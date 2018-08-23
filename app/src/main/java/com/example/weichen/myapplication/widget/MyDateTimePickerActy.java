package com.example.weichen.myapplication.widget;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.example.weichen.myapplication.R;

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
				// datePicker��ȡʱ��
				int year = dateDP.getYear();
				int month = dateDP.getMonth();
				int day = dateDP.getDayOfMonth();
				// ��ʾ�ı�������
				dateTV.setText("ѡ��������ǣ�" + year + "��" + (month + 1) + "��" + day + "��");
				
				// timePicker��ȡʱ��
				int hour = timeTP.getCurrentHour();
				int min = timeTP.getCurrentMinute();
				timeTV.setText("ѡ���ʱ���ǣ�" + hour + "ʱ" + min + "��");
				
			}
		});
		
	}

	private void initTimePicker() {
		timeTP = (TimePicker)findViewById(R.id.adt_tp_time);
		// ����24Сʱ
		timeTP.setIs24HourView(true);
		timeTP.setCurrentHour(12);
		timeTP.setCurrentMinute(55);
		
		timeTV = (TextView)findViewById(R.id.adt_tv_time);
		timeTP.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// ��ȡʱ��
				timeTV.setText("ʱ���ǣ�" + hourOfDay + "ʱ" + minute + "��");
			}
		});
		
		
	}

	private void initDatePicker() {
		dateDP = (DatePicker)findViewById(R.id.adt_dp_date);
		dateTV = (TextView)findViewById(R.id.adt_tv_date);
		// ��������
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int monthOfYear = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		
		// ��ʼ��
		dateDP.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				
				// ��ʾ�ı�������
				dateTV.setText("�����ǣ�" + year + "��" + (monthOfYear + 1) + "��" + dayOfMonth + "��");
				
			}
		});
		
		
	}
}
