package AirlinesJava;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.* ; 
import java.util.* ; 

public class AdminFrame extends JFrame implements ActionListener {
 JButton jBDeleteFlight; 
 JButton jBBack; 
 JButton jBExit; 
 JButton jBView;
  
 JLabel jLTitle; 
 JLabel jL2;
  
 JPanel jPanel1;
  
 JTextArea TextArea1; 
 JTextField jTextField1; 
 Container contentPane ; 
 
  
 // constructor
 public AdminFrame(){
  contentPane = getContentPane( ); 
  contentPane.setLayout(null); 
  setTitle ("Flight Reservation System");
 setLocation (200, 150); 
 setResizable (false); 
 setSize(700, 500); 
 this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  
// jLTitle; 
jLTitle = new JLabel("Admin menu : "); 
jLTitle.setFont(new Font("Segoe UI", Font.ITALIC, 26));  
jLTitle. setBounds(50 , 20 , 500 , 50 ) ; 
contentPane.add(jLTitle ); 

// jL2; 
jL2 = new JLabel("Enter Flight number: "); 
jL2. setBounds(50 , 90 , 150 , 20 ) ; 
contentPane.add(jL2 );
 
// jTextField1; 
jTextField1 = new JTextField(); 
jTextField1.setColumns(10); 
jTextField1. setBounds(50 , 130 , 120 , 20 ) ; 
contentPane.add(jTextField1 );
 
// jBDeleteFlight; 
jBDeleteFlight = new JButton("Delete Flight"); 
jBDeleteFlight. setBounds(50 , 170 , 120 , 30 ) ; 
contentPane.add(jBDeleteFlight); 
jBDeleteFlight.addActionListener(this); 

//JButton jBBack; 
jBBack = new JButton("Back"); 
jBBack. setBounds(50 , 400 , 70 , 30 ) ; 
contentPane.add(jBBack ); 
jBBack.addActionListener(this); 

//JButton jBExit; 
jBExit = new JButton("Exit"); 
jBExit. setBounds(130 , 400 , 70 , 30 ) ; 
contentPane.add(jBExit); 
jBExit.addActionListener(this); 

//JPanel jPanel1; 
jPanel1 = new JPanel(); 
jPanel1.setBorder(BorderFactory.createTitledBorder("View Reservation")); 
jPanel1.setBounds(250 , 20 , 350 , 420 ) ; 
jPanel1.setLayout(null);
 
// jTextArea1; 
TextArea1 = new JTextArea(20,30); 
TextArea1.setBorder(BorderFactory.createLineBorder(Color.RED)); 


JScrollPane scrollPane = new JScrollPane(TextArea1);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollPane.setBounds(25, 25, 300, 330);
jPanel1.add(scrollPane);  

// jBView; 
jBView = new JButton("View all reservations"); 
jBView.setBounds(80 , 365 , 180 , 30 ) ; 
jPanel1.add(jBView); 
jBView.addActionListener(this);
 
contentPane.add(jPanel1 ); 
}

public void actionPerformed(ActionEvent event) {
 if( event.getSource().equals((JButton) jBDeleteFlight)){
  String strNum = jTextField1.getText() ; 
  int num ; 
  try{
   num = Integer.parseInt(strNum) ; 
   }
   catch(NumberFormatException ex ){
    JOptionPane.showMessageDialog(this , "Invalid Flight number" ); 
    return ; 
    } 
    
    if( TestAirline.airline.deleteFlight(num)){
    JOptionPane.showMessageDialog(this , "Flight is deleted successfully"); 
    } 
    else 
    JOptionPane.showMessageDialog(this , "Flight can't be deleted"); 
    jTextField1.setText("0"); 
    }
    //------------------------------------------
    else
    if( event.getSource().equals((JButton) jBBack)){ 
     this.setVisible(false); 
     } 
     else 
     if( event.getSource().equals((JButton) jBExit)){ 
     TestAirline.airline.saveAllInformation(); 
     JOptionPane.showMessageDialog(this, "All data saved. Goodbye!"); 
     System.exit(0); 
     } 
     //------------------------------------------
     else 
     if( event.getSource().equals((JButton) jBView)){ 
     TextArea1.setText(""); 
     Reservation[] list = TestAirline.airline.reservations ; 
     int count = 0; 
     for( int i = 0 ; i < list.length ; i++) 
     if( list[i] != null ){
     TextArea1.append(list[i].toString() + "\n"); 
     TextArea1.append("-------------------------\n"); count++; 
     } 
     if( count == 0 ){ 
     TextArea1.append("       -------------- No reservations found --------------\n"); 
     } 
    } 
    
   }// End actionPerformed 
   }//End class
   
