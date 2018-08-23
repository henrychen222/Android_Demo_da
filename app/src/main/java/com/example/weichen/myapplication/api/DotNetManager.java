package com.example.weichen.myapplication.api;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.kobjects.base64.Base64;

import android.content.Context;
import android.util.Log;

/**
 * @author��xuwangwang E-mail: 541765907@qq.com
 * @date��2012-7-4 ����4:31:12
 * @version 1.0 String Tag = "WsApi�У�";
 *          ���緢����ģ�飺�����������ݿ�����ݽӿڿ������൱��Dao��ҵ���߼�manage��
 */
public class DotNetManager {
	private String TAG = "DotNetManager";

//	private static final String url = WSdotnet.NameSpace + "WebServiceTest.asmx";
	// http://localhost/WS_SuweiWeibo/SuweiWeibo.asmx?op=login
	private static final String url = "http://192.168.15.253/WS_SuweiWeibo/SuweiWeibo.asmx";
	private Context ctx;

	/**
	 * �����û��������½
	 * 
	 * @param name
	 * @param age
	 * @return String
	 */
	public String peopleLogin(String loginName, String passWord) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("passWord", passWord);
		// 1��ʾandriod,2��ʾiphone 3 ��ʾ ipad
		params.put("loginType", "1");
		
//		String url = "http://192.168.0.19:8081/WebServiceDemo/SuweiTest.asmx";
		String result = WSdotnet.get("login", params, url);
		if (result == null) {
			return null;
		}
		Log.e("WSdotnet","TestManager�У�resultΪ��" + result);
		return result;
	}
	
	

	public String getPeopleList(String size) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("size", size);

		// params.put("versionCode", WSApplication.VersionCode);
		// params.put("machineCode", WSApplication.MachineCode);
		String result = WSdotnet.get("AA_getPeopleList", params, url);
		if (result == null) {
			return null;
		}
		Log.e("WSdotnet","TestManager�У�getPeopleListΪ��" + result);
		return result;

	}

	/**
	 * ͼƬ�ϴ�
	 */
	public String testUploadImage(String filePath, String fileName){

		String uploadBuffer = file2Base64String(filePath, fileName);
		if (uploadBuffer == null) {
			return null;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", "001");
		params.put("content", "xxxx����");
		params.put("imageFile", uploadBuffer);
		
		String url = "http://192.168.15.253/WS_SuweiWeibo/SuweiTest.asmx";
		
		String result = WSdotnet.post("writeWeibo", params, url);


		return result;
	}
	
	/**
	 * ͼƬ�ļ�תBase64�ַ���
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	private String file2Base64String(String filePath, String fileName){
		try {
			FileInputStream fis = new FileInputStream(filePath + fileName);   
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();   
	        byte[] buffer = new byte[1024];   
	        int count = 0;   
	        while((count = fis.read(buffer)) >= 0){   
	            baos.write(buffer, 0, count);   
	        }                
	        fis.close(); 
	        String uploadBuffer = new String(Base64.encode(baos.toByteArray()));  //����Base64����    
	        return uploadBuffer;
		} catch (Exception e) {
			Log.e(TAG,"�ļ�ת������--------->" + e);
			return null;
		}
		
	}


}
