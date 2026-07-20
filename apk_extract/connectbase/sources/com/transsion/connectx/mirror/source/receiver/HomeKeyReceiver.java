package com.transsion.connectx.mirror.source.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import k4.m;
import kn.l0;
import kn.w;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class HomeKeyReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final a f2159c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final String f2160d = "homekey";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final String f2161e = "reason";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final String f2162f = "recentstart";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final String f2163g = "recentapps";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final String f2164h = "HomeKeyReceiver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final jn.a<l2> f2165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2166b;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public HomeKeyReceiver(@l jn.a<l2> aVar) {
        l0.p(aVar, "homeKeyCallback");
        this.f2165a = aVar;
    }

    public final void a(Intent intent) {
        String stringExtra = intent.getStringExtra(f2161e);
        m.b(f2164h, "reason:" + stringExtra);
        if (stringExtra != null && (l0.g(stringExtra, f2160d) || l0.g(stringExtra, f2162f))) {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - this.f2166b > 200) {
                this.f2166b = timeInMillis;
                m.b(f2164h, "home key press down");
                this.f2165a.invoke();
            }
        }
        if (stringExtra == null || !l0.g(stringExtra, f2163g)) {
            return;
        }
        this.f2165a.invoke();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@os.m Context context, @os.m Intent intent) {
        m.b(f2164h, "onReceive");
        if (l0.g("android.intent.action.CLOSE_SYSTEM_DIALOGS", intent != null ? intent.getAction() : null)) {
            a(intent);
        }
    }
}
