package rg;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final Object a(Object obj, KFunction kFunction, mg.a aVar) {
        Object obj2;
        List<KParameter> parameters = kFunction.getParameters();
        ArrayList<KParameter> arrayList = new ArrayList();
        for (Object obj3 : parameters) {
            if (!((KParameter) obj3).isOptional()) {
                arrayList.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.i(arrayList)), 16));
        for (KParameter parameter : arrayList) {
            if (parameter.getKind() == KParameter.Kind.INSTANCE) {
                obj2 = obj;
            } else {
                ThreadLocal threadLocal = a.f9434a;
                Intrinsics.checkNotNullParameter(parameter, "parameter");
                if (a.d(parameter, a.f9435b)) {
                    obj2 = aVar.f8055i;
                } else {
                    if (!a.c(parameter)) {
                        if (!StringsKt__StringsKt.contains$default(parameter.getType().toString(), "Application", false, 2, (Object) null)) {
                            StringBuilder sb2 = new StringBuilder("Parameter type '");
                            sb2.append(parameter.getType());
                            sb2.append("' of parameter '");
                            String name = parameter.getName();
                            if (name == null) {
                                name = "<receiver>";
                            }
                            throw new IllegalArgumentException(h0.a.n(sb2, name, "' is not supported"));
                        }
                        Type javaType = ReflectJvmMapping.getJavaType(parameter.getType());
                        Class cls = javaType instanceof Class ? (Class) javaType : null;
                        ClassLoader classLoader = cls != null ? cls.getClassLoader() : null;
                        StringBuilder sb3 = new StringBuilder("Parameter type ");
                        sb3.append(parameter.getType());
                        sb3.append(":{");
                        sb3.append(classLoader);
                        sb3.append("} is not supported.Application is loaded as ");
                        Class cls2 = a.f9436c;
                        sb3.append(cls2);
                        sb3.append(":{");
                        sb3.append(cls2.getClassLoader());
                        sb3.append('}');
                        throw new IllegalArgumentException(sb3.toString());
                    }
                    obj2 = aVar;
                }
            }
            linkedHashMap.put(parameter, obj2);
        }
        try {
            return kFunction.callBy(linkedHashMap);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            throw cause;
        }
    }
}
