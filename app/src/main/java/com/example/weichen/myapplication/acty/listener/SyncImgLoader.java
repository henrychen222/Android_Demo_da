package com.example.weichen.myapplication.acty.listener;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;


public class SyncImgLoader {


	/**
	 * ����ԭͼƬ
	 * 
	 * @param imageUrl
	 * @param onloadImage
	 */
	public void loadImage(final String imageUrl, final OnloadImage onloadImage) {
		// �Ƿ�url
		if (TextUtils.isEmpty(imageUrl) || ("null").equals(imageUrl)) {
			onloadImage.loadFail();
			return;
		}

		// �ļ�����
//		String file = fileCache.getCacheFilePath(imageUrl);
//		if (null != file) {
//			// ��ȡ��bitmap
//			Bitmap bit2 = BitmapFactory.decodeFile(file);
//			if (null != bit2) {
//				onloadImage.loadFinish(bit2);
//				return;
//			}
//		}

		// û������
//		if (!hasNetByQuery()) {
//			onloadImage.loadFail();
//			return;
//		}

		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					onloadImage.loadFinish((Bitmap) msg.obj);
					break;
				case 2:
					onloadImage.loadFail();
					break;
				default:
					break;
				}
				super.handleMessage(msg);
			}
		};

		// ����
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
				// ����ͼƬ
				Bitmap bitmap = downloadBitmapFromNet(imageUrl);
				Message msg;
				if (bitmap != null) {
					msg = Message.obtain(handler, 1, bitmap);
					handler.sendMessage(msg);
				} else {
					msg = Message.obtain(handler, 2, null);
					handler.sendMessage(msg);
				}
			}
		}).start();
	}


	
	/**
	 * �������ȡInputStream
	 * manifest�мӷ�������Ȩ��android.permission.INTERNET
	 * @param urlStr
	 * @throws MalformedURLException
	 * @throws IOException
	 * @return InputStream
	 */
	public Bitmap downloadBitmapFromNet(String urlStr){
		try {
			Log.e("", "getInputSteamFromUrl������-------->��urlStrΪ��" + urlStr);
			URL url = new URL(urlStr);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			InputStream inputStream = urlConn.getInputStream();
			Log.e("", "getInputSteamFromUrl������-------->��ͼƬ������Ϊ��" + urlConn.getContentLength());
			// ֱ�ӱ����bitmap
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//			bitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(createFile));
//			String filePath = createFile.getAbsolutePath();
			return bitmap;
		} catch (Exception e) {
			Log.e("", "getInputSteamFromNet������-------->��eΪ��" + e);
			return null;
		}
	}



	
	/**
	 * ����ͼƬ�ص�
	 * 
	 * @author ww
	 */
	public interface OnloadImage extends Serializable {
		/** ������� */
		void loadFinish(Bitmap bitmap);

		/** ����ʧ�� */
		void loadFail();
	}
	
}