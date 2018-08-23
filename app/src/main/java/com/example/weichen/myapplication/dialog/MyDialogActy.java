package com.example.weichen.myapplication.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.view.MyDialog;

public class MyDialogActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button userCenterBN;
	
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
	}

	private void bindViews() {
		
	}

	private void setListener() {
		userCenterBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adt_btn_userCenter:// 
			showMyDialog();
			break;
		default:
			break;
		}
		
	}
	
	
	private void showMyDialog(){
		final MyDialog myDialog = new MyDialog(mContext);
		myDialog.setTitle("��ʾ");
		myDialog.setMessage("��ȷ��Ҫ�˳�����ȷ��Ҫ�˳���");
		myDialog.setOkBnListener("�����˳�", new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "�˳�", Toast.LENGTH_SHORT).show();
				myDialog.dismiss();
			}
		});
//		myDialog.setcancelBnListener("�Ժ���˵", new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(mContext, "ȡ��", Toast.LENGTH_SHORT).show();
//				myDialog.dismiss();
//			}
//		});
		myDialog.show();
		
		
	}
	
	

}
