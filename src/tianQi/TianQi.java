package tianQi;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TianQi {
	public static void json() throws Exception{
		//参数url化
		String city = java.net.URLEncoder.encode("北京", "utf-8");
		
		//拼地址
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
		//开始请求
		URL url= new URL(apiUrl);
		URLConnection open = url.openConnection();
		System.out.println(open);
		InputStream input = open.getInputStream();
//		System.out.println(input);
		//这里转换为String，带上包名，怕你们引错包
		String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
		//输出
		System.out.println(result);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		json();
	}
}
