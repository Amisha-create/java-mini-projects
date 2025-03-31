import javax.swing.*;
import java.awt.*;

public class calculator 
{
	public static void main(String s[])
	{
		JFrame frame = new JFrame("calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel(new GridLayout(6,6,6,6));
		JPanel panel2 = new JPanel(new GridLayout(5,2,10,10));

		JTextField tf1 = new JTextField("25");
		JTextField tf2 = new JTextField("10");
		JTextField tf3 = new JTextField("35");
		
		
		JLabel label1 = new JLabel("enter number 1");
		JLabel label2 = new JLabel("enter number 2");
		JLabel label3 = new JLabel("Result");

		JButton button1 = new JButton("+");
		button1.setBounds(20,20,30,30);
		JButton button2 = new JButton("-");
		button2.setBounds(20,20,30,30);
		JButton button3 = new JButton("*");
		button3.setBounds(20,20,30,30);
		JButton button4 = new JButton("/");
		button4.setBounds(20,20,30,30);
		
		panel1.add(label1);
		panel1.add(tf1);
		panel1.add(label2);
		panel1.add(tf2);
		panel1.add(label3);
		panel1.add(tf3);

		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);

                frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);
		
		
		
		
		frame.setSize(400,300);
		frame.setVisible(true);
	}
}
