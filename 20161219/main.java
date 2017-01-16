import  java.awt.FlowLayout;
import javax.swing.*;
public class main{
	public static void main(String[] args) {
		JFrame frame = new JFrame("GUItest");
		JLabel label = new JLabel("Hello world");
		JButton button = new JButton("push");
		JLabel label2 = new JLabel("Aloha");
		JButton button2 = new JButton("push!");
		JLabel label3 = new JLabel("Aloha!");
		JButton button3 = new JButton("push!!");
		JLabel label4 = new JLabel("ALOHA");
		JButton button4 = new JButton("PUuuuuuuuush!!!");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(button);
		frame.getContentPane().add(label);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(button3);
		frame.getContentPane().add(label3);
		frame.getContentPane().add(button4);
		frame.getContentPane().add(label4);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		frame.setVisible(true);
	}
}