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

package greenpages;

import java.util.List;

/**
 * Main business interface for the GreenPages application.
 * 
 * <p>
 * Using this interface you can {@link #search(String) search} the directory for a {@link Listing} and you can access a
 * <code>Listing</code> {@link #findListing(int) by ID}.
 * 
 * @see Listing
 */
public interface Directory {

    /**
     * Searches the directory for all {@link Listing Listings} that match the supplied term. Matching is done against
     * the {@link Listing#getLastName() last name} of all known <code>Listings</code>.
     * 
     * @param term the search criteria.
     * @return the search results or an empty {@link List} if no matches are found.
     */
    List<Listing> search(String term);

    /**
     * Finds the {@link Listing} with the supplied ID.
     * 
     * @param id the ID of the <code>Listing</code>
     * @return the <code>Listing</code> or <code>null</code> if no match is found.
     */
    Listing findListing(int id);
}
