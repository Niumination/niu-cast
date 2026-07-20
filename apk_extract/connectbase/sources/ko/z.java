package ko;

import ik.y0;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z implements uo.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f9442a = new a();

    public static final class a {
        public a() {
        }

        @os.l
        public final z a(@os.l Type type) {
            l0.p(type, y0.a.f8215h);
            boolean z10 = type instanceof Class;
            if (z10) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new x(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z10 && ((Class) type).isArray())) {
                return new k(type);
            }
            return type instanceof WildcardType ? new c0((WildcardType) type) : new n(type);
        }

        public a(kn.w wVar) {
        }
    }

    @os.l
    public abstract Type N();

    @Override // uo.d
    @os.m
    public uo.a d(@os.l dp.c cVar) {
        return uo.x.a.a(this, cVar);
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof z) && l0.g(N(), ((z) obj).N());
    }

    public int hashCode() {
        return N().hashCode();
    }

    @os.l
    public String toString() {
        return getClass().getName() + ": " + N();
    }
}
