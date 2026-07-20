package l1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@q
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f9502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f9503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f9504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f9505e;

    public class a extends l1.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l1.j f9506a;

        public a(final l1.j val$encodedSink) {
            this.f9506a = val$encodedSink;
        }

        @Override // l1.f
        public OutputStream c() throws IOException {
            return b.this.p(this.f9506a.b());
        }
    }

    /* JADX INFO: renamed from: l1.b$b, reason: collision with other inner class name */
    public class C0251b extends l1.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l1.k f9508a;

        public C0251b(final l1.k val$encodedSource) {
            this.f9508a = val$encodedSource;
        }

        @Override // l1.g
        public InputStream m() throws IOException {
            return b.this.k(this.f9508a.m());
        }
    }

    public class e extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Appendable f9516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Writer f9517b;

        public e(final Appendable val$separatingAppendable, final Writer val$delegate) {
            this.f9516a = val$separatingAppendable;
            this.f9517b = val$delegate;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f9517b.close();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            this.f9517b.flush();
        }

        @Override // java.io.Writer
        public void write(int c10) throws IOException {
            this.f9516a.append((char) c10);
        }

        @Override // java.io.Writer
        public void write(char[] chars, int off, int len) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f9519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f9522e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f9523f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f9524g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean[] f9525h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f9526i;

        public f(String name, char[] chars) {
            this(name, chars, c(chars), false);
        }

        public static byte[] c(char[] chars) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i10 = 0; i10 < chars.length; i10++) {
                char c10 = chars[i10];
                boolean z10 = true;
                c1.h0.f(c10 < 128, "Non-ASCII character: %s", c10);
                if (bArr[c10] != -1) {
                    z10 = false;
                }
                c1.h0.f(z10, "Duplicate character: %s", c10);
                bArr[c10] = (byte) i10;
            }
            return bArr;
        }

        public boolean b(char ch2) {
            return ch2 <= 127 && this.f9524g[ch2] != -1;
        }

        public int d(char ch2) throws i {
            if (ch2 > 127) {
                throw new i("Unrecognized character: 0x" + Integer.toHexString(ch2));
            }
            byte b10 = this.f9524g[ch2];
            if (b10 != -1) {
                return b10;
            }
            if (ch2 <= ' ' || ch2 == 127) {
                throw new i("Unrecognized character: 0x" + Integer.toHexString(ch2));
            }
            throw new i("Unrecognized character: " + ch2);
        }

        public char e(int bits) {
            return this.f9519b[bits];
        }

        public boolean equals(@gm.a Object other) {
            if (!(other instanceof f)) {
                return false;
            }
            f fVar = (f) other;
            return this.f9526i == fVar.f9526i && Arrays.equals(this.f9519b, fVar.f9519b);
        }

        public final boolean f() {
            for (char c10 : this.f9519b) {
                if (c1.c.c(c10)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean g() {
            for (char c10 : this.f9519b) {
                if (c1.c.d(c10)) {
                    return true;
                }
            }
            return false;
        }

        public f h() {
            if (this.f9526i) {
                return this;
            }
            byte[] bArr = this.f9524g;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            int i10 = 65;
            while (true) {
                if (i10 > 90) {
                    return new f(j.c.a(new StringBuilder(), this.f9518a, ".ignoreCase()"), this.f9519b, bArrCopyOf, true);
                }
                int i11 = i10 | 32;
                byte[] bArr2 = this.f9524g;
                byte b10 = bArr2[i10];
                byte b11 = bArr2[i11];
                if (b10 == -1) {
                    bArrCopyOf[i10] = b11;
                } else {
                    c1.h0.j0(b11 == -1, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i10, (char) i11);
                    bArrCopyOf[i11] = b10;
                }
                i10++;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(this.f9519b) + (this.f9526i ? 1231 : 1237);
        }

        public boolean i(int index) {
            return this.f9525h[index % this.f9522e];
        }

        public f j() {
            if (!g()) {
                return this;
            }
            c1.h0.h0(!f(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f9519b.length];
            int i10 = 0;
            while (true) {
                char[] cArr2 = this.f9519b;
                if (i10 >= cArr2.length) {
                    break;
                }
                cArr[i10] = c1.c.e(cArr2[i10]);
                i10++;
            }
            f fVar = new f(j.c.a(new StringBuilder(), this.f9518a, ".lowerCase()"), cArr);
            return this.f9526i ? fVar.h() : fVar;
        }

        public boolean k(char c10) {
            byte[] bArr = this.f9524g;
            return c10 < bArr.length && bArr[c10] != -1;
        }

        public f l() {
            if (!f()) {
                return this;
            }
            c1.h0.h0(!g(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f9519b.length];
            int i10 = 0;
            while (true) {
                char[] cArr2 = this.f9519b;
                if (i10 >= cArr2.length) {
                    break;
                }
                cArr[i10] = c1.c.h(cArr2[i10]);
                i10++;
            }
            f fVar = new f(j.c.a(new StringBuilder(), this.f9518a, ".upperCase()"), cArr);
            return this.f9526i ? fVar.h() : fVar;
        }

        public String toString() {
            return this.f9518a;
        }

        public f(String name, char[] chars, byte[] decodabet, boolean ignoreCase) {
            name.getClass();
            this.f9518a = name;
            chars.getClass();
            this.f9519b = chars;
            try {
                int iP = m1.f.p(chars.length, RoundingMode.UNNECESSARY);
                this.f9521d = iP;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iP);
                int i10 = 1 << (3 - iNumberOfTrailingZeros);
                this.f9522e = i10;
                this.f9523f = iP >> iNumberOfTrailingZeros;
                this.f9520c = chars.length - 1;
                this.f9524g = decodabet;
                boolean[] zArr = new boolean[i10];
                for (int i11 = 0; i11 < this.f9523f; i11++) {
                    zArr[m1.f.g(i11 * 8, this.f9521d, RoundingMode.CEILING)] = true;
                }
                this.f9525h = zArr;
                this.f9526i = ignoreCase;
            } catch (ArithmeticException e10) {
                throw new IllegalArgumentException("Illegal alphabet length " + chars.length, e10);
            }
        }
    }

    public static final class g extends k {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final char[] f9527k;

        public g(String name, String alphabetChars) {
            this(new f(name, alphabetChars.toCharArray()));
        }

        @Override // l1.b.k
        public b E(f alphabet, @gm.a Character paddingChar) {
            return new g(alphabet);
        }

        @Override // l1.b.k, l1.b
        public int i(byte[] target, CharSequence chars) throws i {
            target.getClass();
            if (chars.length() % 2 == 1) {
                throw new i("Invalid input length " + chars.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < chars.length()) {
                target[i11] = (byte) ((this.f9531f.d(chars.charAt(i10)) << 4) | this.f9531f.d(chars.charAt(i10 + 1)));
                i10 += 2;
                i11++;
            }
            return i11;
        }

        @Override // l1.b.k, l1.b
        public void n(Appendable target, byte[] bytes, int off, int len) throws IOException {
            target.getClass();
            c1.h0.f0(off, off + len, bytes.length);
            for (int i10 = 0; i10 < len; i10++) {
                int i11 = bytes[off + i10] & 255;
                target.append(this.f9527k[i11]);
                target.append(this.f9527k[i11 | 256]);
            }
        }

        public g(f alphabet) {
            super(alphabet, null);
            this.f9527k = new char[512];
            c1.h0.d(alphabet.f9519b.length == 16);
            for (int i10 = 0; i10 < 256; i10++) {
                char[] cArr = this.f9527k;
                char[] cArr2 = alphabet.f9519b;
                cArr[i10] = cArr2[i10 >>> 4];
                cArr[i10 | 256] = cArr2[i10 & 15];
            }
        }
    }

    public static final class h extends k {
        public h(String name, String alphabetChars, @gm.a Character paddingChar) {
            this(new f(name, alphabetChars.toCharArray()), paddingChar);
        }

        @Override // l1.b.k
        public b E(f alphabet, @gm.a Character paddingChar) {
            return new h(alphabet, paddingChar);
        }

        @Override // l1.b.k, l1.b
        public int i(byte[] target, CharSequence chars) throws i {
            target.getClass();
            CharSequence charSequenceZ = z(chars);
            if (!this.f9531f.i(charSequenceZ.length())) {
                throw new i("Invalid input length " + charSequenceZ.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequenceZ.length()) {
                int i12 = i10 + 2;
                int iD = (this.f9531f.d(charSequenceZ.charAt(i10)) << 18) | (this.f9531f.d(charSequenceZ.charAt(i10 + 1)) << 12);
                int i13 = i11 + 1;
                target[i11] = (byte) (iD >>> 16);
                if (i12 < charSequenceZ.length()) {
                    int i14 = i10 + 3;
                    int iD2 = iD | (this.f9531f.d(charSequenceZ.charAt(i12)) << 6);
                    int i15 = i11 + 2;
                    target[i13] = (byte) ((iD2 >>> 8) & 255);
                    if (i14 < charSequenceZ.length()) {
                        i10 += 4;
                        i11 += 3;
                        target[i15] = (byte) ((iD2 | this.f9531f.d(charSequenceZ.charAt(i14))) & 255);
                    } else {
                        i11 = i15;
                        i10 = i14;
                    }
                } else {
                    i11 = i13;
                    i10 = i12;
                }
            }
            return i11;
        }

        @Override // l1.b.k, l1.b
        public void n(Appendable target, byte[] bytes, int off, int len) throws IOException {
            target.getClass();
            int i10 = off + len;
            c1.h0.f0(off, i10, bytes.length);
            while (len >= 3) {
                int i11 = off + 2;
                int i12 = ((bytes[off + 1] & 255) << 8) | ((bytes[off] & 255) << 16);
                off += 3;
                int i13 = i12 | (bytes[i11] & 255);
                target.append(this.f9531f.f9519b[i13 >>> 18]);
                target.append(this.f9531f.f9519b[(i13 >>> 12) & 63]);
                target.append(this.f9531f.f9519b[(i13 >>> 6) & 63]);
                target.append(this.f9531f.f9519b[i13 & 63]);
                len -= 3;
            }
            if (off < i10) {
                D(target, bytes, off, i10 - off);
            }
        }

        public h(f alphabet, @gm.a Character paddingChar) {
            super(alphabet, paddingChar);
            c1.h0.d(alphabet.f9519b.length == 64);
        }
    }

    public static final class i extends IOException {
        public i(String message) {
            super(message);
        }

        public i(Throwable cause) {
            super(cause);
        }
    }

    public static final class j extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f9528f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f9529g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f9530h;

        public j(b delegate, String separator, int afterEveryChars) {
            delegate.getClass();
            this.f9528f = delegate;
            separator.getClass();
            this.f9529g = separator;
            this.f9530h = afterEveryChars;
            c1.h0.k(afterEveryChars > 0, "Cannot add a separator after every %s chars", afterEveryChars);
        }

        @Override // l1.b
        public b A() {
            return this.f9528f.A().C(this.f9529g, this.f9530h);
        }

        @Override // l1.b
        public b B(char padChar) {
            return this.f9528f.B(padChar).C(this.f9529g, this.f9530h);
        }

        @Override // l1.b
        public b C(String separator, int afterEveryChars) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        @Override // l1.b
        public boolean f(CharSequence chars) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < chars.length(); i10++) {
                char cCharAt = chars.charAt(i10);
                if (this.f9529g.indexOf(cCharAt) < 0) {
                    sb2.append(cCharAt);
                }
            }
            return this.f9528f.f(sb2);
        }

        @Override // l1.b
        public int i(byte[] target, CharSequence chars) throws i {
            StringBuilder sb2 = new StringBuilder(chars.length());
            for (int i10 = 0; i10 < chars.length(); i10++) {
                char cCharAt = chars.charAt(i10);
                if (this.f9529g.indexOf(cCharAt) < 0) {
                    sb2.append(cCharAt);
                }
            }
            return this.f9528f.i(target, sb2);
        }

        @Override // l1.b
        @b1.c
        @b1.d
        public InputStream k(Reader reader) {
            return this.f9528f.k(b.s(reader, this.f9529g));
        }

        @Override // l1.b
        public void n(Appendable target, byte[] bytes, int off, int len) throws IOException {
            this.f9528f.n(b.x(target, this.f9529g, this.f9530h), bytes, off, len);
        }

        @Override // l1.b
        @b1.c
        @b1.d
        public OutputStream p(Writer output) {
            return this.f9528f.p(b.y(output, this.f9529g, this.f9530h));
        }

        @Override // l1.b
        public b r() {
            return this.f9528f.r().C(this.f9529g, this.f9530h);
        }

        @Override // l1.b
        public b t() {
            return this.f9528f.t().C(this.f9529g, this.f9530h);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f9528f);
            sb2.append(".withSeparator(\"");
            sb2.append(this.f9529g);
            sb2.append("\", ");
            return c.a.a(sb2, this.f9530h, ")");
        }

        @Override // l1.b
        public int u(int chars) {
            return this.f9528f.u(chars);
        }

        @Override // l1.b
        public int v(int bytes) {
            int iV = this.f9528f.v(bytes);
            return (m1.f.g(Math.max(0, iV - 1), this.f9530h, RoundingMode.FLOOR) * this.f9529g.length()) + iV;
        }

        @Override // l1.b
        public b w() {
            return this.f9528f.w().C(this.f9529g, this.f9530h);
        }

        @Override // l1.b
        public CharSequence z(CharSequence chars) {
            return this.f9528f.z(chars);
        }
    }

    static {
        Character chValueOf = Character.valueOf(fl.h.f6043c);
        f9501a = new h("base64()", fl.h.f6041a, chValueOf);
        f9502b = new h("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", chValueOf);
        f9503c = new k("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", chValueOf);
        f9504d = new k("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", chValueOf);
        f9505e = new g("base16()", jq.j.f8822b);
    }

    public static b a() {
        return f9505e;
    }

    public static b b() {
        return f9503c;
    }

    public static b c() {
        return f9504d;
    }

    public static b d() {
        return f9501a;
    }

    public static b e() {
        return f9502b;
    }

    public static byte[] q(byte[] result, int length) {
        if (length == result.length) {
            return result;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(result, 0, bArr, 0, length);
        return bArr;
    }

    @b1.c
    @b1.d
    public static Reader s(Reader delegate, String toIgnore) {
        delegate.getClass();
        toIgnore.getClass();
        return new c(delegate, toIgnore);
    }

    public static Appendable x(Appendable delegate, String separator, int afterEveryChars) {
        delegate.getClass();
        separator.getClass();
        c1.h0.d(afterEveryChars > 0);
        return new d(afterEveryChars, delegate, separator);
    }

    @b1.c
    @b1.d
    public static Writer y(Writer delegate, String separator, int afterEveryChars) {
        return new e(x(delegate, separator, afterEveryChars), delegate);
    }

    public abstract b A();

    public abstract b B(char padChar);

    public abstract b C(String separator, int n10);

    public abstract boolean f(CharSequence chars);

    public final byte[] g(CharSequence chars) {
        try {
            return h(chars);
        } catch (i e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public final byte[] h(CharSequence chars) throws i {
        CharSequence charSequenceZ = z(chars);
        byte[] bArr = new byte[u(charSequenceZ.length())];
        return q(bArr, i(bArr, charSequenceZ));
    }

    public abstract int i(byte[] target, CharSequence chars) throws i;

    @b1.c
    @b1.d
    public final l1.g j(l1.k encodedSource) {
        encodedSource.getClass();
        return new C0251b(encodedSource);
    }

    @b1.c
    @b1.d
    public abstract InputStream k(Reader reader);

    public String l(byte[] bytes) {
        return m(bytes, 0, bytes.length);
    }

    public final String m(byte[] bytes, int off, int len) {
        c1.h0.f0(off, off + len, bytes.length);
        StringBuilder sb2 = new StringBuilder(v(len));
        try {
            n(sb2, bytes, off, len);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public abstract void n(Appendable target, byte[] bytes, int off, int len) throws IOException;

    @b1.c
    @b1.d
    public final l1.f o(l1.j encodedSink) {
        encodedSink.getClass();
        return new a(encodedSink);
    }

    @b1.c
    @b1.d
    public abstract OutputStream p(Writer writer);

    public abstract b r();

    public abstract b t();

    public abstract int u(int chars);

    public abstract int v(int bytes);

    public abstract b w();

    public CharSequence z(CharSequence chars) {
        chars.getClass();
        return chars;
    }

    public class c extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Reader f9510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9511b;

        public c(final Reader val$delegate, final String val$toIgnore) {
            this.f9510a = val$delegate;
            this.f9511b = val$toIgnore;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f9510a.close();
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            int i10;
            do {
                i10 = this.f9510a.read();
                if (i10 == -1) {
                    break;
                }
            } while (this.f9511b.indexOf((char) i10) >= 0);
            return i10;
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int off, int len) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public class d implements Appendable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f9513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Appendable f9514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f9515d;

        public d(final int val$afterEveryChars, final Appendable val$delegate, final String val$separator) {
            this.f9513b = val$afterEveryChars;
            this.f9514c = val$delegate;
            this.f9515d = val$separator;
            this.f9512a = val$afterEveryChars;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c10) throws IOException {
            if (this.f9512a == 0) {
                this.f9514c.append(this.f9515d);
                this.f9512a = this.f9513b;
            }
            this.f9514c.append(c10);
            this.f9512a--;
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@gm.a CharSequence chars, int off, int len) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Appendable
        public Appendable append(@gm.a CharSequence chars) {
            throw new UnsupportedOperationException();
        }
    }

    public static class k extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final f f9531f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @gm.a
        public final Character f9532g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @u1.b
        @gm.a
        public volatile b f9533h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @u1.b
        @gm.a
        public volatile b f9534i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @u1.b
        @gm.a
        public volatile b f9535j;

        public class a extends OutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9536a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f9537b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f9538c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Writer f9539d;

            public a(final Writer val$out) {
                this.f9539d = val$out;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                int i10 = this.f9537b;
                if (i10 > 0) {
                    int i11 = this.f9536a;
                    f fVar = k.this.f9531f;
                    this.f9539d.write(fVar.f9519b[(i11 << (fVar.f9521d - i10)) & fVar.f9520c]);
                    this.f9538c++;
                    if (k.this.f9532g != null) {
                        while (true) {
                            int i12 = this.f9538c;
                            k kVar = k.this;
                            if (i12 % kVar.f9531f.f9522e == 0) {
                                break;
                            }
                            this.f9539d.write(kVar.f9532g.charValue());
                            this.f9538c++;
                        }
                    }
                }
                this.f9539d.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.f9539d.flush();
            }

            @Override // java.io.OutputStream
            public void write(int b10) throws IOException {
                this.f9536a = (b10 & 255) | (this.f9536a << 8);
                this.f9537b += 8;
                while (true) {
                    int i10 = this.f9537b;
                    f fVar = k.this.f9531f;
                    int i11 = fVar.f9521d;
                    if (i10 < i11) {
                        return;
                    }
                    this.f9539d.write(fVar.f9519b[(this.f9536a >> (i10 - i11)) & fVar.f9520c]);
                    this.f9538c++;
                    this.f9537b -= k.this.f9531f.f9521d;
                }
            }
        }

        public k(f alphabet, @gm.a Character paddingChar) {
            alphabet.getClass();
            this.f9531f = alphabet;
            c1.h0.u(paddingChar == null || !alphabet.k(paddingChar.charValue()), "Padding character %s was already in alphabet", paddingChar);
            this.f9532g = paddingChar;
        }

        @Override // l1.b
        public b A() {
            b bVarE = this.f9533h;
            if (bVarE == null) {
                f fVarL = this.f9531f.l();
                bVarE = fVarL == this.f9531f ? this : E(fVarL, this.f9532g);
                this.f9533h = bVarE;
            }
            return bVarE;
        }

        @Override // l1.b
        public b B(char padChar) {
            if (8 % this.f9531f.f9521d == 0) {
                return this;
            }
            Character ch2 = this.f9532g;
            return (ch2 == null || ch2.charValue() != padChar) ? E(this.f9531f, Character.valueOf(padChar)) : this;
        }

        @Override // l1.b
        public b C(String separator, int afterEveryChars) {
            for (int i10 = 0; i10 < separator.length(); i10++) {
                c1.h0.u(!this.f9531f.k(separator.charAt(i10)), "Separator (%s) cannot contain alphabet characters", separator);
            }
            Character ch2 = this.f9532g;
            if (ch2 != null) {
                c1.h0.u(separator.indexOf(ch2.charValue()) < 0, "Separator (%s) cannot contain padding character", separator);
            }
            return new j(this, separator, afterEveryChars);
        }

        public void D(Appendable target, byte[] bytes, int off, int len) throws IOException {
            target.getClass();
            c1.h0.f0(off, off + len, bytes.length);
            int i10 = 0;
            c1.h0.d(len <= this.f9531f.f9523f);
            long j10 = 0;
            for (int i11 = 0; i11 < len; i11++) {
                j10 = (j10 | ((long) (bytes[off + i11] & 255))) << 8;
            }
            int i12 = ((len + 1) * 8) - this.f9531f.f9521d;
            while (i10 < len * 8) {
                f fVar = this.f9531f;
                target.append(fVar.f9519b[((int) (j10 >>> (i12 - i10))) & fVar.f9520c]);
                i10 += this.f9531f.f9521d;
            }
            if (this.f9532g != null) {
                while (i10 < this.f9531f.f9523f * 8) {
                    target.append(this.f9532g.charValue());
                    i10 += this.f9531f.f9521d;
                }
            }
        }

        public b E(f alphabet, @gm.a Character paddingChar) {
            return new k(alphabet, paddingChar);
        }

        public boolean equals(@gm.a Object other) {
            if (!(other instanceof k)) {
                return false;
            }
            k kVar = (k) other;
            return this.f9531f.equals(kVar.f9531f) && Objects.equals(this.f9532g, kVar.f9532g);
        }

        @Override // l1.b
        public boolean f(CharSequence chars) {
            chars.getClass();
            CharSequence charSequenceZ = z(chars);
            if (!this.f9531f.i(charSequenceZ.length())) {
                return false;
            }
            for (int i10 = 0; i10 < charSequenceZ.length(); i10++) {
                if (!this.f9531f.b(charSequenceZ.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.f9532g) ^ this.f9531f.hashCode();
        }

        @Override // l1.b
        public int i(byte[] target, CharSequence chars) throws i {
            f fVar;
            target.getClass();
            CharSequence charSequenceZ = z(chars);
            if (!this.f9531f.i(charSequenceZ.length())) {
                throw new i("Invalid input length " + charSequenceZ.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequenceZ.length()) {
                long jD = 0;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    fVar = this.f9531f;
                    if (i12 >= fVar.f9522e) {
                        break;
                    }
                    jD <<= fVar.f9521d;
                    if (i10 + i12 < charSequenceZ.length()) {
                        jD |= (long) this.f9531f.d(charSequenceZ.charAt(i13 + i10));
                        i13++;
                    }
                    i12++;
                }
                int i14 = fVar.f9523f;
                int i15 = (i14 * 8) - (i13 * fVar.f9521d);
                int i16 = (i14 - 1) * 8;
                while (i16 >= i15) {
                    target[i11] = (byte) ((jD >>> i16) & 255);
                    i16 -= 8;
                    i11++;
                }
                i10 += this.f9531f.f9522e;
            }
            return i11;
        }

        @Override // l1.b
        @b1.c
        @b1.d
        public InputStream k(Reader reader) {
            reader.getClass();
            return new C0252b(reader);
        }

        @Override // l1.b
        public void n(Appendable target, byte[] bytes, int off, int len) throws IOException {
            target.getClass();
            c1.h0.f0(off, off + len, bytes.length);
            int i10 = 0;
            while (i10 < len) {
                D(target, bytes, off + i10, Math.min(this.f9531f.f9523f, len - i10));
                i10 += this.f9531f.f9523f;
            }
        }

        @Override // l1.b
        @b1.c
        @b1.d
        public OutputStream p(Writer out) {
            out.getClass();
            return new a(out);
        }

        @Override // l1.b
        public b r() {
            b bVarE = this.f9535j;
            if (bVarE == null) {
                f fVarH = this.f9531f.h();
                bVarE = fVarH == this.f9531f ? this : E(fVarH, this.f9532g);
                this.f9535j = bVarE;
            }
            return bVarE;
        }

        @Override // l1.b
        public b t() {
            b bVarE = this.f9534i;
            if (bVarE == null) {
                f fVarJ = this.f9531f.j();
                bVarE = fVarJ == this.f9531f ? this : E(fVarJ, this.f9532g);
                this.f9534i = bVarE;
            }
            return bVarE;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("BaseEncoding.");
            sb2.append(this.f9531f);
            if (8 % this.f9531f.f9521d != 0) {
                if (this.f9532g == null) {
                    sb2.append(".omitPadding()");
                } else {
                    sb2.append(".withPadChar('");
                    sb2.append(this.f9532g);
                    sb2.append("')");
                }
            }
            return sb2.toString();
        }

        @Override // l1.b
        public int u(int chars) {
            return (int) (((((long) this.f9531f.f9521d) * ((long) chars)) + 7) / 8);
        }

        @Override // l1.b
        public int v(int bytes) {
            f fVar = this.f9531f;
            return m1.f.g(bytes, fVar.f9523f, RoundingMode.CEILING) * fVar.f9522e;
        }

        @Override // l1.b
        public b w() {
            return this.f9532g == null ? this : E(this.f9531f, null);
        }

        @Override // l1.b
        public CharSequence z(CharSequence chars) {
            chars.getClass();
            Character ch2 = this.f9532g;
            if (ch2 == null) {
                return chars;
            }
            char cCharValue = ch2.charValue();
            int length = chars.length() - 1;
            while (length >= 0 && chars.charAt(length) == cCharValue) {
                length--;
            }
            return chars.subSequence(0, length + 1);
        }

        public k(String name, String alphabetChars, @gm.a Character paddingChar) {
            this(new f(name, alphabetChars.toCharArray()), paddingChar);
        }

        /* JADX INFO: renamed from: l1.b$k$b, reason: collision with other inner class name */
        public class C0252b extends InputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9541a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f9542b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f9543c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f9544d = false;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Reader f9545e;

            public C0252b(final Reader val$reader) {
                this.f9545e = val$reader;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f9545e.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                int i10;
                while (true) {
                    int i11 = this.f9545e.read();
                    if (i11 == -1) {
                        if (this.f9544d || k.this.f9531f.i(this.f9543c)) {
                            return -1;
                        }
                        throw new i("Invalid input length " + this.f9543c);
                    }
                    this.f9543c++;
                    char c10 = (char) i11;
                    Character ch2 = k.this.f9532g;
                    if (ch2 == null || ch2.charValue() != c10) {
                        if (this.f9544d) {
                            throw new i("Expected padding character but found '" + c10 + "' at index " + this.f9543c);
                        }
                        int i12 = this.f9541a;
                        f fVar = k.this.f9531f;
                        int i13 = i12 << fVar.f9521d;
                        this.f9541a = i13;
                        int iD = fVar.d(c10) | i13;
                        this.f9541a = iD;
                        int i14 = this.f9542b + k.this.f9531f.f9521d;
                        this.f9542b = i14;
                        if (i14 >= 8) {
                            int i15 = i14 - 8;
                            this.f9542b = i15;
                            return (iD >> i15) & 255;
                        }
                    } else {
                        if (!this.f9544d && ((i10 = this.f9543c) == 1 || !k.this.f9531f.i(i10 - 1))) {
                            throw new i("Padding cannot start at index " + this.f9543c);
                        }
                        this.f9544d = true;
                    }
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] buf, int off, int len) throws IOException {
                int i10 = len + off;
                c1.h0.f0(off, i10, buf.length);
                int i11 = off;
                while (i11 < i10) {
                    int i12 = read();
                    if (i12 == -1) {
                        int i13 = i11 - off;
                        if (i13 == 0) {
                            return -1;
                        }
                        return i13;
                    }
                    buf[i11] = (byte) i12;
                    i11++;
                }
                return i11 - off;
            }
        }
    }
}
