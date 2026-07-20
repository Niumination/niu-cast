package xg;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends m3.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10952b;

    public h(String name, String prefix) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.f10951a = name;
        this.f10952b = prefix;
        for (int i8 = 0; i8 < prefix.length(); i8++) {
            if (prefix.charAt(i8) == '/') {
                throw new IllegalArgumentException("Multisegment prefix is not supported");
            }
        }
    }

    @Override // m3.w
    public final n a(c0 c0Var, int i8) {
        zf.d0 h0Var;
        String str;
        List list = c0Var.f10930d;
        String str2 = this.f10952b;
        if (str2.length() > 0 && ((str = (String) CollectionsKt.getOrNull(list, i8)) == null || !StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null))) {
            return n.f10968a;
        }
        String name = this.f10951a;
        if (name.length() == 0) {
            zf.d0.f11496b.getClass();
            h0Var = zf.m.f11519c;
        } else {
            List listDrop = CollectionsKt.drop(list, i8);
            ArrayList values = new ArrayList(CollectionsKt.i(listDrop));
            int i9 = 0;
            for (Object obj : listDrop) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String strDrop = (String) obj;
                if (i9 == 0) {
                    strDrop = StringsKt.drop(strDrop, str2.length());
                }
                values.add(strDrop);
                i9 = i10;
            }
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(values, "values");
            h0Var = new zf.h0(name, values);
        }
        return new m(i8 < list.size() ? 0.1d : 0.2d, h0Var, list.size() - i8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.f10951a, hVar.f10951a) && Intrinsics.areEqual(this.f10952b, hVar.f10952b);
    }

    public final int hashCode() {
        return this.f10952b.hashCode() + (this.f10951a.hashCode() * 31);
    }

    public final String toString() {
        return "{...}";
    }
}
