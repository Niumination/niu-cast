package xn;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends f<Object> implements kn.e0<Object>, un.i<Object>, xn.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f20374v;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final j f20375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final String f20376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public final Object f20377g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final a0.a f20378i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final a0.b f20379n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final a0.b f20380p;

    public static final class a extends n0 implements jn.a<yn.d<? extends Member>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        public final yn.d<? extends Member> invoke() {
            Object objG;
            yn.e<Constructor<?>> eVarS;
            d dVarG = d0.f20319a.g(k.this.L());
            if (dVarG instanceof d.C0520d) {
                if (k.this.J()) {
                    Class<?> clsS = k.this.f20375e.s();
                    List<un.n> parameters = k.this.getParameters();
                    ArrayList arrayList = new ArrayList(nm.z.b0(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((un.n) it.next()).getName();
                        l0.m(name);
                        arrayList.add(name);
                    }
                    return new yn.a(clsS, arrayList, yn.a.EnumC0551a.POSITIONAL_CALL, yn.a.b.KOTLIN, null, 16, null);
                }
                objG = k.this.f20375e.C(((d.C0520d) dVarG).f20315a.f3368b);
            } else if (dVarG instanceof d.e) {
                j jVar = k.this.f20375e;
                cp.d.b bVar = ((d.e) dVarG).f20317a;
                objG = jVar.G(bVar.f3367a, bVar.f3368b);
            } else if (dVarG instanceof d.c) {
                objG = ((d.c) dVarG).f20314a;
            } else {
                if (!(dVarG instanceof d.b)) {
                    if (!(dVarG instanceof d.a)) {
                        throw new lm.i0();
                    }
                    List<Method> list = ((d.a) dVarG).f20312b;
                    Class<?> clsS2 = k.this.f20375e.s();
                    List<Method> list2 = list;
                    ArrayList arrayList2 = new ArrayList(nm.z.b0(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Method) it2.next()).getName());
                    }
                    return new yn.a(clsS2, arrayList2, yn.a.EnumC0551a.POSITIONAL_CALL, yn.a.b.JAVA, list);
                }
                objG = ((d.b) dVarG).f20313a;
            }
            if (objG instanceof Constructor) {
                k kVar = k.this;
                eVarS = kVar.Q((Constructor) objG, kVar.L());
            } else {
                if (!(objG instanceof Method)) {
                    throw new y("Could not compute caller for function: " + k.this.L() + " (member = " + objG + ')');
                }
                Method method = (Method) objG;
                if (Modifier.isStatic(method.getModifiers())) {
                    eVarS = k.this.L().getAnnotations().d(h0.j()) != null ? k.this.S(method) : k.this.T(method);
                } else {
                    eVarS = k.this.R(method);
                }
            }
            return yn.h.c(eVarS, k.this.L(), false, 2, null);
        }
    }

    public static final class b extends n0 implements jn.a<yn.d<? extends Member>> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final yn.d<? extends Member> invoke() {
            GenericDeclaration genericDeclarationD;
            yn.e<Constructor<?>> eVarT;
            d dVarG = d0.f20319a.g(k.this.L());
            if (dVarG instanceof d.e) {
                k kVar = k.this;
                j jVar = kVar.f20375e;
                cp.d.b bVar = ((d.e) dVarG).f20317a;
                String str = bVar.f3367a;
                String str2 = bVar.f3368b;
                Member memberB = kVar.F().b();
                l0.m(memberB);
                genericDeclarationD = jVar.E(str, str2, !Modifier.isStatic(memberB.getModifiers()));
            } else if (dVarG instanceof d.C0520d) {
                if (k.this.J()) {
                    Class<?> clsS = k.this.f20375e.s();
                    List<un.n> parameters = k.this.getParameters();
                    ArrayList arrayList = new ArrayList(nm.z.b0(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((un.n) it.next()).getName();
                        l0.m(name);
                        arrayList.add(name);
                    }
                    return new yn.a(clsS, arrayList, yn.a.EnumC0551a.CALL_BY_NAME, yn.a.b.KOTLIN, null, 16, null);
                }
                genericDeclarationD = k.this.f20375e.D(((d.C0520d) dVarG).f20315a.f3368b);
            } else {
                if (dVarG instanceof d.a) {
                    List<Method> list = ((d.a) dVarG).f20312b;
                    Class<?> clsS2 = k.this.f20375e.s();
                    List<Method> list2 = list;
                    ArrayList arrayList2 = new ArrayList(nm.z.b0(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Method) it2.next()).getName());
                    }
                    return new yn.a(clsS2, arrayList2, yn.a.EnumC0551a.CALL_BY_NAME, yn.a.b.JAVA, list);
                }
                genericDeclarationD = null;
            }
            if (genericDeclarationD instanceof Constructor) {
                k kVar2 = k.this;
                eVarT = kVar2.Q((Constructor) genericDeclarationD, kVar2.L());
            } else if (genericDeclarationD instanceof Method) {
                eVarT = (k.this.L().getAnnotations().d(h0.j()) == null || ((eo.e) k.this.L().b()).a0()) ? k.this.T((Method) genericDeclarationD) : k.this.S((Method) genericDeclarationD);
            } else {
                eVarT = null;
            }
            if (eVarT == null) {
                return null;
            }
            return yn.h.b(eVarT, k.this.L(), true);
        }
    }

    public static final class c extends n0 implements jn.a<eo.y> {
        final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.$name = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        public final eo.y invoke() {
            k kVar = k.this;
            return kVar.f20375e.F(this.$name, kVar.f20376f);
        }
    }

    static {
        g1 g1Var = new g1(l1.d(k.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;");
        m1 m1Var = l1.f9319a;
        f20374v = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(k.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), m1Var.n(new g1(m1Var.d(k.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    }

    public /* synthetic */ k(j jVar, String str, String str2, eo.y yVar, Object obj, int i10, kn.w wVar) {
        this(jVar, str, str2, yVar, (i10 & 16) != 0 ? kn.q.NO_RECEIVER : obj);
    }

    private final Object U() {
        return yn.h.a(this.f20377g, L());
    }

    @Override // xn.f
    @os.l
    public yn.d<?> F() {
        a0.b bVar = this.f20379n;
        un.o<Object> oVar = f20374v[1];
        Object objInvoke = bVar.invoke();
        l0.o(objInvoke, "<get-caller>(...)");
        return (yn.d) objInvoke;
    }

    @Override // xn.f
    @os.l
    public j G() {
        return this.f20375e;
    }

    @Override // xn.f
    @os.m
    public yn.d<?> H() {
        a0.b bVar = this.f20380p;
        un.o<Object> oVar = f20374v[2];
        return (yn.d) bVar.invoke();
    }

    @Override // xn.f
    public boolean K() {
        return !l0.g(this.f20377g, kn.q.NO_RECEIVER);
    }

    public final yn.e<Constructor<?>> Q(Constructor<?> constructor, eo.y yVar) {
        if (mp.b.f(yVar)) {
            return K() ? new yn.e.a(constructor, U()) : new yn.e.b(constructor);
        }
        return K() ? new yn.e.c(constructor, U()) : new yn.e.C0553e(constructor);
    }

    public final yn.e.h R(Method method) {
        return K() ? new yn.e.h.a(method, U()) : new yn.e.h.d(method);
    }

    public final yn.e.h S(Method method) {
        return K() ? new yn.e.h.b(method) : new yn.e.h.C0556e(method);
    }

    public final yn.e.h T(Method method) {
        return K() ? new yn.e.h.c(method, U()) : new yn.e.h.f(method);
    }

    @Override // xn.f
    @os.l
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public eo.y L() {
        a0.a aVar = this.f20378i;
        un.o<Object> oVar = f20374v[0];
        Object objInvoke = aVar.invoke();
        l0.o(objInvoke, "<get-descriptor>(...)");
        return (eo.y) objInvoke;
    }

    public boolean equals(@os.m Object obj) {
        k kVarC = h0.c(obj);
        return kVarC != null && l0.g(this.f20375e, kVarC.f20375e) && l0.g(getName(), kVarC.getName()) && l0.g(this.f20376f, kVarC.f20376f) && l0.g(this.f20377g, kVarC.f20377g);
    }

    @Override // kn.e0
    public int getArity() {
        return yn.f.a(F());
    }

    @Override // un.c
    @os.l
    public String getName() {
        String strB = L().getName().b();
        l0.o(strB, "descriptor.name.asString()");
        return strB;
    }

    public int hashCode() {
        return this.f20376f.hashCode() + ((getName().hashCode() + (this.f20375e.hashCode() * 31)) * 31);
    }

    @Override // jn.a
    @os.m
    public Object invoke() {
        return xn.c.a.a(this);
    }

    @Override // un.i
    public boolean isExternal() {
        return L().isExternal();
    }

    @Override // un.i
    public boolean isInfix() {
        return L().isInfix();
    }

    @Override // un.i
    public boolean isInline() {
        return L().isInline();
    }

    @Override // un.i
    public boolean isOperator() {
        return L().isOperator();
    }

    @Override // un.c, un.i
    public boolean isSuspend() {
        return L().isSuspend();
    }

    @os.l
    public String toString() {
        return c0.f20308a.d(L());
    }

    @Override // jn.l
    @os.m
    public Object invoke(@os.m Object obj) {
        return xn.c.a.b(this, obj);
    }

    public k(j jVar, String str, String str2, eo.y yVar, Object obj) {
        this.f20375e = jVar;
        this.f20376f = str2;
        this.f20377g = obj;
        this.f20378i = a0.c(yVar, new c(str));
        this.f20379n = a0.b(new a());
        this.f20380p = a0.b(new b());
    }

    @Override // jn.p
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2) {
        return xn.c.a.c(this, obj, obj2);
    }

    @Override // jn.q
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3) {
        return xn.c.a.d(this, obj, obj2, obj3);
    }

    @Override // jn.r
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4) {
        return xn.c.a.e(this, obj, obj2, obj3, obj4);
    }

    @Override // jn.s
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5) {
        return xn.c.a.f(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // jn.t
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6) {
        return xn.c.a.g(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // jn.u
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7) {
        return xn.c.a.h(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // jn.v
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8) {
        return xn.c.a.i(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(@os.l j jVar, @os.l String str, @os.l String str2, @os.m Object obj) {
        this(jVar, str, str2, null, obj);
        l0.p(jVar, "container");
        l0.p(str, "name");
        l0.p(str2, "signature");
    }

    @Override // jn.w
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9) {
        return xn.c.a.j(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public k(@os.l j jVar, @os.l eo.y yVar) {
        l0.p(jVar, "container");
        l0.p(yVar, "descriptor");
        String strB = yVar.getName().b();
        l0.o(strB, "descriptor.name.asString()");
        this(jVar, strB, d0.f20319a.g(yVar).a(), yVar, null, 16, null);
    }

    @Override // jn.b
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10) {
        return xn.c.a.k(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // jn.c
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11) {
        return xn.c.a.l(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // jn.d
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12) {
        return xn.c.a.m(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // jn.e
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13) {
        return xn.c.a.n(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // jn.f
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14) {
        return xn.c.a.o(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // jn.g
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14, @os.m Object obj15) {
        return xn.c.a.p(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // jn.h
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14, @os.m Object obj15, @os.m Object obj16) {
        return xn.c.a.q(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // jn.i
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14, @os.m Object obj15, @os.m Object obj16, @os.m Object obj17) {
        return xn.c.a.r(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // jn.j
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14, @os.m Object obj15, @os.m Object obj16, @os.m Object obj17, @os.m Object obj18) {
        return xn.c.a.s(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // jn.k
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14, @os.m Object obj15, @os.m Object obj16, @os.m Object obj17, @os.m Object obj18, @os.m Object obj19) {
        return xn.c.a.t(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // jn.m
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14, @os.m Object obj15, @os.m Object obj16, @os.m Object obj17, @os.m Object obj18, @os.m Object obj19, @os.m Object obj20) {
        return xn.c.a.u(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // jn.n
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14, @os.m Object obj15, @os.m Object obj16, @os.m Object obj17, @os.m Object obj18, @os.m Object obj19, @os.m Object obj20, @os.m Object obj21) {
        return xn.c.a.v(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // jn.o
    @os.m
    public Object invoke(@os.m Object obj, @os.m Object obj2, @os.m Object obj3, @os.m Object obj4, @os.m Object obj5, @os.m Object obj6, @os.m Object obj7, @os.m Object obj8, @os.m Object obj9, @os.m Object obj10, @os.m Object obj11, @os.m Object obj12, @os.m Object obj13, @os.m Object obj14, @os.m Object obj15, @os.m Object obj16, @os.m Object obj17, @os.m Object obj18, @os.m Object obj19, @os.m Object obj20, @os.m Object obj21, @os.m Object obj22) {
        return xn.c.a.w(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
