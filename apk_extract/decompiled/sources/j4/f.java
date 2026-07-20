package j4;

import java.io.OutputStream;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class f extends OutputStream {
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i8) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        bArr.getClass();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i8, int i9) {
        bArr.getClass();
        v8.k(i8, i9 + i8, bArr.length);
    }
}
