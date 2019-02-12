package com.example.choi.project_gitae;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {



    public static FragmentManager fm;
    public static FragmentTransaction ft;
    public static Fragment frame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm = getFragmentManager();
        frame = fm.findFragmentById(R.id.frame);
        ft = fm.beginTransaction();


        ft.replace(R.id.frame, new home());
        ft.addToBackStack(null);
        ft.commit();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu1:
                    ft = fm.beginTransaction();
                    ft.replace(R.id.frame, new home());
                    ft.addToBackStack(null);
                    ft.commit();
                    return true;
                case R.id.menu2:
                    ft = fm.beginTransaction();

                    ft.addToBackStack(null);
                    ft.commit();
                    return true;
                case R.id.menu3:
                    return true;
                case R.id.menu4:
                    return true;
            }
            return false;
        }
    };

    public interface onKeyBackPressedListener {
        public void onBack();
    }

    private onKeyBackPressedListener mOnKeyBackPressedListener;

    public void setOnKeyBackPressedListener(onKeyBackPressedListener listener) {
        mOnKeyBackPressedListener = listener;
    }

    @Override
    public void onBackPressed() {
        if (mOnKeyBackPressedListener != null) {
            mOnKeyBackPressedListener.onBack();
        } else {
            super.onBackPressed();
        }
    }
}
