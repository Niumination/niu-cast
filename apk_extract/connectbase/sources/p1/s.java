package p1;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@d
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Type> f12749a = new HashSet();

    public final void a(Type... types) {
        for (Type type : types) {
            if (type != null && this.f12749a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        e((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        f((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        d((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        b((Class) type);
                    } else {
                        if (!(type instanceof GenericArrayType)) {
                            throw new AssertionError("Unknown type: " + type);
                        }
                        c((GenericArrayType) type);
                    }
                } catch (Throwable th2) {
                    this.f12749a.remove(type);
                    throw th2;
                }
            }
        }
    }

    public void b(Class<?> t10) {
    }

    public void c(GenericArrayType t10) {
    }

    public void d(ParameterizedType t10) {
    }

    public void e(TypeVariable<?> t10) {
    }

    public void f(WildcardType t10) {
    }
}
