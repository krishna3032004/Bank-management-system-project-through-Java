import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import java.util.*;
import javax.swing.*;
// import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
    String pinnumber;
    JButton back,withdraw;
    JTextField text;
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber ;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance (900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,750);
        add(label);

        JLabel line = new JLabel("Please Enter the amount you want to withdraw ");
        line.setBounds(180,250,350,30);
        line.setForeground(Color.WHITE);
        line.setFont(new Font("System", Font.BOLD, 14));
        label.add(line);

        text = new JTextField();
        text.setBounds(180,325,300,25);
        label.add(text);
        
        withdraw =new JButton("Withdraw");
        withdraw.setBounds(250,400,100,30);
        withdraw.addActionListener(this);
        label.add(withdraw);

        back =new JButton("Back");
        back.setBounds(380,400,100,30);
        back.addActionListener(this);
        label.add(back);

        getContentPane().setBackground(Color.WHITE);

        setSize(900, 750);
        setLocation(300,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ay){
        if(ay.getSource() == withdraw){
            String amount = text.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount");
            }
            else{
                
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pinnumber+"'");
                    int balance=0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }

                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        setVisible(false);
                        new transactions(pinnumber).setVisible(true);
                    }
                    else{
                        conn conn =new conn();
                        String query = "insert into bank values('"+pinnumber+"','"+amount+"','"+date+"','withdraw')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs "+amount+" withdraw successfully");
                        setVisible(false);
                        new transactions(pinnumber).setVisible(true);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }

        }
        else if(ay.getSource() == back){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }

    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}
