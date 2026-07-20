package vj;

/* JADX INFO: loaded from: classes2.dex */
public final class q2<ReqT, RespT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w1<ReqT, RespT> f17252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m2<ReqT, RespT> f17253b;

    public q2(w1<ReqT, RespT> w1Var, m2<ReqT, RespT> m2Var) {
        this.f17252a = w1Var;
        this.f17253b = m2Var;
    }

    public static <ReqT, RespT> q2<ReqT, RespT> a(w1<ReqT, RespT> w1Var, m2<ReqT, RespT> m2Var) {
        return new q2<>(w1Var, m2Var);
    }

    public w1<ReqT, RespT> b() {
        return this.f17252a;
    }

    public m2<ReqT, RespT> c() {
        return this.f17253b;
    }

    public q2<ReqT, RespT> d(m2<ReqT, RespT> m2Var) {
        return new q2<>(this.f17252a, m2Var);
    }
}
