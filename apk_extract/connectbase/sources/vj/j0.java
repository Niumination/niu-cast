package vj;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import vj.j2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j0<T extends j2<T>> extends j2<T> {
    @t1.e(RtspHeaders.Names.UNSUPPORTED)
    public static j2<?> m(int i10) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @Override // vj.j2
    public T A(File file, File file2) {
        C().A(file, file2);
        return this;
    }

    @Override // vj.j2
    public T B(InputStream inputStream, InputStream inputStream2) {
        C().B(inputStream, inputStream2);
        return this;
    }

    public abstract j2<?> C();

    @Override // vj.j2
    public T a(c cVar) {
        C().a(cVar);
        return this;
    }

    @Override // vj.j2
    public T b(t2 t2Var) {
        C().b(t2Var);
        return this;
    }

    @Override // vj.j2
    public T d(u2.a aVar) {
        C().d(aVar);
        return this;
    }

    @Override // vj.j2
    public T e(v2 v2Var) {
        C().e(v2Var);
        return this;
    }

    @Override // vj.j2
    public i2 f() {
        return C().f();
    }

    @Override // vj.j2
    public T g(l2 l2Var) {
        C().g(l2Var);
        return this;
    }

    @Override // vj.j2
    public T h(@gm.j t tVar) {
        C().h(tVar);
        return this;
    }

    @Override // vj.j2
    public T i(@gm.j a0 a0Var) {
        C().i(a0Var);
        return this;
    }

    @Override // vj.j2
    public T j() {
        C().j();
        return this;
    }

    @Override // vj.j2
    public T k(@gm.j Executor executor) {
        C().k(executor);
        return this;
    }

    @Override // vj.j2
    public T l(@gm.j o0 o0Var) {
        C().l(o0Var);
        return this;
    }

    @Override // vj.j2
    public T n(long j10, TimeUnit timeUnit) {
        C().n(j10, timeUnit);
        return this;
    }

    @Override // vj.j2
    public T o(o2 o2Var) {
        C().o(o2Var);
        return this;
    }

    @Override // vj.j2
    public T p(long j10, TimeUnit timeUnit) {
        C().p(j10, timeUnit);
        return this;
    }

    @Override // vj.j2
    public T q(long j10, TimeUnit timeUnit) {
        C().q(j10, timeUnit);
        return this;
    }

    @Override // vj.j2
    public T r(long j10, TimeUnit timeUnit) {
        C().r(j10, timeUnit);
        return this;
    }

    @Override // vj.j2
    public T s(long j10, TimeUnit timeUnit) {
        C().s(j10, timeUnit);
        return this;
    }

    @Override // vj.j2
    public T t(long j10, TimeUnit timeUnit) {
        C().t(j10, timeUnit);
        return this;
    }

    public String toString() {
        return c1.z.c(this).j("delegate", C()).toString();
    }

    @Override // vj.j2
    public T u(int i10) {
        C().u(i10);
        return this;
    }

    @Override // vj.j2
    public T v(int i10) {
        C().v(i10);
        return this;
    }

    @Override // vj.j2
    public T w(long j10, TimeUnit timeUnit) {
        C().w(j10, timeUnit);
        return this;
    }

    @Override // vj.j2
    public T x(boolean z10) {
        C().x(z10);
        return this;
    }

    @Override // vj.j2
    public T y(b bVar) {
        C().y(bVar);
        return this;
    }

    public final T z() {
        return this;
    }
}
