package za;

import android.app.Application;
import android.content.Intent;
import android.os.UserHandle;
import android.util.Log;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import na.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11266a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final sj.a f11267b = new sj.a(5);

    public static boolean a() {
        if (!f11266a) {
            Intrinsics.checkNotNullParameter("GestureAction", "tag");
            Intrinsics.checkNotNullParameter("is not active", "log");
            if (gc.f6462a <= 5) {
                Log.w(gc.f6463b.concat("GestureAction"), "is not active");
            }
            return false;
        }
        s8.a aVar = (s8.a) d.f8136a.getValue();
        aVar.getClass();
        if (aVar.a(l9.a.f).isSplitScreen()) {
            Intrinsics.checkNotNullParameter("GestureAction", "tag");
            Intrinsics.checkNotNullParameter("in multiple window", "log");
            if (gc.f6462a <= 5) {
                Log.w(gc.f6463b.concat("GestureAction"), "in multiple window");
            }
            return false;
        }
        if (!new s8.a().a(l9.a.f7345d).hasMultiWindow()) {
            return true;
        }
        Intrinsics.checkNotNullParameter("GestureAction", "tag");
        Intrinsics.checkNotNullParameter("TranActivityTaskManager in thunder back window", "log");
        if (gc.f6462a <= 5) {
            Log.w(gc.f6463b.concat("GestureAction"), "TranActivityTaskManager in thunder back window");
        }
        return false;
    }

    public static void b(String str) {
        String log = "<sendBroadcast> action = ".concat(str);
        Intrinsics.checkNotNullParameter("GestureAction", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("GestureAction"), log);
        }
        Application applicationA = pb.a();
        Intent intent = new Intent(str);
        UserHandle CURRENT = z8.a.f11265a;
        Intrinsics.checkNotNullExpressionValue(CURRENT, "CURRENT");
        pb.c(applicationA, intent);
    }
}
