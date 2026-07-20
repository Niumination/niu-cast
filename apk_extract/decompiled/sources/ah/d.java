package ah;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    public /* synthetic */ d(String str, Throwable th2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "Cannot write to a channel" : str, th2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String message, Throwable exception) {
        super(message, exception);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(exception, "exception");
    }
}
