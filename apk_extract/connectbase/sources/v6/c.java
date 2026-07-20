package v6;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import gm.i;
import gm.j;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements hf.c {
    @Override // hf.c
    public ComponentName a(Context context, Intent intent, UserHandle userHandle) {
        return (ComponentName) cc.a.j(cc.a.g(context.getClass(), "startServiceAsUser", Intent.class, UserHandle.class), context, intent, userHandle);
    }

    @Override // hf.c
    public void b() {
        Method methodG = cc.a.g(AssetManager.class, "enableAssetsOverlay", new Class[0]);
        if (methodG != null) {
            cc.a.j(methodG, null, new Object[0]);
        }
    }

    @Override // hf.c
    public Intent c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
        return (Intent) cc.a.j(cc.a.g(context.getClass(), "registerReceiverForAllUsers", BroadcastReceiver.class, IntentFilter.class, String.class, Handler.class, Integer.TYPE), context, broadcastReceiver, intentFilter, str, handler, Integer.valueOf(i10));
    }

    @Override // hf.c
    public int d(Context context) {
        Object objJ = cc.a.j(cc.a.g(context.getClass(), "getDisplayId", new Class[0]), context, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // hf.c
    public void e(Context context, @i Intent intent, @j Bundle bundle, @i UserHandle userHandle) {
        cc.a.j(cc.a.g(context.getClass(), "startActivityAsUser", Intent.class, Bundle.class, UserHandle.class), context, intent, bundle, userHandle);
    }

    @Override // hf.c
    public UserHandle f(Context context) {
        return (UserHandle) cc.a.j(cc.a.g(context.getClass(), "getUser", new Class[0]), context, new Object[0]);
    }

    @Override // hf.c
    public Context g(Context context, @i String str, int i10, @i UserHandle userHandle) {
        Object objJ = cc.a.j(cc.a.g(context.getClass(), "createPackageContextAsUser", String.class, Integer.TYPE, UserHandle.class), context, str, Integer.valueOf(i10), userHandle);
        if (objJ instanceof Context) {
            return (Context) objJ;
        }
        return null;
    }

    @Override // hf.c
    public boolean h(Context context, @i Intent intent, @i ServiceConnection serviceConnection, int i10, @i UserHandle userHandle) {
        Object objJ = cc.a.j(cc.a.g(context.getClass(), "bindServiceAsUser", Intent.class, ServiceConnection.class, Integer.TYPE, UserHandle.class), context, intent, serviceConnection, Integer.valueOf(i10), userHandle);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // hf.c
    public void i(Context context, Intent intent, UserHandle userHandle) {
        cc.a.j(cc.a.g(context.getClass(), "sendBroadcastAsUser", Intent.class, UserHandle.class), context, intent, userHandle);
    }

    @Override // hf.c
    public Intent j(Context context, BroadcastReceiver broadcastReceiver, UserHandle userHandle, IntentFilter intentFilter, @j String str, @j Handler handler) {
        return (Intent) cc.a.j(cc.a.g(context.getClass(), "registerReceiverAsUser", BroadcastReceiver.class, UserHandle.class, IntentFilter.class, String.class, Handler.class), context, broadcastReceiver, userHandle, intentFilter, str, handler);
    }

    @Override // hf.c
    public void k(Context context, @i Intent intent, @i UserHandle userHandle) {
        cc.a.j(cc.a.g(context.getClass(), "startActivityAsUser", Intent.class, UserHandle.class), context, intent, userHandle);
    }
}
