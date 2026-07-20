package m3;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {
    public static zf.i a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(value)) {
            return zf.i.f11505h;
        }
        zf.n nVar = (zf.n) CollectionsKt.last(z5.a(value));
        String str = nVar.f11521a;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            if (Intrinsics.areEqual(StringsKt__StringsKt.trim((CharSequence) str).toString(), vj.e.ANY_MARKER)) {
                return zf.i.f11505h;
            }
            throw new zf.a(value);
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String string = StringsKt__StringsKt.trim((CharSequence) strSubstring).toString();
        if (string.length() == 0) {
            throw new zf.a(value);
        }
        String strSubstring2 = str.substring(iIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        String string2 = StringsKt__StringsKt.trim((CharSequence) strSubstring2).toString();
        if (StringsKt__StringsKt.contains$default((CharSequence) string, ' ', false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) string2, ' ', false, 2, (Object) null)) {
            throw new zf.a(value);
        }
        if (string2.length() == 0 || StringsKt__StringsKt.contains$default((CharSequence) string2, '/', false, 2, (Object) null)) {
            throw new zf.a(value);
        }
        return new zf.i(string, string2, nVar.f11522b);
    }
}
