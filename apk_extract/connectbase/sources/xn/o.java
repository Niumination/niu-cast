package xn;

import java.util.Collection;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import lm.o1;
import lm.t0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Class<?> f20387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public final String f20388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final a0.b<a> f20389f;

    public final class a extends j.b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ un.o<Object>[] f20390j;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final a0.a f20391d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final a0.a f20392e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final a0.b f20393f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final a0.b f20394g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public final a0.a f20395h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ o f20396i;

        /* JADX INFO: renamed from: xn.o$a$a, reason: collision with other inner class name */
        public static final class C0525a extends n0 implements jn.a<jo.f> {
            final /* synthetic */ o this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0525a(o oVar) {
                super(0);
                this.this$0 = oVar;
            }

            @Override // jn.a
            @os.m
            public final jo.f invoke() {
                return jo.f.f8758c.a(this.this$0.f20387d);
            }
        }

        public static final class b extends n0 implements jn.a<Collection<? extends f<?>>> {
            final /* synthetic */ o this$0;
            final /* synthetic */ a this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(o oVar, a aVar) {
                super(0);
                this.this$0 = oVar;
                this.this$1 = aVar;
            }

            @Override // jn.a
            public final Collection<? extends f<?>> invoke() {
                return this.this$0.L(this.this$1.g(), j.c.DECLARED);
            }
        }

        public static final class c extends n0 implements jn.a<o1<? extends cp.f, ? extends yo.a.l, ? extends cp.e>> {
            public c() {
                super(0);
            }

            @Override // jn.a
            @os.m
            public final o1<? extends cp.f, ? extends yo.a.l, ? extends cp.e> invoke() {
                jo.f fVarC = a.this.c();
                if (fVarC == null) {
                    return null;
                }
                xo.a aVar = fVarC.f8760b;
                String[] strArr = aVar.f20440c;
                String[] strArr2 = aVar.f20442e;
                if (strArr == null || strArr2 == null) {
                    return null;
                }
                t0<cp.f, yo.a.l> t0VarM = cp.g.m(strArr, strArr2);
                return new o1<>(t0VarM.component1(), t0VarM.component2(), aVar.f20439b);
            }
        }

        public static final class d extends n0 implements jn.a<Class<?>> {
            final /* synthetic */ o this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(o oVar) {
                super(0);
                this.this$1 = oVar;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.m
            public final Class<?> invoke() {
                jo.f fVarC = a.this.c();
                String strE = fVarC == null ? null : fVarC.f8760b.e();
                if (strE == null || strE.length() <= 0) {
                    return null;
                }
                return this.this$1.f20387d.getClassLoader().loadClass(jq.e0.h2(strE, el.b0.f4502a, n1.e.f11183c, false, 4, null));
            }
        }

        public static final class e extends n0 implements jn.a<op.h> {
            public e() {
                super(0);
            }

            @Override // jn.a
            public final op.h invoke() {
                jo.f fVarC = a.this.c();
                return fVarC != null ? a.this.a().f8767b.a(fVarC) : op.h.c.f12406b;
            }
        }

        static {
            g1 g1Var = new g1(l1.d(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;");
            m1 m1Var = l1.f9319a;
            f20390j = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), m1Var.n(new g1(m1Var.d(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), m1Var.n(new g1(m1Var.d(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), m1Var.n(new g1(m1Var.d(a.class), "members", "getMembers()Ljava/util/Collection;"))};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar) {
            super(oVar);
            l0.p(oVar, "this$0");
            this.f20396i = oVar;
            this.f20391d = a0.d(new C0525a(oVar));
            this.f20392e = a0.d(new e());
            this.f20393f = a0.b(new d(oVar));
            this.f20394g = a0.b(new c());
            this.f20395h = a0.d(new b(oVar, this));
        }

        public final jo.f c() {
            a0.a aVar = this.f20391d;
            un.o<Object> oVar = f20390j[0];
            return (jo.f) aVar.invoke();
        }

        @os.l
        public final Collection<f<?>> d() {
            a0.a aVar = this.f20395h;
            un.o<Object> oVar = f20390j[4];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-members>(...)");
            return (Collection) objInvoke;
        }

        @os.m
        public final o1<cp.f, yo.a.l, cp.e> e() {
            a0.b bVar = this.f20394g;
            un.o<Object> oVar = f20390j[3];
            return (o1) bVar.invoke();
        }

        @os.m
        public final Class<?> f() {
            a0.b bVar = this.f20393f;
            un.o<Object> oVar = f20390j[2];
            return (Class) bVar.invoke();
        }

        @os.l
        public final op.h g() {
            a0.a aVar = this.f20392e;
            un.o<Object> oVar = f20390j[1];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-scope>(...)");
            return (op.h) objInvoke;
        }
    }

    public static final class b extends n0 implements jn.a<a> {
        public b() {
            super(0);
        }

        @Override // jn.a
        public final a invoke() {
            return new a(o.this);
        }
    }

    public /* synthetic */ class c extends kn.g0 implements jn.p<rp.w, yo.a.n, eo.t0> {
        public static final c INSTANCE = new c();

        public c() {
            super(2);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "loadProperty";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(rp.w.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // jn.p
        @os.l
        public final eo.t0 invoke(@os.l rp.w wVar, @os.l yo.a.n nVar) {
            l0.p(wVar, "p0");
            l0.p(nVar, "p1");
            return wVar.l(nVar);
        }
    }

    public o(@os.l Class<?> cls, @os.m String str) {
        l0.p(cls, "jClass");
        this.f20387d = cls;
        this.f20388e = str;
        a0.b<a> bVarB = a0.b(new b());
        l0.o(bVarB, "lazy { Data() }");
        this.f20389f = bVarB;
    }

    @Override // xn.j
    @os.l
    public Collection<eo.l> I() {
        return k0.INSTANCE;
    }

    @Override // xn.j
    @os.l
    public Collection<eo.y> J(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        return U().a(fVar, mo.d.FROM_REFLECTION);
    }

    @Override // xn.j
    @os.m
    public eo.t0 K(int i10) {
        o1<cp.f, yo.a.l, cp.e> o1VarE = this.f20389f.invoke().e();
        if (o1VarE == null) {
            return null;
        }
        cp.f fVarComponent1 = o1VarE.component1();
        yo.a.l lVarComponent2 = o1VarE.component2();
        cp.e eVarComponent3 = o1VarE.component3();
        fp.i.g<yo.a.l, List<yo.a.n>> gVar = bp.a.f1016n;
        l0.o(gVar, "packageLocalVariable");
        yo.a.n nVar = (yo.a.n) ap.e.b(lVarComponent2, gVar, i10);
        if (nVar == null) {
            return null;
        }
        Class<?> cls = this.f20387d;
        yo.a.t typeTable = lVarComponent2.getTypeTable();
        l0.o(typeTable, "packageProto.typeTable");
        return (eo.t0) h0.h(cls, nVar, fVarComponent1, new ap.g(typeTable), eVarComponent3, c.INSTANCE);
    }

    @Override // xn.j
    @os.l
    public Class<?> M() {
        Class<?> clsF = this.f20389f.invoke().f();
        return clsF == null ? this.f20387d : clsF;
    }

    @Override // xn.j
    @os.l
    public Collection<eo.t0> N(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        return U().c(fVar, mo.d.FROM_REFLECTION);
    }

    public final op.h U() {
        return this.f20389f.invoke().g();
    }

    @Override // un.h
    @os.l
    public Collection<un.c<?>> d() {
        return this.f20389f.invoke().d();
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof o) && l0.g(this.f20387d, ((o) obj).f20387d);
    }

    public int hashCode() {
        return this.f20387d.hashCode();
    }

    @Override // kn.t
    @os.l
    public Class<?> s() {
        return this.f20387d;
    }

    @os.l
    public String toString() {
        return l0.C("file class ", ko.d.a(this.f20387d).b());
    }

    public /* synthetic */ o(Class cls, String str, int i10, kn.w wVar) {
        this(cls, (i10 & 2) != 0 ? null : str);
    }
}
