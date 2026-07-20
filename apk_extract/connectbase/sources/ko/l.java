package ko;

import eo.m1;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.g0;
import kn.l0;
import kn.l1;
import kn.n0;
import kn.s1;
import nm.k0;
import uo.d0;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends p implements ko.h, v, uo.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Class<?> f9428a;

    public /* synthetic */ class a extends g0 implements jn.l<Member, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(Member.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l Member member) {
            l0.p(member, "p0");
            return Boolean.valueOf(member.isSynthetic());
        }
    }

    public /* synthetic */ class b extends g0 implements jn.l<Constructor<?>, o> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "<init>";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(o.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // jn.l
        @os.l
        public final o invoke(@os.l Constructor<?> constructor) {
            l0.p(constructor, "p0");
            return new o(constructor);
        }
    }

    public /* synthetic */ class c extends g0 implements jn.l<Member, Boolean> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(Member.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l Member member) {
            l0.p(member, "p0");
            return Boolean.valueOf(member.isSynthetic());
        }
    }

    public /* synthetic */ class d extends g0 implements jn.l<Field, r> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "<init>";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(r.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // jn.l
        @os.l
        public final r invoke(@os.l Field field) {
            l0.p(field, "p0");
            return new r(field);
        }
    }

    public static final class e extends n0 implements jn.l<Class<?>, Boolean> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            l0.o(simpleName, "it.simpleName");
            return Boolean.valueOf(simpleName.length() == 0);
        }
    }

    public static final class f extends n0 implements jn.l<Class<?>, dp.f> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final dp.f invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!dp.f.m(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return dp.f.k(simpleName);
        }
    }

    public static final class g extends n0 implements jn.l<Method, Boolean> {
        public g() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0020  */
        @Override // jn.l
        @os.l
        public final Boolean invoke(Method method) {
            boolean z10 = false;
            if (!method.isSynthetic()) {
                if (l.this.f9428a.isEnum()) {
                    l lVar = l.this;
                    l0.o(method, "method");
                    if (!lVar.W(method)) {
                        z10 = true;
                    }
                } else {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    public /* synthetic */ class h extends g0 implements jn.l<Method, u> {
        public static final h INSTANCE = new h();

        public h() {
            super(1);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "<init>";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(u.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // jn.l
        @os.l
        public final u invoke(@os.l Method method) {
            l0.p(method, "p0");
            return new u(method);
        }
    }

    public l(@os.l Class<?> cls) {
        l0.p(cls, "klass");
        this.f9428a = cls;
    }

    @Override // uo.g
    @os.l
    public Collection<uo.j> B() throws IllegalAccessException, InvocationTargetException {
        Class<?>[] clsArrC = ko.b.f9398a.c(this.f9428a);
        if (clsArrC == null) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(clsArrC.length);
        int length = clsArrC.length;
        int i10 = 0;
        while (i10 < length) {
            Class<?> cls = clsArrC[i10];
            i10++;
            arrayList.add(new n(cls));
        }
        return arrayList;
    }

    @Override // uo.d
    public boolean C() {
        return ko.h.a.c(this);
    }

    @Override // uo.g
    public boolean H() {
        return this.f9428a.isInterface();
    }

    @Override // uo.g
    @os.m
    public d0 I() {
        return null;
    }

    @os.m
    public ko.e O(@os.l dp.c cVar) {
        return ko.h.a.a(this, cVar);
    }

    @os.l
    public List<ko.e> P() {
        return ko.h.a.b(this);
    }

    @Override // uo.g
    @os.l
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public List<o> g() {
        Constructor<?>[] declaredConstructors = this.f9428a.getDeclaredConstructors();
        l0.o(declaredConstructors, "klass.declaredConstructors");
        return gq.v.c3(gq.v.k1(gq.v.u0(nm.r.K5(declaredConstructors), a.INSTANCE), b.INSTANCE));
    }

    @os.l
    public Class<?> R() {
        return this.f9428a;
    }

    @Override // uo.g
    @os.l
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public List<r> getFields() {
        Field[] declaredFields = this.f9428a.getDeclaredFields();
        l0.o(declaredFields, "klass.declaredFields");
        return gq.v.c3(gq.v.k1(gq.v.u0(nm.r.K5(declaredFields), c.INSTANCE), d.INSTANCE));
    }

    @Override // uo.g
    @os.l
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public List<dp.f> z() {
        Class<?>[] declaredClasses = this.f9428a.getDeclaredClasses();
        l0.o(declaredClasses, "klass.declaredClasses");
        return gq.v.c3(gq.v.p1(gq.v.u0(nm.r.K5(declaredClasses), e.INSTANCE), f.INSTANCE));
    }

    @Override // uo.g
    @os.l
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public List<u> A() {
        Method[] declaredMethods = this.f9428a.getDeclaredMethods();
        l0.o(declaredMethods, "klass.declaredMethods");
        return gq.v.c3(gq.v.k1(gq.v.p0(nm.r.K5(declaredMethods), new g()), h.INSTANCE));
    }

    @Override // uo.g
    @os.m
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public l l() {
        Class<?> declaringClass = this.f9428a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new l(declaringClass);
    }

    public final boolean W(Method method) {
        String name = method.getName();
        if (l0.g(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            l0.o(parameterTypes, "method.parameterTypes");
            return parameterTypes.length == 0;
        }
        if (l0.g(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // uo.g
    @os.l
    public Collection<uo.j> a() {
        if (l0.g(this.f9428a, Object.class)) {
            return k0.INSTANCE;
        }
        s1 s1Var = new s1(2);
        Type genericSuperclass = this.f9428a.getGenericSuperclass();
        s1Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.f9428a.getGenericInterfaces();
        l0.o(genericInterfaces, "klass.genericInterfaces");
        s1Var.b(genericInterfaces);
        List listO = nm.y.O(s1Var.f9356a.toArray(new Type[s1Var.f9356a.size()]));
        ArrayList arrayList = new ArrayList(nm.z.b0(listO, 10));
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add(new n((Type) it.next()));
        }
        return arrayList;
    }

    @Override // uo.g
    public boolean c() throws IllegalAccessException, InvocationTargetException {
        Boolean boolF = ko.b.f9398a.f(this.f9428a);
        if (boolF == null) {
            return false;
        }
        return boolF.booleanValue();
    }

    @Override // uo.d
    public uo.a d(dp.c cVar) {
        return ko.h.a.a(this, cVar);
    }

    @Override // uo.g
    @os.l
    public dp.c e() {
        dp.c cVarB = ko.d.a(this.f9428a).b();
        l0.o(cVarB, "klass.classId.asSingleFqName()");
        return cVarB;
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof l) && l0.g(this.f9428a, ((l) obj).f9428a);
    }

    @Override // uo.d
    public Collection getAnnotations() {
        return ko.h.a.b(this);
    }

    @Override // ko.h
    public AnnotatedElement getElement() {
        return this.f9428a;
    }

    @Override // ko.v
    public int getModifiers() {
        return this.f9428a.getModifiers();
    }

    @Override // uo.t
    @os.l
    public dp.f getName() {
        dp.f fVarK = dp.f.k(this.f9428a.getSimpleName());
        l0.o(fVarK, "identifier(klass.simpleName)");
        return fVarK;
    }

    @Override // uo.z
    @os.l
    public List<a0> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.f9428a.getTypeParameters();
        l0.o(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i10 = 0;
        while (i10 < length) {
            TypeVariable<Class<?>> typeVariable = typeParameters[i10];
            i10++;
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // uo.s
    @os.l
    public m1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return this.f9428a.hashCode();
    }

    @Override // uo.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // uo.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // uo.s
    public boolean k() {
        return v.a.d(this);
    }

    @Override // uo.g
    @os.l
    public Collection<uo.w> m() {
        Object[] objArrD = ko.b.f9398a.d(this.f9428a);
        int i10 = 0;
        if (objArrD == null) {
            objArrD = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArrD.length);
        int length = objArrD.length;
        while (i10 < length) {
            Object obj = objArrD[i10];
            i10++;
            arrayList.add(new y(obj));
        }
        return arrayList;
    }

    @Override // uo.g
    public boolean p() {
        return this.f9428a.isAnnotation();
    }

    @Override // uo.g
    public boolean r() throws IllegalAccessException, InvocationTargetException {
        Boolean boolE = ko.b.f9398a.e(this.f9428a);
        if (boolE == null) {
            return false;
        }
        return boolE.booleanValue();
    }

    @Override // uo.g
    public boolean s() {
        return false;
    }

    @os.l
    public String toString() {
        return l.class.getName() + ": " + this.f9428a;
    }

    @Override // uo.g
    public boolean w() {
        return this.f9428a.isEnum();
    }
}
