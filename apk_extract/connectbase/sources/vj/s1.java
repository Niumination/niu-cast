package vj;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import vj.s1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s1<T extends s1<T>> {
    private T F() {
        return this;
    }

    public static s1<?> l(String str, int i10) {
        return t1.g().a(str, i10);
    }

    public static s1<?> m(String str) {
        return t1.g().b(str);
    }

    public abstract T A(String str);

    @e0("https://github.com/grpc/grpc-java/issues/3982")
    public T B(long j10) {
        throw new UnsupportedOperationException();
    }

    public T C(g2 g2Var) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/3982")
    public T D(long j10) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/4017")
    public T E(b bVar) {
        throw new UnsupportedOperationException();
    }

    public T G() {
        throw new UnsupportedOperationException();
    }

    public T H() {
        throw new UnsupportedOperationException();
    }

    public abstract T I(String str);

    @e0("https://github.com/grpc/grpc-java/issues/10652")
    public T a(o oVar) {
        throw new UnsupportedOperationException();
    }

    public abstract r1 b();

    @e0("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T c(t tVar);

    @e0("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T d(a0 a0Var);

    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public T e(String str) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/5189")
    public T f(@gm.j Map<String, ?> map) {
        throw new UnsupportedOperationException();
    }

    public abstract T g();

    public T h() {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/5189")
    public T i() {
        throw new UnsupportedOperationException();
    }

    public T j() {
        throw new UnsupportedOperationException();
    }

    public abstract T k(Executor executor);

    @e0("https://github.com/grpc/grpc-java/issues/2022")
    public abstract T n(long j10, TimeUnit timeUnit);

    public abstract T o(List<l> list);

    public abstract T p(l... lVarArr);

    public T q(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T r(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T s(boolean z10) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/3982")
    public T t(int i10) {
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

    @e0("https://github.com/grpc/grpc-java/issues/3982")
    public T w(int i10) {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/4471")
    public T x(int i10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @e0("https://github.com/grpc/grpc-java/issues/1770")
    public abstract T y(x1.d dVar);

    public T z(Executor executor) {
        throw new UnsupportedOperationException();
    }
}
