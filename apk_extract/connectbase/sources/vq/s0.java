package vq;

import vq.r0;

/* JADX INFO: loaded from: classes3.dex */
@in.g
public final class s0<S extends r0<S>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final Object f17879a;

    public /* synthetic */ s0(Object obj) {
        this.f17879a = obj;
    }

    public static final /* synthetic */ s0 a(Object obj) {
        return new s0(obj);
    }

    @os.l
    public static <S extends r0<S>> Object b(@os.m Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof s0) && kn.l0.g(obj, ((s0) obj2).f17879a);
    }

    public static final boolean d(Object obj, Object obj2) {
        return kn.l0.g(obj, obj2);
    }

    public static /* synthetic */ void e() {
    }

    @os.l
    public static final S f(Object obj) {
        if (obj == f.f17836b) {
            throw new IllegalStateException("Does not contain segment");
        }
        kn.l0.n(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj == f.f17836b;
    }

    public static String i(Object obj) {
        return em.a.a("SegmentOrClosed(value=", obj, ')');
    }

    public boolean equals(Object obj) {
        return c(this.f17879a, obj);
    }

    public int hashCode() {
        return g(this.f17879a);
    }

    public final /* synthetic */ Object j() {
        return this.f17879a;
    }

    public String toString() {
        return i(this.f17879a);
    }
}
