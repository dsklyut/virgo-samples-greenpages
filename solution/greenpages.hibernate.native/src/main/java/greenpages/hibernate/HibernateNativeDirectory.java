/*******************************************************************************
 * Copyright (c) 2008, 2010 VMware Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   VMware Inc. - initial contribution
 *******************************************************************************/

package greenpages.hibernate;

import greenpages.Directory;
import greenpages.Listing;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of {@link Directory} that uses JPA for persistence.<p />
 * <p/>
 * This class is marked as {@link Transactional}. The Spring configuration for this module, enables AspectJ weaving for
 * adding transaction demarcation to classes annotated with <code>@Transactional</code>.
 */
@Transactional
@Repository
final class HibernateNativeDirectory implements Directory {

    private final HibernateTemplate hibernateTemplate;

    /**
     * Spring will inject a managed JPA {@link EntityManager} into this field.
     * @param sessionFactory - session factory to use
     */
    @Autowired(required = true)
    HibernateNativeDirectory(SessionFactory sessionFactory) {
        Assert.notNull(sessionFactory, "SessionFactory is required");
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public Listing findListing(int id) {
        return hibernateTemplate.get(HibernateListing.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Listing> search(final String term) {
        return hibernateTemplate.execute(new HibernateCallback<List<Listing>>() {
            @Override
            public List<Listing> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria c = session.createCriteria(Listing.class);
                c.add(Restrictions.ilike("lastName", term));
                return c.list();
            }
        });
    }

}
