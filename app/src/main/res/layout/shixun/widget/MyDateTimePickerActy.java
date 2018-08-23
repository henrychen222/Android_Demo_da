package com.sutest.shixun.widget;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.sutest.shixun.R;

public class MyDateTimePickerActy extends Activity {

	
	
	private TimePicker timeTP;
	private TextView timeTV;
	private DatePicker dateDP;
	private TextView dateTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_date_timepicker);
		
		
		initDatePicker();
		
		
		initTimePicker();
		
		getTime();
		
	}

	private void getTime() {
		findViewById(R.id.adt_bn_getTime).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// datePicker获取时间
				int year = dateDP.getYear();
				int month = dateDP.getMonth();
				int day = dateDP.getDayOfMonth();
				// 显示改变后的生日
				dateTV.setText("选择的日期是：" + year + "年" + (month + 1) + "月" + day + "日");
				
				// timePicker获取时间
				int hour = timeTP.getCurrentHour();
				int min = timeTP.getCurrentMinute();
				timeTV.setText("选择的时间是：" + hour + "时" + min + "分");
				
			}
		});
		
	}

	private void initTimePicker() {
		timeTP = (TimePicker)findViewById(R.id.adt_tp_time);
		// 设置24小时
		timeTP.setIs24HourView(true);
		timeTP.setCurrentHour(12);
		timeTP.setCurrentMinute(55);
		
		timeTV = (TextView)findViewById(R.id.adt_tv_time);
		timeTP.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// 获取时间
				timeTV.setText("时间是：" + hourOfDay + "时" + minute + "分");
			}
		});
		
		
	}

	private void initDatePicker() {
		dateDP = (DatePicker)findViewById(R.id.adt_dp_date);
		dateTV = (TextView)findViewById(R.id.adt_tv_date);
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int monthOfYear = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		
		// 初始化
		dateDP.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				
				// 显示改变后的生日
				dateTV.setText("生日是：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
				
			}
		});
		
		
	}
}
