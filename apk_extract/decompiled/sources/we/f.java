package we;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f10724a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.f10724a = gVar;
    }

    @Override // android.os.Handler
    public final synchronized void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.f10724a.b(msg);
    }
}
