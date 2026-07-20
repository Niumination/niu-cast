package en;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InputStream;
import kn.l0;
import nm.p;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@f
public final class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final InputStream f4574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final a f4575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final byte[] f4578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final byte[] f4579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final byte[] f4580g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4581i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4582n;

    public d(@l InputStream inputStream, @l a aVar) {
        l0.p(inputStream, "input");
        l0.p(aVar, HttpHeaders.Values.BASE64);
        this.f4574a = inputStream;
        this.f4575b = aVar;
        this.f4578e = new byte[1];
        this.f4579f = new byte[1024];
        this.f4580g = new byte[1024];
    }

    public final void b(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = this.f4580g;
        int i12 = this.f4581i;
        p.v0(bArr2, bArr, i10, i12, i12 + i11);
        this.f4581i += i11;
        n();
    }

    public final int c(byte[] bArr, int i10, int i11, int i12) {
        int i13 = this.f4582n;
        this.f4582n = i13 + this.f4575b.n(this.f4579f, this.f4580g, i13, 0, i12);
        int iMin = Math.min(d(), i11 - i10);
        b(bArr, i10, iMin);
        o();
        return iMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4576c) {
            return;
        }
        this.f4576c = true;
        this.f4574a.close();
    }

    public final int d() {
        return this.f4582n - this.f4581i;
    }

    public final int h(int i10) throws IOException {
        this.f4579f[i10] = 61;
        if ((i10 & 3) != 2) {
            return i10 + 1;
        }
        int iK = k();
        if (iK >= 0) {
            this.f4579f[i10 + 1] = (byte) iK;
        }
        return i10 + 2;
    }

    public final int k() throws IOException {
        int i10;
        if (!this.f4575b.f4569b) {
            return this.f4574a.read();
        }
        do {
            i10 = this.f4574a.read();
            if (i10 == -1) {
                break;
            }
        } while (!c.g(i10));
        return i10;
    }

    public final void n() {
        if (this.f4581i == this.f4582n) {
            this.f4581i = 0;
            this.f4582n = 0;
        }
    }

    public final void o() {
        byte[] bArr = this.f4580g;
        int length = bArr.length;
        int i10 = this.f4582n;
        if ((this.f4579f.length / 4) * 3 > length - i10) {
            p.v0(bArr, bArr, 0, this.f4581i, i10);
            this.f4582n -= this.f4581i;
            this.f4581i = 0;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i10 = this.f4581i;
        if (i10 < this.f4582n) {
            int i11 = this.f4580g[i10] & 255;
            this.f4581i = i10 + 1;
            n();
            return i11;
        }
        int i12 = read(this.f4578e, 0, 1);
        if (i12 == -1) {
            return -1;
        }
        if (i12 == 1) {
            return this.f4578e[0] & 255;
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.io.InputStream
    public int read(@l byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        boolean z10;
        boolean z11;
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        if (i10 >= 0 && i11 >= 0 && (i12 = i10 + i11) <= bArr.length) {
            if (!this.f4576c) {
                if (this.f4577d) {
                    return -1;
                }
                if (i11 == 0) {
                    return 0;
                }
                if (d() >= i11) {
                    b(bArr, i10, i11);
                    return i11;
                }
                int iD = (((i11 - d()) + 2) / 3) * 4;
                int iC = i10;
                while (true) {
                    z10 = this.f4577d;
                    if (z10 || iD <= 0) {
                        break;
                    }
                    int iMin = Math.min(this.f4579f.length, iD);
                    int iH = 0;
                    while (true) {
                        z11 = this.f4577d;
                        if (z11 || iH >= iMin) {
                            break;
                        }
                        int iK = k();
                        if (iK == -1) {
                            this.f4577d = true;
                        } else if (iK != 61) {
                            this.f4579f[iH] = (byte) iK;
                            iH++;
                        } else {
                            iH = h(iH);
                            this.f4577d = true;
                        }
                    }
                    if (!z11 && iH != iMin) {
                        throw new IllegalStateException("Check failed.");
                    }
                    iD -= iH;
                    iC += c(bArr, iC, i12, iH);
                }
                if (iC == i10 && z10) {
                    return -1;
                }
                return iC - i10;
            }
            throw new IOException("The input stream is closed.");
        }
        StringBuilder sbA = i0.a.a("offset: ", i10, ", length: ", i11, ", buffer size: ");
        sbA.append(bArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }
}
