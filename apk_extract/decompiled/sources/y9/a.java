package y9;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    Intent b(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler);

    void c(Application application, Intent intent);
}
