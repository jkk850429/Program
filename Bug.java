import java.io.*;
import java.util.regex.*;
import java.net.*;                                      //regular expression
class Bug{
    public static void main(String[] argv)throws Exception{
	    //get();
		getURL();
	}
	public static void getURL() throws Exception{                //爬網頁
	    URL url = new URL("http://bigocheatsheet.com/");
		URLConnection conn = url.openConnection();
		
        InputStreamReader ISR = new InputStreamReader(conn.getInputStream());
		BufferedReader br1 = new BufferedReader(ISR);
		
		String s = null;
		String mailreg = "\\w+sort";
		Pattern p = Pattern.compile(mailreg);   //以Pattern物件設定Regular expression, 以Matcher物件來找尋所需的資料
		
		while((s=br1.readLine())!=null){
		    Matcher m = p.matcher(s);
			while(m.find()){
				System.out.println(m.group());
			}
		}
	}
	public static void get() throws Exception{                //爬文字檔
	    FileReader input = new FileReader("test.txt");
		BufferedReader br = new BufferedReader(input);
		String s = null;
		String mailreg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(mailreg);   //以Pattern物件設定Regular expression, 以Matcher物件來找尋所需的資料
		
		while((s=br.readLine())!=null){
		    Matcher m = p.matcher(s);
			while(m.find()){
				System.out.println(m.group());
			}
		}
	}
}