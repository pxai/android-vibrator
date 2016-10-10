package io.pello.android.vibratorplayground;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Playing with the vibrator
 * @author PELLO_ALTADILL
 * Check API for more options
 * https://developer.android.com/reference/android/os/Vibrator.html
 */
public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private TextView textView;
    private  Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    /**
     * You know how to turn me on
     * @param view
     */
    public void vibrate (View view) {
        int time = 1;

        // Check if number is correct
        if (!editTextNumber.getText().toString().isEmpty()) {
            time = Integer.parseInt(editTextNumber.getText().toString());
        }

        // shake it
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(time);

            // patterns: gap, vibrate time, gap, vibrate time, gap,...
            long[] pattern = { 1000, 100, 0, 200, 100, 200 };
            // vibrate patterns and repeat
            vibrator.vibrate(pattern, 1);
        }


    }
}
