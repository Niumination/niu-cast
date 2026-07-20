package xg;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends m3.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f10981a = new p0();

    @Override // m3.w
    public final n a(c0 c0Var, int i8) {
        mg.r rVar = c0Var.f10928b;
        zg.a aVar = d.f10934a;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        zg.h hVarI = rVar.i();
        hVarI.getClass();
        zg.a key = d.f10934a;
        Intrinsics.checkNotNullParameter(key, "key");
        if (hVarI.c().containsKey(key)) {
            return n.f;
        }
        List list = c0Var.f10930d;
        if (list.isEmpty()) {
            return n.e;
        }
        if (i8 < CollectionsKt.getLastIndex(list)) {
            return n.f;
        }
        if (i8 > CollectionsKt.getLastIndex(list)) {
            return n.f10968a;
        }
        if (((CharSequence) list.get(i8)).length() > 0) {
            return n.f;
        }
        return c0Var.e ? n.f10972g : n.f10968a;
    }

    public final String toString() {
        return "<slash>";
    }
}
