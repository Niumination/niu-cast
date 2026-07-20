package yj;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vj.v1;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    public static final class a extends DefaultHttp2HeadersDecoder {
        public a(long j10) {
            super(true, j10);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b newHeaders() {
            return new d(numberOfHeadersGuess());
        }
    }

    public static abstract class b extends yj.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AsciiString f21128d = new AsciiString(v1.f17425d.getBytes(c1.f.f1177a));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[][] f21129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AsciiString[] f21130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21131c;

        public b(int i10) {
            c1.h0.k(i10 > 0, "numHeadersGuess needs to be positive: %s", i10);
            this.f21129a = new byte[i10 * 2][];
            this.f21130b = new AsciiString[i10];
        }

        public static void Q0(StringBuilder sb2, CharSequence charSequence, CharSequence charSequence2, boolean z10) {
            if (z10) {
                sb2.append(", ");
            }
            sb2.append(charSequence);
            sb2.append(": ");
            sb2.append(charSequence2);
        }

        public static byte[] R0(AsciiString asciiString) {
            return asciiString.isEntireArrayUsed() ? asciiString.array() : asciiString.toByteArray();
        }

        public static boolean S0(AsciiString asciiString, AsciiString asciiString2) {
            return U0(asciiString.array(), asciiString.arrayOffset(), asciiString.length(), asciiString2.array(), asciiString2.arrayOffset(), asciiString2.length());
        }

        public static boolean T0(AsciiString asciiString, byte[] bArr) {
            return U0(asciiString.array(), asciiString.arrayOffset(), asciiString.length(), bArr, 0, bArr.length);
        }

        public static boolean U0(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
            if (i11 != i13) {
                return false;
            }
            return PlatformDependent.equals(bArr, i10, bArr2, i12, i11);
        }

        public static boolean X0(AsciiString asciiString) {
            return !asciiString.isEmpty() && asciiString.charAt(0) == ':';
        }

        public static AsciiString c1(CharSequence charSequence) {
            if (charSequence instanceof AsciiString) {
                return (AsciiString) charSequence;
            }
            throw new IllegalArgumentException("AsciiString expected. Was: ".concat(charSequence.getClass().getName()));
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: I */
        public List<CharSequence> getAll(CharSequence charSequence) {
            AsciiString asciiStringC1 = c1(charSequence);
            ArrayList arrayList = new ArrayList(4);
            for (int i10 = 0; i10 < this.f21131c; i10 += 2) {
                if (T0(asciiStringC1, this.f21129a[i10])) {
                    arrayList.add(this.f21130b[i10 / 2]);
                }
            }
            return arrayList;
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: I0 */
        public Http2Headers setLong(CharSequence charSequence, long j10) {
            return set(charSequence, AsciiString.of(CharSequenceValueConverter.INSTANCE.convertLong(j10)));
        }

        public Http2Headers O0(AsciiString asciiString, AsciiString asciiString2) {
            byte[] bArrR0 = R0(asciiString);
            if (!asciiString.endsWith(f21128d)) {
                P0(asciiString2, bArrR0, R0(asciiString2));
                return this;
            }
            int i10 = -1;
            int i11 = 0;
            while (i10 < asciiString2.length()) {
                int iIndexOf = asciiString2.indexOf(StringUtil.COMMA, i11);
                int length = iIndexOf == -1 ? asciiString2.length() : iIndexOf;
                AsciiString asciiStringSubSequence = asciiString2.subSequence(i11, length, false);
                P0(asciiStringSubSequence, bArrR0, l1.b.d().g(asciiStringSubSequence));
                i11 = iIndexOf + 1;
                i10 = length;
            }
            return this;
        }

        public final void P0(AsciiString asciiString, byte[] bArr, byte[] bArr2) {
            if (this.f21131c == this.f21129a.length) {
                V0();
            }
            AsciiString[] asciiStringArr = this.f21130b;
            int i10 = this.f21131c;
            asciiStringArr[i10 / 2] = asciiString;
            byte[][] bArr3 = this.f21129a;
            bArr3[i10] = bArr;
            int i11 = i10 + 1;
            this.f21131c = i11;
            bArr3[i11] = bArr2;
            this.f21131c = i10 + 2;
        }

        public final void V0() {
            AsciiString[] asciiStringArr = this.f21130b;
            int iMax = Math.max(2, (asciiStringArr.length / 2) + asciiStringArr.length);
            byte[][] bArr = new byte[iMax * 2][];
            AsciiString[] asciiStringArr2 = new AsciiString[iMax];
            byte[][] bArr2 = this.f21129a;
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            AsciiString[] asciiStringArr3 = this.f21130b;
            System.arraycopy(asciiStringArr3, 0, asciiStringArr2, 0, asciiStringArr3.length);
            this.f21129a = bArr;
            this.f21130b = asciiStringArr2;
        }

        public CharSequence W0(AsciiString asciiString) {
            for (int i10 = 0; i10 < this.f21131c; i10 += 2) {
                if (T0(asciiString, this.f21129a[i10])) {
                    return this.f21130b[i10 / 2];
                }
            }
            return null;
        }

        public byte[][] Y0() {
            return this.f21129a;
        }

        public final List<Map.Entry<CharSequence, CharSequence>> Z0() {
            ArrayList arrayList = new ArrayList(this.f21130b.length);
            for (int i10 = 0; i10 < this.f21131c; i10 += 2) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(new String(this.f21129a[i10], c1.f.f1177a), this.f21130b[i10 / 2]));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public final String a1() {
            StringBuilder sb2 = new StringBuilder();
            boolean z10 = false;
            for (Map.Entry<CharSequence, CharSequence> entry : Z0()) {
                Q0(sb2, entry.getKey(), entry.getValue(), z10);
                z10 = true;
            }
            return sb2.toString();
        }

        public int b1() {
            return this.f21131c / 2;
        }

        public AsciiString d1(AsciiString asciiString) throws Throwable {
            int iArrayOffset = asciiString.arrayOffset();
            int length = asciiString.length();
            byte[] bArrArray = asciiString.array();
            for (int i10 = iArrayOffset; i10 < iArrayOffset + length; i10++) {
                if (AsciiString.isUpperCase(bArrArray[i10])) {
                    PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "invalid header name '%s'", asciiString));
                }
            }
            return asciiString;
        }

        @Override // yj.a, io.netty.handler.codec.http2.Http2Headers, io.netty.handler.codec.Headers, java.lang.Iterable
        public Iterator<Map.Entry<CharSequence, CharSequence>> iterator() {
            return Z0().iterator();
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        public int size() {
            return b1();
        }

        @Override // yj.a, io.netty.handler.codec.http2.Http2Headers
        public CharSequence status() {
            return W0(Http2Headers.PseudoHeaderName.STATUS.value());
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: u */
        public boolean contains(CharSequence charSequence) {
            return get(charSequence) != null;
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        @t1.a
        /* JADX INFO: renamed from: w0 */
        public boolean remove(CharSequence charSequence) {
            AsciiString asciiStringC1 = c1(charSequence);
            int i10 = 0;
            while (i10 < this.f21131c && !T0(asciiStringC1, this.f21129a[i10])) {
                i10 += 2;
            }
            if (i10 >= this.f21131c) {
                return false;
            }
            int i11 = i10;
            while (i10 < this.f21131c) {
                if (!T0(asciiStringC1, this.f21129a[i10])) {
                    AsciiString[] asciiStringArr = this.f21130b;
                    asciiStringArr[i11 / 2] = asciiStringArr[i10 / 2];
                    byte[][] bArr = this.f21129a;
                    bArr[i11] = bArr[i10];
                    bArr[i11 + 1] = bArr[i10 + 1];
                    i11 += 2;
                }
                i10 += 2;
            }
            this.f21131c = i11;
            return true;
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: y0 */
        public Http2Headers set(CharSequence charSequence, CharSequence charSequence2) {
            remove(charSequence);
            return add(charSequence, charSequence2);
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final AsciiString f21132p = AsciiString.of(":path");

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final AsciiString f21133v = AsciiString.of(":authority");

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final AsciiString f21134w = AsciiString.of(":method");

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final AsciiString f21135x = AsciiString.of(":scheme");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AsciiString f21136e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AsciiString f21137f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AsciiString f21138g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public AsciiString f21139i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public AsciiString f21140n;

        public c(int i10) {
            super(i10);
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: G */
        public CharSequence get(CharSequence charSequence) {
            AsciiString asciiStringC1 = b.c1(charSequence);
            if (b.X0(asciiStringC1)) {
                return e1(asciiStringC1);
            }
            return b.S0(i1.f20996i, asciiStringC1) ? this.f21140n : W0(asciiStringC1);
        }

        @Override // yj.m.b, yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: I */
        public List<CharSequence> getAll(CharSequence charSequence) {
            AsciiString asciiStringC1 = b.c1(charSequence);
            if (!b.X0(asciiStringC1)) {
                return b.S0(i1.f20996i, asciiStringC1) ? Collections.singletonList(this.f21140n) : super.getAll(charSequence);
            }
            AsciiString asciiStringE1 = e1(asciiStringC1);
            return asciiStringE1 == null ? Collections.emptyList() : Collections.singletonList(asciiStringE1);
        }

        @Override // yj.a, io.netty.handler.codec.http2.Http2Headers
        public CharSequence authority() {
            return this.f21137f;
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: b */
        public Http2Headers add(CharSequence charSequence, CharSequence charSequence2) throws Throwable {
            AsciiString asciiStringD1 = d1(b.c1(charSequence));
            AsciiString asciiStringC1 = b.c1(charSequence2);
            if (b.X0(asciiStringD1)) {
                if (e1(asciiStringD1) != null) {
                    PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Duplicate %s header", asciiStringD1));
                }
                f1(asciiStringD1, asciiStringC1);
                return this;
            }
            if (!b.S0(i1.f20996i, asciiStringD1)) {
                return O0(asciiStringD1, asciiStringC1);
            }
            this.f21140n = asciiStringC1;
            return this;
        }

        public final AsciiString e1(AsciiString asciiString) {
            if (b.S0(f21132p, asciiString)) {
                return this.f21136e;
            }
            if (b.S0(f21133v, asciiString)) {
                return this.f21137f;
            }
            if (b.S0(f21134w, asciiString)) {
                return this.f21138g;
            }
            if (b.S0(f21135x, asciiString)) {
                return this.f21139i;
            }
            return null;
        }

        public final void f1(AsciiString asciiString, AsciiString asciiString2) throws Throwable {
            if (b.S0(f21132p, asciiString)) {
                this.f21136e = asciiString2;
                return;
            }
            if (b.S0(f21133v, asciiString)) {
                this.f21137f = asciiString2;
                return;
            }
            if (b.S0(f21134w, asciiString)) {
                this.f21138g = asciiString2;
            } else if (b.S0(f21135x, asciiString)) {
                this.f21139i = asciiString2;
            } else {
                PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Illegal pseudo-header '%s' in request.", asciiString));
                throw new AssertionError();
            }
        }

        @Override // yj.a, io.netty.handler.codec.http2.Http2Headers
        public CharSequence method() {
            return this.f21138g;
        }

        @Override // yj.a, io.netty.handler.codec.http2.Http2Headers
        public CharSequence path() {
            return this.f21136e;
        }

        @Override // yj.a, io.netty.handler.codec.http2.Http2Headers
        public CharSequence scheme() {
            return this.f21139i;
        }

        @Override // yj.m.b, yj.a, io.netty.handler.codec.Headers
        public int size() {
            int i10 = this.f21136e != null ? 1 : 0;
            if (this.f21137f != null) {
                i10++;
            }
            if (this.f21138g != null) {
                i10++;
            }
            if (this.f21139i != null) {
                i10++;
            }
            if (this.f21140n != null) {
                i10++;
            }
            return b1() + i10;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(c.class.getSimpleName());
            sb2.append(ks.a.f9445d);
            AsciiString asciiString = this.f21136e;
            boolean z10 = true;
            boolean z11 = false;
            if (asciiString != null) {
                b.Q0(sb2, f21132p, asciiString, false);
                z11 = true;
            }
            AsciiString asciiString2 = this.f21137f;
            if (asciiString2 != null) {
                b.Q0(sb2, f21133v, asciiString2, z11);
                z11 = true;
            }
            AsciiString asciiString3 = this.f21138g;
            if (asciiString3 != null) {
                b.Q0(sb2, f21134w, asciiString3, z11);
                z11 = true;
            }
            AsciiString asciiString4 = this.f21139i;
            if (asciiString4 != null) {
                b.Q0(sb2, f21135x, asciiString4, z11);
            } else {
                z10 = z11;
            }
            AsciiString asciiString5 = this.f21140n;
            if (asciiString5 != null) {
                b.Q0(sb2, i1.f20996i, asciiString5, z10);
            }
            String strA1 = a1();
            if (sb2.length() > 0 && strA1.length() > 0) {
                sb2.append(", ");
            }
            return l.a.a(sb2, strA1, ']');
        }

        @Override // yj.m.b, yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: w0 */
        public boolean remove(CharSequence charSequence) throws Throwable {
            AsciiString asciiStringC1 = b.c1(charSequence);
            if (b.X0(asciiStringC1)) {
                if (e1(asciiStringC1) == null) {
                    return false;
                }
                f1(asciiStringC1, null);
                return true;
            }
            if (!b.S0(i1.f20996i, asciiStringC1)) {
                return super.remove(asciiStringC1);
            }
            boolean z10 = this.f21140n != null;
            this.f21140n = null;
            return z10;
        }
    }

    public static final class d extends b {
        public d(int i10) {
            super(i10);
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: G */
        public CharSequence get(CharSequence charSequence) {
            return W0(b.c1(charSequence));
        }

        @Override // yj.a, io.netty.handler.codec.Headers
        /* JADX INFO: renamed from: b */
        public Http2Headers add(CharSequence charSequence, CharSequence charSequence2) {
            return O0(d1(b.c1(charSequence)), b.c1(charSequence2));
        }

        public String toString() {
            return d.class.getSimpleName() + ks.a.f9445d + a1() + ']';
        }
    }

    public static final class e extends DefaultHttp2HeadersDecoder {
        public e(long j10) {
            super(true, j10);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b newHeaders() {
            return new c(numberOfHeadersGuess());
        }
    }
}
