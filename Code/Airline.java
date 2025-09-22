package AirlinesJava;

import java.io.* ;
import javax.swing.JOptionPane;

public class Airline implements InputOutputInterface  {

	    private String airlineName;
	    Node headFlight ; 
	    Reservation[] reservations;
	    private int numReservations;
	    int maxFlights =100 ;

	    public Airline(String name, int maxReservations) {
	        this.airlineName = name;
	        headFlight = null ;
	        this.reservations = new Reservation[maxReservations];
	        this.numReservations = 0;
           
	    }
	    
	    public int CountFlight(){
	    	if( headFlight == null ) 
	    	return 0 ; 
	    	int count =0 ; 
	    	Node current = headFlight ; 
	    	while(current != null ){
	    	count++ ; 
	    	current = current.getNext();
	    	}
	    	return count ; 
	    	}
	    
	    public boolean addFlight(Flight flight) {
	        if (CountFlight() < maxFlights) { // Aggregation
	        	Node n = new Node(flight) ; 
	        	n.setNext(headFlight);
	        	headFlight = n ; 
	            return true;
	        }
	        return false;
	    }

	    public boolean deleteFlight(int Num ){
	    	 if( headFlight == null)
	    	 return false ; 
	    	 
	    	if(headFlight.getData().getFlightNo() == Num ) {
	    	Flight temp = headFlight.getData();
	    	if( temp.isAvailable() == false ){
	    	JOptionPane.showMessageDialog(null,"Sorry ! This flight has been fully booked already.");
	    	return false; 
	    	}
	    	headFlight = headFlight.getNext();
         removeReservationsByFlight(Num);
	    	return true ; 
	    	}
	    	Node priv = headFlight ; 
	    	Node current = headFlight.getNext() ;
	    	while(current != null ){
	    	if( current.getData().getFlightNo()== Num ) {
	    	 if(current.getData().isAvailable() == true ){
	    	priv.setNext( current.getNext());
         removeReservationsByFlight(Num);
	    	return true ; }
	    	 else
	    	JOptionPane.showMessageDialog(null,"Sorry ! This flight has been fully booked already.");
	    	return false; 
	    	}
	    	else {
	    	priv = priv.getNext() ; 
	    	current = current.getNext() ; 
	    	}
	    	}
	    	return false ; 
	    	}
         
	    //To remove reservations
	   private void removeReservationsByFlight(int flightNo) {
    for (int i = 0; i < numReservations; ) {
        if (reservations[i] != null &&
            reservations[i].getFlight().getFlightNo() == flightNo) {
            
            //Replace with last element to avoid gaps
            reservations[i] = reservations[numReservations - 1];
            reservations[numReservations - 1] = null;
            numReservations--;
        } else {
            i++; //Only increment if no deletion to avoid skipping
        }
    }
}
  
	    public boolean addReservation(Reservation res) {
	        if (numReservations < reservations.length) { // Composition
	            reservations[numReservations] = new Reservation(res);
	            numReservations++;
	            return true;
	        }
	        return false;
	    }

	    public boolean cancelReservation(String id, int flightNo) {
	        for (int i = 0; i < numReservations; i++) {
	            if (reservations[i].getID().equals(id) &&
	                reservations[i].getFlight().getFlightNo() == flightNo) {
	                reservations[i].cancelReservation();
	                reservations[i] = reservations[numReservations - 1];
	                numReservations--;
	                reservations[numReservations] = null;
	                return true;
	            }
	        }
	        return false;
	    }

	    public Reservation searchReservation(String id, int flightNo) {
	        for (int i = 0; i < numReservations; i++) {
	            if (reservations[i].getID().equals(id) &&
	                reservations[i].getFlight().getFlightNo() == flightNo) {
	                return reservations[i];
	            }
	        }
	        return null;
	    }

	    public Flight searchFlight(int flightNo) {
	    	 if( headFlight == null )
	    		 return null ; 
	    		 
	    		Node current = headFlight ; 
	    		while(current != null )
	    		{
	    		if( current.getData().getFlightNo() == flightNo ) 
	    		return current.getData() ; 
	    		
	    		current = current.getNext();
	    		}

	        return null;
	    }

	    public DomesticFlight[] getAllDomesticFlights() {
	        DomesticFlight[] list = new DomesticFlight[CountFlight()];
	        int j = 0;
	        
	        Node current = headFlight ; 
	        while(current != null ){
	        if( current.getData() instanceof DomesticFlight ) 
	        list[j++] = (DomesticFlight) current.getData() ; 
	        current = current.getNext() ; 
	        }
	        return list;
	    }

	    public InternationalFlight[] getAllInternationalFlights() {
	        InternationalFlight[] list = new InternationalFlight[CountFlight()];
	        int j = 0;
	        
	        Node current = headFlight ; 
	        while(current != null ){
	        if( current.getData() instanceof InternationalFlight ) 
	        list[j++] = (InternationalFlight) current.getData() ; 
	        current = current.getNext() ; 
	        }
	        return list;
	    }

	    public Flight[] getAllAvailableFlights() {
	        Flight[] list = new Flight[CountFlight()];
	        int j = 0;
	        
	        Node current = headFlight ;
	        while(current != null ){
	        	if( current.getData().isAvailable() )
	        		list[j++] = current.getData() ; 
	        		current = current.getNext() ;
	        }
	        
	        return list;
	    }
	    
	    // Added FILES section
	    public void saveAllInformation(){
       
	    	 try{
	    	File out = new File(fileOutput);
	    	FileOutputStream FO = new FileOutputStream (out);
	    	ObjectOutputStream OOS = new ObjectOutputStream (FO);
	    	
	    	OOS.writeObject( headFlight ) ; 
	    	OOS.close(); 
	    	
	    	File out2 = new File("Reservations.dat");
	    	FileOutputStream FO2 = new FileOutputStream (out2);
	    	ObjectOutputStream OOS2 = new ObjectOutputStream (FO2);
	    	
	    	OOS2.writeInt(numReservations);
	    	OOS2.writeObject( reservations ) ; // write array all at once
	    	OOS2.close(); 
	    	 } catch( IOException e){
	    	 System.out.println(e.toString());
	    	 } 
	    	}

	       
	    public void readAllData(){
	    	 try{
    
	    	File file1 = new File(fileOutput);
	    	FileInputStream FI = new FileInputStream(file1); 
	    	ObjectInputStream OIS= new ObjectInputStream(FI) ;

	    	headFlight = (Node) OIS.readObject(); 
	    	OIS.close() ; 
	    	File file2 = new File("Reservations.dat");
	    	FileInputStream FI2 = new FileInputStream(file2); 
	    	ObjectInputStream OIS2= new ObjectInputStream(FI2) ;
           
	    	numReservations = OIS2.readInt() ; 
	    	reservations = (Reservation[]) OIS2.readObject(); 
	    	OIS2.close() ;
         
	    	} catch( ClassNotFoundException ex){ System.out.println(ex.toString()); }
	    	 
	    	catch( IOException e){ System.out.println(e.toString());} 
	    	
	    	}
                          
                 	    
	}