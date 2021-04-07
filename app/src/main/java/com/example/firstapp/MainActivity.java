package com.example.firstapp;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button uThumb;
    private Button dThumb;
    private TextView upCount;
    private TextView downCount;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uThumb = findViewById(R.id.thumb_up);
        dThumb = findViewById(R.id.thumb_down);
        upCount = findViewById(R.id.up_count);
        downCount = findViewById(R.id.down_count);
        final int upTemp = Integer.parseInt(String.valueOf(upCount.getText()));
        final int downTemp = Integer.parseInt(String.valueOf(downCount.getText()));


        uThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int downTemp = Integer.parseInt(String.valueOf(downCount.getText()));
                if(downTemp != 0 ) {
                    downTemp = downTemp - 1;
                    downCount.setText(String.valueOf(downTemp));
                }
                if (!uThumb.isSelected()) {
                    int temp = upTemp;
                    temp = temp + 1;
                    upCount.setText(String.valueOf(temp));

                    uThumb.setSelected(true);
                    uThumb.setEnabled(false);
                    dThumb.setSelected(false);
                    dThumb.setEnabled(true);

                }


            }
        });

        dThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int upTemp = Integer.parseInt(String.valueOf(upCount.getText()));
                if(upTemp != 0 ) {
                    upTemp = upTemp - 1;
                    upCount.setText(String.valueOf(upTemp));
                }
                if (!dThumb.isSelected()) {
                    int temp = upTemp;
                    temp = temp + 1;
                    downCount.setText(String.valueOf(temp));

                    dThumb.setSelected(true);
                    dThumb.setEnabled(false);
                    uThumb.setSelected(false);
                    uThumb.setEnabled(true);
                    Log.d("tess", "싫어요" + dThumb.isSelected());
                    Log.d("tess", "싫어요");
                }

            }
        });

    }
}

