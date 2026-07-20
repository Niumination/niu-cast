package fp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements Iterable<Byte> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6202a = new p(new byte[0]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f6203b = false;

    public interface a extends Iterator<Byte> {
        byte nextByte();
    }

    public static d a(Iterator<d> it, int i10) {
        if (i10 == 1) {
            return it.next();
        }
        int i11 = i10 >>> 1;
        return a(it, i11).b(a(it, i10 - i11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public static d c(Iterable<d> iterable) {
        ?? arrayList;
        if (iterable instanceof Collection) {
            arrayList = (Collection) iterable;
        } else {
            arrayList = new ArrayList();
            Iterator<d> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList.isEmpty() ? f6202a : a(arrayList.iterator(), arrayList.size());
    }

    public static d e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static d f(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new p(bArr2);
    }

    public static d g(String str) {
        try {
            return new p(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    public static b q() {
        return new b(128);
    }

    public d b(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return u.C(this, dVar);
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("ByteString would be too long: ");
        sb2.append(size);
        sb2.append(ps.d.ANY_NON_NULL_MARKER);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public void i(byte[] bArr, int i10, int i11, int i12) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(30);
            sb3.append("Target offset < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        if (i12 < 0) {
            StringBuilder sb4 = new StringBuilder(23);
            sb4.append("Length < 0: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i13 = i10 + i12;
        if (i13 > size()) {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Source end offset < 0: ");
            sb5.append(i13);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
        int i14 = i11 + i12;
        if (i14 <= bArr.length) {
            if (i12 > 0) {
                j(bArr, i10, i11, i12);
            }
        } else {
            StringBuilder sb6 = new StringBuilder(34);
            sb6.append("Target end offset < 0: ");
            sb6.append(i14);
            throw new IndexOutOfBoundsException(sb6.toString());
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract void j(byte[] bArr, int i10, int i11, int i12);

    public abstract int k();

    public abstract boolean l();

    public abstract boolean m();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: n */
    public abstract a iterator();

    public abstract e o();

    public abstract int r(int i10, int i11, int i12);

    public abstract int s(int i10, int i11, int i12);

    public abstract int size();

    public abstract int t();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public byte[] u() {
        int size = size();
        if (size == 0) {
            return j.f6259a;
        }
        byte[] bArr = new byte[size];
        j(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String v(String str) throws UnsupportedEncodingException;

    public String w() {
        try {
            return v("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    public void x(OutputStream outputStream, int i10, int i11) throws IOException {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i12 = i10 + i11;
        if (i12 <= size()) {
            if (i11 > 0) {
                y(outputStream, i10, i11);
            }
        } else {
            StringBuilder sb4 = new StringBuilder(39);
            sb4.append("Source end offset exceeded: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public abstract void y(OutputStream outputStream, int i10, int i11) throws IOException;

    public static final class b extends OutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f6204f = new byte[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<d> f6206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f6208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6209e;

        public b(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f6205a = i10;
            this.f6206b = new ArrayList<>();
            this.f6208d = new byte[i10];
        }

        public final byte[] b(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i10));
            return bArr2;
        }

        public final void c(int i10) {
            this.f6206b.add(new p(this.f6208d));
            int length = this.f6207c + this.f6208d.length;
            this.f6207c = length;
            this.f6208d = new byte[Math.max(this.f6205a, Math.max(i10, length >>> 1))];
            this.f6209e = 0;
        }

        public final void d() {
            int i10 = this.f6209e;
            byte[] bArr = this.f6208d;
            if (i10 >= bArr.length) {
                this.f6206b.add(new p(this.f6208d));
                this.f6208d = f6204f;
            } else if (i10 > 0) {
                this.f6206b.add(new p(b(bArr, i10)));
            }
            this.f6207c += this.f6209e;
            this.f6209e = 0;
        }

        public synchronized int h() {
            return this.f6207c + this.f6209e;
        }

        public synchronized d k() {
            d();
            return d.c(this.f6206b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(h()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i10) {
            try {
                if (this.f6209e == this.f6208d.length) {
                    c(1);
                }
                byte[] bArr = this.f6208d;
                int i11 = this.f6209e;
                this.f6209e = i11 + 1;
                bArr[i11] = (byte) i10;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i10, int i11) {
            try {
                byte[] bArr2 = this.f6208d;
                int length = bArr2.length;
                int i12 = this.f6209e;
                if (i11 <= length - i12) {
                    System.arraycopy(bArr, i10, bArr2, i12, i11);
                    this.f6209e += i11;
                } else {
                    int length2 = bArr2.length - i12;
                    System.arraycopy(bArr, i10, bArr2, i12, length2);
                    int i13 = i11 - length2;
                    c(i13);
                    System.arraycopy(bArr, i10 + length2, this.f6208d, 0, i13);
                    this.f6209e = i13;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
