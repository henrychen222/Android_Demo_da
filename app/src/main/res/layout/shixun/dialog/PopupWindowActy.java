package com.sutest.shixun.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.sutest.shixun.R;

public class PopupWindowActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button buttonBN;
	private TextView msgTV;
	private PopupWindow popupWindow;
	
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
		buttonBN = (Button)findViewById(R.id.adt_btn_userCenter);
		msgTV = (TextView)findViewById(R.id.adt_tv_msg);
	}

	private void bindViews() {
		buttonBN.setText("请登录PopupWindow");
		
	}

	private void setListener() {
		buttonBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adt_btn_userCenter:// PopupWindow
			// PopupWindow登录
			showLoginPopupWindow();
			break;
		default:
			break;
		}
		
	}

	
	private void showLoginPopupWindow() {

		if (popupWindow == null) {
			// 法一：
			// View rootView = LayoutInflater.from(mContext).inflate(R.layout.dlg_login, null);
			// 法二：
			View rootView = getLayoutInflater().inflate(R.layout.dlg_login, null);

			final EditText nameET = (EditText)rootView.findViewById(R.id.dl_et_name);
			final EditText passET = (EditText)rootView.findViewById(R.id.dl_et_pass); 
			Button loginBN = (Button)rootView.findViewById(R.id.dl_bn_login); 
			Button registerBN = (Button)rootView.findViewById(R.id.dl_bn_register); 

			loginBN.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (TextUtils.isEmpty(nameET.getText().toString())) {
						Toast.makeText(mContext, "用户名不能为空", Toast.LENGTH_SHORT).show();
						return;
					}


					Toast.makeText(mContext, "登录--->", Toast.LENGTH_SHORT).show();
					popupWindow.dismiss();

				}
			});
			registerBN.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(mContext, "注册--->", Toast.LENGTH_SHORT).show();
					popupWindow.dismiss();
				}
			});


			// 创建一个阻塞的对话框
			popupWindow = new PopupWindow(rootView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			// 是否可以获取焦点，弹出键盘
			popupWindow.setFocusable(true);
		}
		
		// 法一 显示在指定视图下面
//		popupWindow.showAsDropDown(buttonBN);
		// 法二 显示屏幕位置
		popupWindow.showAtLocation(buttonBN, Gravity.BOTTOM, 0, 0);
		
	}
	
	
	
	

}
