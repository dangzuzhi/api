package urlApi;
 
import java.io.BufferedInputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.Reader; 
import java.net.URL; 
import java.net.URLConnection; 

public class TextURL { 
/* 
* ��ȡurlָ������Դ 
*/ 
public static void getImageResourceByURL(String imagesFile) throws IOException{ 
URL url = new URL(imagesFile); 
Object obj = url.getContent();//���url���� 
System.out.print(obj.getClass().getName());//��ʾ���� 
} 
/* 
* ��ȡurlָ������Դ 
*/ 
public static void getHtmlResourceByURL(String htmlFile) throws IOException{ 
URL url = new URL(htmlFile); 
URLConnection us = url.openConnection();//����Զ�����Ӷ��� 
InputStream in = us.getInputStream();//�����Ӷ�ȡ�������� 
int c; 
while((c=in.read())!=-1){ 
System.out.print((char)c); 
} 
System.out.println(); 
in.close(); 
} 
/* 
* ��ȡurlָ������ҳ��Դ 
*/ 
public static void getHTMLResource(String htmlFile) throws IOException{ 
URL url = new URL(htmlFile);//����URL���� 
Reader reader = new InputStreamReader(//��URL����,����һ�������� 
new BufferedInputStream(url.openStream())); 
int c; 
while((c = reader.read())!=-1){ 
System.out.print((char)c); 
} 
System.out.println(); 
reader.close(); 
} 
/* 
* ��ȡurlָ������ҳ��Դ 
*/ 
public static void getResourceOfHTML(String htmlFile) throws IOException{ 
URL url = new URL(htmlFile); 
InputStream in = url.openStream();//��url���Ӵ��������� 
int c; 
while((c = in.read()) !=-1){ 
System.out.print((char)c); 
} 
System.out.println(); 
in.close(); 
} 
/* 
* java��֧�ֵ�url���� 
*/ 
public static void supportURLType(String host,String file) { 
String[] schemes = {"url","http","mailto","jdbc","telnet","ftp","netdoc"}; 
for(int i=0; i < schemes.length; i++){ 
try { 
URL url = new URL(schemes[i], host, file); 
System.out.println(schemes[i]+"��java��֧�ֵ�URL����rn"); 
} catch (Exception e) { 
System.out.println(schemes[i]+"����java֧�ֵ�URL����rn"); 
} 
} 
} 
public static void main(String[] args) throws IOException { 
String imageFile ="https://gw.alicdn.com/tfs/TB1GxwdSXXXXXa.aXXXXXXXXXXX-65-70.gif"; 
String htmlFile ="https://www.aliyun.com/jiaocheng/531531.html"; 
String hostFile ="http://image.baidu.com/channel/wallpaper"; 
String file ="/1753.4.html"; 
//System.out.println("1.��ȡURLͼ����Դ��Ϣ"); 
getImageResourceByURL("https://gw.alicdn.com/tfs/TB1GxwdSXXXXXa.aXXXXXXXXXXX-65-70.gif"); 
System.out.println(); 
//System.out.println("2.��ȡURLָ����HTML��ҳ��Դ��Ϣ"); 
//getHtmlResourceByURL(htmlFile); 
//System.out.println("3.����URL�����ö����ȡ��ҳ����"); 
//getHTMLResource(hostFile); 
//System.out.println("4.����URL������������ȡ��ҳ����"); 
//getResourceOfHTML(htmlFile); 
System.out.println("5.�ж�java��֧�ֵ�url����"); 
supportURLType(hostFile, file); 
} 
}