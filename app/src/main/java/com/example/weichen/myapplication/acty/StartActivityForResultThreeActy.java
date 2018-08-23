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
public class StartActivityForResultThreeActy extends Activity implements View.OnClickListener{
	
	private EditText contentET1;
	/** ����ʡ����*/
	public static final int RESULT_CODE_2 = 0x13;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_startactivityforresult_three);
		
		contentET1 = (EditText)findViewById(R.id.ast_et_content2);
		
		findViewById(R.id.ast_btn_back2).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ast_btn_back2:// ʡ����
			Intent intent = new Intent();
			intent.putExtra("msg4", contentET1.getText().toString());
			setResult(RESULT_CODE_2, intent);
			finish();
			break;
		default:
			break;
		}
		
	}

}
