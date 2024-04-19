import java.awt.event.*;
import java.awt.*;
import java.util.Date;
import javax.swing.*;
// import java.sql.*;

public class deposit extends JFrame implements ActionListener {
    String pinnumber;
    JButton back,deposit;
    JTextField text;
    deposit(String pinnumber){
        this.pinnumber = pinnumber ;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance (900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,750);
        add(label);

        JLabel line = new JLabel("Please Enter the amount you want to deposit ");
        line.setBounds(180,250,350,30);
        line.setForeground(Color.WHITE);
        line.setFont(new Font("System", Font.BOLD, 14));
        label.add(line);

        text = new JTextField();
        text.setBounds(180,325,300,25);
        label.add(text);
        
        deposit =new JButton("deposit");
        deposit.setBounds(250,400,100,30);
        deposit.addActionListener(this);
        label.add(deposit);

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
        if(ay.getSource() == deposit){
            String amount = text.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount");
            }
            else{
                try{
                    conn c = new conn();
                    String query = "insert into bank values('"+pinnumber+"','"+amount+"','"+date+"','Deposit')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog( null, "Rs "+amount+" deposited successfully");
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
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
        new deposit("");
    }
}
