package in;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.annotation.Annotation;
import kn.l0;
import kn.l1;
import lm.a1;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "JvmClassMappingKt")
public final class b {
    @os.l
    public static final <T extends Annotation> un.d<? extends T> a(@os.l T t10) {
        l0.p(t10, "<this>");
        Class<? extends Annotation> clsAnnotationType = t10.annotationType();
        l0.o(clsAnnotationType, "annotationType(...)");
        un.d<? extends T> dVarI = i(clsAnnotationType);
        l0.n(dVarI, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return dVarI;
    }

    public static final <E extends Enum<E>> Class<E> b(Enum<E> r10) {
        l0.p(r10, "<this>");
        Class<E> declaringClass = r10.getDeclaringClass();
        l0.o(declaringClass, "getDeclaringClass(...)");
        return declaringClass;
    }

    @f1(version = "1.7")
    @an.f
    public static /* synthetic */ void c(Enum r10) {
    }

    @os.l
    public static final <T> Class<T> d(@os.l T t10) {
        l0.p(t10, "<this>");
        Class<T> cls = (Class<T>) t10.getClass();
        l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }

    @i(name = "getJavaClass")
    @os.l
    public static final <T> Class<T> e(@os.l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kn.t) dVar).s();
        l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static /* synthetic */ void f(un.d dVar) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @os.l
    public static final <T> Class<T> g(@os.l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kn.t) dVar).s();
        if (!cls.isPrimitive()) {
            l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (Class<T>) Double.class;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    cls = (Class<T>) Integer.class;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (Class<T>) Byte.class;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (Class<T>) Character.class;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (Class<T>) Long.class;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (Class<T>) Void.class;
                }
                break;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    cls = (Class<T>) Boolean.class;
                }
                break;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    cls = (Class<T>) Float.class;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (Class<T>) Short.class;
                }
                break;
        }
        l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @os.m
    public static final <T> Class<T> h(@os.l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kn.t) dVar).s();
        if (cls.isPrimitive()) {
            l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    @i(name = "getKotlinClass")
    @os.l
    public static final <T> un.d<T> i(@os.l Class<T> cls) {
        l0.p(cls, "<this>");
        return l1.d(cls);
    }

    @i(name = "getRuntimeClassOfKClassInstance")
    @os.l
    public static final <T> Class<un.d<T>> j(@os.l un.d<T> dVar) {
        l0.p(dVar, "<this>");
        Class<un.d<T>> cls = (Class<un.d<T>>) dVar.getClass();
        l0.n(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @a1(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void k(un.d dVar) {
    }

    public static final boolean l(Object[] objArr) {
        l0.p(objArr, "<this>");
        l0.P();
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }
}
