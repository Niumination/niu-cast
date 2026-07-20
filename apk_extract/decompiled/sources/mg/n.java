package mg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends m {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
