package com.example.weichen.myapplication.acty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.weichen.myapplication.R;

public class DownloadBitmapActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button downloadBN;
	private Button resetBN;
	private ImageView iconIV;
	private final int DOWN_OK = 0x12;
	private final int DOWN_FAIL = 0x123;
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case DOWN_OK:
				iconIV.setImageBitmap((Bitmap)msg.obj);
				Toast.makeText(mContext, "���سɹ�", Toast.LENGTH_SHORT).show();
				break;
			case DOWN_FAIL:
				Toast.makeText(mContext, "����ʧ��", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_download_bitmap);
		
		mContext = this;
		
		initVar();
		
		findViews();
		
		bindViews();
		
		setListener();
		
	}

	private void initVar() {

	}

	private void findViews() {
		downloadBN = (Button)findViewById(R.id.adb_bn_download);
		resetBN = (Button)findViewById(R.id.adb_bn_reset);
		iconIV = (ImageView)findViewById(R.id.adb_iv_icon);
	}

	private void bindViews() {
	}

	private void setListener() {
		downloadBN.setOnClickListener(this);
		resetBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adb_bn_download:// ����
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					String urlStr = "http://192.168.1.99/BaseWidgetTest/yue.jpg";
//					String urlStr = "http://img1.2345.com/duoteimg/qqTxImg/2013/04/22/13667761307.jpg";
					// ��һ����ʱ������������ͼƬ
					doDownLoadBitmap(urlStr);
				}
			}).start();
			
			
			break;
		case R.id.adb_bn_reset:// ����
			iconIV.setImageResource(R.mipmap.ic_launcher);
			//iconIV.setBackgroundResource(resid);
			break;
		default:
			break;
		}
		
	}

	/**
	 * ��������ͼƬ
	 * ��ӷ�������Ȩ�ޣ�android.permission.INTERNET
	 */
	private void doDownLoadBitmap(String urlStr) {
		try {
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			InputStream inputStream = con.getInputStream();
			// ֱ�ӱ����bitmap
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			
			// ���浽����
			bitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(new File("/mnt/sdcard/Download/", "yue.png")));
			
			// �����浽���ص�ͼƬ�����bitmap
			String filePath = "/mnt/sdcard/Download/yue.png";
			Bitmap bit = BitmapFactory.decodeFile(filePath);
			
			// ����һ���ɹ���Ϣ
			Message msg = Message.obtain();
			msg.what = DOWN_OK;
			msg.obj = bit;
			mHandler.sendMessage(msg);
		} catch (Exception e) {
			
			// ����һ��ʧ����Ϣ
			Message msg = Message.obtain();
			msg.what = DOWN_FAIL;
			mHandler.sendMessage(msg);
		}
		
	}

	
	

}
