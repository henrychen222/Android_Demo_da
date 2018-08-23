package com.example.weichen.myapplication.acty;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weichen.myapplication.R;

public class SharedPreferencesActy extends Activity implements OnClickListener{

	private SharedPreferences mySPF;
	private EditText passET;
	private EditText nameET;
	private EditText floatET;
	private Button saveBN;
	private Button getBN;
	private TextView msgTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_sharedpreferences);

		initVar();

		findViews();

		bindViews();
		
		setListener();

	}


	private void initVar() {
		mySPF = this.getSharedPreferences("mySPF", Activity.MODE_PRIVATE);

	}

	private void findViews() {
		nameET = (EditText) findViewById(R.id.as_et_name);
		passET = (EditText) findViewById(R.id.as_et_pass);
		floatET = (EditText) findViewById(R.id.as_et_float);

		saveBN = (Button) findViewById(R.id.as_bn_save);
		getBN = (Button) findViewById(R.id.as_bn_get);
		
		msgTV = (TextView) findViewById(R.id.as_tv_msg);

	}

	private void bindViews() {

	}
	
	private void setListener() {
		saveBN.setOnClickListener(this);
		getBN.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.as_bn_save:// ����
			Editor edit = mySPF.edit();
			edit.putString("name", nameET.getText().toString());
			edit.putString("pass", passET.getText().toString());
			edit.putBoolean("autoLogin", true);
			try {
				float value = Float.valueOf(floatET.getText().toString());
				edit.putFloat("floatKey", value);
			} catch (Exception e) {
				
			}
			// �ύ���޸��ļ�
			edit.commit();
			
			break;
		case R.id.as_bn_get:
			String name = mySPF.getString("name", "null");
			String pass = mySPF.getString("pass", "null");
			float f = mySPF.getFloat("floatKey", -1f);
			boolean autoLogin = mySPF.getBoolean("autoLogin", false);
			
			String text = "name:" + name + "\n pass:" + pass 
					+ "\n float:" + f + "\n autoLogin:" + autoLogin;
			msgTV.setText(text);
			
			break;
		default:
			break;
		}
		
	}

}
