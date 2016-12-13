public class Aloha {
	public static void main(String[] args) {
		String msg = args[0];
		String msg2 = args[1];
		for (int i=0;i<20 ;i++ ) {
			if (i%3==0) {
				System.out.println(msg2);
			}else{
				System.out.println(msg);
			}
		}
	}
}
