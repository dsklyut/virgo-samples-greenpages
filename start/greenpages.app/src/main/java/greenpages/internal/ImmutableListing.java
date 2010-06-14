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

import greenpages.Listing;

final class ImmutableListing implements Listing {

	private final Integer listingNumber;
	
	private final String  firstName;
	
	private final String lastName;
	
	private final String  emailAddress;
	
	public ImmutableListing(int listingNumber, String firstName,String lastName, String emailAddress) {
		
		this.listingNumber = listingNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}
	
	public Integer getListingNumber() {
		return listingNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
}
