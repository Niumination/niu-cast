package cm;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import kn.l0;
import lm.l2;
import os.l;
import tl.i0;
import tl.n0;
import tl.s;
import tl.s0;
import tl.v;
import tl.w0;
import tn.u;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final char[] f1674a = new char[8192];

    public static final class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f1675a;

        public a(v vVar) {
            this.f1675a = vVar;
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(this.f1675a.S0(), 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f1675a.z2();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f1675a.B1()) {
                return -1;
            }
            return this.f1675a.readByte() & 255;
        }
    }

    public static final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f1676a;

        public b(s sVar) {
            this.f1676a = sVar;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws n0 {
            this.f1676a.d1((byte) i10);
        }

        @Override // java.io.OutputStream
        public void write(@l byte[] bArr, int i10, int i11) {
            l0.p(bArr, "b");
            s0.j(this.f1676a, bArr, i10, i11);
        }
    }

    public static final class c extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f1677a;

        public c(v vVar) {
            this.f1677a = vVar;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f1677a.z2();
        }

        @Override // java.io.Reader
        public int read(@l char[] cArr, int i10, int i11) {
            l0.p(cArr, "cbuf");
            return this.f1677a.q2(cArr, i10, i11);
        }

        @Override // java.io.Reader
        public long skip(long j10) {
            int i10;
            char[] cArr = f.f1674a;
            int length = cArr.length;
            long j11 = 0;
            while (j11 < j10 && (i10 = read(cArr, 0, (int) Math.min(length, j10 - j11))) != -1) {
                j11 += (long) i10;
            }
            return j11;
        }
    }

    public static final class d extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f1678a;

        public d(s sVar) {
            this.f1678a = sVar;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(@l char[] cArr, int i10, int i11) {
            l0.p(cArr, "cbuf");
            this.f1678a.f1(cArr, i10, i11 + i10);
        }
    }

    @l
    public static final InputStream b(@l v vVar) {
        l0.p(vVar, "<this>");
        return new a(vVar);
    }

    @l
    public static final OutputStream c(@l s sVar) {
        l0.p(sVar, "<this>");
        return new b(sVar);
    }

    @l
    public static final v d(@l InputStream inputStream, long j10) {
        l0.p(inputStream, "<this>");
        return g(inputStream, j10, Long.MAX_VALUE);
    }

    @l
    public static final v e(@l InputStream inputStream, long j10) {
        l0.p(inputStream, "<this>");
        return g(inputStream, 1L, j10);
    }

    @l
    public static final v f(@l InputStream inputStream, long j10) {
        l0.p(inputStream, "<this>");
        return g(inputStream, j10, j10);
    }

    public static final v g(InputStream inputStream, long j10, long j11) {
        long j12 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("min shouldn't be negative");
        }
        if (j10 > j11) {
            StringBuilder sbA = j.b.a("min shouldn't be greater than max: ", j10, " > ");
            sbA.append(j11);
            throw new IllegalArgumentException(sbA.toString().toString());
        }
        int iC = (int) u.C(j11, 4096L);
        byte[] bArr = new byte[iC];
        s sVarB = w0.b(0, 1, null);
        while (true) {
            if (j12 >= j10 && (j12 != j10 || j10 != 0)) {
                return sVarB.z2();
            }
            try {
                int i10 = inputStream.read(bArr, 0, Math.min((int) Math.min(j11 - j12, 2147483647L), iC));
                if (i10 == -1) {
                    throw new EOFException("Premature end of stream: was read " + j12 + " bytes of " + j10);
                }
                j12 += (long) i10;
                s0.j(sVarB, bArr, 0, i10);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    @l
    public static final Reader h(@l v vVar) {
        l0.p(vVar, "<this>");
        return new c(vVar);
    }

    public static final void i(@l OutputStream outputStream, @l jn.l<? super s, l2> lVar) {
        l0.p(outputStream, "<this>");
        l0.p(lVar, "builder");
        s sVarA = w0.a(0);
        try {
            lVar.invoke(sVarA);
            j(outputStream, sVarA.z2());
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    public static final void j(@l OutputStream outputStream, @l v vVar) {
        l0.p(outputStream, "<this>");
        l0.p(vVar, "packet");
        long jS0 = vVar.S0();
        if (jS0 == 0) {
            return;
        }
        byte[] bArr = new byte[(int) u.C(jS0, 4096L)];
        while (!vVar.B1()) {
            try {
                outputStream.write(bArr, 0, i0.i(vVar, bArr, 0, 0, 6, null));
            } catch (Throwable th2) {
                vVar.z2();
                throw th2;
            }
        }
        vVar.z2();
    }

    @l
    public static final Writer k(@l s sVar) {
        l0.p(sVar, "<this>");
        return new d(sVar);
    }
}
