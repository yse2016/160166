import javax.swing.*;
import java.awt.event.*;

public class SwingTest extends JFrame implements ActionListener{
  JLabel label;

  public static void main(String[] args){
    SwingTest test = new SwingTest("SwingTest");

    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    test.setVisible(true);
  }

  SwingTest(String title){
    setTitle(title);
    setBounds( 10, 10, 300, 200);

    label = new JLabel("");

    JButton btn = new JButton("Push");
    btn.addActionListener(this);

    JPanel p = new JPanel();
    p.add(label);
    p.add(btn);

    getContentPane().add(p);
  }

  public void actionPerformed(ActionEvent e){
    label.setText("Push");
  }
}