package reservationserviceconsumer;

import resturantservicepublisher.ResturantServicePublish;

// This is the user model
public class User {
	ResturantServicePublish resturantServicePublish;

	//constructor taking the ResturantServicePublish reference
	public User(ResturantServicePublish resturantServicePublish) {
		super();
		this.resturantServicePublish = resturantServicePublish;
	}
	
	public void reserve() {
		resturantServicePublish.insertReservation();
	}
}
