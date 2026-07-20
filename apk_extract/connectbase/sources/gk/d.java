package gk;

import fl.t1;
import ik.l1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lm.l2;
import nm.o1;
import nm.p1;
import wj.h2;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f6542q = 86400;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jq.r f6544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final Set<String> f6548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final List<jn.l<String, Boolean>> f6549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final Set<ik.p0> f6550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final Set<String> f6551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f6552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public final List<String> f6553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public final String f6554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.m
    public final String f6555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.m
    public final String f6556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final HashSet<String> f6557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public final HashSet<lm.t0<String, String>> f6558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final b f6541p = new b();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.l
    public static final fl.b<d> f6543r = new fl.b<>("CORS");

    public static final class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @os.l
        public static final C0161a f6559k = new C0161a();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @os.l
        public static final Set<ik.p0> f6560l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @os.l
        public static final Set<String> f6561m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @os.l
        public static final Set<String> f6562n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @os.l
        public static final Set<String> f6563o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @os.l
        public static final Set<ik.i> f6564p;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6570f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f6574j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final String f6565a = "*.";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final Set<String> f6566b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final Set<String> f6567c = new fl.p();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final Set<ik.p0> f6568d = new HashSet();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final Set<String> f6569e = new fl.p();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final List<jn.l<String, Boolean>> f6571g = new ArrayList();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f6572h = d.f6542q;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f6573i = true;

        /* JADX INFO: renamed from: gk.d$a$a, reason: collision with other inner class name */
        public static final class C0161a {
            public C0161a() {
            }

            @lm.k(level = lm.m.ERROR, message = "Use CorsSimpleRequestHeaders or CorsSimpleResponseHeaders instead")
            public static /* synthetic */ void b() {
            }

            public static /* synthetic */ void e() {
            }

            @os.l
            public final Set<String> a() {
                return a.f6561m;
            }

            @os.l
            public final Set<ik.p0> c() {
                return a.f6560l;
            }

            @os.l
            public final Set<ik.i> d() {
                return a.f6564p;
            }

            @os.l
            public final Set<String> f() {
                return a.f6562n;
            }

            @os.l
            public final Set<String> g() {
                return a.f6563o;
            }

            public C0161a(kn.w wVar) {
            }
        }

        public static final class b extends kn.n0 implements jn.l<String, Boolean> {
            final /* synthetic */ String $headerPrefix;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.$headerPrefix = str;
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l String str) {
                kn.l0.p(str, "name");
                return Boolean.valueOf(jq.e0.s2(str, this.$headerPrefix, false, 2, null));
            }
        }

        public static final class c extends kn.n0 implements jn.l<CharSequence, Integer> {
            final /* synthetic */ String $subString;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.$subString = str;
            }

            @Override // jn.l
            @os.l
            public final Integer invoke(@os.l CharSequence charSequence) {
                kn.l0.p(charSequence, "it");
                return Integer.valueOf(kn.l0.g(charSequence, this.$subString) ? 1 : 0);
            }
        }

        static {
            ik.p0.a aVar = ik.p0.f8135b;
            aVar.getClass();
            ik.p0 p0Var = ik.p0.f8136c;
            aVar.getClass();
            ik.p0 p0Var2 = ik.p0.f8137d;
            aVar.getClass();
            f6560l = o1.u(p0Var, p0Var2, ik.p0.f8141h);
            b bVar = d.f6541p;
            ik.j0 j0Var = ik.j0.f8048a;
            j0Var.getClass();
            String str = ik.j0.f8070l;
            j0Var.getClass();
            String str2 = ik.j0.f8078p;
            j0Var.getClass();
            String str3 = ik.j0.f8086t;
            j0Var.getClass();
            String str4 = ik.j0.C;
            j0Var.getClass();
            String str5 = ik.j0.O;
            j0Var.getClass();
            String str6 = ik.j0.Y;
            f6561m = bVar.c(str, str2, str3, str4, str5, str6);
            j0Var.getClass();
            String str7 = ik.j0.f8050b;
            j0Var.getClass();
            String str8 = ik.j0.f8056e;
            j0Var.getClass();
            j0Var.getClass();
            f6562n = bVar.c(str7, str8, str2, str3);
            j0Var.getClass();
            j0Var.getClass();
            j0Var.getClass();
            j0Var.getClass();
            j0Var.getClass();
            j0Var.getClass();
            f6563o = bVar.c(str, str2, str3, str4, str5, str6);
            ik.i.a.f7985a.getClass();
            ik.i iVar = ik.i.a.f7999o;
            ik.i.f.f8020a.getClass();
            ik.i iVar2 = ik.i.f.f8025f;
            ik.i.g.f8029a.getClass();
            f6564p = fl.s.a(o1.u(iVar, iVar2, ik.i.g.f8031c));
        }

        public static final int H(String str, String str2) {
            return nm.h0.C5(jq.j0.k9(str, str2.length(), 0, false, new c(str2), 6, null));
        }

        @lm.k(level = lm.m.HIDDEN, message = "Use maxAgeInSeconds or maxAgeDuration instead.")
        public static /* synthetic */ void u() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void z(a aVar, String str, List list, List list2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                list = nm.x.k("http");
            }
            if ((i10 & 4) != 0) {
                list2 = nm.k0.INSTANCE;
            }
            aVar.y(str, list, list2);
        }

        public final void A(@os.l ik.p0 p0Var) {
            kn.l0.p(p0Var, "method");
            if (f6560l.contains(p0Var)) {
                return;
            }
            this.f6568d.add(p0Var);
        }

        public final void B(boolean z10) {
            this.f6570f = z10;
        }

        public final void C(boolean z10) {
            this.f6574j = z10;
        }

        public final void D(boolean z10) {
            this.f6573i = z10;
        }

        public final /* synthetic */ void E(Duration duration) {
            kn.l0.p(duration, "newMaxAge");
            l0.e(this, duration);
        }

        public final void F(long j10) {
            if (j10 < 0) {
                throw new IllegalStateException(kn.l0.C("maxAgeInSeconds shouldn't be negative: ", Long.valueOf(j10)).toString());
            }
            this.f6572h = j10;
        }

        public final void G(String str) {
            if (jq.h0.S2(str, kl.f.f9277j, false, 2, null)) {
                if (!I(str)) {
                    throw new IllegalArgumentException("wildcard must appear in front of the domain, e.g. *.domain.com");
                }
                if (H(str, this.f6565a) != 1) {
                    throw new IllegalArgumentException("wildcard cannot appear more than once");
                }
            }
        }

        public final boolean I(String str) {
            int iP3 = jq.h0.p3(str, this.f6565a, 0, false, 6, null);
            if (!jq.h0.T2(str, this.f6565a, false, 2, null) || jq.e0.J1(str, this.f6565a, false, 2, null)) {
                return false;
            }
            return iP3 <= 0 || jq.e0.J1(jq.h0.v5(str, this.f6565a, null, 2, null), "://", false, 2, null);
        }

        public final void f(String str) {
            G(str);
            this.f6566b.add(str);
        }

        public final void g(@os.l jn.l<? super String, Boolean> lVar) {
            kn.l0.p(lVar, "predicate");
            this.f6571g.add(lVar);
        }

        public final void h(@os.l String str) {
            kn.l0.p(str, "headerPrefix");
            this.f6571g.add(new b(str));
        }

        public final void i() {
            ik.j0.f8048a.getClass();
            x(ik.j0.M0);
        }

        public final void j() {
            this.f6566b.add("*");
        }

        public final void k(@os.l String str) {
            kn.l0.p(str, "header");
            if (f6563o.contains(str)) {
                return;
            }
            this.f6569e.add(str);
        }

        @lm.k(level = lm.m.ERROR, message = "Allow it in request headers instead", replaceWith = @lm.a1(expression = "allowXHttpMethodOverride()", imports = {}))
        public final void l() {
            Set<String> set = this.f6569e;
            ik.j0.f8048a.getClass();
            set.add(ik.j0.M0);
        }

        public final boolean m() {
            return this.f6570f;
        }

        public final boolean n() {
            return this.f6574j;
        }

        public final boolean o() {
            return this.f6573i;
        }

        @os.l
        public final Set<String> p() {
            return this.f6569e;
        }

        @os.l
        public final List<jn.l<String, Boolean>> q() {
            return this.f6571g;
        }

        @os.l
        public final Set<String> r() {
            return this.f6567c;
        }

        @os.l
        public final Set<String> s() {
            return this.f6566b;
        }

        public final /* synthetic */ Duration t() {
            return l0.a(this);
        }

        public final long v() {
            return this.f6572h;
        }

        @os.l
        public final Set<ik.p0> w() {
            return this.f6568d;
        }

        public final void x(@os.l String str) {
            kn.l0.p(str, "header");
            ik.j0.f8048a.getClass();
            if (jq.e0.K1(str, ik.j0.f8086t, true)) {
                this.f6574j = true;
            } else {
                if (f6562n.contains(str)) {
                    return;
                }
                this.f6567c.add(str);
            }
        }

        public final void y(@os.l String str, @os.l List<String> list, @os.l List<String> list2) {
            kn.l0.p(str, "host");
            kn.l0.p(list, "schemes");
            kn.l0.p(list2, "subDomains");
            if (kn.l0.g(str, "*")) {
                j();
                return;
            }
            if (jq.h0.T2(str, "://", false, 2, null)) {
                throw new IllegalArgumentException("scheme should be specified as a separate parameter schemes");
            }
            for (String str2 : list) {
                f(str2 + "://" + str);
                for (String str3 : list2) {
                    G(str3);
                    f(str2 + "://" + str3 + n1.e.f11183c + str);
                }
            }
        }
    }

    public static final class b implements dk.h<dk.c, a, d> {

        @xm.f(c = "io.ktor.features.CORS$Feature$install$1", f = "CORS.kt", i = {}, l = {579}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ d $cors;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, um.d<? super a> dVar2) {
                super(3, dVar2);
                this.$cors = dVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f<l2, dk.b> fVar = (nl.f) this.L$0;
                    d dVar = this.$cors;
                    this.label = 1;
                    if (dVar.u(fVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lm.d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                a aVar = new a(this.$cors, dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        public final Set<String> c(String... strArr) {
            return new fl.p(nm.p.t(strArr));
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public d a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            d dVar = new d(aVar);
            dk.c.f3706v.getClass();
            cVar.x(dk.c.f3709y, new a(dVar, null));
            return dVar;
        }

        @Override // dk.h
        @os.l
        public fl.b<d> getKey() {
            return d.f6543r;
        }

        public b(kn.w wVar) {
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6575a;

        static {
            int[] iArr = new int[s0.values().length];
            iArr[s0.OK.ordinal()] = 1;
            iArr[s0.SkipCORS.ordinal()] = 2;
            iArr[s0.Failed.ordinal()] = 3;
            f6575a = iArr;
        }
    }

    /* JADX INFO: renamed from: gk.d$d, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.features.CORS", f = "CORS.kt", i = {2}, l = {y5.a.f20718f0, y5.a.f20736o0, 129, 137}, m = "intercept", n = {"context"}, s = {"L$0"})
    public static final class C0162d extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C0162d(um.d<? super C0162d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.u(null, this);
        }
    }

    @xm.f(c = "io.ktor.features.CORS", f = "CORS.kt", i = {0}, l = {600}, m = "respondCorsFailed", n = {"$this$respondCorsFailed"}, s = {"L$0"})
    public static final class e extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.y(null, this);
        }
    }

    public d(@os.l a aVar) {
        kn.l0.p(aVar, "configuration");
        this.f6544a = new jq.r("[0-9]+");
        this.f6545b = aVar.f6573i;
        this.f6546c = aVar.f6566b.contains("*");
        this.f6547d = aVar.f6570f;
        Set<String> set = aVar.f6567c;
        a.C0161a c0161a = a.f6559k;
        c0161a.getClass();
        Set<String> setD = p1.D(set, a.f6562n);
        if (!aVar.f6574j) {
            ik.j0.f8048a.getClass();
            setD = p1.z(setD, ik.j0.f8086t);
        }
        this.f6548e = setD;
        this.f6549f = aVar.f6571g;
        Set<ik.p0> set2 = aVar.f6568d;
        c0161a.getClass();
        this.f6550g = new HashSet(p1.D(set2, a.f6560l));
        ArrayList arrayList = new ArrayList(nm.z.b0(setD, 10));
        Iterator<T> it = setD.iterator();
        while (it.hasNext()) {
            arrayList.add(t1.e((String) it.next()));
        }
        this.f6551h = nm.h0.a6(arrayList);
        this.f6552i = aVar.f6574j;
        Set<String> set3 = aVar.f6567c;
        List arrayList2 = new ArrayList();
        for (Object obj : set3) {
            a.f6559k.getClass();
            if (!a.f6562n.contains((String) obj)) {
                arrayList2.add(obj);
            }
        }
        if (this.f6552i) {
            ik.j0.f8048a.getClass();
            arrayList2 = nm.h0.F4(arrayList2, ik.j0.f8086t);
        }
        this.f6553j = arrayList2;
        Set<ik.p0> set4 = this.f6550g;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : set4) {
            a.f6559k.getClass();
            if (!a.f6560l.contains((ik.p0) obj2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(nm.z.b0(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((ik.p0) it2.next()).f8144a);
        }
        this.f6554k = nm.h0.m3(nm.h0.q5(arrayList4), ", ", null, null, 0, null, null, 62, null);
        long j10 = aVar.f6572h;
        this.f6555l = j10 > 0 ? String.valueOf(j10) : null;
        this.f6556m = !aVar.f6569e.isEmpty() ? nm.h0.m3(nm.h0.q5(aVar.f6569e), ", ", null, null, 0, null, null, 62, null) : null;
        Set<String> set5 = aVar.f6566b;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : set5) {
            if (!jq.h0.S2((String) obj3, kl.f.f9277j, false, 2, null)) {
                arrayList5.add(obj3);
            }
        }
        ArrayList arrayList6 = new ArrayList(nm.z.b0(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList6.add(x((String) it3.next()));
        }
        this.f6557n = new HashSet<>(arrayList6);
        Set<String> set6 = aVar.f6566b;
        ArrayList arrayList7 = new ArrayList();
        for (Object obj4 : set6) {
            if (jq.h0.S2((String) obj4, kl.f.f9277j, false, 2, null)) {
                arrayList7.add(obj4);
            }
        }
        ArrayList arrayList8 = new ArrayList(nm.z.b0(arrayList7, 10));
        Iterator it4 = arrayList7.iterator();
        while (it4.hasNext()) {
            List listQ4 = jq.h0.Q4(x((String) it4.next()), new char[]{kl.f.f9277j}, false, 0, 6, null);
            arrayList8.add(new lm.t0((String) listQ4.get(0), (String) listQ4.get(1)));
        }
        this.f6558o = new HashSet<>(arrayList8);
    }

    public final void d(dk.b bVar) {
        if (this.f6547d) {
            vk.a aVarE = bVar.e();
            ik.j0.f8048a.getClass();
            vk.c.m(aVarE, ik.j0.G0, "true");
        }
    }

    public final void e(dk.b bVar, String str) {
        if (!this.f6546c || this.f6547d) {
            vk.a aVarE = bVar.e();
            ik.j0.f8048a.getClass();
            vk.c.m(aVarE, ik.j0.E0, str);
        } else {
            vk.a aVarE2 = bVar.e();
            ik.j0.f8048a.getClass();
            vk.c.m(aVarE2, ik.j0.E0, "*");
        }
    }

    public final void f(dk.b bVar) {
        if (this.f6555l != null) {
            vk.a aVarE = bVar.e();
            ik.j0.f8048a.getClass();
            vk.c.m(aVarE, ik.j0.L0, this.f6555l);
        }
    }

    @os.l
    public final s0 g(@os.l String str, @os.l l1 l1Var) {
        kn.l0.p(str, n1.d.a.f11176d);
        kn.l0.p(l1Var, "point");
        if (!w(str)) {
            return s0.SkipCORS;
        }
        if (this.f6545b && v(str, l1Var)) {
            return s0.SkipCORS;
        }
        return !i(str) ? s0.Failed : s0.OK;
    }

    public final boolean h(dk.b bVar) {
        return this.f6550g.contains(uk.e.n(bVar.d()));
    }

    public final boolean i(String str) {
        String strX = x(str);
        if (!this.f6546c && !this.f6557n.contains(strX)) {
            HashSet<lm.t0<String, String>> hashSet = this.f6558o;
            if (hashSet != null && hashSet.isEmpty()) {
                return false;
            }
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                lm.t0 t0Var = (lm.t0) it.next();
                String str2 = (String) t0Var.component1();
                String str3 = (String) t0Var.component2();
                if (!jq.e0.s2(strX, str2, false, 2, null) || !jq.e0.J1(strX, str3, false, 2, null)) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean j(List<String> list) {
        List<String> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        for (String str : list2) {
            if (!this.f6551h.contains(str) && !t(str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(dk.b bVar) {
        uk.d dVarD = bVar.d();
        ik.j0.f8048a.getClass();
        String strQ = uk.e.q(dVarD, ik.j0.I0);
        ik.p0 p0Var = strQ == null ? null : new ik.p0(strQ);
        return p0Var != null && this.f6550g.contains(p0Var);
    }

    public final void l(dk.b bVar) {
        vk.g gVarB = bVar.e().b();
        ik.j0 j0Var = ik.j0.f8048a;
        j0Var.getClass();
        String str = ik.j0.A0;
        String strF = gVarB.f(str);
        if (strF == null) {
            vk.a aVarE = bVar.e();
            j0Var.getClass();
            j0Var.getClass();
            vk.c.m(aVarE, str, ik.j0.V);
            return;
        }
        vk.a aVarE2 = bVar.e();
        j0Var.getClass();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) strF);
        sb2.append(", ");
        j0Var.getClass();
        sb2.append(ik.j0.V);
        vk.c.m(aVarE2, str, sb2.toString());
    }

    @os.l
    public final Set<String> m() {
        return this.f6548e;
    }

    @os.l
    public final Set<String> n() {
        return this.f6551h;
    }

    public final boolean o() {
        return this.f6547d;
    }

    public final boolean p() {
        return this.f6545b;
    }

    public final boolean q() {
        return this.f6546c;
    }

    @os.l
    public final List<jn.l<String, Boolean>> r() {
        return this.f6549f;
    }

    @os.l
    public final Set<ik.p0> s() {
        return this.f6550g;
    }

    public final boolean t(String str) {
        List<jn.l<String, Boolean>> list = this.f6549f;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Boolean) ((jn.l) it.next()).invoke(str)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object u(@os.l nl.f<l2, dk.b> fVar, @os.l um.d<? super l2> dVar) {
        C0162d c0162d;
        if (dVar instanceof C0162d) {
            c0162d = (C0162d) dVar;
            int i10 = c0162d.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0162d.label = i10 - Integer.MIN_VALUE;
            } else {
                c0162d = new C0162d(dVar);
            }
        } else {
            c0162d = new C0162d(dVar);
        }
        Object obj = c0162d.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0162d.label;
        if (i11 != 0) {
            if (i11 == 1) {
                lm.d1.n(obj);
                return l2.f10208a;
            }
            if (i11 == 2) {
                lm.d1.n(obj);
                return l2.f10208a;
            }
            if (i11 != 3) {
                if (i11 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
                return l2.f10208a;
            }
            fVar = (nl.f) c0162d.L$0;
            lm.d1.n(obj);
            fVar.finish();
            return l2.f10208a;
        }
        lm.d1.n(obj);
        dk.b context = fVar.getContext();
        if (!this.f6546c || this.f6547d) {
            l(context);
        }
        ik.b0 b0VarB = context.d().b();
        ik.j0 j0Var = ik.j0.f8048a;
        j0Var.getClass();
        List<String> listB = b0VarB.b(ik.j0.V);
        String str = listB == null ? null : (String) nm.h0.k5(listB);
        if (str == null) {
            return l2.f10208a;
        }
        int i12 = c.f6575a[g(str, u0.e(context.d())).ordinal()];
        if (i12 == 2) {
            return l2.f10208a;
        }
        if (i12 == 3) {
            c0162d.label = 1;
            if (y(fVar, c0162d) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }
        if (!this.f6552i) {
            uk.d dVarD = context.d();
            j0Var.getClass();
            String strQ = uk.e.q(dVarD, ik.j0.f8086t);
            ik.i iVarB = strQ != null ? ik.i.f7981f.b(strQ) : null;
            if (iVarB != null) {
                a.f6559k.getClass();
                if (!a.f6564p.contains(iVarB.k())) {
                    c0162d.label = 2;
                    if (y(fVar, c0162d) == obj2) {
                        return obj2;
                    }
                    return l2.f10208a;
                }
            }
        }
        ik.p0 p0VarN = uk.e.n(context.d());
        ik.p0.f8135b.getClass();
        if (kn.l0.g(p0VarN, ik.p0.f8142i)) {
            c0162d.L$0 = fVar;
            c0162d.label = 3;
            if (z(context, str, c0162d) == obj2) {
                return obj2;
            }
            fVar.finish();
            return l2.f10208a;
        }
        if (!h(context)) {
            c0162d.label = 4;
            if (y(fVar, c0162d) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }
        e(context, str);
        d(context);
        if (this.f6556m != null) {
            vk.a aVarE = context.e();
            j0Var.getClass();
            vk.c.m(aVarE, ik.j0.K0, this.f6556m);
        }
        return l2.f10208a;
    }

    public final boolean v(String str, l1 l1Var) {
        return kn.l0.g(x(l1Var.d() + "://" + l1Var.b() + n1.e.f11184d + l1Var.a()), x(str));
    }

    public final boolean w(String str) {
        int iP3;
        if (str.length() == 0) {
            return false;
        }
        if (kn.l0.g(str, d6.a.E)) {
            return true;
        }
        if (!jq.h0.T2(str, "%", false, 2, null) && (iP3 = jq.h0.p3(str, "://", 0, false, 6, null)) > 0 && Character.isLetter(str.charAt(0))) {
            CharSequence charSequenceSubSequence = str.subSequence(0, iP3);
            int i10 = 0;
            while (i10 < charSequenceSubSequence.length()) {
                char cCharAt = charSequenceSubSequence.charAt(i10);
                i10++;
                if (Character.isLetter(cCharAt) || Character.isDigit(cCharAt) || cCharAt == '-' || cCharAt == '+' || cCharAt == '.') {
                }
            }
            int length = str.length();
            int i11 = iP3 + 3;
            int length2 = str.length();
            while (i11 < length2) {
                int i12 = i11 + 1;
                char cCharAt2 = str.charAt(i11);
                if (cCharAt2 == ':' || cCharAt2 == '/') {
                    length = i12;
                    break;
                }
                if (cCharAt2 == '?') {
                    return false;
                }
                i11 = i12;
            }
            int length3 = str.length();
            while (length < length3) {
                int i13 = length + 1;
                if (!Character.isDigit(str.charAt(length))) {
                    return false;
                }
                length = i13;
            }
            return true;
        }
        return false;
    }

    public final String x(String str) {
        if (kn.l0.g(str, d6.a.E) || kn.l0.g(str, "*")) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        sb2.append(str);
        if (!this.f6544a.matches(jq.h0.p5(str, ":", ""))) {
            String str2 = null;
            String strU5 = jq.h0.u5(str, n1.e.f11184d, null, 2, null);
            if (kn.l0.g(strU5, "http")) {
                str2 = "80";
            } else if (kn.l0.g(strU5, h2.f18719h)) {
                str2 = "443";
            }
            if (str2 != null) {
                sb2.append(n1.e.f11184d);
                sb2.append(str2);
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder(origin.len…   }\n        }.toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object y(nl.f<l2, dk.b> fVar, um.d<? super l2> dVar) {
        e eVar;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object obj = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            lm.d1.n(obj);
            dk.b context = fVar.getContext();
            ik.r0.f8158c.getClass();
            ik.r0 r0Var = ik.r0.A;
            if (!(r0Var instanceof byte[])) {
                try {
                    vk.i.b(context.e(), kn.l1.A(ik.r0.class));
                } catch (Throwable unused) {
                }
            }
            vk.d dVarC = context.e().c();
            eVar.L$0 = fVar;
            eVar.label = 1;
            if (dVarC.g(context, r0Var, eVar) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (nl.f) eVar.L$0;
            lm.d1.n(obj);
        }
        fVar.finish();
        return l2.f10208a;
    }

    public final Object z(dk.b bVar, String str, um.d<? super l2> dVar) {
        List<String> list;
        ik.b0 b0VarB = bVar.d().b();
        ik.j0.f8048a.getClass();
        List<String> listB = b0VarB.b(ik.j0.J0);
        if (listB == null) {
            list = null;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                nm.d0.r0(arrayList, jq.h0.R4((String) it.next(), new String[]{ks.g.f9491d}, false, 0, 6, null));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!jq.e0.S1((String) obj)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(nm.z.b0(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(t1.e(jq.h0.C5((String) it2.next()).toString()));
            }
            list = arrayList3;
        }
        if (list == null) {
            list = nm.k0.INSTANCE;
        }
        if (!k(bVar) || !j(list)) {
            ik.r0.f8158c.getClass();
            ik.r0 r0Var = ik.r0.A;
            if (!(r0Var instanceof byte[])) {
                try {
                    vk.i.b(bVar.e(), kn.l1.A(ik.r0.class));
                } catch (Throwable unused) {
                }
            }
            Object objG = bVar.e().c().g(bVar, r0Var, dVar);
            return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
        }
        e(bVar, str);
        d(bVar);
        if (this.f6554k.length() > 0) {
            vk.a aVarE = bVar.e();
            ik.j0.f8048a.getClass();
            vk.c.m(aVarE, ik.j0.F0, this.f6554k);
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            if (t((String) obj2)) {
                arrayList4.add(obj2);
            }
        }
        String strM3 = nm.h0.m3(nm.h0.q5(nm.h0.E4(this.f6553j, arrayList4)), ", ", null, null, 0, null, null, 62, null);
        vk.a aVarE2 = bVar.e();
        ik.j0.f8048a.getClass();
        vk.c.m(aVarE2, ik.j0.H0, strM3);
        f(bVar);
        ik.r0.f8158c.getClass();
        ik.r0 r0Var2 = ik.r0.f8165g;
        if (!(r0Var2 instanceof byte[])) {
            try {
                vk.i.b(bVar.e(), kn.l1.A(ik.r0.class));
            } catch (Throwable unused2) {
            }
        }
        Object objG2 = bVar.e().c().g(bVar, r0Var2, dVar);
        return objG2 == wm.a.COROUTINE_SUSPENDED ? objG2 : l2.f10208a;
    }
}
