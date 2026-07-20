package se;

import android.content.Intent;
import android.os.Message;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends we.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.g f9701c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(com.welink.protocol.nfbd.g gVar) {
        super(false, "NearbyServiceHandlerThread");
        Intrinsics.checkNotNullParameter("NearbyServiceHandlerThread", "threadName");
        this.f9701c = gVar;
    }

    @Override // we.g
    public final void b(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        o.d.x(msg.what, "handleThreadMessage ", "HandlerThreadPool");
        int i8 = msg.what;
        if (i8 != 1080) {
            Log.e("HandlerThreadPool", "Unknown message type " + i8);
        } else {
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Intent");
            this.f9701c.i((Intent) obj);
        }
    }
}
