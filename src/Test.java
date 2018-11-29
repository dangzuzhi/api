/*
 * Copyright 2018 textile.com All right reserved. This software is the
 * confidential and proprietary information of textile.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with textile.com.
 */

//test
import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
//update Test
/**
 * @fileName com.bxm.advertisercmsaaa.java
 * @CopyRright (c) 2017-bxm������΢�ƿƼ����޹�˾
 * @date 2018��3��9�� ����10:40:36
 * @author chzq
 */
public class Test {

    /**
     * @date 2018��3��9�� ����10:40:40
     * @param args
     * @author chzq
     */
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder(
                "https://buy.bianxianmao.com/shop/countInfo");
        Map<String, String> params = new HashMap<String, String>();
        params.put("bxm_id", "ǰ�˴�������bxm_de��ֵ");
        params.put("status","1");//�̶�ֵ
        params.put("modeltype", "7");//�̶�ֵ
        String result1 = GetPostUrl(sb.toString(), params, "GET",null, 0, 0);
        System.out.println(result1);
        
    }

    public static String GetPostUrl(String sendUrl, Map<String, String> params, String sendType, String charset,
            int repeat_request_count, int repeat_request_max_count) {
        URL url = null;
        HttpURLConnection httpurlconnection = null;

        try {
            // �����������
            StringBuffer paramSb = new StringBuffer();
            if (params != null) {
                for (java.util.Map.Entry<String, String> e : params.entrySet()) {
                    paramSb.append(e.getKey());
                    paramSb.append("=");
                    // ������ֵurlEncode����,��ֹ����������
                    paramSb.append(URLEncoder.encode(e.getValue(), "UTF-8"));
                    paramSb.append("&");
                }
                paramSb.substring(0, paramSb.length() - 1);
            }
            url = new URL(sendUrl + "?" + paramSb.toString());
            httpurlconnection = (HttpURLConnection) url.openConnection();
            httpurlconnection.setRequestMethod("GET");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);

            // ����http����ʱʱ��30000���루30�룩
            httpurlconnection.setConnectTimeout(30000);
            httpurlconnection.setReadTimeout(30000);
            httpurlconnection.setUseCaches(true);
            /*
             * if (submitMethod.equalsIgnoreCase("POST")) {
             * httpurlconnection.getOutputStream().write(postData.getBytes("GBK"
             * )); httpurlconnection.getOutputStream().flush();
             * httpurlconnection.getOutputStream().close(); }
             */

            int code = httpurlconnection.getResponseCode();
            if (code == 200) {
                DataInputStream in = new DataInputStream(httpurlconnection.getInputStream());
                int len = in.available();
                byte[] by = new byte[len];
                in.readFully(by);
                String rev = new String(by, "UTF-8");

                in.close();

                return rev;
            } else {
                // http ���󷵻ط� 200״̬ʱ����
                return "<?xml version=\"1.0\" encoding=\"utf-8\" ?><error>���͵���������ʧ��</error>";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
        }
        return null;
    }

}