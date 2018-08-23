package com.sutest.shixun.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sutest.shixun.R;
import com.sutest.shixun.view.MyDialog;

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
		myDialog.setTitle("提示");
		myDialog.setMessage("您确定要退出吗？您确定要退出吗？");
		myDialog.setOkBnListener("立即退出", new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "退出", Toast.LENGTH_SHORT).show();
				myDialog.dismiss();
			}
		});
//		myDialog.setcancelBnListener("稍后再说", new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
//				myDialog.dismiss();
//			}
//		});
		myDialog.show();
		
		
	}
	
	

}
