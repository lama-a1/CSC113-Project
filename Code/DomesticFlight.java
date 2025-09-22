package AirlinesJava;

public class DomesticFlight extends Flight{
    private String region;


    public DomesticFlight(String region, int flightNo, int availableSeats, double basePrice) {
        super(flightNo, availableSeats, basePrice);
        this.region = region;
    }

    public double calculatePrice(int numSeats) {
        return basePrice * numSeats;
    }

    
    public String toString() {
        return super.toString() + ", Region: " + region;
    }
}


