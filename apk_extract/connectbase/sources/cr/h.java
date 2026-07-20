package cr;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f3418a;

    public h(z zVar) {
        if (zVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3418a = zVar;
    }

    @Override // cr.z
    public void Z0(c cVar, long j10) throws IOException {
        this.f3418a.Z0(cVar, j10);
    }

    public final z b() {
        return this.f3418a;
    }

    @Override // cr.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3418a.close();
    }

    @Override // cr.z
    public b0 f() {
        return this.f3418a.f();
    }

    @Override // cr.z, java.io.Flushable
    public void flush() throws IOException {
        this.f3418a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f3418a.toString() + ")";
    }
}
