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

package greenpages.web;

import greenpages.Directory;
import greenpages.Listing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class for GreenPages web application.<p/>
 * 
 * This class is configured using Spring 2.5-style MVC annotations. Documentation for this feature can be found <a
 * href="http://static.springframework.org/spring/docs/2.5.x/reference/mvc.html#mvc-annotation">here</a>.<p/>
 * 
 * The use of {@link Controller} makes this class eligible for autodetection by &lt;context:component-scan/&gt; in the
 * context configuration.
 */
@Controller
public class GreenPagesController {

    /**
     * This field is injected automatically by Spring. For this injection to be satisfied, the greenpages.web module
     * must either declare a bean of type {@link Directory} or it must import a <code>Directory</code> from OSGi.
     */
	@Autowired
	private Directory directory;   


    @RequestMapping("/home.htm")
    public void home() {
    }

    @RequestMapping("/search.htm")
    public List<Listing> search(@RequestParam("query") String query) {
        return this.directory.search(query);
    }

    @RequestMapping("/entry.htm")
    public Listing entry(@RequestParam("id") int id) {
        return this.directory.findListing(id);
    }
}
