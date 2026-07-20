package com.transsion.connectx.mirror.source;

import a6.f;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import i5.d;
import k4.e;
import k4.m;
import k4.u;
import m2.b;
import p5.c;
import w4.l1;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public class SourceApplication extends Application {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1880b = "SourceApplication";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Application f1881c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ServiceConnection f1882a = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.e(SourceApplication.f1880b, "on welink service connected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            int iV0 = l1.h.f18073a.v0();
            b.a("on welink service disconnected:cast state:", iV0, SourceApplication.f1880b);
            if (iV0 == 1) {
                SourceApplication.this.a();
            }
        }
    }

    public static Application b() {
        return f1881c;
    }

    public void a() {
        m.e(f1880b, "bindWelinkService");
        Intent intent = new Intent("com.transsion.capability.iotservie.keeplive");
        intent.setPackage(f.a());
        try {
            bindService(intent, this.f1882a, 1);
        } catch (Exception e10) {
            m.d(f1880b, e10);
        }
    }

    public void c() {
        m.e(f1880b, "unbindWelinkService");
        try {
            unbindService(this.f1882a);
        } catch (Exception e10) {
            m.d(f1880b, e10);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f1881c = this;
        e.c(this);
        m.f();
        o1.a.f18113a.i(this);
        Thread.setDefaultUncaughtExceptionHandler(new w4.f());
        u.a.f8983a.c(this);
        e5.b.a.f4068a.a();
        h5.e.a.f6975a.a();
        f5.b.a.f5846a.a();
        d.a.f7720a.a();
        ji.d.a.f8711a.e(b5.u.a().b());
        bc.a.b().c(this);
        m.e(f1880b, "VERSION_CODE: 10402097VERSION_NAME: 1.4.2.097 BUILD_TYPE: release");
        b4.a.f725a.m(this);
        c.f12806a.a(this);
    }
}
