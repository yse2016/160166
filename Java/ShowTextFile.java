import java.io.*;
public class ShowTextFile{
	public static void main(String[] args) {
		String name=args[0];
		FileReader in= null;
		try{
			in =new FileReader(name);
			int d=0;
			while((d = in.read()) != -1){
				System.out.print((char)d);
			}
			System.out.println("end");
		}catch (IOException e) {
			System.out.println("IO ERROR");
		}finally{
			try{
				in.close();
			}catch (IOException e) {
				System.out.println("ERROR");
			}
		}
	}
}