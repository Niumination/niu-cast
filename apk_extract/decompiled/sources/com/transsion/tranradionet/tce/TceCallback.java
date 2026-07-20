package com.transsion.tranradionet.tce;

import android.hardware.SensorEvent;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TceCallback {
    public static final int MODE_TYPE_ELEVATOR = 1;
    public static final int MODE_TYPE_SENSOR = 3;
    public static final int MODE_TYPE_VEHICLE = 2;
    private Executor mExecutor;
    private final long mTceId;

    public TceCallback() {
        this(new r0.a(new Handler(Looper.getMainLooper())));
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public long getTceId() {
        return this.mTceId;
    }

    public abstract void onSensorChanged(SensorEvent sensorEvent);

    public abstract void onTceEvent(TceEvent tceEvent);

    public void setExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TceCallback(Handler handler) {
        this(new r0.a(handler));
        Objects.requireNonNull(handler);
    }

    public TceCallback(Executor executor) {
        this.mTceId = System.currentTimeMillis();
        this.mExecutor = executor;
    }
}
