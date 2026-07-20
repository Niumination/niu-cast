package xg;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import m3.z5;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends m3.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10925b;

    public a(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f10924a = name;
        this.f10925b = value;
    }

    @Override // m3.w
    public final n a(c0 c0Var, int i8) {
        Object next;
        Iterator it = CollectionsKt.sortedWith(z5.a(c0Var.f10928b.g().a().get(this.f10924a)), new zf.u()).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt__StringsJVMKt.equals(((zf.n) next).f11521a, this.f10925b, true));
        zf.n nVar = (zf.n) next;
        return nVar == null ? n.f10970c : new m(0, 6, nVar.f11523c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f10924a, aVar.f10924a) && Intrinsics.areEqual(this.f10925b, aVar.f10925b);
    }

    public final int hashCode() {
        return this.f10925b.hashCode() + (this.f10924a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("(header:");
        sb2.append(this.f10924a);
        sb2.append(" = ");
        return a1.a.s(sb2, this.f10925b, ')');
    }
}
