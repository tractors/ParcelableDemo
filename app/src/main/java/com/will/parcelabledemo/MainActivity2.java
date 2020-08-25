package com.will.parcelabledemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.will.parcelabledemo.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2);
        Bundle bundle = getIntent().getBundleExtra("data");
        Student student = bundle.getParcelable("student");
        binding.textViewName.setText(student.getName());
        binding.textViewAge.setText(String.valueOf(student.getAge()));
        binding.textViewMath.setText(String.valueOf(student.getScore().getMath()));
        binding.textViewEnglish.setText(String.valueOf(student.getScore().getEnglish()));
    }
}