package cj;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements aj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum[] f1706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f1707b;

    public e(String serialName, Enum[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f1706a = values;
        this.f1707b = LazyKt.lazy(new d(0, this, serialName));
    }

    @Override // aj.a
    public final bj.d getDescriptor() {
        return (bj.d) this.f1707b.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().e() + Typography.greater;
    }
}
