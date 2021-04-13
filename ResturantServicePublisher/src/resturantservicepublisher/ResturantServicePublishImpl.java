package resturantservicepublisher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ResturantServicePublishImpl implements ResturantServicePublish {
    private List<Table> tablesList = new ArrayList<>();;

	@Override
	public int reserveTable(String dateString, int noOfGuests, String name, String telephoneNumber) {
		LocalDateTime arivalDateTime = toDateTime(dateString);
        for (Table table : tablesList) {
            if ( table.isAvailable(arivalDateTime)&& table.getnoOfGuests() >= noOfGuests) {
                table.reserve(arivalDateTime, noOfGuests, name, telephoneNumber);
                return table.gettableId();
            }
        }
        return -1;
	}

	@Override
	public void addTable(int id, int maxCapacity) {
		Table table = new Table(id, maxCapacity);
        tablesList.add(table);
        System.out.println("Table"+id+" was added with a max capacity of "+maxCapacity);
	}

	
	private LocalDateTime toDateTime(String dateString) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH");
	        return LocalDateTime.parse(dateString, formatter);
	}
	
	public String getReservations() {
        String st = "\nRESTAURANT RESERVATIONS\n";
        for (Table t : tablesList) {
            st = st + t.getTableInformation();
        }
        return st;
    }


}
