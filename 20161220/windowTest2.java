import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class windowTest2{
	public static void main(String[] args) {
		FrameMan fm=new FrameMan();
		fm.start();
	}
}
class FrameMan implements ActionListener{
		JFrame frame;
		JLabel label;
		JPanel panel;
		JPanel panel2;
		JButton button;
		JTextField textfield;

	public void start(){

		frame = new JFrame("FrameMan");
		frame.setBounds(50,50,300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		panel = new JPanel();
		panel2 = new JPanel();
		label = new JLabel("Hello");
		button = new JButton("push");
    	textfield= new JTextField(10);

		button.addActionListener(this);

		panel.add(textfield);
		panel.add(button);
		panel2.add(label);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);

		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		String data = textfield.getText();
		label.setText(data);
	}
}