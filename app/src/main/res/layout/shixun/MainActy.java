package com.sutest.shixun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sutest.shixun.acty.AActy;
import com.sutest.shixun.acty.DataBaseActy;
import com.sutest.shixun.acty.DownloadBitmapActy;
import com.sutest.shixun.acty.RegisterActy;
import com.sutest.shixun.acty.SharedPreferencesActy;
import com.sutest.shixun.acty.StartActivityForResultActy;
import com.sutest.shixun.acty.TakePhotosActy;
import com.sutest.shixun.acty.anim.ButterflyActy;
import com.sutest.shixun.acty.anim.FrameActy;
import com.sutest.shixun.acty.anim.TweenActy;
import com.sutest.shixun.acty.listener.HandlerActy;
import com.sutest.shixun.acty.listener.SyncImageLoaderActy;
import com.sutest.shixun.acty.listener.ThiefActy;
import com.sutest.shixun.acty.service.MusicListActy;
import com.sutest.shixun.acty.webservice.WebServiceActy;
import com.sutest.shixun.dialog.AllDialogActy;
import com.sutest.shixun.widget.MyAutoCompleteTextViewActy;
import com.sutest.shixun.widget.MyButtonActy;
import com.sutest.shixun.widget.MyDateTimePickerActy;
import com.sutest.shixun.widget.MyEditTextActy;
import com.sutest.shixun.widget.MyExpandableListView;
import com.sutest.shixun.widget.MyGalleryActy;
import com.sutest.shixun.widget.MyGridViewActy;
import com.sutest.shixun.widget.MyListViewActy;
import com.sutest.shixun.widget.MyPeopleEditActy;
import com.sutest.shixun.widget.MyProgressActy;
import com.sutest.shixun.widget.MyRadioGroupActy;
import com.sutest.shixun.widget.MyTextViewActy;

public class MainActy extends Activity {
	
	private String[] array = new String[]{
			"TextView","EditText","Button",
			"RadioGroup","MyAutoCompleteTextViewActy","MyDateTimePickerActy",
			"MyProgressActy","MyListViewActy","MainActivity",
			"MyGridViewActy","MyGalleryActy","MyPeopleEditActy",
			"MyExpandableListView","StartActivityForResultActy",
			"TakePhotosActy","SharedPreferencesActy","AllDialogActy",
			
			"HandlerActy", "DownloadImageActy", 
			"ThiefActy(Ð¡ÍµµÄ¹ÊÊÂ)",
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
