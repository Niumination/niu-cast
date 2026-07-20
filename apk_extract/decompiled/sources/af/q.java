package af;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cf.j f520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z2 f521b;

    public q(cf.j jVar, z2 z2Var) {
        this.f520a = jVar;
        this.f521b = z2Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f520a.close();
    }
}
