import  java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AlohaWindow{
	public static void main(String[] args) {
		AlohaWindowMan awm = new AlohaWindowMan();
	}
}
class AlohaWindowMan {
	JFrame frame;
	JButton button;
	JPanel panel;
	JTextField fileNameField;

	public AlohaWindowMan() {
		frame = new JFrame("AlohaWindow");
		frame.setLocation(400, 400);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("Click Me!");
		fileNameField = new JTextField("ALOHA", 20);

		panel = new JPanel();
		panel.add(fileNameField);
		panel.add(button);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(panel);

		frame.setVisible(true);

	}
			public void ActionPerformed(ActionEvent ae) {
			fileNameField.setText("Hello");
	}
}