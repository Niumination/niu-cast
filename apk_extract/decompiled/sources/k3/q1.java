package k3;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class q1 {
    public static final dg.d a(dg.c cVar, dg.c grammar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return new dg.d(CollectionsKt.listOf((Object[]) new dg.c[]{cVar, grammar}));
    }

    public static final dg.g b(dg.c cVar, dg.c grammar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return new dg.g(CollectionsKt.listOf((Object[]) new dg.c[]{cVar, grammar}));
    }

    public static final dg.g c(dg.c cVar, String value) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        return b(cVar, new dg.h(value));
    }
}
