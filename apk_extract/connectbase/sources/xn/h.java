package xn;

import eo.e1;
import eo.t0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jq.m0;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import kn.u1;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class h<T> extends j implements un.d<T>, i, x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Class<T> f20337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final a0.b<h<T>.a> f20338e;

    public final class a extends xn.j.b {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final /* synthetic */ un.o<Object>[] f20339w;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final a0.a f20340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final a0.a f20341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final a0.a f20342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final a0.a f20343g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public final a0.a f20344h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final a0.a f20345i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.l
        public final a0.b f20346j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @os.l
        public final a0.a f20347k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @os.l
        public final a0.a f20348l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @os.l
        public final a0.a f20349m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @os.l
        public final a0.a f20350n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @os.l
        public final a0.a f20351o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @os.l
        public final a0.a f20352p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @os.l
        public final a0.a f20353q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @os.l
        public final a0.a f20354r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @os.l
        public final a0.a f20355s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @os.l
        public final a0.a f20356t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @os.l
        public final a0.a f20357u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ h<T> f20358v;

        /* JADX INFO: renamed from: xn.h$a$a, reason: collision with other inner class name */
        public static final class C0522a extends n0 implements jn.a<List<? extends xn.f<?>>> {
            final /* synthetic */ h<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0522a(h<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // jn.a
            public final List<? extends xn.f<?>> invoke() {
                return nm.h0.E4(this.this$0.h(), this.this$0.i());
            }
        }

        public static final class b extends n0 implements jn.a<List<? extends xn.f<?>>> {
            final /* synthetic */ h<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(h<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // jn.a
            public final List<? extends xn.f<?>> invoke() {
                return nm.h0.E4(this.this$0.m(), this.this$0.p());
            }
        }

        public static final class c extends n0 implements jn.a<List<? extends xn.f<?>>> {
            final /* synthetic */ h<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(h<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // jn.a
            public final List<? extends xn.f<?>> invoke() {
                return nm.h0.E4(this.this$0.n(), this.this$0.q());
            }
        }

        public static final class d extends n0 implements jn.a<List<? extends Annotation>> {
            final /* synthetic */ h<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(h<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // jn.a
            public final List<? extends Annotation> invoke() {
                return h0.e(this.this$0.o());
            }
        }

        public static final class e extends n0 implements jn.a<List<? extends un.i<? extends T>>> {
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(h<T> hVar) {
                super(0);
                this.this$0 = hVar;
            }

            @Override // jn.a
            public final List<un.i<T>> invoke() {
                Collection<eo.l> collectionI = this.this$0.I();
                h<T> hVar = this.this$0;
                ArrayList arrayList = new ArrayList(nm.z.b0(collectionI, 10));
                Iterator<T> it = collectionI.iterator();
                while (it.hasNext()) {
                    arrayList.add(new xn.k(hVar, (eo.l) it.next()));
                }
                return arrayList;
            }
        }

        public static final class f extends n0 implements jn.a<List<? extends xn.f<?>>> {
            final /* synthetic */ h<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(h<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // jn.a
            public final List<? extends xn.f<?>> invoke() {
                return nm.h0.E4(this.this$0.m(), this.this$0.n());
            }
        }

        public static final class g extends n0 implements jn.a<Collection<? extends xn.f<?>>> {
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(h<T> hVar) {
                super(0);
                this.this$0 = hVar;
            }

            @Override // jn.a
            public final Collection<? extends xn.f<?>> invoke() {
                h<T> hVar = this.this$0;
                return hVar.L(hVar.Z(), xn.j.c.DECLARED);
            }
        }

        /* JADX INFO: renamed from: xn.h$a$h, reason: collision with other inner class name */
        public static final class C0523h extends n0 implements jn.a<Collection<? extends xn.f<?>>> {
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0523h(h<T> hVar) {
                super(0);
                this.this$0 = hVar;
            }

            @Override // jn.a
            public final Collection<? extends xn.f<?>> invoke() {
                h<T> hVar = this.this$0;
                return hVar.L(hVar.a0(), xn.j.c.DECLARED);
            }
        }

        public static final class i extends n0 implements jn.a<eo.e> {
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public i(h<T> hVar) {
                super(0);
                this.this$0 = hVar;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            public final eo.e invoke() {
                dp.b bVarW = this.this$0.W();
                jo.k kVarA = this.this$0.f20338e.invoke().a();
                eo.e eVarB = bVarW.f3808c ? kVarA.f8766a.b(bVarW) : eo.x.a(kVarA.f8766a.f14728b, bVarW);
                if (eVarB != null) {
                    return eVarB;
                }
                this.this$0.b0();
                throw null;
            }
        }

        public static final class j extends n0 implements jn.a<Collection<? extends xn.f<?>>> {
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(h<T> hVar) {
                super(0);
                this.this$0 = hVar;
            }

            @Override // jn.a
            public final Collection<? extends xn.f<?>> invoke() {
                h<T> hVar = this.this$0;
                return hVar.L(hVar.Z(), xn.j.c.INHERITED);
            }
        }

        public static final class k extends n0 implements jn.a<Collection<? extends xn.f<?>>> {
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public k(h<T> hVar) {
                super(0);
                this.this$0 = hVar;
            }

            @Override // jn.a
            public final Collection<? extends xn.f<?>> invoke() {
                h<T> hVar = this.this$0;
                return hVar.L(hVar.a0(), xn.j.c.INHERITED);
            }
        }

        public static final class l extends n0 implements jn.a<List<? extends h<? extends Object>>> {
            final /* synthetic */ h<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public l(h<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // jn.a
            public final List<? extends h<? extends Object>> invoke() {
                op.h hVarV = this.this$0.o().V();
                l0.o(hVarV, "descriptor.unsubstitutedInnerClassesScope");
                Collection collectionA = op.k.a.a(hVarV, null, null, 3, null);
                ArrayList<eo.m> arrayList = new ArrayList();
                for (T t10 : collectionA) {
                    if (!hp.d.B((eo.m) t10)) {
                        arrayList.add(t10);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (eo.m mVar : arrayList) {
                    eo.e eVar = mVar instanceof eo.e ? (eo.e) mVar : null;
                    Class<?> clsP = eVar == null ? null : h0.p(eVar);
                    h hVar = clsP == null ? null : new h(clsP);
                    if (hVar != null) {
                        arrayList2.add(hVar);
                    }
                }
                return arrayList2;
            }
        }

        public static final class m extends n0 implements jn.a<T> {
            final /* synthetic */ h<T>.a this$0;
            final /* synthetic */ h<T> this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public m(h<T>.a aVar, h<T> hVar) {
                super(0);
                this.this$0 = aVar;
                this.this$1 = hVar;
            }

            @Override // jn.a
            @os.m
            public final T invoke() {
                eo.e eVarO = this.this$0.o();
                if (eVarO.getKind() != eo.f.OBJECT) {
                    return null;
                }
                T t10 = (T) ((!eVarO.a0() || ao.d.a(ao.c.f519a, eVarO)) ? this.this$1.f20337d.getDeclaredField("INSTANCE") : this.this$1.f20337d.getEnclosingClass().getDeclaredField(eVarO.getName().b())).get(null);
                if (t10 != null) {
                    return t10;
                }
                throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            }
        }

        public static final class n extends n0 implements jn.a<String> {
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public n(h<T> hVar) {
                super(0);
                this.this$0 = hVar;
            }

            @Override // jn.a
            @os.m
            public final String invoke() {
                if (this.this$0.f20337d.isAnonymousClass()) {
                    return null;
                }
                dp.b bVarW = this.this$0.W();
                if (bVarW.f3808c) {
                    return null;
                }
                return bVarW.b().b();
            }
        }

        public static final class o extends n0 implements jn.a<List<? extends h<? extends T>>> {
            final /* synthetic */ h<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public o(h<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // jn.a
            public final List<h<? extends T>> invoke() {
                Collection<eo.e> collectionK = this.this$0.o().k();
                l0.o(collectionK, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (eo.e eVar : collectionK) {
                    if (eVar == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                    Class<?> clsP = h0.p(eVar);
                    h hVar = clsP == null ? null : new h(clsP);
                    if (hVar != null) {
                        arrayList.add(hVar);
                    }
                }
                return arrayList;
            }
        }

        public static final class p extends n0 implements jn.a<String> {
            final /* synthetic */ h<T> this$0;
            final /* synthetic */ h<T>.a this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public p(h<T> hVar, h<T>.a aVar) {
                super(0);
                this.this$0 = hVar;
                this.this$1 = aVar;
            }

            @Override // jn.a
            @os.m
            public final String invoke() {
                if (this.this$0.f20337d.isAnonymousClass()) {
                    return null;
                }
                dp.b bVarW = this.this$0.W();
                if (bVarW.f3808c) {
                    return this.this$1.f(this.this$0.f20337d);
                }
                String strB = bVarW.j().b();
                l0.o(strB, "classId.shortClassName.asString()");
                return strB;
            }
        }

        public static final class q extends n0 implements jn.a<List<? extends v>> {
            final /* synthetic */ h<T>.a this$0;
            final /* synthetic */ h<T> this$1;

            /* JADX INFO: renamed from: xn.h$a$q$a, reason: collision with other inner class name */
            public static final class C0524a extends n0 implements jn.a<Type> {
                final /* synthetic */ vp.f0 $kotlinType;
                final /* synthetic */ h<T>.a this$0;
                final /* synthetic */ h<T> this$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0524a(vp.f0 f0Var, h<T>.a aVar, h<T> hVar) {
                    super(0);
                    this.$kotlinType = f0Var;
                    this.this$0 = aVar;
                    this.this$1 = hVar;
                }

                @Override // jn.a
                @os.l
                public final Type invoke() {
                    eo.h hVarD = this.$kotlinType.G0().d();
                    if (!(hVarD instanceof eo.e)) {
                        throw new y(l0.C("Supertype not a class: ", hVarD));
                    }
                    Class<?> clsP = h0.p((eo.e) hVarD);
                    if (clsP == null) {
                        throw new y("Unsupported superclass of " + this.this$0 + ": " + hVarD);
                    }
                    if (l0.g(this.this$1.f20337d.getSuperclass(), clsP)) {
                        Type genericSuperclass = this.this$1.f20337d.getGenericSuperclass();
                        l0.o(genericSuperclass, "{\n                      …ass\n                    }");
                        return genericSuperclass;
                    }
                    Class<?>[] interfaces = this.this$1.f20337d.getInterfaces();
                    l0.o(interfaces, "jClass.interfaces");
                    int iIf = nm.r.If(interfaces, clsP);
                    if (iIf >= 0) {
                        Type type = this.this$1.f20337d.getGenericInterfaces()[iIf];
                        l0.o(type, "{\n                      …ex]\n                    }");
                        return type;
                    }
                    throw new y("No superclass of " + this.this$0 + " in Java reflection for " + hVarD);
                }
            }

            public static final class b extends n0 implements jn.a<Type> {
                public static final b INSTANCE = new b();

                public b() {
                    super(0);
                }

                @Override // jn.a
                @os.l
                public final Type invoke() {
                    return Object.class;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public q(h<T>.a aVar, h<T> hVar) {
                super(0);
                this.this$0 = aVar;
                this.this$1 = hVar;
            }

            @Override // jn.a
            public final List<? extends v> invoke() {
                Collection<vp.f0> collectionA = this.this$0.o().i().a();
                l0.o(collectionA, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(collectionA.size());
                h<T>.a aVar = this.this$0;
                h<T> hVar = this.this$1;
                for (vp.f0 f0Var : collectionA) {
                    l0.o(f0Var, "kotlinType");
                    arrayList.add(new v(f0Var, new C0524a(f0Var, aVar, hVar)));
                }
                if (!ao.h.s0(this.this$0.o())) {
                    if (arrayList.isEmpty()) {
                        vp.n0 n0VarI = lp.a.g(this.this$0.o()).i();
                        l0.o(n0VarI, "descriptor.builtIns.anyType");
                        arrayList.add(new v(n0VarI, b.INSTANCE));
                    } else {
                        Iterator<T> it = arrayList.iterator();
                        while (it.hasNext()) {
                            eo.f kind = hp.d.e(((v) it.next()).f20427a).getKind();
                            l0.o(kind, "getClassDescriptorForType(it.type).kind");
                            if (kind == eo.f.INTERFACE || kind == eo.f.ANNOTATION_CLASS) {
                            }
                        }
                        vp.n0 n0VarI2 = lp.a.g(this.this$0.o()).i();
                        l0.o(n0VarI2, "descriptor.builtIns.anyType");
                        arrayList.add(new v(n0VarI2, b.INSTANCE));
                    }
                }
                return eq.a.c(arrayList);
            }
        }

        public static final class r extends n0 implements jn.a<List<? extends w>> {
            final /* synthetic */ h<T>.a this$0;
            final /* synthetic */ h<T> this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public r(h<T>.a aVar, h<T> hVar) {
                super(0);
                this.this$0 = aVar;
                this.this$1 = hVar;
            }

            @Override // jn.a
            public final List<? extends w> invoke() {
                List<e1> listR = this.this$0.o().r();
                l0.o(listR, "descriptor.declaredTypeParameters");
                List<e1> list = listR;
                h<T> hVar = this.this$1;
                ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
                for (e1 e1Var : list) {
                    l0.o(e1Var, "descriptor");
                    arrayList.add(new w(hVar, e1Var));
                }
                return arrayList;
            }
        }

        static {
            g1 g1Var = new g1(l1.d(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
            m1 m1Var = l1.f9319a;
            f20339w = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(a.class), "annotations", "getAnnotations()Ljava/util/List;")), m1Var.n(new g1(m1Var.d(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), m1Var.n(new g1(m1Var.d(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), m1Var.n(new g1(m1Var.d(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), m1Var.n(new g1(m1Var.d(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), m1Var.n(new g1(m1Var.d(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), m1Var.n(new g1(m1Var.d(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), m1Var.n(new g1(m1Var.d(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), m1Var.n(new g1(m1Var.d(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar) {
            super(hVar);
            l0.p(hVar, "this$0");
            this.f20358v = hVar;
            this.f20340d = a0.d(new i(hVar));
            this.f20341e = a0.d(new d(this));
            this.f20342f = a0.d(new p(hVar, this));
            this.f20343g = a0.d(new n(hVar));
            this.f20344h = a0.d(new e(hVar));
            this.f20345i = a0.d(new l(this));
            this.f20346j = a0.b(new m(this, hVar));
            this.f20347k = a0.d(new r(this, hVar));
            this.f20348l = a0.d(new q(this, hVar));
            this.f20349m = a0.d(new o(this));
            this.f20350n = a0.d(new g(hVar));
            this.f20351o = a0.d(new C0523h(hVar));
            this.f20352p = a0.d(new j(hVar));
            this.f20353q = a0.d(new k(hVar));
            this.f20354r = a0.d(new b(this));
            this.f20355s = a0.d(new c(this));
            this.f20356t = a0.d(new f(this));
            this.f20357u = a0.d(new C0522a(this));
        }

        public final String f(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                l0.o(simpleName, "name");
                return jq.h0.n5(simpleName, l0.C(enclosingMethod.getName(), "$"), null, 2, null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                l0.o(simpleName, "name");
                return jq.h0.m5(simpleName, m0.f8865c, null, 2, null);
            }
            l0.o(simpleName, "name");
            return jq.h0.n5(simpleName, l0.C(enclosingConstructor.getName(), "$"), null, 2, null);
        }

        @os.l
        public final Collection<xn.f<?>> g() {
            a0.a aVar = this.f20357u;
            un.o<Object> oVar = f20339w[17];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-allMembers>(...)");
            return (Collection) objInvoke;
        }

        @os.l
        public final Collection<xn.f<?>> h() {
            a0.a aVar = this.f20354r;
            un.o<Object> oVar = f20339w[14];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-allNonStaticMembers>(...)");
            return (Collection) objInvoke;
        }

        @os.l
        public final Collection<xn.f<?>> i() {
            a0.a aVar = this.f20355s;
            un.o<Object> oVar = f20339w[15];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-allStaticMembers>(...)");
            return (Collection) objInvoke;
        }

        @os.l
        public final List<Annotation> j() {
            a0.a aVar = this.f20341e;
            un.o<Object> oVar = f20339w[1];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-annotations>(...)");
            return (List) objInvoke;
        }

        @os.l
        public final Collection<un.i<T>> k() {
            a0.a aVar = this.f20344h;
            un.o<Object> oVar = f20339w[4];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-constructors>(...)");
            return (Collection) objInvoke;
        }

        @os.l
        public final Collection<xn.f<?>> l() {
            a0.a aVar = this.f20356t;
            un.o<Object> oVar = f20339w[16];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-declaredMembers>(...)");
            return (Collection) objInvoke;
        }

        @os.l
        public final Collection<xn.f<?>> m() {
            a0.a aVar = this.f20350n;
            un.o<Object> oVar = f20339w[10];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-declaredNonStaticMembers>(...)");
            return (Collection) objInvoke;
        }

        public final Collection<xn.f<?>> n() {
            a0.a aVar = this.f20351o;
            un.o<Object> oVar = f20339w[11];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-declaredStaticMembers>(...)");
            return (Collection) objInvoke;
        }

        @os.l
        public final eo.e o() {
            a0.a aVar = this.f20340d;
            un.o<Object> oVar = f20339w[0];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-descriptor>(...)");
            return (eo.e) objInvoke;
        }

        public final Collection<xn.f<?>> p() {
            a0.a aVar = this.f20352p;
            un.o<Object> oVar = f20339w[12];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-inheritedNonStaticMembers>(...)");
            return (Collection) objInvoke;
        }

        public final Collection<xn.f<?>> q() {
            a0.a aVar = this.f20353q;
            un.o<Object> oVar = f20339w[13];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-inheritedStaticMembers>(...)");
            return (Collection) objInvoke;
        }

        @os.l
        public final Collection<un.d<?>> r() {
            a0.a aVar = this.f20345i;
            un.o<Object> oVar = f20339w[5];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-nestedClasses>(...)");
            return (Collection) objInvoke;
        }

        @os.m
        public final T s() {
            a0.b bVar = this.f20346j;
            un.o<Object> oVar = f20339w[6];
            return (T) bVar.invoke();
        }

        @os.m
        public final String t() {
            a0.a aVar = this.f20343g;
            un.o<Object> oVar = f20339w[3];
            return (String) aVar.invoke();
        }

        @os.l
        public final List<un.d<? extends T>> u() {
            a0.a aVar = this.f20349m;
            un.o<Object> oVar = f20339w[9];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-sealedSubclasses>(...)");
            return (List) objInvoke;
        }

        @os.m
        public final String v() {
            a0.a aVar = this.f20342f;
            un.o<Object> oVar = f20339w[2];
            return (String) aVar.invoke();
        }

        @os.l
        public final List<un.s> w() {
            a0.a aVar = this.f20348l;
            un.o<Object> oVar = f20339w[8];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-supertypes>(...)");
            return (List) objInvoke;
        }

        @os.l
        public final List<un.t> x() {
            a0.a aVar = this.f20347k;
            un.o<Object> oVar = f20339w[7];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-typeParameters>(...)");
            return (List) objInvoke;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20359a;

        static {
            int[] iArr = new int[xo.a.EnumC0527a.values().length];
            iArr[xo.a.EnumC0527a.FILE_FACADE.ordinal()] = 1;
            iArr[xo.a.EnumC0527a.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[xo.a.EnumC0527a.MULTIFILE_CLASS_PART.ordinal()] = 3;
            iArr[xo.a.EnumC0527a.SYNTHETIC_CLASS.ordinal()] = 4;
            iArr[xo.a.EnumC0527a.UNKNOWN.ordinal()] = 5;
            iArr[xo.a.EnumC0527a.CLASS.ordinal()] = 6;
            f20359a = iArr;
        }
    }

    public static final class c extends n0 implements jn.a<h<T>.a> {
        final /* synthetic */ h<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h<T> hVar) {
            super(0);
            this.this$0 = hVar;
        }

        @Override // jn.a
        public final h<T>.a invoke() {
            return new a(this.this$0);
        }
    }

    public /* synthetic */ class d extends kn.g0 implements jn.p<rp.w, yo.a.n, t0> {
        public static final d INSTANCE = new d();

        public d() {
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
        public final t0 invoke(@os.l rp.w wVar, @os.l yo.a.n nVar) {
            l0.p(wVar, "p0");
            l0.p(nVar, "p1");
            return wVar.l(nVar);
        }
    }

    public h(@os.l Class<T> cls) {
        l0.p(cls, "jClass");
        this.f20337d = cls;
        a0.b<h<T>.a> bVarB = a0.b(new c(this));
        l0.o(bVarB, "lazy { Data() }");
        this.f20338e = bVarB;
    }

    @Override // xn.j
    @os.l
    public Collection<eo.l> I() {
        eo.e eVarY = y();
        if (eVarY.getKind() == eo.f.INTERFACE || eVarY.getKind() == eo.f.OBJECT) {
            return k0.INSTANCE;
        }
        Collection<eo.d> collectionG = eVarY.g();
        l0.o(collectionG, "descriptor.constructors");
        return collectionG;
    }

    @Override // xn.j
    @os.l
    public Collection<eo.y> J(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        op.h hVarZ = Z();
        mo.d dVar = mo.d.FROM_REFLECTION;
        return nm.h0.E4(hVarZ.a(fVar, dVar), a0().a(fVar, dVar));
    }

    @Override // xn.j
    @os.m
    public t0 K(int i10) {
        Class<?> declaringClass;
        if (l0.g(this.f20337d.getSimpleName(), "DefaultImpls") && (declaringClass = this.f20337d.getDeclaringClass()) != null && declaringClass.isInterface()) {
            return ((h) in.b.i(declaringClass)).K(i10);
        }
        eo.e eVarY = y();
        tp.e eVar = eVarY instanceof tp.e ? (tp.e) eVarY : null;
        if (eVar == null) {
            return null;
        }
        yo.a.c cVar = eVar.f15956g;
        fp.i.g<yo.a.c, List<yo.a.n>> gVar = bp.a.f1012j;
        l0.o(gVar, "classLocalVariable");
        yo.a.n nVar = (yo.a.n) ap.e.b(cVar, gVar, i10);
        if (nVar == null) {
            return null;
        }
        Class<T> cls = this.f20337d;
        rp.l lVar = eVar.f15963y;
        return (t0) h0.h(cls, nVar, lVar.f14749b, lVar.f14751d, eVar.f15957i, d.INSTANCE);
    }

    @Override // xn.j
    @os.l
    public Collection<t0> N(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        op.h hVarZ = Z();
        mo.d dVar = mo.d.FROM_REFLECTION;
        return nm.h0.E4(hVarZ.c(fVar, dVar), a0().c(fVar, dVar));
    }

    public final dp.b W() {
        return d0.f20319a.c(this.f20337d);
    }

    @os.l
    public final a0.b<h<T>.a> X() {
        return this.f20338e;
    }

    @Override // xn.i
    @os.l
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public eo.e y() {
        return this.f20338e.invoke().o();
    }

    @os.l
    public final op.h Z() {
        return y().q().o();
    }

    @Override // un.d
    @os.l
    public List<un.s> a() {
        return this.f20338e.invoke().w();
    }

    @os.l
    public final op.h a0() {
        op.h hVarK0 = y().k0();
        l0.o(hVarK0, "descriptor.staticScope");
        return hVarK0;
    }

    public final Void b0() {
        jo.f fVarA = jo.f.f8758c.a(this.f20337d);
        xo.a.EnumC0527a enumC0527a = fVarA == null ? null : fVarA.f8760b.f20438a;
        switch (enumC0527a == null ? -1 : b.f20359a[enumC0527a.ordinal()]) {
            case -1:
            case 6:
                throw new y(l0.C("Unresolved class: ", this.f20337d));
            case 0:
            default:
                throw new lm.i0();
            case 1:
            case 2:
            case 3:
                throw new UnsupportedOperationException(l0.C("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: ", this.f20337d));
            case 4:
                throw new UnsupportedOperationException(l0.C("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: ", this.f20337d));
            case 5:
                throw new y("Unknown class: " + this.f20337d + " (kind = " + enumC0527a + ')');
        }
    }

    @Override // un.d
    public boolean c() {
        return y().s() == eo.e0.SEALED;
    }

    @Override // un.h
    @os.l
    public Collection<un.c<?>> d() {
        return this.f20338e.invoke().g();
    }

    @Override // un.d
    @os.l
    public Collection<un.d<?>> e() {
        return this.f20338e.invoke().r();
    }

    @Override // un.d
    public boolean equals(@os.m Object obj) {
        return (obj instanceof h) && l0.g(in.b.g(this), in.b.g((un.d) obj));
    }

    @Override // un.d
    @os.l
    public Collection<un.i<T>> g() {
        return this.f20338e.invoke().k();
    }

    @Override // un.b
    @os.l
    public List<Annotation> getAnnotations() {
        return this.f20338e.invoke().j();
    }

    @Override // un.d
    @os.l
    public List<un.t> getTypeParameters() {
        return this.f20338e.invoke().x();
    }

    @Override // un.d
    @os.m
    public un.w getVisibility() {
        eo.u visibility = y().getVisibility();
        l0.o(visibility, "descriptor.visibility");
        return h0.q(visibility);
    }

    @Override // un.d
    @os.m
    public T h() {
        return this.f20338e.invoke().s();
    }

    @Override // un.d
    public int hashCode() {
        return in.b.g(this).hashCode();
    }

    @Override // un.d
    public boolean isAbstract() {
        return y().s() == eo.e0.ABSTRACT;
    }

    @Override // un.d
    public boolean isFinal() {
        return y().s() == eo.e0.FINAL;
    }

    @Override // un.d
    public boolean isOpen() {
        return y().s() == eo.e0.OPEN;
    }

    @Override // un.d
    @os.l
    public List<un.d<? extends T>> k() {
        return this.f20338e.invoke().u();
    }

    @Override // un.d
    public boolean l() {
        return y().l();
    }

    @Override // un.d
    public boolean q() {
        return y().a0();
    }

    @Override // un.d
    public boolean r(@os.m Object obj) {
        Integer numC = ko.d.c(this.f20337d);
        if (numC != null) {
            return u1.B(obj, numC.intValue());
        }
        Class clsG = ko.d.g(this.f20337d);
        if (clsG == null) {
            clsG = this.f20337d;
        }
        return clsG.isInstance(obj);
    }

    @Override // kn.t
    @os.l
    public Class<T> s() {
        return this.f20337d;
    }

    @Override // un.d
    public boolean t() {
        return y().t();
    }

    @os.l
    public String toString() {
        dp.b bVarW = W();
        dp.c cVarH = bVarW.h();
        l0.o(cVarH, "classId.packageFqName");
        String strC = cVarH.d() ? "" : l0.C(cVarH.b(), ".");
        String strB = bVarW.i().b();
        l0.o(strB, "classId.relativeClassName.asString()");
        return l0.C("class ", l0.C(strC, jq.e0.h2(strB, n1.e.f11183c, m0.f8865c, false, 4, null)));
    }

    @Override // un.d
    public boolean u() {
        return y().u();
    }

    @Override // un.d
    @os.m
    public String v() {
        return this.f20338e.invoke().t();
    }

    @Override // un.d
    @os.m
    public String w() {
        return this.f20338e.invoke().v();
    }

    @Override // un.d
    public boolean x() {
        return y().x();
    }
}
