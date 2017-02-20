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


	int[] dataint;
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

		textArea=new JTextArea(4,20);
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

			}else if (chage==0) {
				textArea.append("Chage BET");

			}else{
				if (rand<=23) {
					if (bet==1) {
					hit =chage*2;
					}
					textArea.append("HIT 1$");
				}else if (rand>23&&rand<=38) {
					if (bet==2) {
					hit =chage*3;
					}
					textArea.append("HIT 2$");
				}else if (rand>38&&rand<=46) {
					if (bet==3) {
					hit =chage*6;
					}
					textArea.append("HIT 5$");
				}else if (rand>46&&rand<=50) {
					if (bet==4) {
					hit =chage*11;
					}
					textArea.append("HIT 10$");
				}else if (rand>50&&rand<=52) {
					if (bet==5) {
					hit =chage*21;
					}
					textArea.append("HIT 20$");
				}else if (rand>52&&rand<=53) {
					if (bet==6) {
					hit =chage*41;
					}
					textArea.append("HIT JOKER");
				}else if (rand>53&&rand<=54) {
					if (bet==7) {
					hit =chage*41;
					}
					textArea.append("HIT FLAG");
				}
				textArea.append("  Return:"+hit+"coin");
				coin+=hit;

			}
			chage=0;
			bet=0;
		}else if (cmd.equals("open")) {
		String textFileName = fileName.getText();

			JFileChooser fc=new JFileChooser();
			fc.setCurrentDirectory(new File("."));
			int ret=fc.showOpenDialog(frame);
			if(ret == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textFileName = file.getAbsolutePath();
				}
			try{
				fr = new FileReader(textFileName);
				br = new BufferedReader(fr);

				String data;
				while ((data=br.readLine())!=null) {
					System.out.println(data+":data");
					data=data.replace("O","0");
					data=data.replace("l","1");
					data=data.replace("z","2");
					data=data.replace("E","3");
					data=data.replace("Z","5");
					data=data.replace("k","4");
					data=data.replace("b","6");
					data=data.replace("T","7");
					data=data.replace("R","8");
					data=data.replace("Q","9");
					String[] savedata=data.split(":");
					int dataint1= Integer.parseInt(savedata[0]);
					int dataint2= Integer.parseInt(savedata[1]);
					int dataint3= Integer.parseInt(savedata[2]);
					if (dataint1%3==0&&dataint2%5==0&&dataint3%7==0) {
						if (dataint1/3==dataint2/5&&dataint2/5==dataint3/7) {
						coin =dataint1/3;
						System.out.println("OK");
						}else{System.out.println("ERROR");}
					}else{System.out.println("ERROR");}
				System.out.println(dataint1/3+"&"+dataint2/5+"&"+dataint3/7+":int");
				}
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
				String[] data = new String[3];
				data[0]= String.valueOf(coin*3);
				data[1]= String.valueOf(coin*5);
				data[2]= String.valueOf(coin*7);
	for (int i=0;i<3 ;i++ ) {
				data[i]=data[i].replace("0","O");
				data[i]=data[i].replace("1","l");
				data[i]=data[i].replace("2","z");
				data[i]=data[i].replace("3","E");
				data[i]=data[i].replace("4","k");
				data[i]=data[i].replace("5","Z");
				data[i]=data[i].replace("6","b");
				data[i]=data[i].replace("7","T");
				data[i]=data[i].replace("8","R");
				data[i]=data[i].replace("9","Q");
				System.out.println(data[i]);
	}

				pw.println(data[0]+":"+data[1]+":"+data[2]);

			}catch (IOException e) {
				System.out.println("ERROR1");
				e.printStackTrace();
			} finally {
				try{
					fw.close();
					pw.close();
				}catch (IOException e) {
					System.out.println("ERROR2");
					e.printStackTrace();
				}
			}
		}else if (cmd.equals("BET")) {
			if (coin==0) {
				textArea.setText("Empty coin");
			}else if (bet==0) {
				textArea.setText("SELECT BET");
			}else {
				coin -=1;
				chage +=1;
			}
		}
			if (cmd.equals("1")) {
				bet =1;
				textArea.setText("SELECT 1$");
			}else if (cmd.equals("2")) {
				bet =2;
				textArea.setText("SELECT 2$");
			}else if (cmd.equals("5")) {
				bet =3;
				textArea.setText("SELECT 5$");
			}else if (cmd.equals("10")) {
				bet =4;
				textArea.setText("SELECT 10$");
			}else if (cmd.equals("20")) {
				bet =5;
				textArea.setText("SELECT 20$");
			}else if (cmd.equals("J")) {
				bet =6;
				textArea.setText("SELECT JOKER");
			}else if (cmd.equals("F")) {
				bet =7;
				textArea.setText("SELECT FLAG");
			}
		fileName.setText("coin@"+coin+"Chage@"+chage);
	}
}