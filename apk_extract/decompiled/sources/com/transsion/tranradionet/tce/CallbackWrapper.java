package com.transsion.tranradionet.tce;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class CallbackWrapper extends ITceCallback.Stub {
    private final TceCallback mCallback;
    private final Executor mExecutor;
    private final Map<Integer, SensorEvent> mSensorEvents;
    private final Set<Integer> mSensorHandles;
    private final TceManager mTceManager;
    private final Set<Integer> mTceTypes;

    public CallbackWrapper(TceCallback tceCallback, TceManager tceManager) {
        this.mTceTypes = new HashSet();
        this.mSensorHandles = new HashSet();
        this.mSensorEvents = new HashMap();
        this.mCallback = tceCallback;
        this.mExecutor = tceCallback.getExecutor();
        this.mTceManager = tceManager;
    }

    private SensorEvent createSensorEvent(int i8, float[] fArr, int i9, long j8) {
        SensorEvent sensorEvent;
        if (fArr == null || i8 == -1) {
            return null;
        }
        try {
            Sensor sensorByHandle = this.mTceManager.getSensorByHandle(i8);
            if (sensorByHandle == null) {
                return null;
            }
            synchronized (this.mSensorEvents) {
                sensorEvent = this.mSensorEvents.get(Integer.valueOf(i8));
            }
            if (sensorEvent == null) {
                sensorEvent = new SensorEvent(sensorByHandle, i9, j8, fArr);
                synchronized (this.mSensorEvents) {
                    this.mSensorEvents.put(Integer.valueOf(i8), sensorEvent);
                }
            } else {
                updateSensorEventFields(sensorEvent, sensorByHandle, i9, j8, fArr);
            }
            return sensorEvent;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSensorChanged$1(int i8, float[] fArr, int i9, long j8) {
        SensorEvent sensorEventCreateSensorEvent = createSensorEvent(i8, fArr, i9, j8);
        if (sensorEventCreateSensorEvent != null) {
            this.mCallback.onSensorChanged(sensorEventCreateSensorEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTceEvent$0(TceEvent tceEvent) {
        this.mCallback.onTceEvent(tceEvent);
    }

    private void updateSensorEventFields(SensorEvent sensorEvent, Sensor sensor, int i8, long j8, float[] fArr) {
        float[] fArr2 = sensorEvent.values;
        System.arraycopy(fArr, 0, fArr2, 0, Math.min(fArr.length, fArr2.length));
        sensorEvent.timestamp = j8;
        sensorEvent.accuracy = i8;
        sensorEvent.sensor = sensor;
    }

    public void addSensorHandle(int i8) {
        synchronized (this.mSensorHandles) {
            this.mSensorHandles.add(Integer.valueOf(i8));
        }
    }

    public void addTceType(int i8) {
        synchronized (this.mTceTypes) {
            this.mTceTypes.add(Integer.valueOf(i8));
        }
    }

    public void cleanup() {
        synchronized (this.mSensorEvents) {
            this.mSensorEvents.clear();
        }
        synchronized (this.mTceTypes) {
            this.mTceTypes.clear();
        }
        synchronized (this.mSensorHandles) {
            this.mSensorHandles.clear();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mCallback.equals(((CallbackWrapper) obj).mCallback);
    }

    public TceCallback getCallback() {
        return this.mCallback;
    }

    public boolean hasRegistrations() {
        boolean z2;
        synchronized (this.mTceTypes) {
            synchronized (this.mSensorHandles) {
                try {
                    z2 = (this.mTceTypes.isEmpty() && this.mSensorHandles.isEmpty()) ? false : true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return z2;
    }

    public boolean hasSensorHandle(int i8) {
        boolean zContains;
        synchronized (this.mSensorHandles) {
            zContains = this.mSensorHandles.contains(Integer.valueOf(i8));
        }
        return zContains;
    }

    public boolean hasSensorHandles() {
        boolean z2;
        synchronized (this.mSensorHandles) {
            z2 = !this.mSensorHandles.isEmpty();
        }
        return z2;
    }

    public boolean hasTceType(int i8) {
        boolean zContains;
        synchronized (this.mTceTypes) {
            zContains = this.mTceTypes.contains(Integer.valueOf(i8));
        }
        return zContains;
    }

    public boolean hasTceTypes() {
        boolean z2;
        synchronized (this.mTceTypes) {
            z2 = !this.mTceTypes.isEmpty();
        }
        return z2;
    }

    public int hashCode() {
        return this.mCallback.hashCode();
    }

    @Override // com.transsion.tranradionet.tce.ITceCallback
    public void onSensorChanged(final int i8, final float[] fArr, final int i9, final long j8) throws RemoteException {
        this.mExecutor.execute(new Runnable() { // from class: com.transsion.tranradionet.tce.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f2957a.lambda$onSensorChanged$1(i8, fArr, i9, j8);
            }
        });
    }

    @Override // com.transsion.tranradionet.tce.ITceCallback
    public void onTceEvent(final TceEvent tceEvent) throws RemoteException {
        this.mExecutor.execute(new Runnable() { // from class: com.transsion.tranradionet.tce.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f2961a.lambda$onTceEvent$0(tceEvent);
            }
        });
    }

    public void removeSensorHandle(int i8) {
        synchronized (this.mSensorHandles) {
            this.mSensorHandles.remove(Integer.valueOf(i8));
        }
    }

    public void removeTceType(int i8) {
        synchronized (this.mTceTypes) {
            this.mTceTypes.remove(Integer.valueOf(i8));
        }
    }

    public String toString() {
        return "CallbackWrapper{callback=" + this.mCallback + "}";
    }

    public CallbackWrapper(TceCallback tceCallback) {
        this.mTceTypes = new HashSet();
        this.mSensorHandles = new HashSet();
        this.mSensorEvents = new HashMap();
        this.mCallback = tceCallback;
        this.mExecutor = tceCallback.getExecutor();
        this.mTceManager = null;
    }
}
