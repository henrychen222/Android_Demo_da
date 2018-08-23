package com.sutest.shixun.acty.anim;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sutest.shixun.R;

/**
 * ÖðÖ¡¶¯»­
 * @author wwx220
 *
 */
public class FrameActy extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_frame);
		
		ImageView imageIV = (ImageView)findViewById(R.id.af_iv_anim);
		final AnimationDrawable animationDrawable = (AnimationDrawable)imageIV.getBackground();
		
		findViewById(R.id.af_bn_play).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ²¥·Å
				animationDrawable.start();
				
			}
		});
		findViewById(R.id.af_bn_stop).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Í£Ö¹
				animationDrawable.stop();
				
			}
		});
		
		
	}
	
	

}
