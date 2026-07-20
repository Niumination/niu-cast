package wi;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f10786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f10787b;

    public l(Function0 function0, k kVar) {
        this.f10786a = function0;
        this.f10787b = kVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        if (((Boolean) this.f10786a.invoke()).booleanValue()) {
            throw new IOException("Underlying source is closed.");
        }
        return (int) Math.min(this.f10787b.getBuffer().f10764c, Integer.MAX_VALUE);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Exception {
        this.f10787b.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (((Boolean) this.f10786a.invoke()).booleanValue()) {
            throw new IOException("Underlying source is closed.");
        }
        k kVar = this.f10787b;
        if (kVar.T()) {
            return -1;
        }
        return kVar.readByte() & UByte.MAX_VALUE;
    }

    public final String toString() {
        return this.f10787b + ".asInputStream()";
    }

    @Override // java.io.InputStream
    public final int read(byte[] data, int i8, int i9) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!((Boolean) this.f10786a.invoke()).booleanValue()) {
            q.b(data.length, i8, i9);
            return this.f10787b.U(data, i8, i9 + i8);
        }
        throw new IOException("Underlying source is closed.");
    }
}
