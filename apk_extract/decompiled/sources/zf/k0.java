package zf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
