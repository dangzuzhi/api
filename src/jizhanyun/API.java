package jizhanyun;

/**
* @(#)jizhanyun.com for java
*
* ��վ��ƽ̨�ӿ���ʾFOR JAVA
*
* @��վ��
* @version 1.00
*/
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class API {
   
   public static String apikey    = "1ATS2C6D9FFF0825DA88B864A3D1E034"; //apikey ��վ��ƽ̨��ȡ
   public static String mnc       = "1";                                //mnc
   public static String lac       = "14608";                            //lac
   public static String cell      = "60541";                            //cell

   public static String getWebData(String domain) {
       StringBuffer sb = new StringBuffer();
       InputStream is = null;
       InputStreamReader isr = null;
       BufferedReader in = null;
       try {
           java.net.URL url = new java.net.URL(domain);
           is = url.openStream();
           isr = new InputStreamReader(is,"utf-8");
           in = new BufferedReader(isr);
           String line;
           while ((line = in.readLine()) != null) {
               sb.append(line).append("\n");
           }
           in.close();
           
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           try {
               if(in!=null){
                   in.close();
                   in=null;
               }
               if(isr!=null){
                   isr.close();
                   isr=null;
               }
               if(is!=null){
                   is.close();
                   is=null;
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return sb.toString();
   }
   
   public static void main(String[] args) {
       String data=getWebData("http://www.jizhanyun.com/api/?mnc="+mnc+"&lac="+lac+"&cell="+cell+"&ishex=10&type=1&apikey="+apikey);
       String code="";
       String about="";
       String lng="";
       String lat="";
       String glng="";
       String glat="";
       String address="";
       if(data!=""){
           String[] arr=data.split("\\|");
           code=arr[0];
           if(code.equals("001")){
               lng=arr[2];
               lat=arr[3];
               glng=arr[4];
               glat=arr[5];
               address=arr[6];
           }else{
               about=arr[1];
           }
       }
       
       System.out.println("״̬��"+code);
       System.out.println("˵����"+about);
       System.out.println("���ȣ�"+lng);
       System.out.println("γ�ȣ�"+lat);
       System.out.println("�ȸ��ͼ���ȣ�"+glng);
       System.out.println("�ȸ��ͼ���ȣ�"+glat);
       System.out.println("��ַ��"+address);


   }
}
