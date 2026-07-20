package n9;

import android.annotation.RequiresPermission;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import gm.i;
import gm.j;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hf.c f11429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hf.c f11430b;

    public boolean a(Context context, @i Intent intent, @i ServiceConnection serviceConnection, int i10, @i UserHandle userHandle) {
        return e(fc.b.a.f5988h).h(context, intent, serviceConnection, i10, userHandle);
    }

    public Context b(Context context, @i String str, int i10, @i UserHandle userHandle) throws PackageManager.NameNotFoundException {
        if (str == null) {
            throw new NullPointerException("package name should not be null");
        }
        if (i10 < 0 || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("input flag wrong");
        }
        return e(fc.b.a.f5987g).g(context, str, i10, userHandle);
    }

    public void c() {
        e(fc.b.a.C).b();
    }

    public int d(Context context) {
        return e(fc.b.a.f5986f).d(context);
    }

    public hf.c e(String str) {
        if (fc.b.b(str)) {
            hf.c cVar = this.f11429a;
            if (cVar != null) {
                return cVar;
            }
            oc.c cVar2 = new oc.c();
            this.f11429a = cVar2;
            return cVar2;
        }
        hf.c cVar3 = this.f11430b;
        if (cVar3 != null) {
            return cVar3;
        }
        v6.c cVar4 = new v6.c();
        this.f11430b = cVar4;
        return cVar4;
    }

    public UserHandle f(Context context) {
        if (context != null) {
            return e(fc.b.a.f5994n).f(context);
        }
        throw new NullPointerException("context is null");
    }

    public Intent g(Context context, BroadcastReceiver broadcastReceiver, UserHandle userHandle, IntentFilter intentFilter, @j String str, @j Handler handler) {
        return e(fc.b.a.f5985e).j(context, broadcastReceiver, userHandle, intentFilter, str, handler);
    }

    public Intent h(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
        if (context == null) {
            throw new NullPointerException("context should not be null");
        }
        if (intentFilter != null) {
            return e(fc.b.a.E).c(context, broadcastReceiver, intentFilter, str, handler, i10);
        }
        throw new NullPointerException("filter should not be null");
    }

    public void i(Context context, Intent intent, UserHandle userHandle) {
        e(fc.b.a.f5988h).i(context, intent, userHandle);
    }

    public void j(Context context, @RequiresPermission @i Intent intent, @j Bundle bundle, @i UserHandle userHandle) {
        e(fc.b.a.f5985e).e(context, intent, bundle, userHandle);
    }

    public void k(Context context, @RequiresPermission @i Intent intent, @i UserHandle userHandle) {
        e(fc.b.a.f5984d).k(context, intent, userHandle);
    }

    public ComponentName l(Context context, Intent intent, UserHandle userHandle) {
        if (context != null) {
            return e(fc.b.a.f6003w).a(context, intent, userHandle);
        }
        throw new NullPointerException("context is null");
    }
}
