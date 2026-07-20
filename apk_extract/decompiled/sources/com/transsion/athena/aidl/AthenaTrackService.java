package com.transsion.athena.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import p6.a;

/* JADX INFO: loaded from: classes2.dex */
public class AthenaTrackService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2312a;

    public AthenaTrackService() {
        a aVar = new a();
        aVar.attachInterface(aVar, "com.transsion.athena.IAthenaTrackInterface");
        this.f2312a = aVar;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        z6.a.a("AthenaTrackService onBind");
        return this.f2312a;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        z6.a.a("AthenaTrackService onUnbind");
        return super.onUnbind(intent);
    }
}
