import  java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
	
public class roulette{
	public static void main(String[] args) {
		rouletteMan tem = new rouletteMan();
	}
}
class rouletteMan implements ActionListener{
	JFrame frame;
	JPanel fieldpanel;
	JTextField saveData;
	JButton btnOpen;
	JButton btnSave;
	JTextArea textArea;
	JScrollPane scrollPane;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	PrintWriter pw;
    JFileChooser filechooser = new JFileChooser();

	public rouletteMan() {

		frame = new JFrame("Window");
		frame.setLocation(400, 400);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		saveData = new JTextField("LOAD",20);
		btnOpen=new JButton("LOAD");
		btnSave=new JButton("SAVE");
		textArea=new JTextArea(10,30);
		scrollPane=new JScrollPane(textArea);

		fieldpanel = new JPanel();
		fieldpanel.add(saveData);
		fieldpanel.add(btnOpen);
		fieldpanel.add(btnSave);

		btnOpen.setActionCommand("open");
		btnOpen.addActionListener(this);
		btnSave.setActionCommand("save");
		btnSave.addActionListener(this);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(fieldpanel);
		con.add(scrollPane);

		fieldpanel.add(btnOpen);
		fieldpanel.add(btnSave);


		frame.setVisible(true);
}
public void actionPerformed(ActionEvent ae){
		String cmd = ae.getActionCommand();
		if (cmd.equals("open")) {
		String textFileName = saveData.getText();

			JFileChooser fc=new JFileChooser();
			fc.setCurrentDirectory(new File("."));
			int ret=fc.showOpenDialog(frame);
			if(ret == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textFileName = file.getAbsolutePath();
					saveData.setText(textFileName);
				}
			try{
				fr = new FileReader(textFileName);
				br = new BufferedReader(fr);

				String data;
				while ((data=br.readLine())!=null) {
					saveData.setText(data);
				}
				System.out.println(data);
			}catch (IOException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		}else if (cmd.equals("save")) {
			String textFileName = saveData.getText();

			JFileChooser fc=new JFileChooser();
			fc.setCurrentDirectory(new File("."));
			int ret=fc.showSaveDialog(frame);
			if(ret == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textFileName = file.getAbsolutePath();
					saveData.setText(textFileName);
				}
			try{
				fw=new FileWriter(textFileName);
				pw=new PrintWriter(fw);
				String data=textArea.getText();
				pw.println(data);

			}catch (IOException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			} finally {
				try{
					fw.close();
					pw.close();
				}catch (IOException e) {
					System.out.println("ERROR");
					e.printStackTrace();
				}
			}
		}
	}
}