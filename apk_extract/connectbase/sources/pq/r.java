package pq;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lm.l2;
import lm.t0;
import lm.z0;
import nq.c3;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f13314a = "Channel was closed";

    @z0
    @os.l
    public static final <E, R> f0<R> J(@os.l f0<? extends E> f0Var, @os.l um.g gVar, @os.l jn.p<? super E, ? super um.d<? super R>, ? extends Object> pVar) {
        return u.E(f0Var, gVar, pVar);
    }

    @z0
    @os.l
    public static final <E, R> f0<R> L(@os.l f0<? extends E> f0Var, @os.l um.g gVar, @os.l jn.q<? super Integer, ? super E, ? super um.d<? super R>, ? extends Object> qVar) {
        return u.G(f0Var, gVar, qVar);
    }

    @z0
    public static final void b(@os.l f0<?> f0Var, @os.m Throwable th2) {
        t.a(f0Var, th2);
    }

    @lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @c3
    public static final <E, R> R c(@os.l d<E> dVar, @os.l jn.l<? super f0<? extends E>, ? extends R> lVar) {
        return (R) t.b(dVar, lVar);
    }

    public static final <E, R> R d(@os.l f0<? extends E> f0Var, @os.l jn.l<? super f0<? extends E>, ? extends R> lVar) {
        return (R) t.c(f0Var, lVar);
    }

    @os.m
    @lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object e(@os.l d<E> dVar, @os.l jn.l<? super E, l2> lVar, @os.l um.d<? super l2> dVar2) {
        return t.d(dVar, lVar, dVar2);
    }

    @os.m
    @z0
    public static final <E, C extends g0<? super E>> Object e0(@os.l f0<? extends E> f0Var, @os.l C c10, @os.l um.d<? super C> dVar) {
        return u.W(f0Var, c10, dVar);
    }

    @os.m
    public static final <E> Object f(@os.l f0<? extends E> f0Var, @os.l jn.l<? super E, l2> lVar, @os.l um.d<? super l2> dVar) {
        return t.e(f0Var, lVar, dVar);
    }

    @os.m
    @z0
    public static final <E, C extends Collection<? super E>> Object f0(@os.l f0<? extends E> f0Var, @os.l C c10, @os.l um.d<? super C> dVar) {
        return u.X(f0Var, c10, dVar);
    }

    @z0
    @os.l
    public static final jn.l<Throwable, l2> g(@os.l f0<?> f0Var) {
        return new u.b(f0Var);
    }

    @os.m
    public static final <E> Object g0(@os.l f0<? extends E> f0Var, @os.l um.d<? super List<? extends E>> dVar) {
        return t.j(f0Var, dVar);
    }

    @z0
    @os.l
    public static final jn.l<Throwable, l2> h(@os.l f0<?>... f0VarArr) {
        return new u.c(f0VarArr);
    }

    @os.m
    @z0
    public static final <K, V, M extends Map<? super K, ? super V>> Object h0(@os.l f0<? extends t0<? extends K, ? extends V>> f0Var, @os.l M m10, @os.l um.d<? super M> dVar) {
        return u.Y(f0Var, m10, dVar);
    }

    @z0
    @os.l
    public static final <E, K> f0<E> k(@os.l f0<? extends E> f0Var, @os.l um.g gVar, @os.l jn.p<? super E, ? super um.d<? super K>, ? extends Object> pVar) {
        return u.f(f0Var, gVar, pVar);
    }

    @os.m
    @z0
    public static final <E> Object k0(@os.l f0<? extends E> f0Var, @os.l um.d<? super Set<E>> dVar) {
        return u.b0(f0Var, dVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object l0(f0 f0Var, um.d dVar) {
        return u.b0(f0Var, dVar);
    }

    @os.l
    public static final <E> Object m0(@os.l g0<? super E> g0Var, E e10) {
        return s.b(g0Var, e10);
    }

    @z0
    @os.l
    public static final <E, R, V> f0<V> q0(@os.l f0<? extends E> f0Var, @os.l f0<? extends R> f0Var2, @os.l um.g gVar, @os.l jn.p<? super E, ? super R, ? extends V> pVar) {
        return u.g0(f0Var, f0Var2, gVar, pVar);
    }

    @z0
    @os.l
    public static final <E> f0<E> s(@os.l f0<? extends E> f0Var, @os.l um.g gVar, @os.l jn.p<? super E, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return u.n(f0Var, gVar, pVar);
    }

    @z0
    @os.l
    public static final <E> f0<E> y(@os.l f0<? extends E> f0Var) {
        return u.t(f0Var);
    }
}
