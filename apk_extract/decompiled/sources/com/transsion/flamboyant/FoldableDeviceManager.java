package com.transsion.flamboyant;

import android.content.Context;
import android.hardware.Sensor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class FoldableDeviceManager {
    public static final int STATE_CLOSE = 0;
    public static final int STATE_HALF_OPEN = 1;
    public static final int STATE_OPEN = 2;
    public static final int TYPE_FOLD = 16;
    public static final int TYPE_FOLD_POCKET = 17;
    public static final int TYPE_NONE = 0;

    public interface StateChangedListener {
        void onStateChangedListener(int i8, int i9);
    }

    private FoldableDeviceManager() {
        throw new RuntimeException("Stub!");
    }

    public static FoldableDeviceManager get(Context context) {
        throw new RuntimeException("Stub!");
    }

    public static Sensor getHingeAngleSensor(Context context) {
        throw new RuntimeException("Stub!");
    }

    public int getCurrentFoldState() {
        throw new RuntimeException("Stub!");
    }

    public int getDeviceType() {
        throw new RuntimeException("Stub!");
    }

    public PocketDisplay getPocketDisplay() {
        throw new RuntimeException("Stub!");
    }

    public boolean isFoldableDevice() {
        throw new RuntimeException("Stub!");
    }

    public void registerStateChangedListener(StateChangedListener stateChangedListener, Executor executor) {
        throw new RuntimeException("Stub!");
    }

    public void unregisterStateChangedListener(StateChangedListener stateChangedListener) {
        throw new RuntimeException("Stub!");
    }
}
