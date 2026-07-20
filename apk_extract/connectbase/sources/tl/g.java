package tl;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import lm.g2;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    public static final class a extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15829a;

        public a(int i10) {
            this.f15829a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("times shouldn't be negative: ", Integer.valueOf(this.f15829a)));
        }
    }

    public static final class b extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f15831b;

        public b(int i10, e eVar) {
            this.f15830a = i10;
            this.f15831b = eVar;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            StringBuilder sb2 = new StringBuilder("times shouldn't be greater than the write remaining space: ");
            sb2.append(this.f15830a);
            sb2.append(" > ");
            m mVar = this.f15831b.f15821b;
            sb2.append(mVar.f15872a - mVar.f15874c);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    @lm.k(message = "This is no longer supported. Use a packet builder to append characters instead.")
    @os.l
    public static final e a(@os.l e eVar, char c10) {
        int i10;
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i11 = mVar.f15874c;
        int i12 = mVar.f15872a;
        if (c10 >= 0 && c10 < 128) {
            byteBuffer.put(i11, (byte) c10);
            i10 = 1;
        } else if (128 <= c10 && c10 < 2048) {
            byteBuffer.put(i11, (byte) (((c10 >> 6) & 31) | 192));
            byteBuffer.put(i11 + 1, (byte) ((c10 & '?') | 128));
            i10 = 2;
        } else if (2048 <= c10 && c10 < 0) {
            byteBuffer.put(i11, (byte) (((c10 >> '\f') & 15) | 224));
            byteBuffer.put(i11 + 1, (byte) (((c10 >> 6) & 63) | 128));
            byteBuffer.put(i11 + 2, (byte) ((c10 & '?') | 128));
            i10 = 3;
        } else {
            if (0 > c10 || c10 >= 0) {
                ul.j.p(c10);
                throw new lm.y();
            }
            byteBuffer.put(i11, (byte) (((c10 >> 18) & 7) | p5.m0.f12864d));
            byteBuffer.put(i11 + 1, (byte) (((c10 >> '\f') & 63) | 128));
            byteBuffer.put(i11 + 2, (byte) (((c10 >> 6) & 63) | 128));
            byteBuffer.put(i11 + 3, (byte) ((c10 & '?') | 128));
            i10 = 4;
        }
        if (i10 <= i12 - i11) {
            eVar.b(i10);
            return eVar;
        }
        g(1);
        throw new lm.y();
    }

    @lm.k(message = "This is no longer supported. Use a packet builder to append characters instead.")
    @os.l
    public static final e b(@os.l e eVar, @os.m CharSequence charSequence) {
        kn.l0.p(eVar, "<this>");
        return charSequence == null ? b(eVar, d6.a.E) : c(eVar, charSequence, 0, charSequence.length());
    }

    @lm.k(message = "This is no longer supported. Use a packet builder to append characters instead.")
    @os.l
    public static final e c(@os.l e eVar, @os.m CharSequence charSequence, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        if (charSequence == null) {
            return c(eVar, d6.a.E, i10, i11);
        }
        if (e(eVar, charSequence, i10, i11) == i11) {
            return eVar;
        }
        g(i11 - i10);
        throw new lm.y();
    }

    @lm.k(message = "This is no longer supported. Use a packet builder to append characters instead.")
    @os.l
    public static final e d(@os.l e eVar, @os.l char[] cArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(cArr, "csq");
        return c(eVar, new ul.a(cArr, 0, cArr.length), i10, i11);
    }

    public static final int e(@os.l e eVar, @os.l CharSequence charSequence, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(charSequence, "csq");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int iH = ul.j.h(byteBuffer, charSequence, i10, i11, mVar.f15874c, mVar.f15872a);
        int iM = g2.m((short) (iH >>> 16)) & g2.f10190d;
        eVar.b(((short) (iH & 65535)) & g2.f10190d);
        return i10 + iM;
    }

    public static final int f(@os.l e eVar, @os.l char[] cArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(cArr, "csq");
        return e(eVar, new ul.a(cArr, 0, cArr.length), i10, i11);
    }

    public static final Void g(int i10) throws j {
        throw new j(k.b.a("Not enough free space available to write ", i10, " character(s)."));
    }

    public static final void h(@os.l e eVar, int i10, byte b10) {
        kn.l0.p(eVar, "<this>");
        if (!(i10 >= 0)) {
            new a(i10).a();
            throw new lm.y();
        }
        m mVar = eVar.f15821b;
        int i11 = mVar.f15872a;
        int i12 = mVar.f15874c;
        if (!(i10 <= i11 - i12)) {
            new b(i10, eVar).a();
            throw new lm.y();
        }
        ql.i.f(eVar.f15820a, i12, i10, b10);
        eVar.b(i10);
    }

    @lm.k(message = "Use fill with n with type Int")
    public static final void i(@os.l e eVar, long j10, byte b10) {
        kn.l0.p(eVar, "<this>");
        if (j10 >= 2147483647L) {
            throw ql.d.a(j10, p6.n.f13005a);
        }
        h(eVar, (int) j10, b10);
    }

    public static final void j(@os.l e eVar, int i10, byte b10) {
        kn.l0.p(eVar, "$this$fill");
        h(eVar, i10, b10);
    }

    @lm.k(message = "Does nothing.")
    public static final void k(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
    }

    @os.l
    public static final q l(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        return q.BIG_ENDIAN;
    }

    @lm.k(level = lm.m.ERROR, message = "This is no longer supported. All operations are big endian by default. Use readXXXLittleEndian to read primitives in little endian")
    public static /* synthetic */ void m(e eVar) {
    }

    @lm.k(message = "Use duplicate instead", replaceWith = @lm.a1(expression = "duplicate()", imports = {}))
    @os.l
    public static final e n(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        return eVar.o();
    }

    @lm.k(message = "Use duplicate instead", replaceWith = @lm.a1(expression = "duplicate()", imports = {}))
    @os.l
    public static final ul.b o(@os.l ul.b bVar) {
        kn.l0.p(bVar, "<this>");
        return bVar.o();
    }

    @lm.k(message = "Use rewind instead", replaceWith = @lm.a1(expression = "rewind(n)", imports = {}))
    public static final void p(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        eVar.y0(i10);
    }

    public static final void q(@os.l e eVar, @os.l Byte[] bArr, int i10, int i11) throws EOFException {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(bArr, "dst");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i12 = mVar.f15873b;
        if (mVar.f15874c - i12 < i11) {
            throw new EOFException(k.b.a("Not enough bytes available to read ", i11, " bytes"));
        }
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13 + i10] = Byte.valueOf(byteBuffer.get(i13 + i12));
        }
        eVar.h(i11);
    }

    public static /* synthetic */ void r(e eVar, Byte[] bArr, int i10, int i11, int i12, Object obj) throws EOFException {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        q(eVar, bArr, i10, i11);
    }

    @lm.k(message = "This is no longer supported. Read from a packet instead.")
    public static final int s(@os.l e eVar, @os.l CharsetDecoder charsetDecoder, @os.l Appendable appendable, boolean z10, int i10) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(charsetDecoder, "decoder");
        kn.l0.p(appendable, "out");
        return rl.a.c(charsetDecoder, eVar, appendable, z10, i10);
    }

    public static /* synthetic */ int t(e eVar, CharsetDecoder charsetDecoder, Appendable appendable, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return s(eVar, charsetDecoder, appendable, z10, i10);
    }

    public static final void u(@os.l o0 o0Var, @os.l bm.h<o0> hVar) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(hVar, "pool");
        o0Var.j2(hVar);
    }

    public static final void v(@os.l e eVar, @os.l q qVar) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(qVar, "newOrder");
        if (qVar != q.BIG_ENDIAN) {
            throw new UnsupportedOperationException("Only BIG_ENDIAN is supported");
        }
    }

    @lm.k(message = "Use tryPeekByte instead", replaceWith = @lm.a1(expression = "tryPeekByte()", imports = {}))
    public static final int w(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        return eVar.T0();
    }
}
