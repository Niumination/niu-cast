package cr;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f3419a;

    public i(a0 a0Var) {
        if (a0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3419a = a0Var;
    }

    @Override // cr.a0
    public long Y0(c cVar, long j10) throws IOException {
        return this.f3419a.Y0(cVar, j10);
    }

    public final a0 b() {
        return this.f3419a;
    }

    @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3419a.close();
    }

    @Override // cr.a0
    public b0 f() {
        return this.f3419a.f();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f3419a.toString() + ")";
    }
}
