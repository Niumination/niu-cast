package vj;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public abstract class r1 extends f {
    public abstract boolean h(long j10, TimeUnit timeUnit) throws InterruptedException;

    @e0("https://github.com/grpc/grpc-java/issues/4056")
    public void i() {
    }

    @e0("https://github.com/grpc/grpc-java/issues/4359")
    public u l(boolean z10) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public abstract boolean o();

    public abstract boolean p();

    @e0("https://github.com/grpc/grpc-java/issues/4359")
    public void q(u uVar, Runnable runnable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @e0("https://github.com/grpc/grpc-java/issues/4056")
    public void r() {
    }

    public abstract r1 s();

    public abstract r1 t();
}
