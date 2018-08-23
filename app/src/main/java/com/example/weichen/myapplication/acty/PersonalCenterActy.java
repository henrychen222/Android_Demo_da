package com.example.weichen.myapplication.acty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.weichen.myapplication.R;

public class PersonalCenterActy extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal);

		String username = getIntent().getStringExtra("username");
		String userpwd = getIntent().getStringExtra("userpwd");
		String sex = getIntent().getStringExtra("sex");
		String userprovince = getIntent().getStringExtra("userprovince");
		String datetime = getIntent().getStringExtra("datetime");
		String hobby = getIntent().getStringExtra("hobby");
		String stars1 = getIntent().getStringExtra("stars1");
		String stars2 = getIntent().getStringExtra("stars2");
		String stars3 = getIntent().getStringExtra("stars3");
		TextView tvname = (TextView) findViewById(R.id.am_username);
		TextView tvpwd = (TextView) findViewById(R.id.ap_pwd);
		TextView tvsex = (TextView) findViewById(R.id.man);
		TextView tvlocal = (TextView) findViewById(R.id.am_province);
		TextView tvtime = (TextView) findViewById(R.id.ab_year);
		TextView tvhobby = (TextView) findViewById(R.id.read);
		TextView tvratingbar1 = (TextView) findViewById(R.id.ab_ratingbar1);
		TextView tvratingbar2 = (TextView) findViewById(R.id.ab_ratingbar2);
		TextView tvratingbar3 = (TextView) findViewById(R.id.ab_ratingbar3);
		tvname.setText(username);
		tvpwd.setText(userpwd);
		tvsex.setText(sex);
		tvlocal.setText(userprovince);
		tvtime.setText(datetime);
		tvhobby.setText(hobby);
		tvratingbar1.setText(stars1);
		tvratingbar2.setText(stars2);
		tvratingbar3.setText(stars3);
		Button butback = (Button) findViewById(R.id.ap_bt_back);
		butback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PersonalCenterActy.this,
						RegisterActy.class);
				startActivity(intent);
			}
		});
	}
}
