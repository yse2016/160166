import java.io.*;
public class ShowText {
	public static void main(String[] args) {
		try{
			FileReader fr=null;
			BufferedReader in=null;
			fr=new FileReader("data.txt");
			in=new BufferedReader(fr);

			while(true){
				String data=in.readLine();
				if (data==null) {
					break;
				}
				System.out.println(data);
			}
			in.close();
		}catch (IOException e) {
			System.err.println("ERROR");
		}
	}
}