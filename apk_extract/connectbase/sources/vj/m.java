package vj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<Object, Object> f17169a = new b();

    public class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1.c f17170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w1.c f17171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f17172c;

        /* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
        /* JADX INFO: renamed from: vj.m$a$a, reason: collision with other inner class name */
        public class C0452a<ReqT, RespT> extends a2<ReqT, RespT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f17173a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w1 f17174b;

            /* JADX INFO: Add missing generic type declarations: [WRespT] */
            /* JADX INFO: renamed from: vj.m$a$a$a, reason: collision with other inner class name */
            public class C0453a<WRespT> extends b2<WRespT> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ k.a f17176a;

                public C0453a(k.a aVar) {
                    this.f17176a = aVar;
                }

                @Override // vj.k.a
                public void c(WRespT wrespt) {
                    this.f17176a.c(C0452a.this.f17174b.f17484e.c(a.this.f17171b.a(wrespt)));
                }

                @Override // vj.b2
                public k.a<?> e() {
                    return this.f17176a;
                }
            }

            public C0452a(k kVar, w1 w1Var) {
                this.f17173a = kVar;
                this.f17174b = w1Var;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // vj.k
            public void f(ReqT reqt) {
                this.f17173a.f(a.this.f17170a.c(this.f17174b.f17483d.a(reqt)));
            }

            @Override // vj.k
            public void h(k.a<RespT> aVar, v1 v1Var) {
                this.f17173a.h(new C0453a(aVar), v1Var);
            }

            @Override // vj.a2
            public k<?, ?> i() {
                return this.f17173a;
            }
        }

        public a(w1.c cVar, w1.c cVar2, l lVar) {
            this.f17170a = cVar;
            this.f17171b = cVar2;
            this.f17172c = lVar;
        }

        @Override // vj.l
        public <ReqT, RespT> k<ReqT, RespT> a(w1<ReqT, RespT> w1Var, e eVar, f fVar) {
            return new C0452a(this.f17172c.a(w1Var.x(this.f17170a, this.f17171b).a(), eVar, fVar), w1Var);
        }
    }

    public class b extends k<Object, Object> {
        @Override // vj.k
        public void a(String str, Throwable th2) {
        }

        @Override // vj.k
        public void c() {
        }

        @Override // vj.k
        public boolean d() {
            return false;
        }

        @Override // vj.k
        public void e(int i10) {
        }

        @Override // vj.k
        public void f(Object obj) {
        }

        @Override // vj.k
        public void h(k.a<Object> aVar, v1 v1Var) {
        }
    }

    public static abstract class c<ReqT, RespT> extends h0<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k<ReqT, RespT> f17178a;

        public c(k<ReqT, RespT> kVar) {
            this.f17178a = kVar;
        }

        @Override // vj.h0, vj.k
        public final void h(k.a<RespT> aVar, v1 v1Var) {
            try {
                j(aVar, v1Var);
            } catch (Exception e10) {
                this.f17178a = m.f17169a;
                v1 v1VarS = y2.s(e10);
                y2 y2VarN = y2.n(e10);
                if (v1VarS == null) {
                    v1VarS = new v1();
                }
                aVar.a(y2VarN, v1VarS);
            }
        }

        @Override // vj.h0, vj.a2
        public final k<ReqT, RespT> i() {
            return this.f17178a;
        }

        public abstract void j(k.a<RespT> aVar, v1 v1Var) throws Exception;
    }

    public static f b(f fVar, List<? extends l> list) {
        c1.h0.F(fVar, "channel");
        Iterator<? extends l> it = list.iterator();
        while (it.hasNext()) {
            fVar = new d(fVar, it.next());
        }
        return fVar;
    }

    public static f c(f fVar, l... lVarArr) {
        return b(fVar, Arrays.asList(lVarArr));
    }

    public static f d(f fVar, List<? extends l> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return b(fVar, arrayList);
    }

    public static f e(f fVar, l... lVarArr) {
        return d(fVar, Arrays.asList(lVarArr));
    }

    public static <WReqT, WRespT> l f(l lVar, w1.c<WReqT> cVar, w1.c<WRespT> cVar2) {
        return new a(cVar, cVar2, lVar);
    }

    public static class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f17179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l f17180b;

        public d(f fVar, l lVar) {
            this.f17179a = fVar;
            this.f17180b = (l) c1.h0.F(lVar, "interceptor");
        }

        @Override // vj.f
        public String b() {
            return this.f17179a.b();
        }

        @Override // vj.f
        public <ReqT, RespT> k<ReqT, RespT> g(w1<ReqT, RespT> w1Var, e eVar) {
            return this.f17180b.a(w1Var, eVar, this.f17179a);
        }

        public /* synthetic */ d(f fVar, l lVar, a aVar) {
            this(fVar, lVar);
        }
    }
}
