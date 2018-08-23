package com.example.weichen.myapplication.acty.anim;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.weichen.myapplication.R;

/**
 * ��֡����
 * @author wwx220
 *
 */
public class ButterflyActy extends Activity {

	private ImageView imageIV;
	
	private final int FLY_RIGHT = 0x12;
	private float curX = 0;
	private float curY = 30;
	
	private float nextX;
	private float nextY;
	
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case FLY_RIGHT:// ���ҷ���
				
				if (nextX > 720) {
					curX = 0;
					nextX = 0;
				}else {
					nextX += 10;
				}
				// random()ֵ��[0, 1)  [-5, 5)
				nextY = curY + (float)(Math.random() * 10 - 5);
				TranslateAnimation anim = new TranslateAnimation(curX, nextX, curY, nextY);
				anim.setDuration(200);
				imageIV.startAnimation(anim);
				
				curX = nextX;
				curY = nextY;
				
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
		setContentView(R.layout.acty_butterfly);
		
		imageIV = (ImageView)findViewById(R.id.ab_iv_butter);
		final AnimationDrawable animationDrawable = (AnimationDrawable)imageIV.getBackground();
		
		imageIV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ��֡��������
				animationDrawable.start();
				// ����һ���̣߳�ÿ��0.2�����һ��λ�ƶ�����ʹ�������ҷ���
				new Timer().schedule(new TimerTask() {
					
					@Override
					public void run() {
						// ÿ��0.2�뷢��һ����Ϣ
						mHandler.sendEmptyMessage(FLY_RIGHT);
					}
				}, 10, 200);
				
			}
		});
		
	}
	
	

}
