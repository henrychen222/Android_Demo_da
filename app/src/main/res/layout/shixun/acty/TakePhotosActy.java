package com.sutest.shixun.acty;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.sutest.shixun.R;

public class TakePhotosActy extends Activity implements OnClickListener{

	private ImageView picIV;
	private String savePicPath;
	/** 拍照*/
	private final int RC_TAKEPHOTO = 0x12;
	/** 相册*/
	private final int RC_ALBUM = 0x13;
	/** 裁剪*/
	private final int RC_CUT = 0x14;
	private String picName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_take_photos);
		
		initVar();
		
		findViews();
		
		bindViews();
		
		setListener();
	}
	
	


	private void initVar() {
		savePicPath = "/mnt/sdcard/shixun/imageCache/";
		// 创建文件夹
		File file = new File(savePicPath);
		if (!file.exists()) {
			// 根据路径一层层创建文件夹
			file.mkdirs();
		}
		
		
	}

	private void findViews() {
		picIV = (ImageView)findViewById(R.id.atp_iv_pic1);
		
	}

	private void bindViews() {
		
	}
	
	private void setListener() {
		findViewById(R.id.atp_btn_takephoto).setOnClickListener(this);
		findViewById(R.id.atp_btn_album).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.atp_btn_takephoto:// 拍照
			picName = System.currentTimeMillis() + ".png";
			// 获取照片的意图
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
			// 保存到外部存储，指定存储路径
			intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(savePicPath, picName)));
			// 启动拍照意图，进入系统拍照页面
			startActivityForResult(intent, RC_TAKEPHOTO);
			
			break;
		case R.id.atp_btn_album:// 相册
			picName = System.currentTimeMillis() + ".png";
			Intent intent2 = new Intent(Intent.ACTION_PICK, null);
			// 指定数据类型
			intent2.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			// 启动系统相册选择照片页面
			startActivityForResult(intent2, RC_ALBUM);
			
			break;
		default:
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Log.i("", "onActivityResult--->requestCode:" + requestCode);
		
		if (resultCode == 0) {
			return;
		}
		
		// 拍照
		if (requestCode == RC_TAKEPHOTO) {
			File file = new File(savePicPath, picName);
			// 裁剪页面
			startCutZoom(Uri.fromFile(file));
		}
		
		if (intent == null) {
			return;
		}
		
		// 相册
		if (requestCode == RC_ALBUM) {
			startCutZoom(intent.getData());
		}
		
		// 裁剪
		if (requestCode == RC_CUT) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				Bitmap bm = bundle.getParcelable("data");
				// 设置到ImageView上
				picIV.setImageBitmap(bm);
			}
			
		}
		
		
		super.onActivityResult(requestCode, resultCode, intent);
	}


	private void startCutZoom(Uri uri){
		// 系统裁剪页面
		Intent intent = new Intent("com.android.camera.action.CROP", null);
		// 在intent上绑定照片数据及格式
		intent.setDataAndType(uri, "image/*");
		// 是否裁剪
		intent.putExtra("crop", true);
		// 裁剪宽度比例
		intent.putExtra("aspectX", 1);
		// 裁剪高度比例
		intent.putExtra("aspectY", 1);
		// 输出图片宽度
		intent.putExtra("outputX", 300);
		// 输出图片高度
		intent.putExtra("outputY", 300);
		// 是否返回数据
		intent.putExtra("return-data", true);
		// 启动裁剪意图，进入系统裁剪页面
		startActivityForResult(intent, RC_CUT);
		
		
	}

	
	
	
	

}
