package oc;

import android.annotation.RequiresPermission;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import com.transsion.hubsdk.TranContext;
import gm.i;
import gm.j;

/* JADX INFO: loaded from: classes2.dex */
public class c implements hf.c {
    @Override // hf.c
    public ComponentName a(Context context, Intent intent, UserHandle userHandle) {
        return TranContext.get(context).startServiceAsUser(context, intent, userHandle);
    }

    @Override // hf.c
    public void b() {
        TranContext.enableAssetsOverlay();
    }

    @Override // hf.c
    public Intent c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
        return TranContext.get(context).registerReceiverForAllUsers(context, broadcastReceiver, intentFilter, str, handler, i10);
    }

    @Override // hf.c
    public int d(Context context) {
        return TranContext.get(context).getDisplayId(context);
    }

    @Override // hf.c
    public void e(Context context, @RequiresPermission @i Intent intent, @j Bundle bundle, @i UserHandle userHandle) {
        TranContext.get(context).startActivityAsUser(context, intent, bundle, userHandle);
    }

    @Override // hf.c
    public UserHandle f(Context context) {
        return TranContext.get(context).getUser(context);
    }

    @Override // hf.c
    public Context g(Context context, @i String str, int i10, @i UserHandle userHandle) {
        return TranContext.get(context).createPackageContextAsUser(context, str, i10, userHandle);
    }

    @Override // hf.c
    public boolean h(Context context, Intent intent, ServiceConnection serviceConnection, int i10, UserHandle userHandle) {
        return false;
    }

    @Override // hf.c
    public void i(Context context, Intent intent, UserHandle userHandle) {
    }

    @Override // hf.c
    public Intent j(Context context, BroadcastReceiver broadcastReceiver, UserHandle userHandle, IntentFilter intentFilter, @j String str, @j Handler handler) {
        return TranContext.get(context).registerReceiverAsUser(context, broadcastReceiver, userHandle, intentFilter, str, handler);
    }

    @Override // hf.c
    public void k(Context context, @RequiresPermission @i Intent intent, @i UserHandle userHandle) {
        TranContext.get(context).startActivityAsUser(context, intent, userHandle);
    }
}
