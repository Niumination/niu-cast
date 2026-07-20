package el;

import ik.y0;
import kn.l0;
import kn.l1;
import lm.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f4542a = "$type";

    @lm.k(message = "Use defaultSessionSerializer instead.", replaceWith = @a1(expression = "defaultSessionSerializer<T>()", imports = {}))
    public static final <T> n<T> b() {
        l0.P();
        return (n) f(null);
    }

    @lm.k(message = "Use defaultSessionSerializer<T> instead.", replaceWith = @a1(expression = "defaultSessionSerializer<T>()", imports = {}))
    @os.l
    public static final <T> n<T> c(@os.l un.d<T> dVar) {
        l0.p(dVar, y0.a.f8215h);
        return (n) f(vn.g.d(dVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T d(Object obj, un.d<T> dVar) {
        if (in.b.e(dVar).isInstance(obj)) {
            return obj;
        }
        throw new ClassCastException(l1.d(obj.getClass()) + " couldn't be cast to " + dVar);
    }

    public static final <T> m<T> e() {
        l0.P();
        return f(null);
    }

    @os.l
    public static final <T> m<T> f(@os.l un.s sVar) {
        l0.p(sVar, "typeInfo");
        return new n(sVar);
    }
}
