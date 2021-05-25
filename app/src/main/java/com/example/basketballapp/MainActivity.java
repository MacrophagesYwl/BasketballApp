package com.example.basketballapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
        mBinding.imageButtonRevoke.setOnClickListener(v -> {
            revoke();

        });
        mBinding.imageButtonReset.setOnClickListener(v -> {
            reset();
        });
    };
    public void addA(int i){
        save();
        scroeA += i;
        show();
    }

    public void addB(int i){
        save();
        scroeB += i;
        show();
    }

    public void  show(){
        mBinding.textScoreA.setText(String.valueOf(scroeA));
        mBinding.textScoreB.setText(String.valueOf(scroeB));
    }

    public void revoke(){
        scroeA = saveA;
        scroeB = saveB;
        show();
    }

    public void reset(){
        save();
        scroeB = 0;
        scroeA = 0;
        show();
    }

    public void save(){
        saveA = Integer.parseInt(mBinding.textScoreA.getText().toString());
        saveB = Integer.parseInt(mBinding.textScoreB.getText().toString());
    }
}