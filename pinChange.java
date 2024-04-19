import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class pinChange extends JFrame implements ActionListener{
    String pinnumber;
    JPasswordField pintext,pintext2;
    JButton back,change;
    pinChange(String pinnumber){
        this.pinnumber = pinnumber;  
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 750,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,210,200,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);

        JLabel rpin = new JLabel("New-PIN:");
        rpin.setBounds(150,235,100,50);
        rpin.setForeground(Color.WHITE);
        rpin.setFont(new Font("System", Font.BOLD, 14));
        image.add(rpin);

        pintext =new JPasswordField();
        pintext.setBounds(300,250,200,25);
        pintext.setForeground(Color.BLACK);
        pintext.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(pintext);

        JLabel rpin2 = new JLabel("Re-Enter New-PIN:");
        rpin2.setBounds(150,275,200,50);
        rpin2.setForeground(Color.WHITE);
        rpin2.setFont(new Font("System", Font.BOLD, 14));
        image.add(rpin2);

        pintext2 =new JPasswordField();
        pintext2.setBounds(300,290,200,25);
        pintext2.setForeground(Color.BLACK);
        pintext2.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(pintext2);
                
        change = new JButton("CHANGE");
        change.setBounds(350,370,100,20);
        change.setForeground(Color.BLACK);
        change.setFont(new Font("System", Font.BOLD, 10));
        change.addActionListener(this);
        image.add(change);

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
        if(ar.getSource() == change){
            try{
                String newpin = pintext.getText();
                String repin = pintext2.getText();
                if(!newpin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter PIN");
                    return;
                }
                if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter PIN");
                    return;
                }
                conn c =new conn();
                String query1 = "Update bank set pin_number = '"+newpin+"' where pin_number = '"+pinnumber+"'";
                String query2 = "Update login set Pin_number = '"+newpin+"' where Pin_number = '"+pinnumber+"'";
                String query3 = "Update signin3 set pin_number = '"+newpin+"' where pin_number = '"+pinnumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new transactions(pinnumber).setVisible(true);

            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new pinChange("");
    }
}
