package pb;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f8715d;

    public b(List descParams, int i8, int i9, int i10) {
        Intrinsics.checkNotNullParameter(descParams, "descParams");
        this.f8712a = i8;
        this.f8713b = i9;
        this.f8714c = i10;
        this.f8715d = descParams;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f8712a == bVar.f8712a && this.f8713b == bVar.f8713b && this.f8714c == bVar.f8714c && Intrinsics.areEqual(this.f8715d, bVar.f8715d);
    }

    public final int hashCode() {
        return this.f8715d.hashCode() + a1.a.c(this.f8714c, a1.a.c(this.f8713b, Integer.hashCode(this.f8712a) * 31, 31), 31);
    }

    public final String toString() {
        return "Item(title=" + this.f8712a + ", desc=" + this.f8713b + ", imageRes=" + this.f8714c + ", descParams=" + this.f8715d + ")";
    }

    public /* synthetic */ b(int i8, int i9, int i10) {
        this(CollectionsKt.emptyList(), i8, i9, i10);
    }
}
