import  java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class AlohaWindow{
	public static void main(String[] args) {
		AlohaWindowMan awm = new AlohaWindowMan();
	}
}
class AlohaWindowMan implements ActionListener{
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


	public AlohaWindowMan() {
		frame = new JFrame("AlohaWindow");
		frame.setLocation(400, 400);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnOpen = new JButton("OPEN");
		btnSave = new JButton("SAVE");
		fileName = new JTextField("ALOHA", 20);
		textArea = new JTextArea(10, 30);
		scrollPanel = new JScrollPane(textArea);

		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);
		btnOpen.setActionCommand("open");
		btnSave.setActionCommand("save");


		panel = new JPanel();
		panel.add(fileName);
		panel.add(btnOpen);
		panel.add(btnSave);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(panel);
		con.add(scrollPanel);

		frame.setVisible(true);

	}
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		if (cmd.equals("open")) {
			try{
				String textFile = fileName.getText();
				fr = new FileReader(textFile);
				br = new BufferedReader(fr);

				String data= br.readLine();
				/*while ((data=br.readLine())!=null) {
					textArea.append(data + '\n');
				}*/
				textArea.setText(data);
			}catch (Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		}else if (cmd.equals("save")) {
			fileName.setText("SAVE");
			textArea.setText("hello");
			/*try{
			String textFile = fileName.getText();
			fw=new FileWriter(textFile);
			bw=new BufferedWriter(fw);
			pw=new PrintWriter(bw);
			String data = pw.println(setText);
			pw.close();
			}catch (IOException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}*/
		}
	}
}