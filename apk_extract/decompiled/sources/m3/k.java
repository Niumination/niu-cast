package m3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static final String a(vg.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        return (String) ((af.r5) ug.f.a(cVar)).e;
    }

    public static final String b(vg.c cVar, String name) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return cVar.a().get(name);
    }

    public static final String c(vg.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        return StringsKt__StringsKt.substringBefore$default((String) ((af.r5) ug.f.a(cVar)).e, '?', (String) null, 2, (Object) null);
    }
}
