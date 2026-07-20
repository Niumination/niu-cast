package vj;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class p2 {

    public class a implements w1.c<InputStream> {
        @Override // vj.w1.c
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public InputStream c(InputStream inputStream) {
            if (inputStream.markSupported()) {
                return inputStream;
            }
            return inputStream instanceof n1 ? new d(inputStream) : new BufferedInputStream(inputStream);
        }

        @Override // vj.w1.c
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public InputStream a(InputStream inputStream) {
            return inputStream;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [WRespT, WReqT] */
    public class b<WReqT, WRespT> implements m2<WReqT, WRespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f17225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w1 f17226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m2 f17227c;

        /* JADX INFO: Add missing generic type declarations: [OReqT, ORespT] */
        public class a<OReqT, ORespT> extends c2<OReqT, ORespT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k2 f17228a;

            public a(k2 k2Var) {
                this.f17228a = k2Var;
            }

            @Override // vj.k2
            public w1<OReqT, ORespT> d() {
                return b.this.f17225a;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // vj.k2
            public void j(ORespT orespt) {
                n().j(b.this.f17226b.f17484e.c(b.this.f17225a.f17484e.a((RespT) orespt)));
            }

            @Override // vj.c2
            public k2<WReqT, WRespT> n() {
                return this.f17228a;
            }
        }

        /* JADX INFO: renamed from: vj.p2$b$b, reason: collision with other inner class name */
        public class C0455b extends d2<WReqT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k2.a f17230a;

            public C0455b(k2.a aVar) {
                this.f17230a = aVar;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // vj.k2.a
            public void d(WReqT wreqt) {
                f().d(b.this.f17225a.f17483d.c(b.this.f17226b.f17483d.a((ReqT) wreqt)));
            }

            @Override // vj.d2
            public k2.a<OReqT> f() {
                return this.f17230a;
            }
        }

        public b(w1 w1Var, w1 w1Var2, m2 m2Var) {
            this.f17225a = w1Var;
            this.f17226b = w1Var2;
            this.f17227c = m2Var;
        }

        @Override // vj.m2
        public k2.a<WReqT> a(k2<WReqT, WRespT> k2Var, v1 v1Var) {
            return new C0455b(this.f17227c.a(new a(k2Var), v1Var));
        }
    }

    public static final class c<ReqT, RespT> implements m2<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o2 f17232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m2<ReqT, RespT> f17233b;

        public c(o2 o2Var, m2<ReqT, RespT> m2Var) {
            this.f17232a = (o2) c1.h0.F(o2Var, "interceptor");
            this.f17233b = m2Var;
        }

        public static <ReqT, RespT> c<ReqT, RespT> b(o2 o2Var, m2<ReqT, RespT> m2Var) {
            return new c<>(o2Var, m2Var);
        }

        @Override // vj.m2
        public k2.a<ReqT> a(k2<ReqT, RespT> k2Var, v1 v1Var) {
            return this.f17232a.a(k2Var, v1Var, this.f17233b);
        }
    }

    public static final class d extends BufferedInputStream implements n1 {
        public d(InputStream inputStream) {
            super(inputStream);
        }
    }

    public static t2 a(vj.c cVar, List<? extends o2> list) {
        c1.h0.F(cVar, "bindableService");
        return c(cVar.bindService(), list);
    }

    public static t2 b(vj.c cVar, o2... o2VarArr) {
        c1.h0.F(cVar, "bindableService");
        return c(cVar.bindService(), Arrays.asList(o2VarArr));
    }

    public static t2 c(t2 t2Var, List<? extends o2> list) {
        c1.h0.F(t2Var, "serviceDef");
        if (list.isEmpty()) {
            return t2Var;
        }
        t2.b bVar = new t2.b(t2Var.f17267a);
        Iterator<q2<?, ?>> it = t2Var.f17268b.values().iterator();
        while (it.hasNext()) {
            l(bVar, it.next(), list);
        }
        return bVar.c();
    }

    public static t2 d(t2 t2Var, o2... o2VarArr) {
        return c(t2Var, Arrays.asList(o2VarArr));
    }

    public static t2 e(vj.c cVar, List<? extends o2> list) {
        return g(cVar.bindService(), list);
    }

    public static t2 f(vj.c cVar, o2... o2VarArr) {
        return g(cVar.bindService(), Arrays.asList(o2VarArr));
    }

    public static t2 g(t2 t2Var, List<? extends o2> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return c(t2Var, arrayList);
    }

    public static t2 h(t2 t2Var, o2... o2VarArr) {
        return g(t2Var, Arrays.asList(o2VarArr));
    }

    @e0("https://github.com/grpc/grpc-java/issues/1712")
    public static t2 i(t2 t2Var) {
        a aVar = new a();
        return k(t2Var, aVar, aVar);
    }

    @e0("https://github.com/grpc/grpc-java/issues/1712")
    public static <T> t2 j(t2 t2Var, w1.c<T> cVar) {
        return k(t2Var, cVar, cVar);
    }

    @e0("https://github.com/grpc/grpc-java/issues/9870")
    public static <ReqT, RespT> t2 k(t2 t2Var, w1.c<ReqT> cVar, w1.c<RespT> cVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (q2<?, ?> q2Var : t2Var.f17268b.values()) {
            w1 w1VarA = q2Var.f17252a.x(cVar, cVar2).a();
            arrayList2.add(w1VarA);
            arrayList.add(n(q2Var, w1VarA));
        }
        w2.b bVar = new w2.b(t2Var.f17267a.f17499a);
        bVar.f17504c = t2Var.f17267a.f17501c;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            bVar.f((w1) it.next());
        }
        t2.b bVar2 = new t2.b(new w2(bVar));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            bVar2.b((q2) it2.next());
        }
        return bVar2.c();
    }

    public static <ReqT, RespT> void l(t2.b bVar, q2<ReqT, RespT> q2Var, List<? extends o2> list) {
        m2<ReqT, RespT> cVar = q2Var.f17253b;
        Iterator<? extends o2> it = list.iterator();
        while (it.hasNext()) {
            cVar = new c(it.next(), cVar);
        }
        bVar.b(q2Var.d(cVar));
    }

    public static <OReqT, ORespT, WReqT, WRespT> m2<WReqT, WRespT> m(m2<OReqT, ORespT> m2Var, w1<OReqT, ORespT> w1Var, w1<WReqT, WRespT> w1Var2) {
        return new b(w1Var, w1Var2, m2Var);
    }

    public static <OReqT, ORespT, WReqT, WRespT> q2<WReqT, WRespT> n(q2<OReqT, ORespT> q2Var, w1<WReqT, WRespT> w1Var) {
        return new q2<>(w1Var, new b(q2Var.f17252a, w1Var, q2Var.f17253b));
    }
}
