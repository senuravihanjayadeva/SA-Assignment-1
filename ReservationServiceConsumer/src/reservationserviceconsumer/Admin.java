package reservationserviceconsumer;

import resturantservicepublisher.ResturantServicePublish;
//this is the admin class model
public class Admin {
	ResturantServicePublish resturantServicePublish;

	//constructor taking the ResturantServicePublish reference
	public Admin(ResturantServicePublish resturantServicePublish) {
		super();
		this.resturantServicePublish = resturantServicePublish;
	}
	
	public void getallReservations() {
		resturantServicePublish.getallReservations();
	}
	public void getReservationsByCustName() {
		resturantServicePublish.getReservationsByCustName();
	}
	public void deleteReservation() {
		resturantServicePublish.deleteReservation();
	}
	public void getPriorityNormal() {
		resturantServicePublish.getPriorityNormal();
	}
}
