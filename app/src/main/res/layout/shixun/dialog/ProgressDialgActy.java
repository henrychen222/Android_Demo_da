package com.sutest.shixun.dialog;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sutest.shixun.R;

public class ProgressDialgActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button showWiatBN;
	private TextView msgTV;
	
	/** 消失等待对话框*/
	private final int WAIT_DIALOG_DISMISS = 0x12;
	/** 更新ProgressDialog进度条*/
	private final int UPDATE_PROGRESS = 0x13;
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case WAIT_DIALOG_DISMISS:// 消失等待对话框
				waitDialog.dismiss();
				Toast.makeText(mContext, "登陆成功", Toast.LENGTH_SHORT).show();
				break;
			case UPDATE_PROGRESS:// 更新ProgressDialog进度条
				// 更新进度条
				doWorkDialog.setProgress(progress);
				
				if (progress >= 100) {
					doWorkDialog.dismiss();
				}
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
		
	};
	private Button doWorkBN;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_dialog_tip);
		
		mContext = this;
		
		initVar();
		
		findViews();
		
		bindViews();
		
		setListener();
		
	}

	private void initVar() {

	}

	private void findViews() {
		showWiatBN = (Button)findViewById(R.id.adt_btn_userCenter);
		doWorkBN = (Button)findViewById(R.id.adt_btn_time);
		msgTV = (TextView)findViewById(R.id.adt_tv_msg);
	}

	private void bindViews() {
		showWiatBN.setText("登录显示等待对话框");
		doWorkBN.setText("做耗时任务");
		doWorkBN.setVisibility(View.VISIBLE);
		
	}

	private void setListener() {
		showWiatBN.setOnClickListener(this);
		doWorkBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adt_btn_userCenter:// 
			// 
			showWaitDialog();
			break;
		case R.id.adt_btn_time:// 做耗时任务
			// 
			showDoWorkDialog();
			break;
		default:
			break;
		}
		
	}

	

	private ProgressDialog waitDialog;
	private void showWaitDialog() {

		if (waitDialog == null) {
			waitDialog = new ProgressDialog(mContext);
			waitDialog.setMessage("登陆中...");
			// 水平进度条
			// waitDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// 旋转体
			waitDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			// 按系统返回键将不管用
			waitDialog.setCancelable(false);
		}
		waitDialog.show();
		
		// 法一：普通线程延时
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// 模拟一个耗时任务
//				try {
//					Thread.sleep(2500);
//				} catch (Exception e) {
//				}
//				// 将报错！！子线程不可以操控UI控件
//				// waitDialog.dismiss();
//				
//				// 从消息池中取出一个消息对象
//				Message msg = Message.obtain();
//				// 指定一个int值，区分业务
//				msg.what = WAIT_DIALOG_DISMISS;
//				// 用handler对象发送消息
//				mHandler.sendMessage(msg);
//			}
//		}).start();
		
		// 法二：采用Timer线程延时
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// 从消息池中取出一个消息对象
				Message msg = Message.obtain();
				// 指定一个int值，区分业务
				msg.what = WAIT_DIALOG_DISMISS;
				// 用handler对象发送消息
				mHandler.sendMessage(msg);
			}
		}, 2500);
		
		
		
		
	}
	
	
	
	private ProgressDialog doWorkDialog;
	private int progress = 0;
	private void showDoWorkDialog() {
		
		if (doWorkDialog == null) {
			doWorkDialog = new ProgressDialog(mContext);
			doWorkDialog.setTitle("请稍后");
			doWorkDialog.setMessage("耗时任务完成百分比");
			doWorkDialog.setMax(100);
			// 水平进度条
			doWorkDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// 旋转体
//			doWorkDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			doWorkDialog.setCancelable(false);
		}
		doWorkDialog.show();
		
		// 还原初始状态
		progress = 0;
		doWorkDialog.setProgress(progress);
		
		// 法一：普通线程
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while (progress <= 100) {
//					// 模拟一个耗时任务
//					progress++;
//					try {
//						Thread.sleep(100);
//					} catch (Exception e) {
//					}
//					Message msg = Message.obtain();
//					msg.what = UPDATE_PROGRESS;
//					mHandler.sendMessage(msg);
//				}
//				
//			}
//		}).start();
		
		
		// 法二：Timer线程
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// 模拟一个耗时任务
				progress++;
				
				Message msg = Message.obtain();
				msg.what = UPDATE_PROGRESS;
				mHandler.sendMessage(msg);
				
				// mHandler.sendEmptyMessage(UPDATE_PROGRESS);
			}
		}, 100, 100);
		
		
	}
	
	

}
