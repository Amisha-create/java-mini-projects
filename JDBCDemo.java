import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login { // Corrected class name

    public static void main(String[] args) {
        JFrame f = new JFrame("Login Page");
        f.setSize(500, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridBagLayout());

        JPanel p = new JPanel(new GridLayout(5, 1, 5, 5));

        JLabel l1 = new JLabel("User Name:");
        JTextField t1 = new JTextField(15);
        JPanel p1 = new JPanel(new GridLayout(1, 2, 5, 5));

        JLabel l2 = new JLabel("Password:");
        JPasswordField t2 = new JPasswordField(15);
        JPanel p2 = new JPanel(new GridLayout(1, 2, 5, 5));

        JButton b1 = new JButton("Login");
        JPanel p3 = new JPanel();

        JButton b2 = new JButton("Create Account");
        JPanel p4 = new JPanel();

        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);
        p3.add(b1);
        p4.add(b2);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        f.add(p, gbc);

        f.setVisible(true);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f11 = new JFrame("Create Account");
                f11.setSize(500, 600);
                f11.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f11.setLayout(new GridBagLayout());

                JPanel p1 = new JPanel(new GridLayout(3, 1, 5, 5));

                JLabel l11 = new JLabel("User Name:");
                JTextField t11 = new JTextField(15);
                JPanel p11 = new JPanel(new GridLayout(1, 2, 5, 5));

                JLabel l21 = new JLabel("Password:");
                JPasswordField t21 = new JPasswordField(15);
                JPanel p21 = new JPanel(new GridLayout(1, 2, 5, 5));

                JButton b11 = new JButton("Submit");
                JPanel p31 = new JPanel();

                p11.add(l11);
                p11.add(t11);
                p21.add(l21);
                p21.add(t21);
                p31.add(b11);

                p1.add(p11);
                p1.add(p21);
                p1.add(p31);

                GridBagConstraints gbc11 = new GridBagConstraints();
                gbc11.gridx = 0;
                gbc11.gridy = 0;
                gbc11.weightx = 1.0;
                gbc11.weighty = 1.0;
                gbc11.anchor = GridBagConstraints.CENTER;
                f11.add(p1, gbc11);

                f11.setVisible(true);

                b11.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String url = "jdbc:mysql://localhost:3307/mydb"; // Corrected port
                        String user = "root";
                        String password = "";

                        String name1 = t11.getText();
                        String pass1 = new String(t21.getPassword());

                        boolean isValid = true;
                        String errorMessage = "";

                        if (name1.isEmpty() || !name1.matches("[a-zA-Z\\s]+")) {
                            isValid = false;
                            errorMessage += "Invalid Name.\n";
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

                            String query = "INSERT INTO users (Username, password) VALUES (?, ?)";

                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setString(1, name1);
                            pst.setString(2, pass1);
                            pst.executeUpdate();
                            System.out.println("Data inserted successfully!");

                            con.close();
                            JOptionPane.showMessageDialog(f11, "Account created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE); // added success message.
                            f11.dispose(); //close create account window.

                        } catch (Exception ex) {
                            System.out.println("Connection Failed!");
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(f11, "Database error", "Error", JOptionPane.ERROR_MESSAGE); // added error message.
                        }
                    }
                });
            }
        });
    }
}