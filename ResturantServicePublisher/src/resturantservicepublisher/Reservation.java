package resturantservicepublisher;

public class Reservation {
	 private String customerName;
	    private int noOfGuests;

		Reservation(int noOfGuests, String customerName) {
	        this.customerName = customerName;
	        this.noOfGuests = noOfGuests;
	    }

	    public String getReservationDetails() {
	    	String st = "Reserved for "+noOfGuests+"(Reserved by : "+customerName+")";
	        return st;
	   }
}
