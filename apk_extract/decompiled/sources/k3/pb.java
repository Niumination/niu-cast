package k3;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.UserHandle;
import com.transsion.iotservice.multiscreen.pc.PCConnectApplication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class pb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PCConnectApplication f6621a;

    public static final Application a() {
        PCConnectApplication pCConnectApplication = f6621a;
        if (pCConnectApplication != null) {
            return pCConnectApplication;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sContext");
        return null;
    }

    public static void b(sj.a aVar, Application context, BroadcastReceiver receiver, IntentFilter filter, Handler handler) {
        UserHandle user = z8.a.f11265a;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (context.checkSelfPermission("android.permission.INTERACT_ACROSS_USERS") == 0 || context.checkSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) {
            aVar.i(l9.a.f7344c).b(context, receiver, filter, handler);
        } else {
            context.registerReceiver(receiver, filter, null, handler, 2);
        }
    }

    public static final void c(Application application, Intent intent) {
        UserHandle user = z8.a.f11265a;
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(user, "user");
        if (application.checkSelfPermission("android.permission.INTERACT_ACROSS_USERS") == 0 || application.checkSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) {
            application.sendBroadcastAsUser(intent, user);
        } else {
            application.sendBroadcast(intent);
        }
    }

    public static final void d(sj.a aVar, Application context, Intent intent) {
        UserHandle user = z8.a.f11265a;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(user, "user");
        if (context.checkSelfPermission("android.permission.INTERACT_ACROSS_USERS") == 0 || context.checkSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) {
            aVar.i(l9.a.f7343b).c(context, intent);
        } else {
            context.startActivity(intent);
        }
    }
}
