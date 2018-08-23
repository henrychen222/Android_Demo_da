package com.example.weichen.myapplication.widget;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.weichen.myapplication.R;

public class MyEditTextActy extends Activity implements View.OnClickListener{

	private EditText testET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_edittext);
		
		
		testET = (EditText)findViewById(R.id.ae_et_test);
		// �����ı�����ı��¼�
		testET.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Log.e("textChange", "onTextChanged-->" + s.toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				Log.e("textChange", "beforeTextChanged-->" + s.toString());
			}
			
			@Override
			public void afterTextChanged(Editable editable) {
				Log.e("textChange", "afterTextChanged-->" + editable.toString());
				
			}
		});
		
		findViewById(R.id.ae_bn_show).setOnClickListener(this);
		findViewById(R.id.ae_bn_hide).setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ae_bn_show:// ������ʾ����
			testET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
			break;
		case R.id.ae_bn_hide:// ������������
			testET.setTransformationMethod(PasswordTransformationMethod.getInstance());
			break;

		default:
			break;
		}
	}

	
	
	
	

	
	
	
}
