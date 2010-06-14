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

package greenpages.jpa;

import greenpages.Directory;
import greenpages.Listing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link Directory} that uses JPA for persistence.<p />
 * 
 * This class is marked as {@link Transactional}. The Spring configuration for this module, enables AspectJ weaving for
 * adding transaction demarcation to classes annotated with <code>@Transactional</code>.
 */
@Transactional
@Repository
final class JpaDirectory implements Directory {

    private static final String SEARCH_QUERY = "select l from Listing l where upper(l.lastName) like :term";

    /**
     * Spring will inject a managed JPA {@link EntityManager} into this field.
     */
    @PersistenceContext
    private EntityManager em;

    public Listing findListing(int id) {
        return em.find(JpaListing.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Listing> search(String term) {
        return em.createQuery(SEARCH_QUERY).setParameter("term", "%" + term.toUpperCase() + "%").getResultList();
    }

}
