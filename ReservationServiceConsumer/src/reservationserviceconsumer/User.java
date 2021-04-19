package reservationserviceconsumer;

import resturantservicepublisher.ResturantServicePublish;

public class User {
	ResturantServicePublish resturantServicePublish;

	public User(ResturantServicePublish resturantServicePublish) {
		super();
		this.resturantServicePublish = resturantServicePublish;
	}
	
	public void reserve() {
		resturantServicePublish.insertReservation();
	}
}
