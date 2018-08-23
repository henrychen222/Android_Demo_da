package com.sutest.shixun.dialog;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sutest.shixun.R;
import com.sutest.shixun.adapter.PeopleBaseAdapter;
import com.sutest.shixun.item.PeopleItem;

public class DialogCustomListActy extends Activity implements View.OnClickListener{

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
		userCenterBN.setText("点击我");
		
	}

	private void setListener() {
		userCenterBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adt_btn_userCenter:// 选择爱好
			// 选择爱好
			showChooseDialog();
			break;
		default:
			break;
		}
		
	}

	
	private AlertDialog tipDialog;
	// 
	private void showChooseDialog() {
		
		if (tipDialog == null) {
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
			builder.setTitle("请选择以下成员");
			builder.setIcon(R.drawable.ic_launcher);
			// 数据源
			List<PeopleItem> peopleList = new ArrayList<PeopleItem>();
			PeopleItem item;
			for (int i = 0; i < 5; i++) {
				item = new PeopleItem();
				item.setName("张三" + i);
				item.setPhone("1361511927" + i);
				item.setAge(20);
				peopleList.add(item);
			}
			
			// 适配器
			final PeopleBaseAdapter adapter = new PeopleBaseAdapter(mContext, peopleList);
			// 绑定适配器
			builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					PeopleItem item = (PeopleItem)adapter.getItem(which);
					
					msgTV.setText("选择了：" + item.getName());
				}
			});
			
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					tipDialog.dismiss();
				}
			});
			tipDialog = builder.create();
		}
		tipDialog.show();
		
		
	}
	
	
	
	

}
