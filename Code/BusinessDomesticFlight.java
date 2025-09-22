package AirlinesJava;

public class BusinessDomesticFlight extends DomesticFlight {
	private boolean priorityBoarding;
    private boolean loungeAccess;
    private boolean flexibleRescheduling;
    private static final double BUSINESS_FEE = 120; //Extra fee for business perks

    public BusinessDomesticFlight(String region, int flightNo, int availableSeats, double basePrice, 
        boolean priorityBoarding, boolean loungeAccess, boolean flexibleRescheduling) {
        super(region, flightNo, availableSeats, basePrice);
        this.priorityBoarding = priorityBoarding;
        this.loungeAccess = loungeAccess;
        this.flexibleRescheduling = flexibleRescheduling;
    }

    public double calculatePrice(int numSeats) {
        double total = super.calculatePrice(numSeats);
        
        //Business class perks increase ticket price
        if (priorityBoarding)
        	total += 20 * numSeats;
        if (loungeAccess) 
        	total += 50 * numSeats;
        if (flexibleRescheduling)
        	total += 80 * numSeats;

        return total + (BUSINESS_FEE * numSeats);
    }

    public String toString() {
        return super.toString() + ", Business Perks: " +
               (priorityBoarding ? "Priority Boarding, " : "") +
               (loungeAccess ? "Lounge Access, " : "") +
               (flexibleRescheduling ? "Flexible Rescheduling" : "Standard Ticket");
    }
}
