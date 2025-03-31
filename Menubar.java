import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Menubar
{
	public static void main(String s[])
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("menu");

		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenu edit = new JMenu("edit");
		JMenu view = new JMenu("view");
		JMenu help = new JMenu("help");
		mb.add(file);
		mb.add(edit);	
		mb.add(view);
		mb.add(help);
		file.setFont(new Font("TNR",Font.BOLD,20));
		edit.setFont(new Font("TNR",Font.BOLD,20));
		view.setFont(new Font("TNR",Font.BOLD,20));
		help.setFont(new Font("TNR",Font.BOLD,20));
		
		frame.setJMenuBar(mb);
		frame.setVisible(true);
		frame.setSize(400,300);


		JMenuItem New = new JMenuItem("new");
		JMenuItem open = new JMenuItem("open");
		JMenuItem save = new JMenuItem("save");
		JMenuItem saveas = new JMenuItem("saveas");
		JMenuItem exit = new JMenuItem("EXIT");

		ImageIcon img = new ImageIcon(new ImageIcon("newlogo.jpg").getImage().getScaledInstance(20, 		20, Image.SCALE_SMOOTH));
		New.setIcon(img);
		New.setIconTextGap(10);
		open.setIcon(img);
		open.setIconTextGap(10);
		save.setIcon(img);
		save.setIconTextGap(10);
		saveas.setIcon(img);
		saveas.setIconTextGap(10);
		exit.setIcon(img);
		exit.setIconTextGap(10);
			
		file.add(New);
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.add(exit);
		

		JMenuItem undo = new JMenuItem("undo");
		JMenuItem cut = new JMenuItem("cut");
		JMenuItem copy = new JMenuItem("copy");
		JMenuItem paste = new JMenuItem("paste");
		JMenuItem delete = new JMenuItem("delete");
	
		undo.setIcon(img);
		undo.setIconTextGap(10);
		cut.setIcon(img);
		cut.setIconTextGap(10);
		copy.setIcon(img);
		copy.setIconTextGap(10);
		paste.setIcon(img);
		paste.setIconTextGap(10);
		delete.setIcon(img);
		delete.setIconTextGap(10);		

		edit.add(undo);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
	
		JMenuItem zoom = new JMenuItem("zoom");
		JMenuItem statusbar = new JMenuItem("Status_Bar");
		JMenuItem wordwrap = new JMenuItem("Word_Bar");
		
		zoom.setIcon(img);
		zoom.setIconTextGap(10);
		statusbar.setIcon(img);
		statusbar.setIconTextGap(10);
		wordwrap.setIcon(img);
		wordwrap.setIconTextGap(10);

	
		view.add(zoom);
		view.add(statusbar);
		view.add(wordwrap);

		
		

  	}
}