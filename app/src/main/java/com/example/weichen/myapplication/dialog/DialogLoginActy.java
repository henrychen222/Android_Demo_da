package com.example.weichen.myapplication.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weichen.myapplication.R;

public class DialogLoginActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button userCenterBN;
	private TextView msgTV;
	private AlertDialog loginDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_dialog_tip);
		
		mContext = this;
		
		initVar();
		
		findViews();
		
		bindViews();
		
		setListener();
		
	}

	private void initVar() {

	}

	private void findViews() {
		userCenterBN = (Button)findViewById(R.id.adt_btn_userCenter);
		msgTV = (TextView)findViewById(R.id.adt_tv_msg);
	}

	private void bindViews() {
		userCenterBN.setText("���¼");
		
	}

	private void setListener() {
		userCenterBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adt_btn_userCenter:// ѡ����ɫ
			// ѡ����ɫ
			showLoginDialog();
			break;
		default:
			break;
		}
		
	}

	
	private void showLoginDialog() {
		
		if (loginDialog == null) {
			// ��һ��
			// View rootView = LayoutInflater.from(mContext).inflate(R.layout.dlg_login, null);
			// ������
			View rootView = getLayoutInflater().inflate(R.layout.dlg_login, null);

			final EditText nameET = (EditText)rootView.findViewById(R.id.dl_et_name);
			final EditText passET = (EditText)rootView.findViewById(R.id.dl_et_pass); 
			Button loginBN = (Button)rootView.findViewById(R.id.dl_bn_login); 
			Button registerBN = (Button)rootView.findViewById(R.id.dl_bn_register); 
			
			loginBN.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (TextUtils.isEmpty(nameET.getText().toString())) {
						Toast.makeText(mContext, "�û�������Ϊ��", Toast.LENGTH_SHORT).show();
						return;
					}
					
					
					Toast.makeText(mContext, "��¼--->", Toast.LENGTH_SHORT).show();
					loginDialog.dismiss();
					
				}
			});
			registerBN.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(mContext, "ע��--->", Toast.LENGTH_SHORT).show();
					loginDialog.dismiss();
				}
			});

			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
			builder.setView(rootView);

			loginDialog = builder.create();
		}
		loginDialog.show();
		
		
	}
	
	
	
	

}
