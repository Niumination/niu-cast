package jq;

import lm.a1;
import lm.f1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class b0 extends a0 {
    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use append(value: Any?) instead", replaceWith = @a1(expression = "append(value = obj)", imports = {}))
    public static final StringBuilder h0(StringBuilder sb2, Object obj) {
        kn.l0.p(sb2, "<this>");
        sb2.append(obj);
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @an.f
    @lm.k(level = lm.m.ERROR, message = "Use appendRange instead.", replaceWith = @a1(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    public static final StringBuilder i0(StringBuilder sb2, char[] cArr, int i10, int i11) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(cArr, "str");
        throw new lm.j0(null, 1, null);
    }

    @os.l
    public static final StringBuilder j0(@os.l StringBuilder sb2, @os.l Object... objArr) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(objArr, "value");
        for (Object obj : objArr) {
            sb2.append(obj);
        }
        return sb2;
    }

    @os.l
    public static StringBuilder k0(@os.l StringBuilder sb2, @os.l String... strArr) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(strArr, "value");
        for (String str : strArr) {
            sb2.append(str);
        }
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder l0(StringBuilder sb2) {
        kn.l0.p(sb2, "<this>");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder m0(StringBuilder sb2, char c10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(c10);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder n0(StringBuilder sb2, CharSequence charSequence) {
        kn.l0.p(sb2, "<this>");
        sb2.append(charSequence);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder o0(StringBuilder sb2, Object obj) {
        kn.l0.p(sb2, "<this>");
        sb2.append(obj);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder p0(StringBuilder sb2, String str) {
        kn.l0.p(sb2, "<this>");
        sb2.append(str);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder q0(StringBuilder sb2, boolean z10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(z10);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder r0(StringBuilder sb2, char[] cArr) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(cArr, "value");
        sb2.append(cArr);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.1")
    @an.f
    public static final String s0(int i10, jn.l<? super StringBuilder, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        StringBuilder sb2 = new StringBuilder(i10);
        lVar.invoke(sb2);
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    public static final String t0(jn.l<? super StringBuilder, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        StringBuilder sb2 = new StringBuilder();
        lVar.invoke(sb2);
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }
}
