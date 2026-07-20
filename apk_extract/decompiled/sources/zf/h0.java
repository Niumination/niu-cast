package zf;

import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements d0, zg.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11504d;

    public h0(String name, List values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f11503c = name;
        this.f11504d = values;
    }

    @Override // zg.t
    public final Set a() {
        return SetsKt.setOf(new zg.x(this));
    }

    @Override // zg.t
    public final List b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (StringsKt__StringsJVMKt.equals(this.f11503c, name, true)) {
            return this.f11504d;
        }
        return null;
    }

    @Override // zg.t
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        body.invoke(this.f11503c, this.f11504d);
    }

    @Override // zg.t
    public final boolean d() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zg.t)) {
            return false;
        }
        zg.t tVar = (zg.t) obj;
        if (true != tVar.d()) {
            return false;
        }
        return Intrinsics.areEqual(a(), tVar.a());
    }

    public final int hashCode() {
        Set setA = a();
        return setA.hashCode() + (Boolean.hashCode(true) * 961);
    }

    @Override // zg.t
    public final boolean isEmpty() {
        return false;
    }

    @Override // zg.t
    public final Set names() {
        return SetsKt.setOf(this.f11503c);
    }

    public final String toString() {
        return "Parameters " + a();
    }
}
