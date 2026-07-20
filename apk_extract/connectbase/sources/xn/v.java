package xn;

import eo.d1;
import eo.e1;
import ik.y0;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m0;
import kn.m1;
import kn.n0;
import lm.j0;
import nm.k0;
import vp.c1;
import vp.j1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements m0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f20426e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final vp.f0 f20427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final a0.a<Type> f20428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final a0.a f20429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final a0.a f20430d;

    public static final class a extends n0 implements jn.a<List<? extends un.u>> {
        final /* synthetic */ jn.a<Type> $computeJavaType;

        /* JADX INFO: renamed from: xn.v$a$a, reason: collision with other inner class name */
        public static final class C0526a extends n0 implements jn.a<Type> {
            final /* synthetic */ int $i;
            final /* synthetic */ lm.d0<List<Type>> $parameterizedTypeArguments$delegate;
            final /* synthetic */ v this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0526a(v vVar, int i10, lm.d0<? extends List<? extends Type>> d0Var) {
                super(0);
                this.this$0 = vVar;
                this.$i = i10;
                this.$parameterizedTypeArguments$delegate = d0Var;
            }

            @Override // jn.a
            @os.l
            public final Type invoke() {
                Type typeP = this.this$0.p();
                if (typeP instanceof Class) {
                    Class cls = (Class) typeP;
                    Class<?> componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    l0.o(componentType, "{\n                      …                        }");
                    return componentType;
                }
                if (typeP instanceof GenericArrayType) {
                    if (this.$i != 0) {
                        throw new y(l0.C("Array type has been queried for a non-0th argument: ", this.this$0));
                    }
                    Type genericComponentType = ((GenericArrayType) typeP).getGenericComponentType();
                    l0.o(genericComponentType, "{\n                      …                        }");
                    return genericComponentType;
                }
                if (!(typeP instanceof ParameterizedType)) {
                    throw new y(l0.C("Non-generic type has been queried for arguments: ", this.this$0));
                }
                Type type = (Type) a.m76access$invoke$lambda0(this.$parameterizedTypeArguments$delegate).get(this.$i);
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    l0.o(lowerBounds, "argument.lowerBounds");
                    Type type2 = (Type) nm.r.nc(lowerBounds);
                    if (type2 == null) {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        l0.o(upperBounds, "argument.upperBounds");
                        type = (Type) nm.r.Rb(upperBounds);
                    } else {
                        type = type2;
                    }
                }
                l0.o(type, "{\n                      …                        }");
                return type;
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20431a;

            static {
                int[] iArr = new int[o1.values().length];
                iArr[o1.INVARIANT.ordinal()] = 1;
                iArr[o1.IN_VARIANCE.ordinal()] = 2;
                iArr[o1.OUT_VARIANCE.ordinal()] = 3;
                f20431a = iArr;
            }
        }

        public static final class c extends n0 implements jn.a<List<? extends Type>> {
            final /* synthetic */ v this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(v vVar) {
                super(0);
                this.this$0 = vVar;
            }

            @Override // jn.a
            @os.l
            public final List<? extends Type> invoke() {
                Type typeP = this.this$0.p();
                l0.m(typeP);
                return ko.d.d(typeP);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.a<? extends Type> aVar) {
            super(0);
            this.$computeJavaType = aVar;
        }

        public static final List<Type> a(lm.d0<? extends List<? extends Type>> d0Var) {
            return (List) d0Var.getValue();
        }

        /* JADX INFO: renamed from: access$invoke$lambda-0, reason: not valid java name */
        public static final List m76access$invoke$lambda0(lm.d0 d0Var) {
            return (List) d0Var.getValue();
        }

        @Override // jn.a
        public final List<? extends un.u> invoke() {
            un.u uVarE;
            List<c1> listF0 = v.this.f20427a.F0();
            if (listF0.isEmpty()) {
                return k0.INSTANCE;
            }
            lm.d0 d0VarC = lm.f0.c(lm.h0.PUBLICATION, new c(v.this));
            List<c1> list = listF0;
            jn.a<Type> aVar = this.$computeJavaType;
            v vVar = v.this;
            ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    nm.y.Z();
                }
                c1 c1Var = (c1) obj;
                if (c1Var.a()) {
                    un.u.f16346c.getClass();
                    uVarE = un.u.f16347d;
                } else {
                    vp.f0 type = c1Var.getType();
                    l0.o(type, "typeProjection.type");
                    v vVar2 = new v(type, aVar == null ? null : new C0526a(vVar, i10, d0VarC));
                    int i12 = b.f20431a[c1Var.c().ordinal()];
                    if (i12 == 1) {
                        uVarE = un.u.f16346c.e(vVar2);
                    } else if (i12 == 2) {
                        uVarE = un.u.f16346c.a(vVar2);
                    } else {
                        if (i12 != 3) {
                            throw new lm.i0();
                        }
                        uVarE = un.u.f16346c.b(vVar2);
                    }
                }
                arrayList.add(uVarE);
                i10 = i11;
            }
            return arrayList;
        }
    }

    public static final class b extends n0 implements jn.a<un.g> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final un.g invoke() {
            v vVar = v.this;
            return vVar.m(vVar.f20427a);
        }
    }

    static {
        g1 g1Var = new g1(l1.d(v.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;");
        m1 m1Var = l1.f9319a;
        f20426e = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(v.class), "arguments", "getArguments()Ljava/util/List;"))};
    }

    public v(@os.l vp.f0 f0Var, @os.m jn.a<? extends Type> aVar) {
        l0.p(f0Var, y0.a.f8215h);
        this.f20427a = f0Var;
        a0.a<Type> aVarD = null;
        a0.a<Type> aVar2 = aVar instanceof a0.a ? (a0.a) aVar : null;
        if (aVar2 != null) {
            aVarD = aVar2;
        } else if (aVar != null) {
            aVarD = a0.d(aVar);
        }
        this.f20428b = aVarD;
        this.f20429c = a0.d(new b());
        this.f20430d = a0.d(new a(aVar));
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof v) && l0.g(this.f20427a, ((v) obj).f20427a);
    }

    @Override // un.b
    @os.l
    public List<Annotation> getAnnotations() {
        return h0.e(this.f20427a);
    }

    public int hashCode() {
        return this.f20427a.hashCode();
    }

    @Override // un.s
    @os.m
    public un.g i() {
        a0.a aVar = this.f20429c;
        un.o<Object> oVar = f20426e[0];
        return (un.g) aVar.invoke();
    }

    public final un.g m(vp.f0 f0Var) {
        eo.h hVarD = f0Var.G0().d();
        if (!(hVarD instanceof eo.e)) {
            if (hVarD instanceof e1) {
                return new w(null, (e1) hVarD);
            }
            if (hVarD instanceof d1) {
                throw new j0(l0.C("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
            }
            return null;
        }
        Class<?> clsP = h0.p((eo.e) hVarD);
        if (clsP == null) {
            return null;
        }
        if (!clsP.isArray()) {
            if (j1.m(f0Var)) {
                return new h(clsP);
            }
            Class<?> clsE = ko.d.e(clsP);
            if (clsE != null) {
                clsP = clsE;
            }
            return new h(clsP);
        }
        c1 c1Var = (c1) nm.h0.k5(f0Var.F0());
        if (c1Var == null) {
            return new h(clsP);
        }
        vp.f0 type = c1Var.getType();
        l0.o(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
        un.g gVarM = m(type);
        if (gVarM != null) {
            return new h(h0.f(in.b.e(wn.d.a(gVarM))));
        }
        throw new y(l0.C("Cannot determine classifier for array element type: ", this));
    }

    @Override // un.s
    @os.l
    public List<un.u> n() {
        a0.a aVar = this.f20430d;
        un.o<Object> oVar = f20426e[1];
        Object objInvoke = aVar.invoke();
        l0.o(objInvoke, "<get-arguments>(...)");
        return (List) objInvoke;
    }

    @Override // un.s
    public boolean o() {
        return this.f20427a.H0();
    }

    @Override // kn.m0
    @os.m
    public Type p() {
        a0.a<Type> aVar = this.f20428b;
        if (aVar == null) {
            return null;
        }
        return aVar.invoke();
    }

    @os.l
    public final vp.f0 s() {
        return this.f20427a;
    }

    @os.l
    public String toString() {
        return c0.f20308a.h(this.f20427a);
    }

    @os.l
    public final v y(boolean z10) {
        if (!vp.c0.b(this.f20427a) && this.f20427a.H0() == z10) {
            return this;
        }
        vp.f0 f0VarQ = j1.q(this.f20427a, z10);
        l0.o(f0VarQ, "makeNullableAsSpecified(type, nullable)");
        return new v(f0VarQ, this.f20428b);
    }

    public /* synthetic */ v(vp.f0 f0Var, jn.a aVar, int i10, kn.w wVar) {
        this(f0Var, (i10 & 2) != 0 ? null : aVar);
    }
}
