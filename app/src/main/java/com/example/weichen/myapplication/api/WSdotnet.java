package com.example.weichen.myapplication.api;

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
 * @author��xuwangwang E-mail: 541765907@qq.com
 * @date��2013-1-22 ����4:26:01
 * @version 1.0 String Tag = "WSdotnet�У�";
 */
public class WSdotnet {
	// public static final String NameSpace = "http://zl.emnet.cn/";
	// public static final String NameSpace = "http://test.java.eezz.cn/";
	public static final String NameSpace = "http://demo.java.eezz.cn/";

	/**
	 * 
	 * @param WSApplication
	 *            .NameSpace �����ռ�
	 * @param methodname
	 *            ���÷���
	 * @param URL
	 *            ����URL
	 * @param map
	 *            ������ŵ��÷����Ĳ���
	 * @return ����SoapObject
	 */
	public static String get(String methodName, Map<String, Object> params, String url) {
		return get(methodName, params, url, 15000);
	}
	/**
	 * 
	 * @param WSApplication
	 *            .NameSpace �����ռ�
	 * @param methodname
	 *            ���÷���
	 * @param URL
	 *            ����URL
	 * @param map
	 *            ������ŵ��÷����Ĳ���
	 * @return ����SoapObject
	 */
	public static String get(String methodName, Map<String, Object> params, String url, int timeOut) {
		try {
			// ʵ����SoapObject���󣺼򵥶������Э��(Simple Object Access Protocol)
			SoapObject so = new SoapObject(NameSpace, methodName);
			// ����в��������õ��÷�������
			Set keySet = params.keySet();// ���ؼ��ļ���
			Iterator it = keySet.iterator();
			while (it.hasNext()) { // ��һ�ֵ�����ʽȡ��ֵ
				Object key = it.next();
				so.addProperty(key.toString(), params.get(key));
			}
			// ������л���Envelope:�ŷ�
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.bodyOut = so;
			envelope.dotNet = true;
			envelope.setOutputSoapObject(so);
			envelope.encodingStyle = "UTF-8";
			/**
			 * Android������� ���������ó�ʱʱ�䣬10�� 10������޷�Ӧ��ht.call���ȡ�������ݣ�
			 * ��ʱ��ȡIOException�쳣 ��envelope.getResponse()ǿת�ɣ�SoapObject���ᱨ�������£�
			 * java.lang.ClassCastException:
			 * org.ksoap2.serialization.SoapPrimitive
			 */
			// HttpTransportSE ht = new HttpTransportSE(URL);
			HttpTransportSE transport = new HttpTransportSE(url, timeOut);
			transport.debug = true;
			// ����WebService(���в���Ϊ1�������ռ�+�������ƣ�2��Envelope����)
			transport.call(NameSpace + methodName, envelope);
			// ����SoapObject
			// return (SoapObject) envelope.getResponse();//����
			// return (SoapObject) envelope.bodyIn;//����byte[]����base64���н���ͱ���
			// return(SoapPrimitive) envelope.getResponse();//������
			// return envelope.getResponse();//��base64���н���ͱ����ʱ��ᱨ������
			return envelope.getResponse().toString();
			// return envelope.bodyIn.toString();
		} catch (IOException e) {
			Log.e("WSdotnet","IO================" + e);
			return null;
		} catch (XmlPullParserException e) {
			Log.e("WSdotnet","XmlPullParser===============" + e);
			return null;
		} catch (Exception e) {
			Log.e("WSdotnet","WSClient�У�eΪ��" + e);
			return null;
		}

	}
	/**
	 * �����ύ����ͼƬ�ļ�ֵ�ԣ�ͼƬ�ļ�ͨ��base64ת��string
	 * @param methodName
	 * @param params
	 * @param url
	 * @return
	 */
	public static String post(String methodName, Map<String, Object> params, String url) {
		return post(methodName, params, url, 30000);
	}

	/**
	 * �����ύ����ͼƬ�ļ�ֵ�ԣ�ͼƬ�ļ�ͨ��base64ת��string
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
