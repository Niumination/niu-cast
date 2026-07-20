package com.transsion.connectx.mirror.source.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import com.transsion.connectx.mirror.source.SourceApplication;
import k4.m;
import m5.s;
import w4.c0;
import w4.l1;
import w4.n0;

/* JADX INFO: loaded from: classes2.dex */
public class SourceService extends Service {
    public static final String H = "com.connectx.exit.FILE_TRANSFER";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f2175x = "SourceService";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f2176y = "com.connectx.EXIT";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f2177z = "com.connectx.TOGGLE_AUDIO";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f2178a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2180c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2179b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BroadcastReceiver f2181d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f2182e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BroadcastReceiver f2183f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BroadcastReceiver f2184g = new d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2185i = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2186n = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2187p = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2188v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2189w = false;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("app");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            SourceService.this.i(stringExtra);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SourceService.this.f2178a.stopTCCPServer();
        }
    }

    public class c extends BroadcastReceiver {
        public c(SourceService sourceService) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            s.a.f10535a.o(0);
        }
    }

    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (SystemClock.elapsedRealtime() - SourceService.this.f2179b < r4.a.O) {
                return;
            }
            SourceService.this.f2179b = SystemClock.elapsedRealtime();
            l1.h.f18073a.S1();
        }
    }

    public static void f() {
        c0.b.f17991a.A0();
    }

    public final void g() {
        if (!this.f2185i) {
            registerReceiver(this.f2181d, new IntentFilter("com.connectx.openAppReq"));
            this.f2185i = true;
        }
        if (!this.f2186n) {
            registerReceiver(this.f2182e, new IntentFilter(f2176y));
            this.f2186n = true;
        }
        if (!this.f2187p) {
            registerReceiver(this.f2183f, new IntentFilter(H));
            this.f2187p = true;
        }
        if (this.f2188v) {
            return;
        }
        registerReceiver(this.f2184g, new IntentFilter(f2177z));
        this.f2188v = true;
    }

    public final void h() {
        if (this.f2189w) {
            return;
        }
        com.transsion.connectx.mirror.source.receiver.a.C0076a.f2172a.e();
        this.f2189w = true;
    }

    public final void i(String str) {
        l1.h.f18073a.T(w4.c.m(this), str);
    }

    public final void j() {
        if (this.f2185i) {
            unregisterReceiver(this.f2181d);
            this.f2185i = false;
        }
        if (this.f2186n) {
            unregisterReceiver(this.f2182e);
            this.f2186n = false;
        }
        if (this.f2187p) {
            unregisterReceiver(this.f2183f);
            this.f2187p = false;
        }
        if (this.f2188v) {
            unregisterReceiver(this.f2184g);
            this.f2188v = false;
        }
    }

    public final void k() {
        if (this.f2189w) {
            com.transsion.connectx.mirror.source.receiver.a.C0076a.f2172a.i();
            this.f2189w = false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        m.c(f2175x, "onBind");
        return this.f2178a;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int iJ = w4.c.j(SourceApplication.b());
        int iC = w4.c.c(SourceApplication.f1881c);
        int i10 = iJ * iC;
        if (i10 == this.f2180c) {
            return;
        }
        m.b(f2175x, "onConfigurationChanged resolution Changed: " + iJ + "*" + iC);
        this.f2180c = i10;
        l1.h.f18073a.u1();
    }

    @Override // android.app.Service
    public void onCreate() {
        m.e(f2175x, "source service onCreate");
        super.onCreate();
        this.f2178a = new n0();
        h();
        y5.c.d(SourceApplication.b()).c();
        z5.b.f(this).i();
        this.f2180c = w4.c.c(SourceApplication.f1881c) * w4.c.j(SourceApplication.f1881c);
    }

    @Override // android.app.Service
    public void onDestroy() {
        m.b(f2175x, "Cast Screen Service onDestroy");
        m.e(f2175x, "release p2p from source-service onDestroy");
        i6.a.b.f7724a.b(new u5.b());
        stopForeground(true);
        super.onDestroy();
        k();
        y5.c.d(SourceApplication.b()).j();
        z5.b.f(this).d();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        m.e(f2175x, "onStartCommand");
        return super.onStartCommand(intent, i10, i11);
    }
}
