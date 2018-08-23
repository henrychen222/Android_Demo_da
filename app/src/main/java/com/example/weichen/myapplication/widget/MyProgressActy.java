package com.example.weichen.myapplication.widget;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.example.weichen.myapplication.R;

public class MyProgressActy extends Activity {

	
	private ProgressBar progressB;
	private Button downloadBN;
	private int progress = 0;
	/**
	 * Handler�����̺߳����߳�ͨѶ����������������̷߳��͹�������Ϣ������UI�ؼ�
	 */
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			// ���½���ֵ
			progressB.setProgress(progress);
			
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_progress);
		
		
		initProgressBar();
		
		
		initSeekBar();
		
		
		initRatingBar();
		
	}

	private void initRatingBar() {
		RatingBar ratingB = (RatingBar)findViewById(R.id.ap_rb_rating);
		ratingB.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				// 
				Toast.makeText(MyProgressActy.this, "��ѡ����" + rating + "����", Toast.LENGTH_SHORT).show();
				
			}
		});
		
	}

	private void initSeekBar() {
		SeekBar seekB = (SeekBar)findViewById(R.id.ar_sb_seek);
		final ImageView imgIV = (ImageView)findViewById(R.id.ar_iv_img);
		
		seekB.setMax(255);
		seekB.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// �ı�ͼƬ͸����
				imgIV.setAlpha(progress);
				
			}
		});
		
		
	}

	private void initProgressBar() {
		progressB = (ProgressBar)findViewById(R.id.ar_pb_progress);
		progressB.setMax(100);
		
		downloadBN = (Button)findViewById(R.id.ar_bn_download);
		downloadBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				progress = 0;
				// ����һ���߳�
				new Thread(new Runnable() {
					/**
					 * run�����������߳������У����̲߳����Բٿ�UI�ؼ�
					 * ͨ��Handler�����̺߳����߳�ͨѶ����������һ����Ϣ�����̣߳�
					 * ���̸߳������UI�ؼ�
					 */
					@Override
					public void run() {
						for (int i = 0; i < 100; i++) {
							progress++;
							try {
								Thread.sleep(100);
							} catch (Exception e) {
								
							}
							// ����һ����Ϣ�����̣߳�����UI�ؼ�
							mHandler.sendEmptyMessage(0);
						}
					}
				}).start();
				
			}
		});
		
	}
}
