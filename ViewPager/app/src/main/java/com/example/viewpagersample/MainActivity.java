package com.example.viewpagersample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.viewpagersample.Adapter.CustomPageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager myViewPager = (ViewPager) findViewById(R.id.newViewPager);
        myViewPager.setAdapter(new CustomPageAdapter(this));

    }
}
