package tp;

import eo.d1;
import eo.t0;
import eo.y0;
import fp.q;
import fp.s;
import gq.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import lm.l2;
import nm.c0;
import nm.c1;
import nm.d0;
import nm.h0;
import nm.k0;
import nm.p1;
import nm.z;
import rp.w;
import rp.x;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends op.i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f15977f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final rp.l f15978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final a f15979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final up.i f15980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final up.j f15981e;

    public interface a {
        @os.l
        Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar);

        @os.l
        Set<dp.f> b();

        @os.l
        Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar);

        @os.l
        Set<dp.f> d();

        @os.l
        Set<dp.f> e();

        @os.m
        d1 f(@os.l dp.f fVar);

        void g(@os.l Collection<eo.m> collection, @os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar, @os.l mo.b bVar);
    }

    public final class b implements a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ un.o<Object>[] f15982o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final List<yo.a.i> f15983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final List<yo.a.n> f15984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final List<yo.a.r> f15985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final up.i f15986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final up.i f15987e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final up.i f15988f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final up.i f15989g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public final up.i f15990h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final up.i f15991i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.l
        public final up.i f15992j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @os.l
        public final up.i f15993k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @os.l
        public final up.i f15994l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @os.l
        public final up.i f15995m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ i f15996n;

        public static final class a extends n0 implements jn.a<List<? extends y0>> {
            public a() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final List<? extends y0> invoke() {
                return h0.E4(b.this.D(), b.this.t());
            }
        }

        /* JADX INFO: renamed from: tp.i$b$b, reason: collision with other inner class name */
        public static final class C0414b extends n0 implements jn.a<List<? extends t0>> {
            public C0414b() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final List<? extends t0> invoke() {
                return h0.E4(b.this.E(), b.this.u());
            }
        }

        public static final class c extends n0 implements jn.a<List<? extends d1>> {
            public c() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final List<? extends d1> invoke() {
                return b.this.z();
            }
        }

        public static final class d extends n0 implements jn.a<List<? extends y0>> {
            public d() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final List<? extends y0> invoke() {
                return b.this.v();
            }
        }

        public static final class e extends n0 implements jn.a<List<? extends t0>> {
            public e() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final List<? extends t0> invoke() {
                return b.this.y();
            }
        }

        public static final class f extends n0 implements jn.a<Set<? extends dp.f>> {
            final /* synthetic */ i this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(i iVar) {
                super(0);
                this.this$1 = iVar;
            }

            @Override // jn.a
            @os.l
            public final Set<? extends dp.f> invoke() {
                b bVar = b.this;
                List list = bVar.f15983a;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                i iVar = bVar.f15996n;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(x.b(iVar.f15978b.f14749b, ((yo.a.i) ((q) it.next())).getName()));
                }
                return p1.D(linkedHashSet, this.this$1.v());
            }
        }

        public static final class g extends n0 implements jn.a<Map<dp.f, ? extends List<? extends y0>>> {
            public g() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final Map<dp.f, ? extends List<? extends y0>> invoke() {
                List listA = b.this.A();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listA) {
                    dp.f name = ((y0) obj).getName();
                    l0.o(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        public static final class h extends n0 implements jn.a<Map<dp.f, ? extends List<? extends t0>>> {
            public h() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final Map<dp.f, ? extends List<? extends t0>> invoke() {
                List listB = b.this.B();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listB) {
                    dp.f name = ((t0) obj).getName();
                    l0.o(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: renamed from: tp.i$b$i, reason: collision with other inner class name */
        public static final class C0415i extends n0 implements jn.a<Map<dp.f, ? extends d1>> {
            public C0415i() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final Map<dp.f, ? extends d1> invoke() {
                List listC = b.this.C();
                int iJ = c1.j(z.b0(listC, 10));
                if (iJ < 16) {
                    iJ = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
                for (Object obj : listC) {
                    dp.f name = ((d1) obj).getName();
                    l0.o(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        public static final class j extends n0 implements jn.a<Set<? extends dp.f>> {
            final /* synthetic */ i this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(i iVar) {
                super(0);
                this.this$1 = iVar;
            }

            @Override // jn.a
            @os.l
            public final Set<? extends dp.f> invoke() {
                b bVar = b.this;
                List list = bVar.f15984b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                i iVar = bVar.f15996n;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(x.b(iVar.f15978b.f14749b, ((yo.a.n) ((q) it.next())).getName()));
                }
                return p1.D(linkedHashSet, this.this$1.w());
            }
        }

        static {
            g1 g1Var = new g1(l1.d(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;");
            m1 m1Var = l1.f9319a;
            f15982o = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), m1Var.n(new g1(m1Var.d(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), m1Var.n(new g1(m1Var.d(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), m1Var.n(new g1(m1Var.d(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), m1Var.n(new g1(m1Var.d(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), m1Var.n(new g1(m1Var.d(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), m1Var.n(new g1(m1Var.d(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), m1Var.n(new g1(m1Var.d(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), m1Var.n(new g1(m1Var.d(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public b(@os.l i iVar, @os.l List<yo.a.i> list, @os.l List<yo.a.n> list2, List<yo.a.r> list3) {
            l0.p(iVar, "this$0");
            l0.p(list, "functionList");
            l0.p(list2, "propertyList");
            l0.p(list3, "typeAliasList");
            this.f15996n = iVar;
            this.f15983a = list;
            this.f15984b = list2;
            this.f15985c = iVar.f15978b.f14748a.f14729c.c() ? list3 : k0.INSTANCE;
            this.f15986d = iVar.f15978b.f14748a.f14727a.h(new d());
            this.f15987e = iVar.f15978b.f14748a.f14727a.h(new e());
            this.f15988f = iVar.f15978b.f14748a.f14727a.h(new c());
            this.f15989g = iVar.f15978b.f14748a.f14727a.h(new a());
            this.f15990h = iVar.f15978b.f14748a.f14727a.h(new C0414b());
            this.f15991i = iVar.f15978b.f14748a.f14727a.h(new C0415i());
            this.f15992j = iVar.f15978b.f14748a.f14727a.h(new g());
            this.f15993k = iVar.f15978b.f14748a.f14727a.h(new h());
            this.f15994l = iVar.f15978b.f14748a.f14727a.h(new f(iVar));
            this.f15995m = iVar.f15978b.f14748a.f14727a.h(new j(iVar));
        }

        public final List<y0> A() {
            return (List) up.m.a(this.f15989g, this, f15982o[3]);
        }

        public final List<t0> B() {
            return (List) up.m.a(this.f15990h, this, f15982o[4]);
        }

        public final List<d1> C() {
            return (List) up.m.a(this.f15988f, this, f15982o[2]);
        }

        public final List<y0> D() {
            return (List) up.m.a(this.f15986d, this, f15982o[0]);
        }

        public final List<t0> E() {
            return (List) up.m.a(this.f15987e, this, f15982o[1]);
        }

        public final Map<dp.f, Collection<y0>> F() {
            return (Map) up.m.a(this.f15992j, this, f15982o[6]);
        }

        public final Map<dp.f, Collection<t0>> G() {
            return (Map) up.m.a(this.f15993k, this, f15982o[7]);
        }

        public final Map<dp.f, d1> H() {
            return (Map) up.m.a(this.f15991i, this, f15982o[5]);
        }

        @Override // tp.i.a
        @os.l
        public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
            Collection<y0> collection;
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            return (b().contains(fVar) && (collection = F().get(fVar)) != null) ? collection : k0.INSTANCE;
        }

        @Override // tp.i.a
        @os.l
        public Set<dp.f> b() {
            return (Set) up.m.a(this.f15994l, this, f15982o[8]);
        }

        @Override // tp.i.a
        @os.l
        public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
            Collection<t0> collection;
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            return (d().contains(fVar) && (collection = G().get(fVar)) != null) ? collection : k0.INSTANCE;
        }

        @Override // tp.i.a
        @os.l
        public Set<dp.f> d() {
            return (Set) up.m.a(this.f15995m, this, f15982o[9]);
        }

        @Override // tp.i.a
        @os.l
        public Set<dp.f> e() {
            List<yo.a.r> list = this.f15985c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            i iVar = this.f15996n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(x.b(iVar.f15978b.f14749b, ((yo.a.r) ((q) it.next())).getName()));
            }
            return linkedHashSet;
        }

        @Override // tp.i.a
        @os.m
        public d1 f(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            return H().get(fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tp.i.a
        public void g(@os.l Collection<eo.m> collection, @os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar, @os.l mo.b bVar) {
            l0.p(collection, "result");
            l0.p(dVar, "kindFilter");
            l0.p(lVar, "nameFilter");
            l0.p(bVar, "location");
            op.d.f12368c.getClass();
            if (dVar.a(op.d.f12375j)) {
                for (Object obj : B()) {
                    dp.f name = ((t0) obj).getName();
                    l0.o(name, "it.name");
                    if (lVar.invoke(name).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            op.d.f12368c.getClass();
            if (dVar.a(op.d.f12374i)) {
                for (Object obj2 : A()) {
                    dp.f name2 = ((y0) obj2).getName();
                    l0.o(name2, "it.name");
                    if (lVar.invoke(name2).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        public final List<y0> t() {
            Set<dp.f> setV = this.f15996n.v();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setV.iterator();
            while (it.hasNext()) {
                d0.r0(arrayList, w((dp.f) it.next()));
            }
            return arrayList;
        }

        public final List<t0> u() {
            Set<dp.f> setW = this.f15996n.w();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setW.iterator();
            while (it.hasNext()) {
                d0.r0(arrayList, x((dp.f) it.next()));
            }
            return arrayList;
        }

        public final List<y0> v() {
            List<yo.a.i> list = this.f15983a;
            i iVar = this.f15996n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                y0 y0VarJ = iVar.f15978b.f14756i.j((yo.a.i) ((q) it.next()));
                if (!iVar.z(y0VarJ)) {
                    y0VarJ = null;
                }
                if (y0VarJ != null) {
                    arrayList.add(y0VarJ);
                }
            }
            return arrayList;
        }

        public final List<y0> w(dp.f fVar) {
            List<y0> listD = D();
            i iVar = this.f15996n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                if (l0.g(((eo.m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            iVar.m(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        public final List<t0> x(dp.f fVar) {
            List<t0> listE = E();
            i iVar = this.f15996n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listE) {
                if (l0.g(((eo.m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            iVar.n(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        public final List<t0> y() {
            List<yo.a.n> list = this.f15984b;
            i iVar = this.f15996n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                t0 t0VarL = iVar.f15978b.f14756i.l((yo.a.n) ((q) it.next()));
                if (t0VarL != null) {
                    arrayList.add(t0VarL);
                }
            }
            return arrayList;
        }

        public final List<d1> z() {
            List<yo.a.r> list = this.f15985c;
            i iVar = this.f15996n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                d1 d1VarM = iVar.f15978b.f14756i.m((yo.a.r) ((q) it.next()));
                if (d1VarM != null) {
                    arrayList.add(d1VarM);
                }
            }
            return arrayList;
        }
    }

    public final class c implements a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ un.o<Object>[] f15997j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Map<dp.f, byte[]> f15998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final Map<dp.f, byte[]> f15999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final Map<dp.f, byte[]> f16000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final up.g<dp.f, Collection<y0>> f16001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final up.g<dp.f, Collection<t0>> f16002e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final up.h<dp.f, d1> f16003f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final up.i f16004g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public final up.i f16005h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ i f16006i;

        public static final class a extends n0 implements jn.a<Object> {
            final /* synthetic */ ByteArrayInputStream $inputStream;
            final /* synthetic */ s<Object> $parser;
            final /* synthetic */ i this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(s<Object> sVar, ByteArrayInputStream byteArrayInputStream, i iVar) {
                super(0);
                this.$parser = sVar;
                this.$inputStream = byteArrayInputStream;
                this.this$0 = iVar;
            }

            @Override // jn.a
            @os.m
            public final Object invoke() {
                return (q) this.$parser.d(this.$inputStream, this.this$0.f15978b.f14748a.f14742p);
            }
        }

        public static final class b extends n0 implements jn.a<Set<? extends dp.f>> {
            final /* synthetic */ i this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(i iVar) {
                super(0);
                this.this$1 = iVar;
            }

            @Override // jn.a
            @os.l
            public final Set<? extends dp.f> invoke() {
                return p1.D(c.this.f15998a.keySet(), this.this$1.v());
            }
        }

        /* JADX INFO: renamed from: tp.i$c$c, reason: collision with other inner class name */
        public static final class C0416c extends n0 implements jn.l<dp.f, Collection<? extends y0>> {
            public C0416c() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final Collection<y0> invoke(@os.l dp.f fVar) {
                l0.p(fVar, "it");
                return c.this.m(fVar);
            }
        }

        public static final class d extends n0 implements jn.l<dp.f, Collection<? extends t0>> {
            public d() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final Collection<t0> invoke(@os.l dp.f fVar) {
                l0.p(fVar, "it");
                return c.this.n(fVar);
            }
        }

        public static final class e extends n0 implements jn.l<dp.f, d1> {
            public e() {
                super(1);
            }

            @Override // jn.l
            @os.m
            public final d1 invoke(@os.l dp.f fVar) {
                l0.p(fVar, "it");
                return c.this.o(fVar);
            }
        }

        public static final class f extends n0 implements jn.a<Set<? extends dp.f>> {
            final /* synthetic */ i this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(i iVar) {
                super(0);
                this.this$1 = iVar;
            }

            @Override // jn.a
            @os.l
            public final Set<? extends dp.f> invoke() {
                return p1.D(c.this.f15999b.keySet(), this.this$1.w());
            }
        }

        static {
            g1 g1Var = new g1(l1.d(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;");
            m1 m1Var = l1.f9319a;
            f15997j = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public c(@os.l i iVar, @os.l List<yo.a.i> list, @os.l List<yo.a.n> list2, List<yo.a.r> list3) throws IOException {
            Map<dp.f, byte[]> mapZ;
            l0.p(iVar, "this$0");
            l0.p(list, "functionList");
            l0.p(list2, "propertyList");
            l0.p(list3, "typeAliasList");
            this.f16006i = iVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                dp.f fVarB = x.b(iVar.f15978b.f14749b, ((yo.a.i) ((q) obj)).getName());
                Object arrayList = linkedHashMap.get(fVarB);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(fVarB, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f15998a = p(linkedHashMap);
            i iVar2 = this.f16006i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : list2) {
                dp.f fVarB2 = x.b(iVar2.f15978b.f14749b, ((yo.a.n) ((q) obj2)).getName());
                Object arrayList2 = linkedHashMap2.get(fVarB2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(fVarB2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.f15999b = p(linkedHashMap2);
            if (this.f16006i.f15978b.f14748a.f14729c.c()) {
                i iVar3 = this.f16006i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : list3) {
                    dp.f fVarB3 = x.b(iVar3.f15978b.f14749b, ((yo.a.r) ((q) obj3)).getName());
                    Object arrayList3 = linkedHashMap3.get(fVarB3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(fVarB3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapZ = p(linkedHashMap3);
            } else {
                mapZ = nm.d1.z();
            }
            this.f16000c = mapZ;
            this.f16001d = this.f16006i.f15978b.f14748a.f14727a.a(new C0416c());
            this.f16002e = this.f16006i.f15978b.f14748a.f14727a.a(new d());
            this.f16003f = this.f16006i.f15978b.f14748a.f14727a.f(new e());
            i iVar4 = this.f16006i;
            this.f16004g = iVar4.f15978b.f14748a.f14727a.h(new b(iVar4));
            i iVar5 = this.f16006i;
            this.f16005h = iVar5.f15978b.f14748a.f14727a.h(new f(iVar5));
        }

        @Override // tp.i.a
        @os.l
        public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            return !b().contains(fVar) ? k0.INSTANCE : this.f16001d.invoke(fVar);
        }

        @Override // tp.i.a
        @os.l
        public Set<dp.f> b() {
            return (Set) up.m.a(this.f16004g, this, f15997j[0]);
        }

        @Override // tp.i.a
        @os.l
        public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            return !d().contains(fVar) ? k0.INSTANCE : this.f16002e.invoke(fVar);
        }

        @Override // tp.i.a
        @os.l
        public Set<dp.f> d() {
            return (Set) up.m.a(this.f16005h, this, f15997j[1]);
        }

        @Override // tp.i.a
        @os.l
        public Set<dp.f> e() {
            return this.f16000c.keySet();
        }

        @Override // tp.i.a
        @os.m
        public d1 f(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            return this.f16003f.invoke(fVar);
        }

        @Override // tp.i.a
        public void g(@os.l Collection<eo.m> collection, @os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar, @os.l mo.b bVar) {
            l0.p(collection, "result");
            l0.p(dVar, "kindFilter");
            l0.p(lVar, "nameFilter");
            l0.p(bVar, "location");
            op.d.f12368c.getClass();
            if (dVar.a(op.d.f12375j)) {
                Set<dp.f> setD = d();
                ArrayList arrayList = new ArrayList();
                for (dp.f fVar : setD) {
                    if (lVar.invoke(fVar).booleanValue()) {
                        arrayList.addAll(c(fVar, bVar));
                    }
                }
                hp.g.b bVar2 = hp.g.b.f7488a;
                l0.o(bVar2, "INSTANCE");
                c0.p0(arrayList, bVar2);
                collection.addAll(arrayList);
            }
            op.d.f12368c.getClass();
            if (dVar.a(op.d.f12374i)) {
                Set<dp.f> setB = b();
                ArrayList arrayList2 = new ArrayList();
                for (dp.f fVar2 : setB) {
                    if (lVar.invoke(fVar2).booleanValue()) {
                        arrayList2.addAll(a(fVar2, bVar));
                    }
                }
                hp.g.b bVar3 = hp.g.b.f7488a;
                l0.o(bVar3, "INSTANCE");
                c0.p0(arrayList2, bVar3);
                collection.addAll(arrayList2);
            }
        }

        public final Collection<y0> m(dp.f fVar) {
            Map<dp.f, byte[]> map = this.f15998a;
            s<yo.a.i> sVar = yo.a.i.PARSER;
            l0.o(sVar, "PARSER");
            i iVar = this.f16006i;
            byte[] bArr = map.get(fVar);
            Collection<yo.a.i> collectionC3 = bArr == null ? k0.INSTANCE : v.c3(gq.s.m(new a(sVar, new ByteArrayInputStream(bArr), this.f16006i)));
            ArrayList arrayList = new ArrayList(collectionC3.size());
            for (yo.a.i iVar2 : collectionC3) {
                w wVar = iVar.f15978b.f14756i;
                l0.o(iVar2, "it");
                y0 y0VarJ = wVar.j(iVar2);
                if (!iVar.z(y0VarJ)) {
                    y0VarJ = null;
                }
                if (y0VarJ != null) {
                    arrayList.add(y0VarJ);
                }
            }
            iVar.m(fVar, arrayList);
            return eq.a.c(arrayList);
        }

        public final Collection<t0> n(dp.f fVar) {
            Map<dp.f, byte[]> map = this.f15999b;
            s<yo.a.n> sVar = yo.a.n.PARSER;
            l0.o(sVar, "PARSER");
            i iVar = this.f16006i;
            byte[] bArr = map.get(fVar);
            Collection<yo.a.n> collectionC3 = bArr == null ? k0.INSTANCE : v.c3(gq.s.m(new a(sVar, new ByteArrayInputStream(bArr), this.f16006i)));
            ArrayList arrayList = new ArrayList(collectionC3.size());
            for (yo.a.n nVar : collectionC3) {
                w wVar = iVar.f15978b.f14756i;
                l0.o(nVar, "it");
                t0 t0VarL = wVar.l(nVar);
                if (t0VarL != null) {
                    arrayList.add(t0VarL);
                }
            }
            iVar.n(fVar, arrayList);
            return eq.a.c(arrayList);
        }

        public final d1 o(dp.f fVar) {
            yo.a.r delimitedFrom;
            byte[] bArr = this.f16000c.get(fVar);
            if (bArr == null || (delimitedFrom = yo.a.r.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.f16006i.f15978b.f14748a.f14742p)) == null) {
                return null;
            }
            return this.f16006i.f15978b.f14756i.m(delimitedFrom);
        }

        public final Map<dp.f, byte[]> p(Map<dp.f, ? extends Collection<? extends fp.a>> map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(c1.j(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(z.b0(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((fp.a) it2.next()).writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(l2.f10208a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }
    }

    public static final class d extends n0 implements jn.a<Set<? extends dp.f>> {
        final /* synthetic */ jn.a<Collection<dp.f>> $classNames;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(jn.a<? extends Collection<dp.f>> aVar) {
            super(0);
            this.$classNames = aVar;
        }

        @Override // jn.a
        @os.l
        public final Set<? extends dp.f> invoke() {
            return h0.a6(this.$classNames.invoke());
        }
    }

    public static final class e extends n0 implements jn.a<Set<? extends dp.f>> {
        public e() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final Set<? extends dp.f> invoke() {
            Set<dp.f> setU = i.this.u();
            if (setU == null) {
                return null;
            }
            return p1.D(p1.D(i.this.s(), i.this.f15979c.e()), setU);
        }
    }

    static {
        g1 g1Var = new g1(l1.d(i.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;");
        m1 m1Var = l1.f9319a;
        f15977f = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(i.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public i(@os.l rp.l lVar, @os.l List<yo.a.i> list, @os.l List<yo.a.n> list2, @os.l List<yo.a.r> list3, @os.l jn.a<? extends Collection<dp.f>> aVar) {
        l0.p(lVar, "c");
        l0.p(list, "functionList");
        l0.p(list2, "propertyList");
        l0.p(list3, "typeAliasList");
        l0.p(aVar, "classNames");
        this.f15978b = lVar;
        this.f15979c = p(list, list2, list3);
        this.f15980d = lVar.f14748a.f14727a.h(new d(aVar));
        this.f15981e = lVar.f14748a.f14727a.g(new e());
    }

    @Override // op.i, op.h, op.k
    @os.l
    public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return this.f15979c.a(fVar, bVar);
    }

    @Override // op.i, op.h
    @os.l
    public Set<dp.f> b() {
        return this.f15979c.b();
    }

    @Override // op.i, op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return this.f15979c.c(fVar, bVar);
    }

    @Override // op.i, op.h
    @os.l
    public Set<dp.f> d() {
        return this.f15979c.d();
    }

    @Override // op.i, op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        if (y(fVar)) {
            return q(fVar);
        }
        if (this.f15979c.e().contains(fVar)) {
            return this.f15979c.f(fVar);
        }
        return null;
    }

    @Override // op.i, op.h
    @os.m
    public Set<dp.f> h() {
        return t();
    }

    public abstract void k(@os.l Collection<eo.m> collection, @os.l jn.l<? super dp.f, Boolean> lVar);

    @os.l
    public final Collection<eo.m> l(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar, @os.l mo.b bVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        l0.p(bVar, "location");
        ArrayList arrayList = new ArrayList(0);
        op.d.a aVar = op.d.f12368c;
        aVar.getClass();
        if (dVar.a(op.d.f12371f)) {
            k(arrayList, lVar);
        }
        this.f15979c.g(arrayList, dVar, lVar, bVar);
        aVar.getClass();
        if (dVar.a(op.d.f12377l)) {
            for (dp.f fVar : s()) {
                if (lVar.invoke(fVar).booleanValue()) {
                    eq.a.a(arrayList, q(fVar));
                }
            }
        }
        op.d.f12368c.getClass();
        if (dVar.a(op.d.f12372g)) {
            for (dp.f fVar2 : this.f15979c.e()) {
                if (lVar.invoke(fVar2).booleanValue()) {
                    eq.a.a(arrayList, this.f15979c.f(fVar2));
                }
            }
        }
        return eq.a.c(arrayList);
    }

    public void m(@os.l dp.f fVar, @os.l List<y0> list) {
        l0.p(fVar, "name");
        l0.p(list, "functions");
    }

    public void n(@os.l dp.f fVar, @os.l List<t0> list) {
        l0.p(fVar, "name");
        l0.p(list, "descriptors");
    }

    @os.l
    public abstract dp.b o(@os.l dp.f fVar);

    public final a p(List<yo.a.i> list, List<yo.a.n> list2, List<yo.a.r> list3) {
        return this.f15978b.f14748a.f14729c.a() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
    }

    public final eo.e q(dp.f fVar) {
        return this.f15978b.f14748a.b(o(fVar));
    }

    @os.l
    public final rp.l r() {
        return this.f15978b;
    }

    @os.l
    public final Set<dp.f> s() {
        return (Set) up.m.a(this.f15980d, this, f15977f[0]);
    }

    public final Set<dp.f> t() {
        return (Set) up.m.b(this.f15981e, this, f15977f[1]);
    }

    @os.m
    public abstract Set<dp.f> u();

    @os.l
    public abstract Set<dp.f> v();

    @os.l
    public abstract Set<dp.f> w();

    public final d1 x(dp.f fVar) {
        return this.f15979c.f(fVar);
    }

    public boolean y(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        return s().contains(fVar);
    }

    public boolean z(@os.l y0 y0Var) {
        l0.p(y0Var, "function");
        return true;
    }
}
