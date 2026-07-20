package vj;

import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    public static class a<ReqT> extends l0.a<ReqT> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w f17505b;

        public a(k2.a<ReqT> aVar, w wVar) {
            super(aVar);
            this.f17505b = wVar;
        }

        @Override // vj.l0.a, vj.l0, vj.d2, vj.k2.a
        public void a() {
            w wVarC = this.f17505b.c();
            try {
                super.a();
            } finally {
                this.f17505b.q(wVarC);
            }
        }

        @Override // vj.l0.a, vj.l0, vj.d2, vj.k2.a
        public void b() {
            w wVarC = this.f17505b.c();
            try {
                super.b();
            } finally {
                this.f17505b.q(wVarC);
            }
        }

        @Override // vj.l0.a, vj.l0, vj.d2, vj.k2.a
        public void c() {
            w wVarC = this.f17505b.c();
            try {
                super.c();
            } finally {
                this.f17505b.q(wVarC);
            }
        }

        @Override // vj.l0, vj.k2.a
        public void d(ReqT reqt) {
            w wVarC = this.f17505b.c();
            try {
                super.d(reqt);
            } finally {
                this.f17505b.q(wVarC);
            }
        }

        @Override // vj.l0.a, vj.l0, vj.d2, vj.k2.a
        public void e() {
            w wVarC = this.f17505b.c();
            try {
                super.e();
            } finally {
                this.f17505b.q(wVarC);
            }
        }
    }

    public static <ReqT, RespT> k2.a<ReqT> a(w wVar, k2<ReqT, RespT> k2Var, v1 v1Var, m2<ReqT, RespT> m2Var) {
        w wVarC = wVar.c();
        try {
            return new a(m2Var.a(k2Var, v1Var), wVar);
        } finally {
            wVar.q(wVarC);
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/1975")
    public static y2 b(w wVar) {
        c1.h0.F(wVar, "context must not be null");
        if (!wVar.E()) {
            return null;
        }
        Throwable thK = wVar.k();
        if (thK == null) {
            return y2.f17549f.u("io.grpc.Context was cancelled without error");
        }
        if (thK instanceof TimeoutException) {
            return y2.f17552i.u(thK.getMessage()).t(thK);
        }
        y2 y2VarN = y2.n(thK);
        return (y2.b.UNKNOWN.equals(y2VarN.f17568a) && y2VarN.f17570c == thK) ? y2.f17549f.u("Context cancelled").t(thK) : y2VarN.t(thK);
    }
}
