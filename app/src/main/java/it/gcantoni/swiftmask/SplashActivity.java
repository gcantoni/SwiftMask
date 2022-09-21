package it.gcantoni.swiftmask;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.gcantoni.swiftmask.camera.DetectorActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // launch app
        startActivity(new Intent(this, DetectorActivity.class));
        finish();
    }
}

