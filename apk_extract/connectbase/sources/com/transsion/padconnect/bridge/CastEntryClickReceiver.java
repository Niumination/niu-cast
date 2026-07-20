package com.transsion.padconnect.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import hi.b;
import kn.l0;
import kn.w;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class CastEntryClickReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f2277b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final String f2278c = "CastEntryClickReceiver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final jn.l<String, l2> f2279a;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CastEntryClickReceiver(@l jn.l<? super String, l2> lVar) {
        l0.p(lVar, "callback");
        this.f2279a = lVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@m Context context, @m Intent intent) {
        if (l0.g(intent != null ? intent.getAction() : null, b.f7114c)) {
            long longExtra = intent.getLongExtra(b.f7123l, 0L);
            String stringExtra = intent.getStringExtra(b.f7124m);
            Log.d(f2278c, "Received cast entry click: timestamp=" + longExtra + ", source=" + stringExtra);
            this.f2279a.invoke(stringExtra);
        }
    }
}
