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

public class DialogMultiChooseActy extends Activity implements View.OnClickListener{

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
		userCenterBN.setText("请选爱好");
		
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

	
	private String[] colorArr = new String[]{"读书","游泳","游戏","电影"};
	private boolean[] booArr = new boolean[]{true, false, true, false};
	private List<Integer> selectedList = new ArrayList<Integer>();
	
	private AlertDialog tipDialog;
	// 
	private void showChooseDialog() {
		
		if (tipDialog == null) {
			selectedList.add(0); 
			selectedList.add(2); 

			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
			builder.setTitle("请选择爱好");
			builder.setIcon(R.drawable.ic_launcher);
			builder.setMultiChoiceItems(colorArr, booArr, new DialogInterface.OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					String tip = isChecked? "选中了":"取消了" + colorArr[which];
					msgTV.setText(tip);

					if (isChecked) {
						if (!selectedList.contains(which)) {
							selectedList.add(new Integer(which));
						}
					}else {
						if (selectedList.contains(which)) {
//							selectedList.remove(which);
							selectedList.remove(new Integer(which));
						}
					}

				}
			});
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					tipDialog.dismiss();

					String tip = "";
					for (int i = 0; i < selectedList.size(); i++) {
						int index = selectedList.get(i);
						tip += colorArr[index];
					}
					// 显示所有爱好
					msgTV.setText(tip);
				}
			});
			tipDialog = builder.create();
		}
		tipDialog.show();
		
		
	}
	
	
	
	

}
