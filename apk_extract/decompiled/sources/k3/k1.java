package k3;

import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class k1 {
    public static final void a(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.d("DefaultLog.".concat(tag), msg);
    }

    public static final void b(String tag, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.e("DefaultLog.".concat(tag), msg);
    }

    public static final void c(String str, String msg, Throwable th2) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(msg, "msg");
        String strConcat = "DefaultLog.".concat(str);
        String string = th2.toString();
        String message = th2.getMessage();
        Throwable cause = th2.getCause();
        StackTraceElement[] stackTrace = th2.getStackTrace();
        if (stackTrace != null) {
            arrayList = new ArrayList(stackTrace.length);
            for (StackTraceElement stackTraceElement : stackTrace) {
                arrayList.add(stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ":" + stackTraceElement.getMethodName());
            }
        } else {
            arrayList = null;
        }
        Log.e(strConcat, msg + ",throwable=" + string + "," + message + "," + cause + "," + arrayList);
    }

    public static final void d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "s");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.w("DefaultLog.".concat(tag), msg);
    }
}
