import java.io.*;
public class ALOHA {
	public static void main(String[] args) {
		System.out.println("ALOHA");
		Write w=new Write();
		String p;
		p = new java.util.Scanner( System.in ).nextLine();
		w.setp(p);
		String pa;
		pa= new java.util.Scanner( System.in ).nextLine();
		w.setpa(pa);
		w.main();

		String ppap= w.sayPPAP();
		System.out.println("oh.."+ppap);
	}
}

class Write{
	String p;
	String pa;
	String ppa;
	public void setp( String n ){
		this.p = n;
	}
	public void setpa( String n ){
		this.pa = n;
	}
	public void main() {
		try{
			File f=new File("PPAP.txt");
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			pw.println(p+pa);
			ppa=p+pa;
			pw.close();

		}catch (IOException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
	public String sayPPAP(){
		return this.ppa;
	}
}