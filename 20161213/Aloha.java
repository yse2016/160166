public class Aloha {
	public static void main(String[] args) {
		int frg=1;
		while (frg==1) {
			System.out.print("main :");
			String msg = new java.util.Scanner(System.in).nextLine();
			System.out.print("sub :");
			String msg2 = new java.util.Scanner(System.in).nextLine();
			if (msg.equals("exit")||msg2.equals("exit")) {
				frg=0;
			}else{
				for (int i=0;i<20 ;i++ ) {
					if (i%3==0) {
						System.out.println(msg2);
					}else{
						System.out.println(msg);
					}
				}
			}
		}
	}
}
