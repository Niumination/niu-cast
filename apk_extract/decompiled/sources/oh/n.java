package oh;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends s {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(byte[] data) {
        super(true, y.CLOSE, data, false, false, false);
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public n(c reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        wi.a packet = new wi.a();
        packet.t(reason.f8481a);
        lh.a.n(packet, reason.f8482b, 0, 0, 14);
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(packet, "<this>");
        this(wi.o.d(packet, -1));
    }
}
