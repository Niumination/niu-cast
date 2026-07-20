package jj;

import kotlin.jvm.internal.Intrinsics;
import qj.b0;
import qj.l;
import qj.s;
import qj.x;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f6318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f6320c;

    public b(g gVar) {
        this.f6320c = gVar;
        this.f6318a = new l(((s) gVar.f6334h).f9218a.b());
    }

    @Override // qj.x
    public final b0 b() {
        return this.f6318a;
    }

    @Override // qj.x, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f6319b) {
            return;
        }
        this.f6319b = true;
        ((s) this.f6320c.f6334h).v("0\r\n\r\n");
        g.i(this.f6320c, this.f6318a);
        this.f6320c.f6330b = 3;
    }

    @Override // qj.x, java.io.Flushable
    public final synchronized void flush() {
        if (this.f6319b) {
            return;
        }
        ((s) this.f6320c.f6334h).flush();
    }

    @Override // qj.x
    public final void k0(qj.f source, long j8) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f6319b) {
            throw new IllegalStateException("closed");
        }
        if (j8 == 0) {
            return;
        }
        g gVar = this.f6320c;
        s sVar = (s) gVar.f6334h;
        if (sVar.f9220c) {
            throw new IllegalStateException("closed");
        }
        sVar.f9219b.a0(j8);
        sVar.a();
        s sVar2 = (s) gVar.f6334h;
        sVar2.v("\r\n");
        sVar2.k0(source, j8);
        sVar2.v("\r\n");
    }
}
