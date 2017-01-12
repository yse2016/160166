public class ALOHA{
	public static void main(String[] args) {
		Alohaman am =new Alohaman();
		am.sayAloha(20);
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
	public void sayAloha(int n){
		for (int i=0;i<n ;i++ ) {
		System.out.println(msg);
		}
	}
}