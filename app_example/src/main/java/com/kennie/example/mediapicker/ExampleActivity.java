package com.kennie.example.mediapicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kennie.example.library.R;
import com.kennie.library.media.picker.config.MediaMimeType;

public class ExampleActivity extends AppCompatActivity {

    private static String TAG = ExampleActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Log.i(TAG , "媒体长度："+MediaMimeType.ofAll().length);
        Log.i(TAG , "媒体长度："+MediaMimeType.ofImage()[0]);

    }
}