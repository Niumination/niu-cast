package yq;

import kn.n0;
import lm.l2;
import nq.g2;
import vq.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21733b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21734c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21735d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21736e = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final jn.q<Object, Object, Object, Object> f21732a = a.INSTANCE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final u0 f21737f = new u0("STATE_REG");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final u0 f21738g = new u0("STATE_COMPLETED");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final u0 f21739h = new u0("STATE_CANCELLED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final u0 f21740i = new u0("NO_RESULT");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final u0 f21741j = new u0("PARAM_CLAUSE_0");

    public static final class a extends n0 implements jn.q {
        public static final a INSTANCE = new a();

        public a() {
            super(3);
        }

        @Override // jn.q
        @os.m
        public final Void invoke(@os.l Object obj, @os.m Object obj2, @os.m Object obj3) {
            return null;
        }
    }

    @g2
    public static /* synthetic */ void a() {
    }

    @g2
    public static /* synthetic */ void b() {
    }

    @g2
    public static /* synthetic */ void c() {
    }

    public static final r d(int i10) {
        if (i10 == 0) {
            return r.SUCCESSFUL;
        }
        if (i10 == 1) {
            return r.REREGISTER;
        }
        if (i10 == 2) {
            return r.CANCELLED;
        }
        if (i10 == 3) {
            return r.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i10).toString());
    }

    @os.l
    public static final u0 l() {
        return f21741j;
    }

    @os.m
    public static final <R> Object m(@os.l jn.l<? super c<? super R>, l2> lVar, @os.l um.d<? super R> dVar) {
        l lVar2 = new l(dVar.getContext());
        lVar.invoke(lVar2);
        return l.z(lVar2, dVar);
    }

    public static final <R> Object n(jn.l<? super c<? super R>, l2> lVar, um.d<? super R> dVar) {
        throw null;
    }

    public static final boolean o(nq.p<? super l2> pVar, jn.l<? super Throwable, l2> lVar) {
        Object objI = pVar.I(l2.f10208a, null, lVar);
        if (objI == null) {
            return false;
        }
        pVar.M(objI);
        return true;
    }
}
