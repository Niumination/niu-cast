package m3;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class k6 {
    public static final void a(zg.h hVar, zg.h other) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        for (zg.a aVar : CollectionsKt.toList(other.c().keySet())) {
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            hVar.e(aVar, other.b(aVar));
        }
    }
}
