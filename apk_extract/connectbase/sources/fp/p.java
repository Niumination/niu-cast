package fp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class p extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f6270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6271d = 0;

    public class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6273b;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6272a < this.f6273b;
        }

        @Override // fp.d.a
        public byte nextByte() {
            try {
                byte[] bArr = p.this.f6270c;
                int i10 = this.f6272a;
                this.f6272a = i10 + 1;
                return bArr[i10];
            } catch (ArrayIndexOutOfBoundsException e10) {
                throw new NoSuchElementException(e10.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public b() {
            this.f6272a = 0;
            this.f6273b = p.this.size();
        }
    }

    public p(byte[] bArr) {
        this.f6270c = bArr;
    }

    public static int C(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public boolean A(p pVar, int i10, int i11) {
        if (i11 > pVar.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i11);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i10 + i11 > pVar.size()) {
            int size2 = pVar.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: ");
            sb3.append(i10);
            sb3.append(", ");
            sb3.append(i11);
            sb3.append(", ");
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        }
        byte[] bArr = this.f6270c;
        byte[] bArr2 = pVar.f6270c;
        int iB = B() + i11;
        int iB2 = B();
        int iB3 = pVar.B() + i10;
        while (iB2 < iB) {
            if (bArr[iB2] != bArr2[iB3]) {
                return false;
            }
            iB2++;
            iB3++;
        }
        return true;
    }

    public int B() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof p) {
            return A((p) obj, 0, size());
        }
        if (obj instanceof u) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(j.c.a(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
    }

    public int hashCode() {
        int iR = this.f6271d;
        if (iR == 0) {
            int size = size();
            iR = r(size, 0, size);
            if (iR == 0) {
                iR = 1;
            }
            this.f6271d = iR;
        }
        return iR;
    }

    @Override // fp.d
    public void j(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f6270c, i10, bArr, i11, i12);
    }

    @Override // fp.d
    public int k() {
        return 0;
    }

    @Override // fp.d
    public boolean l() {
        return true;
    }

    @Override // fp.d
    public boolean m() {
        int iB = B();
        return y.f(this.f6270c, iB, size() + iB);
    }

    @Override // fp.d, java.lang.Iterable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new b();
    }

    @Override // fp.d
    public e o() {
        return e.g(this);
    }

    @Override // fp.d
    public int r(int i10, int i11, int i12) {
        return C(i10, this.f6270c, B() + i11, i12);
    }

    @Override // fp.d
    public int s(int i10, int i11, int i12) {
        int iB = B() + i11;
        return y.g(i10, this.f6270c, iB, i12 + iB);
    }

    @Override // fp.d
    public int size() {
        return this.f6270c.length;
    }

    @Override // fp.d
    public int t() {
        return this.f6271d;
    }

    @Override // fp.d
    public String v(String str) throws UnsupportedEncodingException {
        return new String(this.f6270c, B(), size(), str);
    }

    @Override // fp.d
    public void y(OutputStream outputStream, int i10, int i11) throws IOException {
        outputStream.write(this.f6270c, B() + i10, i11);
    }

    public byte z(int i10) {
        return this.f6270c[i10];
    }
}
