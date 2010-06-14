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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import greenpages.Directory;
import greenpages.Listing;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaDirectorySpringContextTests {

    @Autowired
    private Directory directory;

    @Test
    public void search() {
        List<Listing> results = this.directory.search("johnson");
        assertNotNull(results);
        assertEquals(1, results.size());

        Listing listing = results.get(0);
        assertNotNull(listing);
        assertEquals("Johnson", listing.getLastName());
    }
}
