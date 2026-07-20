package se;

import android.app.BackgroundServiceStartNotAllowedException;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import k3.lb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c7 {
    public static final u0 f = new u0(a7.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f9693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothAdapter f9694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WifiManager f9695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9696d;
    public com.welink.protocol.nfbd.z e;

    public final void a(int i8) {
        we.h.g("startTranProfileManager()");
        d(i6.f9809a, 12, i8);
    }

    public final void b(int i8) {
        we.h.g("stopTranProfileManager()");
        d(i6.f9809a, 10, i8);
    }

    public final void c(int i8) {
        we.h.g("state : " + i8);
        if (i8 == 0) {
            this.f9696d = false;
            b(0);
        } else if (i8 == 1) {
            this.f9696d = true;
            a(1);
        } else if (i8 == 2 || i8 == 3) {
            this.f9696d = false;
        }
    }

    public final void d(ArrayList arrayList, int i8, int i9) {
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            we.h.g("Context packname " + this.f9693a.getPackageName() + " Service name is " + ((Class) next).getName());
            Intent intent = new Intent();
            if (i8 == 12) {
                intent.setAction("com.android.bluetooth.btservice.action.START");
            } else {
                intent.setAction("com.android.bluetooth.btservice.action.STOP");
            }
            intent.setAction("com.android.bluetooth.btservice.action.STATE_CHANGED");
            intent.putExtra("action", "com.android.bluetooth.btservice.action.STATE_CHANGED");
            intent.putExtra("smart_state", i9);
            intent.putExtra("android.bluetooth.adapter.extra.STATE", i8);
            try {
                com.welink.protocol.nfbd.z zVar = this.e;
                if (zVar != null) {
                    u0 u0Var = com.welink.protocol.nfbd.z.f4202l;
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    com.welink.protocol.nfbd.g gVar = zVar.f4207i;
                    if (gVar != null) {
                        gVar.w(intent, 0);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                if (e instanceof BackgroundServiceStartNotAllowedException) {
                    String mes = "Android 13 后台服务限制: " + e.getMessage();
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", mes, null);
                    }
                } else if (e instanceof IllegalStateException) {
                    e.printStackTrace();
                    String mes2 = "IllegalStateException: " + e.getMessage();
                    Intrinsics.checkNotNullParameter(mes2, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", mes2, null);
                    }
                } else {
                    e.printStackTrace();
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }
}
