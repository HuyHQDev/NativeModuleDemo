package com.nativemoduledemo.module;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by bapvn on 8/23/17.
 */

public class SnackbarModule extends ReactContextBaseJavaModule {

    public SnackbarModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SnackbarAndroid";
    }

    @ReactMethod
    public void show(String message, int length) {
        Snackbar.make(((ViewGroup)getCurrentActivity().findViewById(android.R.id.content)).getChildAt(0), message, length)
                .show();
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("SHORT", Snackbar.LENGTH_SHORT);
        constants.put("LONG", Snackbar.LENGTH_LONG);
        constants.put("INDEFINITE", Snackbar.LENGTH_INDEFINITE);
        return constants;
    }

    @ReactMethod
    public void showWithAction(String message, String action, final Callback callback) {
        Snackbar.make(((ViewGroup)getCurrentActivity().findViewById(android.R.id.content)).getChildAt(0), message, Snackbar.LENGTH_INDEFINITE)
                .setAction(action, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callback.invoke();
                    }
                })
                .show();
    }

}
