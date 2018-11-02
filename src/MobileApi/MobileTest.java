package MobileApi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;

public class MobileTest {
    private int mts;
    private String province;
    private String catName;
    private String telString;
    private int areaVid;
    private int ispVid;
    private String carrier;
 
    public int getMts() {
        return mts;
    }
 
    public void setMts(int mts) {
        this.mts = mts;
    }
 
    public String getProvince() {
        return province;
    }
 
    public void setProvince(String province) {
        this.province = province;
    }
 
    public String getCatName() {
        return catName;
    }
 
    public void setCatName(String catName) {
        this.catName = catName;
    }
 
    public String getTelString() {
        return telString;
    }
 
    public void setTelString(String telString) {
        this.telString = telString;
    }
 
    public int getAreaVid() {
        return areaVid;
    }
 
    public void setAreaVid(int areaVid) {
        this.areaVid = areaVid;
    }
 
    public int getIspVid() {
        return ispVid;
    }
 
    public void setIspVid(int ispVid) {
        this.ispVid = ispVid;
    }
 
    public String getCarrier() {
        return carrier;
    }
 
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    
    public static String calcMobileCity(String mobileNumber) throws MalformedURLException {
    	 
        //��ȡ��������API��ַ 
//                String urlString = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?mobile="
//                        + mobileNumber + "&amount=10000&callname=getPhoneNumInfoExtCallback";
        //�Ա�����API��ַ
        String urlString = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="
                + mobileNumber;
 
        StringBuffer sb = new StringBuffer();
        BufferedReader buffer;
        URL url = new URL(urlString);
        String province = "";
        try {
            //��ȡURL��ַ�е�ҳ������ 
            InputStream in = url.openStream();
            // ����������� 
            buffer = new BufferedReader(new InputStreamReader(in, "gb2312"));
            String line = null;
            //һ��һ�еĶ�ȡ���� 
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
            in.close();
            buffer.close();
            System.out.println(sb.toString());
            //�������ֲ�ͬ��ʽ���ַ���
            //   __GetZoneResult_ = {    mts:'1594578',    province:'������',    catName:'�й��ƶ�',    telString:'15945782060',    areaVid:'30496',    ispVid:'3236139',   carrier:'�������ƶ�'}
            String objectStr = "{\"mts\":\"1594578\",\"province\":\"������\",\"catName\":\"�й��ƶ�\",\"telString\":\"15945782060\",\"areaVid\":\"30496\",\"ispVid\":\"3236139\",\"carrier\":\"�������ƶ�\"}";
            //1��ʹ��JSONObject
            JSONObject jsonObject2 = JSONObject.fromObject(objectStr);
            String pro1 = jsonObject2.getString("province");
//            System.out.println(pro1);
            MobileTest stu = (MobileTest) JSONObject.toBean(jsonObject2, MobileTest.class);
            province = stu.getProvince();
//            System.out.println(province);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        //��JSONObject�����ж�ȡ�������� 
        return province/*jsonObject.getString("cityname")*/;
    }
    
    public static void main(String[] args) throws MalformedURLException {
				try {
					calcMobileCity("13476292989");
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
}

