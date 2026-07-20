package vj;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1914")
public final class q extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f17234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f17235b;

    public static final class a extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d.a f17236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v1 f17237b;

        public a(d.a aVar, v1 v1Var) {
            this.f17236a = aVar;
            this.f17237b = v1Var;
        }

        @Override // vj.d.a
        public void a(v1 v1Var) {
            c1.h0.F(v1Var, "headers");
            v1 v1Var2 = new v1();
            v1Var2.s(this.f17237b);
            v1Var2.s(v1Var);
            this.f17236a.a(v1Var2);
        }

        @Override // vj.d.a
        public void b(y2 y2Var) {
            this.f17236a.b(y2Var);
        }
    }

    public final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d.b f17238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f17239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d.a f17240c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final w f17241d;

        public b(d.b bVar, Executor executor, d.a aVar, w wVar) {
            this.f17238a = bVar;
            this.f17239b = executor;
            this.f17240c = (d.a) c1.h0.F(aVar, "delegate");
            this.f17241d = (w) c1.h0.F(wVar, "context");
        }

        @Override // vj.d.a
        public void a(v1 v1Var) {
            c1.h0.F(v1Var, "headers");
            w wVarC = this.f17241d.c();
            try {
                q.this.f17235b.a(this.f17238a, this.f17239b, new a(this.f17240c, v1Var));
            } finally {
                this.f17241d.q(wVarC);
            }
        }

        @Override // vj.d.a
        public void b(y2 y2Var) {
            this.f17240c.b(y2Var);
        }
    }

    public q(d dVar, d dVar2) {
        this.f17234a = (d) c1.h0.F(dVar, "creds1");
        this.f17235b = (d) c1.h0.F(dVar2, "creds2");
    }

    @Override // vj.d
    public void a(d.b bVar, Executor executor, d.a aVar) {
        this.f17234a.a(bVar, executor, new b(bVar, executor, aVar, w.o()));
    }
}
