package k3;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class u0 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6659b;

    @Override // java.io.OutputStream
    public final void write(int i8) {
        switch (this.f6658a) {
            case 0:
                this.f6659b++;
                break;
            default:
                this.f6659b++;
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        switch (this.f6658a) {
            case 0:
                this.f6659b += (long) bArr.length;
                break;
            default:
                this.f6659b += (long) bArr.length;
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i8, int i9) {
        int length;
        int i10;
        int length2;
        int i11;
        switch (this.f6658a) {
            case 0:
                if (i8 >= 0 && i8 <= (length = bArr.length) && i9 >= 0 && (i10 = i8 + i9) <= length && i10 >= 0) {
                    this.f6659b += (long) i9;
                    return;
                }
                throw new IndexOutOfBoundsException();
            default:
                if (i8 >= 0 && i8 <= (length2 = bArr.length) && i9 >= 0 && (i11 = i8 + i9) <= length2 && i11 >= 0) {
                    this.f6659b += (long) i9;
                    return;
                }
                throw new IndexOutOfBoundsException();
        }
    }
}
