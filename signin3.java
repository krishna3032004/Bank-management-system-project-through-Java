import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class signin3 extends JFrame implements ActionListener{
    JCheckBox box1,box2,box3,box4,box5,box6,box7;
    JRadioButton account1,account2,account3,account4;
    JButton submit;
    String formno;
    signin3(String formno){
        this.formno =formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel Details = new JLabel("Page 3 : Account Details");
        Details.setFont(new Font("Raleway",Font.BOLD,22));
        Details.setBounds(250, 20, 500, 80);
        add(Details);

        JLabel Accounttype = new JLabel("Account Type");
        Accounttype.setFont(new Font("Raleway",Font.BOLD,22));
        Accounttype.setBounds(100, 100, 200, 50);
        add(Accounttype);

        account1 = new JRadioButton("Saving Account");
        account1.setFont(new Font("Raleway",Font.BOLD,15));
        account1.setBounds(100,140,200,40);
        account1.setBackground(Color.WHITE);
        add(account1);
        account2 = new JRadioButton("Current Account");
        account2.setFont(new Font("Raleway",Font.BOLD,15));
        account2.setBounds(100,170,200,40);
        account2.setBackground(Color.WHITE);
        add(account2);
        account3 = new JRadioButton("Fixed Deposit Account");
        account3.setFont(new Font("Raleway",Font.BOLD,15));
        account3.setBounds(350,140,200,40);
        account3.setBackground(Color.WHITE);
        add(account3);
        account4 = new JRadioButton("Recurring Deposit Account");
        account4.setFont(new Font("Raleway",Font.BOLD,15));
        account4.setBounds(350,170,250,40);
        account4.setBackground(Color.WHITE);
        add(account4);
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(account1);
        accountgroup.add(account2);
        accountgroup.add(account3);
        accountgroup.add(account4);

        JLabel Number = new JLabel("Card Number:");
        Number.setFont(new Font("Raleway",Font.BOLD,22));
        Number.setBounds(100, 230, 200, 50);
        add(Number);
        JLabel info = new JLabel("Your 16 Digit Card Number");
        info.setFont(new Font("Raleway",Font.BOLD,13));
        info.setBounds(100, 255, 200, 50);
        add(info);
        JLabel Num = new JLabel("XXXX-XXXX-XXXX-4126");
        Num.setFont(new Font("Raleway",Font.BOLD,22));
        Num.setBounds(350, 230, 250, 50);
        add(Num);

        JLabel Number2 = new JLabel("PIN:");
        Number2.setFont(new Font("Raleway",Font.BOLD,22));
        Number2.setBounds(100, 300, 200, 50);
        add(Number2);
        JLabel info2 = new JLabel("Your 16 Digit Card Number");
        info2.setFont(new Font("Raleway",Font.BOLD,13));
        info2.setBounds(100, 325, 200, 50);
        add(info2);
        JLabel Num2 = new JLabel("XXXX");
        Num2.setFont(new Font("Raleway",Font.BOLD,22));
        Num2.setBounds(350, 300, 250, 50);
        add(Num2);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100, 380, 200, 50);
        add(services);
        box1 = new JCheckBox("ATM Card");
        box1.setFont(new Font("Raleway",Font.BOLD,16));
        box1.setBackground(Color.WHITE);
        box1.setBounds(100,420,150,50);
        add(box1);
        box2 = new JCheckBox("Mobile Banking");
        box2.setFont(new Font("Raleway",Font.BOLD,16));
        box2.setBackground(Color.WHITE);
        box2.setBounds(100,460,150,50);
        add(box2);
        box3 = new JCheckBox("Cheque Book");
        box3.setFont(new Font("Raleway",Font.BOLD,16));
        box3.setBackground(Color.WHITE);
        box3.setBounds(100,500,150,50);
        add(box3);
        box4 = new JCheckBox("Internet Banking");
        box4.setFont(new Font("Raleway",Font.BOLD,16));
        box4.setBackground(Color.WHITE);
        box4.setBounds(350,420,180,50);
        add(box4);
        box5 = new JCheckBox("EMAIL & SMS Alerts");
        box5.setFont(new Font("Raleway",Font.BOLD,16));
        box5.setBackground(Color.WHITE);
        box5.setBounds(350,460,180,50);
        add(box5);
        box6 = new JCheckBox("E-Statement");
        box6.setFont(new Font("Raleway",Font.BOLD,16));
        box6.setBackground(Color.WHITE);
        box6.setBounds(350,500,150,50);
        add(box6);
        box7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowlegde");
        box7.setFont(new Font("Raleway",Font.BOLD,12));
        box7.setBackground(Color.WHITE);
        box7.setBounds(100,590,600,30);
        add(box7);

        submit = new JButton("Submit");
        submit.setBounds(250,630,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,770);
        setVisible(true);
        setLocation(350,10);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accounttype = "";
            if(account1.isSelected()){
                accounttype = "Saving Account";
            }
            else if(account2.isSelected()){
                accounttype ="Current Account";
            }
            else if(account3.isSelected()){
                accounttype ="Fixed Deposit Account";
            }
            else if(account3.isSelected()){
                accounttype ="Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 504093600000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if(box1.isSelected()){
                facility = facility + "ATM CARD";
            }
            else if(box2.isSelected()){
                facility =facility + "Mobile Banking";
            }
            else if(box3.isSelected()){
                facility =facility + "Cheque Book";
            }
            else if(box4.isSelected()){
                facility =facility + "Internet Banking";
            }
            else if(box5.isSelected()){
                facility =facility + "EMAIL & SMS Alerts";
            }
            else if(box6.isSelected()){
                facility =facility + "E-Statement";
            }
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else if(!box7.isSelected()){
                    JOptionPane.showMessageDialog(null,"Tick the confirmation line!");
                } else {
                    conn conn = new conn();
                    String query1 = "Insert into signin3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "Insert into Login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card number: " + cardnumber + "\n Pin: " + pinnumber);
                    JOptionPane.showMessageDialog(null, "Please deposit some amount");
                    setVisible(false);
                    new deposit(pinnumber).setVisible(true);
                }
            } catch(Exception e){
                System.out.println(e);
            }
            

        }
    }
    public static void main (String args[]){
        new signin3("");
    }

}
