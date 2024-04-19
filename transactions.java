import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transactions extends JFrame implements ActionListener{
    JButton select1,select2,select3,select4,select5,select6,select7;
    String pinnumber;
    transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance (900,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,750);
        add(label);

        JLabel title = new JLabel("Please Select your Transaction ");
        title.setBounds(220,250,300,50);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("System", Font.BOLD, 14));
        label.add(title);

        select1 = new JButton("Deposit");
        select1.setBounds(170,340,140,25);
        select1.addActionListener(this);
        label.add(select1);
        select2 = new JButton("Fast Cash");
        select2.setBounds(170,370,140,25);
        select2.addActionListener(this);
        label.add(select2);
        select3 = new JButton("Pin Change");
        select3.setBounds(170,400,140,25);
        select3.addActionListener(this);
        label.add(select3);
        select4 = new JButton("Cash Withdrawl");
        select4.setBounds(360,340,140,25);
        select4.addActionListener(this);
        label.add(select4);
        select5 = new JButton("Mini Statement");
        select5.setBounds(360,370,140,25);
        select5.addActionListener(this);
        label.add(select5);
        select6 = new JButton("Balance Enquiry");
        select6.setBounds(360,400,140,25);
        select6.addActionListener(this);
        label.add(select6);
        select7 = new JButton("EXIT");
        select7.setBounds(360,430,140,25);
        select7.addActionListener(this);
        label.add(select7);





        getContentPane().setBackground(Color.WHITE);

        setSize(900, 750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ay){
        if(ay.getSource() == select7){
            System.exit(0);           
        }
        else if(ay.getSource() == select1){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        }
        else if(ay.getSource() == select3){
            setVisible(false);
            new pinChange(pinnumber).setVisible(true);
        }    
        else if(ay.getSource() == select4){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ay.getSource() == select6){
            setVisible(false);
            new balanceenquiry(pinnumber).setVisible(true);
        }

    }

    public static void main(String args[]){
        new transactions("");
    }
}
