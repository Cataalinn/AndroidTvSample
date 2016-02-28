package com.servicesample.androidtvsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.servicesample.androidtvsample.Fragment.VinesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction().add(R.id.content_main, new VinesFragment(), "").commit();
    }
}
