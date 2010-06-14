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

import greenpages.Listing;

/**
 * Basic implementation of {@link Listing} that is configured as a persistent type in JPA.
 */
public class JpaListing implements Listing {

    private Integer listingNumber;

    private String firstName;

    private String lastName;

    private String emailAddress;

    public Integer getListingNumber() {
        return listingNumber;
    }

    public void setListingNumber(Integer listingNumber) {
        this.listingNumber = listingNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
