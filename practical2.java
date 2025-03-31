import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class practical2 
{
	public static void main(String s[])
	{
		JFrame frame = new JFrame("buttons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel(new GridLayout(6,0,10,10));
				
		
		JLabel label1 = new JLabel("Items:");
		label1.setBounds(30,30,50,50);

		
		final JCheckBox ch1 = new JCheckBox("samosa(15)");
		ch1.setBounds(30,30,50,50);
		final JCheckBox ch2 = new JCheckBox("kachori(10)");
		ch2.setBounds(30,30,50,50);
		final JCheckBox ch3 = new JCheckBox("patties(25)");
		ch3.setBounds(30,30,50,50);
		final JCheckBox ch4 = new JCheckBox("chai(5)");
		ch4.setBounds(30,30,50,50);

		final JButton button1 = new JButton("BUY");
		button1.setBounds(30,30,50,50);
		
     
     		panel1.add(label1);
		panel1.add(ch1);
		panel1.add(ch2);
		panel1.add(ch3);
		panel1.add(ch4);
		panel1.add(button1);
		panel1.setBackground(Color.PINK);

                frame.add(panel1,BorderLayout.CENTER);		
		frame.setSize(400,300);
		frame.setVisible(true);

		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			int Total_amount=0;
			String items ="";
			if(ch1.isSelected())
			{       items += ch1.getText();
				Total_amount +=15;
				System.out.println(items);
				System.out.println(Total_amount);
			}
			if(ch2.isSelected())
			{	items += ch2.getText();
				Total_amount +=10;
				System.out.println(items);
				System.out.println(Total_amount);
			}
			if(ch3.isSelected())
			{	items += ch3.getText();
				Total_amount +=25;
				System.out.println(items);
				System.out.println(Total_amount);
			}
			if(ch4.isSelected())
			{	items += ch4.getText();
				Total_amount +=5;
				System.out.println(items);
				System.out.println(Total_amount);
			}
						}
		});
	}
}
