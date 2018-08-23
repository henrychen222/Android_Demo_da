package com.sutest.shixun.acty.webservice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sutest.shixun.R;
import com.sutest.shixun.api.DotNetManager;

public class WebServiceActy extends Activity {

	private Context mContext;
	private Button clickBN;
	private TextView tipTV;
	private TextView titleTV;
	private String result;
	
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			tipTV.setText(result);
		}
		
	};
	private DotNetManager dotNetManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_web_service);
		
		mContext = this;
		
		initVar();
		findViews();
		bindViews();
		setOnclickListener();
		
		
	}

	private void initVar() {
		dotNetManager = new DotNetManager();
	}

	private void findViews() {
		titleTV = (TextView)findViewById(R.id.am_tv_title);
		tipTV = (TextView)findViewById(R.id.am_tv_tip);
		clickBN = (Button)findViewById(R.id.am_bn_dialog);
		
		
		
	}

	private void bindViews() {
		titleTV.setText("dotNet版Webservice");
		
	}

	private void setOnclickListener() {
		clickBN.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				new Thread(new Runnable() {
					@Override
					public void run() {
//						String filePath = "/sdcard/Download/"; //路径    
//						String fileName = "login.jpg";  //文件名    
//						// 上传图片
//						result = dotNetManager.testUploadImage(filePath, fileName);
						// 用户登录
						result = dotNetManager.peopleLogin("113", "123456");
						mHandler.sendEmptyMessage(0x12);
						
					}
				}).start();
			}
		});
	}
	
	
}
