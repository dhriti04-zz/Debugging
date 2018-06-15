package com.codepath.debuggingchallenges.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codepath.debuggingchallenges.R;

import java.util.Calendar;

public class CurrentDayActivity extends AppCompatActivity {

    TextView tvDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_day);
        tvDay = (TextView) findViewById(R.id.tvDay);

        Calendar cal = Calendar.getInstance();
        System.out.print(cal.get(Calendar.DAY_OF_MONTH));

        tvDay.setText(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));

    }

}
