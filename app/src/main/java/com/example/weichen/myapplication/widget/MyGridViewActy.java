package com.example.weichen.myapplication.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.adapter.QiuBaseAdapter;
import com.example.weichen.myapplication.item.QiuItem;

public class MyGridViewActy extends Activity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_grid_view);

        initVar();

        findViews();

        bindViews();

    }

    private void initVar() {

    }

    private void findViews() {
        gridView = (GridView) findViewById(R.id.agv_gv_grid);

    }

    private void bindViews() {
        List<QiuItem> qiuList = new ArrayList<QiuItem>();
        int[] imageIds = new int[]{R.mipmap.bomb5, R.mipmap.bomb6, R.mipmap.bomb7, R.mipmap.bomb8, R.mipmap.bomb9, R.mipmap.bomb10, R.mipmap.bomb11, R.mipmap.bomb12, R.mipmap.bomb13,
                R.mipmap.bomb14, R.mipmap.bomb15, R.mipmap.bomb16};
        QiuItem qiuItem;
        for (int i = 0; i < imageIds.length; i++) {
            qiuItem = new QiuItem();
            qiuItem.setName("����ը��" + i);
            qiuItem.setResId(imageIds[i]);
            qiuList.add(qiuItem);
        }

        QiuBaseAdapter qiuBaseAdapter = new QiuBaseAdapter(MyGridViewActy.this, qiuList);

        gridView.setAdapter(qiuBaseAdapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("", "position-->" + position);
            }
        });

    }


}
