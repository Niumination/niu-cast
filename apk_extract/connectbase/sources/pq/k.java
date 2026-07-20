package pq;

import kn.l0;
import lm.l2;
import vq.u0;
import vq.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    public static final int F = 60;
    public static final long G = 1152921504606846975L;
    public static final long H = 4611686018427387904L;
    public static final long I = 4611686018427387903L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f13269d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f13270e = Long.MAX_VALUE;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f13283r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f13284s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f13285t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f13286u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f13287v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f13288w = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final q<Object> f13266a = new q<>(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    public static final int f13267b = z0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13268c = z0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @in.f
    @os.l
    public static final u0 f13271f = new u0("BUFFERED");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final u0 f13272g = new u0("SHOULD_BUFFER");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final u0 f13273h = new u0("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final u0 f13274i = new u0("RESUMING_BY_EB");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final u0 f13275j = new u0("POISONED");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final u0 f13276k = new u0("DONE_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public static final u0 f13277l = new u0("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public static final u0 f13278m = new u0("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final u0 f13279n = new u0("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public static final u0 f13280o = new u0("SUSPEND");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final u0 f13281p = new u0("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public static final u0 f13282q = new u0("FAILED");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final u0 f13289x = new u0("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final u0 f13290y = new u0("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public static final u0 f13291z = new u0("CLOSE_HANDLER_INVOKED");

    @os.l
    public static final u0 A = new u0("NO_CLOSE_CAUSE");

    /* JADX INFO: Add missing generic type declarations: [E] */
    public /* synthetic */ class a<E> extends kn.h0 implements jn.p<Long, q<E>, q<E>> {
        public static final a INSTANCE = new a();

        public a() {
            super(2, k.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(Long l10, Object obj) {
            return invoke(l10.longValue(), (q) obj);
        }

        @os.l
        public final q<E> invoke(long j10, @os.l q<E> qVar) {
            return k.x(j10, qVar);
        }
    }

    public static final long A(long j10) {
        return j10 & 4611686018427387903L;
    }

    public static final boolean B(long j10) {
        return (j10 & 4611686018427387904L) != 0;
    }

    public static final int C(long j10) {
        return (int) (j10 >> 60);
    }

    public static final long D(long j10) {
        return j10 & G;
    }

    public static final long E(int i10) {
        if (i10 == 0) {
            return 0L;
        }
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        return Long.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean F(nq.p<? super T> pVar, T t10, jn.l<? super Throwable, l2> lVar) {
        Object objI = pVar.I(t10, null, lVar);
        if (objI == null) {
            return false;
        }
        pVar.M(objI);
        return true;
    }

    public static /* synthetic */ boolean G(nq.p pVar, Object obj, jn.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        return F(pVar, obj, lVar);
    }

    public static final long v(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j10;
    }

    public static final long w(long j10, int i10) {
        return (((long) i10) << 60) + j10;
    }

    public static final <E> q<E> x(long j10, q<E> qVar) {
        j<E> jVar = qVar.f13312e;
        l0.m(jVar);
        return new q<>(j10, qVar, jVar, 0);
    }

    @os.l
    public static final <E> un.i<q<E>> y() {
        return a.INSTANCE;
    }

    @os.l
    public static final u0 z() {
        return f13279n;
    }
}
