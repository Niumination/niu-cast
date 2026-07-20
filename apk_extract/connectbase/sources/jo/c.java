package jo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kn.l0;
import nm.r;
import wo.p;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final c f8756a = new c();

    public final jp.f a(Class<?> cls) {
        int i10 = 0;
        while (cls.isArray()) {
            i10++;
            cls = cls.getComponentType();
            l0.o(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            dp.b bVarA = ko.d.a(cls);
            co.c cVar = co.c.f1685a;
            dp.c cVarB = bVarA.b();
            l0.o(cVarB, "javaClassId.asSingleFqName()");
            dp.b bVarN = cVar.n(cVarB);
            if (bVarN != null) {
                bVarA = bVarN;
            }
            return new jp.f(bVarA, i10);
        }
        if (l0.g(cls, Void.TYPE)) {
            dp.b bVarM = dp.b.m(ao.k.a.f581f.l());
            l0.o(bVarM, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new jp.f(bVarM, i10);
        }
        ao.i primitiveType = mp.e.get(cls.getName()).getPrimitiveType();
        l0.o(primitiveType, "get(currentClass.name).primitiveType");
        if (i10 > 0) {
            dp.b bVarM2 = dp.b.m(primitiveType.getArrayTypeFqName());
            l0.o(bVarM2, "topLevel(primitiveType.arrayTypeFqName)");
            return new jp.f(bVarM2, i10 - 1);
        }
        dp.b bVarM3 = dp.b.m(primitiveType.getTypeFqName());
        l0.o(bVarM3, "topLevel(primitiveType.typeFqName)");
        return new jp.f(bVarM3, i10);
    }

    public final void b(@os.l Class<?> cls, @os.l p.c cVar) {
        l0.p(cls, "klass");
        l0.p(cVar, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        l0.o(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i10 = 0;
        while (i10 < length) {
            Annotation annotation = declaredAnnotations[i10];
            i10++;
            l0.o(annotation, "annotation");
            f(cVar, annotation);
        }
        cVar.a();
    }

    public final void c(Class<?> cls, p.d dVar) throws InvocationTargetException {
        Constructor<?>[] constructorArr;
        int i10;
        int i11;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        l0.o(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i12 = 0;
        while (i12 < length) {
            Constructor<?> constructor = declaredConstructors[i12];
            int i13 = i12 + 1;
            dp.f fVar = dp.h.f3832i;
            m mVar = m.f8770a;
            l0.o(constructor, "constructor");
            p.e eVarB = dVar.b(fVar, mVar.a(constructor));
            if (eVarB == null) {
                constructorArr = declaredConstructors;
                i10 = length;
                i11 = i13;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                l0.o(declaredAnnotations, "constructor.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i14 = 0;
                while (i14 < length2) {
                    Annotation annotation = declaredAnnotations[i14];
                    i14++;
                    l0.o(annotation, "annotation");
                    f(eVarB, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                l0.o(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length3 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length4 = parameterAnnotations.length;
                    int i15 = 0;
                    while (i15 < length4) {
                        Annotation[] annotationArr = parameterAnnotations[i15];
                        int i16 = i15 + 1;
                        l0.o(annotationArr, "annotations");
                        int length5 = annotationArr.length;
                        int i17 = 0;
                        while (i17 < length5) {
                            Annotation annotation2 = annotationArr[i17];
                            i17++;
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Class<?> clsE = in.b.e(in.b.a(annotation2));
                            int i18 = length;
                            int i19 = i13;
                            dp.b bVarA = ko.d.a(clsE);
                            int i20 = length3;
                            l0.o(annotation2, "annotation");
                            p.a aVarC = eVarB.c(i15 + length3, bVarA, new b(annotation2));
                            if (aVarC != null) {
                                f8756a.h(aVarC, annotation2, clsE);
                            }
                            length = i18;
                            declaredConstructors = constructorArr2;
                            i13 = i19;
                            length3 = i20;
                        }
                        i15 = i16;
                    }
                }
                constructorArr = declaredConstructors;
                i10 = length;
                i11 = i13;
                eVarB.a();
            }
            length = i10;
            declaredConstructors = constructorArr;
            i12 = i11;
        }
    }

    public final void d(Class<?> cls, p.d dVar) throws InvocationTargetException {
        Field[] declaredFields = cls.getDeclaredFields();
        l0.o(declaredFields, "klass.declaredFields");
        int length = declaredFields.length;
        int i10 = 0;
        while (i10 < length) {
            Field field = declaredFields[i10];
            i10++;
            dp.f fVarK = dp.f.k(field.getName());
            l0.o(fVarK, "identifier(field.name)");
            m mVar = m.f8770a;
            l0.o(field, "field");
            p.c cVarA = dVar.a(fVarK, mVar.b(field), null);
            if (cVarA != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                l0.o(declaredAnnotations, "field.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i11 = 0;
                while (i11 < length2) {
                    Annotation annotation = declaredAnnotations[i11];
                    i11++;
                    l0.o(annotation, "annotation");
                    f(cVarA, annotation);
                }
                cVarA.a();
            }
        }
    }

    public final void e(Class<?> cls, p.d dVar) throws InvocationTargetException {
        Method[] methodArr;
        int i10;
        Method[] declaredMethods = cls.getDeclaredMethods();
        l0.o(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i11 = 0;
        while (i11 < length) {
            Method method = declaredMethods[i11];
            i11++;
            dp.f fVarK = dp.f.k(method.getName());
            l0.o(fVarK, "identifier(method.name)");
            m mVar = m.f8770a;
            l0.o(method, "method");
            p.e eVarB = dVar.b(fVarK, mVar.c(method));
            if (eVarB == null) {
                methodArr = declaredMethods;
                i10 = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                l0.o(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i12 = 0;
                while (i12 < length2) {
                    Annotation annotation = declaredAnnotations[i12];
                    i12++;
                    l0.o(annotation, "annotation");
                    f(eVarB, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                l0.o(parameterAnnotations, "method.parameterAnnotations");
                Annotation[][] annotationArr = parameterAnnotations;
                int length3 = annotationArr.length;
                int i13 = 0;
                while (i13 < length3) {
                    Annotation[] annotationArr2 = annotationArr[i13];
                    int i14 = i13 + 1;
                    l0.o(annotationArr2, "annotations");
                    int length4 = annotationArr2.length;
                    int i15 = 0;
                    while (i15 < length4) {
                        Annotation annotation2 = annotationArr2[i15];
                        i15++;
                        Class<?> clsE = in.b.e(in.b.a(annotation2));
                        Method[] methodArr2 = declaredMethods;
                        dp.b bVarA = ko.d.a(clsE);
                        int i16 = length;
                        l0.o(annotation2, "annotation");
                        p.a aVarC = eVarB.c(i13, bVarA, new b(annotation2));
                        if (aVarC != null) {
                            f8756a.h(aVarC, annotation2, clsE);
                        }
                        declaredMethods = methodArr2;
                        length = i16;
                    }
                    i13 = i14;
                }
                methodArr = declaredMethods;
                i10 = length;
                eVarB.a();
            }
            declaredMethods = methodArr;
            length = i10;
        }
    }

    public final void f(p.c cVar, Annotation annotation) throws InvocationTargetException {
        Class<?> clsE = in.b.e(in.b.a(annotation));
        p.a aVarB = cVar.b(ko.d.a(clsE), new b(annotation));
        if (aVarB == null) {
            return;
        }
        f8756a.h(aVarB, annotation, clsE);
    }

    public final void g(p.a aVar, dp.f fVar, Object obj) throws InvocationTargetException {
        Class<?> enclosingClass = obj.getClass();
        if (l0.g(enclosingClass, Class.class)) {
            aVar.f(fVar, a((Class) obj));
            return;
        }
        if (i.f8763a.contains(enclosingClass)) {
            aVar.c(fVar, obj);
            return;
        }
        if (ko.d.h(enclosingClass)) {
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            l0.o(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
            dp.b bVarA = ko.d.a(enclosingClass);
            dp.f fVarK = dp.f.k(((Enum) obj).name());
            l0.o(fVarK, "identifier((value as Enum<*>).name)");
            aVar.b(fVar, bVarA, fVarK);
            return;
        }
        if (Annotation.class.isAssignableFrom(enclosingClass)) {
            Class<?>[] interfaces = enclosingClass.getInterfaces();
            l0.o(interfaces, "clazz.interfaces");
            Class<?> cls = (Class) r.gt(interfaces);
            l0.o(cls, "annotationClass");
            p.a aVarE = aVar.e(fVar, ko.d.a(cls));
            if (aVarE == null) {
                return;
            }
            h(aVarE, (Annotation) obj, cls);
            return;
        }
        if (!enclosingClass.isArray()) {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + obj);
        }
        p.b bVarD = aVar.d(fVar);
        if (bVarD == null) {
            return;
        }
        Class<?> componentType = enclosingClass.getComponentType();
        int i10 = 0;
        if (componentType.isEnum()) {
            l0.o(componentType, "componentType");
            dp.b bVarA2 = ko.d.a(componentType);
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i10 < length) {
                Object obj2 = objArr[i10];
                i10++;
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                }
                dp.f fVarK2 = dp.f.k(((Enum) obj2).name());
                l0.o(fVarK2, "identifier((element as Enum<*>).name)");
                bVarD.b(bVarA2, fVarK2);
            }
        } else if (l0.g(componentType, Class.class)) {
            Object[] objArr2 = (Object[]) obj;
            int length2 = objArr2.length;
            while (i10 < length2) {
                Object obj3 = objArr2[i10];
                i10++;
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
                }
                bVarD.c(a((Class) obj3));
            }
        } else if (Annotation.class.isAssignableFrom(componentType)) {
            Object[] objArr3 = (Object[]) obj;
            int length3 = objArr3.length;
            while (i10 < length3) {
                Object obj4 = objArr3[i10];
                i10++;
                l0.o(componentType, "componentType");
                p.a aVarD = bVarD.d(ko.d.a(componentType));
                if (aVarD != null) {
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Annotation");
                    }
                    h(aVarD, (Annotation) obj4, componentType);
                }
            }
        } else {
            Object[] objArr4 = (Object[]) obj;
            int length4 = objArr4.length;
            while (i10 < length4) {
                Object obj5 = objArr4[i10];
                i10++;
                bVarD.e(obj5);
            }
        }
        bVarD.a();
    }

    public final void h(p.a aVar, Annotation annotation, Class<?> cls) throws InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        l0.o(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i10 = 0;
        while (i10 < length) {
            Method method = declaredMethods[i10];
            i10++;
            try {
                Object objInvoke = method.invoke(annotation, null);
                l0.m(objInvoke);
                dp.f fVarK = dp.f.k(method.getName());
                l0.o(fVarK, "identifier(method.name)");
                g(aVar, fVarK, objInvoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void i(@os.l Class<?> cls, @os.l p.d dVar) {
        l0.p(cls, "klass");
        l0.p(dVar, "memberVisitor");
        e(cls, dVar);
        c(cls, dVar);
        d(cls, dVar);
    }
}
