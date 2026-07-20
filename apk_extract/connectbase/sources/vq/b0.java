package vq;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class b0<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17801a = AtomicReferenceFieldUpdater.newUpdater(b0.class, Object.class, "_cur");

    @os.m
    @in.x
    private volatile Object _cur;

    public b0(boolean z10) {
        this._cur = new c0(8, z10);
    }

    public final boolean a(@os.l E e10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17801a;
        while (true) {
            c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
            int iA = c0Var.a(e10);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                j.d.a(f17801a, this, c0Var, c0Var.m());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17801a;
        while (true) {
            c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
            if (c0Var.d()) {
                return;
            } else {
                j.d.a(f17801a, this, c0Var, c0Var.m());
            }
        }
    }

    public final int c() {
        return ((c0) f17801a.get(this)).f();
    }

    public final boolean d() {
        return ((c0) f17801a.get(this)).g();
    }

    public final boolean e() {
        return ((c0) f17801a.get(this)).h();
    }

    public final void f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @os.l
    public final <R> List<R> g(@os.l jn.l<? super E, ? extends R> lVar) {
        return ((c0) f17801a.get(this)).k(lVar);
    }

    @os.m
    public final E h() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17801a;
        while (true) {
            c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
            E e10 = (E) c0Var.n();
            if (e10 != c0.f17820t) {
                return e10;
            }
            j.d.a(f17801a, this, c0Var, c0Var.m());
        }
    }
}
