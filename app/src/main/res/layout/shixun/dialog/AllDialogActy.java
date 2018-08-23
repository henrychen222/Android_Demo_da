package com.sutest.shixun.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sutest.shixun.R;

public class AllDialogActy extends Activity {
	
	private String[] array = new String[]{
			"DialogTipActy","DialogSingleChooseActy","DialogMultiChooseActy",
			"DialogCustomListActy","DialogDateTimePickerActy","DialogLoginActy",
			"PopupWindowActy","ProgressDialgActy","MyDialogActy"
			
			};
	private Class[] actys = new Class[]{
			DialogTipActy.class, DialogSingleChooseActy.class,DialogMultiChooseActy.class,
			DialogCustomListActy.class, DialogDateTimePickerActy.class,DialogLoginActy.class,
			PopupWindowActy.class,ProgressDialgActy.class,MyDialogActy.class
			};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_main);
		
		
		ListView listLV = (ListView)findViewById(R.id.am_lv_list);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				AllDialogActy.this, 
				android.
				R.layout.simple_list_item_1, array);
		
		listLV.setAdapter(adapter);
		
		
		
		listLV.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				Intent intent = new Intent(AllDialogActy.this, actys[position]);
				startActivity(intent);
				
				
			}
		});
		
		
		
		
	}

	

}
