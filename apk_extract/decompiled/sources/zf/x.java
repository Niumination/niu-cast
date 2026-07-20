package zf;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f11553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f11554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f11555d;
    public static final x e;
    public static final x f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x f11556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f11557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List f11558i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11559a;

    static {
        x xVar = new x("GET");
        f11553b = xVar;
        x xVar2 = new x("POST");
        f11554c = xVar2;
        x xVar3 = new x("PUT");
        f11555d = xVar3;
        x xVar4 = new x("PATCH");
        e = xVar4;
        x xVar5 = new x("DELETE");
        f = xVar5;
        x xVar6 = new x("HEAD");
        f11556g = xVar6;
        x xVar7 = new x("OPTIONS");
        f11557h = xVar7;
        f11558i = CollectionsKt.listOf((Object[]) new x[]{xVar, xVar2, xVar3, xVar4, xVar5, xVar6, xVar7});
    }

    public x(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f11559a = value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && Intrinsics.areEqual(this.f11559a, ((x) obj).f11559a);
    }

    public final int hashCode() {
        return this.f11559a.hashCode();
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("HttpMethod(value="), this.f11559a, ')');
    }
}
