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

package greenpages.internal;

import java.util.Collections;
import java.util.List;

import greenpages.Directory;
import greenpages.Listing;

/**
 * Stub implementation of {@link Directory} that allows for simple testing without a database.
 *
 * Uses Spring 2.* component scanning to find this class and create a bean. The name for this bean
 * is extracted from the {@link Component} annotation.
 */

public class DirectoryImpl implements Directory {

    private static final Listing ANDY_WILKINSON = new ImmutableListing(1, "Andy", "Wilkinson", "andy.wilkinson@springsource.com");

    /**
     * {@inheritDoc}
     * 
     * Stub implementation will match only for term '<code>Wilkinson</code>'.
     */
    public List<Listing> search(String term) {
        if (ANDY_WILKINSON.getLastName().equalsIgnoreCase(term)) {
            Listing l = ANDY_WILKINSON;

            return Collections.singletonList(l);
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * Stub implementation will return a {@link Listing} for ID 1.
     */
    public Listing findListing(int id) {
        if (id == ANDY_WILKINSON.getListingNumber()) {
            return ANDY_WILKINSON;
        } else {
            return null;
        }
    }

}
