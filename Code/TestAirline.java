package AirlinesJava;

import java.io.File;
import java.util.Scanner;

		public class TestAirline {
             
		    static Airline airline = new Airline("Saudia", 1000);         
          public static boolean shouldDeleteFiles = false;
                    
		   public static void main(String[] args) {
         
      		  do{ 
               TestAirline.shouldDeleteFiles = true;
               TestAirline.deleteTempFiles();	 
                          		        
		    	  File file1 = new File("Flights.dat");
	           File file2 = new File("Reservations.dat");                    
	               if( file1.exists() && file2.exists() ){
	                     airline.readAllData();                                          
                        }                        
	               else{
		        
		    	DomesticFlight DF1 = new DomesticFlight ("Riyadh" , 101 , 250 , 800);
				DomesticFlight DF2 = new DomesticFlight ("Jeddah" , 102 , 200 , 650);
				DomesticFlight DF3 = new DomesticFlight ("Dammam" , 103 , 300 , 600);
				
				
			    InternationalFlight IF1 = new InternationalFlight("Rome" , true , 201 , 400 , 3400);
			    InternationalFlight IF2 = new InternationalFlight("Tokyo" , true , 202 , 300 , 4000);
			    InternationalFlight IF3 = new InternationalFlight("Tbilsi" , false , 203 , 400 , 2800);
			    
			    
			    BusinessDomesticFlight BIF1 = new BusinessDomesticFlight("Abha", 104, 150, 1000, true, true, true );
			    BusinessDomesticFlight BIF2 = new BusinessDomesticFlight("AL Madinah", 105, 100, 800, true, true, true );
		        
			        
			    
			    PremiumInternationalFlight PIF1 = new  PremiumInternationalFlight ("New York" , true , 204 , 30 , 12000 , 8000);
			    PremiumInternationalFlight PIF2 = new  PremiumInternationalFlight ("Paris" , true , 205 , 20 , 16000 , 9000);
		        

		        airline.addFlight(DF1);
			    airline.addFlight(DF2);
			    airline.addFlight(DF3);
			    
			    airline.addFlight(IF1);
			    airline.addFlight(IF2);
			    airline.addFlight(IF3);
			    
			    airline.addFlight(BIF1); 
			    airline.addFlight(BIF2); 
			    
			    airline.addFlight(PIF1);
			    airline.addFlight(PIF2);
		        
		        FirstFrame frame = new FirstFrame();
		        frame.setVisible(true) ; //Set frame visible             
		    } }while(shouldDeleteFiles =false) ;
		}
	
             public static void deleteTempFiles() { //To delete .dat files after the first  run
    if (shouldDeleteFiles) {
        File file1 = new File("flights.dat");
        File file2 = new File("reservations.dat");

        if (file1.exists()) file1.delete();
        if (file2.exists()) file2.delete();
    }

	}
 }
 