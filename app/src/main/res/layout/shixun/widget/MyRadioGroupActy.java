package com.sutest.shixun.widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.sutest.shixun.R;

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
					Toast.makeText(MyRadioGroupActy.this, "打开了开关", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MyRadioGroupActy.this, "关闭了开关", Toast.LENGTH_SHORT).show();
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
		
		// 读书监听
		readCB.setOnCheckedChangeListener(this);
		// 游泳监听
		swimCB.setOnCheckedChangeListener(this);
		netCB.setOnCheckedChangeListener(this);
		gameCB.setOnCheckedChangeListener(this);
	}

	private void initRadioGroup() {
		RadioGroup radioGroupRG = (RadioGroup)findViewById(R.id.ar_rg_group);
		// 选择监听
		radioGroupRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.ar_rb_man:// 选择男
					Toast.makeText(MyRadioGroupActy.this, "您选择的是男", Toast.LENGTH_SHORT).show();
					break;
				case R.id.ar_rb_woman:// 选择女
					Toast.makeText(MyRadioGroupActy.this, "您选择的是女", Toast.LENGTH_SHORT).show();
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
		case R.id.ar_cb_read:// 读书监听
			if (isChecked) {
				Toast.makeText(MyRadioGroupActy.this, "您选中了读书", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MyRadioGroupActy.this, "您未选中读书", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.ar_cb_swim:// 游泳监听
			if (isChecked) {
				Toast.makeText(MyRadioGroupActy.this, "您选中了游泳", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MyRadioGroupActy.this, "您未选中游泳", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.ar_cb_net:// 上网
			if (isChecked) {
				Toast.makeText(MyRadioGroupActy.this, "您选中了上网", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MyRadioGroupActy.this, "您未选中上网", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.ar_cb_game:// 游戏
			if (isChecked) {
				Toast.makeText(MyRadioGroupActy.this, "您选中了游戏", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MyRadioGroupActy.this, "您未选中游戏", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
		
	}
	
	
	
	
	
}
