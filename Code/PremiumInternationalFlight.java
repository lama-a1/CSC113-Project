package AirlinesJava;

public class PremiumInternationalFlight extends InternationalFlight {
	   private int luxurySeatFee;

	    public PremiumInternationalFlight(String destinationCountry, boolean visaRequired, int flightNo, int availableSeats, double basePrice, int luxurySeatFee) {
	        super(destinationCountry, visaRequired, flightNo, availableSeats, basePrice);
	        this.luxurySeatFee = luxurySeatFee;
	    }

	    public double calculatePrice(int numSeats) {
	        return super.calculatePrice(numSeats) + (luxurySeatFee * numSeats);
	    }

	    public String toString() {
	        return super.toString() + ", Luxury Seat Fee: " + luxurySeatFee +" SAR";
	    }
}
