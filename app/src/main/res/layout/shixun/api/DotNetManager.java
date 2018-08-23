package com.sutest.shixun.api;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.kobjects.base64.Base64;

import android.content.Context;
import android.util.Log;

/**
 * @author：xuwangwang E-mail: 541765907@qq.com
 * @date：2012-7-4 下午4:31:12
 * @version 1.0 String Tag = "WsApi中：";
 *          网络发言人模块：面向网络数据库的数据接口开发，相当于Dao和业务逻辑manage层
 */
public class DotNetManager {
	private String TAG = "DotNetManager";

//	private static final String url = WSdotnet.NameSpace + "WebServiceTest.asmx";
	// http://localhost/WS_SuweiWeibo/SuweiWeibo.asmx?op=login
	private static final String url = "http://192.168.15.253/WS_SuweiWeibo/SuweiWeibo.asmx";
	private Context ctx;

	/**
	 * 根据用户名密码登陆
	 * 
	 * @param name
	 * @param age
	 * @return String
	 */
	public String peopleLogin(String loginName, String passWord) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("passWord", passWord);
		// 1表示andriod,2表示iphone 3 表示 ipad
		params.put("loginType", "1");
		
//		String url = "http://192.168.0.19:8081/WebServiceDemo/SuweiTest.asmx";
		String result = WSdotnet.get("login", params, url);
		if (result == null) {
			return null;
		}
		Log.e("WSdotnet","TestManager中：result为：" + result);
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
		Log.e("WSdotnet","TestManager中：getPeopleList为：" + result);
		return result;

	}

	/**
	 * 图片上传
	 */
	public String testUploadImage(String filePath, String fileName){

		String uploadBuffer = file2Base64String(filePath, fileName);
		if (uploadBuffer == null) {
			return null;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", "001");
		params.put("content", "xxxx内容");
		params.put("imageFile", uploadBuffer);
		
		String url = "http://192.168.15.253/WS_SuweiWeibo/SuweiTest.asmx";
		
		String result = WSdotnet.post("writeWeibo", params, url);


		return result;
	}
	
	/**
	 * 图片文件转Base64字符串
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
	        String uploadBuffer = new String(Base64.encode(baos.toByteArray()));  //进行Base64编码    
	        return uploadBuffer;
		} catch (Exception e) {
			Log.e(TAG,"文件转换错误--------->" + e);
			return null;
		}
		
	}


}
