import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class TextEditor {
	public static void main(String[] args) {
		TextEditorMan tem = new TextEditorMan();
	}
}

class TextEditorMan implements ActionListener{
	JFrame frame;
	JButton btnOpen;
	JButton btnSave;
	JPanel panel;
	JScrollPane scrollPanel;
	JTextArea textArea;
	JTextField fileName;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	BufferedWriter bw;
	PrintWriter pw;


	public TextEditorMan (){
		frame = new JFrame("Window");
		frame.setLocation(400, 400);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnOpen = new JButton("OPEN");
		btnSave = new JButton("SAVE");


		btnOpen.setActionCommand("open");
		btnSave.setActionCommand("save");


		fieldpanel = new JPanel();
		fieldpanel.add(fileName);
		fieldpanel.add(btnOpen);
		fieldpanel.add(btnSave);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(fieldpanel);
		con.add(scrollPanel);

		frame.setVisible(true);
		/*frame = new JFrame("WINDOW");
		frame.setLocation(400, 400);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fileName = JTextField(ALOHA,15);
		btnOpen = new JButton("OPEN");
		btnSave = new JButton("SAVE");

		fieldPanel =new JPanel();
		fieldPanel.add(fileName);
		fieldpanel.add(btnOpen);
		fieldpanel.add(btnSave);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2,1));
		con.add(fieldPanel);

		frame.setVisible(true);*/

	}
}