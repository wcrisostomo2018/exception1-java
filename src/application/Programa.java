package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room Number: ");
			int number = sc.nextInt();
			System.out.println("Checkin date (dd/mm/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Checkout date (dd/mm/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number,checkin,checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Checkin date (dd/mm/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.println("Checkout date (dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e ) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in Reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();
	}

}
