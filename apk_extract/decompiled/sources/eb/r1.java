package eb;

import ag.b;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.transsion.iotservice.multiscreen.pc.manager.ScreenStateManager$register$1;
import eb.q1;
import eb.r1;
import java.util.concurrent.CopyOnWriteArraySet;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ScreenStateManager$register$1 f4794b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f4793a = new r1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet f4795c = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f4796d = {"android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF", "android.intent.action.USER_PRESENT"};

    public static void a(Function1 function1) {
        for (q1 q1Var : f4795c) {
            Intrinsics.checkNotNull(q1Var);
            function1.invoke(q1Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.transsion.iotservice.multiscreen.pc.manager.ScreenStateManager$register$1] */
    public static void b(Application application) {
        Intrinsics.checkNotNullParameter("ScreenStateManager", "tag");
        Intrinsics.checkNotNullParameter("register receiver", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ScreenStateManager"), "register receiver");
        }
        if (f4794b != null) {
            return;
        }
        f4794b = new BroadcastReceiver() { // from class: com.transsion.iotservice.multiscreen.pc.manager.ScreenStateManager$register$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    r1 r1Var = r1.f4793a;
                    String log = "handleScreenAction: ".concat(action);
                    Intrinsics.checkNotNullParameter("ScreenStateManager", "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("ScreenStateManager"), log);
                    }
                    int iHashCode = action.hashCode();
                    if (iHashCode == -2128145023) {
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            r1.a(new b(7));
                            return;
                        }
                        return;
                    }
                    if (iHashCode == -1454123155) {
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            r1.a(new b(8));
                        }
                    } else if (iHashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                        for (q1 it : r1.f4795c) {
                            Intrinsics.checkNotNull(it);
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.getClass();
                            Intrinsics.checkNotNullParameter("ScreenOffTimer", "tag");
                            Intrinsics.checkNotNullParameter("onUserPresent", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("ScreenOffTimer"), "onUserPresent");
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            }
        };
        ScreenStateManager$register$1 screenStateManager$register$1 = f4794b;
        IntentFilter intentFilter = new IntentFilter();
        for (String str : f4796d) {
            intentFilter.addAction(str);
        }
        ContextCompat.registerReceiver(application, screenStateManager$register$1, intentFilter, 2);
    }
}
