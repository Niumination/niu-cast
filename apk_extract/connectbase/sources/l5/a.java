package l5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Boolean bool) {
        if (Build.VERSION.SDK_INT < 33) {
            context.registerReceiver(broadcastReceiver, new IntentFilter(intentFilter));
        } else if (bool.booleanValue()) {
            context.registerReceiver(broadcastReceiver, intentFilter, 2);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, 4);
        }
    }
}
