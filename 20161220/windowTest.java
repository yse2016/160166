import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class windowTest{
	public static void main(String[] args) {
		FrameMan fm=new FrameMan();
		fm.start();
	}
}
class FrameMan implements ActionListener{
		JFrame frame;
		JLabel label;
		JPanel panel;
		JButton button;

	public void start(){

		frame = new JFrame("FrameMan");
		frame.setBounds(50,50,300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		panel = new JPanel();
		label = new JLabel("Hello");
		button = new JButton("push");

		button.addActionListener(this);

		frame.add(label);
		frame.add(button);
		frame.add(panel);

		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		label.setText("ALOHA!");
	}
}