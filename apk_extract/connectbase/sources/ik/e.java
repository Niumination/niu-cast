package ik;

import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final List<Byte> f7953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final List<Character> f7954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final List<Character> f7955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final List<Byte> f7956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final List<Character> f7957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final List<Byte> f7958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final Set<Character> f7959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final Set<Character> f7960h;

    public static final class a extends kn.n0 implements jn.l<Byte, l2> {
        final /* synthetic */ boolean $spaceToPlus;
        final /* synthetic */ StringBuilder $this_buildString;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(StringBuilder sb2, boolean z10) {
            super(1);
            this.$this_buildString = sb2;
            this.$spaceToPlus = z10;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Byte b10) {
            invoke(b10.byteValue());
            return l2.f10208a;
        }

        public final void invoke(byte b10) {
            if (e.f7953a.contains(Byte.valueOf(b10)) || e.f7958f.contains(Byte.valueOf(b10))) {
                this.$this_buildString.append((char) b10);
            } else if (this.$spaceToPlus && b10 == 32) {
                this.$this_buildString.append('+');
            } else {
                this.$this_buildString.append(e.C(b10));
            }
        }
    }

    public static final class b extends kn.n0 implements jn.l<Byte, l2> {
        final /* synthetic */ StringBuilder $this_buildString;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StringBuilder sb2) {
            super(1);
            this.$this_buildString = sb2;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Byte b10) {
            invoke(b10.byteValue());
            return l2.f10208a;
        }

        public final void invoke(byte b10) {
            this.$this_buildString.append(e.C(b10));
        }
    }

    public static final class c extends kn.n0 implements jn.l<Byte, l2> {
        final /* synthetic */ boolean $encodeFull;
        final /* synthetic */ boolean $spaceToPlus;
        final /* synthetic */ StringBuilder $this_buildString;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z10, StringBuilder sb2, boolean z11) {
            super(1);
            this.$spaceToPlus = z10;
            this.$this_buildString = sb2;
            this.$encodeFull = z11;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Byte b10) {
            invoke(b10.byteValue());
            return l2.f10208a;
        }

        public final void invoke(byte b10) {
            if (b10 == 32) {
                boolean z10 = this.$spaceToPlus;
                StringBuilder sb2 = this.$this_buildString;
                if (z10) {
                    sb2.append('+');
                    return;
                } else {
                    sb2.append("%20");
                    return;
                }
            }
            if (e.f7953a.contains(Byte.valueOf(b10)) || (!this.$encodeFull && e.f7956d.contains(Byte.valueOf(b10)))) {
                this.$this_buildString.append((char) b10);
            } else {
                this.$this_buildString.append(e.C(b10));
            }
        }
    }

    static {
        List listE4 = nm.h0.E4(nm.h0.A4(new tn.c(y5.a.H, 'z', 1), new tn.c(y5.a.G, y5.a.O, 1)), new tn.c('0', '9', 1));
        ArrayList arrayList = new ArrayList(nm.z.b0(listE4, 10));
        Iterator it = listE4.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        f7953a = arrayList;
        f7954b = nm.h0.E4(nm.h0.A4(new tn.c(y5.a.H, 'z', 1), new tn.c(y5.a.G, y5.a.O, 1)), new tn.c('0', '9', 1));
        f7955c = nm.h0.E4(nm.h0.A4(new tn.c(y5.a.H, 'f', 1), new tn.c(y5.a.G, 'F', 1)), new tn.c('0', '9', 1));
        List listO = nm.y.O(Character.valueOf(n1.e.f11184d), Character.valueOf(el.b0.f4502a), '?', '#', Character.valueOf(ks.a.f9445d), ']', '@', '!', Character.valueOf(jq.m0.f8865c), Character.valueOf(jq.m0.f8866d), '\'', '(', ')', Character.valueOf(kl.f.f9277j), Character.valueOf(StringUtil.COMMA), ';', Character.valueOf(fl.h.f6043c), '-', Character.valueOf(n1.e.f11183c), '_', '~', '+');
        ArrayList arrayList2 = new ArrayList(nm.z.b0(listO, 10));
        Iterator it2 = listO.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        f7956d = arrayList2;
        f7957e = nm.y.O(Character.valueOf(n1.e.f11184d), '@', '!', Character.valueOf(jq.m0.f8865c), Character.valueOf(jq.m0.f8866d), '\'', '(', ')', Character.valueOf(kl.f.f9277j), '+', Character.valueOf(StringUtil.COMMA), ';', Character.valueOf(fl.h.f6043c), '-', Character.valueOf(n1.e.f11183c), '_', '~');
        List listO2 = nm.y.O('-', Character.valueOf(n1.e.f11183c), '_', '~');
        ArrayList arrayList3 = new ArrayList(nm.z.b0(listO2, 10));
        Iterator it3 = listO2.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Byte.valueOf((byte) ((Character) it3.next()).charValue()));
        }
        f7958f = arrayList3;
        Set<Character> setD = nm.p1.D(nm.p1.D(nm.h0.a6(new tn.c(y5.a.H, 'z', 1)), nm.h0.a6(new tn.c(y5.a.G, y5.a.O, 1))), nm.h0.a6(new tn.c('0', '9', 1)));
        f7959g = setD;
        f7960h = nm.p1.D(nm.o1.u('!', '#', '%', Character.valueOf(jq.m0.f8866d), '\'', Character.valueOf(kl.f.f9277j), '+', '-', Character.valueOf(n1.e.f11183c), '^', '_', '`', '|', '~'), setD);
    }

    public static /* synthetic */ void A() {
    }

    public static final char B(int i10) {
        return (char) ((i10 < 0 || i10 >= 10) ? ((char) (i10 + 65)) - '\n' : i10 + 48);
    }

    public static final String C(byte b10) {
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append('%');
        sb2.append(B((b10 & 255) >> 4));
        sb2.append(B(b10 & c1.c.f1123q));
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final int e(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('A' <= c10 && c10 < 'G') {
            return c10 - '7';
        }
        if ('a' > c10 || c10 >= 'g') {
            return -1;
        }
        return c10 - 'W';
    }

    public static final String f(CharSequence charSequence, int i10, int i11, int i12, boolean z10, Charset charset) throws q1 {
        int i13 = i11 - i10;
        if (i13 > 255) {
            i13 /= 3;
        }
        StringBuilder sb2 = new StringBuilder(i13);
        if (i12 > i10) {
            sb2.append(charSequence, i10, i12);
        }
        byte[] bArr = null;
        while (i12 < i11) {
            char cCharAt = charSequence.charAt(i12);
            if (z10 && cCharAt == '+') {
                sb2.append(' ');
            } else if (cCharAt == '%') {
                if (bArr == null) {
                    bArr = new byte[(i11 - i12) / 3];
                }
                int i14 = 0;
                while (i12 < i11 && charSequence.charAt(i12) == '%') {
                    int i15 = i12 + 2;
                    if (i15 >= i11) {
                        throw new q1("Incomplete trailing HEX escape: " + charSequence.subSequence(i12, charSequence.length()).toString() + ", in " + ((Object) charSequence) + " at " + i12);
                    }
                    int i16 = i12 + 1;
                    int iE = e(charSequence.charAt(i16));
                    int iE2 = e(charSequence.charAt(i15));
                    if (iE == -1 || iE2 == -1) {
                        throw new q1("Wrong HEX escape: %" + charSequence.charAt(i16) + charSequence.charAt(i15) + ", in " + ((Object) charSequence) + ", at " + i12);
                    }
                    bArr[i14] = (byte) ((iE * 16) + iE2);
                    i12 += 3;
                    i14++;
                }
                sb2.append(new String(bArr, 0, i14, charset));
            } else {
                sb2.append(cCharAt);
            }
            i12++;
        }
        String string = sb2.toString();
        kn.l0.o(string, "sb.toString()");
        return string;
    }

    public static final String g(String str, int i10, int i11, boolean z10, Charset charset) {
        int i12 = i10;
        while (i12 < i11) {
            int i13 = i12 + 1;
            char cCharAt = str.charAt(i12);
            if (cCharAt == '%' || (z10 && cCharAt == '+')) {
                return f(str, i10, i11, i12, z10, charset);
            }
            i12 = i13;
        }
        if (i10 == 0 && i11 == str.length()) {
            return str.toString();
        }
        String strSubstring = str.substring(i10, i11);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @os.l
    public static final String h(@os.l String str, int i10, int i11, @os.l Charset charset) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charset, "charset");
        return g(str, i10, i11, false, charset);
    }

    public static /* synthetic */ String i(String str, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            charset = jq.f.f8800b;
        }
        return h(str, i10, i11, charset);
    }

    @os.l
    public static final String j(@os.l String str, int i10, int i11, boolean z10, @os.l Charset charset) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charset, "charset");
        return g(str, i10, i11, z10, charset);
    }

    public static /* synthetic */ String k(String str, int i10, int i11, boolean z10, Charset charset, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            charset = jq.f.f8800b;
        }
        return j(str, i10, i11, z10, charset);
    }

    @os.l
    public static final String l(@os.l String str) {
        kn.l0.p(str, "<this>");
        return n(str, false, 1, null);
    }

    @os.l
    public static final String m(@os.l String str, boolean z10) throws Throwable {
        kn.l0.p(str, "<this>");
        StringBuilder sb2 = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = jq.f.f8800b.newEncoder();
        kn.l0.o(charsetEncoderNewEncoder, "UTF_8.newEncoder()");
        s(rl.b.f(charsetEncoderNewEncoder, str, 0, 0, 6, null), new a(sb2, z10));
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String n(String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return m(str, z10);
    }

    @os.l
    public static final String o(@os.l String str) {
        kn.l0.p(str, "<this>");
        return m(str, true);
    }

    @os.l
    public static final String p(@os.l String str) throws Throwable {
        int i10;
        kn.l0.p(str, "<this>");
        StringBuilder sb2 = new StringBuilder();
        Charset charset = jq.f.f8800b;
        int i11 = 0;
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '/' || f7954b.contains(Character.valueOf(cCharAt)) || f7957e.contains(Character.valueOf(cCharAt))) {
                sb2.append(cCharAt);
                i11++;
            } else {
                if (cCharAt == '%' && (i10 = i11 + 2) < str.length()) {
                    List<Character> list = f7955c;
                    int i12 = i11 + 1;
                    if (list.contains(Character.valueOf(str.charAt(i12))) && list.contains(Character.valueOf(str.charAt(i10)))) {
                        sb2.append(cCharAt);
                        sb2.append(str.charAt(i12));
                        sb2.append(str.charAt(i10));
                        i11 += 3;
                    }
                }
                int i13 = jq.e.L(cCharAt) ? 2 : 1;
                CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
                kn.l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
                int i14 = i13 + i11;
                s(rl.b.c(charsetEncoderNewEncoder, str, i11, i14), new b(sb2));
                i11 = i14;
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public static final String q(@os.l String str, boolean z10, boolean z11, @os.l Charset charset) throws Throwable {
        kn.l0.p(str, "<this>");
        kn.l0.p(charset, "charset");
        StringBuilder sb2 = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kn.l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        s(rl.b.f(charsetEncoderNewEncoder, str, 0, 0, 6, null), new c(z11, sb2, z10));
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String r(String str, boolean z10, boolean z11, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        if ((i10 & 4) != 0) {
            charset = jq.f.f8800b;
        }
        return q(str, z10, z11, charset);
    }

    public static final void s(tl.v vVar, jn.l<? super Byte, l2> lVar) throws Throwable {
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(vVar, 1);
        if (bVarJ == null) {
            return;
        }
        while (true) {
            try {
                tl.m mVar = bVarJ.f15821b;
                if (mVar.f15874c > mVar.f15873b) {
                    lVar.invoke(Byte.valueOf(bVarJ.readByte()));
                } else {
                    try {
                        bVarJ = ul.k.m(vVar, bVarJ);
                        if (bVarJ == null) {
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = false;
                        if (z10) {
                            ul.k.e(vVar, bVarJ);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static /* synthetic */ void t() {
    }

    @os.l
    public static final Set<Character> u() {
        return f7959g;
    }

    public static /* synthetic */ void v() {
    }

    @os.l
    public static final Set<Character> w() {
        return f7960h;
    }

    public static /* synthetic */ void x() {
    }

    public static /* synthetic */ void y() {
    }

    public static /* synthetic */ void z() {
    }
}
