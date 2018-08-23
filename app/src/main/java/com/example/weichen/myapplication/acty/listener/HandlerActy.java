package com.example.weichen.myapplication.acty.listener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weichen.myapplication.R;

public class HandlerActy extends Activity {

	private Button downloadBN;
	private ImageView imgIV;
	private Button resetBN;
	private TextView timeTV;

	
	private static final int FLAG_DOWN_OK = 0x12;
	private static final int FLAG_DOWN_FAIL = 0x13;
	private static final int UPDATE_TIME = 0x14;
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case FLAG_DOWN_OK:// ���سɹ�
				Bitmap bitmap = (Bitmap)msg.obj;
				imgIV.setImageBitmap(bitmap);
				Toast.makeText(HandlerActy.this, "���سɹ���", Toast.LENGTH_SHORT).show();
				break;
			case FLAG_DOWN_FAIL:// ����ʧ��
				Toast.makeText(HandlerActy.this, "����ʧ�ܣ�", Toast.LENGTH_SHORT).show();
				break;
			case UPDATE_TIME:// ����ʱ��
				timeTV.setText("ʱ�䣺" + time++);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
		
	};
	private Button startBN;
	private Button stopBN;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_handler);
		
		initVar();
		
		findViews();
		
		setOnClickListener();
		
	}


	

	




	private void initVar() {
		
	}




	private void findViews() {
		downloadBN = (Button)findViewById(R.id.ah_bn_download);
		resetBN = (Button)findViewById(R.id.ah_bn_reset);
		startBN = (Button)findViewById(R.id.ah_bn_start);
		stopBN = (Button)findViewById(R.id.ah_bn_stop);
		
		imgIV = (ImageView)findViewById(R.id.ah_iv_img);
		timeTV = (TextView)findViewById(R.id.ah_tv_time);
		
	}
	
	
	private void setOnClickListener() {
		downloadBN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// ����ͼƬ
//						String urlStr = "http://img1.2345.com/duoteimg/qqTxImg/2013/04/22/13667761307.jpg";
						String urlStr = "http://192.168.1.99/BaseWidgetTest/yue.jpg";
						// ��������ͼƬ
						Bitmap bitmap = downloadBitmapFromNet(urlStr );
						// ����bitmap�Ƿ�Ϊnull�ж��Ƿ����سɹ�
						if (bitmap != null) {
							Message msg = Message.obtain();
							msg.what = FLAG_DOWN_OK;
							msg.obj = bitmap;
							mHandler.sendMessage(msg);
						}else{
							Message msg = Message.obtain();
							msg.what = FLAG_DOWN_FAIL;
							mHandler.sendMessage(msg);
						}
						
					}
				}).start();
			}
		});
		resetBN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// �޸ĳ�Ĭ��ͼƬ
				imgIV.setImageResource(R.mipmap.ic_launcher);
			}
		});
		startBN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Timer��ʱ��
				runTime();
			}
		});
		stopBN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ֹͣ
				if (timer != null) {
					timer.cancel();
					timer = null;
				}
			}
		});
		
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
			// ���汾��
//			bitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(createFile));
//			String filePath = createFile.getAbsolutePath();
			// ��ȡͼƬ�ļ�������Bitmap
//			Bitmap bitmap = BitmapFactory.decodeFile(filePath);
			return bitmap;
		} catch (Exception e) {
			Log.e("", "getInputSteamFromNet������-------->��eΪ��" + e);
			return null;
		}
	}

	
	private int time;
	private Timer timer;
	
	private void runTime() {
		if (timer == null) {
			// ��ʱ����
			timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					// ÿ��1���ӷ���һ����Ϣ
					mHandler.sendEmptyMessage(UPDATE_TIME);
				}
			}, 10, 1000);
		}
		
	}

}
