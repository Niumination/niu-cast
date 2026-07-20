package x7;

import android.util.Log;
import com.transsion.connectx.sdk.TCCPListener;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends TCCPListener.Stub {
    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onEnd() {
        Intrinsics.checkNotNullParameter("SourceServiceConnectHelper", "tag");
        Intrinsics.checkNotNullParameter("mTccpBinder onEnd", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SourceServiceConnectHelper"), "mTccpBinder onEnd");
        }
        if (i.f) {
            j jVar = i.f10887b;
            if (jVar != null) {
                jVar.b(new q7.f(0));
            }
        } else {
            i.f = true;
        }
        TCCPListener.Stub stub = i.f10888c;
        if (stub != null) {
            f.m(stub);
        }
        TCCPListener.Stub stub2 = i.f10889d;
        if (stub2 != null) {
            f.l(stub2);
        }
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onError(int i8) {
        Intrinsics.checkNotNullParameter("SourceServiceConnectHelper", "tag");
        Intrinsics.checkNotNullParameter("mTccpBinder onError", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("SourceServiceConnectHelper"), "mTccpBinder onError");
        }
        TCCPListener.Stub stub = i.f10888c;
        if (stub != null) {
            f.m(stub);
        }
        TCCPListener.Stub stub2 = i.f10889d;
        if (stub2 != null) {
            f.l(stub2);
        }
        if (!i.f) {
            i.f = true;
            return;
        }
        j jVar = i.f10887b;
        if (jVar != null) {
            jVar.k(new q7.g(i8, 2));
        }
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onStart() {
        Intrinsics.checkNotNullParameter("SourceServiceConnectHelper", "tag");
        Intrinsics.checkNotNullParameter("mTccpBinder onStart", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SourceServiceConnectHelper"), "mTccpBinder onStart");
        }
        if (!i.f) {
            i.f = true;
            return;
        }
        j jVar = i.f10887b;
        if (jVar != null) {
            jVar.onConnected();
        }
    }
}
