package com.example.android2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ItemViewModel itemViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView fragmentText = (TextView) findViewById(R.id.fragmentText);

        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        itemViewModel.getSelectedItem().observe(this, item -> {
            fragmentText.setText(item);
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment1 Fragment1 = new fragment1();
        fragment2 Fragment2 = new fragment2();
        fragmentManager.beginTransaction()
                .replace(R.id.framelayout,Fragment1)
                .commit();
        Button first_fragment_btn = (Button)findViewById(R.id.btn_fragment1);
        first_fragment_btn.setOnClickListener((View v) -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.framelayout,Fragment1)
                    .commit();
        });
        Button second_fragment_btn = (Button)findViewById(R.id.btn_fragment2);
        second_fragment_btn.setOnClickListener((View v) -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.framelayout, Fragment2)
                    .commit();
        });
    }
}