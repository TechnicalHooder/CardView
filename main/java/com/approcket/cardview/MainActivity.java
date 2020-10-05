package com.approcket.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toolbar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    Activity mActivity;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
    Unbinder mUnbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //((TextView) findViewById(R.id.tv)).setText("Welcome user");
        mUnbinder = ButterKnife.bind(this);

        ArrayList<Data> list = new ArrayList<>();
        list.add(new Data(Data.VIEW_PAGER, "Hello. This is the View Pager view type with images", 0));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.disney_cinderalla));
        list.add(new Data(Data.AUDIO_TYPE, "Hey, A view type with Button and Textview", 0));
        list.add(new Data(Data.IMAGE_TYPE, "Hi again. A view with Image and Textview", R.drawable.snow));

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list, this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) mUnbinder.unbind();
    }

}