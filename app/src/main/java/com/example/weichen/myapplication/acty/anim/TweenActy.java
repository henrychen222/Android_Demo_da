package com.example.weichen.myapplication.acty.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.weichen.myapplication.R;

/**
 * ���䶯��
 * 1��λ�ƶ���
 * 2�����Ŷ���
 * 3����ת����
 * 4��͸������
 * @author wwx220
 *
 */
public class TweenActy extends Activity {

	private ImageView translateIV;
	private Button translateBN;
	private ImageView scaleIV;
	private Button scaleBN;
	private Button rotateBN;
	private ImageView rotateIV;
	private Button alphaBN;
	private ImageView alphaIV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_tween);
		
		// 1��λ�ƶ���
		initTranslateAnim();
		
		// 2�����Ŷ���
		initScaleAnim();
		
		
		// 3����ת����
		initRotateAnim();
		
		
		// 4��͸������
		initAlphaAnim();
		
		
		
	}

	

	private void initAlphaAnim() {
		alphaIV = (ImageView)findViewById(R.id.at_iv_alpha);
		alphaBN = (Button)findViewById(R.id.at_bn_alpha);
		
		final AlphaAnimation alphaAnim = new AlphaAnimation(0.1f, 1.0f);
		alphaAnim.setDuration(5000);
		
		alphaBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ������һ��
				alphaIV.startAnimation(alphaAnim);
				// ����������
//				alphaIV.setAnimation(alphaAnim);
//				alphaAnim.start();
				
			}
		});
		
	}



	private void initRotateAnim() {
		rotateIV = (ImageView)findViewById(R.id.at_iv_rotate);
		rotateBN = (Button)findViewById(R.id.at_bn_rotate);
		/*
		 *  ������ת����
		 *  fromDegrees ��ת��ʼ�Ƕ�
		 *  toDegrees ��ת�����Ƕ�
		 *  pivotX ����ڿؼ������xƫ��������(pivotX, pivotY)�������ת
		 *  pivotY ����ڿؼ������yƫ��������(pivotX, pivotY)�������ת
		 */
		final RotateAnimation rotateAnim = new RotateAnimation(0, 360, 10, 10);
		// ���Բ岹��
		rotateAnim.setInterpolator(new LinearInterpolator());
		// ����ʱ��
		rotateAnim.setDuration(800);
		// ִ��ǰ�ȴ�ʱ��
		rotateAnim.setStartOffset(100);
		
		rotateBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ������һ��
				rotateIV.startAnimation(rotateAnim);
				// ����������
//				rotateIV.setAnimation(rotateAnim);
//				rotateAnim.start();
				
			}
		});
		
		
	}



	// 1��λ�ƶ���
	private void initTranslateAnim() {
		translateIV = (ImageView)findViewById(R.id.at_iv_translate);
		translateBN = (Button)findViewById(R.id.at_bn_translate);
		/*
		 *  һ��λ�ƶ���
		 *  fromXDelta��λ�ñ仯����ʼ��X���ꡣ
		 *  toXDelta��λ�ñ仯�Ľ�����X���ꡣ
		 *  fromYDelta��λ�ñ仯����ʼ��Y���ꡣ
		 *  toYDelta��λ�ñ仯�Ľ�����Y���ꡣ
		 */
		final TranslateAnimation translateAnim = new TranslateAnimation(0, 400, 0, 200);
		// ����ʱ��
		translateAnim.setDuration(1000);
		// �ظ�һ��
		translateAnim.setRepeatCount(1);
//		translateAnim.setStartTime(Animation.START_ON_FIRST_FRAME); 
		// ������ִ��
		translateAnim.setRepeatMode(Animation.REVERSE);
//		translateIV.setAnimation(translateAnim);
		
		translateBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ������һ��
//				translateIV.startAnimation(translateAnim);
				// ����������
				translateIV.setAnimation(translateAnim);
//				translateAnim.start();
				
			}
		});
	}
	
	
	private void initScaleAnim() {
		scaleIV = (ImageView)findViewById(R.id.at_iv_scale);
		scaleBN = (Button)findViewById(R.id.at_bn_scale);
		/*
		 *  �������Ŷ���
		 *  float fromX ������ʼʱ X�����ϵ������ߴ� 
		 *  float toX ��������ʱ X�����ϵ������ߴ� 
		 *  float fromY ������ʼʱY�����ϵ������ߴ� 
		 *  float toY ��������ʱY�����ϵ������ߴ� 
		 */
		final ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f);
		scaleAnim.setDuration(800);
		// ����ִ���꣬�������һ֡
		scaleAnim.setFillAfter(true);
//		scaleAnim.setFillBefore(true);
		
		scaleBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ������һ��
				scaleIV.startAnimation(scaleAnim);
				// ����������
//				scaleIV.setAnimation(scaleAnim);
//				scaleAnim.start();
				
			}
		});
		
	}
	
	

}
