import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Form
{
public static void main(String s[]){
	JFrame f1 = new JFrame("buttons");
	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f1.setLayout(new FlowLayout());
	JPanel p = new JPanel(new GridLayout(9,0));

	JPanel p1 = new JPanel(new GridLayout(1,1));	
	JLabel l1 = new JLabel("REGISTERATION FORM:-");
	l1.setFont(new Font("TNR",Font.BOLD,30));
	
	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
	JLabel l2 = new JLabel("NAME:-");
	 JTextField tf1 = new JTextField(20);
	
	
	JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));	
	JLabel l3 = new JLabel("FATHER NAME:-");
	 JTextField tf2 = new JTextField(20);
	tf2.setBounds(30,30,50,50);


	JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
	JLabel l4 = new JLabel("ENROLLEMENT:-");
	JTextField tf3 = new JTextField(20);
	tf3.setBounds(10,10,20,20);


	JPanel p5 = new JPanel(new GridLayout(1,2));
	JLabel l5 = new JLabel("Gender:-");
	
	
	
	JPanel p6 = new JPanel(new GridLayout(2,1));
	 ButtonGroup group = new ButtonGroup();
	 JRadioButton b1 = new JRadioButton("female");
	b1.setBounds(30,30,50,50);

	 JRadioButton b2 = new JRadioButton("male");
	b2.setBounds(30,30,50,50);

	
	JPanel p7 = new JPanel(new GridLayout(1,1));
	JLabel l6 = new JLabel("SKILLS:-");
	
	
	JPanel p8 = new JPanel(new GridLayout(4,1));
     	 JCheckBox ch1 = new JCheckBox("JAVA");
	
	 JCheckBox ch2 = new JCheckBox("C++");
	
	 JCheckBox ch3 = new JCheckBox("HTML");
	
	 JCheckBox ch4 = new JCheckBox("PYTHON");

	JPanel p9 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton b3 = new JButton("SUBMIT");
	JButton b4 = new JButton("RESET");
	
	
	p1.add(l1);
	p2.add(l2);
	p2.add(tf1);
	p3.add(l3);
	p3.add(tf2);
	p4.add(l4);
	p4.add(tf3);
	p5.add(l5);
	
	
	p6.add(b1);
	p6.add(b2);
	p7.add(l6);
	p8.add(ch1);
	p8.add(ch2);
	p8.add(ch3);
	p8.add(ch4);
	p9.add(b3);
	p9.add(b4);
	
	p.add(p1);
	p.add(p2);
	p.add(p3);
	p.add(p4);
	p.add(p5);
	p.add(p6);
	p.add(p7);
	p.add(p8);
	p.add(p9);
	p.setVisible(true);
	


	//p1.setBackground(Color.RED);
	//p2.setBackground(Color.RED);
	//p3.setBackground(Color.RED);
	//p4.setBackground(Color.RED);
	//p5.setBackground(Color.RED);
	//p6.setBackground(Color.RED);
	//p7.setBackground(Color.RED);
	//p8.setBackground(Color.RED);
	//p9.setBackground(Color.RED);

	group.add(b1);
        group.add(b2);
	
        f1.add(p,BorderLayout.CENTER);		
	f1.setSize(400,300);
	f1.setVisible(true);
	
	b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			    String url = "jdbc:mysql://localhost:3307/db"; 
        			String user = "root";  
       				 String password = ""; 
			  
				String name1 = tf1.getText();
				String Father_name = tf2.getText();
				String Enrollemnet1 = tf3.getText();
				String gender1 = b1.isSelected() ? "Male" : "Female";
				String Skills1 = "";	
				if (ch1.isSelected()) Skills1 += "JAVA";
				if (ch2.isSelected()) Skills1 += "C++";
				if (ch3.isSelected()) Skills1 += "HTML";
				if (ch4.isSelected()) Skills1 += "PYTHON";

			   try{
				Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    System.out.println("Connection Successful!");
				String query = "INSERT INTO registeration (Name, Father_Name, Enrollement, Gender, Skills) VALUES (?, ?, ?, ?, ?)";

				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, name1);
				stmt.setString(2, Father_name);
				stmt.setString(3, Enrollemnet1);
				stmt.setString(4, gender1);
				stmt.setString(5, Skills1);

				stmt.executeUpdate();
				conn.close();
				
				
			
				} catch (Exception ex) {
                    System.out.println("Connection Failed!");
                    ex.printStackTrace();
                }

			}
		});
		
			 b4.addActionListener(new ActionListener() {
            
           			 public void actionPerformed(ActionEvent e) {
                			tf1.setText("");
                			tf2.setText("");
                			tf3.setText("");
               				group.clearSelection(); 	               				 		ch1.setSelected(false);
               				ch2.setSelected(false);
               				ch3.setSelected(false);
                			ch4.setSelected(false);
            }
        });	
     	
}

}