package zf;

import af.s1;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends s1 {
    public s() {
        super(8);
    }

    @Override // af.s1
    public final void m(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        super.m(name);
        v.a(name);
    }

    @Override // af.s1
    public final void n(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super.n(value);
        v.b(value);
    }

    public final t o() {
        Map values = (Map) this.f574b;
        Intrinsics.checkNotNullParameter(values, "values");
        return new t(values);
    }
}
