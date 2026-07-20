package fp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class u extends fp.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f6275n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fp.d f6277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fp.d f6278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6280g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6281i;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack<fp.d> f6282a;

        public b() {
            this.f6282a = new Stack<>();
        }

        public final fp.d b(fp.d dVar, fp.d dVar2) {
            c(dVar);
            c(dVar2);
            fp.d dVarPop = this.f6282a.pop();
            while (!this.f6282a.isEmpty()) {
                dVarPop = new u(this.f6282a.pop(), dVarPop);
            }
            return dVarPop;
        }

        public final void c(fp.d dVar) {
            if (dVar.l()) {
                e(dVar);
            } else {
                if (!(dVar instanceof u)) {
                    String strValueOf = String.valueOf(dVar.getClass());
                    throw new IllegalArgumentException(j.c.a(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
                }
                u uVar = (u) dVar;
                c(uVar.f6277d);
                c(uVar.f6278e);
            }
        }

        public final int d(int i10) {
            int iBinarySearch = Arrays.binarySearch(u.f6275n, i10);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        public final void e(fp.d dVar) {
            int iD = d(dVar.size());
            int i10 = u.f6275n[iD + 1];
            if (this.f6282a.isEmpty() || this.f6282a.peek().size() >= i10) {
                this.f6282a.push(dVar);
                return;
            }
            int i11 = u.f6275n[iD];
            fp.d dVarPop = this.f6282a.pop();
            while (!this.f6282a.isEmpty() && this.f6282a.peek().size() < i11) {
                dVarPop = new u(this.f6282a.pop(), dVarPop);
            }
            u uVar = new u(dVarPop, dVar);
            while (!this.f6282a.isEmpty()) {
                if (this.f6282a.peek().size() >= u.f6275n[d(uVar.size()) + 1]) {
                    break;
                } else {
                    uVar = new u(this.f6282a.pop(), uVar);
                }
            }
            this.f6282a.push(uVar);
        }
    }

    public static class c implements Iterator<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack<u> f6283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f6284b;

        public final p a(fp.d dVar) {
            while (dVar instanceof u) {
                u uVar = (u) dVar;
                this.f6283a.push(uVar);
                dVar = uVar.f6277d;
            }
            return (p) dVar;
        }

        public final p b() {
            while (!this.f6283a.isEmpty()) {
                p pVarA = a(this.f6283a.pop().f6278e);
                if (!pVarA.isEmpty()) {
                    return pVarA;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public p next() {
            p pVar = this.f6284b;
            if (pVar == null) {
                throw new NoSuchElementException();
            }
            this.f6284b = b();
            return pVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6284b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public c(fp.d dVar) {
            this.f6283a = new Stack<>();
            this.f6284b = a(dVar);
        }
    }

    public class d implements fp.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f6285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fp.d.a f6286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6287c;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6287c > 0;
        }

        @Override // fp.d.a
        public byte nextByte() {
            if (!this.f6286b.hasNext()) {
                this.f6286b = this.f6285a.next().iterator();
            }
            this.f6287c--;
            return this.f6286b.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public d() {
            c cVar = new c(u.this);
            this.f6285a = cVar;
            this.f6286b = cVar.next().iterator();
            this.f6287c = u.this.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 1;
        while (i10 > 0) {
            arrayList.add(Integer.valueOf(i10));
            int i12 = i11 + i10;
            i11 = i10;
            i10 = i12;
        }
        arrayList.add(Integer.MAX_VALUE);
        f6275n = new int[arrayList.size()];
        int i13 = 0;
        while (true) {
            int[] iArr = f6275n;
            if (i13 >= iArr.length) {
                return;
            }
            iArr[i13] = ((Integer) arrayList.get(i13)).intValue();
            i13++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x0086  */
    /* JADX WARN: Code duplicated, block: B:28:0x008d  */
    public static fp.d C(fp.d dVar, fp.d dVar2) {
        u uVar = dVar instanceof u ? (u) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() != 0) {
            int size = dVar2.size() + dVar.size();
            if (size < 128) {
                return D(dVar, dVar2);
            }
            if (uVar == null) {
                if (uVar != null) {
                }
                if (size >= f6275n[Math.max(dVar.k(), dVar2.k()) + 1]) {
                }
            }
            if (dVar2.size() + uVar.f6278e.size() < 128) {
                dVar2 = new u(uVar.f6277d, D(uVar.f6278e, dVar2));
            } else {
                if (uVar != null || uVar.f6277d.k() <= uVar.f6278e.k() || uVar.k() <= dVar2.k()) {
                    return size >= f6275n[Math.max(dVar.k(), dVar2.k()) + 1] ? new u(dVar, dVar2) : new b().b(dVar, dVar2);
                }
                dVar2 = new u(uVar.f6277d, new u(uVar.f6278e, dVar2));
            }
        }
        return dVar2;
    }

    public static p D(fp.d dVar, fp.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.i(bArr, 0, 0, size);
        dVar2.i(bArr, 0, size, size2);
        return new p(bArr);
    }

    public final boolean E(fp.d dVar) {
        c cVar = new c(this);
        p pVar = (p) cVar.next();
        c cVar2 = new c(dVar);
        p pVar2 = (p) cVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int size = pVar.size() - i10;
            int size2 = pVar2.size() - i11;
            int iMin = Math.min(size, size2);
            if (!(i10 == 0 ? pVar.A(pVar2, i11, iMin) : pVar2.A(pVar, i10, iMin))) {
                return false;
            }
            i12 += iMin;
            int i13 = this.f6276c;
            if (i12 >= i13) {
                if (i12 == i13) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                pVar = (p) cVar.next();
                i10 = 0;
            } else {
                i10 += iMin;
            }
            if (iMin == size2) {
                pVar2 = (p) cVar2.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
        }
    }

    public boolean equals(Object obj) {
        int iT;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fp.d)) {
            return false;
        }
        fp.d dVar = (fp.d) obj;
        if (this.f6276c != dVar.size()) {
            return false;
        }
        if (this.f6276c == 0) {
            return true;
        }
        if (this.f6281i == 0 || (iT = dVar.t()) == 0 || this.f6281i == iT) {
            return E(dVar);
        }
        return false;
    }

    public int hashCode() {
        int iR = this.f6281i;
        if (iR == 0) {
            int i10 = this.f6276c;
            iR = r(i10, 0, i10);
            if (iR == 0) {
                iR = 1;
            }
            this.f6281i = iR;
        }
        return iR;
    }

    @Override // fp.d
    public void j(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.f6279f;
        if (i13 <= i14) {
            this.f6277d.j(bArr, i10, i11, i12);
        } else {
            if (i10 >= i14) {
                this.f6278e.j(bArr, i10 - i14, i11, i12);
                return;
            }
            int i15 = i14 - i10;
            this.f6277d.j(bArr, i10, i11, i15);
            this.f6278e.j(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    @Override // fp.d
    public int k() {
        return this.f6280g;
    }

    @Override // fp.d
    public boolean l() {
        return this.f6276c >= f6275n[this.f6280g];
    }

    @Override // fp.d
    public boolean m() {
        int iS = this.f6277d.s(0, 0, this.f6279f);
        fp.d dVar = this.f6278e;
        return dVar.s(iS, 0, dVar.size()) == 0;
    }

    @Override // fp.d, java.lang.Iterable
    /* JADX INFO: renamed from: n */
    public fp.d.a iterator() {
        return new d();
    }

    @Override // fp.d
    public fp.e o() {
        return new fp.e(new e());
    }

    @Override // fp.d
    public int r(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f6279f;
        if (i13 <= i14) {
            return this.f6277d.r(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f6278e.r(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f6278e.r(this.f6277d.r(i10, i11, i15), 0, i12 - i15);
    }

    @Override // fp.d
    public int s(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f6279f;
        if (i13 <= i14) {
            return this.f6277d.s(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f6278e.s(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f6278e.s(this.f6277d.s(i10, i11, i15), 0, i12 - i15);
    }

    @Override // fp.d
    public int size() {
        return this.f6276c;
    }

    @Override // fp.d
    public int t() {
        return this.f6281i;
    }

    @Override // fp.d
    public String v(String str) throws UnsupportedEncodingException {
        return new String(u(), str);
    }

    @Override // fp.d
    public void y(OutputStream outputStream, int i10, int i11) throws IOException {
        int i12 = i10 + i11;
        int i13 = this.f6279f;
        if (i12 <= i13) {
            this.f6277d.y(outputStream, i10, i11);
        } else {
            if (i10 >= i13) {
                this.f6278e.y(outputStream, i10 - i13, i11);
                return;
            }
            int i14 = i13 - i10;
            this.f6277d.y(outputStream, i10, i14);
            this.f6278e.y(outputStream, 0, i11 - i14);
        }
    }

    public u(fp.d dVar, fp.d dVar2) {
        this.f6281i = 0;
        this.f6277d = dVar;
        this.f6278e = dVar2;
        int size = dVar.size();
        this.f6279f = size;
        this.f6276c = dVar2.size() + size;
        this.f6280g = Math.max(dVar.k(), dVar2.k()) + 1;
    }

    public class e extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f6289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f6290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6294f;

        public e() {
            c();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return u.this.size() - (this.f6293e + this.f6292d);
        }

        public final void b() {
            if (this.f6290b != null) {
                int i10 = this.f6292d;
                int i11 = this.f6291c;
                if (i10 == i11) {
                    this.f6293e += i11;
                    this.f6292d = 0;
                    if (!this.f6289a.hasNext()) {
                        this.f6290b = null;
                        this.f6291c = 0;
                    } else {
                        p next = this.f6289a.next();
                        this.f6290b = next;
                        this.f6291c = next.size();
                    }
                }
            }
        }

        public final void c() {
            c cVar = new c(u.this);
            this.f6289a = cVar;
            p next = cVar.next();
            this.f6290b = next;
            this.f6291c = next.size();
            this.f6292d = 0;
            this.f6293e = 0;
        }

        public final int d(byte[] bArr, int i10, int i11) {
            int i12 = i11;
            while (i12 > 0) {
                b();
                if (this.f6290b == null) {
                    if (i12 != i11) {
                        break;
                    }
                    return -1;
                }
                int iMin = Math.min(this.f6291c - this.f6292d, i12);
                if (bArr != null) {
                    this.f6290b.i(bArr, this.f6292d, i10, iMin);
                    i10 += iMin;
                }
                this.f6292d += iMin;
                i12 -= iMin;
            }
            return i11 - i12;
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f6294f = this.f6293e + this.f6292d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            bArr.getClass();
            if (i10 < 0 || i11 < 0 || i11 > bArr.length - i10) {
                throw new IndexOutOfBoundsException();
            }
            return d(bArr, i10, i11);
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            c();
            d(null, 0, this.f6294f);
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            if (j10 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j10 > 2147483647L) {
                j10 = 2147483647L;
            }
            return d(null, 0, (int) j10);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            b();
            p pVar = this.f6290b;
            if (pVar == null) {
                return -1;
            }
            int i10 = this.f6292d;
            this.f6292d = i10 + 1;
            return pVar.z(i10) & 255;
        }
    }
}
