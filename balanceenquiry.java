import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class balanceenquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    balanceenquiry(String pinnumber){
        this.pinnumber = pinnumber;  
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 750,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        conn c = new conn();
        int balance=0;
        try{
            
            ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
                    
        }
        catch(Exception e){
            System.out.println(e);
        }
        

        JLabel text = new JLabel("Your Net Account Balance is " + balance);
        text.setBounds(200,250,250,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);

        back = new JButton("BACK");
        back.setBounds(350,395,100,20);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System", Font.BOLD, 10));
        back.addActionListener(this);
        image.add(back);




        getContentPane().setBackground(Color.WHITE);
        
        setSize(900,750);
        setVisible(true);
        setLocation(300,0);
    }
    public void actionPerformed(ActionEvent ar){
        if(ar.getSource() == back){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new balanceenquiry("");
    }
}
