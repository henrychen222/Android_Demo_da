package com.example.weichen.myapplication.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.weichen.myapplication.R;

public class MyAutoCompleteTextViewActy extends Activity {

	private AutoCompleteTextView tipATV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_autocomplete);
		
		
		
		tipATV = (AutoCompleteTextView)findViewById(R.id.aa_atv_tip);
		// ����Դ
		String[] arrays = getResources().getStringArray(R.array.list);
//		String[] arrays = new String[]{"",""};
		/*
		 *  ������
		 *  android.R.layout.simple_spinner_dropdown_item ��Ϊ�б����
		 *  
		 */
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
				MyAutoCompleteTextViewActy.this, 
				android.R.layout.simple_spinner_dropdown_item, 
				arrays);
//		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		tipATV.setAdapter(arrayAdapter);
		
		
		
		Spinner spinner = (Spinner)findViewById(R.id.aa_s_country);
		final String[] countrys = getResources().getStringArray(R.array.list);
		/*
		 *  ������
		 *  android.R.layout.simple_spinner_item ��Ϊ�ؼ���ʾ����
		 *  android.R.layout.simple_spinner_dropdown_item ��Ϊ�б����
		 *  
		 */
		ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(
				MyAutoCompleteTextViewActy.this, 
				android.R.layout.simple_spinner_item, 
				countrys);
		countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(countryAdapter);
		
		// �б�����¼�
//		spinner.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				 String msg = "�����" + countrys[position];
//				 Toast.makeText(MyAutoCompleteTextViewActy.this, msg, Toast.LENGTH_SHORT).show();
//			}
//		});
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				 String msg = "�����" + countrys[position];
				 Toast.makeText(MyAutoCompleteTextViewActy.this, msg, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
			
		});
		
		
		
		
	}
}
