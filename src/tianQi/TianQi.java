package tianQi;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TianQi {
	public static void json() throws Exception{
		//����url��
		String city = java.net.URLEncoder.encode("����", "utf-8");
		
		//ƴ��ַ
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
		//��ʼ����
		URL url= new URL(apiUrl);
		URLConnection open = url.openConnection();
		System.out.println(open);
		InputStream input = open.getInputStream();
//		System.out.println(input);
		//����ת��ΪString�����ϰ����������������
		String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
		//���
		System.out.println(result);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		json();
	}
}
