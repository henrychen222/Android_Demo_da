package com.example.weichen.myapplication.widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.weichen.myapplication.R;

public class MyRadioGroupActy extends Activity implements CompoundButton.OnCheckedChangeListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_radiogroup);
		
		// 
		initRadioGroup();
		// 
		initCheckBox();
		// 
		initToggleButton();
		
	}

	private void initToggleButton() {
		ToggleButton toggleTB = (ToggleButton)findViewById(R.id.ar_tb_toggle);
		toggleTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					Toast.makeText(MyRadioGroupActy.this, "���˿���", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MyRadioGroupActy.this, "�ر��˿���", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void initCheckBox() {
		CheckBox readCB = (CheckBox)findViewById(R.id.ar_cb_read);
		CheckBox swimCB = (CheckBox)findViewById(R.id.ar_cb_swim);
		CheckBox netCB = (CheckBox)findViewById(R.id.ar_cb_net);
		CheckBox gameCB = (CheckBox)findViewById(R.id.ar_cb_game);
		
		readCB.setChecked(false);
		
		// �������
		readCB.setOnCheckedChangeListener(this);
		// ��Ӿ����
		swimCB.setOnCheckedChangeListener(this);
		netCB.setOnCheckedChangeListener(this);
		gameCB.setOnCheckedChangeListener(this);
	}

	private void initRadioGroup() {
		RadioGroup radioGroupRG = (RadioGroup)findViewById(R.id.ar_rg_group);
		// ѡ�����
		radioGroupRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.ar_rb_man:// ѡ����
					Toast.makeText(MyRadioGroupActy.this, "��ѡ�������", Toast.LENGTH_SHORT).show();
					break;
				case R.id.ar_rb_woman:// ѡ��Ů
					Toast.makeText(MyRadioGroupActy.this, "��ѡ�����Ů", Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
				}
				
				
			}
		});
	}

	@Override
	public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
		switch (checkBox.getId()) {
		case R.id.ar_cb_read:// �������
			if (isChecked) {
				Toast.makeText(MyRadioGroupActy.this, "��ѡ���˶���", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MyRadioGroupActy.this, "��δѡ�ж���", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.ar_cb_swim:// ��Ӿ����
			if (isChecked) {
				Toast.makeText(MyRadioGroupActy.this, "��ѡ������Ӿ", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MyRadioGroupActy.this, "��δѡ����Ӿ", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.ar_cb_net:// ����
			if (isChecked) {
				Toast.makeText(MyRadioGroupActy.this, "��ѡ��������", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MyRadioGroupActy.this, "��δѡ������", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.ar_cb_game:// ��Ϸ
			if (isChecked) {
				Toast.makeText(MyRadioGroupActy.this, "��ѡ������Ϸ", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MyRadioGroupActy.this, "��δѡ����Ϸ", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
		
	}
	
	
	
	
	
}
