package com.example.weichen.myapplication.acty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.weichen.myapplication.R;
/**
 * 
 * @author wwx220
 *
 */
public class StartActivityForResultSecondActy extends Activity implements View.OnClickListener{
	
	private EditText contentET1;
	private EditText contentET2;
	private EditText contentET3;
	/** ���ع���*/
	public static final int RESULT_CODE_1 = 0x12;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_startactivityforresult_second);
		
		contentET1 = (EditText)findViewById(R.id.ass_et_content1);
		contentET2 = (EditText)findViewById(R.id.ass_et_content2);
		
		findViewById(R.id.ass_btn_back1).setOnClickListener(this);
		findViewById(R.id.ass_btn_back2).setOnClickListener(this);
		
		contentET3 = (EditText)findViewById(R.id.ass_et_content3);
		findViewById(R.id.ass_btn_back3).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ass_btn_back1:// ����
			Intent intent = new Intent();
			intent.putExtra("msg1", contentET1.getText().toString());
			// �ص�����Я������
			setResult(RESULT_OK, intent);
			finish();
			break;
		case R.id.ass_btn_back2:// ʡ
			Intent intent2 = new Intent();
			intent2.putExtra("msg2", contentET2.getText().toString());
			// �ص�����Я������
			setResult(RESULT_OK, intent2);
			finish();
			break;
			
		case R.id.ass_btn_back3:// resultCode ����
			Intent intent3 = new Intent();
			intent3.putExtra("msg3", contentET3.getText().toString());
			// �ص�����Я������
			setResult(RESULT_CODE_1, intent3);
			finish();
			break;
		default:
			break;
		}
		
	}

}
