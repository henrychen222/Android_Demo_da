package com.sutest.shixun.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sutest.shixun.R;

public class DialogTipActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button userCenterBN;
	private SharedPreferences settingSPF;
	private AlertDialog tipDialog;
	
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
		settingSPF = getSharedPreferences("mySPF", Activity.MODE_PRIVATE);
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
		case R.id.adt_btn_userCenter:// 个人中心
			// 判断是否已经登录
			boolean isLogin = settingSPF.getBoolean("isLogin", false);
			// 没有登录，弹框提醒
			if (!isLogin) {
				// 提示登录
				showTipDialog();
			}
			// 已经登录，直接进入个人中心页面
			else{
				Toast.makeText(mContext, "准备跳入个人中心页面", Toast.LENGTH_SHORT).show();
			}
			
			break;
		default:
			break;
		}
		
	}
	
	
	private void showTipDialog(){
		
		if (tipDialog == null) {
			// 对话框建造者
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
			// 设置标题
			builder.setTitle("提示");
			// 设置图标
			// builder.setIcon(R.drawable.ic_launcher);
			// 设置提示内容
			builder.setMessage("您还没有登录，立即登录？");
			// 设置积极的按钮
			builder.setPositiveButton("立即登录", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// 跳转到登录页面
					settingSPF.edit()
					.putBoolean("isLogin", true)
					.commit();
					Toast.makeText(mContext, "模拟登录成功", Toast.LENGTH_SHORT).show();
				}
			});
			// 设置消极按钮
			builder.setNegativeButton("以后再说", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// 取消对话框
					tipDialog.dismiss();
				}
			});
			// 真正创建对话框方法
			tipDialog = builder.create();
		}
		// 显示对话框
		tipDialog.show();
		
	}
	
	

}
