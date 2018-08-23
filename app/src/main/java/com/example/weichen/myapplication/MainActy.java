package com.example.weichen.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.weichen.myapplication.acty.AActy;
import com.example.weichen.myapplication.acty.DataBaseActy;
import com.example.weichen.myapplication.acty.DownloadBitmapActy;
import com.example.weichen.myapplication.acty.RegisterActy;
import com.example.weichen.myapplication.acty.SharedPreferencesActy;
import com.example.weichen.myapplication.acty.StartActivityForResultActy;
import com.example.weichen.myapplication.acty.TakePhotosActy;
import com.example.weichen.myapplication.acty.anim.ButterflyActy;
import com.example.weichen.myapplication.acty.anim.FrameActy;
import com.example.weichen.myapplication.acty.anim.TweenActy;
import com.example.weichen.myapplication.acty.listener.HandlerActy;
import com.example.weichen.myapplication.acty.listener.SyncImageLoaderActy;
import com.example.weichen.myapplication.acty.listener.ThiefActy;
import com.example.weichen.myapplication.acty.service.MusicListActy;
import com.example.weichen.myapplication.acty.webservice.WebServiceActy;
import com.example.weichen.myapplication.dialog.AllDialogActy;
import com.example.weichen.myapplication.widget.MyAutoCompleteTextViewActy;
import com.example.weichen.myapplication.widget.MyButtonActy;
import com.example.weichen.myapplication.widget.MyDateTimePickerActy;
import com.example.weichen.myapplication.widget.MyEditTextActy;
import com.example.weichen.myapplication.widget.MyExpandableListView;
import com.example.weichen.myapplication.widget.MyGalleryActy;
import com.example.weichen.myapplication.widget.MyGridViewActy;
import com.example.weichen.myapplication.widget.MyListViewActy;
import com.example.weichen.myapplication.widget.MyPeopleEditActy;
import com.example.weichen.myapplication.widget.MyProgressActy;
import com.example.weichen.myapplication.widget.MyRadioGroupActy;
import com.example.weichen.myapplication.widget.MyTextViewActy;

public class MainActy extends Activity {
	
	private String[] array = new String[]{
			"TextView","EditText","Button",
			"RadioGroup","MyAutoCompleteTextViewActy","MyDateTimePickerActy",
			"MyProgressActy","MyListViewActy","MainActivity",
			"MyGridViewActy","MyGalleryActy","MyPeopleEditActy",
			"MyExpandableListView","StartActivityForResultActy",
			"TakePhotosActy","SharedPreferencesActy","AllDialogActy",
			
			"HandlerActy", "DownloadImageActy", 
			"ThiefActy(С͵�Ĺ���)",
			"SyncImageLoaderActy",
			
			"AActy",
			
			"FrameActy",
			"TweenActy",
			"ButterflyActy",
			"DataBaseActy",
			"MusicListActy",
			"WebServiceActy"
			};
	private Class[] actys = new Class[]{
			MyTextViewActy.class, MyEditTextActy.class, MyButtonActy.class,
			MyRadioGroupActy.class, MyAutoCompleteTextViewActy.class, MyDateTimePickerActy.class,
			MyProgressActy.class, MyListViewActy.class, RegisterActy.class,
			MyGridViewActy.class,MyGalleryActy.class, MyPeopleEditActy.class,
			MyExpandableListView.class,StartActivityForResultActy.class,
			TakePhotosActy.class,SharedPreferencesActy.class, AllDialogActy.class,
			
			
			HandlerActy.class, DownloadBitmapActy.class,
			ThiefActy.class,
			SyncImageLoaderActy.class,
			
			AActy.class,
			
			FrameActy.class,
			TweenActy.class,
			ButterflyActy.class,
			DataBaseActy.class,
			MusicListActy.class,
			WebServiceActy.class
			};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_main);
		
		
		ListView listLV = (ListView)findViewById(R.id.am_lv_list);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActy.this, 
				android.
				R.layout.simple_list_item_1, array);
		
		listLV.setAdapter(adapter);
		
		
		
		listLV.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				Intent intent = new Intent(MainActy.this, actys[position]);
				startActivity(intent);
				
				
			}
		});
		
		
		
		
	}

	

}
