package xq;

import nq.a2;
import nq.n0;
import vq.v;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final d f20498g = new d();

    public d() {
        super(o.f20522c, o.f20523d, o.f20524e, o.f20520a);
    }

    public final void J0() {
        super.close();
    }

    @Override // xq.i, nq.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // nq.n0
    @a2
    @os.l
    public n0 limitedParallelism(int i10) {
        v.a(i10);
        return i10 >= o.f20522c ? this : super.limitedParallelism(i10);
    }

    @Override // nq.n0
    @os.l
    public String toString() {
        return "Dispatchers.Default";
    }
}
