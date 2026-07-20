package yn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kn.l0;
import kn.s1;
import kn.w;
import lm.l2;
import nm.p;
import nm.r;
import nm.y;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e<M extends Member> implements yn.d<M> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final d f21478e = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final M f21479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final Type f21480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public final Class<?> f21481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final List<Type> f21482d;

    public static final class a extends e<Constructor<?>> implements yn.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @m
        public final Object f21483f;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(@l Constructor<?> constructor, @m Object obj) {
            l0.p(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            l0.o(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            l0.o(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 2 ? new Type[0] : p.l1(genericParameterTypes, 1, genericParameterTypes.length - 1)));
            this.f21483f = obj;
        }

        @Override // yn.d
        @m
        public Object call(@l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            yn.d.a.a(this, objArr);
            Constructor constructor = (Constructor) this.f21479a;
            s1 s1Var = new s1(3);
            s1Var.a(this.f21483f);
            s1Var.b(objArr);
            s1Var.a(null);
            return constructor.newInstance(s1Var.f9356a.toArray(new Object[s1Var.f9356a.size()]));
        }
    }

    public static final class b extends e<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(@l Constructor<?> constructor) {
            l0.p(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            l0.o(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            l0.o(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : p.l1(genericParameterTypes, 0, genericParameterTypes.length - 1)));
        }

        @Override // yn.d
        @m
        public Object call(@l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            yn.d.a.a(this, objArr);
            Constructor constructor = (Constructor) this.f21479a;
            s1 s1Var = new s1(2);
            s1Var.b(objArr);
            s1Var.a(null);
            return constructor.newInstance(s1Var.f9356a.toArray(new Object[s1Var.f9356a.size()]));
        }
    }

    public static final class c extends e<Constructor<?>> implements yn.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @m
        public final Object f21484f;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(@l Constructor<?> constructor, @m Object obj) {
            l0.p(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            l0.o(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            l0.o(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, null, genericParameterTypes);
            this.f21484f = obj;
        }

        @Override // yn.d
        @m
        public Object call(@l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            yn.d.a.a(this, objArr);
            Constructor constructor = (Constructor) this.f21479a;
            s1 s1Var = new s1(2);
            s1Var.a(this.f21484f);
            s1Var.b(objArr);
            return constructor.newInstance(s1Var.f9356a.toArray(new Object[s1Var.f9356a.size()]));
        }
    }

    public static final class d {
        public d() {
        }

        public d(w wVar) {
        }
    }

    /* JADX INFO: renamed from: yn.e$e, reason: collision with other inner class name */
    public static final class C0553e extends e<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public C0553e(@l Constructor<?> constructor) {
            l0.p(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            l0.o(declaringClass, "constructor.declaringClass");
            Class<?> declaringClass2 = constructor.getDeclaringClass();
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            declaringClass3 = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            l0.o(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, declaringClass3, genericParameterTypes);
        }

        @Override // yn.d
        @m
        public Object call(@l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            yn.d.a.a(this, objArr);
            return ((Constructor) this.f21479a).newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    public static abstract class f extends e<Field> {

        public static final class a extends f implements yn.c {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @m
            public final Object f21485f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@l Field field, @m Object obj) {
                super(field, false);
                l0.p(field, "field");
                this.f21485f = obj;
            }

            @Override // yn.e.f, yn.d
            @m
            public Object call(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                yn.d.a.a(this, objArr);
                return ((Field) this.f21479a).get(this.f21485f);
            }
        }

        public static final class b extends f implements yn.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@l Field field) {
                super(field, false);
                l0.p(field, "field");
            }
        }

        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@l Field field) {
                super(field, true);
                l0.p(field, "field");
            }
        }

        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@l Field field) {
                super(field, true);
                l0.p(field, "field");
            }

            @Override // yn.e
            public void c(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                yn.d.a.a(this, objArr);
                d(r.nc(objArr));
            }
        }

        /* JADX INFO: renamed from: yn.e$f$e, reason: collision with other inner class name */
        public static final class C0554e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0554e(@l Field field) {
                super(field, false);
                l0.p(field, "field");
            }
        }

        public /* synthetic */ f(Field field, boolean z10, w wVar) {
            this(field, z10);
        }

        @Override // yn.d
        @m
        public Object call(@l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            c(objArr);
            return ((Field) this.f21479a).get(this.f21481c != null ? r.Rb(objArr) : null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Field field, boolean z10) {
            Type genericType = field.getGenericType();
            l0.o(genericType, "field.genericType");
            super(field, genericType, z10 ? field.getDeclaringClass() : null, new Type[0]);
        }
    }

    public static abstract class g extends e<Field> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f21486f;

        public static final class a extends g implements yn.c {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @m
            public final Object f21487g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@l Field field, boolean z10, @m Object obj) {
                super(field, z10, false);
                l0.p(field, "field");
                this.f21487g = obj;
            }

            @Override // yn.e.g, yn.d
            @l
            public Object call(@l Object[] objArr) throws IllegalAccessException {
                l0.p(objArr, d6.a.F);
                c(objArr);
                ((Field) this.f21479a).set(this.f21487g, r.Rb(objArr));
                return l2.f10208a;
            }
        }

        public static final class b extends g implements yn.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@l Field field, boolean z10) {
                super(field, z10, false);
                l0.p(field, "field");
            }

            @Override // yn.e.g, yn.d
            @l
            public Object call(@l Object[] objArr) throws IllegalAccessException {
                l0.p(objArr, d6.a.F);
                c(objArr);
                ((Field) this.f21479a).set(null, r.Ah(objArr));
                return l2.f10208a;
            }
        }

        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@l Field field, boolean z10) {
                super(field, z10, true);
                l0.p(field, "field");
            }
        }

        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@l Field field, boolean z10) {
                super(field, z10, true);
                l0.p(field, "field");
            }

            @Override // yn.e.g, yn.e
            public void c(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                super.c(objArr);
                d(r.nc(objArr));
            }
        }

        /* JADX INFO: renamed from: yn.e$g$e, reason: collision with other inner class name */
        public static final class C0555e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0555e(@l Field field, boolean z10) {
                super(field, z10, false);
                l0.p(field, "field");
            }
        }

        public /* synthetic */ g(Field field, boolean z10, boolean z11, w wVar) {
            this(field, z10, z11);
        }

        @Override // yn.e
        public void c(@l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            yn.d.a.a(this, objArr);
            if (this.f21486f && r.Ah(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override // yn.d
        @m
        public Object call(@l Object[] objArr) throws IllegalAccessException {
            l0.p(objArr, d6.a.F);
            c(objArr);
            ((Field) this.f21479a).set(this.f21481c != null ? r.Rb(objArr) : null, r.Ah(objArr));
            return l2.f10208a;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public g(Field field, boolean z10, boolean z11) {
            Class cls = Void.TYPE;
            l0.o(cls, "TYPE");
            Class<?> declaringClass = z11 ? field.getDeclaringClass() : null;
            Type genericType = field.getGenericType();
            l0.o(genericType, "field.genericType");
            super(field, cls, declaringClass, new Type[]{genericType});
            this.f21486f = z10;
        }
    }

    public static abstract class h extends e<Method> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f21488f;

        public static final class a extends h implements yn.c {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @m
            public final Object f21489g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@l Method method, @m Object obj) {
                super(method, false, null, 4, null);
                l0.p(method, "method");
                this.f21489g = obj;
            }

            @Override // yn.d
            @m
            public Object call(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                yn.d.a.a(this, objArr);
                return f(this.f21489g, objArr);
            }
        }

        public static final class b extends h implements yn.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@l Method method) {
                super(method, false, null, 4, null);
                l0.p(method, "method");
            }

            @Override // yn.d
            @m
            public Object call(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                yn.d.a.a(this, objArr);
                return f(null, objArr);
            }
        }

        public static final class c extends h implements yn.c {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @m
            public final Object f21490g;

            /* JADX WARN: Illegal instructions before constructor call */
            public c(@l Method method, @m Object obj) {
                l0.p(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                l0.o(genericParameterTypes, "method.genericParameterTypes");
                super(method, false, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : p.l1(genericParameterTypes, 1, genericParameterTypes.length)));
                this.f21490g = obj;
            }

            @Override // yn.d
            @m
            public Object call(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                yn.d.a.a(this, objArr);
                s1 s1Var = new s1(2);
                s1Var.a(this.f21490g);
                s1Var.b(objArr);
                return f(null, s1Var.f9356a.toArray(new Object[s1Var.f9356a.size()]));
            }
        }

        public static final class d extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@l Method method) {
                super(method, false, null, 6, null);
                l0.p(method, "method");
            }

            @Override // yn.d
            @m
            public Object call(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                yn.d.a.a(this, objArr);
                return f(objArr[0], objArr.length <= 1 ? new Object[0] : p.l1(objArr, 1, objArr.length));
            }
        }

        /* JADX INFO: renamed from: yn.e$h$e, reason: collision with other inner class name */
        public static final class C0556e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0556e(@l Method method) {
                super(method, true, null, 4, null);
                l0.p(method, "method");
            }

            @Override // yn.d
            @m
            public Object call(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                yn.d.a.a(this, objArr);
                d(r.nc(objArr));
                return f(null, objArr.length <= 1 ? new Object[0] : p.l1(objArr, 1, objArr.length));
            }
        }

        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(@l Method method) {
                super(method, false, null, 6, null);
                l0.p(method, "method");
            }

            @Override // yn.d
            @m
            public Object call(@l Object[] objArr) {
                l0.p(objArr, d6.a.F);
                yn.d.a.a(this, objArr);
                return f(null, objArr);
            }
        }

        public /* synthetic */ h(Method method, boolean z10, Type[] typeArr, w wVar) {
            this(method, z10, typeArr);
        }

        @m
        public final Object f(@m Object obj, @l Object[] objArr) {
            l0.p(objArr, d6.a.F);
            return this.f21488f ? l2.f10208a : ((Method) this.f21479a).invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ h(Method method, boolean z10, Type[] typeArr, int i10, w wVar) {
            z10 = (i10 & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z10;
            if ((i10 & 4) != 0) {
                typeArr = method.getGenericParameterTypes();
                l0.o(typeArr, "class Method(\n        me…        }\n        }\n    }");
            }
            this(method, z10, typeArr);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public h(Method method, boolean z10, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            l0.o(genericReturnType, "method.genericReturnType");
            super(method, genericReturnType, z10 ? method.getDeclaringClass() : null, typeArr);
            this.f21488f = l0.g(this.f21480b, Void.TYPE);
        }
    }

    public /* synthetic */ e(Member member, Type type, Class cls, Type[] typeArr, w wVar) {
        this(member, type, cls, typeArr);
    }

    @Override // yn.d
    @l
    public List<Type> a() {
        return this.f21482d;
    }

    @Override // yn.d
    @l
    public final M b() {
        return this.f21479a;
    }

    public void c(@l Object[] objArr) {
        yn.d.a.a(this, objArr);
    }

    public final void d(@m Object obj) {
        if (obj == null || !this.f21479a.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @m
    public final Class<?> e() {
        return this.f21481c;
    }

    @Override // yn.d
    @l
    public final Type getReturnType() {
        return this.f21480b;
    }

    public e(M m10, Type type, Class<?> cls, Type[] typeArr) {
        List<Type> listO;
        this.f21479a = m10;
        this.f21480b = type;
        this.f21481c = cls;
        if (cls == null) {
            listO = r.Ky(typeArr);
        } else {
            s1 s1Var = new s1(2);
            s1Var.a(cls);
            s1Var.b(typeArr);
            listO = y.O(s1Var.f9356a.toArray(new Type[s1Var.f9356a.size()]));
        }
        this.f21482d = listO;
    }
}
