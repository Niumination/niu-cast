package ii;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Context f7935a;

    public b(@l Context context) {
        l0.p(context, "context");
        this.f7935a = context;
    }

    @Override // ii.a
    public void a(@l Intent intent, @m String str) {
        l0.p(intent, "intent");
        this.f7935a.sendBroadcast(intent, str);
    }

    @Override // ii.a
    public void b(@l BroadcastReceiver broadcastReceiver, @l IntentFilter intentFilter, @m String str, @m Handler handler, int i10) {
        l0.p(broadcastReceiver, "receiver");
        l0.p(intentFilter, "filter");
        ContextCompat.registerReceiver(this.f7935a, broadcastReceiver, intentFilter, str, handler, i10);
    }

    @Override // ii.a
    public void c(@l BroadcastReceiver broadcastReceiver) {
        l0.p(broadcastReceiver, "receiver");
        this.f7935a.unregisterReceiver(broadcastReceiver);
    }
}
