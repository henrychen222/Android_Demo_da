package com.sutest.shixun.acty;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

import com.sutest.shixun.R;

public class RegisterActy extends Activity implements CompoundButton.OnCheckedChangeListener {
	
	private Calendar calendar = Calendar.getInstance();
	private Spinner spinner;
	private EditText dritusername;
	private EditText am_password;
	private String username = "";
	private String userpwd = "";
	private String sex = "";
	private Button buttonlogin;
	private RadioGroup radiog;
	private String userprovince = "";
	private Spinner spinner2;
	private DatePicker date;
	private String datetime;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private CheckBox checkbox3;
	private CheckBox checkbox4;
	private CheckBox checkbox5;
	private CheckBox checkbox6;
	private String hobby = "";
	private RatingBar ratingBar;
	private String stars1 = "";
	private String stars2 = "";
	private String stars3 = "";
	private EditText am_password2;
	private RadioButton radiowoman;
	private RadioButton radioman;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		// LinearLayout lin = (LinearLayout) findViewById(R.id.am_comments);
		// lin.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// }
		// });

		userEidt();

		passwordEdit();

		sinnerInit();

		radioSex();

		dateMethord();

		starsMethord();

		initChecBox();

		// initRegister2();

	}

	private void initRegister() {
		buttonlogin = (Button) findViewById(R.id.ab_login);
		buttonlogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				// 用户名、密码、性别、出生地、我的爱好、自我评价（勤劳、上进、勇敢）为必填项，

				// 用户名为空
				if (TextUtils.isEmpty(dritusername.getText().toString())) {
					Toast.makeText(RegisterActy.this, "用户名不能为空",
							Toast.LENGTH_SHORT).show();
					return;
				}

				if (dritusername.getText().length() < 4) {
					Toast.makeText(RegisterActy.this, "用户名不能小于4个字符",
							Toast.LENGTH_SHORT).show();
					return;
				}

				if (TextUtils.isEmpty(am_password.getText().toString())) {
					Toast.makeText(RegisterActy.this, "密码不能为空",
							Toast.LENGTH_SHORT).show();
					return;
				}

				if (TextUtils.isEmpty(am_password2.getText().toString())) {
					Toast.makeText(RegisterActy.this, "重复密码不能为空",
							Toast.LENGTH_SHORT).show();
					return;
				}

				if (!TextUtils.equals(am_password.getText().toString(),
						am_password2.getText().toString())) {
					am_password.setText("");
					am_password2.setText("");

					Toast.makeText(RegisterActy.this, "两次密码不一样",
							Toast.LENGTH_SHORT).show();
					return;
				}

			}
		});
	}

	private void initRegister2() {
		buttonlogin = (Button) findViewById(R.id.ab_login);
		buttonlogin.setOnClickListener(new OnClickListener() {

			private String msg;

			@Override
			public void onClick(View v) {
				msg = "";
				username = dritusername.getText().toString();
				userpwd = am_password.getText().toString();
				// sex
				userprovince = spinner.getSelectedItem().toString()
						+ spinner2.getSelectedItem().toString();
				// dateyear datemonth datedate hobby
				if (username.equals("")) {
					msg += " 用户名不能为空 ";
					Toast.makeText(RegisterActy.this, msg, Toast.LENGTH_SHORT)
							.show();
				} else {
					if (userpwd.equals("")) {
						msg += " 密码不能为空 ";
						Toast.makeText(RegisterActy.this, msg,
								Toast.LENGTH_SHORT).show();
					} else {
						if (sex.equals("")) {
							msg += " 性别不能为空 ";
							Toast.makeText(RegisterActy.this, msg,
									Toast.LENGTH_SHORT).show();
						} else {
							if (userprovince.equals("")) {
								msg += " 出生地不能为空 ";
								Toast.makeText(RegisterActy.this, msg,
										Toast.LENGTH_SHORT).show();
							} else {
								if (hobby.equals("")) {
									msg += " 爱好至少选一项 ";
									Toast.makeText(RegisterActy.this, msg,
											Toast.LENGTH_SHORT).show();
								}

								else {
									if (stars1.equals("")) {
										msg += " 自我评价勤劳不能为空 ";
										Toast.makeText(RegisterActy.this, msg,
												Toast.LENGTH_SHORT).show();
									} else {
										if (stars2.equals("")) {
											msg += " 自我评价上进不能为空 ";
											Toast.makeText(RegisterActy.this,
													msg, Toast.LENGTH_SHORT)
													.show();
										} else {
											if (stars3.equals("")) {
												msg += " 自我评价勇敢不能为空 ";
												Toast.makeText(
														RegisterActy.this, msg,
														Toast.LENGTH_SHORT)
														.show();
											} else {

												Intent intent = new Intent(
														RegisterActy.this,
														PersonalCenterActy.class);
												intent.putExtra("username",
														username);
												intent.putExtra("userpwd",
														userpwd);
												intent.putExtra("sex", sex);
												intent.putExtra("userprovince",
														userprovince);
												intent.putExtra("datetime",
														datetime);
												intent.putExtra("hobby", hobby);
												intent.putExtra("stars1",
														stars1);
												intent.putExtra("stars2",
														stars2);
												intent.putExtra("stars3",
														stars3);
												startActivity(intent);
												Toast.makeText(
														RegisterActy.this,
														"注册成功",
														Toast.LENGTH_SHORT)
														.show();
												finish();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
	}

	private void initChecBox() {
		checkbox1 = (CheckBox) findViewById(R.id.read);
		checkbox1.setOnCheckedChangeListener(this);
		checkbox2 = (CheckBox) findViewById(R.id.coding);
		checkbox2.setOnCheckedChangeListener(this);
		checkbox3 = (CheckBox) findViewById(R.id.sing);
		checkbox3.setOnCheckedChangeListener(this);
		checkbox4 = (CheckBox) findViewById(R.id.swim);
		checkbox4.setOnCheckedChangeListener(this);
		checkbox5 = (CheckBox) findViewById(R.id.game);
		checkbox5.setOnCheckedChangeListener(this);
		checkbox6 = (CheckBox) findViewById(R.id.sports);
		checkbox6.setOnCheckedChangeListener(this);
	}

	private void starsMethord() {
		ratingBar = (RatingBar) findViewById(R.id.ab_ratingbar1);
		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				stars1 = rating + "颗星";
			}
		});
		ratingBar = (RatingBar) findViewById(R.id.ab_ratingbar2);
		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				stars2 = rating + "颗星";
			}
		});
		ratingBar = (RatingBar) findViewById(R.id.ab_ratingbar3);
		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				stars3 = rating + "颗星";
			}
		});
	}

	private void dateMethord() {
		date = (DatePicker) findViewById(R.id.ab_datepicker);
		int year = calendar.get(Calendar.YEAR);
		int monthOfYear = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		date.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				datetime = year + "年" + (monthOfYear + 1) + "月" + dayOfMonth
						+ "日";

			}
		});
	}

	private void radioSex() {
		radiog = (RadioGroup) findViewById(R.id.ar_rg);

		radioman = (RadioButton) findViewById(R.id.man);
		radioman.setChecked(true);
		sex = "男";
		radiowoman = (RadioButton) findViewById(R.id.woman);
		radiog.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.man:
					radioman.setFocusable(true);
					radioman.setFocusableInTouchMode(true);
					sex = "男";
					break;
				case R.id.woman:
					radiowoman.setFocusable(true);
					radiowoman.setFocusableInTouchMode(true);
					sex = "女";
					break;

				default:
					break;
				}
			}
		});
	}

	private void sinnerInit() {
		spinner = (Spinner) findViewById(R.id.am_province);
		String[] arrarys = new String[] { "江苏", "安徽", "辽宁" };
		ArrayAdapter<String> arraryAdapter = new ArrayAdapter<String>(
				RegisterActy.this, android.R.layout.simple_spinner_item,
				arrarys);
		arraryAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(arraryAdapter);

		spinner2 = (Spinner) findViewById(R.id.am_city);
		String[] arrarys1 = new String[] { "南京", "南通", "连云港", "淮安" };
		ArrayAdapter<String> arraryAdapter1 = new ArrayAdapter<String>(
				RegisterActy.this, android.R.layout.simple_spinner_item,
				arrarys1);
		arraryAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(arraryAdapter1);
	}

	private void passwordEdit() {
		am_password = (EditText) findViewById(R.id.am_password);
		am_password.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					if (!(am_password.getText().toString().length() < 13 && am_password
							.getText().toString().length() > 5)) {
						Toast.makeText(RegisterActy.this, "请重新输入6-12位密码",
								Toast.LENGTH_SHORT).show();
						am_password.setText("");
					}
				}
			}
		});
		am_password2 = (EditText) findViewById(R.id.affirmpwd);
		am_password2.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					//
					if (!am_password.hasFocus()) {
						if (am_password.getText().toString()
								.equals(am_password2.getText().toString())) {
							Toast.makeText(RegisterActy.this, "确认密码正确",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(RegisterActy.this, "确认密码有误,请重新输入",
									Toast.LENGTH_SHORT).show();
							am_password2.setText("");
						}
					}
				}
			}
		});

	}

	private void userEidt() {
		dritusername = (EditText) findViewById(R.id.am_username);
		dritusername.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					if (dritusername.getText().toString().length() < 4) {
						Toast.makeText(RegisterActy.this, "用户名不得低于4个字符",
								Toast.LENGTH_SHORT).show();
						dritusername.setText("");
					}
				}

			}
		});
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.read:
			if (isChecked) {
				hobby += " 阅读 ";
			}
			break;
		case R.id.coding:
			if (isChecked) {
				hobby += " 编码 ";
			}
			break;
		case R.id.sing:
			if (isChecked) {
				hobby += " 唱歌 ";
			}
			break;
		case R.id.swim:
			if (isChecked) {
				hobby += " 游泳 ";
			}
			break;
		case R.id.game:
			if (isChecked) {
				hobby += " 游戏 ";
			}
			break;
		case R.id.sports:
			if (isChecked) {
				hobby += " 体育 ";
			}
			break;

		default:
			break;
		}
	}

}
