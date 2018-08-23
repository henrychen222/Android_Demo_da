package com.sutest.shixun.acty.anim;

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

import com.sutest.shixun.R;

/**
 * 补间动画
 * 1、位移动画
 * 2、缩放动画
 * 3、旋转动画
 * 4、透明动画
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
		
		// 1、位移动画
		initTranslateAnim();
		
		// 2、缩放动画
		initScaleAnim();
		
		
		// 3、旋转动画
		initRotateAnim();
		
		
		// 4、透明动画
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
				// 启动法一：
				alphaIV.startAnimation(alphaAnim);
				// 启动法二：
//				alphaIV.setAnimation(alphaAnim);
//				alphaAnim.start();
				
			}
		});
		
	}



	private void initRotateAnim() {
		rotateIV = (ImageView)findViewById(R.id.at_iv_rotate);
		rotateBN = (Button)findViewById(R.id.at_bn_rotate);
		/*
		 *  三、旋转动画
		 *  fromDegrees 旋转起始角度
		 *  toDegrees 旋转结束角度
		 *  pivotX 相对于控件本身的x偏移量，以(pivotX, pivotY)坐标点旋转
		 *  pivotY 相对于控件本身的y偏移量，以(pivotX, pivotY)坐标点旋转
		 */
		final RotateAnimation rotateAnim = new RotateAnimation(0, 360, 10, 10);
		// 线性插补器
		rotateAnim.setInterpolator(new LinearInterpolator());
		// 动画时长
		rotateAnim.setDuration(800);
		// 执行前等待时间
		rotateAnim.setStartOffset(100);
		
		rotateBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 启动法一：
				rotateIV.startAnimation(rotateAnim);
				// 启动法二：
//				rotateIV.setAnimation(rotateAnim);
//				rotateAnim.start();
				
			}
		});
		
		
	}



	// 1、位移动画
	private void initTranslateAnim() {
		translateIV = (ImageView)findViewById(R.id.at_iv_translate);
		translateBN = (Button)findViewById(R.id.at_bn_translate);
		/*
		 *  一、位移动画
		 *  fromXDelta：位置变化的起始点X坐标。
		 *  toXDelta：位置变化的结束点X坐标。
		 *  fromYDelta：位置变化的起始点Y坐标。
		 *  toYDelta：位置变化的结束点Y坐标。
		 */
		final TranslateAnimation translateAnim = new TranslateAnimation(0, 400, 0, 200);
		// 动画时长
		translateAnim.setDuration(1000);
		// 重复一次
		translateAnim.setRepeatCount(1);
//		translateAnim.setStartTime(Animation.START_ON_FIRST_FRAME); 
		// 反方向执行
		translateAnim.setRepeatMode(Animation.REVERSE);
//		translateIV.setAnimation(translateAnim);
		
		translateBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 启动法一：
//				translateIV.startAnimation(translateAnim);
				// 启动法二：
				translateIV.setAnimation(translateAnim);
//				translateAnim.start();
				
			}
		});
	}
	
	
	private void initScaleAnim() {
		scaleIV = (ImageView)findViewById(R.id.at_iv_scale);
		scaleBN = (Button)findViewById(R.id.at_bn_scale);
		/*
		 *  二、缩放动画
		 *  float fromX 动画起始时 X坐标上的伸缩尺寸 
		 *  float toX 动画结束时 X坐标上的伸缩尺寸 
		 *  float fromY 动画起始时Y坐标上的伸缩尺寸 
		 *  float toY 动画结束时Y坐标上的伸缩尺寸 
		 */
		final ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f);
		scaleAnim.setDuration(800);
		// 动画执行完，插入最后一帧
		scaleAnim.setFillAfter(true);
//		scaleAnim.setFillBefore(true);
		
		scaleBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 启动法一：
				scaleIV.startAnimation(scaleAnim);
				// 启动法二：
//				scaleIV.setAnimation(scaleAnim);
//				scaleAnim.start();
				
			}
		});
		
	}
	
	

}
