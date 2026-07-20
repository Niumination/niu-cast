package vn;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final c f17596a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public static a f17597b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m
        public final Class<? extends Annotation> f17598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m
        public final Method f17599b;

        public a(@m Class<? extends Annotation> cls, @m Method method) {
            this.f17598a = cls;
            this.f17599b = method;
        }

        @m
        public final Class<? extends Annotation> a() {
            return this.f17598a;
        }

        @m
        public final Method b() {
            return this.f17599b;
        }
    }

    public final a a() {
        return new a(Repeatable.class, Repeatable.class.getMethod("value", null));
    }

    @m
    public final a b() {
        return f17597b;
    }

    @m
    public final Class<? extends Annotation> c(@l Class<? extends Annotation> cls) throws IllegalAccessException, InvocationTargetException {
        Annotation annotation;
        Method method;
        l0.p(cls, "klass");
        a aVar = f17597b;
        if (aVar == null) {
            synchronized (this) {
                c cVar = f17596a;
                cVar.getClass();
                a aVarA = f17597b;
                if (aVarA == null) {
                    aVarA = cVar.a();
                    cVar.getClass();
                    f17597b = aVarA;
                }
                aVar = aVarA;
            }
        }
        Class cls2 = aVar.f17598a;
        if (cls2 == null || (annotation = cls.getAnnotation(cls2)) == null || (method = aVar.f17599b) == null) {
            return null;
        }
        Object objInvoke = method.invoke(annotation, null);
        if (objInvoke != null) {
            return (Class) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
    }

    public final void d(@m a aVar) {
        f17597b = aVar;
    }
}
