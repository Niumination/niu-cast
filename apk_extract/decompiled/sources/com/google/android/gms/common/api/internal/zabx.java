package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import i1.a;
import r2.w;

/* JADX INFO: loaded from: classes.dex */
public final class zabx extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1823b;

    public zabx(a aVar) {
        this.f1823b = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            ((w) this.f1823b.f5525c).getClass();
            throw null;
        }
    }
}
