package k3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class c2 {
    public static final void a(Exception exc, Exception cause) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(cause, "cause");
        exc.initCause(cause);
    }
}
