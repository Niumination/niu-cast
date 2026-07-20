package en;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.io.OutputStream;
import kn.l0;
import nm.p;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@f
public final class e extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final OutputStream f4583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final a f4584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final byte[] f4587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final byte[] f4588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4589g;

    public e(@l OutputStream outputStream, @l a aVar) {
        l0.p(outputStream, "output");
        l0.p(aVar, HttpHeaders.Values.BASE64);
        this.f4583a = outputStream;
        this.f4584b = aVar;
        this.f4586d = aVar.f4569b ? 76 : -1;
        this.f4587e = new byte[1024];
        this.f4588f = new byte[3];
    }

    public final void b() throws IOException {
        if (this.f4585c) {
            throw new IOException("The output stream is closed.");
        }
    }

    public final int c(byte[] bArr, int i10, int i11) {
        int iMin = Math.min(3 - this.f4589g, i11 - i10);
        p.v0(bArr, this.f4588f, this.f4589g, i10, i10 + iMin);
        int i12 = this.f4589g + iMin;
        this.f4589g = i12;
        if (i12 == 3) {
            d();
        }
        return iMin;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4585c) {
            return;
        }
        this.f4585c = true;
        if (this.f4589g != 0) {
            d();
        }
        this.f4583a.close();
    }

    public final void d() {
        if (h(this.f4588f, 0, this.f4589g) != 4) {
            throw new IllegalStateException("Check failed.");
        }
        this.f4589g = 0;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        b();
        this.f4583a.flush();
    }

    public final int h(byte[] bArr, int i10, int i11) throws IOException {
        int iT = this.f4584b.t(bArr, this.f4587e, 0, i10, i11);
        if (this.f4586d == 0) {
            OutputStream outputStream = this.f4583a;
            a.f4557c.getClass();
            outputStream.write(a.f4565k);
            this.f4586d = 76;
            if (iT > 76) {
                throw new IllegalStateException("Check failed.");
            }
        }
        this.f4583a.write(this.f4587e, 0, iT);
        this.f4586d -= iT;
        return iT;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        b();
        byte[] bArr = this.f4588f;
        int i11 = this.f4589g;
        int i12 = i11 + 1;
        this.f4589g = i12;
        bArr[i11] = (byte) i10;
        if (i12 == 3) {
            d();
        }
    }

    @Override // java.io.OutputStream
    public void write(@l byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        l0.p(bArr, "source");
        b();
        if (i10 < 0 || i11 < 0 || (i12 = i10 + i11) > bArr.length) {
            StringBuilder sbA = i0.a.a("offset: ", i10, ", length: ", i11, ", source size: ");
            sbA.append(bArr.length);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        if (i11 == 0) {
            return;
        }
        int i13 = this.f4589g;
        if (i13 < 3) {
            if (i13 != 0) {
                i10 += c(bArr, i10, i12);
                if (this.f4589g != 0) {
                    return;
                }
            }
            while (i10 + 3 <= i12) {
                int iMin = Math.min((this.f4584b.f4569b ? this.f4586d : this.f4587e.length) / 4, (i12 - i10) / 3);
                int i14 = (iMin * 3) + i10;
                if (h(bArr, i10, i14) != iMin * 4) {
                    throw new IllegalStateException("Check failed.");
                }
                i10 = i14;
            }
            p.v0(bArr, this.f4588f, 0, i10, i12);
            this.f4589g = i12 - i10;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }
}
