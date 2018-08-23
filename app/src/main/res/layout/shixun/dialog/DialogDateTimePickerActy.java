package com.sutest.shixun.dialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.sutest.shixun.R;

public class DialogDateTimePickerActy extends Activity implements View.OnClickListener{

	private Context mContext;
	private Button dateBN;
	private TextView msgTV;
	private Button timeBN;
	
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
		dateBN = (Button)findViewById(R.id.adt_btn_userCenter);
		timeBN = (Button)findViewById(R.id.adt_btn_time);
		msgTV = (TextView)findViewById(R.id.adt_tv_msg);
	}

	private void bindViews() {
		dateBN.setText("日期选择器弹框");
		timeBN.setVisibility(View.VISIBLE);
		
	}

	private void setListener() {
		dateBN.setOnClickListener(this);
		timeBN.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adt_btn_userCenter:// 日期
			// 日期弹框
			showDatePickerDialog();
			break;
		case R.id.adt_btn_time:// 时间
			// 时间弹框
			showTimePickerDialog();
			break;
		default:
			break;
		}
		
	}

	private Calendar calendar = Calendar.getInstance();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private DatePickerDialog dateDialog;
	private TimePickerDialog timePickerDialog;
	
	private void showDatePickerDialog() {
		int year = calendar.get(Calendar.YEAR);
		int monthOfYear = calendar.get(Calendar.MONTH);
		int dayofMonth = calendar.get(Calendar.DAY_OF_MONTH);
		
		if (dateDialog == null) {
			dateDialog = new DatePickerDialog(mContext, new OnDateSetListener() {
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					Log.i("date","year--->" + year);
					Log.i("date","monthOfYear--->" + monthOfYear);
					Log.i("date","dayOfMonth--->" + dayOfMonth);


					// 修改日历对象的年月日
					calendar.set(year, monthOfYear, dayOfMonth);
					String msg = sdf.format(calendar.getTime());

					msgTV.setText("选择的日期是：" + msg);


				}
			}, year, monthOfYear, dayofMonth);
		}
		dateDialog.show();
		
	}
	
	
	private void showTimePickerDialog() {
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		
		if (timePickerDialog == null) {
			timePickerDialog = new TimePickerDialog(mContext, new OnTimeSetListener() {

				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//					// 设置小时
//					calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
//					// 设置分钟
//					calendar.set(Calendar.MINUTE, minute);
					
					String msg = "选择的时间是：" + hourOfDay + "时" + minute + "分";
					msgTV.setText(msg);
					
				}
			}, hourOfDay, minute, true);
		}
		timePickerDialog.show();
	}
	
	
	
	

}
