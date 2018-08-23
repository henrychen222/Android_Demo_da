package com.sutest.shixun.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sutest.shixun.R;

public class DialogSingleChooseActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button userCenterBN;
	private TextView msgTV;
	
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
		userCenterBN.setText("请选择颜色");
		
	}

	private void setListener() {
		userCenterBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adt_btn_userCenter:// 选择颜色
			// 选择颜色
			showChooseColorDialog();
			break;
		default:
			break;
		}
		
	}

	
	private String[] colorArr = new String[]{"红色","黄色","蓝色"};
	private AlertDialog tipDialog;
	// 
	private void showChooseColorDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		builder.setTitle("请选择颜色");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setSingleChoiceItems(colorArr, 1, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String tip = "选择的颜色为：" + colorArr[which];
				msgTV.setText(tip);
			}
		});
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				tipDialog.dismiss();
			}
		});
		tipDialog = builder.create();
		
		tipDialog.show();
		
		
	}
	
	
	
	

}
