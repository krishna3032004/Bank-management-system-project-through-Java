import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.util.*;
// import java.awt.event.*;
// import javax.swing.JComboBox;


public class signin2 extends JFrame implements ActionListener{
    JButton next;
    JRadioButton ayes,ano,eyes,eno;
    JTextField aadharTextField, panTextField;
    JComboBox religion1,category1,income1,education1,occupation1;
    String formno;
    signin2(String formno){
        this.formno =formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        // Random ran =new Random();
        // random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        // JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        // formno.setFont(new Font("Raleway",Font.BOLD,38));
        // formno.setBounds(140,20,600,40);
        // add(formno);
        
        JLabel details = new JLabel("Page 2 : Additional Details ");
        details.setFont(new Font("Raleway",Font.BOLD,22));
        details.setBounds(280,70,400,30);
        add(details);
        
        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,115,200,40);
        add(religion);
        String religionoption[] = {"Hindu","Muslim","Sikh","Christian","Others"};
        religion1 = new JComboBox(religionoption);
        religion1.setBounds(300, 120, 400, 30);
        religion1.setFont(new Font("Raleway",Font.BOLD, 14));
        add(religion1);
        
        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,170,200,40);
        add(category);
        String categoryoption[] = {"General","OBC","SC","ST","Others"};
        category1 = new JComboBox(categoryoption);
        category1.setBounds(300, 175, 400, 30);
        category1.setFont(new Font("Raleway",Font.BOLD, 14));
        add(category1);
        
        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,225,200,40);
        add(income);
        String incomeoption[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income1 = new JComboBox(incomeoption);
        income1.setBounds(300,230,400,30);
        income1.setFont(new Font("Raleway",Font.BOLD, 14));
        add(income1);
        
        JLabel educational = new JLabel("Educational ");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,285,200,40);
        add(educational);
        JLabel qualification = new JLabel("Qualification  :");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,320,200,40);
        add(qualification);
        String educationoption[] = {"Non-Graduate","Graduation","Post-Graduation","Doctrate","Others"};
        education1 = new JComboBox(educationoption);
        education1.setBounds(300,320,400,30);
        education1.setFont(new Font("Raleway",Font.BOLD, 14));
        add(education1);
    
        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,40);
        add(occupation);
        String occupationoption[] = {"Salaried","Self-Employed","Bussiness","Retired","Student","Others"};
        occupation1 = new JComboBox(occupationoption);
        occupation1.setBounds(300,390,400,30);
        occupation1.setFont(new Font("Raleway",Font.BOLD, 14));
        add(occupation1);
        
        JLabel pannumber = new JLabel("PAN Number :");
        pannumber.setFont(new Font("Raleway",Font.BOLD,20));
        pannumber.setBounds(100,445,200,40);
        add(pannumber);
        panTextField = new JTextField();
        panTextField.setBounds(300, 450, 400, 30);
        panTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(panTextField);
        
        JLabel aadharno = new JLabel("Aadhar Number :");
        aadharno.setFont(new Font("Raleway",Font.BOLD,20));
        aadharno.setBounds(100,500,200,40);
        add(aadharno);
        aadharTextField = new JTextField();
        aadharTextField.setBounds(300, 505, 400, 30);
        aadharTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        add(aadharTextField);
        
        JLabel senior = new JLabel("Senior Citizen :");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,555,200,40);
        add(senior);
        ayes =new JRadioButton("Yes");
        ayes.setBounds(300, 555, 200, 30);
        ayes.setFont(new Font("Raleway",Font.BOLD, 14));
        add(ayes);
        ano =new JRadioButton("NO");
        ano.setBounds(500, 555, 200, 30);
        ano.setFont(new Font("Raleway",Font.BOLD, 14));
        add(ano);
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(ayes);
        seniorgroup.add(ano);
        
        JLabel existingaccount = new JLabel("Existing Account :");
        existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
        existingaccount.setBounds(100,610,200,40);
        add(existingaccount);
        eyes =new JRadioButton("Yes");
        eyes.setBounds(300, 610, 200, 30);
        eyes.setFont(new Font("Raleway",Font.BOLD, 14));
        add(eyes);
        eno =new JRadioButton("No");
        eno.setBounds(500, 610, 200, 30);
        eno.setFont(new Font("Raleway",Font.BOLD, 14));
        add(eno);
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);

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
        // String formno = "" + random;
        String sreligion = (String)religion1.getSelectedItem();
        String scategory= (String)category1.getSelectedItem();
        String sincome = (String)income1.getSelectedItem();
        String seducation = (String)education1.getSelectedItem();
        String soccupation = (String)occupation1.getSelectedItem();
        String spannumber = panTextField.getText();
        String saadhar = aadharTextField.getText();
        String ssenior =null;
        if(ayes.isSelected()){
            ssenior = "Yes";
        } 
        else if(ano.isSelected()){
            ssenior = "No";
        }
        String sexisting = null;
        if(eyes.isSelected()){
            sexisting="Yes";
        }
        else if(eno.isSelected()){
            sexisting = "No";
        }
        
        try{
            if(sreligion.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }else{
                conn c = new conn();
                String query = "Insert into signin2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+spannumber+"','"+saadhar+"','"+ssenior+"','"+sexisting+"')";
                c.s.executeUpdate(query);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        if(ae.getSource() == next){
            setVisible(false);
            new signin3(formno).setVisible(true);
        }
    }


    public static void main (String args[]){
        new signin2("");
    }
}
