package com.transsion.tranradionet.tce;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TceManager {
    public static final String BUNDLE_KEY_ODR = "odr";
    public static final int ODR_10HZ = 10;
    public static final int ODR_1HZ = 1;
    public static final int ODR_25HZ = 25;
    public static final int ODR_2HZ = 2;
    public static final int ODR_50HZ = 50;
    public static final int ODR_5HZ = 5;
    public static final int ODR_DEFAULT = 50;
    public static final int RESULT_ERROR = 1;
    public static final int RESULT_INVALID_PARAMETER = 2;
    public static final int RESULT_SERVICE_NOT_CONNECTED = 3;
    public static final int RESULT_SUCCESS = 0;
    private static final String SVC_NAME = "com.transsion.tranradionet.tce.TceService";
    private static final String SVC_PKG_NAME = "com.transsion.tranradionet";
    private static final String TAG = "TceManager";
    public static final String VER_INFO = "1.0";
    private static TceManager sInstance;
    private final Context mContext;
    private final SensorManager mSensorManager;
    private volatile ITceService mService = null;
    private final Map<Integer, Sensor> mSensorList = new HashMap();
    private final Map<TceCallback, CallbackWrapper> mCallbackMap = new ConcurrentHashMap();
    private final Map<Handler, Integer> mHandlerMap = new ConcurrentHashMap();
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.transsion.tranradionet.tce.TceManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (TceManager.class) {
                try {
                    TceManager.this.mService = ITceService.Stub.asInterface(iBinder);
                    for (Map.Entry entry : TceManager.this.mHandlerMap.entrySet()) {
                        ((Handler) entry.getKey()).sendMessage(((Handler) entry.getKey()).obtainMessage(0, ((Integer) entry.getValue()).intValue(), 0));
                    }
                    Log.i(TceManager.TAG, "TCE service connected");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (TceManager.class) {
                try {
                    Log.i(TceManager.TAG, "TCE service disconnected");
                    TceManager.this.mService = null;
                    for (Map.Entry entry : TceManager.this.mHandlerMap.entrySet()) {
                        ((Handler) entry.getKey()).sendMessage(((Handler) entry.getKey()).obtainMessage(3, ((Integer) entry.getValue()).intValue(), 0));
                    }
                    TceManager.this.mHandlerMap.clear();
                    Iterator it = TceManager.this.mCallbackMap.values().iterator();
                    while (it.hasNext()) {
                        ((CallbackWrapper) it.next()).cleanup();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    private TceManager(Context context) {
        Log.i(TAG, "TceManager constructor");
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mSensorManager = (SensorManager) applicationContext.getSystemService("sensor");
        initSensorList();
    }

    private void checkPermission() {
        int callingUid = Binder.getCallingUid();
        if (this.mContext.checkSelfPermission("com.transsion.tranradionet.START_TCE_SERVICE") != 0) {
            throw new SecurityException(a1.a.o(callingUid, "No permission to access TCE service, callingUid = "));
        }
    }

    public static TceEvent createTestElevatorEvent(boolean z2, int i8) {
        return new TceEvent(1, i8, new float[]{z2 ? 1.0f : 0.0f});
    }

    public static TceEvent createTestVehicleEvent(boolean z2, int i8) {
        return new TceEvent(2, i8, new float[]{z2 ? 1.0f : 0.0f});
    }

    public static TceEvent createTestVehicleMotionEvent(int i8, int i9) {
        return new TceEvent(3, i9, new float[]{i8});
    }

    public static TceManager getInstance(Context context) {
        TceManager tceManager;
        synchronized (TceManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new TceManager(context);
                }
                tceManager = sInstance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tceManager;
    }

    private void initSensorList() {
        for (Sensor sensor : this.mSensorManager.getSensorList(-1)) {
            this.mSensorList.put(Integer.valueOf(sensor.getHandle()), sensor);
        }
    }

    public boolean clearSensorTestData() {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.clearSensorTestData();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to clear sensor test data", e);
            return false;
        }
    }

    public boolean clearTestData() {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.clearTestData();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to clear test data", e);
            return false;
        }
    }

    public boolean connectService(Handler handler, int i8) {
        try {
            checkPermission();
            if (this.mService == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(SVC_PKG_NAME, SVC_NAME));
                if (handler != null && !this.mHandlerMap.containsKey(handler)) {
                    this.mHandlerMap.put(handler, Integer.valueOf(i8));
                }
                return this.mContext.bindService(intent, this.mServiceConnection, 1);
            }
            Log.w(TAG, "TCE service is already connected，serviceConnId = " + i8);
            if (handler != null) {
                Log.i(TAG, "TCE service is already connected, send message to callback handler");
                handler.sendMessage(handler.obtainMessage(0, i8, 0));
            }
            return true;
        } catch (SecurityException e) {
            Log.e(TAG, "Failed to connect service due to permission", e);
            return false;
        } catch (Exception e4) {
            Log.e(TAG, "Failed to connect service", e4);
            return false;
        }
    }

    public void disconnectService() {
        try {
            ServiceConnection serviceConnection = this.mServiceConnection;
            if (serviceConnection != null) {
                this.mContext.unbindService(serviceConnection);
            }
            this.mService = null;
            for (Map.Entry<Handler, Integer> entry : this.mHandlerMap.entrySet()) {
                entry.getKey().sendMessage(entry.getKey().obtainMessage(3, entry.getValue().intValue(), 0));
            }
            this.mHandlerMap.clear();
            Iterator<CallbackWrapper> it = this.mCallbackMap.values().iterator();
            while (it.hasNext()) {
                it.next().cleanup();
            }
            this.mCallbackMap.clear();
        } catch (Exception e) {
            Log.e(TAG, "Failed to disconnect service", e);
        }
    }

    public Map<Integer, Sensor> getAvailableSensors() {
        return new HashMap(this.mSensorList);
    }

    public String getCurrentMemoryInfo() {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return "";
        }
        try {
            return this.mService.getCurrentMemoryInfo(getCurrentPid());
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get current memory info", e);
            return "";
        }
    }

    public int getCurrentPid() {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return -1;
        }
        try {
            return this.mService.getCurrentPid();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get current PID" + e.getMessage());
            return -1;
        }
    }

    public String getDebugInfo() {
        if (this.mService == null) {
            return "Service not connected";
        }
        try {
            return this.mService.getDebugInfo();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get debug info", e);
            return "Failed to get debug info: " + e.getMessage();
        }
    }

    public Sensor getSensorByHandle(int i8) {
        return this.mSensorList.get(Integer.valueOf(i8));
    }

    public String getTsnProcessMemoryInfo() {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return "";
        }
        try {
            return this.mService.getTsnProcessMemoryInfo();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get TSN process memory info", e);
            return "";
        }
    }

    public int injectLocations(String[] strArr, Location[] locationArr) {
        if (strArr == null || locationArr == null) {
            Log.e(TAG, "Cannot inject null location arrays");
            return 0;
        }
        if (strArr.length != locationArr.length) {
            Log.e(TAG, "Provider and location arrays must have same length");
            return 0;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return 0;
        }
        try {
            return this.mService.injectLocations(strArr, locationArr);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to inject locations", e);
            return 0;
        }
    }

    public boolean injectTestLocation(String str, Location location) {
        if (str == null || location == null) {
            Log.e(TAG, "Cannot inject null location parameters");
            return false;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.injectTestLocation(str, location);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to inject test location", e);
            return false;
        }
    }

    public boolean injectTestSensorData(int i8, float[] fArr, int i9, long j8) {
        if (fArr == null) {
            Log.e(TAG, "Cannot inject null sensor values");
            return false;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.injectTestSensorData(i8, fArr, i9, j8);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to inject test sensor data", e);
            return false;
        }
    }

    public boolean injectTestSensorDataSimple(Sensor sensor, float[] fArr) {
        if (fArr == null) {
            Log.e(TAG, "Cannot inject null sensor values");
            return false;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.injectTestSensorDataSimple(sensor.getHandle(), fArr);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to inject simple test sensor data", e);
            return false;
        }
    }

    public boolean injectTestSensorDataWithAccuracy(int i8, float[] fArr, int i9) {
        if (fArr == null) {
            Log.e(TAG, "Cannot inject null sensor values");
            return false;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.injectTestSensorDataWithAccuracy(i8, fArr, i9);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to inject test sensor data with accuracy", e);
            return false;
        }
    }

    public boolean injectTestTceEvent(TceEvent tceEvent) {
        if (tceEvent == null) {
            Log.e(TAG, "Cannot inject null test event");
            return false;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.injectTestTceEvent(tceEvent);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to inject test TCE event", e);
            return false;
        }
    }

    public int injectTestTceEvents(TceEvent[] tceEventArr) {
        if (tceEventArr == null) {
            Log.e(TAG, "Cannot inject null test events array");
            return 0;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return 0;
        }
        try {
            return this.mService.injectTestTceEvents(tceEventArr);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to inject test TCE events", e);
            return 0;
        }
    }

    public boolean isInternalSensorAccessAvailable() {
        return isServiceConnected();
    }

    public boolean isLocationTestEnable() {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.isLocationTestEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get location test enable status", e);
            return false;
        }
    }

    public boolean isSensorTestModeEnabled() {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.isSensorTestModeEnabled();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get sensor test mode status", e);
            return false;
        }
    }

    public boolean isServiceConnected() {
        return this.mService != null && this.mService.asBinder().isBinderAlive();
    }

    public boolean isTestModeEnabled() {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.isTestModeEnabled();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get test mode status", e);
            return false;
        }
    }

    public boolean queryChargeGeofence(Messenger messenger) {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.queryChargeGeofence(messenger);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to query charge geofence status", e);
            return false;
        }
    }

    public int registerForElevatorMode(TceCallback tceCallback) {
        return registerTceCallback(tceCallback, 1);
    }

    public boolean registerForSensor(TceCallback tceCallback, Sensor sensor) {
        if (tceCallback == null) {
            return false;
        }
        if (sensor == null) {
            Log.e(TAG, "Sensor is null");
            return false;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            synchronized (this.mCallbackMap) {
                try {
                    CallbackWrapper callbackWrapper = this.mCallbackMap.get(tceCallback);
                    boolean z2 = true;
                    if (callbackWrapper == null) {
                        callbackWrapper = new CallbackWrapper(tceCallback, this);
                        Log.i(TAG, "Created new wrapper for sensor callback id: " + tceCallback.getTceId());
                    } else {
                        if (callbackWrapper.hasSensorHandle(sensor.getHandle())) {
                            Log.w(TAG, "Sensor handle " + sensor.getHandle() + " already registered for callback id: " + tceCallback.getTceId());
                            return true;
                        }
                        Log.i(TAG, "Using existing wrapper for sensor callback id: " + tceCallback.getTceId());
                        z2 = false;
                    }
                    boolean zRegisterForSensor = this.mService.registerForSensor(callbackWrapper, sensor.getHandle(), 3);
                    if (zRegisterForSensor) {
                        if (z2) {
                            this.mCallbackMap.put(tceCallback, callbackWrapper);
                        }
                        callbackWrapper.addSensorHandle(sensor.getHandle());
                    }
                    return zRegisterForSensor;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to register sensor callback", e);
            return false;
        }
    }

    public int registerForVehicleMode(TceCallback tceCallback) {
        return registerTceCallback(tceCallback, 2);
    }

    public int registerForVehicleMotion(TceCallback tceCallback) {
        return registerTceCallback(tceCallback, 3);
    }

    public int registerTceCallback(TceCallback tceCallback, int i8) {
        return registerTceCallback(tceCallback, new int[]{i8});
    }

    public boolean setLocationInjectionEnabled(boolean z2) {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.setLocationInjectionEnabled(z2);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to set injection enabled", e);
            return false;
        }
    }

    public boolean setSensorTestModeEnabled(boolean z2) {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.setSensorTestModeEnabled(z2);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to set sensor test mode", e);
            return false;
        }
    }

    public boolean setTestModeEnabled(boolean z2) {
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            return this.mService.setTestModeEnabled(z2);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to set test mode", e);
            return false;
        }
    }

    public int unregisterForElevatorMode(TceCallback tceCallback) {
        return unregisterTceCallback(tceCallback, 1);
    }

    public boolean unregisterForSensor(TceCallback tceCallback, Sensor sensor) {
        if (tceCallback == null) {
            return false;
        }
        if (sensor == null) {
            Log.e(TAG, "Sensor is null");
            return false;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            synchronized (this.mCallbackMap) {
                try {
                    CallbackWrapper callbackWrapper = this.mCallbackMap.get(tceCallback);
                    if (callbackWrapper == null) {
                        Log.w(TAG, "Callback not found for sensor unregistration");
                        return true;
                    }
                    boolean zUnregisterForSensor = this.mService.unregisterForSensor(callbackWrapper, sensor.getHandle());
                    if (zUnregisterForSensor) {
                        callbackWrapper.removeSensorHandle(sensor.getHandle());
                        if (!callbackWrapper.hasRegistrations()) {
                            this.mCallbackMap.remove(tceCallback);
                        }
                    }
                    return zUnregisterForSensor;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to unregister sensor callback", e);
            return false;
        }
    }

    public int unregisterForVehicleMode(TceCallback tceCallback) {
        return unregisterTceCallback(tceCallback, 2);
    }

    public int unregisterForVehicleMotion(TceCallback tceCallback) {
        return unregisterTceCallback(tceCallback, 3);
    }

    public int unregisterTceCallback(TceCallback tceCallback, int i8) {
        return unregisterTceCallback(tceCallback, new int[]{i8});
    }

    public int registerForVehicleMotion(TceCallback tceCallback, Bundle bundle) {
        return registerTceCallback(tceCallback, 3, bundle);
    }

    public int registerTceCallback(TceCallback tceCallback, int[] iArr) {
        return registerTceCallback(tceCallback, iArr, (Bundle) null);
    }

    public int unregisterTceCallback(TceCallback tceCallback, int[] iArr) {
        if (tceCallback == null) {
            Log.e(TAG, "Callback is null");
            return 2;
        }
        if (iArr != null && iArr.length != 0) {
            if (this.mService == null) {
                Log.e(TAG, "Service not connected");
                return 3;
            }
            synchronized (this.mCallbackMap) {
                try {
                    CallbackWrapper callbackWrapper = this.mCallbackMap.get(tceCallback);
                    if (callbackWrapper == null) {
                        Log.e(TAG, "Callback not found for unregistration callback id: " + tceCallback.getTceId());
                        return 1;
                    }
                    for (int i8 : iArr) {
                        callbackWrapper.removeTceType(i8);
                    }
                    if (!callbackWrapper.hasRegistrations()) {
                        this.mCallbackMap.remove(tceCallback);
                        Log.i(TAG, "No more registrations, remove the wrapper from the map");
                    }
                    Log.i(TAG, "Unregister TCE callback with id: " + tceCallback.getTceId() + " and tceTypes: " + Arrays.toString(iArr));
                    try {
                        return this.mService.unregisterTceCallback(callbackWrapper, iArr);
                    } catch (RemoteException e) {
                        Log.e(TAG, "Failed to unregister TCE callback", e);
                        return 1;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        Log.e(TAG, "Invalid tceTypes parameter");
        return 2;
    }

    public int registerTceCallback(TceCallback tceCallback, int i8, Bundle bundle) {
        return registerTceCallback(tceCallback, new int[]{i8}, bundle);
    }

    public int registerTceCallback(TceCallback tceCallback, int[] iArr, Bundle bundle) {
        boolean z2;
        if (tceCallback == null) {
            Log.e(TAG, "Callback is null");
            return 2;
        }
        if (iArr != null && iArr.length != 0) {
            if (this.mService == null) {
                Log.e(TAG, "registerTceCallback, Service not connected");
                return 3;
            }
            try {
                String packageName = this.mContext.getPackageName();
                synchronized (this.mCallbackMap) {
                    try {
                        CallbackWrapper callbackWrapper = this.mCallbackMap.get(tceCallback);
                        if (callbackWrapper != null) {
                            for (int i8 : iArr) {
                                if (callbackWrapper.hasTceType(i8)) {
                                    Log.w(TAG, "TceType " + i8 + " already registered for callback id: " + tceCallback.getTceId());
                                }
                            }
                            Log.i(TAG, "Using existing wrapper for callback id: " + tceCallback.getTceId());
                            z2 = false;
                        } else {
                            callbackWrapper = new CallbackWrapper(tceCallback);
                            Log.i(TAG, "Created new wrapper for callback id: " + tceCallback.getTceId());
                            z2 = true;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i9 : iArr) {
                            if (!callbackWrapper.hasTceType(i9)) {
                                arrayList.add(Integer.valueOf(i9));
                            }
                        }
                        if (arrayList.isEmpty()) {
                            Log.i(TAG, "All tceTypes already registered for callback id: " + tceCallback.getTceId());
                            return 0;
                        }
                        int[] array = arrayList.stream().mapToInt(new dd.a()).toArray();
                        int iRegisterTceCallback = this.mService.registerTceCallback(callbackWrapper, array, bundle, packageName);
                        if (iRegisterTceCallback == 0) {
                            synchronized (this.mCallbackMap) {
                                if (z2) {
                                    try {
                                        this.mCallbackMap.put(tceCallback, callbackWrapper);
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                for (int i10 : array) {
                                    callbackWrapper.addTceType(i10);
                                }
                            }
                        }
                        Log.i(TAG, "Register TCE callback with id: " + tceCallback.getTceId() + " and pkgName: " + packageName + " and result: " + iRegisterTceCallback + " and newTceTypes: " + Arrays.toString(array) + " (original tceTypes: " + Arrays.toString(iArr) + ")");
                        return iRegisterTceCallback;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to register TCE callback", e);
                return 1;
            }
        }
        Log.e(TAG, "Invalid tceTypes parameter");
        return 2;
    }

    public boolean connectService(Handler handler) {
        return connectService(handler, 0);
    }

    public boolean connectService() {
        return connectService(null, 0);
    }

    public boolean registerForSensor(TceCallback tceCallback, Sensor sensor, int i8) {
        if (tceCallback == null) {
            return false;
        }
        if (sensor == null) {
            Log.e(TAG, "Sensor is null");
            return false;
        }
        if (this.mService == null) {
            Log.e(TAG, "Service not connected");
            return false;
        }
        try {
            synchronized (this.mCallbackMap) {
                try {
                    CallbackWrapper callbackWrapper = this.mCallbackMap.get(tceCallback);
                    boolean z2 = true;
                    if (callbackWrapper == null) {
                        callbackWrapper = new CallbackWrapper(tceCallback, this);
                        Log.i(TAG, "Created new wrapper for sensor callback id: " + tceCallback.getTceId());
                    } else if (!callbackWrapper.hasSensorHandle(sensor.getHandle())) {
                        Log.i(TAG, "Using existing wrapper for sensor callback id: " + tceCallback.getTceId());
                        z2 = false;
                    } else {
                        Log.w(TAG, "Sensor handle " + sensor.getHandle() + " already registered for callback id: " + tceCallback.getTceId());
                        return true;
                    }
                    boolean zRegisterForSensor = this.mService.registerForSensor(callbackWrapper, sensor.getHandle(), i8);
                    if (zRegisterForSensor) {
                        if (z2) {
                            this.mCallbackMap.put(tceCallback, callbackWrapper);
                        }
                        callbackWrapper.addSensorHandle(sensor.getHandle());
                    }
                    return zRegisterForSensor;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to register sensor callback with samplingPeriodUs", e);
            return false;
        }
    }
}
