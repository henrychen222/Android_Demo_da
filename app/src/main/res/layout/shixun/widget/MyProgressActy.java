package com.sutest.shixun.widget;

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

import com.sutest.shixun.R;

public class MyProgressActy extends Activity {

	
	private ProgressBar progressB;
	private Button downloadBN;
	private int progress = 0;
	/**
	 * Handler是主线程和子线程通讯桥梁，负责接收子线程发送过来的消息，更新UI控件
	 */
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			// 更新进度值
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
				Toast.makeText(MyProgressActy.this, "您选择了" + rating + "颗星", Toast.LENGTH_SHORT).show();
				
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
				// 改变图片透明度
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
				// 启动一个线程
				new Thread(new Runnable() {
					/**
					 * run方法是在子线程中运行，子线程不可以操控UI控件
					 * 通过Handler（子线程和主线程通讯桥梁）发送一个消息到主线程，
					 * 主线程负责更新UI控件
					 */
					@Override
					public void run() {
						for (int i = 0; i < 100; i++) {
							progress++;
							try {
								Thread.sleep(100);
							} catch (Exception e) {
								
							}
							// 发送一个消息给主线程，更新UI控件
							mHandler.sendEmptyMessage(0);
						}
					}
				}).start();
				
			}
		});
		
	}
}
