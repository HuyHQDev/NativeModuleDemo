package com.nativemoduledemo.module;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;

/**
 * Created by bapvn on 8/24/17.
 */

public class MathModule extends ReactContextBaseJavaModule {

    public MathModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Math";
    }

    @ReactMethod
    public void add(ReadableArray numbers, Promise promise) {
        double total = 0;
        for (Object number : numbers.toArrayList()) {
            total += (double) number;
        }

        promise.resolve(total);
    }

    @ReactMethod
    public void doubleValue(ReadableArray numbers, Promise promise) {
        WritableArray result = new WritableNativeArray();

        for (Object number : numbers.toArrayList()) {
            result.pushDouble((double) number * 2);
        }

        promise.resolve(result);
    }

}
