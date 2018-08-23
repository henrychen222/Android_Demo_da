package com.example.weichen.myapplication.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.weichen.myapplication.R;

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
		case R.id.adt_btn_userCenter:// ��������
			// �ж��Ƿ��Ѿ���¼
			boolean isLogin = settingSPF.getBoolean("isLogin", false);
			// û�е�¼����������
			if (!isLogin) {
				// ��ʾ��¼
				showTipDialog();
			}
			// �Ѿ���¼��ֱ�ӽ����������ҳ��
			else{
				Toast.makeText(mContext, "׼�������������ҳ��", Toast.LENGTH_SHORT).show();
			}
			
			break;
		default:
			break;
		}
		
	}
	
	
	private void showTipDialog(){
		
		if (tipDialog == null) {
			// �Ի�������
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
			// ���ñ���
			builder.setTitle("��ʾ");
			// ����ͼ��
			// builder.setIcon(R.drawable.ic_launcher);
			// ������ʾ����
			builder.setMessage("����û�е�¼��������¼��");
			// ���û����İ�ť
			builder.setPositiveButton("������¼", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// ��ת����¼ҳ��
					settingSPF.edit()
					.putBoolean("isLogin", true)
					.commit();
					Toast.makeText(mContext, "ģ���¼�ɹ�", Toast.LENGTH_SHORT).show();
				}
			});
			// ����������ť
			builder.setNegativeButton("�Ժ���˵", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// ȡ���Ի���
					tipDialog.dismiss();
				}
			});
			// ���������Ի��򷽷�
			tipDialog = builder.create();
		}
		// ��ʾ�Ի���
		tipDialog.show();
		
	}
	
	

}
