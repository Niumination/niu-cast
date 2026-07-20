package ms;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class e extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f10916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10917b;

    public e(OutputStream outputStream) {
        super(outputStream);
        this.f10916a = new byte[8192];
    }

    public final void b() throws IOException {
        int i10 = this.f10917b;
        if (i10 > 0) {
            ((FilterOutputStream) this).out.write(this.f10916a, 0, i10);
            this.f10917b = 0;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        b();
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        if (this.f10917b >= this.f10916a.length) {
            b();
        }
        byte[] bArr = this.f10916a;
        int i11 = this.f10917b;
        this.f10917b = i11 + 1;
        bArr[i11] = (byte) i10;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        byte[] bArr2 = this.f10916a;
        if (i11 >= bArr2.length) {
            b();
            ((FilterOutputStream) this).out.write(bArr, i10, i11);
        } else {
            if (i11 > bArr2.length - this.f10917b) {
                b();
            }
            System.arraycopy(bArr, i10, this.f10916a, this.f10917b, i11);
            this.f10917b += i11;
        }
    }
}
