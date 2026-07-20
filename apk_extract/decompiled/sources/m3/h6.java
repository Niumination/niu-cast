package m3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class h6 {
    public static final String a(zf.r0 r0Var) {
        Intrinsics.checkNotNullParameter(r0Var, "<this>");
        StringBuilder sb2 = new StringBuilder();
        String encodedPath = (String) r0Var.f11545k.getValue();
        String encodedQuery = (String) r0Var.f11546l.getValue();
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
        Intrinsics.checkNotNullParameter(encodedQuery, "encodedQuery");
        if (!StringsKt.isBlank(encodedPath) && !StringsKt__StringsJVMKt.startsWith$default(encodedPath, "/", false, 2, null)) {
            sb2.append('/');
        }
        sb2.append((CharSequence) encodedPath);
        if (encodedQuery.length() > 0 || r0Var.e) {
            sb2.append((CharSequence) "?");
        }
        sb2.append((CharSequence) encodedQuery);
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String b(zf.r0 r0Var) {
        Intrinsics.checkNotNullParameter(r0Var, "<this>");
        return r0Var.f11537a + ':' + r0Var.a();
    }

    public static final void c(zf.j0 j0Var, zf.r0 url) {
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        j0Var.f11512d = url.f11543i;
        j0Var.e(url.f11537a);
        j0Var.f(url.a());
        e6.d(j0Var, (String) url.f11545k.getValue());
        j0Var.e = (String) url.f11548n.getValue();
        j0Var.f = (String) url.f11549o.getValue();
        zf.f0 value = c6.a();
        value.e(d6.b(0, 6, (String) url.f11546l.getValue()));
        Intrinsics.checkNotNullParameter(value, "value");
        j0Var.f11515i = value;
        j0Var.f11516j = new zf.s0(value);
        String str = (String) url.p.getValue();
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        j0Var.f11513g = str;
        j0Var.f11510b = url.e;
    }
}
