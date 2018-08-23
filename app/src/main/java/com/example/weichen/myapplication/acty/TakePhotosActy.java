package com.example.weichen.myapplication.acty;

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

import com.example.weichen.myapplication.R;

public class TakePhotosActy extends Activity implements OnClickListener{

	private ImageView picIV;
	private String savePicPath;
	/** ����*/
	private final int RC_TAKEPHOTO = 0x12;
	/** ���*/
	private final int RC_ALBUM = 0x13;
	/** �ü�*/
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
		// �����ļ���
		File file = new File(savePicPath);
		if (!file.exists()) {
			// ����·��һ��㴴���ļ���
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
		case R.id.atp_btn_takephoto:// ����
			picName = System.currentTimeMillis() + ".png";
			// ��ȡ��Ƭ����ͼ
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
			// ���浽�ⲿ�洢��ָ���洢·��
			intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(savePicPath, picName)));
			// ����������ͼ������ϵͳ����ҳ��
			startActivityForResult(intent, RC_TAKEPHOTO);
			
			break;
		case R.id.atp_btn_album:// ���
			picName = System.currentTimeMillis() + ".png";
			Intent intent2 = new Intent(Intent.ACTION_PICK, null);
			// ָ����������
			intent2.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			// ����ϵͳ���ѡ����Ƭҳ��
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
		
		// ����
		if (requestCode == RC_TAKEPHOTO) {
			File file = new File(savePicPath, picName);
			// �ü�ҳ��
			startCutZoom(Uri.fromFile(file));
		}
		
		if (intent == null) {
			return;
		}
		
		// ���
		if (requestCode == RC_ALBUM) {
			startCutZoom(intent.getData());
		}
		
		// �ü�
		if (requestCode == RC_CUT) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				Bitmap bm = bundle.getParcelable("data");
				// ���õ�ImageView��
				picIV.setImageBitmap(bm);
			}
			
		}
		
		
		super.onActivityResult(requestCode, resultCode, intent);
	}


	private void startCutZoom(Uri uri){
		// ϵͳ�ü�ҳ��
		Intent intent = new Intent("com.android.camera.action.CROP", null);
		// ��intent�ϰ���Ƭ���ݼ���ʽ
		intent.setDataAndType(uri, "image/*");
		// �Ƿ�ü�
		intent.putExtra("crop", true);
		// �ü���ȱ���
		intent.putExtra("aspectX", 1);
		// �ü��߶ȱ���
		intent.putExtra("aspectY", 1);
		// ���ͼƬ���
		intent.putExtra("outputX", 300);
		// ���ͼƬ�߶�
		intent.putExtra("outputY", 300);
		// �Ƿ񷵻�����
		intent.putExtra("return-data", true);
		// �����ü���ͼ������ϵͳ�ü�ҳ��
		startActivityForResult(intent, RC_CUT);
		
		
	}

	
	
	
	

}
