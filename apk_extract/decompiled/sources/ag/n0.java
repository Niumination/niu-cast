package ag;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
