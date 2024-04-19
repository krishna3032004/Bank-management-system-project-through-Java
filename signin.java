import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
// import Calendar.JDateChooser;

public class signin extends JFrame implements ActionListener{
    long random;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser dateChooser;
    JTextField nameTextField, fnameTextField,emailTextField, addressTextField,cityTextField,stateTextField,pinTextField;
    signin(){
        setLayout(null);

        Random ran =new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel details = new JLabel("Page 1 : Personal Details ");
        details.setFont(new Font("Raleway",Font.BOLD,22));
        details.setBounds(280,70,400,30);
        add(details);
        
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,115,200,40);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(300, 120, 400, 30);
        nameTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(nameTextField);
        
        JLabel Fname = new JLabel("Father's Name :");
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,170,200,40);
        add(Fname);
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 175, 400, 30);
        fnameTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,225,200,40);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,230,400,30);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,280,200,40);
        add(gender);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(300,285,200,30);
        female.setBounds(500,285,200,30);
        add(male);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,335,200,40);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 400, 30);
        emailTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,40);
        add(marital);
        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");
        others = new JRadioButton("Others");
        married.setBounds(300,390,133,30);
        unmarried.setBounds(433,390,133,30);
        others.setBounds(566,390,133,30);
        add(married);
        add(unmarried);
        add(others);
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);
        
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,445,200,40);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setBounds(300, 450, 400, 30);
        addressTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(addressTextField);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,500,200,40);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 505, 400, 30);
        cityTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(cityTextField);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,555,200,40);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 560, 400, 30);
        stateTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,610,200,40);
        add(pincode);
        pinTextField = new JTextField();
        pinTextField.setBounds(300, 615, 400, 30);
        pinTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(pinTextField);

        next = new JButton("NEXT");
        next.setBounds(650,665,100,25);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,770);
        setVisible(true);
        setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } 
        else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pinTextField.getText();
        String marital =null;
        String state = stateTextField.getText();
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(others.isSelected()){
            marital = "Others";
        }

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }else{
                conn c = new conn();
                String query = "Insert into signin values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+marital+"','"+pincode+"','"+state+"','"+city+"')";
                c.s.executeUpdate(query);
            }
        
        }
        catch(Exception e){
            System.out.println(e);
        }
        if(ae.getSource() == next){
            setVisible(false);
            new signin2(formno).setVisible(true);
        }
    }


    public static void main (String args[]){
        new signin();
    }
}
