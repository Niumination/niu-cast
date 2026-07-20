package tl;

import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 extends bm.j<ul.b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ByteBuffer f15803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.l<ByteBuffer, l2> f15804d;

    /* JADX WARN: Multi-variable type inference failed */
    public b1(@os.l ByteBuffer byteBuffer, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(byteBuffer, "instance");
        kn.l0.p(lVar, "release");
        this.f15803c = byteBuffer;
        this.f15804d = lVar;
    }

    @Override // bm.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(@os.l ul.b bVar) {
        kn.l0.p(bVar, "instance");
        if (!(bVar instanceof o0)) {
            throw new IllegalStateException("Only IoBuffer could be recycled");
        }
        this.f15804d.invoke(this.f15803c);
    }

    @os.l
    public final ByteBuffer h() {
        return this.f15803c;
    }

    @os.l
    public final jn.l<ByteBuffer, l2> k() {
        return this.f15804d;
    }

    @Override // bm.j
    @os.l
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ul.b c() {
        return new o0(this.f15803c, this);
    }
}
