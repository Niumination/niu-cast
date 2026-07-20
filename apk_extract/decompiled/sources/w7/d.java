package w7;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Log;
import bd.b;
import j3.z;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import w7.a;
import w7.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10679a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o6.a f10680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static z f10682d;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.transsion.capability.screencontrol.utils.KeyguardManagerUtil$ScreenLockStatusHelper$mScreenBroadcastReceiver$1] */
    static {
        o6.a aVar = new o6.a(2);
        aVar.f8409d = new AtomicBoolean(true);
        f10680b = aVar;
        final a aVar2 = new a();
        aVar2.f10674b = new Handler(Looper.getMainLooper());
        aVar2.f10676d = new AtomicBoolean(false);
        aVar2.e = new BroadcastReceiver() { // from class: com.transsion.capability.screencontrol.utils.KeyguardManagerUtil$ScreenLockStatusHelper$mScreenBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) throws Exception {
                Intrinsics.checkNotNullParameter(intent, "intent");
                gc.a("KeyguardManagerUtil", "action:" + intent.getAction());
                String action = intent.getAction();
                if (action != null) {
                    int iHashCode = action.hashCode();
                    a aVar3 = aVar2;
                    if (iHashCode == -2128145023) {
                        if (action.equals("android.intent.action.SCREEN_OFF") && aVar3.f10675c != null) {
                            b.f();
                            return;
                        }
                        return;
                    }
                    if (iHashCode == -1454123155) {
                        if (action.equals("android.intent.action.SCREEN_ON") && aVar3.f10675c != null) {
                            b.g();
                            return;
                        }
                        return;
                    }
                    if (iHashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        long j8 = jElapsedRealtime - aVar3.f10673a;
                        aVar3.f10673a = jElapsedRealtime;
                        if (j8 <= 500 || aVar3.f10675c == null) {
                            return;
                        }
                        d.f10679a = 0;
                        gc.a("ScreenControlUtils", "unLockScreen");
                        pa.a aVar4 = pa.a.f8703a;
                        if (pa.a.j("ro.tr_project.flip_screen.support")) {
                            o6.a aVar5 = d.f10680b;
                            if (((AtomicBoolean) aVar5.f8409d).get()) {
                                throw new Exception("not registerDisplayFoldListener,must registerDisplayFoldListener to get the value");
                            }
                            if (aVar5.f8408c) {
                                gc.a("ScreenControlUtils", "unLockScreen fold status");
                            } else {
                                gc.a("ScreenControlUtils", "unLockScreen not fold status");
                                if (d.f10682d != null) {
                                    z.c();
                                }
                            }
                            gc.a("ScreenControlUtils", "unLockScreen isFoldPocket");
                            return;
                        }
                        if (pa.a.j("ro.tr_project.foldable_screen.support")) {
                            gc.a("ScreenControlUtils", "unLockScreen isFoldNormal");
                            if (d.f10682d != null) {
                                z.c();
                                return;
                            }
                            return;
                        }
                        gc.a("ScreenControlUtils", "unLockScreen not fold  phone");
                        if (d.f10682d != null) {
                            z.c();
                        }
                    }
                }
            }
        };
        f10681c = aVar2;
    }

    public static void a() {
        Application context = pb.a();
        bd.b lister = new bd.b();
        a aVar = f10681c;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lister, "lister");
        if (aVar.f10676d.compareAndSet(false, true)) {
            Intrinsics.checkNotNullParameter("KeyguardManagerUtil", "tag");
            Intrinsics.checkNotNullParameter("registerScreenLockStatusChange", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("KeyguardManagerUtil"), "registerScreenLockStatusChange");
            }
            aVar.f10675c = lister;
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("keyguard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            if (((KeyguardManager) systemService).isKeyguardLocked()) {
                Intrinsics.checkNotNullParameter("KeyguardManagerUtil", "tag");
                Intrinsics.checkNotNullParameter("isKeyguard:lockScreen", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("KeyguardManagerUtil"), "isKeyguard:lockScreen");
                }
                bd.b.f();
            } else {
                Object systemService2 = context.getSystemService("power");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
                boolean zIsInteractive = ((PowerManager) systemService2).isInteractive();
                String strO = o.d.o("isScreenOn:", zIsInteractive, "KeyguardManagerUtil", "tag", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("KeyguardManagerUtil"), strO);
                }
                if (zIsInteractive) {
                    bd.b.g();
                } else {
                    bd.b.f();
                }
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            sj.a aVar2 = c.f10678a;
            UserHandle CURRENT = z8.a.f11265a;
            Intrinsics.checkNotNullExpressionValue(CURRENT, "CURRENT");
            pb.b(aVar2, context, aVar.e, intentFilter, aVar.f10674b);
        }
    }
}
