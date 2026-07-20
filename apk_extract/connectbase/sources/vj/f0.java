package vj;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import vj.s1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0<T extends s1<T>> extends s1<T> {
    @t1.e(RtspHeaders.Names.UNSUPPORTED)
    public static s1<?> l(String str, int i10) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @t1.e(RtspHeaders.Names.UNSUPPORTED)
    public static s1<?> m(String str) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @Override // vj.s1
    public T A(String str) {
        J().A(str);
        return this;
    }

    @Override // vj.s1
    public T B(long j10) {
        J().B(j10);
        return this;
    }

    @Override // vj.s1
    public T C(g2 g2Var) {
        J().C(g2Var);
        return this;
    }

    @Override // vj.s1
    public T D(long j10) {
        J().D(j10);
        return this;
    }

    @Override // vj.s1
    public T E(b bVar) {
        J().E(bVar);
        return this;
    }

    public final T F() {
        return this;
    }

    @Override // vj.s1
    public T G() {
        J().G();
        return this;
    }

    @Override // vj.s1
    public T H() {
        J().H();
        return this;
    }

    @Override // vj.s1
    public T I(String str) {
        J().I(str);
        return this;
    }

    public abstract s1<?> J();

    @Override // vj.s1
    public T a(o oVar) {
        J().a(oVar);
        return this;
    }

    @Override // vj.s1
    public r1 b() {
        return J().b();
    }

    @Override // vj.s1
    public T c(t tVar) {
        J().c(tVar);
        return this;
    }

    @Override // vj.s1
    public T d(a0 a0Var) {
        J().d(a0Var);
        return this;
    }

    @Override // vj.s1
    public T e(String str) {
        J().e(str);
        return this;
    }

    @Override // vj.s1
    public T f(@gm.j Map<String, ?> map) {
        J().f(map);
        return this;
    }

    @Override // vj.s1
    public T g() {
        J().g();
        return this;
    }

    @Override // vj.s1
    public T h() {
        J().h();
        return this;
    }

    @Override // vj.s1
    public T i() {
        J().i();
        return this;
    }

    @Override // vj.s1
    public T j() {
        J().j();
        return this;
    }

    @Override // vj.s1
    public T k(Executor executor) {
        J().k(executor);
        return this;
    }

    @Override // vj.s1
    public T n(long j10, TimeUnit timeUnit) {
        J().n(j10, timeUnit);
        return this;
    }

    @Override // vj.s1
    public T o(List<l> list) {
        J().o(list);
        return this;
    }

    @Override // vj.s1
    public T p(l... lVarArr) {
        J().p(lVarArr);
        return this;
    }

    @Override // vj.s1
    public T q(long j10, TimeUnit timeUnit) {
        J().q(j10, timeUnit);
        return this;
    }

    @Override // vj.s1
    public T r(long j10, TimeUnit timeUnit) {
        J().r(j10, timeUnit);
        return this;
    }

    @Override // vj.s1
    public T s(boolean z10) {
        J().s(z10);
        return this;
    }

    @Override // vj.s1
    public T t(int i10) {
        J().t(i10);
        return this;
    }

    public String toString() {
        return c1.z.c(this).j("delegate", J()).toString();
    }

    @Override // vj.s1
    public T u(int i10) {
        J().u(i10);
        return this;
    }

    @Override // vj.s1
    public T v(int i10) {
        J().v(i10);
        return this;
    }

    @Override // vj.s1
    public T w(int i10) {
        J().w(i10);
        return this;
    }

    @Override // vj.s1
    public T x(int i10) {
        J().x(i10);
        return this;
    }

    @Override // vj.s1
    @Deprecated
    public T y(x1.d dVar) {
        J().y(dVar);
        return this;
    }

    @Override // vj.s1
    public T z(Executor executor) {
        J().z(executor);
        return this;
    }
}
