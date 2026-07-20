package mc;

import android.os.Message;
import android.util.Log;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import we.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends g {
    @Override // we.g
    public final void b(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        super.b(msg);
        String log = "handleThreadMessage: " + msg;
        Intrinsics.checkNotNullParameter("HandlerThreadPool", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("HandlerThreadPool"), log);
        }
    }
}
