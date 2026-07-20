package rg;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.jvm.ReflectJvmMapping;
import qg.y0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f9434a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f9435b = mg.d.class;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f9436c = mg.a.class;

    public static final KFunction a(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return (KFunction) CollectionsKt.lastOrNull(CollectionsKt.sortedWith(arrayList, ComparisonsKt.compareBy(new y0(2), new y0(3), new y0(4))));
    }

    public static final boolean b(KFunction kFunction) {
        Intrinsics.checkNotNullParameter(kFunction, "<this>");
        if (kFunction.isOperator() || kFunction.isInfix() || kFunction.isInline() || kFunction.isAbstract() || kFunction.isSuspend()) {
            return false;
        }
        KParameter parameter = KCallables.getExtensionReceiverParameter(kFunction);
        Class cls = f9435b;
        if (parameter != null && !c(parameter)) {
            Intrinsics.checkNotNullParameter(parameter, "parameter");
            if (!d(parameter, cls)) {
                return false;
            }
        }
        Method javaMethod = ReflectJvmMapping.getJavaMethod(kFunction);
        if (javaMethod != null) {
            if (javaMethod.isSynthetic()) {
                return false;
            }
            if (Modifier.isStatic(javaMethod.getModifiers()) && kFunction.getParameters().isEmpty()) {
                return false;
            }
        }
        List<KParameter> parameters = kFunction.getParameters();
        if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
            for (KParameter parameter2 : parameters) {
                if (!c(parameter2)) {
                    Intrinsics.checkNotNullParameter(parameter2, "parameter");
                    if (!d(parameter2, cls) && parameter2.getKind() != KParameter.Kind.INSTANCE && !parameter2.isOptional()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean c(KParameter parameter) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        return d(parameter, f9436c);
    }

    public static final boolean d(KParameter parameter, Class type) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        Intrinsics.checkNotNullParameter(type, "type");
        Type javaType = ReflectJvmMapping.getJavaType(parameter.getType());
        Class<?> cls = javaType instanceof Class ? (Class) javaType : null;
        if (cls != null) {
            return type.isAssignableFrom(cls);
        }
        return false;
    }
}
