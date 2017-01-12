public class ALOHA{
	public static void main(String[] args) {
		Alohaman am =new Alohaman();
		int nam=args.length;
		if (nam==0) {
			am.sayAloha();
		}else if (nam==1) {
			int arg1=Integer.parseInt(args[0]);
			am.sayAloha(arg1);
		}else if (nam==2) {
			int arg1=Integer.parseInt(args[0]);
			int arg2=Integer.parseInt(args[1]);
			am.sayAloha(arg1,arg2);
		}else if (nam>=3) {
			System.out.println("ERROR");
		}
		/*for (int i=0;i<20 ;i++ ) {
			if (i%3==0) {
				System.out.println("アロハ");
			}else{
				System.out.println("ALOHA");
			}
		}*/
	}
}
class Alohaman{
	private String msg;
	private String msg2;

	public Alohaman(){
		this.msg="ALOHA";
		this.msg2="アロハ";
	}
	public void sayAloha(){
		for (int i=0;i<10 ;i++ ) {
				System.out.println(msg);
			}
		}
	public void sayAloha(int n){
		for (int i=0;i<n ;i++ ) {
				System.out.println(msg);
			}
		}
	public void sayAloha(int n, int x){
		for (int i=0;i<n ;i++ ) {
			if (i%x==0) {
				System.out.println(msg2);
			}else{
				System.out.println(msg);
			}
		}
	}
}