// import java.awt.Color;
// import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
 
    JButton clear,signin,Login;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        
        setTitle("AUTOMATIC TELLER MACHINE ");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card no. :");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(150,200,200,20);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(350, 200, 200, 25);
        cardTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("Pin :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(150,250,200,20);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 250, 200, 25);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(pinTextField);

        clear = new JButton("Clear");
        clear.setBounds(350, 290, 200, 25);
        clear.addActionListener(this);
        add(clear);

        signin = new JButton("Sign in");
        signin.setBounds(350, 330, 200, 25);
        signin.addActionListener(this);
        add(signin);

        Login = new JButton("Login");
        Login.setBounds(350, 360, 200, 25);
        Login.addActionListener(this);
        add(Login);

        // JLabel text = new JLabel("WELCOME TO ATM");
        // text.setFont(new Font("Osward",Font.BOLD,38));
        // text.setBounds(200,40,400,40);
        // add(text);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,500);
        setVisible(true);
        setLocation(350,150);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource() == Login){
            conn conn = new conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where card_number = '"+cardnumber+"' and pin_number ='"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"invalid Card number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
           
        } else if(ae.getSource() == signin){
            setVisible(false);
            new signin().setVisible(true);
        }
    }
    public static void main (String args[]){
        new Login();
    }
}