package af;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import k3.v8;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class l4 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f440d = -1;

    public l4(byte[] bArr, int i8, int i9) {
        v8.c("offset must be >= 0", i8 >= 0);
        v8.c("length must be >= 0", i9 >= 0);
        int i10 = i9 + i8;
        v8.c("offset + length exceeds array boundary", i10 <= bArr.length);
        this.f439c = bArr;
        this.f437a = i8;
        this.f438b = i10;
    }

    @Override // af.d
    public final void c() {
        this.f440d = this.f437a;
    }

    @Override // af.d
    public final d h(int i8) {
        a(i8);
        int i9 = this.f437a;
        this.f437a = i9 + i8;
        return new l4(this.f439c, i9, i8);
    }

    @Override // af.d
    public final void i(OutputStream outputStream, int i8) throws IOException {
        a(i8);
        outputStream.write(this.f439c, this.f437a, i8);
        this.f437a += i8;
    }

    @Override // af.d
    public final void k(ByteBuffer byteBuffer) {
        v8.i(byteBuffer, "dest");
        int iRemaining = byteBuffer.remaining();
        a(iRemaining);
        byteBuffer.put(this.f439c, this.f437a, iRemaining);
        this.f437a += iRemaining;
    }

    @Override // af.d
    public final void l(byte[] bArr, int i8, int i9) {
        System.arraycopy(this.f439c, this.f437a, bArr, i8, i9);
        this.f437a += i9;
    }

    @Override // af.d
    public final int m() {
        a(1);
        int i8 = this.f437a;
        this.f437a = i8 + 1;
        return this.f439c[i8] & UByte.MAX_VALUE;
    }

    @Override // af.d
    public final int o() {
        return this.f438b - this.f437a;
    }

    @Override // af.d
    public final void s() {
        int i8 = this.f440d;
        if (i8 == -1) {
            throw new InvalidMarkException();
        }
        this.f437a = i8;
    }

    @Override // af.d
    public final void t(int i8) {
        a(i8);
        this.f437a += i8;
    }
}
