package yc;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import bb.t;
import com.transsion.pcconnect.invoke.bridge.Device;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import ra.h;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f11123b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f11124c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f11125d;
    public static boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f11122a = new f();
    public static final CopyOnWriteArrayList f = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayList f11126g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LinkedHashMap f11127h = new LinkedHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h f11128i = new h(2);

    public static void a(Device device, String str, boolean z2, String str2) {
        try {
            c cVar = f11125d;
            if (cVar != null) {
                cVar.h(device, str, z2, str2);
            }
            Log.d("ActionCommunicator", "Successfully sent action: ".concat(str));
            b(device, str, z2);
            new Handler(Looper.getMainLooper()).postDelayed(new t(12), 1000L);
        } catch (RemoteException e4) {
            Log.e("ActionCommunicator", "Failed to send action: " + e4.getMessage(), e4);
        } catch (Exception e10) {
            Log.e("ActionCommunicator", "Exception executing action: " + e10.getMessage(), e10);
        }
    }

    public static void b(Device device, String str, boolean z2) {
        LinkedHashMap linkedHashMap = f11127h;
        String str2 = device.f2947a;
        Object linkedHashMap2 = linkedHashMap.get(str2);
        if (linkedHashMap2 == null) {
            linkedHashMap2 = new LinkedHashMap();
            linkedHashMap.put(str2, linkedHashMap2);
        }
        ((Map) linkedHashMap2).put(str, Boolean.valueOf(z2));
    }
}
