package resturantservicepublisher;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class Table {
	 private int tableId;
	    private int maxCapacity;

	    private Map<LocalDateTime, Reservation> reservations;

	    Table(int tableId, int noOfGuests) {
	        this.tableId = tableId;
	        this.maxCapacity = noOfGuests;
	        this.reservations = new HashMap<>();
	    }

	    boolean isAvailable(LocalDateTime arivalDateHour) {
	        return !reservations.containsKey(arivalDateHour);
	    }

	    void reserve(LocalDateTime arivalDateHour, int numOfGuests, String custName, String tel) {
	    	Reservation res = new Reservation(numOfGuests, custName);
	        reservations.put(arivalDateHour, res);
	    }

	    int getnoOfGuests() {
	        return maxCapacity;
	    }

	    int gettableId() {
	        return tableId;
	    }

	    
	    public String getTableInformation() {
	    	StringBuilder sb = new StringBuilder();
	    	sb.append(String.format("Table: %d - (maximum capacity : %d)\n", tableId, maxCapacity));
	    	reservations.forEach((k, v) -> sb.append(String.format("\tDate: %s/%s/ %s: %s\n",k.getDayOfMonth(), k.getMonth(),k.getHour(), v.getReservationDetails())));
	    	return sb.toString();
	    }
}
