package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
	
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now)|| checkOut.before(now)) {
			return "ERROR IN RESERVATION: RESERVATION DATES FOR UPDATES MUST BE FUTURE DATES!";
		}
		if (!checkOut.after(checkIn)) {
			return "ERROR IN RESERVATION: CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE!";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "ROOM: " + 
				roomNumber +
				", CHECK-IN: " +
				sdf.format(checkIn) +
				", CHECK-OUT" +
				sdf.format(checkOut) +
				", " +
				duration() +
				"NIGHTS";
	}
	
}
