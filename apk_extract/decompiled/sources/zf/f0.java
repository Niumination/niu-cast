package zf;

import af.s1;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends s1 implements e0 {
    @Override // zf.e0
    public final d0 build() {
        Map values = (Map) this.f574b;
        Intrinsics.checkNotNullParameter(values, "values");
        return new g0(values);
    }
}
