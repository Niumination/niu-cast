package jj;

import kotlin.jvm.internal.Intrinsics;
import qj.b0;
import qj.l;
import qj.s;
import qj.x;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f6325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f6327c;

    public e(g gVar) {
        this.f6327c = gVar;
        this.f6325a = new l(((s) gVar.f6334h).f9218a.b());
    }

    @Override // qj.x
    public final b0 b() {
        return this.f6325a;
    }

    @Override // qj.x, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6326b) {
            return;
        }
        this.f6326b = true;
        g gVar = this.f6327c;
        g.i(gVar, this.f6325a);
        gVar.f6330b = 3;
    }

    @Override // qj.x, java.io.Flushable
    public final void flush() {
        if (this.f6326b) {
            return;
        }
        ((s) this.f6327c.f6334h).flush();
    }

    @Override // qj.x
    public final void k0(qj.f source, long j8) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f6326b) {
            throw new IllegalStateException("closed");
        }
        ej.b.c(source.f9195b, 0L, j8);
        ((s) this.f6327c.f6334h).k0(source, j8);
    }
}
