package com.sutest.shixun.api;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

/**
 * @author：xuwangwang E-mail: 541765907@qq.com
 * @date：2013-1-22 下午4:26:01
 * @version 1.0 String Tag = "WSdotnet中：";
 */
public class WSdotnet {
	// public static final String NameSpace = "http://zl.emnet.cn/";
	// public static final String NameSpace = "http://test.java.eezz.cn/";
	public static final String NameSpace = "http://demo.java.eezz.cn/";

	/**
	 * 
	 * @param WSApplication
	 *            .NameSpace 命名空间
	 * @param methodname
	 *            调用方法
	 * @param URL
	 *            请求URL
	 * @param map
	 *            用来存放调用方法的参数
	 * @return 返回SoapObject
	 */
	public static String get(String methodName, Map<String, Object> params, String url) {
		return get(methodName, params, url, 15000);
	}
	/**
	 * 
	 * @param WSApplication
	 *            .NameSpace 命名空间
	 * @param methodname
	 *            调用方法
	 * @param URL
	 *            请求URL
	 * @param map
	 *            用来存放调用方法的参数
	 * @return 返回SoapObject
	 */
	public static String get(String methodName, Map<String, Object> params, String url, int timeOut) {
		try {
			// 实例化SoapObject对象：简单对象访问协议(Simple Object Access Protocol)
			SoapObject so = new SoapObject(NameSpace, methodName);
			// 如果有参数，设置调用方法参数
			Set keySet = params.keySet();// 返回键的集合
			Iterator it = keySet.iterator();
			while (it.hasNext()) { // 第一种迭代方式取键值
				Object key = it.next();
				so.addProperty(key.toString(), params.get(key));
			}
			// 获得序列化的Envelope:信封
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.bodyOut = so;
			envelope.dotNet = true;
			envelope.setOutputSoapObject(so);
			envelope.encodingStyle = "UTF-8";
			/**
			 * Android传输对象 在这里设置超时时间，10秒 10秒后若无反应，ht.call则获取不到数据，
			 * 此时获取IOException异常 把envelope.getResponse()强转成（SoapObject）会报错误如下：
			 * java.lang.ClassCastException:
			 * org.ksoap2.serialization.SoapPrimitive
			 */
			// HttpTransportSE ht = new HttpTransportSE(URL);
			HttpTransportSE transport = new HttpTransportSE(url, timeOut);
			transport.debug = true;
			// 调用WebService(其中参数为1：命名空间+方法名称，2：Envelope对象)
			transport.call(NameSpace + methodName, envelope);
			// 返回SoapObject
			// return (SoapObject) envelope.getResponse();//报错
			// return (SoapObject) envelope.bodyIn;//兼容byte[]数据base64进行解码和编码
			// return(SoapPrimitive) envelope.getResponse();//不报错
			// return envelope.getResponse();//用base64进行解码和编码的时候会报出错误
			return envelope.getResponse().toString();
			// return envelope.bodyIn.toString();
		} catch (IOException e) {
			Log.e("WSdotnet","IO================" + e);
			return null;
		} catch (XmlPullParserException e) {
			Log.e("WSdotnet","XmlPullParser===============" + e);
			return null;
		} catch (Exception e) {
			Log.e("WSdotnet","WSClient中：e为：" + e);
			return null;
		}

	}
	/**
	 * 可以提交含有图片的键值对，图片文件通过base64转成string
	 * @param methodName
	 * @param params
	 * @param url
	 * @return
	 */
	public static String post(String methodName, Map<String, Object> params, String url) {
		return post(methodName, params, url, 30000);
	}

	/**
	 * 可以提交含有图片的键值对，图片文件通过base64转成string
	 * @param methodName
	 * @param params
	 * @param url
	 * @param timeOut
	 * @return
	 */
	public static String post(String methodName, Map<String, Object> params, String url, int timeOut) {
		return get(methodName, params, url, timeOut);
	}
	
	
	
	
	

}
