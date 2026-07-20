package com.google.android.gms.common.internal;

import af.f;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import hf.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import q2.c;
import q2.g;
import q2.h;
import u2.b;
import u2.e;
import u2.j;
import u2.k;
import u2.l;
import u2.m;
import u2.n;
import u2.o;
import u2.p;
import u2.q;
import u2.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Feature[] f1875z = new Feature[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f1876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f1877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f1878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u2.u f1879d;
    public final m e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f1880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f1881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k f1882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f1883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IInterface f1884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f1885m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f1886n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1887o;
    public final e p;
    public final e q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f1888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f1889s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile String f1890t;
    public ConnectionResult u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1891v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile zzj f1892w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicInteger f1893x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Set f1894y;

    public a(Context context, Looper looper, int i8, c2.k kVar, g gVar, h hVar) {
        synchronized (u2.u.f10369g) {
            try {
                if (u2.u.f10370h == null) {
                    u2.u.f10370h = new u2.u(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        u2.u uVar = u2.u.f10370h;
        Object obj = p2.a.f8647c;
        l.e(gVar);
        l.e(hVar);
        e eVar = new e(gVar);
        e eVar2 = new e(hVar);
        String str = (String) kVar.e;
        this.f1876a = null;
        this.f1880h = new Object();
        this.f1881i = new Object();
        this.f1885m = new ArrayList();
        this.f1887o = 1;
        this.u = null;
        this.f1891v = false;
        this.f1892w = null;
        this.f1893x = new AtomicInteger(0);
        l.f(context, "Context must not be null");
        this.f1878c = context;
        l.f(looper, "Looper must not be null");
        l.f(uVar, "Supervisor must not be null");
        this.f1879d = uVar;
        this.e = new m(this, looper);
        this.f1888r = i8;
        this.p = eVar;
        this.q = eVar2;
        this.f1889s = str;
        Set set = (Set) kVar.f1409c;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f1894y = set;
    }

    public static /* bridge */ /* synthetic */ boolean s(a aVar, int i8, int i9, IInterface iInterface) {
        synchronized (aVar.f1880h) {
            try {
                if (aVar.f1887o != i8) {
                    return false;
                }
                aVar.t(iInterface, i9);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // q2.c
    public final boolean a() {
        boolean z2;
        synchronized (this.f1880h) {
            int i8 = this.f1887o;
            z2 = true;
            if (i8 != 2 && i8 != 3) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // q2.c
    public final void b() {
        if (!g() || this.f1877b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    @Override // q2.c
    public final void c(b bVar) {
        this.f1883k = bVar;
        t(null, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q2.c
    public final void d(u2.c cVar, Set set) {
        Bundle bundleN = n();
        int i8 = this.f1888r;
        String str = this.f1890t;
        int i9 = p2.b.f8649a;
        Scope[] scopeArr = GetServiceRequest.q;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f1848r;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i8, i9, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f1852d = this.f1878c.getPackageName();
        getServiceRequest.f1854i = bundleN;
        if (set != null) {
            getServiceRequest.f1853h = (Scope[]) set.toArray(new Scope[0]);
        }
        if (e()) {
            getServiceRequest.f1855j = new Account("<<default account>>", "com.google");
            if (cVar != 0) {
                getServiceRequest.e = ((h3.a) cVar).f5235c;
            }
        }
        getServiceRequest.f1856k = f1875z;
        getServiceRequest.f1857l = m();
        if (this instanceof y2.g) {
            getServiceRequest.f1860o = true;
        }
        try {
            try {
                synchronized (this.f1881i) {
                    try {
                        k kVar = this.f1882j;
                        if (kVar != null) {
                            kVar.e(new n(this, this.f1893x.get()), getServiceRequest);
                        } else {
                            Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (RemoteException | RuntimeException e) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
                int i10 = this.f1893x.get();
                p pVar = new p(this, 8, null, null);
                m mVar = this.e;
                mVar.sendMessage(mVar.obtainMessage(1, i10, -1, pVar));
            }
        } catch (DeadObjectException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            m mVar2 = this.e;
            mVar2.sendMessage(mVar2.obtainMessage(6, this.f1893x.get(), 3));
        } catch (SecurityException e10) {
            throw e10;
        }
    }

    @Override // q2.c
    public final void disconnect() {
        this.f1893x.incrementAndGet();
        synchronized (this.f1885m) {
            try {
                int size = this.f1885m.size();
                for (int i8 = 0; i8 < size; i8++) {
                    j jVar = (j) this.f1885m.get(i8);
                    synchronized (jVar) {
                        jVar.f10342a = null;
                    }
                }
                this.f1885m.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (this.f1881i) {
            this.f1882j = null;
        }
        t(null, 1);
    }

    @Override // q2.c
    public boolean e() {
        return false;
    }

    @Override // q2.c
    public final Set f() {
        return e() ? this.f1894y : Collections.emptySet();
    }

    @Override // q2.c
    public final boolean g() {
        boolean z2;
        synchronized (this.f1880h) {
            z2 = this.f1887o == 4;
        }
        return z2;
    }

    @Override // q2.c
    public final void i(se.e eVar) {
        ((r2.l) eVar.f9720b).f9350n.f9334o.post(new f(eVar, 28));
    }

    @Override // q2.c
    public final Feature[] j() {
        zzj zzjVar = this.f1892w;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f1909b;
    }

    @Override // q2.c
    public final String k() {
        return this.f1876a;
    }

    public abstract IInterface l(IBinder iBinder);

    public Feature[] m() {
        return f1875z;
    }

    public Bundle n() {
        return new Bundle();
    }

    public final IInterface o() {
        IInterface iInterface;
        synchronized (this.f1880h) {
            try {
                if (this.f1887o == 5) {
                    throw new DeadObjectException();
                }
                if (!g()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f1884l;
                l.f(iInterface, "Client is connected but service is null");
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iInterface;
    }

    public abstract String p();

    public abstract String q();

    public boolean r() {
        return h() >= 211700000;
    }

    public final void t(IInterface iInterface, int i8) {
        u uVar;
        if ((i8 == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f1880h) {
            try {
                this.f1887o = i8;
                this.f1884l = iInterface;
                if (i8 == 1) {
                    o oVar = this.f1886n;
                    if (oVar != null) {
                        u2.u uVar2 = this.f1879d;
                        String str = (String) this.f1877b.f5332b;
                        l.e(str);
                        this.f1877b.getClass();
                        if (this.f1889s == null) {
                            this.f1878c.getClass();
                        }
                        uVar2.a(str, oVar, this.f1877b.f5331a);
                        this.f1886n = null;
                    }
                } else if (i8 == 2 || i8 == 3) {
                    o oVar2 = this.f1886n;
                    if (oVar2 != null && (uVar = this.f1877b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + ((String) uVar.f5332b) + " on com.google.android.gms");
                        u2.u uVar3 = this.f1879d;
                        String str2 = (String) this.f1877b.f5332b;
                        l.e(str2);
                        this.f1877b.getClass();
                        if (this.f1889s == null) {
                            this.f1878c.getClass();
                        }
                        uVar3.a(str2, oVar2, this.f1877b.f5331a);
                        this.f1893x.incrementAndGet();
                    }
                    o oVar3 = new o(this, this.f1893x.get());
                    this.f1886n = oVar3;
                    String strQ = q();
                    boolean zR = r();
                    this.f1877b = new u(strQ, zR);
                    if (zR && h() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.f1877b.f5332b)));
                    }
                    u2.u uVar4 = this.f1879d;
                    String str3 = (String) this.f1877b.f5332b;
                    l.e(str3);
                    this.f1877b.getClass();
                    String name = this.f1889s;
                    if (name == null) {
                        name = this.f1878c.getClass().getName();
                    }
                    if (!uVar4.b(new r(str3, this.f1877b.f5331a), oVar3, name)) {
                        Log.w("GmsClient", "unable to connect to service: " + ((String) this.f1877b.f5332b) + " on com.google.android.gms");
                        int i9 = this.f1893x.get();
                        q qVar = new q(this, 16);
                        m mVar = this.e;
                        mVar.sendMessage(mVar.obtainMessage(7, i9, -1, qVar));
                    }
                } else if (i8 == 4) {
                    l.e(iInterface);
                    System.currentTimeMillis();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // q2.c
    public final void disconnect(String str) {
        this.f1876a = str;
        disconnect();
    }
}
