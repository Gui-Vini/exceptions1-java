package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("ROOM NUMBER: ");
		int number = sc.nextInt();
		System.out.print("CHECK-IN DATE (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("CHECK-OUT DATE (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("ERROR IN RESERVATION: CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE!");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("RESERVATION: " + reservation);
			System.out.println();
			System.out.println("ENTER DATA TO UPDATE THE RESERVATION: ");
			System.out.print("CHECK-IN DATE (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CHECK-OUT DATE (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("ERROR IN RESERVATION: " + error);
			}
			else {
				System.out.println("RESERVATION: " + reservation); 
			}
		
			sc.close();
		
		}

	}
}


