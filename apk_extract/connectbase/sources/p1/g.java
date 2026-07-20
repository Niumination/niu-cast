package p1;

import f1.i3;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@d
public abstract class g<T, R> implements AnnotatedElement, Member {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f12706c = n();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibleObject f12707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Member f12708b;

    public static class a<T> extends g<T, T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Constructor<?> f12709d;

        public a(Constructor<?> constructor) {
            super(constructor);
            this.f12709d = constructor;
        }

        @Override // p1.g
        public final boolean C() {
            return this.f12709d.isVarArgs();
        }

        public final boolean I() {
            Class<?> declaringClass = this.f12709d.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        @Override // p1.g
        @e
        public AnnotatedType[] c() {
            return this.f12709d.getAnnotatedParameterTypes();
        }

        @Override // p1.g
        @e
        @t1.e
        public AnnotatedType d() {
            return this.f12709d.getAnnotatedReturnType();
        }

        @Override // p1.g
        public Type[] f() {
            return this.f12709d.getGenericExceptionTypes();
        }

        @Override // p1.g
        public Type[] g() {
            Type[] genericParameterTypes = this.f12709d.getGenericParameterTypes();
            if (genericParameterTypes.length > 0 && I()) {
                Class<?>[] parameterTypes = this.f12709d.getParameterTypes();
                if (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == this.f12708b.getDeclaringClass().getEnclosingClass()) {
                    return (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                }
            }
            return genericParameterTypes;
        }

        @Override // p1.g
        public Type h() {
            Class<?> declaringClass = this.f12708b.getDeclaringClass();
            TypeVariable<Class<?>>[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? t.l(declaringClass, typeParameters) : declaringClass;
        }

        @Override // p1.g
        public final Annotation[][] j() {
            return this.f12709d.getParameterAnnotations();
        }

        @Override // p1.g
        public final TypeVariable<?>[] m() {
            TypeVariable<Class<?>>[] typeParameters = this.f12708b.getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f12709d.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        @Override // p1.g
        public final Object p(@gm.a Object receiver, Object[] args) throws IllegalAccessException, InvocationTargetException {
            try {
                return this.f12709d.newInstance(args);
            } catch (InstantiationException e10) {
                throw new RuntimeException(this.f12709d + " failed.", e10);
            }
        }

        @Override // p1.g
        public final boolean u() {
            return false;
        }
    }

    public static class b<T> extends g<T, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f12710d;

        public b(Method method) {
            super(method);
            this.f12710d = method;
        }

        @Override // p1.g
        public final boolean C() {
            return this.f12710d.isVarArgs();
        }

        @Override // p1.g
        @e
        public AnnotatedType[] c() {
            return this.f12710d.getAnnotatedParameterTypes();
        }

        @Override // p1.g
        @e
        @t1.e
        public AnnotatedType d() {
            return this.f12710d.getAnnotatedReturnType();
        }

        @Override // p1.g
        public Type[] f() {
            return this.f12710d.getGenericExceptionTypes();
        }

        @Override // p1.g
        public Type[] g() {
            return this.f12710d.getGenericParameterTypes();
        }

        @Override // p1.g
        public Type h() {
            return this.f12710d.getGenericReturnType();
        }

        @Override // p1.g
        public final Annotation[][] j() {
            return this.f12710d.getParameterAnnotations();
        }

        @Override // p1.g
        public final TypeVariable<?>[] m() {
            return this.f12710d.getTypeParameters();
        }

        @Override // p1.g
        @gm.a
        public final Object p(@gm.a Object receiver, Object[] args) throws IllegalAccessException, InvocationTargetException {
            return this.f12710d.invoke(receiver, args);
        }

        @Override // p1.g
        public final boolean u() {
            return (s() || w() || z() || Modifier.isFinal(this.f12708b.getDeclaringClass().getModifiers())) ? false : true;
        }
    }

    public <M extends AccessibleObject & Member> g(M member) {
        member.getClass();
        this.f12707a = member;
        this.f12708b = member;
    }

    public static <T> g<T, T> a(Constructor<T> constructor) {
        return new a(constructor);
    }

    public static g<?, Object> b(Method method) {
        return new b(method);
    }

    public static boolean n() {
        try {
            Class.forName("java.lang.reflect.AnnotatedType");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean A() {
        return Modifier.isSynchronized(this.f12708b.getModifiers());
    }

    public final boolean B() {
        return Modifier.isTransient(this.f12708b.getModifiers());
    }

    public abstract boolean C();

    public final boolean D() {
        return Modifier.isVolatile(this.f12708b.getModifiers());
    }

    public final <R1 extends R> g<T, R1> E(Class<R1> returnType) {
        return F(q.of((Class) returnType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> g<T, R1> F(q<R1> returnType) {
        if (returnType.isSupertypeOf(l())) {
            return this;
        }
        throw new IllegalArgumentException("Invokable is known to return " + l() + ", not " + returnType);
    }

    public final void G(boolean flag) {
        this.f12707a.setAccessible(flag);
    }

    public final boolean H() {
        try {
            this.f12707a.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    @e
    public abstract AnnotatedType[] c();

    @e
    @b1.a
    @Deprecated
    @t1.e("fails under Android VMs; do not use from guava-android")
    public abstract AnnotatedType d();

    public final i3<q<? extends Throwable>> e() {
        i3.a aVarBuilder = i3.builder();
        for (Type type : f()) {
            aVarBuilder.j(q.of(type));
        }
        return aVarBuilder.e();
    }

    public boolean equals(@gm.a Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return i().equals(gVar.i()) && this.f12708b.equals(gVar.f12708b);
    }

    public abstract Type[] f();

    public abstract Type[] g();

    @Override // java.lang.reflect.AnnotatedElement
    @gm.a
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f12707a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f12707a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f12707a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f12708b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f12708b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f12708b.getName();
    }

    public abstract Type h();

    public int hashCode() {
        return this.f12708b.hashCode();
    }

    public q<T> i() {
        return q.of((Class) this.f12708b.getDeclaringClass());
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return this.f12707a.isAnnotationPresent(annotationClass);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f12708b.isSynthetic();
    }

    public abstract Annotation[][] j();

    @e
    public final i3<j> k() {
        Type[] typeArrG = g();
        Annotation[][] annotationArrJ = j();
        Object[] objArrC = f12706c ? c() : new Object[typeArrG.length];
        i3.a aVarBuilder = i3.builder();
        for (int i10 = 0; i10 < typeArrG.length; i10++) {
            aVarBuilder.j(new j(this, i10, q.of(typeArrG[i10]), annotationArrJ[i10], objArrC[i10]));
        }
        return aVarBuilder.e();
    }

    public final q<? extends R> l() {
        return (q<? extends R>) q.of(h());
    }

    public abstract TypeVariable<?>[] m();

    @gm.a
    @t1.a
    public final R o(@gm.a T t10, Object... objArr) throws IllegalAccessException, InvocationTargetException {
        objArr.getClass();
        return (R) p(t10, objArr);
    }

    @gm.a
    public abstract Object p(@gm.a Object receiver, Object[] args) throws IllegalAccessException, InvocationTargetException;

    public final boolean q() {
        return Modifier.isAbstract(this.f12708b.getModifiers());
    }

    public final boolean r() {
        return this.f12707a.isAccessible();
    }

    public final boolean s() {
        return Modifier.isFinal(this.f12708b.getModifiers());
    }

    public final boolean t() {
        return Modifier.isNative(this.f12708b.getModifiers());
    }

    public String toString() {
        return this.f12708b.toString();
    }

    public abstract boolean u();

    public final boolean v() {
        return (w() || y() || x()) ? false : true;
    }

    public final boolean w() {
        return Modifier.isPrivate(this.f12708b.getModifiers());
    }

    public final boolean x() {
        return Modifier.isProtected(this.f12708b.getModifiers());
    }

    public final boolean y() {
        return Modifier.isPublic(this.f12708b.getModifiers());
    }

    public final boolean z() {
        return Modifier.isStatic(this.f12708b.getModifiers());
    }
}
