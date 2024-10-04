package com.example.healthcareapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

public class NavigationActivity extends AppCompatActivity {

    ViewPager slideViewPager;
    ViewPAgerAdapter viewPAgerAdapter;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navigation);

        nextButton=findViewById(R.id.nextBtn);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0)<1){
                    slideViewPager.setCurrentItem(getItem(1),true);
                }else {
                    Intent intent = new Intent(NavigationActivity.this, GetStarted.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        slideViewPager = (ViewPager) findViewById(R.id.slideViewpager);
        viewPAgerAdapter = new ViewPAgerAdapter(this);
        slideViewPager.setAdapter(viewPAgerAdapter);



    }
    private int getItem(int i){
        return slideViewPager.getCurrentItem()+i;
    }
}