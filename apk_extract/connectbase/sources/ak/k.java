package ak;

import c1.h0;
import vj.e0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k<RespT> extends e<RespT> {
    @Override // ak.e
    public abstract boolean e();

    @Override // ak.e
    public abstract void f(int i10);

    @Override // ak.e
    public abstract void g(boolean z10);

    @Override // ak.e
    public abstract void h(Runnable runnable);

    public void i() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean j();

    public abstract void k(String str);

    public abstract void l(Runnable runnable);

    @e0("https://github.com/grpc/grpc-java/issues/8467")
    public void m(Runnable runnable) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/11021")
    public void n(int i10) {
        h0.k(i10 > 0, "numBytes must be positive: %s", i10);
    }
}
