package k3;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f6462a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f6463b = "LogUtils-";

    public static void a(String tag, String log) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (f6462a <= 3) {
            Log.d(f6463b.concat(tag), log);
        }
    }

    public static void b(String tag, String log) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (f6462a <= 6) {
            Log.e(f6463b.concat(tag), log);
        }
    }

    public static void c(String tag, String log) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (f6462a <= 4) {
            Log.i(f6463b.concat(tag), log);
        }
    }

    public static void d(String tag, String log) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (f6462a <= 5) {
            Log.w(f6463b.concat(tag), log);
        }
    }
}
