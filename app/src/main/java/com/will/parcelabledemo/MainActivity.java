package com.will.parcelabledemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.will.parcelabledemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editTextName.getText().toString().trim();
                String strAge = binding.editTextAge.getText().toString().trim();
                int age = strAge.isEmpty() ? 0 : Integer.parseInt(strAge);
                String strMath = binding.editTextMath.getText().toString().trim();
                int math = strMath.isEmpty() ? 0 : Integer.parseInt(strMath);
                String strEnglish = binding.editTextEnglish.getText().toString().trim();
                int english = strEnglish.isEmpty() ? 0 : Integer.parseInt(strEnglish);

                Student student = new Student(name,age,new Score(math,english));

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                Bundle bundle = new Bundle();
                bundle.putParcelable("student",student);
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });
    }
}