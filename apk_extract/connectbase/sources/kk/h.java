package kk;

import java.io.Closeable;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final f f9221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final lk.c f9222b;

    public h(@os.l f fVar, @os.l lk.c cVar) {
        l0.p(fVar, "headers");
        l0.p(cVar, "builder");
        this.f9221a = fVar;
        this.f9222b = cVar;
    }

    @os.l
    public final f b() {
        return this.f9221a;
    }

    public final void c() {
        this.f9222b.r();
        this.f9221a.j();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c();
    }
}
