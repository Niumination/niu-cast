package com.transsion.athena.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.transsion.athena.data.TrackData;
import k6.g;
import y3.b;

/* JADX INFO: loaded from: classes2.dex */
public class AthenaTrackService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l3.a.AbstractBinderC0253a f1811a = new a();

    public class a extends l3.a.AbstractBinderC0253a {
        public a(AthenaTrackService athenaTrackService) {
        }

        @Override // l3.a
        public void N(String str, TrackData trackData, long j10) throws RemoteException {
            b.c("AthenaTrackService receive appId : %d, eventName : %s", Long.valueOf(j10), str);
            g.j0(j10).d1(str, trackData, j10);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        b.b("AthenaTrackService onBind");
        return this.f1811a;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        b.b("AthenaTrackService onUnbind");
        return super.onUnbind(intent);
    }
}
