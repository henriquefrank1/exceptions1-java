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

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error, check out must be after check in");
		} else {
			Reservation rs = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(rs);
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out: ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now) || checkOut.before(checkIn)) {
				System.out.println("Error, check out must be after check in");			
			}
			else {
				rs.updateDates(checkIn, checkOut);
				System.out.println(rs);				
			}
		}

		sc.close();

	}

}

//String[] vec = null;
//int position;
//
//try {
//	vec = sc.nextLine().split(" ");
//	position = sc.nextInt();
//	System.out.println(vec[position]);
//} catch (ArrayIndexOutOfBoundsException e) {
//	System.out.println("Digite um índice válido");
//	position = sc.nextInt();
//} catch (InputMismatchException e) {
//	System.out.println("Digite um índice válido (0-:)");
//	sc.nextLine();
//	position = sc.nextInt();
//	System.out.println(e.getMessage());
//} finally {
//	System.out.println("RobertOOOO");
//}
//
//System.out.println(vec[position]);
//System.out.println("End of Program");