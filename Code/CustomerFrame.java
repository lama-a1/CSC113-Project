package AirlinesJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerFrame extends JFrame implements ActionListener {
    ButtonGroup buttonGroup = new ButtonGroup();
    JButton bookButton, cancelButton, searchButton, viewButton, backButton, exitButton;
    JComboBox<String> comboBox;
    JLabel jLabelTitle, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
    JPanel panel1, panel2;
    JRadioButton radioDomestic, radioInternational, radioBusiness, radioPremium, radioAvailable;
    JTextArea textArea;
    JTextField flightNoField, userIdField, nameField, mobileField;
    Container contentPane;

    public CustomerFrame() {
    contentPane = getContentPane();
    contentPane.setLayout(null);
    setTitle("Flight Reservation System");
    setLocation(200, 100);
    setResizable(false);
    setSize(800, 550);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    // Title label
    jLabelTitle = new JLabel("Customer Menu:");
    jLabelTitle.setFont(new Font("Segoe UI", Font.ITALIC, 26));
    jLabelTitle.setBounds(50, 20, 500, 50);
    contentPane.add(jLabelTitle);

    // Panel 1  (Reservation)
    panel1 = new JPanel();
    panel1.setBorder(BorderFactory.createTitledBorder("Flight Reservation"));
    panel1.setBounds(20, 80, 350, 370);
    panel1.setLayout(null);
    contentPane.add(panel1);

    // Panel 2  (View Flights)
    panel2 = new JPanel();
    panel2.setBorder(BorderFactory.createTitledBorder("View Flights"));
    panel2.setBounds(400, 80, 350, 420);
    panel2.setLayout(null);
    contentPane.add(panel2);

    //Reservation panel components
    jLabel2 = new JLabel("Flight Number:");
    jLabel2.setBounds(20, 20, 150, 20);
    panel1.add(jLabel2);

    jLabel3 = new JLabel("Passenger ID:");
    jLabel3.setBounds(20, 50, 150, 20);
    panel1.add(jLabel3);

    jLabel4 = new JLabel("Full Name:");
    jLabel4.setBounds(20, 80, 150, 20);
    panel1.add(jLabel4);

    jLabel5 = new JLabel("Mobile Number:");
    jLabel5.setBounds(20, 110, 150, 20);
    panel1.add(jLabel5);

    jLabel6 = new JLabel("Seats:");
    jLabel6.setBounds(20, 140, 150, 20);
    panel1.add(jLabel6);

    flightNoField = new JTextField();
    flightNoField.setBounds(180, 20, 120, 20);
    panel1.add(flightNoField);

    userIdField = new JTextField();
    userIdField.setBounds(180, 50, 120, 20);
    panel1.add(userIdField);

    nameField = new JTextField();
    nameField.setBounds(180, 80, 120, 20);
    panel1.add(nameField);

    mobileField = new JTextField();
    mobileField.setBounds(180, 110, 120, 20);
    panel1.add(mobileField);

    String[] seats = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    comboBox = new JComboBox<>(seats);
    comboBox.setBounds(180, 140, 100, 20);
    panel1.add(comboBox);

    bookButton = new JButton("Book Ticket");
    bookButton.setBounds(20, 170, 150, 30);
    panel1.add(bookButton);
    bookButton.addActionListener(this);

    cancelButton = new JButton("Cancel Reservation");
    cancelButton.setBounds(20, 210, 150, 30);
    panel1.add(cancelButton);
    cancelButton.addActionListener(this);

    searchButton = new JButton("Search Reservation");
    searchButton.setBounds(20, 250, 150, 30);
    panel1.add(searchButton);
    searchButton.addActionListener(this);

    //Back and Exit buttons
    backButton = new JButton("Back");
    backButton.setBounds(20, 460, 100, 30);
    contentPane.add(backButton);
    backButton.addActionListener(this);

    exitButton = new JButton("Exit");
    exitButton.setBounds(130, 460, 100, 30);
    contentPane.add(exitButton);
    exitButton.addActionListener(this);

    // View flights panel components
    textArea = new JTextArea(20, 30);
    textArea.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(25, 25, 300, 300);
    panel2.add(scrollPane);

    //Flight type radio buttons
    radioDomestic = new JRadioButton("Domestic Flight");
    radioDomestic.setBounds(25, 330, 150, 30);
    panel2.add(radioDomestic);
    radioDomestic.addActionListener(this);

    radioInternational = new JRadioButton("International Flight");
    radioInternational.setBounds(25, 370, 150, 30);
    panel2.add(radioInternational);
    radioInternational.addActionListener(this);

    radioBusiness = new JRadioButton("Business Domestic");
    radioBusiness.setBounds(175, 330, 150, 30);
    panel2.add(radioBusiness);
    radioBusiness.addActionListener(this);

    radioPremium = new JRadioButton("Premium International");
    radioPremium.setBounds(175, 370, 150, 30);
    panel2.add(radioPremium);
    radioPremium.addActionListener(this);

    radioAvailable = new JRadioButton("Available Flights");
    radioAvailable.setBounds(25, 410, 150, 30);
    panel2.add(radioAvailable);
    radioAvailable.addActionListener(this);

    //Add to button group
    buttonGroup.add(radioDomestic);
    buttonGroup.add(radioInternational);
    buttonGroup.add(radioBusiness);
    buttonGroup.add(radioPremium);
    buttonGroup.add(radioAvailable);
}
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(bookButton)) {
            //Book ticket 
            int flightNo;
            try {
                flightNo = Integer.parseInt(flightNoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Flight number must be digits only");
                return;
            }

            Flight flight = TestAirline.airline.searchFlight(flightNo);
            if (flight == null || !flight.isAvailable()) {
                JOptionPane.showMessageDialog(this, "Flight not available");
                return;
            }

            String id = userIdField.getText();
            String name = nameField.getText();
            String mobile;
            try {
                mobile = mobileField.getText();
                if (mobile.length() != 10 || !mobile.startsWith("05")) {
                    throw new invalidMobileNum("Mobile must start with 05 and be 10 digits");
                }
                Long.parseLong(mobile);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Mobile must be digits only");
                return;
            } catch (invalidMobileNum ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }

            int seats = comboBox.getSelectedIndex() + 1;
            Reservation res = new Reservation(name, mobile, id);
            res.checkIn(flight, seats);
            
            if (TestAirline.airline.addReservation(res)) {
                JOptionPane.showMessageDialog(this, "Booking successful!\n" + res.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Booking failed. There is no space available");
            }

            clearFields();
        }
        else if (event.getSource().equals(cancelButton)) {
            //Cancel reservation 
            int flightNo;
            try {
                flightNo = Integer.parseInt(flightNoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Flight number must be digits only");
                return;
            }

            String id = userIdField.getText();
            if (TestAirline.airline.cancelReservation(id, flightNo)) {
                JOptionPane.showMessageDialog(this, "Reservation cancelled");
            } else {
                JOptionPane.showMessageDialog(this, "Reservation not found");
            }

            clearFields();
        }
        else if (event.getSource().equals(searchButton)) {
            //Search reservation             
            int flightNo;
            try {
                flightNo = Integer.parseInt(flightNoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Flight number must be digits only");
                return;
            }

            String id = userIdField.getText();
            Reservation res = TestAirline.airline.searchReservation(id, flightNo);
            if (res != null) {
                JOptionPane.showMessageDialog(this, res.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Reservation not found");
            }
        }
        else if (event.getSource().equals(backButton)) {
            this.setVisible(false);
        }
        else if (event.getSource().equals(exitButton)) {
            TestAirline.airline.saveAllInformation();
            JOptionPane.showMessageDialog(this, "All data saved. Goodbye!");
            System.exit(0);
        }
        else if (event.getSource().equals(radioDomestic) && radioDomestic.isSelected()) {
            textArea.setText("");
            DomesticFlight[] flights = TestAirline.airline.getAllDomesticFlights();
            for (int i = 0; i < flights.length; i++) {
                if (flights[i] != null && !(flights[i] instanceof BusinessDomesticFlight)) {
                    textArea.append(flights[i].toString() + "\n");
                }
            }
        }
        else if (event.getSource().equals(radioInternational) && radioInternational.isSelected()) {
            textArea.setText("");
            InternationalFlight[] flights = TestAirline.airline.getAllInternationalFlights();
            for (int i = 0; i < flights.length; i++) {
                if (flights[i] != null && !(flights[i] instanceof PremiumInternationalFlight)) {
                    textArea.append(flights[i].toString() + "\n");
                }
            }
        }
        else if (event.getSource().equals(radioBusiness) && radioBusiness.isSelected()) {
            textArea.setText("");
            DomesticFlight[] flights = TestAirline.airline.getAllDomesticFlights();
            for (int i = 0; i < flights.length; i++) {
                if (flights[i] instanceof BusinessDomesticFlight) {
                    textArea.append(flights[i].toString() + "\n");
                }
            }
        }
        else if (event.getSource().equals(radioPremium) && radioPremium.isSelected()) {
            textArea.setText("");
            InternationalFlight[] flights = TestAirline.airline.getAllInternationalFlights();
            for (int i = 0; i < flights.length; i++) {
                if (flights[i] instanceof PremiumInternationalFlight) {
                    textArea.append(flights[i].toString() + "\n");
                }
            }
        }
        else if (event.getSource().equals(radioAvailable) && radioAvailable.isSelected()) {
            textArea.setText("");
            Flight[] flights = TestAirline.airline.getAllAvailableFlights();
            for (int i = 0; i < flights.length; i++) {
                if (flights[i] != null) {
                    textArea.append(flights[i].getClass().getSimpleName() + ": " + flights[i].toString() + "\n");
                }
            }
        }
    }

    private void clearFields() {
        flightNoField.setText("");
        userIdField.setText("");
        nameField.setText("");
        mobileField.setText("");
    }
}