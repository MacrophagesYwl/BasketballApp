package com.example.basketballapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private int teamA, teamB, storageA, storageB;
    private final String KEY = "key";
    private final String MY_SP = "my_sp", MY_A = "my_A", MY_B = "my_B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        if (savedInstanceState != null) {
            int[] i = savedInstanceState.getIntArray(KEY);
            teamA = i[0];
            teamB = i[1];
            storageA = i[2];
            storageB = i[3];
        } else {
            init();
        }

        readSP();
        show();

        mBinding.buttonAAdd1.setOnClickListener(v -> {
            addA(1);
        });
        mBinding.buttonAAdd2.setOnClickListener(v -> {
            addA(2);
        });
        mBinding.buttonAAdd3.setOnClickListener(v -> {
            addA(3);
        });
        mBinding.buttonAAdd4.setOnClickListener(v -> {
            addB(1);
        });
        mBinding.buttonAAdd5.setOnClickListener(v -> {
            addB(2);
        });
        mBinding.buttonAAdd6.setOnClickListener(v -> {
            addB(3);
        });
        mBinding.imageButtonRevoke.setOnClickListener(v -> {
            revoke();

        });
        mBinding.imageButtonReset.setOnClickListener(v -> {
            reset();
        });
    }

    ;

    public void addA(int i) {
        Storage();
        teamA += i;
        show();
    }

    public void addB(int i) {
        Storage();
        teamB += i;
        show();
    }

    public void show() {
        mBinding.textScoreA.setText(String.valueOf(teamA));
        mBinding.textScoreB.setText(String.valueOf(teamB));
    }

    public void revoke() {
        teamA = storageA;
        teamB = storageB;
        show();
    }

    public void reset() {
        Storage();
        teamB = 0;
        teamA = 0;
        show();
    }

    public void Storage() {
        storageA = Integer.parseInt(mBinding.textScoreA.getText().toString());
        storageB = Integer.parseInt(mBinding.textScoreB.getText().toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(KEY, new int[]{teamA, teamB, storageA, storageB});
    }

    public void init() {
        teamA = 0;
        teamB = 0;
        storageA = 0;
        storageB = 0;
        show();
    }

    private void readSP() {
        SharedPreferences sp = getSharedPreferences(MY_SP, MODE_PRIVATE);
        teamA = sp.getInt(MY_A, 0);
        teamB = sp.getInt(MY_B, 0);
    }

    private void writeSP() {
        SharedPreferences.Editor sp = getSharedPreferences(MY_SP, MODE_PRIVATE).edit();
        sp.putInt(MY_A, teamA).putInt(MY_B, teamB).apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        writeSP();
    }

}