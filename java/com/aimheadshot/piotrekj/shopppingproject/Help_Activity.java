package com.aimheadshot.piotrekj.shopppingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aimheadshot.guptastationery.R;

public class Help_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
