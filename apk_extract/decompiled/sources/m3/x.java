package m3;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {
    public static final xg.n a(List segments, int i8, String name, String str, String str2, boolean z2) {
        String value;
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(name, "name");
        if (i8 >= segments.size()) {
            return b(null, z2);
        }
        String str3 = (String) segments.get(i8);
        if (str3.length() == 0) {
            return b(str3, z2);
        }
        if (str == null) {
            value = str3;
        } else {
            if (!StringsKt__StringsJVMKt.startsWith$default(str3, str, false, 2, null)) {
                return b(str3, z2);
            }
            value = StringsKt.drop(str3, str.length());
        }
        if (str2 != null) {
            if (!StringsKt__StringsJVMKt.endsWith$default(value, str2, false, 2, null)) {
                return b(str3, z2);
            }
            value = StringsKt.dropLast(value, str2.length());
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new xg.m(((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) ? 0.8d : 0.9d, new zf.h0(name, CollectionsKt.listOf(value)), 1);
    }

    public static final xg.n b(String str, boolean z2) {
        if (!z2) {
            return xg.n.f10968a;
        }
        if (str != null && str.length() == 0) {
            return new xg.m(1, 2, 0.2d);
        }
        return xg.n.f10971d;
    }
}
