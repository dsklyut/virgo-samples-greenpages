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

package greenpages.jpa.hibernate;

import greenpages.Listing;

import javax.persistence.*;

/**
 * Basic implementation of {@link Listing} that is configured as a persistent type in JPA.
 */
@Entity(name = "Listing")
@Table(name = "LISTING")
public class JpaListing implements Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "LISTING_NUMBER")
    private Integer listingNumber;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL_ADDRESS")
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
