package gk;

import ik.t1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 implements dk.h<dk.c, l2, l2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g0 f6611a = new g0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final fl.b<List<a>> f6612b = new fl.b<>("ForwardedParsedKey");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final fl.b<l2> f6613c = new fl.b<>("ForwardedHeaderSupport");

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public final String f6614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final String f6615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public final String f6616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.m
        public final String f6617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final Map<String, String> f6618e;

        public a(@os.m String str, @os.m String str2, @os.m String str3, @os.m String str4, @os.l Map<String, String> map) {
            kn.l0.p(map, "others");
            this.f6614a = str;
            this.f6615b = str2;
            this.f6616c = str3;
            this.f6617d = str4;
            this.f6618e = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ a g(a aVar, String str, String str2, String str3, String str4, Map map, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = aVar.f6614a;
            }
            if ((i10 & 2) != 0) {
                str2 = aVar.f6615b;
            }
            String str5 = str2;
            if ((i10 & 4) != 0) {
                str3 = aVar.f6616c;
            }
            String str6 = str3;
            if ((i10 & 8) != 0) {
                str4 = aVar.f6617d;
            }
            String str7 = str4;
            if ((i10 & 16) != 0) {
                map = aVar.f6618e;
            }
            return aVar.f(str, str5, str6, str7, map);
        }

        @os.m
        public final String a() {
            return this.f6614a;
        }

        @os.m
        public final String b() {
            return this.f6615b;
        }

        @os.m
        public final String c() {
            return this.f6616c;
        }

        @os.m
        public final String d() {
            return this.f6617d;
        }

        @os.l
        public final Map<String, String> e() {
            return this.f6618e;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kn.l0.g(this.f6614a, aVar.f6614a) && kn.l0.g(this.f6615b, aVar.f6615b) && kn.l0.g(this.f6616c, aVar.f6616c) && kn.l0.g(this.f6617d, aVar.f6617d) && kn.l0.g(this.f6618e, aVar.f6618e);
        }

        @os.l
        public final a f(@os.m String str, @os.m String str2, @os.m String str3, @os.m String str4, @os.l Map<String, String> map) {
            kn.l0.p(map, "others");
            return new a(str, str2, str3, str4, map);
        }

        @os.m
        public final String h() {
            return this.f6615b;
        }

        public int hashCode() {
            String str = this.f6614a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f6615b;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f6616c;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f6617d;
            return this.f6618e.hashCode() + ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31);
        }

        @os.m
        public final String i() {
            return this.f6616c;
        }

        @os.m
        public final String j() {
            return this.f6614a;
        }

        @os.l
        public final Map<String, String> k() {
            return this.f6618e;
        }

        @os.m
        public final String l() {
            return this.f6617d;
        }

        @os.l
        public String toString() {
            return "ForwardedHeaderValue(host=" + ((Object) this.f6614a) + ", by=" + ((Object) this.f6615b) + ", forParam=" + ((Object) this.f6616c) + ", proto=" + ((Object) this.f6617d) + ", others=" + this.f6618e + ')';
        }
    }

    @xm.f(c = "io.ktor.features.ForwardedHeaderSupport$install$1", f = "OriginConnectionPoint.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public b(um.d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lm.d1.n(obj);
            nl.f fVar = (nl.f) this.L$0;
            g0 g0Var = g0.f6611a;
            List<a> listC = g0Var.c(((dk.b) fVar.getContext()).d());
            if (listC == null) {
                return l2.f10208a;
            }
            fl.c cVarC = ((dk.b) fVar.getContext()).c();
            g0Var.getClass();
            cVarC.g(g0.f6612b, listC);
            a aVar2 = (a) nm.h0.G2(listC);
            if (aVar2 == null) {
                return l2.f10208a;
            }
            if (aVar2.f6617d != null) {
                q0 q0VarB = u0.b((dk.b) fVar.getContext());
                String str = aVar2.f6617d;
                q0VarB.i(str);
                t1.f8189c.getClass();
                t1 t1Var = (t1) t1.f8195i.get(str);
                if (t1Var != null) {
                    q0VarB.g(t1Var.f8197b);
                }
            }
            String str2 = aVar2.f6616c;
            if (str2 != null) {
                String string = jq.h0.C5((String) nm.h0.B2(jq.h0.R4(str2, new String[]{ks.g.f9491d}, false, 0, 6, null))).toString();
                if (!jq.e0.S1(string)) {
                    u0.b((dk.b) fVar.getContext()).h(string);
                }
            }
            String str3 = aVar2.f6614a;
            if (str3 == null) {
                return l2.f10208a;
            }
            l2 l2Var = null;
            String strU5 = jq.h0.u5(str3, n1.e.f11184d, null, 2, null);
            String strK5 = jq.h0.k5(aVar2.f6614a, n1.e.f11184d, "");
            q0 q0VarB2 = u0.b((dk.b) fVar.getContext());
            q0VarB2.e(strU5);
            Integer numX0 = jq.d0.X0(strK5);
            if (numX0 != null) {
                q0VarB2.g(numX0.intValue());
                l2Var = l2.f10208a;
            }
            if (l2Var == null) {
                t1.f8189c.getClass();
                t1 t1Var2 = (t1) t1.f8195i.get(q0VarB2.d());
                if (t1Var2 != null) {
                    q0VarB2.g(t1Var2.f8197b);
                }
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            b bVar = new b(dVar);
            bVar.L$0 = fVar;
            return bVar.invokeSuspend(l2.f10208a);
        }
    }

    @Override // dk.h
    public /* bridge */ /* synthetic */ l2 a(nl.e eVar, jn.l<? super l2, l2> lVar) throws nl.c {
        e((dk.c) eVar, lVar);
        return l2.f10208a;
    }

    public final List<a> c(uk.d dVar) {
        ik.b0 b0VarB = dVar.b();
        ik.j0.f8048a.getClass();
        List<String> listB = b0VarB.b(ik.j0.E);
        if (listB == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            nm.d0.r0(arrayList, ik.i0.e(kn.l0.C(";", (String) it.next()), false));
        }
        ArrayList arrayList2 = new ArrayList(nm.z.b0(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f6611a.f((ik.x) it2.next()));
        }
        return arrayList2;
    }

    @os.l
    public final fl.b<List<a>> d() {
        return f6612b;
    }

    public void e(@os.l dk.c cVar, @os.l jn.l<? super l2, l2> lVar) throws nl.c {
        kn.l0.p(cVar, "pipeline");
        kn.l0.p(lVar, "configure");
        lVar.invoke(l2.f10208a);
        dk.c.f3706v.getClass();
        cVar.x(dk.c.f3709y, new b(null));
    }

    public final a f(ik.x xVar) {
        List<ik.y> list = xVar.f8201b;
        HashMap map = new HashMap();
        for (ik.y yVar : list) {
            map.put(yVar.f8206a, yVar.f8207b);
        }
        return new a((String) map.remove("host"), (String) map.remove("by"), (String) map.remove("for"), (String) map.remove("proto"), map);
    }

    @Override // dk.h
    @os.l
    public fl.b<l2> getKey() {
        return f6613c;
    }
}
