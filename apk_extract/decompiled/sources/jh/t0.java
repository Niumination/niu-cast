package jh;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(String taskName) {
        super("Concurrent " + taskName + " attempts");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
    }
}
