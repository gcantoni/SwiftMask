package it.gcantoni.swiftmask.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.provider.Settings;
import android.view.View;

import it.gcantoni.swiftmask.R;

public class GesturesUtils {

    // new method to detect the Gesture Navigation Mode (Android 10 Beta 5+)
    public static boolean isGesturesNavigationMode(ContentResolver content) {
        return Settings.Secure.getInt(content, "navigation_mode", 0) == 2;
    }

    public static void enableEdgeToEdgeNavigation(Context context, Activity activity) {
        // transparent navigation bar for devices with Android 10+
        if (Build.VERSION.SDK_INT >= 29) {
            boolean gestures = isGesturesNavigationMode(context.getContentResolver());
            // if user uses navigation gestures
            if(gestures) {
                switch (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
                    case Configuration.UI_MODE_NIGHT_YES:
                        activity.getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                        break;
                    case Configuration.UI_MODE_NIGHT_NO:
                        activity.getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                        break;
                } } else { // if user doesn't use navigation gestures
                switch (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
                    case Configuration.UI_MODE_NIGHT_YES:
                        activity.getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                        activity.getWindow().setNavigationBarColor(context.getColor(R.color.colorPrimary));
                        break;
                    case Configuration.UI_MODE_NIGHT_NO:
                        activity.getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                                        | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
                        activity.getWindow().setNavigationBarColor(context.getColor(R.color.colorPrimary));
                        break;
                }
            } }
    }
}
