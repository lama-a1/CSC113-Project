package AirlinesJava;
import java.io.Serializable;
public class Reservation implements Serializable {

	    private String fullName;
	    private String mobile;
	    private String ID;
	    private Flight flight;
	    private int numOfSeats;
	    private double totalPrice;

	    public Reservation(String fullName, String mobile, String ID) {
	        this.fullName = fullName;
	        this.mobile = mobile;
	        this.ID = ID;
	    }

	    public Reservation(Reservation obj) {
	        this.fullName = obj.fullName;
	        this.mobile = obj.mobile;
	        this.ID = obj.ID;
	        this.numOfSeats = obj.numOfSeats;
	        this.flight = obj.flight;
	        this.totalPrice = obj.totalPrice;
	    }

	    // Check in method to book a flight
	    public void checkIn(Flight flight, int numOfSeats) {
	        this.flight = flight;
	        this.numOfSeats = numOfSeats;
	        flight.setAvailableSeats(flight.getAvailableSeats() - numOfSeats);
	        this.totalPrice = flight.calculatePrice(numOfSeats);
	    }

	    public void cancelReservation() {
	        if (flight == null) {
	            System.out.println("This reservation has already been canceled.");
	        } else {
	            flight.setAvailableSeats(flight.getAvailableSeats() + numOfSeats);
	            flight = null;
	            numOfSeats = 0;
	            totalPrice = 0;
	            System.out.println("Reservation has been successfully canceled.");
	        }
	    }

	    @Override
	    public String toString() {
	        return "Full Name: " + fullName + "\nMobile: " + mobile + "\nID: " + ID + "\nFlight: " + (flight != null ? flight.toString() : "No Flight Booked") + "\nNumber of Seats: " + numOfSeats + "\nTotal Price: " + totalPrice;
	    }

	    // Getters and Setters
	    public String getFullName() {
	        return fullName;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getMobile() {
	        return mobile;
	    }

	    public void setMobile(String mobile) {
	        this.mobile = mobile;
	    }

	    public String getID() {
	        return ID;
	    }

	    public void setID(String ID) {
	        this.ID = ID;
	    }

	    public Flight getFlight() {
	        return flight;
	    }

	    public void setFlight(Flight flight) {
	        this.flight = flight;
	    }

	    public int getNumOfSeats() {
	        return numOfSeats;
	    }

	    public void setNumOfSeats(int numOfSeats) {
	        this.numOfSeats = numOfSeats;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }
	    

	}


