package fl;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 {
    @os.l
    public static final InputStream a(@os.l tl.g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return new a(g0Var);
    }

    public static final class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tl.g0 f6096a;

        public a(tl.g0 g0Var) {
            this.f6096a = g0Var;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6096a.close();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f6096a.B1()) {
                return -1;
            }
            return this.f6096a.readByte();
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            return this.f6096a.t1(j10);
        }

        @Override // java.io.InputStream
        public int read(@os.l byte[] bArr, int i10, int i11) {
            kn.l0.p(bArr, "buffer");
            if (this.f6096a.B1()) {
                return -1;
            }
            return tl.i0.b(this.f6096a, bArr, i10, i11);
        }
    }
}
