import  java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class ppap{
	public static void main(String[] args) {
		TextEditorMan tem = new TextEditorMan();
	}
}
class TextEditorMan implements ActionListener{
	JFrame frame;
	JPanel fieldpanel;
	JTextField fileName;
	JButton btnOpen;
	JButton btnSave;
	JTextArea textArea;
	JScrollPane scrollPane;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	PrintWriter pw;

	int num;
	int num2;
	String[] ppapdata=new String[10];

    JFileChooser filechooser = new JFileChooser();

	public TextEditorMan() {

	ppapdata[0]="pen";
	ppapdata[1]="pine";
	ppapdata[2]="apple";
	ppapdata[3]="PEN";
	ppapdata[4]="PINE";
	ppapdata[5]="APPLE";
	ppapdata[6]="Pen";
	ppapdata[7]="Pine";
	ppapdata[8]="Apple";
	ppapdata[9]="oh...";

		frame = new JFrame("Window");
		frame.setLocation(400, 400);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fileName = new JTextField("PPAP?",20);
		btnOpen=new JButton("PPAP");
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
				String textFileName = "PPAP.txt";
			num=(int)(Math.random()*10);
			num2=(int)(Math.random()*10);
			fileName.setText(ppapdata[num]+ppapdata[num2]);
			try{
				fr = new FileReader(textFileName);
				br = new BufferedReader(fr);

				String data;
				textArea.setText("");
				while ((data=br.readLine())!=null) {
					textArea.append(data + '\n');
				}
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