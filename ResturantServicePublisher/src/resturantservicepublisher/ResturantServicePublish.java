package resturantservicepublisher;

public interface ResturantServicePublish {
	public int reserveTable(String dateString, int noOfGuests, String name, String telephoneNumber);
	public void addTable(int id, int maxCapacity);
	public String getReservations() ;
}
