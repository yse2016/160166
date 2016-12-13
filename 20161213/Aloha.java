public class Aloha {
	public static void main(String[] args) {
		String msg = args[0];
		for (int i=0;i<20 ;i++ ) {
			if (i%3==0) {
				System.out.println("アロハ！");
			}else{
				System.out.println(msg);
			}
		}
	}
}
