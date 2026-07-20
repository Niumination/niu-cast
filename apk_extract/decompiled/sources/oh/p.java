package oh;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends s {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(byte[] data) {
        super(true, y.PING, data, false, false, false);
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
