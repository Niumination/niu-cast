package zf;

import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m3.p6;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f11519c = new m();

    @Override // zg.t
    public final Set a() {
        return SetsKt.emptySet();
    }

    @Override // zg.t
    public final List b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return null;
    }

    @Override // zg.t
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        p6.a(this, body);
    }

    @Override // zg.t
    public final boolean d() {
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d0) && ((d0) obj).isEmpty();
    }

    @Override // zg.t
    public final boolean isEmpty() {
        return true;
    }

    @Override // zg.t
    public final Set names() {
        return SetsKt.emptySet();
    }

    public final String toString() {
        return "Parameters " + SetsKt.emptySet();
    }
}
