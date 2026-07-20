package m3;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class y {
    public static final void a(xg.k kVar, String name, String value, Function1 build) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(build, "build");
        build.invoke(((xg.u) kVar).s(new xg.a(name, value)));
    }

    public static final xg.u b(xg.k kVar, String path, zf.x method, Function1 build) {
        String strSubstring;
        w gVar;
        w eVar;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(build, "build");
        xg.b bVar = new xg.b(method);
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        xg.v vVar = xg.v.f10992b;
        List list = z.a(path).f10993a;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            xg.w wVar = (xg.w) list.get(i8);
            String value = wVar.f10994a;
            int i9 = xg.p.$EnumSwitchMapping$0[wVar.f10995b.ordinal()];
            if (i9 == 1) {
                Intrinsics.checkNotNullParameter(value, "value");
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) value, '{', 0, false, 6, (Object) null);
                int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) value, '}', 0, false, 6, (Object) null);
                String strSubstring2 = null;
                if (iIndexOf$default == 0) {
                    strSubstring = null;
                } else {
                    strSubstring = value.substring(0, iIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                }
                if (iLastIndexOf$default != value.length() - 1) {
                    strSubstring2 = value.substring(iLastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                }
                String strSubstring3 = value.substring(iIndexOf$default + 1, iLastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                if (StringsKt__StringsJVMKt.endsWith$default(strSubstring3, "?", false, 2, null)) {
                    gVar = new xg.f(StringsKt.dropLast(strSubstring3, 1), strSubstring, strSubstring2);
                } else if (!StringsKt__StringsJVMKt.endsWith$default(strSubstring3, "...", false, 2, null)) {
                    gVar = new xg.g(strSubstring3, strSubstring, strSubstring2);
                } else {
                    if (strSubstring2 != null && strSubstring2.length() != 0) {
                        throw new IllegalArgumentException("Suffix after tailcard is not supported");
                    }
                    String strDropLast = StringsKt.dropLast(strSubstring3, 3);
                    if (strSubstring == null) {
                        strSubstring = "";
                    }
                    gVar = new xg.h(strDropLast, strSubstring);
                }
                eVar = gVar;
            } else {
                if (i9 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                eVar = Intrinsics.areEqual(value, vj.e.ANY_MARKER) ? xg.i.f10957a : new xg.e(value);
            }
            kVar = ((xg.u) kVar).s(eVar);
        }
        if (StringsKt__StringsJVMKt.endsWith$default(path, "/", false, 2, null)) {
            kVar = ((xg.u) kVar).s(xg.p0.f10981a);
        }
        xg.u uVarS = ((xg.u) kVar).s(bVar);
        build.invoke(uVarS);
        return uVarS;
    }
}
