package AirlinesJava;

public class InternationalFlight extends Flight {
	  private String destinationCountry;
	    private boolean visaRequired;

	    public InternationalFlight(String destinationCountry, boolean visaRequired, int flightNo, int availableSeats, double basePrice) {
	        super(flightNo, availableSeats, basePrice);
	        this.destinationCountry = destinationCountry;
	        this.visaRequired = visaRequired;
	    }

	    public double calculatePrice(int numSeats) {
	        double total = basePrice * numSeats;
	        if (visaRequired) total += 100 * numSeats; // Visa processing fee per seat
	        return total;
	    }

	    public String toString() {
	        return super.toString() + ", Destination: " + destinationCountry + ", Visa Required: " + visaRequired;
	    }
}
