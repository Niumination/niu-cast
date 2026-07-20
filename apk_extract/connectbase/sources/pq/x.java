package pq;

import java.util.concurrent.CancellationException;
import lm.a1;
import lm.l2;
import nq.c3;

/* JADX INFO: loaded from: classes3.dex */
@lm.k(level = lm.m.WARNING, message = "ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@c3
public final class x<E> implements d<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final e<E> f13315a;

    public x(e<E> eVar) {
        this.f13315a = eVar;
    }

    @Override // pq.g0
    public boolean J() {
        return this.f13315a.J();
    }

    @Override // pq.g0
    @os.m
    public Object L(E e10, @os.l um.d<? super l2> dVar) {
        return this.f13315a.L(e10, dVar);
    }

    @Override // pq.d
    public void b(@os.m CancellationException cancellationException) {
        this.f13315a.R(cancellationException);
    }

    @Override // pq.d
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility only")
    public boolean c(Throwable th2) {
        return this.f13315a.R(th2);
    }

    public final E d() {
        return this.f13315a.M1();
    }

    @os.m
    public final E e() {
        return this.f13315a.O1();
    }

    @Override // pq.g0
    public boolean f(@os.m Throwable th2) {
        return this.f13315a.f(th2);
    }

    @Override // pq.g0
    public void i(@os.l jn.l<? super Throwable, l2> lVar) {
        this.f13315a.i(lVar);
    }

    @Override // pq.g0
    @os.l
    public yq.i<E, g0<E>> m() {
        return this.f13315a.m();
    }

    @Override // pq.g0
    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        e<E> eVar = this.f13315a;
        eVar.getClass();
        return g0.a.c(eVar, e10);
    }

    @Override // pq.d
    @os.l
    public f0<E> v() {
        return this.f13315a.v();
    }

    @Override // pq.g0
    @os.l
    public Object w(E e10) {
        return this.f13315a.w(e10);
    }

    public x() {
        this(new e(-1));
    }

    public x(E e10) {
        this();
        w(e10);
    }
}
