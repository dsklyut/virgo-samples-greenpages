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

final class JpaDirectory implements Directory {

    private static final String SEARCH_QUERY = "select l from Listing l where upper(l.lastName) like :term";

    public Listing findListing(int id) {
    	return null;
    }

    public List<Listing> search(String term) {
    	return null;
    }
}
