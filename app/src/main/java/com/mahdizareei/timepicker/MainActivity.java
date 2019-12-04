package com.mahdizareei.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mahdizareei.mztimepicker.MZTimePicker;
import com.mahdizareei.mztimepicker.interfaces.OnTimeSelectedListener;
import com.mahdizareei.mztimepicker.models.TimeModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.click);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MZTimePicker(MainActivity.this)
                        .setDeleteTimeText("لغو")
                        .setConfirmTimeText("تایید")
                        .setToTitle("از زمان")
                        .setFromTitle("تا زمان")
                        .setTabFont("myfont.ttf")
                        .setTabColor(getResources().getColor(R.color.colorPrimary))
                        .setConfirmButtonColor(getResources().getColor(R.color.colorAccent))
                        .setDeleteButtonColor(getResources().getColor(R.color.colorAccent))
                        .setConfirmTextColor(getResources().getColor(R.color.color_button_x4))
                        .setDeleteTextColor(getResources().getColor(R.color.color_button_x4))
                        .BuildTimePicker(new OnTimeSelectedListener() {
                            @Override
                            public void onTimeSelected(TimeModel time1, TimeModel time2) {
                                textView.setText(String.format("%s:%s | %s:%s", time1.getHour(), time1.getMinute(), time2.getHour(), time2.getMinute()));
                            }
                        });
            }
        });
    }
}
