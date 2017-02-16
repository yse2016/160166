import java.util.HashMap;
public class aloha2{
	public static void main(String[] args) {
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("Ikarasi","takatu");
		hm.put("hoge","hage");

		String val=hm.get("hoge");
		System.out.println("hoge="+val);

		hm.put(args[0],args[1]);
		String val2=hm.get(args[0]);
		System.out.println("args[0]="+val2);

		hm.forEach((k,va)-> System.out.println(k+":"+va));
	}
}