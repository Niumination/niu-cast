package pq;

import lm.a1;
import vq.z0;

/* JADX INFO: loaded from: classes3.dex */
public interface l<E> extends g0<E>, f0<E> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public static final b f13292l = b.f13299a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13293m = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f13294o = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f13295q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f13296r = -2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f13297s = -3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public static final String f13298t = "kotlinx.coroutines.channels.defaultBuffer";

    public static final class a {
        @os.l
        public static <E> yq.g<E> b(@os.l l<E> lVar) {
            return f0.a.d(lVar);
        }

        @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@os.l l<E> lVar, E e10) {
            return g0.a.c(lVar, e10);
        }

        @os.m
        @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @a1(expression = "tryReceive().getOrNull()", imports = {}))
        public static <E> E d(@os.l l<E> lVar) {
            return (E) f0.a.h(lVar);
        }

        @an.h
        @os.m
        @lm.k(level = lm.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @a1(expression = "receiveCatching().getOrNull()", imports = {}))
        public static <E> Object e(@os.l l<E> lVar, @os.l um.d<? super E> dVar) {
            return f0.a.i(lVar, dVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f13300b = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f13301c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f13302d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f13303e = -2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f13304f = -3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final String f13305g = "kotlinx.coroutines.channels.defaultBuffer";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f13299a = new b();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f13306h = z0.a("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        public final int a() {
            return f13306h;
        }
    }
}
