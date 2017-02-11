import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class WheelofFortune {
	public static void main(String[] args) {
		RouletteMan tr=new RouletteMan();
	}
}
class RouletteMan implements ActionListener{
	JFrame frame;
	JPanel fieldpanel;
	JTextField fileName;
	JButton btnOpen;
	JButton btnSave;
	JButton btnSpin;
	JButton btnbet;
	JTextArea textArea;
	JScrollPane scrollPane;


	JButton btn1dollar;
	JButton btn2dollar;
	JButton btn5dollar;
	JButton btn10dollar;
	JButton btn20dollar;
	JButton btnJOKER;
	JButton btnFLAG;
	int bet=0;
		Random rnd = new Random();
		int rand=0;
		int max=54;

		int coin =1000;
		int chage=0;
		int hit=0;


	int i;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	PrintWriter pw;
    JFileChooser filechooser = new JFileChooser();

	public RouletteMan(){
		frame = new JFrame("rouletteMachine");
		frame.setLocation(400, 400);
		frame.setSize(470, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fileName = new JTextField("please press BET BUTTON",15);
		btnOpen=new JButton("LOAD");
		btnSave=new JButton("SAVE");
		btnSpin=new JButton("SPIN");
		btnbet=new JButton("BET");


			btn1dollar=new JButton("1$");
			btn2dollar=new JButton("2$");
			btn5dollar=new JButton("5$");
			btn10dollar=new JButton("10$");
			btn20dollar=new JButton("20$");
			btnJOKER=new JButton("JOKER");
			btnFLAG=new JButton("FLAG");

		textArea=new JTextArea(10,30);
		scrollPane=new JScrollPane(textArea);

		fieldpanel = new JPanel();
		fieldpanel.add(fileName);
			fieldpanel.add(btnOpen);
			fieldpanel.add(btnSave);
			fieldpanel.add(btnSpin);
			fieldpanel.add(btnbet);

				fieldpanel.add(btn1dollar);
				fieldpanel.add(btn2dollar);
				fieldpanel.add(btn5dollar);
				fieldpanel.add(btn10dollar);
				fieldpanel.add(btn20dollar);
				fieldpanel.add(btnJOKER);
				fieldpanel.add(btnFLAG);
		btnOpen.setActionCommand("open");
		btnOpen.addActionListener(this);
		btnSave.setActionCommand("save");
		btnSave.addActionListener(this);
		btnSpin.setActionCommand("spin");
		btnSpin.addActionListener(this);
		btnbet.setActionCommand("BET");
		btnbet.addActionListener(this);
			btn1dollar.setActionCommand("1");
			btn1dollar.addActionListener(this);
			btn2dollar.setActionCommand("2");
			btn2dollar.addActionListener(this);
			btn5dollar.setActionCommand("5");
			btn5dollar.addActionListener(this);
			btn10dollar.setActionCommand("10");
			btn10dollar.addActionListener(this);
			btn20dollar.setActionCommand("20");
			btn20dollar.addActionListener(this);
			btnJOKER.setActionCommand("J");
			btnJOKER.addActionListener(this);
			btnFLAG.setActionCommand("F");
			btnFLAG.addActionListener(this);
		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add(fieldpanel);
		con.add(scrollPane);


		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String cmd = ae.getActionCommand();
		if (cmd.equals("spin")) {
			hit=0;
			textArea.setText("");
			rand = rnd.nextInt(max);
			System.out.println(rand);

			if (bet==0) {
				textArea.append("SELECT BET");

			}else{
				if (rand<=23&&bet==1) {
					hit =chage*2;
				}else if (rand>23&&rand<=38&&bet==2) {
					hit =chage*3;
				}else if (rand>38&&rand<=46&&bet==3) {
					hit =chage*6;
				}else if (rand>46&&rand<=50&&bet==4) {
					hit =chage*11;
				}else if (rand>50&&rand<=52&&bet==5) {
					hit =chage*21;
				}else if (rand>52&&rand<=53&&bet==6) {
					hit =chage*41;
				}else if (rand>53&&rand<=54&&bet==7) {
					hit =chage*41;
				}
				textArea.append("Return:"+hit+"coin");
				coin+=hit;

			}
			chage=0;
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
			String textFileName = fileName.getText();

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
		}else if (cmd.equals("BET")) {
			if (bet==0) {
				textArea.setText("SELECT BET");
			}else {
				coin -=1;
				chage +=1;
			}
		}
		if (bet==0) {
			if (cmd.equals("1")) {
				bet =1;
				chage +=1;
				coin -=1;
				textArea.setText("SELECT 1$");
			}else if (cmd.equals("2")) {
				bet =2;
				chage +=1;
				coin -=1;
				textArea.setText("SELECT 1$");
			}else if (cmd.equals("5")) {
				bet =3;
				chage +=1;
				coin -=1;
				textArea.setText("SELECT 5$");
			}else if (cmd.equals("10")) {
				bet =4;
				chage +=1;
				coin -=1;
				textArea.setText("SELECT 10$");
			}else if (cmd.equals("20")) {
				bet =5;
				chage +=1;
				coin -=1;
				textArea.setText("SELECT 20$");
			}else if (cmd.equals("J")) {
				bet =6;
				chage +=1;
				coin -=1;
				textArea.setText("SELECT FLAG");
			}else if (cmd.equals("F")) {
				bet =7;
				chage +=1;
				coin -=1;
				textArea.setText("SELECT JOKER");
			}
		}
		fileName.setText("coin@"+coin+"Chage@"+chage);
	}
}