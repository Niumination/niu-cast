package yj;

import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends yj.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AsciiString[] f21168c = new AsciiString[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsciiString[] f21169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsciiString[] f21170b;

    public class b implements Map.Entry<CharSequence, CharSequence>, Iterator<Map.Entry<CharSequence, CharSequence>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AsciiString[] f21172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AsciiString f21173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AsciiString f21174d;

        public b() {
            this.f21172b = n.this.f21170b.length != 0 ? n.this.f21170b : n.this.f21169a;
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CharSequence getKey() {
            return this.f21173c;
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CharSequence getValue() {
            return this.f21174d;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<CharSequence, CharSequence> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AsciiString[] asciiStringArr = this.f21172b;
            int i10 = this.f21171a;
            this.f21173c = asciiStringArr[i10];
            this.f21174d = asciiStringArr[i10 + 1];
            int i11 = i10 + 2;
            this.f21171a = i11;
            if (i11 >= asciiStringArr.length && asciiStringArr == n.this.f21170b) {
                this.f21172b = n.this.f21169a;
                this.f21171a = 0;
            }
            return this;
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public CharSequence setValue(CharSequence charSequence) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21171a < this.f21172b.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public n(AsciiString[] asciiStringArr, byte[][] bArr) {
        this.f21169a = new AsciiString[bArr.length];
        int i10 = 0;
        while (true) {
            AsciiString[] asciiStringArr2 = this.f21169a;
            if (i10 >= asciiStringArr2.length) {
                this.f21170b = asciiStringArr;
                return;
            } else {
                asciiStringArr2[i10] = new AsciiString(bArr[i10], false);
                i10++;
            }
        }
    }

    public static n Q0(byte[][] bArr, AsciiString asciiString, AsciiString asciiString2, AsciiString asciiString3, AsciiString asciiString4, AsciiString asciiString5) {
        return new n(new AsciiString[]{Http2Headers.PseudoHeaderName.AUTHORITY.value(), asciiString, Http2Headers.PseudoHeaderName.PATH.value(), asciiString2, Http2Headers.PseudoHeaderName.METHOD.value(), asciiString3, Http2Headers.PseudoHeaderName.SCHEME.value(), asciiString4, i1.f20994g, i1.f20995h, i1.f20996i, i1.f20997j, i1.f20998k, asciiString5}, bArr);
    }

    public static n R0(byte[][] bArr) {
        return new n(new AsciiString[]{Http2Headers.PseudoHeaderName.STATUS.value(), i1.f20989b, i1.f20994g, i1.f20995h}, bArr);
    }

    public static n S0(byte[][] bArr) {
        return new n(f21168c, bArr);
    }

    @Override // yj.a, io.netty.handler.codec.http2.Http2Headers, io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<CharSequence, CharSequence>> iterator() {
        return new b();
    }

    @Override // yj.a, io.netty.handler.codec.Headers
    public int size() {
        return (this.f21169a.length + this.f21170b.length) / 2;
    }

    @Override // yj.a, io.netty.handler.codec.http2.Http2Headers
    public CharSequence status() {
        AsciiString[] asciiStringArr = this.f21170b;
        if (asciiStringArr.length < 2 || asciiStringArr[0] != Http2Headers.PseudoHeaderName.STATUS.value()) {
            return null;
        }
        return this.f21170b[1];
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(n.class.getSimpleName());
        sb2.append(ks.a.f9445d);
        b bVar = new b();
        String str = "";
        while (bVar.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = bVar.next();
            CharSequence key = next.getKey();
            CharSequence value = next.getValue();
            sb2.append(str);
            sb2.append(key);
            sb2.append(": ");
            sb2.append(value);
            str = ", ";
        }
        sb2.append(']');
        return sb2.toString();
    }
}
