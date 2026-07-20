package af;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y3 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f718b;

    public /* synthetic */ y3(Object obj, int i8) {
        this.f717a = i8;
        this.f718b = obj;
    }

    private final void a() {
    }

    private final void c() {
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        switch (this.f717a) {
            case 1:
                break;
            default:
                super.close();
                break;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        switch (this.f717a) {
            case 1:
                break;
            default:
                super.flush();
                break;
        }
    }

    public String toString() {
        switch (this.f717a) {
            case 1:
                return ((qj.f) this.f718b) + ".outputStream()";
            default:
                return super.toString();
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i8) {
        switch (this.f717a) {
            case 0:
                write(new byte[]{(byte) i8}, 0, 1);
                break;
            default:
                ((qj.f) this.f718b).S(i8);
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] data, int i8, int i9) {
        switch (this.f717a) {
            case 0:
                ((a4) this.f718b).f(data, i8, i9);
                break;
            default:
                Intrinsics.checkNotNullParameter(data, "data");
                ((qj.f) this.f718b).L(data, i8, i9);
                break;
        }
    }
}
