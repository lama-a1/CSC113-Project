package AirlinesJava;

import java.io.Serializable;
public abstract class Flight implements Serializable {
	 protected int flightNo;
	 protected int availableSeats;
	 protected double basePrice;
	 
	 
	 	public Flight() {};
	    public Flight(int flightNo, int availableSeats, double basePrice) { 
	    this.flightNo = flightNo;
        this.availableSeats = availableSeats;
        this.basePrice = basePrice ;
        }
	    
	    public abstract double calculatePrice(int numSeats) ;

	    public void bookSeats(int numSeats) { availableSeats -= numSeats; }

	    public void cancelSeats(int numSeats) { availableSeats += numSeats; }
	    
	    public String toString() { return "Flight Number: " + flightNo + ", Available Seats: " + availableSeats; }
	    
	    public boolean isAvailable() {
		    return availableSeats > 0; // Returns true if seats are available, otherwise false
		}
	    
       
	    //Setters and getters 
		public int getFlightNo() {
			return flightNo;
		}

		public void setFlightNo(int flightNo) {
			this.flightNo = flightNo;
		}

		public int getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}

		public double getbasePrice() {
			return basePrice;
		}

		public void setbasePrice(double basePrice) {
			this.basePrice = basePrice;
		}
	    
	    
}
