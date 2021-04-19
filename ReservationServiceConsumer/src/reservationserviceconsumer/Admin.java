package reservationserviceconsumer;

import resturantservicepublisher.ResturantServicePublish;

public class Admin {
	ResturantServicePublish resturantServicePublish;

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
