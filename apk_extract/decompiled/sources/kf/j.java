package kf;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(cg.j content) {
        super("Failed to write body: " + Reflection.getOrCreateKotlinClass(content.getClass()));
        Intrinsics.checkNotNullParameter(content, "content");
    }
}
