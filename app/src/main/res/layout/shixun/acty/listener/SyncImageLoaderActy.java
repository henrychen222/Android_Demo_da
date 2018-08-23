package com.sutest.shixun.acty.listener;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sutest.shixun.R;
import com.sutest.shixun.acty.listener.SyncImgLoader.OnloadImage;

public class SyncImageLoaderActy extends Activity{

	
	private SyncImgLoader syncImgLoader;
	private Button downloadBN;
	private Button resetBN;
	private ImageView imgIV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_sync_img_load);
		
		initVar();
		
		findViews();
		
		setClickListener();
		
	}
	
	
	private void setClickListener() {
		resetBN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 加载默认图片
				imgIV.setImageResource(R.drawable.public_img_default);
				
			}
		});
		downloadBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String imageUrl = "http://img1.2345.com/duoteimg/qqTxImg/2013/04/22/13667761307.jpg";
				// 异步加载
				syncImgLoader.loadImage(imageUrl, new OnloadImage() {
					
					@Override
					public void loadFinish(Bitmap bitmap) {
						imgIV.setImageBitmap(bitmap);
					}
					
					@Override
					public void loadFail() {
						imgIV.setImageResource(R.drawable.public_img_fail);
					}
				});
				
			}
		});
		
	}


	private void initVar() {
		syncImgLoader = new SyncImgLoader();
	}


	private void findViews() {
		downloadBN = (Button)findViewById(R.id.asil_bn_download);
		resetBN = (Button)findViewById(R.id.asil_bn_reset);
		imgIV = (ImageView)findViewById(R.id.asil_iv_img);
		
	}
	
	
	
	
}
