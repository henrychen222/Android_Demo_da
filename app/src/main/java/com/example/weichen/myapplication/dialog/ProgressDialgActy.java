package com.example.weichen.myapplication.dialog;

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

import com.example.weichen.myapplication.R;

public class ProgressDialgActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button showWiatBN;
	private TextView msgTV;
	
	/** ��ʧ�ȴ��Ի���*/
	private final int WAIT_DIALOG_DISMISS = 0x12;
	/** ����ProgressDialog������*/
	private final int UPDATE_PROGRESS = 0x13;
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case WAIT_DIALOG_DISMISS:// ��ʧ�ȴ��Ի���
				waitDialog.dismiss();
				Toast.makeText(mContext, "��½�ɹ�", Toast.LENGTH_SHORT).show();
				break;
			case UPDATE_PROGRESS:// ����ProgressDialog������
				// ���½�����
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
		showWiatBN.setText("��¼��ʾ�ȴ��Ի���");
		doWorkBN.setText("����ʱ����");
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
		case R.id.adt_btn_time:// ����ʱ����
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
			waitDialog.setMessage("��½��...");
			// ˮƽ������
			// waitDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// ��ת��
			waitDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			// ��ϵͳ���ؼ���������
			waitDialog.setCancelable(false);
		}
		waitDialog.show();
		
		// ��һ����ͨ�߳���ʱ
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// ģ��һ����ʱ����
//				try {
//					Thread.sleep(2500);
//				} catch (Exception e) {
//				}
//				// �����������̲߳����Բٿ�UI�ؼ�
//				// waitDialog.dismiss();
//				
//				// ����Ϣ����ȡ��һ����Ϣ����
//				Message msg = Message.obtain();
//				// ָ��һ��intֵ������ҵ��
//				msg.what = WAIT_DIALOG_DISMISS;
//				// ��handler��������Ϣ
//				mHandler.sendMessage(msg);
//			}
//		}).start();
		
		// ����������Timer�߳���ʱ
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// ����Ϣ����ȡ��һ����Ϣ����
				Message msg = Message.obtain();
				// ָ��һ��intֵ������ҵ��
				msg.what = WAIT_DIALOG_DISMISS;
				// ��handler��������Ϣ
				mHandler.sendMessage(msg);
			}
		}, 2500);
		
		
		
		
	}
	
	
	
	private ProgressDialog doWorkDialog;
	private int progress = 0;
	private void showDoWorkDialog() {
		
		if (doWorkDialog == null) {
			doWorkDialog = new ProgressDialog(mContext);
			doWorkDialog.setTitle("���Ժ�");
			doWorkDialog.setMessage("��ʱ������ɰٷֱ�");
			doWorkDialog.setMax(100);
			// ˮƽ������
			doWorkDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// ��ת��
//			doWorkDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			doWorkDialog.setCancelable(false);
		}
		doWorkDialog.show();
		
		// ��ԭ��ʼ״̬
		progress = 0;
		doWorkDialog.setProgress(progress);
		
		// ��һ����ͨ�߳�
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while (progress <= 100) {
//					// ģ��һ����ʱ����
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
		
		
		// ������Timer�߳�
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// ģ��һ����ʱ����
				progress++;
				
				Message msg = Message.obtain();
				msg.what = UPDATE_PROGRESS;
				mHandler.sendMessage(msg);
				
				// mHandler.sendEmptyMessage(UPDATE_PROGRESS);
			}
		}, 100, 100);
		
		
	}
	
	

}
