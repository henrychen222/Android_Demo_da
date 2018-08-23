package com.sutest.shixun.acty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sutest.shixun.R;

/**
 * requestCode 请求码，
 * resultCode 结果码，结果码用于标识返回数据来自哪个新Activity
 * @author wwx220
 *
 */
public class StartActivityForResultActy extends Activity implements View.OnClickListener{
	
	
	
	private TextView contentTV1;
	private TextView contentTV2;
	private TextView contentTV3;
	private TextView contentTV4;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_startactivityforresult_one);
		
		contentTV1 = (TextView)findViewById(R.id.aso_et_content1);
		contentTV2 = (TextView)findViewById(R.id.aso_et_content2);
		findViewById(R.id.aso_btn_goto1).setOnClickListener(this);
		findViewById(R.id.aso_btn_goto2).setOnClickListener(this);
		
		contentTV3 = (TextView)findViewById(R.id.aso_et_content3);
		contentTV4 = (TextView)findViewById(R.id.aso_et_content4);
		findViewById(R.id.aso_btn_goto3).setOnClickListener(this);
		findViewById(R.id.aso_btn_goto4).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.aso_btn_goto1:// 国家
			Intent intent = new Intent(this, StartActivityForResultSecondActy.class);
			// 启动页面
			startActivityForResult(intent, 1);
			break;
		case R.id.aso_btn_goto2:// 省
			intent = new Intent(this, StartActivityForResultSecondActy.class);
			// 启动页面
			startActivityForResult(intent, 2);
			break;
			
		case R.id.aso_btn_goto3:// 国家
			intent = new Intent(this, StartActivityForResultSecondActy.class);
			// 没有用到requestCode
			startActivityForResult(intent, 0);
			break;
		case R.id.aso_btn_goto4:// 省、市
			intent = new Intent(this, StartActivityForResultThreeActy.class);
			// 没有用到requestCode
			startActivityForResult(intent, 0);
			break;
		default:
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Log.e("","onActivityResult--->resultCode=" + resultCode);
		
		switch (requestCode) {
		case 1:// 国家
			if (intent != null) {
				String msg = intent.getStringExtra("msg1");
				contentTV1.setText(msg);
			}
			break;
		case 2:// 省
			if (intent != null) {
				String msg2 = intent.getStringExtra("msg2");
				contentTV2.setText(msg2);
			}
			break;
		default:
			break;
		}
		
		switch (resultCode) {
		case StartActivityForResultSecondActy.RESULT_CODE_1:// 返回国家
			if (intent != null) {
				String msg2 = intent.getStringExtra("msg3");
				contentTV3.setText(msg2);
			}
			break;
		case StartActivityForResultThreeActy.RESULT_CODE_2:// 返回省、市
			if (intent != null) {
				String msg2 = intent.getStringExtra("msg4");
				contentTV4.setText(msg2);
			}
			break;
		default:
			break;
		}
		
		super.onActivityResult(requestCode, resultCode, intent);
	}
	
	

//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//		switch (requestCode) {
//		case 1:// 
//			String msg = intent.getStringExtra("msg1");
//			contentTV1.setText(msg);
//			break;
//
//		default:
//			break;
//		}
//		super.onActivityResult(requestCode, resultCode, intent);
//	}
	
	
	
	
	
	
	
	

}
