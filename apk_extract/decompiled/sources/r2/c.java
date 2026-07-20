package r2;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k3.f1;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Handler.Callback {
    public static final Status q = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Status f9320r = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Object f9321s = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static c f9322t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TelemetryData f9325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w2.b f9326d;
    public final Context e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p2.a f9327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y6.g f9328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f9329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f9330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap f9331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArraySet f9332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArraySet f9333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h3.e f9334o;
    public volatile boolean p;

    public c(Context context, Looper looper) {
        p2.a aVar = p2.a.f8648d;
        this.f9323a = WorkRequest.MIN_BACKOFF_MILLIS;
        this.f9324b = false;
        this.f9329j = new AtomicInteger(1);
        this.f9330k = new AtomicInteger(0);
        this.f9331l = new ConcurrentHashMap(5, 0.75f, 1);
        this.f9332m = new ArraySet();
        this.f9333n = new ArraySet();
        this.p = true;
        this.e = context;
        h3.e eVar = new h3.e(looper, this, 0);
        this.f9334o = eVar;
        this.f9327h = aVar;
        this.f9328i = new y6.g(5);
        PackageManager packageManager = context.getPackageManager();
        if (f1.f6438d == null) {
            f1.f6438d = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (f1.f6438d.booleanValue()) {
            this.p = false;
        }
        eVar.sendMessage(eVar.obtainMessage(6));
    }

    public static Status c(a aVar, ConnectionResult connectionResult) {
        return new Status(1, 17, h0.a.k("API: ", (String) aVar.f9313b.f10387b, " is not available on this device. Connection failed with: ", String.valueOf(connectionResult)), connectionResult.f1799c, connectionResult);
    }

    public static c e(Context context) {
        c cVar;
        HandlerThread handlerThread;
        synchronized (f9321s) {
            if (f9322t == null) {
                synchronized (u2.u.f10369g) {
                    try {
                        handlerThread = u2.u.f10371i;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            u2.u.f10371i = handlerThread2;
                            handlerThread2.start();
                            handlerThread = u2.u.f10371i;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = p2.a.f8647c;
                f9322t = new c(applicationContext, looper);
            }
            cVar = f9322t;
        }
        return cVar;
    }

    public final boolean a() {
        if (this.f9324b) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) u2.e.b().f10334a;
        if (rootTelemetryConfiguration != null && !rootTelemetryConfiguration.f1870b) {
            return false;
        }
        int i8 = ((SparseIntArray) this.f9328i.f11095a).get(203400000, -1);
        return i8 == -1 || i8 == 0;
    }

    public final boolean b(ConnectionResult connectionResult, int i8) {
        boolean zBooleanValue;
        PendingIntent activity;
        Boolean bool;
        p2.a aVar = this.f9327h;
        Context context = this.e;
        aVar.getClass();
        synchronized (a8.d.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = a8.d.f52b;
            if (context2 == null || (bool = a8.d.f53c) == null || context2 != applicationContext) {
                a8.d.f53c = null;
                boolean zIsInstantApp = applicationContext.getPackageManager().isInstantApp();
                a8.d.f53c = Boolean.valueOf(zIsInstantApp);
                a8.d.f52b = applicationContext;
                zBooleanValue = zIsInstantApp;
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (zBooleanValue) {
            return false;
        }
        int i9 = connectionResult.f1798b;
        if (i9 == 0 || (activity = connectionResult.f1799c) == null) {
            Intent intentB = aVar.b(context, i9, null);
            activity = intentB != null ? PendingIntent.getActivity(context, 0, intentB, 201326592) : null;
        }
        if (activity == null) {
            return false;
        }
        int i10 = connectionResult.f1798b;
        int i11 = GoogleApiActivity.f1814b;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", activity);
        intent.putExtra("failing_client_id", i8);
        intent.putExtra("notify_manager", true);
        aVar.g(context, i10, PendingIntent.getActivity(context, 0, intent, 167772160));
        return true;
    }

    public final l d(q2.f fVar) {
        a aVar = fVar.e;
        ConcurrentHashMap concurrentHashMap = this.f9331l;
        l lVar = (l) concurrentHashMap.get(aVar);
        if (lVar == null) {
            lVar = new l(this, fVar);
            concurrentHashMap.put(aVar, lVar);
        }
        if (lVar.f9341c.e()) {
            this.f9333n.add(aVar);
        }
        lVar.l();
        return lVar;
    }

    public final void f(ConnectionResult connectionResult, int i8) {
        if (b(connectionResult, i8)) {
            return;
        }
        h3.e eVar = this.f9334o;
        eVar.sendMessage(eVar.obtainMessage(5, i8, 0, connectionResult));
    }

    /* JADX WARN: Code duplicated, block: B:157:0x034c  */
    /* JADX WARN: Code duplicated, block: B:159:0x0352  */
    /* JADX WARN: Code duplicated, block: B:160:0x0371  */
    /* JADX WARN: Code duplicated, block: B:161:0x037c  */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i8;
        Feature[] featureArrB;
        int i9 = message.what;
        long j8 = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        l lVar = null;
        switch (i9) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j8 = WorkRequest.MIN_BACKOFF_MILLIS;
                }
                this.f9323a = j8;
                this.f9334o.removeMessages(12);
                for (a aVar : this.f9331l.keySet()) {
                    h3.e eVar = this.f9334o;
                    eVar.sendMessageDelayed(eVar.obtainMessage(12, aVar), this.f9323a);
                }
                return true;
            case 2:
                throw o.d.d(message.obj);
            case 3:
                for (l lVar2 : this.f9331l.values()) {
                    u2.l.b(lVar2.f9350n.f9334o);
                    lVar2.f9348l = null;
                    lVar2.l();
                }
                return true;
            case 4:
            case 8:
            case 13:
                r rVar = (r) message.obj;
                l lVarD = (l) this.f9331l.get(rVar.f9364c.e);
                if (lVarD == null) {
                    lVarD = d(rVar.f9364c);
                }
                if (!lVarD.f9341c.e() || this.f9330k.get() == rVar.f9363b) {
                    lVarD.m(rVar.f9362a);
                } else {
                    rVar.f9362a.c(q);
                    lVarD.o();
                }
                return true;
            case 5:
                int i10 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (l lVar3 : this.f9331l.values()) {
                    if (lVar3.f9344h == i10) {
                        lVar = lVar3;
                        if (lVar != null) {
                            i8 = connectionResult.f1798b;
                            if (i8 == 13) {
                                this.f9327h.getClass();
                                int i11 = p2.c.f8653c;
                                lVar.b(new Status(17, h0.a.k("Error resolution was canceled by the user, original error message: ", ConnectionResult.g(i8), ": ", connectionResult.f1800d)));
                            } else {
                                lVar.b(c(lVar.f9342d, connectionResult));
                            }
                        } else {
                            Log.wtf("GoogleApiManager", a1.a.u(i10, "Could not find API instance ", " while trying to fail enqueued calls.").toString(), new Exception());
                        }
                        return true;
                    }
                }
                if (lVar != null) {
                    i8 = connectionResult.f1798b;
                    if (i8 == 13) {
                        this.f9327h.getClass();
                        int i12 = p2.c.f8653c;
                        lVar.b(new Status(17, h0.a.k("Error resolution was canceled by the user, original error message: ", ConnectionResult.g(i8), ": ", connectionResult.f1800d)));
                    } else {
                        lVar.b(c(lVar.f9342d, connectionResult));
                    }
                } else {
                    Log.wtf("GoogleApiManager", a1.a.u(i10, "Could not find API instance ", " while trying to fail enqueued calls.").toString(), new Exception());
                }
                return true;
            case 6:
                if (this.e.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.e.getApplicationContext();
                    b bVar = b.e;
                    synchronized (bVar) {
                        try {
                            if (!bVar.f9319d) {
                                application.registerActivityLifecycleCallbacks(bVar);
                                application.registerComponentCallbacks(bVar);
                                bVar.f9319d = true;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    k kVar = new k(this);
                    synchronized (bVar) {
                        bVar.f9318c.add(kVar);
                        break;
                    }
                    AtomicBoolean atomicBoolean = bVar.f9317b;
                    boolean z2 = atomicBoolean.get();
                    AtomicBoolean atomicBoolean2 = bVar.f9316a;
                    if (!z2) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean2.set(true);
                        }
                    }
                    if (!atomicBoolean2.get()) {
                        this.f9323a = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                    }
                }
                return true;
            case 7:
                d((q2.f) message.obj);
                return true;
            case 9:
                if (this.f9331l.containsKey(message.obj)) {
                    l lVar4 = (l) this.f9331l.get(message.obj);
                    u2.l.b(lVar4.f9350n.f9334o);
                    if (lVar4.f9346j) {
                        lVar4.l();
                    }
                }
                return true;
            case 10:
                Iterator<E> it = this.f9333n.iterator();
                while (it.hasNext()) {
                    l lVar5 = (l) this.f9331l.remove((a) it.next());
                    if (lVar5 != null) {
                        lVar5.o();
                    }
                }
                this.f9333n.clear();
                return true;
            case 11:
                if (this.f9331l.containsKey(message.obj)) {
                    l lVar6 = (l) this.f9331l.get(message.obj);
                    c cVar = lVar6.f9350n;
                    u2.l.b(cVar.f9334o);
                    boolean z3 = lVar6.f9346j;
                    if (z3) {
                        if (z3) {
                            c cVar2 = lVar6.f9350n;
                            h3.e eVar2 = cVar2.f9334o;
                            a aVar2 = lVar6.f9342d;
                            eVar2.removeMessages(11, aVar2);
                            cVar2.f9334o.removeMessages(9, aVar2);
                            lVar6.f9346j = false;
                        }
                        lVar6.b(cVar.f9327h.c(cVar.e, p2.b.f8649a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
                        lVar6.f9341c.disconnect("Timing out connection while resuming.");
                    }
                }
                return true;
            case 12:
                if (this.f9331l.containsKey(message.obj)) {
                    l lVar7 = (l) this.f9331l.get(message.obj);
                    u2.l.b(lVar7.f9350n.f9334o);
                    q2.c cVar3 = lVar7.f9341c;
                    if (cVar3.g() && lVar7.f9343g.size() == 0) {
                        f5.a aVar3 = lVar7.e;
                        if (((Map) aVar3.f4984a).isEmpty() && ((Map) aVar3.f4985b).isEmpty()) {
                            cVar3.disconnect("Timing out service connection.");
                        } else {
                            lVar7.i();
                        }
                    }
                }
                return true;
            case 14:
                throw o.d.d(message.obj);
            case 15:
                m mVar = (m) message.obj;
                if (this.f9331l.containsKey(mVar.f9351a)) {
                    l lVar8 = (l) this.f9331l.get(mVar.f9351a);
                    if (lVar8.f9347k.contains(mVar) && !lVar8.f9346j) {
                        if (lVar8.f9341c.g()) {
                            lVar8.d();
                        } else {
                            lVar8.l();
                        }
                    }
                }
                return true;
            case 16:
                m mVar2 = (m) message.obj;
                if (this.f9331l.containsKey(mVar2.f9351a)) {
                    l lVar9 = (l) this.f9331l.get(mVar2.f9351a);
                    if (lVar9.f9347k.remove(mVar2)) {
                        c cVar4 = lVar9.f9350n;
                        cVar4.f9334o.removeMessages(15, mVar2);
                        cVar4.f9334o.removeMessages(16, mVar2);
                        Feature feature = mVar2.f9352b;
                        LinkedList<o> linkedList = lVar9.f9340b;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        for (o oVar : linkedList) {
                            if (oVar != null && (featureArrB = oVar.b(lVar9)) != null) {
                                int length = featureArrB.length;
                                for (int i13 = 0; i13 < length; i13++) {
                                    if (u2.l.h(featureArrB[i13], feature)) {
                                        if (i13 < 0) {
                                        }
                                        arrayList.add(oVar);
                                    }
                                    break;
                                }
                            }
                        }
                        int size = arrayList.size();
                        for (int i14 = 0; i14 < size; i14++) {
                            o oVar2 = (o) arrayList.get(i14);
                            linkedList.remove(oVar2);
                            oVar2.d(new q2.l(feature));
                        }
                    }
                }
                return true;
            case 17:
                TelemetryData telemetryData = this.f9325c;
                if (telemetryData != null) {
                    if (telemetryData.f1873a > 0 || a()) {
                        if (this.f9326d == null) {
                            this.f9326d = new w2.b(this.e, w2.b.f10651i, u2.f.f10335b, q2.e.f8942b);
                        }
                        this.f9326d.c(telemetryData);
                    }
                    this.f9325c = null;
                }
                return true;
            case 18:
                q qVar = (q) message.obj;
                if (qVar.f9360c == 0) {
                    TelemetryData telemetryData2 = new TelemetryData(qVar.f9359b, Arrays.asList(qVar.f9358a));
                    if (this.f9326d == null) {
                        this.f9326d = new w2.b(this.e, w2.b.f10651i, u2.f.f10335b, q2.e.f8942b);
                    }
                    this.f9326d.c(telemetryData2);
                } else {
                    TelemetryData telemetryData3 = this.f9325c;
                    if (telemetryData3 != null) {
                        List list = telemetryData3.f1874b;
                        if (telemetryData3.f1873a != qVar.f9359b || (list != null && list.size() >= qVar.f9361d)) {
                            this.f9334o.removeMessages(17);
                            TelemetryData telemetryData4 = this.f9325c;
                            if (telemetryData4 != null) {
                                if (telemetryData4.f1873a > 0 || a()) {
                                    if (this.f9326d == null) {
                                        this.f9326d = new w2.b(this.e, w2.b.f10651i, u2.f.f10335b, q2.e.f8942b);
                                    }
                                    this.f9326d.c(telemetryData4);
                                }
                                this.f9325c = null;
                            }
                        } else {
                            TelemetryData telemetryData5 = this.f9325c;
                            MethodInvocation methodInvocation = qVar.f9358a;
                            if (telemetryData5.f1874b == null) {
                                telemetryData5.f1874b = new ArrayList();
                            }
                            telemetryData5.f1874b.add(methodInvocation);
                        }
                    }
                    if (this.f9325c == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(qVar.f9358a);
                        this.f9325c = new TelemetryData(qVar.f9359b, arrayList2);
                        h3.e eVar3 = this.f9334o;
                        eVar3.sendMessageDelayed(eVar3.obtainMessage(17), qVar.f9360c);
                    }
                }
                return true;
            case 19:
                this.f9324b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i9);
                return false;
        }
    }
}
