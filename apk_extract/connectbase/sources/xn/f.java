package xn;

import eo.e1;
import eo.h1;
import eo.q0;
import eo.w0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f<R> implements un.c<R>, x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final a0.a<List<Annotation>> f20332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final a0.a<ArrayList<un.n>> f20333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final a0.a<v> f20334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final a0.a<List<w>> f20335d;

    public static final class a extends n0 implements jn.a<List<? extends Annotation>> {
        final /* synthetic */ f<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(f<? extends R> fVar) {
            super(0);
            this.this$0 = fVar;
        }

        @Override // jn.a
        public final List<? extends Annotation> invoke() {
            return h0.e(this.this$0.L());
        }
    }

    public static final class b extends n0 implements jn.a<ArrayList<un.n>> {
        final /* synthetic */ f<R> this$0;

        public static final class a extends n0 implements jn.a<q0> {
            final /* synthetic */ w0 $instanceReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(w0 w0Var) {
                super(0);
                this.$instanceReceiver = w0Var;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final q0 invoke() {
                return this.$instanceReceiver;
            }
        }

        /* JADX INFO: renamed from: xn.f$b$b, reason: collision with other inner class name */
        public static final class C0521b extends n0 implements jn.a<q0> {
            final /* synthetic */ w0 $extensionReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0521b(w0 w0Var) {
                super(0);
                this.$extensionReceiver = w0Var;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final q0 invoke() {
                return this.$extensionReceiver;
            }
        }

        public static final class c extends n0 implements jn.a<q0> {
            final /* synthetic */ eo.b $descriptor;
            final /* synthetic */ int $i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(eo.b bVar, int i10) {
                super(0);
                this.$descriptor = bVar;
                this.$i = i10;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final q0 invoke() {
                h1 h1Var = this.$descriptor.h().get(this.$i);
                l0.o(h1Var, "descriptor.valueParameters[i]");
                return h1Var;
            }
        }

        public static final class d<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return rm.g.l(((un.n) t10).getName(), ((un.n) t11).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(f<? extends R> fVar) {
            super(0);
            this.this$0 = fVar;
        }

        @Override // jn.a
        public final ArrayList<un.n> invoke() {
            int i10;
            eo.b bVarI = this.this$0.L();
            ArrayList<un.n> arrayList = new ArrayList<>();
            int i11 = 0;
            if (this.this$0.K()) {
                i10 = 0;
            } else {
                w0 w0VarI = h0.i(bVarI);
                if (w0VarI != null) {
                    arrayList.add(new p(this.this$0, 0, un.n.b.INSTANCE, new a(w0VarI)));
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                w0 w0VarR = bVarI.R();
                if (w0VarR != null) {
                    arrayList.add(new p(this.this$0, i10, un.n.b.EXTENSION_RECEIVER, new C0521b(w0VarR)));
                    i10++;
                }
            }
            int size = bVarI.h().size();
            while (i11 < size) {
                arrayList.add(new p(this.this$0, i10, un.n.b.VALUE, new c(bVarI, i11)));
                i11++;
                i10++;
            }
            if (this.this$0.J() && (bVarI instanceof po.a) && arrayList.size() > 1) {
                nm.c0.p0(arrayList, new d());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    public static final class c extends n0 implements jn.a<v> {
        final /* synthetic */ f<R> this$0;

        public static final class a extends n0 implements jn.a<Type> {
            final /* synthetic */ f<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(f<? extends R> fVar) {
                super(0);
                this.this$0 = fVar;
            }

            @Override // jn.a
            @os.l
            public final Type invoke() {
                Type typeE = this.this$0.E();
                return typeE == null ? this.this$0.F().getReturnType() : typeE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(f<? extends R> fVar) {
            super(0);
            this.this$0 = fVar;
        }

        @Override // jn.a
        public final v invoke() {
            vp.f0 returnType = this.this$0.L().getReturnType();
            l0.m(returnType);
            l0.o(returnType, "descriptor.returnType!!");
            return new v(returnType, new a(this.this$0));
        }
    }

    public static final class d extends n0 implements jn.a<List<? extends w>> {
        final /* synthetic */ f<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(f<? extends R> fVar) {
            super(0);
            this.this$0 = fVar;
        }

        @Override // jn.a
        public final List<? extends w> invoke() {
            List<e1> typeParameters = this.this$0.L().getTypeParameters();
            l0.o(typeParameters, "descriptor.typeParameters");
            List<e1> list = typeParameters;
            f<R> fVar = this.this$0;
            ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
            for (e1 e1Var : list) {
                l0.o(e1Var, "descriptor");
                arrayList.add(new w(fVar, e1Var));
            }
            return arrayList;
        }
    }

    public f() {
        a0.a<List<Annotation>> aVarD = a0.d(new a(this));
        l0.o(aVarD, "lazySoft { descriptor.computeAnnotations() }");
        this.f20332a = aVarD;
        a0.a<ArrayList<un.n>> aVarD2 = a0.d(new b(this));
        l0.o(aVarD2, "lazySoft {\n        val d…ze()\n        result\n    }");
        this.f20333b = aVarD2;
        a0.a<v> aVarD3 = a0.d(new c(this));
        l0.o(aVarD3, "lazySoft {\n        KType…eturnType\n        }\n    }");
        this.f20334c = aVarD3;
        a0.a<List<w>> aVarD4 = a0.d(new d(this));
        l0.o(aVarD4, "lazySoft {\n        descr…this, descriptor) }\n    }");
        this.f20335d = aVarD4;
    }

    public final R B(Map<un.n, ? extends Object> map) throws vn.a {
        Object objD;
        List<un.n> parameters = getParameters();
        ArrayList arrayList = new ArrayList(nm.z.b0(parameters, 10));
        for (un.n nVar : parameters) {
            if (map.containsKey(nVar)) {
                objD = map.get(nVar);
                if (objD == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + nVar + ')');
                }
            } else if (nVar.z()) {
                objD = null;
            } else {
                if (!nVar.b()) {
                    throw new IllegalArgumentException(l0.C("No argument provided for a required parameter: ", nVar));
                }
                objD = D(nVar.getType());
            }
            arrayList.add(objD);
        }
        yn.d<?> dVarH = H();
        if (dVarH == null) {
            throw new y(l0.C("This callable does not support a default call: ", L()));
        }
        try {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return (R) dVarH.call(array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        } catch (IllegalAccessException e10) {
            throw new vn.a(e10);
        }
    }

    public final R C(@os.l Map<un.n, ? extends Object> map, @os.m um.d<?> dVar) throws vn.a {
        l0.p(map, d6.a.F);
        List<un.n> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<un.n> it = parameters.iterator();
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (dVar != null) {
                    arrayList.add(dVar);
                }
                if (!z10) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    if (array != null) {
                        return call(Arrays.copyOf(array, array.length));
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                arrayList2.add(Integer.valueOf(i11));
                yn.d<?> dVarH = H();
                if (dVarH == null) {
                    throw new y(l0.C("This callable does not support a default call: ", L()));
                }
                arrayList.addAll(arrayList2);
                arrayList.add(null);
                try {
                    Object[] array2 = arrayList.toArray(new Object[0]);
                    if (array2 != null) {
                        return (R) dVarH.call(array2);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                } catch (IllegalAccessException e10) {
                    throw new vn.a(e10);
                }
            }
            un.n next = it.next();
            if (i10 != 0 && i10 % 32 == 0) {
                arrayList2.add(Integer.valueOf(i11));
                i11 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.z()) {
                arrayList.add(h0.k(next.getType()) ? null : h0.g(wn.e.g(next.getType())));
                i11 = (1 << (i10 % 32)) | i11;
                z10 = true;
            } else {
                if (!next.b()) {
                    throw new IllegalArgumentException(l0.C("No argument provided for a required parameter: ", next));
                }
                arrayList.add(D(next.getType()));
            }
            if (next.getKind() == un.n.b.VALUE) {
                i10++;
            }
        }
    }

    public final Object D(un.s sVar) {
        Class clsE = in.b.e(wn.d.b(sVar));
        if (clsE.isArray()) {
            Object objNewInstance = Array.newInstance(clsE.getComponentType(), 0);
            l0.o(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        throw new y("Cannot instantiate the default empty array of type " + ((Object) clsE.getSimpleName()) + ", because it is not an array type");
    }

    public final Type E() {
        Type[] lowerBounds;
        eo.b bVarI = L();
        eo.y yVar = bVarI instanceof eo.y ? (eo.y) bVarI : null;
        if (yVar == null || !yVar.isSuspend()) {
            return null;
        }
        Object objV3 = nm.h0.v3(F().a());
        ParameterizedType parameterizedType = objV3 instanceof ParameterizedType ? (ParameterizedType) objV3 : null;
        if (!l0.g(parameterizedType == null ? null : parameterizedType.getRawType(), um.d.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        l0.o(actualTypeArguments, "continuationType.actualTypeArguments");
        Object objGt = nm.r.gt(actualTypeArguments);
        WildcardType wildcardType = objGt instanceof WildcardType ? (WildcardType) objGt : null;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) nm.r.Rb(lowerBounds);
    }

    @os.l
    public abstract yn.d<?> F();

    @os.l
    public abstract j G();

    @os.m
    public abstract yn.d<?> H();

    @os.l
    /* JADX INFO: renamed from: I */
    public abstract eo.b L();

    public final boolean J() {
        return l0.g(getName(), "<init>") && G().s().isAnnotation();
    }

    public abstract boolean K();

    @Override // un.c
    public R call(@os.l Object... objArr) throws vn.a {
        l0.p(objArr, d6.a.F);
        try {
            return (R) F().call(objArr);
        } catch (IllegalAccessException e10) {
            throw new vn.a(e10);
        }
    }

    @Override // un.c
    public R callBy(@os.l Map<un.n, ? extends Object> map) {
        l0.p(map, d6.a.F);
        return J() ? B(map) : C(map, null);
    }

    @Override // un.b
    @os.l
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this.f20332a.invoke();
        l0.o(listInvoke, "_annotations()");
        return listInvoke;
    }

    @Override // un.c
    @os.l
    public List<un.n> getParameters() {
        ArrayList<un.n> arrayListInvoke = this.f20333b.invoke();
        l0.o(arrayListInvoke, "_parameters()");
        return arrayListInvoke;
    }

    @Override // un.c
    @os.l
    public un.s getReturnType() {
        v vVarInvoke = this.f20334c.invoke();
        l0.o(vVarInvoke, "_returnType()");
        return vVarInvoke;
    }

    @Override // un.c
    @os.l
    public List<un.t> getTypeParameters() {
        List<w> listInvoke = this.f20335d.invoke();
        l0.o(listInvoke, "_typeParameters()");
        return listInvoke;
    }

    @Override // un.c
    @os.m
    public un.w getVisibility() {
        eo.u visibility = L().getVisibility();
        l0.o(visibility, "descriptor.visibility");
        return h0.q(visibility);
    }

    @Override // un.c
    public boolean isAbstract() {
        return L().s() == eo.e0.ABSTRACT;
    }

    @Override // un.c
    public boolean isFinal() {
        return L().s() == eo.e0.FINAL;
    }

    @Override // un.c
    public boolean isOpen() {
        return L().s() == eo.e0.OPEN;
    }
}
