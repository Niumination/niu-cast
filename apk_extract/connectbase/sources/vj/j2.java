package vj;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import vj.j2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j2<T extends j2<T>> {
    public static j2<?> m(int i10) {
        return r2.e().a(i10);
    }

    private T z() {
        return this;
    }

    public abstract T A(File file, File file2);

    public T B(InputStream inputStream, InputStream inputStream2) {
        throw new UnsupportedOperationException();
    }

    public abstract T a(c cVar);

    public abstract T b(t2 t2Var);

    @e0("https://github.com/grpc/grpc-java/issues/7925")
    public final T c(List<t2> list) {
        c1.h0.F(list, "services");
        Iterator<t2> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        return this;
    }

    @e0("https://github.com/grpc/grpc-java/issues/2861")
    public T d(u2.a aVar) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/2132")
    public T e(v2 v2Var) {
        throw new UnsupportedOperationException();
    }

    public abstract i2 f();

    @e0("https://github.com/grpc/grpc-java/issues/8274")
    public T g(l2 l2Var) {
        return this;
    }

    @e0("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T h(@gm.j t tVar);

    @e0("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T i(@gm.j a0 a0Var);

    public abstract T j();

    public abstract T k(@gm.j Executor executor);

    public abstract T l(@gm.j o0 o0Var);

    public T n(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T o(o2 o2Var) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/9009")
    public T p(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/9009")
    public T q(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/9009")
    public T r(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/9009")
    public T s(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/9009")
    public T t(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T u(int i10) {
        c1.h0.e(i10 >= 0, "bytes must be >= 0");
        return this;
    }

    public T v(int i10) {
        c1.h0.e(i10 > 0, "maxInboundMetadataSize must be > 0");
        return this;
    }

    @e0("https://github.com/grpc/grpc-java/issues/9009")
    public T w(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/9009")
    public T x(boolean z10) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/4017")
    public T y(b bVar) {
        throw new UnsupportedOperationException();
    }
}
