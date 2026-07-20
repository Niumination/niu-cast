package ii;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void a(@l Intent intent, @m String str);

    void b(@l BroadcastReceiver broadcastReceiver, @l IntentFilter intentFilter, @m String str, @m Handler handler, int i10);

    void c(@l BroadcastReceiver broadcastReceiver);
}
