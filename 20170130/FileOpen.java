

//############################################################

//BufferedReader b_reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class FileOpen {
	public static void main(String[] args) {
		TextReaderman tr=new TextReaderman();
	}
}
class TextReaderman implements ActionListener{
	JFrame frame;
	JPanel fieldpanel;
	JTextField fileName;
	JButton btnOpen;
	JButton btnSave;
	JTextArea textArea;
	JScrollPane scrollPane;
		File inFile;
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader br;
	FileWriter fw;
	PrintWriter pw;
		Random rnd = new Random();

		List<String> list = new ArrayList<String>();
	public TextReaderman(){
		frame = new JFrame("Window");
		frame.setLocation(400, 400);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fileName = new JTextField("ALOHA",20);
		btnOpen=new JButton("OPEN");
		btnSave=new JButton("SAVE");
		textArea=new JTextArea(10,30);
		scrollPane=new JScrollPane(textArea);

		fieldpanel = new JPanel();
		fieldpanel.add(fileName);
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
			inFile = new File("words.txt");
			try{
				fis = new FileInputStream(inFile);
				isr = new InputStreamReader(fis, "UTF-8");
				br = new BufferedReader(isr);
				String data;
				while ((data=br.readLine())!=null) {
					list.add(data);
				}
				int ran = rnd.nextInt(list.size()+1);
				int ran2 = rnd.nextInt(list.size()+1);

					System.out.println( list.get(ran));
					System.out.println( list.get(ran2));
					fileName.setText(list.get(ran)+' '+list.get(ran2));
			}catch (IOException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		}else if (cmd.equals("save")) {
			String textFileName = fileName.getText();

			JFileChooser fc=new JFileChooser();
			fc.setCurrentDirectory(new File("."));
			int ret=fc.showSaveDialog(frame);
			if(ret == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textFileName = file.getAbsolutePath();
					fileName.setText(textFileName);
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