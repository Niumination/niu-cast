package ck;

import java.util.concurrent.ExecutionException;
import q1.l2;
import q1.n0;
import vj.a3;
import vj.e0;
import vj.k0;
import vj.k2;
import vj.l0;
import vj.m2;
import vj.o2;
import vj.v1;
import vj.y2;
import wj.t2;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/2189")
public final class q implements o2 {

    /* JADX INFO: Add missing generic type declarations: [ReqT] */
    public class a<ReqT> extends l0.a<ReqT> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k2 f1620b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k2.a aVar, k2 k2Var) {
            super(aVar);
            this.f1620b = k2Var;
        }

        @Override // vj.l0.a, vj.l0, vj.d2, vj.k2.a
        public void a() {
            try {
                super.a();
            } catch (a3 e10) {
                g(e10);
            }
        }

        @Override // vj.l0.a, vj.l0, vj.d2, vj.k2.a
        public void b() {
            try {
                super.b();
            } catch (a3 e10) {
                g(e10);
            }
        }

        @Override // vj.l0.a, vj.l0, vj.d2, vj.k2.a
        public void c() {
            try {
                super.c();
            } catch (a3 e10) {
                g(e10);
            }
        }

        @Override // vj.l0, vj.k2.a
        public void d(ReqT reqt) {
            try {
                super.d(reqt);
            } catch (a3 e10) {
                g(e10);
            }
        }

        @Override // vj.l0.a, vj.l0, vj.d2, vj.k2.a
        public void e() {
            try {
                super.e();
            } catch (a3 e10) {
                g(e10);
            }
        }

        public final void g(a3 a3Var) {
            v1 trailers = a3Var.getTrailers();
            if (trailers == null) {
                trailers = new v1();
            }
            this.f1620b.a(a3Var.getStatus(), trailers);
        }
    }

    public static class b<ReqT, RespT> extends k0.a<ReqT, RespT> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f1622d = "Encountered error during serialized access";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t2 f1623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1624c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l2 f1625a;

            public a(l2 l2Var) {
                this.f1625a = l2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1625a.B(b.super.b());
            }
        }

        /* JADX INFO: renamed from: ck.q$b$b, reason: collision with other inner class name */
        public class RunnableC0068b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l2 f1627a;

            public RunnableC0068b(l2 l2Var) {
                this.f1627a = l2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1627a.B(b.super.c());
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f1629a;

            public c(Object obj) {
                this.f1629a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.super.j(this.f1629a);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f1631a;

            public d(int i10) {
                this.f1631a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.super.h(this.f1631a);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v1 f1633a;

            public e(v1 v1Var) {
                this.f1633a = v1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.super.i(this.f1633a);
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y2 f1635a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v1 f1636b;

            public f(y2 y2Var, v1 v1Var) {
                this.f1635a = y2Var;
                this.f1636b = v1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                if (bVar.f1624c) {
                    return;
                }
                bVar.f1624c = true;
                b.super.a(this.f1635a, this.f1636b);
            }
        }

        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l2 f1638a;

            public g(l2 l2Var) {
                this.f1638a = l2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1638a.B(Boolean.valueOf(b.super.g()));
            }
        }

        public class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l2 f1640a;

            public h(l2 l2Var) {
                this.f1640a = l2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1640a.B(Boolean.valueOf(b.super.f()));
            }
        }

        public class i implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f1642a;

            public i(boolean z10) {
                this.f1642a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.super.l(this.f1642a);
            }
        }

        public class j implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f1644a;

            public j(int i10) {
                this.f1644a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.super.m(this.f1644a);
            }
        }

        public class k implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f1646a;

            public k(String str) {
                this.f1646a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.super.k(this.f1646a);
            }
        }

        public b(k2<ReqT, RespT> k2Var) {
            super(k2Var);
            this.f1623b = new t2(n0.INSTANCE);
            this.f1624c = false;
        }

        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        public void a(y2 y2Var, v1 v1Var) {
            this.f1623b.execute(new f(y2Var, v1Var));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        public vj.a b() {
            l2 l2VarF = l2.F();
            this.f1623b.execute(new a(l2VarF));
            try {
                return (vj.a) l2VarF.get();
            } catch (InterruptedException e10) {
                throw new RuntimeException(f1622d, e10);
            } catch (ExecutionException e11) {
                throw new RuntimeException(f1622d, e11);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        @gm.j
        public String c() {
            l2 l2VarF = l2.F();
            this.f1623b.execute(new RunnableC0068b(l2VarF));
            try {
                return (String) l2VarF.get();
            } catch (InterruptedException e10) {
                throw new RuntimeException(f1622d, e10);
            } catch (ExecutionException e11) {
                throw new RuntimeException(f1622d, e11);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        public boolean f() {
            l2 l2VarF = l2.F();
            this.f1623b.execute(new h(l2VarF));
            try {
                return ((Boolean) l2VarF.get()).booleanValue();
            } catch (InterruptedException e10) {
                throw new RuntimeException(f1622d, e10);
            } catch (ExecutionException e11) {
                throw new RuntimeException(f1622d, e11);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        public boolean g() {
            l2 l2VarF = l2.F();
            this.f1623b.execute(new g(l2VarF));
            try {
                return ((Boolean) l2VarF.get()).booleanValue();
            } catch (InterruptedException e10) {
                throw new RuntimeException(f1622d, e10);
            } catch (ExecutionException e11) {
                throw new RuntimeException(f1622d, e11);
            }
        }

        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        public void h(int i10) {
            this.f1623b.execute(new d(i10));
        }

        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        public void i(v1 v1Var) {
            this.f1623b.execute(new e(v1Var));
        }

        @Override // vj.k0, vj.k2
        public void j(RespT respt) {
            this.f1623b.execute(new c(respt));
        }

        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        public void k(String str) {
            this.f1623b.execute(new k(str));
        }

        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        public void l(boolean z10) {
            this.f1623b.execute(new i(z10));
        }

        @Override // vj.k0.a, vj.k0, vj.c2, vj.k2
        @e0("https://github.com/grpc/grpc-java/issues/11021")
        public void m(int i10) {
            this.f1623b.execute(new j(i10));
        }
    }

    public static o2 b() {
        return new q();
    }

    @Override // vj.o2
    public <ReqT, RespT> k2.a<ReqT> a(k2<ReqT, RespT> k2Var, v1 v1Var, m2<ReqT, RespT> m2Var) {
        b bVar = new b(k2Var);
        return new a(m2Var.a(bVar, v1Var), bVar);
    }
}
