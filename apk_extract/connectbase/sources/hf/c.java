package hf;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import gm.i;
import gm.j;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    ComponentName a(Context context, Intent intent, UserHandle userHandle);

    void b();

    Intent c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10);

    int d(Context context);

    void e(Context context, @i Intent intent, @j Bundle bundle, @i UserHandle userHandle);

    UserHandle f(Context context);

    Context g(Context context, @i String str, int i10, @i UserHandle userHandle);

    boolean h(Context context, @i Intent intent, @i ServiceConnection serviceConnection, int i10, @i UserHandle userHandle);

    void i(Context context, Intent intent, UserHandle userHandle);

    Intent j(Context context, BroadcastReceiver broadcastReceiver, UserHandle userHandle, IntentFilter intentFilter, @j String str, @j Handler handler);

    void k(Context context, @i Intent intent, @i UserHandle userHandle);
}
