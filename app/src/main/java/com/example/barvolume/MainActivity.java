package com.example.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.barvolume.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String STATE_RESULT = "state_result";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnCalculate.setOnClickListener(this);

        if(savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            binding.tvResult.setText(result);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, binding.tvResult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputLength = binding.edtLength.getText().toString().trim();
            String inputWidth = binding.edtWidth.getText().toString().trim();
            String inputHeight = binding.edtHeight.getText().toString().trim();


            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                binding.edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                binding.edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                binding.edtHeight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {
                Double volume = Double.valueOf(inputLength) * Double.valueOf(inputHeight) * Double.valueOf(inputWidth);
                binding.tvResult.setText(String.valueOf(volume));
            }

        }
    }
}