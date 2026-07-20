package com.transsion.connectx.mirror.source.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import k4.h;
import k4.m;
import w4.l1;

/* JADX INFO: loaded from: classes2.dex */
public class CastStatusService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2173b = "CastStatusService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n6.a.b f2174a = new a();

    public class a extends n6.a.b {
        public a(CastStatusService castStatusService) {
        }

        @Override // n6.a
        public void C(int i10, WindowManager.LayoutParams layoutParams) {
            m.b(CastStatusService.f2173b, "hookSecureWindowVisible: " + i10 + " attrs: " + layoutParams);
            l1.h.f18073a.d0();
            h.a.f8959a.f(i10, layoutParams);
        }

        @Override // n6.a
        public void D(int i10, int i11) {
            m.b(CastStatusService.f2173b, "hookInputMethodShown: " + i10 + "; count:" + i11);
            l1.h.f18073a.d0();
            h.a.f8959a.b(i10, i11);
        }

        @Override // n6.a
        public void H(int i10, int i11) {
            m.b(CastStatusService.f2173b, "hookDisplayRotation: " + i10 + " rotation: " + i11);
            l1.h.f18073a.d0();
            h.a.f8959a.d(i10, i11);
        }

        @Override // n6.a
        public void I(String str, Bundle bundle) {
            m.b(CastStatusService.f2173b, "hookToSourceConnect: " + str + " param: " + bundle);
            l1.h.f18073a.d0();
            h.a.f8959a.h(str, bundle);
        }

        @Override // n6.a
        public void t(boolean z10) {
            m.b(CastStatusService.f2173b, "hookIputMethodShown: " + z10);
            l1.h.f18073a.d0();
            h.a.f8959a.e(z10);
        }

        @Override // n6.a
        public void v(int i10, String str) {
            m.b(CastStatusService.f2173b, "hookDisplayResumedActivityChanged: " + i10 + " packageName: " + str);
            l1.h.f18073a.d0();
            h.a.f8959a.c(i10, str);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        m.b(f2173b, "onBind: ");
        return this.f2174a;
    }

    @Override // android.app.Service
    public void onCreate() {
        m.e(f2173b, "onCreate: ");
        super.onCreate();
    }
}
