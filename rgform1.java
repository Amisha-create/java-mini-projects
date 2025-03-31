import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class rgform1 {
	

    public static void main(String[] args) {
        JFrame p = new JFrame("Registration Form");
        p.setSize(500, 600);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setLayout(null);

       
        JLabel l1 = new JLabel("Name:");
        l1.setBounds(50, 50, 150, 25);
        JTextField t1 = new JTextField(10);
        t1.setBounds(200, 50, 200, 25);

       
        JLabel l2 = new JLabel("Enrollment No:");
        l2.setBounds(50, 100, 150, 25);
        JTextField t2 = new JTextField(10);
        t2.setBounds(200, 100, 200, 25);

        JLabel l3 = new JLabel("Email:");
        l3.setBounds(50, 150, 150, 25);
        JTextField t3 = new JTextField(10);
        t3.setBounds(200, 150, 200, 25);

        
        JLabel l4 = new JLabel("Password:");
        l4.setBounds(50, 200, 150, 25);
        JPasswordField t4 = new JPasswordField(10);
        t4.setBounds(200, 200, 200, 25);

        
        JLabel l5 = new JLabel("Gender:");
        l5.setBounds(50, 250, 150, 25);
        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(200, 250, 70, 25);
        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(270, 250, 90, 25);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

       
        JLabel l7 = new JLabel("Subject:");
        l7.setBounds(50, 300, 150, 25);
        JCheckBox c1 = new JCheckBox("DSA");
        c1.setBounds(200, 300, 70, 25);
        JCheckBox c2 = new JCheckBox("DCCN");
        c2.setBounds(270, 300, 70, 25);
        JCheckBox c3 = new JCheckBox("JAVA");
        c3.setBounds(340, 300, 70, 25);

       
        JLabel l6 = new JLabel("Comments:");
        l6.setBounds(50, 350, 150, 25);
        JTextArea ta = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(ta);
        scrollPane.setBounds(200, 350, 200, 75);

      
        JButton b1 = new JButton("Submit");
        b1.setBounds(150, 450, 100, 30);
        JButton b2 = new JButton("Reset");
        b2.setBounds(300, 450, 100, 30);
	/**JTextArea tx=new JTextArea(3,50);
	JScrollPane scrollPane1 = new JScrollPane(tx);
        scrollPane1.setBounds(350, 500, 250, 100);**/

       
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(l4);
        p.add(t4);
        p.add(l5);
        p.add(r1);
        p.add(r2);
        p.add(l7);
        p.add(c1);
        p.add(c2);
        p.add(c3);
        p.add(l6);
        p.add(scrollPane);
        p.add(b1);
        p.add(b2);
	//p.add(scrollPane1);
        p.setVisible(true);
  
        b1.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
		String url = "jdbc:mysql://localhost:3307/db"; 
        String user = "root";  
        String password = "";  

        String name1 = t1.getText();
                String enrollment1 = t2.getText();
                String email1 = t3.getText();
                String pass1 = new String(t4.getPassword());
                String gender1 = r1.isSelected() ? "Male" : "Female";
                String subjects1 = "";
                if (c1.isSelected()) subjects1 += "DSA ";
                if (c2.isSelected()) subjects1 += "DCCN ";
                if (c3.isSelected()) subjects1 += "JAVA";
                String comments1 = ta.getText();

		boolean isValid = true;
                String errorMessage = "";

                
                if (name1.isEmpty() || !name1.matches("[a-zA-Z\\s]+")) {
                    isValid = false;
                    errorMessage += "Invalid Name.\n";
                }

                
                if (enrollment1.isEmpty() || !enrollment1.matches("\\d+")) { 
                    isValid = false;
                    errorMessage += "Invalid Enrollment Number.\n";
                }

                
                String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                if (email1.isEmpty() || !email1.matches(emailRegex)) {
                    isValid = false;
                    errorMessage += "Invalid Email Address.\n";
                }

                if (pass1.length() < 8) {
                    isValid = false;
                    errorMessage += "Password must be at least 8 characters long.\n";
                }

                if (!isValid) {
                    JOptionPane.showMessageDialog(p, errorMessage, "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }


                try {
                      Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    System.out.println("Connection Successful!");

                    String query = "INSERT INTO student (name, enrollment_no, email, password, gender, subject, comment) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, name1);
                    pst.setString(2, enrollment1);
                    pst.setString(3, email1);
                    pst.setString(4, pass1);
                    pst.setString(5, gender1);
                    pst.setString(6, subjects1);
                    pst.setString(7, comments1);
                    		pst.executeUpdate();
                    System.out.println("Data inserted successfully!");
                   /** while(rs.next())
			{
				System.out.println("name="+rs.getString("name"));
				System.out.println("enroll="+rs.getString("enrollment no"));
				System.out.println("email="+rs.getString("email"));
				System.out.println("pass="+rs.getString("password"));
				System.out.println("gender="+rs.getString("gender"));
				System.out.println("subject="+rs.getString("subject"));
				System.out.println("comment="+rs.getString("comment"));
			}**/
		
                    con.close();
                } catch (Exception ex) {
                    System.out.println("Connection Failed!");
                    ex.printStackTrace();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                bg.clearSelection();
                c1.setSelected(false);
                c2.setSelected(false);
                c3.setSelected(false);
                ta.setText("");
            }
        });
    }
}