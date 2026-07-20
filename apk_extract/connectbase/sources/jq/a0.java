package jq;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import kn.r1;
import lm.a1;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nStringBuilderJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringBuilderJVM.kt\nkotlin/text/StringsKt__StringBuilderJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1#2:382\n*E\n"})
public class a0 extends z {
    @f1(version = "1.4")
    @an.f
    public static final StringBuilder A(StringBuilder sb2, long j10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(j10);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder B(StringBuilder sb2, StringBuffer stringBuffer) {
        kn.l0.p(sb2, "<this>");
        sb2.append(stringBuffer);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder C(StringBuilder sb2, StringBuilder sb3) {
        kn.l0.p(sb2, "<this>");
        sb2.append((CharSequence) sb3);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder D(StringBuilder sb2, short s10) {
        kn.l0.p(sb2, "<this>");
        sb2.append((int) s10);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final StringBuilder E(StringBuilder sb2, CharSequence charSequence, int i10, int i11) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(charSequence, "value");
        sb2.append(charSequence, i10, i11);
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final StringBuilder F(StringBuilder sb2, char[] cArr, int i10, int i11) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(cArr, "value");
        sb2.append(cArr, i10, i11 - i10);
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine()", imports = {}))
    @os.l
    public static final Appendable G(@os.l Appendable appendable) throws IOException {
        kn.l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(k0.f8860b);
        kn.l0.o(appendableAppend, "append(...)");
        return appendableAppend;
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final Appendable H(Appendable appendable, char c10) throws IOException {
        kn.l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(c10);
        kn.l0.o(appendableAppend, "append(...)");
        return G(appendableAppend);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final Appendable I(Appendable appendable, CharSequence charSequence) throws IOException {
        kn.l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(charSequence);
        kn.l0.o(appendableAppend, "append(...)");
        return G(appendableAppend);
    }

    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine()", imports = {}))
    @os.l
    public static final StringBuilder J(@os.l StringBuilder sb2) {
        kn.l0.p(sb2, "<this>");
        sb2.append(k0.f8860b);
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder K(StringBuilder sb2, byte b10) {
        kn.l0.p(sb2, "<this>");
        sb2.append((int) b10);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder L(StringBuilder sb2, char c10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(c10);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder M(StringBuilder sb2, double d10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(d10);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder N(StringBuilder sb2, float f10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(f10);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder O(StringBuilder sb2, int i10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(i10);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder P(StringBuilder sb2, long j10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(j10);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder Q(StringBuilder sb2, CharSequence charSequence) {
        kn.l0.p(sb2, "<this>");
        sb2.append(charSequence);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder R(StringBuilder sb2, Object obj) {
        kn.l0.p(sb2, "<this>");
        sb2.append(obj);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder S(StringBuilder sb2, String str) {
        kn.l0.p(sb2, "<this>");
        sb2.append(str);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder T(StringBuilder sb2, StringBuffer stringBuffer) {
        kn.l0.p(sb2, "<this>");
        sb2.append(stringBuffer);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder U(StringBuilder sb2, StringBuilder sb3) {
        kn.l0.p(sb2, "<this>");
        sb2.append((CharSequence) sb3);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder V(StringBuilder sb2, short s10) {
        kn.l0.p(sb2, "<this>");
        sb2.append((int) s10);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder W(StringBuilder sb2, boolean z10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(z10);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @a1(expression = "appendLine(value)", imports = {}))
    public static final StringBuilder X(StringBuilder sb2, char[] cArr) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(cArr, "value");
        sb2.append(cArr);
        kn.l0.o(sb2, "append(...)");
        return J(sb2);
    }

    @f1(version = "1.3")
    @os.l
    public static StringBuilder Y(@os.l StringBuilder sb2) {
        kn.l0.p(sb2, "<this>");
        sb2.setLength(0);
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final StringBuilder Z(StringBuilder sb2, int i10) {
        kn.l0.p(sb2, "<this>");
        StringBuilder sbDeleteCharAt = sb2.deleteCharAt(i10);
        kn.l0.o(sbDeleteCharAt, "deleteCharAt(...)");
        return sbDeleteCharAt;
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final StringBuilder a0(StringBuilder sb2, int i10, int i11) {
        kn.l0.p(sb2, "<this>");
        StringBuilder sbDelete = sb2.delete(i10, i11);
        kn.l0.o(sbDelete, "delete(...)");
        return sbDelete;
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final StringBuilder b0(StringBuilder sb2, int i10, CharSequence charSequence, int i11, int i12) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(charSequence, "value");
        StringBuilder sbInsert = sb2.insert(i10, charSequence, i11, i12);
        kn.l0.o(sbInsert, "insert(...)");
        return sbInsert;
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final StringBuilder c0(StringBuilder sb2, int i10, char[] cArr, int i11, int i12) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(cArr, "value");
        StringBuilder sbInsert = sb2.insert(i10, cArr, i11, i12 - i11);
        kn.l0.o(sbInsert, "insert(...)");
        return sbInsert;
    }

    @an.f
    public static final void d0(StringBuilder sb2, int i10, char c10) {
        kn.l0.p(sb2, "<this>");
        sb2.setCharAt(i10, c10);
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final StringBuilder e0(StringBuilder sb2, int i10, int i11, String str) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(str, "value");
        StringBuilder sbReplace = sb2.replace(i10, i11, str);
        kn.l0.o(sbReplace, "replace(...)");
        return sbReplace;
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final void f0(StringBuilder sb2, char[] cArr, int i10, int i11, int i12) {
        kn.l0.p(sb2, "<this>");
        kn.l0.p(cArr, RtspHeaders.Values.DESTINATION);
        sb2.getChars(i11, i12, cArr, i10);
    }

    public static /* synthetic */ void g0(StringBuilder sb2, char[] cArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = sb2.length();
        }
        kn.l0.p(sb2, "<this>");
        kn.l0.p(cArr, RtspHeaders.Values.DESTINATION);
        sb2.getChars(i11, i12, cArr, i10);
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder w(StringBuilder sb2, byte b10) {
        kn.l0.p(sb2, "<this>");
        sb2.append((int) b10);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder x(StringBuilder sb2, double d10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(d10);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder y(StringBuilder sb2, float f10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(f10);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @f1(version = "1.4")
    @an.f
    public static final StringBuilder z(StringBuilder sb2, int i10) {
        kn.l0.p(sb2, "<this>");
        sb2.append(i10);
        kn.l0.o(sb2, "append(...)");
        sb2.append('\n');
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }
}
