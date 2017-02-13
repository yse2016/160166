import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class slot {
	public static void main(String[] args) {
		SlotMan tr=new SlotMan();
	}
}
class SlotMan implements ActionListener{
	JFrame frame;
	JPanel fieldpanel;
	JTextField fileName;
	JButton btnSpin;
	JButton btnIns;
	JTextArea textArea;
	JScrollPane scrollPane;
	JButton btnRnkup;
	JButton btnRnkdun;


		Random rnd = new Random();
		int coin =1000;
		int chage=0;
		int hit=0;
		int dice=4;
			int ranA1=1;
			int ranA2=2;
			int ranA3=3;
			int ranB1=4;
			int ranB2=5;
			int ranB3=6;
			int ranC1=7;
			int ranC2=8;
			int ranC3=9;

	int i;
	JButton btnOpen;
	JButton btnSave;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	PrintWriter pw;
    JFileChooser filechooser = new JFileChooser();

	public SlotMan(){
		frame = new JFrame("SlotMachine");
		frame.setLocation(400, 400);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fileName = new JTextField("please press INSERT BUTTON",20);
		btnOpen=new JButton("LOAD");
		btnSave=new JButton("SAVE");

		btnSpin=new JButton("SPIN");
		btnIns=new JButton("INSERT");
		btnRnkdun=new JButton("RankDOWN");
		btnRnkup=new JButton("RankUP");
		textArea=new JTextArea(4,30);
		scrollPane=new JScrollPane(textArea);

		fieldpanel = new JPanel();
		fieldpanel.add(fileName);
		fieldpanel.add(btnSpin);
		fieldpanel.add(btnIns);
			fieldpanel.add(btnRnkdun);
			fieldpanel.add(btnRnkup);
		btnOpen.setActionCommand("open");
		btnOpen.addActionListener(this);
		btnSave.setActionCommand("save");
		btnSave.addActionListener(this);
			btnSpin.setActionCommand("spin");
			btnSpin.addActionListener(this);
			btnIns.setActionCommand("insert");
			btnIns.addActionListener(this);
				btnRnkup.setActionCommand("up");
				btnRnkup.addActionListener(this);
				btnRnkdun.setActionCommand("down");
				btnRnkdun.addActionListener(this);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(fieldpanel);
		con.add(scrollPane);

		fieldpanel.add(btnOpen);
		fieldpanel.add(btnSave);

		fieldpanel.add(btnSpin);
		fieldpanel.add(btnIns);
		fieldpanel.add(btnRnkup);
		fieldpanel.add(btnRnkdun);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String cmd = ae.getActionCommand();
		if (cmd.equals("spin")) {
			hit=0;
			textArea.setText("");
			if (chage>=1) {
				ranA1 = rnd.nextInt(dice);
				ranA2 = rnd.nextInt(dice);
				ranA3 = rnd.nextInt(dice);
				textArea.append(ranA1+":"+ranA2+":"+ranA3+'\n');
			}
			if (chage>=2) {
				ranB1 = rnd.nextInt(dice);
				ranB2 = rnd.nextInt(dice);
				ranB3 = rnd.nextInt(dice);
				textArea.append(ranB1+":"+ranB2+":"+ranB3+'\n');
				ranC1 = rnd.nextInt(dice);
				ranC2 = rnd.nextInt(dice);
				ranC3 = rnd.nextInt(dice);
				textArea.append(ranC1+":"+ranC2+":"+ranC3+'\n');
			}
				if (ranA1==ranA2&&ranA2==ranA3&&chage>=1) {hit +=1;}
				if (ranB1==ranB2&&ranB2==ranB3&&chage>=2) {hit +=1;}
				if (ranC1==ranC2&&ranC2==ranC3&&chage>=2) {hit +=1;}
				if (ranA1==ranB2&&ranB2==ranC3&&chage>=3) {hit +=1;}
				if (ranC1==ranB2&&ranB2==ranA3&&chage>=3) {hit +=1;}
			coin +=hit*dice*dice/1.5;
			if (chage>0) {
				textArea.append("hit:"+hit);

			}else {
				textArea.append("press INSERT");
			}
			chage=0;
			ranA1=1;
			ranA2=2;
			ranA3=3;
			ranB1=4;
			ranB2=5;
			ranB3=6;
			ranC1=7;
			ranC2=8;
			ranC3=9;
		}else if (cmd.equals("insert")) {
			if (coin==0) {
				textArea.setText("Empty coin");
			}else if (chage<3) {
				coin -=1;
				chage +=1;
			}else{
				textArea.setText("MAXChage");
			}
		}else if (cmd.equals("up")) {
			dice +=1;
		}else if (cmd.equals("down")) {
			if (dice>1) {
				dice -=1;
			}else{
				textArea.setText("MINIMUM Rank");
			}
		}else if (cmd.equals("open")) {
		String textFileName = fileName.getText();

			JFileChooser fc=new JFileChooser();
			fc.setCurrentDirectory(new File("."));
			int ret=fc.showOpenDialog(frame);
			if(ret == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textFileName = file.getAbsolutePath();
					fileName.setText(textFileName);
				}
			try{
				fr = new FileReader(textFileName);
				br = new BufferedReader(fr);

				String data;
				while ((data=br.readLine())!=null) {
					fileName.setText(data);
				 i= Integer.parseInt(data);
				 coin =i;
					System.out.println(data+"data");
				}
				System.out.println(i+"int");
			}catch (IOException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		}else if (cmd.equals("save")) {
			String textFileName="";

			JFileChooser fc=new JFileChooser();
			fc.setCurrentDirectory(new File("."));
			int ret=fc.showSaveDialog(frame);
			if(ret == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textFileName = file.getAbsolutePath();
				}
			try{
				fw=new FileWriter(textFileName);
				pw=new PrintWriter(fw);
				String data= String.valueOf(coin);
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
		fileName.setText("coin@"+coin+"Chage@"+chage+"Rank"+dice);
	}
}