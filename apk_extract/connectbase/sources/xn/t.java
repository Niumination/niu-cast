package xn;

import eo.s0;
import eo.t0;
import eo.u0;
import eo.v0;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import jq.m0;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t<V> extends xn.f<V> implements un.o<V> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final b f20412v = new b();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final Object f20413w = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final j f20414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final String f20415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final String f20416g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public final Object f20417i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final a0.b<Field> f20418n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final a0.a<t0> f20419p;

    public static abstract class a<PropertyType, ReturnType> extends xn.f<ReturnType> implements un.i<ReturnType>, un.o.a<PropertyType> {
        @Override // xn.f
        @os.l
        public j G() {
            return M().G();
        }

        @Override // xn.f
        @os.m
        public yn.d<?> H() {
            return null;
        }

        @Override // xn.f
        public boolean K() {
            return M().K();
        }

        @os.l
        public abstract s0 L();

        @os.l
        public abstract t<PropertyType> M();

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
    }

    public static final class b {
        public b() {
        }

        @os.l
        public final Object a() {
            return t.f20413w;
        }

        public b(kn.w wVar) {
        }
    }

    public static abstract class c<V> extends a<V, V> implements un.o.c<V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ un.o<Object>[] f20420g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final a0.a f20421e = a0.d(new b(this));

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final a0.b f20422f = a0.b(new a(this));

        public static final class a extends n0 implements jn.a<yn.d<?>> {
            final /* synthetic */ c<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(c<? extends V> cVar) {
                super(0);
                this.this$0 = cVar;
            }

            @Override // jn.a
            public final yn.d<?> invoke() {
                return u.b(this.this$0, true);
            }
        }

        public static final class b extends n0 implements jn.a<u0> {
            final /* synthetic */ c<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(c<? extends V> cVar) {
                super(0);
                this.this$0 = cVar;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            public final u0 invoke() {
                u0 getter = this.this$0.M().L().getGetter();
                if (getter != null) {
                    return getter;
                }
                t0 t0VarL = this.this$0.M().L();
                fo.g.f6167h.getClass();
                return hp.c.b(t0VarL, fo.g.a.f6169b);
            }
        }

        static {
            g1 g1Var = new g1(l1.d(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;");
            m1 m1Var = l1.f9319a;
            f20420g = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        }

        @Override // xn.f
        @os.l
        public yn.d<?> F() {
            a0.b bVar = this.f20422f;
            un.o<Object> oVar = f20420g[1];
            Object objInvoke = bVar.invoke();
            l0.o(objInvoke, "<get-caller>(...)");
            return (yn.d) objInvoke;
        }

        @Override // xn.t.a
        @os.l
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public u0 L() {
            a0.a aVar = this.f20421e;
            un.o<Object> oVar = f20420g[0];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-descriptor>(...)");
            return (u0) objInvoke;
        }

        public boolean equals(@os.m Object obj) {
            return (obj instanceof c) && l0.g(M(), ((c) obj).M());
        }

        @Override // un.c
        @os.l
        public String getName() {
            return "<get-" + M().getName() + m0.f8868f;
        }

        public int hashCode() {
            return M().hashCode();
        }

        @os.l
        public String toString() {
            return l0.C("getter of ", M());
        }
    }

    public static abstract class d<V> extends a<V, l2> implements un.j.b<V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ un.o<Object>[] f20423g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final a0.a f20424e = a0.d(new b(this));

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final a0.b f20425f = a0.b(new a(this));

        public static final class a extends n0 implements jn.a<yn.d<?>> {
            final /* synthetic */ d<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d<V> dVar) {
                super(0);
                this.this$0 = dVar;
            }

            @Override // jn.a
            public final yn.d<?> invoke() {
                return u.b(this.this$0, false);
            }
        }

        public static final class b extends n0 implements jn.a<v0> {
            final /* synthetic */ d<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(d<V> dVar) {
                super(0);
                this.this$0 = dVar;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            public final v0 invoke() {
                v0 setter = this.this$0.M().L().getSetter();
                if (setter != null) {
                    return setter;
                }
                t0 t0VarL = this.this$0.M().L();
                fo.g.a aVar = fo.g.f6167h;
                aVar.getClass();
                fo.g gVar = fo.g.a.f6169b;
                aVar.getClass();
                return hp.c.c(t0VarL, gVar, gVar);
            }
        }

        static {
            g1 g1Var = new g1(l1.d(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;");
            m1 m1Var = l1.f9319a;
            f20423g = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        }

        @Override // xn.f
        @os.l
        public yn.d<?> F() {
            a0.b bVar = this.f20425f;
            un.o<Object> oVar = f20423g[1];
            Object objInvoke = bVar.invoke();
            l0.o(objInvoke, "<get-caller>(...)");
            return (yn.d) objInvoke;
        }

        @Override // xn.t.a
        @os.l
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public v0 L() {
            a0.a aVar = this.f20424e;
            un.o<Object> oVar = f20423g[0];
            Object objInvoke = aVar.invoke();
            l0.o(objInvoke, "<get-descriptor>(...)");
            return (v0) objInvoke;
        }

        public boolean equals(@os.m Object obj) {
            return (obj instanceof d) && l0.g(M(), ((d) obj).M());
        }

        @Override // un.c
        @os.l
        public String getName() {
            return "<set-" + M().getName() + m0.f8868f;
        }

        public int hashCode() {
            return M().hashCode();
        }

        @os.l
        public String toString() {
            return l0.C("setter of ", M());
        }
    }

    public static final class e extends n0 implements jn.a<t0> {
        final /* synthetic */ t<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(t<? extends V> tVar) {
            super(0);
            this.this$0 = tVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        public final t0 invoke() {
            return this.this$0.G().H(this.this$0.getName(), this.this$0.f20416g);
        }
    }

    public static final class f extends n0 implements jn.a<Field> {
        final /* synthetic */ t<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(t<? extends V> tVar) {
            super(0);
            this.this$0 = tVar;
        }

        @Override // jn.a
        @os.m
        public final Field invoke() {
            Class<?> enclosingClass;
            xn.e eVarF = d0.f20319a.f(this.this$0.L());
            if (!(eVarF instanceof xn.e.c)) {
                if (eVarF instanceof xn.e.a) {
                    return ((xn.e.a) eVarF).f20321a;
                }
                if ((eVarF instanceof xn.e.b) || (eVarF instanceof xn.e.d)) {
                    return null;
                }
                throw new lm.i0();
            }
            xn.e.c cVar = (xn.e.c) eVarF;
            t0 t0Var = cVar.f20324a;
            cp.d.a aVarD = cp.g.d(cp.g.f3382a, cVar.f20325b, cVar.f20327d, cVar.f20328e, false, 8, null);
            if (aVarD == null) {
                return null;
            }
            t<V> tVar = this.this$0;
            if (no.k.e(t0Var) || cp.g.f(cVar.f20325b)) {
                enclosingClass = tVar.G().s().getEnclosingClass();
            } else {
                eo.m mVarB = t0Var.b();
                enclosingClass = mVarB instanceof eo.e ? h0.p((eo.e) mVarB) : tVar.G().s();
            }
            if (enclosingClass == null) {
                return null;
            }
            try {
                return enclosingClass.getDeclaredField(aVarD.f3365a);
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
    }

    public t(j jVar, String str, String str2, t0 t0Var, Object obj) {
        this.f20414e = jVar;
        this.f20415f = str;
        this.f20416g = str2;
        this.f20417i = obj;
        a0.b<Field> bVarB = a0.b(new f(this));
        l0.o(bVarB, "lazy {\n        when (val…y -> null\n        }\n    }");
        this.f20418n = bVarB;
        a0.a<t0> aVarC = a0.c(t0Var, new e(this));
        l0.o(aVarC, "lazySoft(descriptorIniti…or(name, signature)\n    }");
        this.f20419p = aVarC;
    }

    @Override // xn.f
    @os.l
    public yn.d<?> F() {
        return Q().F();
    }

    @Override // xn.f
    @os.l
    public j G() {
        return this.f20414e;
    }

    @Override // xn.f
    @os.m
    public yn.d<?> H() {
        return Q().H();
    }

    @Override // xn.f
    public boolean K() {
        return !l0.g(this.f20417i, kn.q.NO_RECEIVER);
    }

    @os.m
    public final Member M() {
        if (!L().C()) {
            return null;
        }
        xn.e eVarF = d0.f20319a.f(L());
        if (eVarF instanceof xn.e.c) {
            xn.e.c cVar = (xn.e.c) eVarF;
            if (cVar.f20326c.hasDelegateMethod()) {
                bp.a.c delegateMethod = cVar.f20326c.getDelegateMethod();
                if (!delegateMethod.hasName() || !delegateMethod.hasDesc()) {
                    return null;
                }
                return G().G(cVar.f20327d.c(delegateMethod.getName()), cVar.f20327d.c(delegateMethod.getDesc()));
            }
        }
        return R();
    }

    @os.m
    public final Object N() {
        return yn.h.a(this.f20417i, L());
    }

    @os.m
    public final Object O(@os.m Member member, @os.m Object obj, @os.m Object obj2) throws vn.b {
        try {
            Object obj3 = f20413w;
            if ((obj == obj3 || obj2 == obj3) && L().R() == null) {
                throw new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object objN = K() ? N() : obj;
            if (objN == obj3) {
                objN = null;
            }
            if (!K()) {
                obj = obj2;
            }
            if (obj == obj3) {
                obj = null;
            }
            if (member == null) {
                return null;
            }
            if (member instanceof Field) {
                return ((Field) member).get(objN);
            }
            if (!(member instanceof Method)) {
                throw new AssertionError("delegate field/method " + member + " neither field nor method");
            }
            int length = ((Method) member).getParameterTypes().length;
            if (length == 0) {
                return ((Method) member).invoke(null, null);
            }
            if (length == 1) {
                Method method = (Method) member;
                if (objN == null) {
                    Class<?> cls = ((Method) member).getParameterTypes()[0];
                    l0.o(cls, "fieldOrMethod.parameterTypes[0]");
                    objN = h0.g(cls);
                }
                return method.invoke(null, objN);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) member;
            if (obj == null) {
                Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                l0.o(cls2, "fieldOrMethod.parameterTypes[1]");
                obj = h0.g(cls2);
            }
            return method2.invoke(null, objN, obj);
        } catch (IllegalAccessException e10) {
            throw new vn.b(e10);
        }
    }

    @Override // xn.f
    @os.l
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public t0 L() {
        t0 t0VarInvoke = this.f20419p.invoke();
        l0.o(t0VarInvoke, "_descriptor()");
        return t0VarInvoke;
    }

    @os.l
    public abstract c<V> Q();

    @os.m
    public final Field R() {
        return this.f20418n.invoke();
    }

    @os.l
    public final String S() {
        return this.f20416g;
    }

    public boolean equals(@os.m Object obj) {
        t<?> tVarD = h0.d(obj);
        return tVarD != null && l0.g(G(), tVarD.G()) && l0.g(getName(), tVarD.getName()) && l0.g(this.f20416g, tVarD.f20416g) && l0.g(this.f20417i, tVarD.f20417i);
    }

    @Override // un.c
    @os.l
    public String getName() {
        return this.f20415f;
    }

    public int hashCode() {
        return this.f20416g.hashCode() + ((getName().hashCode() + (G().hashCode() * 31)) * 31);
    }

    @Override // un.o
    public boolean isConst() {
        return L().isConst();
    }

    @Override // un.o
    public boolean isLateinit() {
        return L().u0();
    }

    @Override // un.c, un.i
    public boolean isSuspend() {
        return false;
    }

    @os.l
    public String toString() {
        return c0.f20308a.g(L());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(@os.l j jVar, @os.l String str, @os.l String str2, @os.m Object obj) {
        this(jVar, str, str2, null, obj);
        l0.p(jVar, "container");
        l0.p(str, "name");
        l0.p(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public t(@os.l j jVar, @os.l t0 t0Var) {
        l0.p(jVar, "container");
        l0.p(t0Var, "descriptor");
        String strB = t0Var.getName().b();
        l0.o(strB, "descriptor.name.asString()");
        this(jVar, strB, d0.f20319a.f(t0Var).a(), t0Var, kn.q.NO_RECEIVER);
    }
}
