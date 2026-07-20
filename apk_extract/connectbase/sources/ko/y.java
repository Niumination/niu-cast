package ko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends t implements uo.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Object f9441a;

    public y(@os.l Object obj) {
        l0.p(obj, "recordComponent");
        this.f9441a = obj;
    }

    @Override // ko.t
    @os.l
    public Member Q() throws IllegalAccessException, InvocationTargetException {
        Method methodC = a.f9393a.c(this.f9441a);
        if (methodC != null) {
            return methodC;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // uo.w
    public boolean b() {
        return false;
    }

    @Override // uo.w
    @os.l
    public uo.x getType() throws IllegalAccessException, InvocationTargetException {
        Class<?> clsD = a.f9393a.d(this.f9441a);
        if (clsD != null) {
            return new n(clsD);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
