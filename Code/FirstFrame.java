package AirlinesJava;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.* ; 
import java.util.* ; 
import javax.swing.ImageIcon;

public class FirstFrame extends JFrame implements ActionListener {
 JButton jBCustomer; 
 JButton jBAdmin; 
 JButton jBExit; 
 JLabel jLtitle; 
 JLabel jLImage; 
 Container contentPane ;
  
 // constructor
public FirstFrame(){
contentPane = getContentPane( ); 
contentPane.setLayout(null); 
setTitle ("Flight Reservation System"); 
setLocation (200, 150); 
setResizable (true); 
setSize(1200, 800); 

this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
this.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        int confirm = JOptionPane.showConfirmDialog(
            FirstFrame.this,
            "Are you sure you want to exit?",
            "Exit Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            TestAirline.airline.saveAllInformation();
            JOptionPane.showMessageDialog(null, "We hope you enjoyed the experience. Goodbye!");
            System.exit(0);
        }
    }
});

//Loading image using resource path
ImageIcon airplaneIcon = null;
airplaneIcon = new ImageIcon(getClass().getResource("/AirlinesJava/airplane.jpg"));

jLImage = new JLabel(airplaneIcon);
jLImage.setBounds(400 , 150 , 750 , 500 ) ; 
contentPane.add(jLImage);
// Ensure image label is *added last* so it stays behind other components
contentPane.setComponentZOrder(jLImage, contentPane.getComponentCount() - 1);

 
jLtitle = new JLabel("Welcome to Saudia Airlines : "); 
jLtitle.setFont(new java.awt.Font ("Segoe UI", 1, 40)); 
jLtitle. setBounds(300 , 20 , 700 , 70 ) ; 
contentPane.add(jLtitle);
 
jBCustomer = new JButton("Customer");
jBCustomer.setFont(new java.awt.Font ("Segoe UI", 0, 20)); 
jBCustomer. setBounds(100 , 180 , 180 , 80 ) ; 
contentPane.add(jBCustomer ); 
jBCustomer.addActionListener(this);
 
jBAdmin = new JButton("Admin");
jBAdmin.setFont(new java.awt.Font ("Segoe UI", 0, 20)); 
jBAdmin. setBounds(100 , 300 , 180 , 80 ) ; 
contentPane.add(jBAdmin ); 
jBAdmin.addActionListener(this); 

jBExit = new JButton("Exit");
jBExit.setFont(new java.awt.Font ("Segoe UI", 0, 20)); 
jBExit. setBounds(100 , 420 , 180 , 80 ) ; 
contentPane.add(jBExit); 
jBExit.addActionListener(this); 
}// end constructor

public void actionPerformed(ActionEvent event) {
 if( event.getSource().equals(jBCustomer)){ 
 CustomerFrame CF = new CustomerFrame() ; 
 CF.setVisible(true); 
 } 
 else 
  if( event.getSource().equals( jBAdmin)){ 
  String pass = "2005" ; 
  String str = JOptionPane.showInputDialog("Please enter passWord: ") ; 
  
  if( str.equals(pass)) {
   AdminFrame AF = new AdminFrame() ; 
   AF.setVisible(true);
   }
 else 
 JOptionPane.showMessageDialog(this, "Invalid passWord"); 
 } 
 else 
 if( event.getSource().equals( jBExit)){    
 TestAirline.airline.saveAllInformation(); 
 JOptionPane.showMessageDialog(this, "We hope you enjoyed the experience. Goodbye!"); 
 System.exit(0); 
 }
 
  } //End actionPerformed 

 }//End class


