package com.example.weichen.myapplication.dialog;

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

import com.example.weichen.myapplication.R;

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
		userCenterBN.setText("��ѡ����");
		
	}

	private void setListener() {
		userCenterBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adt_btn_userCenter:// ѡ�񰮺�
			// ѡ�񰮺�
			showChooseDialog();
			break;
		default:
			break;
		}
		
	}

	
	private String[] colorArr = new String[]{"����","��Ӿ","��Ϸ","��Ӱ"};
	private boolean[] booArr = new boolean[]{true, false, true, false};
	private List<Integer> selectedList = new ArrayList<Integer>();
	
	private AlertDialog tipDialog;
	// 
	private void showChooseDialog() {
		
		if (tipDialog == null) {
			selectedList.add(0); 
			selectedList.add(2); 

			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
			builder.setTitle("��ѡ�񰮺�");
			builder.setIcon(R.mipmap.ic_launcher);
			builder.setMultiChoiceItems(colorArr, booArr, new DialogInterface.OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					String tip = isChecked? "ѡ����":"ȡ����" + colorArr[which];
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
			builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					tipDialog.dismiss();

					String tip = "";
					for (int i = 0; i < selectedList.size(); i++) {
						int index = selectedList.get(i);
						tip += colorArr[index];
					}
					// ��ʾ���а���
					msgTV.setText(tip);
				}
			});
			tipDialog = builder.create();
		}
		tipDialog.show();
		
		
	}
	
	
	
	

}
