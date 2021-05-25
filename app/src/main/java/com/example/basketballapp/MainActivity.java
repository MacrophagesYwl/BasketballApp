package com.example.basketballapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ActionMenuView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.basketballapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private int scroeA,scroeB,saveA,saveB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        show();

        mBinding.buttonAAdd1.setOnClickListener(v ->{
            addA(1);
        });
        mBinding.buttonAAdd2.setOnClickListener(v ->{
            addA(2);
        });
        mBinding.buttonAAdd3.setOnClickListener(v ->{
            addA(3);
        });
        mBinding.buttonAAdd4.setOnClickListener(v ->{
            addB(1);
        });
        mBinding.buttonAAdd5.setOnClickListener(v ->{
            addB(2);
        });
        mBinding.buttonAAdd6.setOnClickListener(v ->{
            addB(3);
        });
    }
    public void addA(int i){
        scroeA += i;
        show();
    }

    public void addB(int i){
        scroeB += i;
        show();
    }

    public void  show(){
        mBinding.textScoreA.setText(String.valueOf(scroeA));
        mBinding.textScoreB.setText(String.valueOf(scroeB));
    }
}