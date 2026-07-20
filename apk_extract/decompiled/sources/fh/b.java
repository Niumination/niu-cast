package fh;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    static {
        Intrinsics.checkNotNullParameter("CONDITION_FALSE", "symbol");
        Intrinsics.checkNotNullParameter("ALREADY_REMOVED", "symbol");
        Intrinsics.checkNotNullParameter("LIST_EMPTY", "symbol");
        Intrinsics.checkNotNullParameter("REMOVE_PREPARED", "symbol");
        Intrinsics.checkNotNullParameter("NO_DECISION", "symbol");
    }

    public static final c a(Object obj) {
        c cVar;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        d dVar = obj instanceof d ? (d) obj : null;
        return (dVar == null || (cVar = dVar.f5056a) == null) ? (c) obj : cVar;
    }
}
