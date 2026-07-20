package oh;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends s {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(byte[] data, li.x0 disposableHandle) {
        super(true, y.PONG, data, false, false, false);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(disposableHandle, "disposableHandle");
    }
}
