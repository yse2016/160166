import java.io.*;
public class CopyByteFile{
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
			String img1 ="hage.jpg";
			String img2 ="hoge.jpg";
			String img="hage.bmp";
			in = new FileInputStream(img);
			out = new FileOutputStream("tgt.jpg");
			int d;
			int i=0;
			while((d = in.read()) != -1){
				if (i<20000) {
				System.out.println(i);
					img=img1;
				}else {
				System.out.println(i+"!");
					img=img2;
				}
				out.write(d);
				i++;
			}
			System.out.println("end copy");
		}catch (IOException e) {
			System.out.println("IO ERROR");
		}finally{
			try{
				in.close();
				out.close();
			}catch (IOException e) {
				System.out.println("ERROR");
			}
		}
	}
}