package com.transsion.padconnect.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import hi.b;
import jn.p;
import kn.l0;
import kn.w;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class CastEntryStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f2280b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final String f2281c = "CastEntryStateReceiver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final p<Boolean, String, l2> f2282a;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CastEntryStateReceiver(@l p<? super Boolean, ? super String, l2> pVar) {
        l0.p(pVar, "callback");
        this.f2282a = pVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@m Context context, @m Intent intent) {
        if (l0.g(intent != null ? intent.getAction() : null, b.f7113b)) {
            boolean booleanExtra = intent.getBooleanExtra(b.f7122k, false);
            long longExtra = intent.getLongExtra(b.f7123l, 0L);
            String stringExtra = intent.getStringExtra(b.f7124m);
            Log.d(f2281c, "Received cast entry state: enabled=" + booleanExtra + ", timestamp=" + longExtra + ", source=" + stringExtra);
            this.f2282a.invoke(Boolean.valueOf(booleanExtra), stringExtra);
        }
    }
}
