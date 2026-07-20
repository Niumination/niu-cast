package u2;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.PeriodicWorkRequest;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f10369g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static u f10370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static HandlerThread f10371i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10372a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile h3.e f10374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c3.a f10375d;
    public final long e;
    public final long f;

    public u(Context context, Looper looper) {
        t tVar = new t(this);
        this.f10373b = context.getApplicationContext();
        this.f10374c = new h3.e(looper, tVar, 1);
        if (c3.a.f1426b == null) {
            synchronized (c3.a.f1425a) {
                try {
                    if (c3.a.f1426b == null) {
                        c3.a aVar = new c3.a();
                        new ConcurrentHashMap();
                        c3.a.f1426b = aVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        c3.a aVar2 = c3.a.f1426b;
        l.e(aVar2);
        this.f10375d = aVar2;
        this.e = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.f = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    public final void a(String str, ServiceConnection serviceConnection, boolean z2) {
        r rVar = new r(str, z2);
        l.f(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f10372a) {
            try {
                s sVar = (s) this.f10372a.get(rVar);
                if (sVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(rVar.toString()));
                }
                if (!sVar.f10362a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(rVar.toString()));
                }
                sVar.f10362a.remove(serviceConnection);
                if (sVar.f10362a.isEmpty()) {
                    this.f10374c.sendMessageDelayed(this.f10374c.obtainMessage(0, rVar), this.e);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean b(r rVar, o oVar, String str) {
        boolean z2;
        synchronized (this.f10372a) {
            try {
                s sVar = (s) this.f10372a.get(rVar);
                if (sVar == null) {
                    sVar = new s(this, rVar);
                    sVar.f10362a.put(oVar, oVar);
                    sVar.a(str);
                    this.f10372a.put(rVar, sVar);
                } else {
                    this.f10374c.removeMessages(0, rVar);
                    if (sVar.f10362a.containsKey(oVar)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(rVar.toString()));
                    }
                    sVar.f10362a.put(oVar, oVar);
                    int i8 = sVar.f10363b;
                    if (i8 == 1) {
                        oVar.onServiceConnected(sVar.f10366h, sVar.f10365d);
                    } else if (i8 == 2) {
                        sVar.a(str);
                    }
                }
                z2 = sVar.f10364c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z2;
    }
}
