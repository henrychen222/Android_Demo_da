package com.sutest.shixun.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sutest.shixun.R;

public class MyDialog extends Dialog {

	private Button okBN;
	private Button cancelBN;
	private TextView titleTV;
	private TextView msgTV;
	
	
	public MyDialog(Context context) {
		super(context, R.style.MyDialog);
//		super(context);
		setContentView(R.layout.dlg_mydialog);
		
		
		titleTV = (TextView)findViewById(R.id.title);
		msgTV = (TextView)findViewById(R.id.message);
		okBN = (Button)findViewById(R.id.ok);
		cancelBN = (Button)findViewById(R.id.cancel);
		
		okBN.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		cancelBN.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		
	}
	
	public void setOkBnListener(String okStr, android.view.View.OnClickListener onClickListener){
		okBN.setText(okStr);
		okBN.setOnClickListener(onClickListener);
	}
	
	public void setcancelBnListener(String cancelStr, android.view.View.OnClickListener onClickListener){
		if (TextUtils.isEmpty(cancelStr)) {
			cancelBN.setVisibility(View.GONE);
		}else {
			cancelBN.setText(cancelStr);
			cancelBN.setOnClickListener(onClickListener);
		}
	}
	
	public void setTitle(String title){
		titleTV.setText(title);
	}
	
	public void setMessage(String message){
		msgTV.setText(message);
	}

	
	
}
