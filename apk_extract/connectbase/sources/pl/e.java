package pl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    public static final class a extends pl.a {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ boolean f13189t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ jn.l<Throwable, Throwable> f13190u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean z10, jn.l<? super Throwable, ? extends Throwable> lVar) {
            super(z10, null, 0, 6, null);
            this.f13189t = z10;
            this.f13190u = lVar;
        }

        @Override // pl.a, pl.n
        public boolean f(@os.m Throwable th2) {
            return super.f(this.f13190u.invoke(th2));
        }
    }

    @os.l
    public static final c a(boolean z10) {
        return new pl.a(z10, null, 0, 6, null);
    }

    @tl.f0
    @os.l
    public static final c b(boolean z10, @os.l jn.l<? super Throwable, ? extends Throwable> lVar) {
        kn.l0.p(lVar, "exceptionMapper");
        return new a(z10, lVar);
    }

    public static /* synthetic */ c c(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }

    public static /* synthetic */ c d(boolean z10, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return b(z10, lVar);
    }

    @os.l
    public static final k e(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, t2.a.f15437d);
        return new pl.a(byteBuffer);
    }

    @os.l
    public static final k f(@os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, t2.a.f15437d);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i10, i11);
        kn.l0.o(byteBufferWrap, "wrap(content, offset, length)");
        return new pl.a(byteBufferWrap);
    }
}
