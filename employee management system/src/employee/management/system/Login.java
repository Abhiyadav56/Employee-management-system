package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    //global declared
  JTextField tusername;

  JPasswordField tpassword;

  JButton login, back;


    public Login()
    {
        // kisi bhi text ko frame par show karbna hai uske liye use hota JLable ka
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        // for box
        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);


        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70,150,30);
        add(tpassword);

        // for login button
        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);// for listen the command login
        add(login);

        // for back button
        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this); // for listen the command back
        add(back);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,400);
        add(imgg);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        setSize(600,300);
       setLocation(450,200);
       setLayout(null);
       setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
       if (e.getSource()==login)
       {

           try{

               String username =  tusername.getText();
               String password = tpassword.getText();

               conn conn = new conn(); // FOR CONNECTION TO conn class

               String query = "select * from login where username ='"+username+"' and password='"+password+"'";
               ResultSet resultSet =conn.statement.executeQuery(query); // data store hota h resultset ke ander
               if (resultSet.next())
               {
                   setVisible(false);
                   new Main_class(); // for connection to Main_class
               }
               else {

                   JOptionPane.showMessageDialog(null,"Invalid username or pasword");
               }

           }catch (Exception E)
           {
               E.printStackTrace();
           }

       } else if (e.getSource()==back)
       {
           System.exit(90);
       }
    }
    public static void main(String [] args)
    {
        Login lg = new Login();

    }
}







