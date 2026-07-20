package fp;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class c extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6198f;

    public class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6200b;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6199a < this.f6200b;
        }

        @Override // fp.d.a
        public byte nextByte() {
            int i10 = this.f6199a;
            if (i10 >= this.f6200b) {
                throw new NoSuchElementException();
            }
            byte[] bArr = c.this.f6270c;
            this.f6199a = i10 + 1;
            return bArr[i10];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public b() {
            int iB = c.this.B();
            this.f6199a = iB;
            this.f6200b = c.this.size() + iB;
        }
    }

    public c(byte[] bArr, int i10, int i11) {
        super(bArr);
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Offset too small: ");
            sb2.append(i10);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(29);
            sb3.append("Length too small: ");
            sb3.append(i10);
            throw new IllegalArgumentException(sb3.toString());
        }
        if (((long) i10) + ((long) i11) <= bArr.length) {
            this.f6197e = i10;
            this.f6198f = i11;
            return;
        }
        StringBuilder sb4 = new StringBuilder(48);
        sb4.append("Offset+Length too large: ");
        sb4.append(i10);
        sb4.append(ps.d.ANY_NON_NULL_MARKER);
        sb4.append(i11);
        throw new IllegalArgumentException(sb4.toString());
    }

    @Override // fp.p
    public int B() {
        return this.f6197e;
    }

    @Override // fp.p, fp.d
    public void j(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f6270c, B() + i10, bArr, i11, i12);
    }

    @Override // fp.p, fp.d, java.lang.Iterable
    /* JADX INFO: renamed from: n */
    public d.a iterator() {
        return new b();
    }

    @Override // fp.p, fp.d
    public int size() {
        return this.f6198f;
    }

    @Override // fp.p
    public byte z(int i10) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(28);
            sb2.append("Index too small: ");
            sb2.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        if (i10 < size()) {
            return this.f6270c[this.f6197e + i10];
        }
        int size = size();
        StringBuilder sb3 = new StringBuilder(41);
        sb3.append("Index too large: ");
        sb3.append(i10);
        sb3.append(", ");
        sb3.append(size);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }
}
