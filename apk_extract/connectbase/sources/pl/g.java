package pl;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private volatile boolean closed;

    @os.m
    private volatile Throwable closedCause;
    private volatile int lastReadAvailable;

    @os.l
    private volatile ul.b lastReadView;

    @os.l
    private volatile tl.q readByteOrder;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;

    @os.l
    private volatile tl.q writeByteOrder;

    public g() {
        tl.q qVar = tl.q.BIG_ENDIAN;
        this.readByteOrder = qVar;
        this.writeByteOrder = qVar;
        this.lastReadView = ul.b.f16311i.a();
    }

    public final boolean a() {
        return this.closed;
    }

    @os.m
    public final Throwable b() {
        return this.closedCause;
    }

    public final int c() {
        return this.lastReadAvailable;
    }

    @os.l
    public final ul.b d() {
        return this.lastReadView;
    }

    @os.l
    public final tl.q e() {
        return this.readByteOrder;
    }

    public final long f() {
        return this.totalBytesRead;
    }

    public final long g() {
        return this.totalBytesWritten;
    }

    @os.l
    public final tl.q h() {
        return this.writeByteOrder;
    }

    public final void i(boolean z10) {
        this.closed = z10;
    }

    public final void j(@os.m Throwable th2) {
        this.closedCause = th2;
    }

    public final void k(int i10) {
        this.lastReadAvailable = i10;
    }

    public final void l(@os.l ul.b bVar) {
        kn.l0.p(bVar, "<set-?>");
        this.lastReadView = bVar;
    }

    public final void m(@os.l tl.q qVar) {
        kn.l0.p(qVar, "<set-?>");
        this.readByteOrder = qVar;
    }

    public final void n(long j10) {
        this.totalBytesRead = j10;
    }

    public final void o(long j10) {
        this.totalBytesWritten = j10;
    }

    public final void p(@os.l tl.q qVar) {
        kn.l0.p(qVar, "<set-?>");
        this.writeByteOrder = qVar;
    }
}
