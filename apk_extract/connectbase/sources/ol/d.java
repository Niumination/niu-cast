package ol;

import ik.y0;
import java.lang.reflect.Type;
import kn.l0;
import kn.l1;
import os.l;
import un.b0;
import un.s;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @l
    public static final Type a(@l s sVar) {
        l0.p(sVar, "<this>");
        return b0.f(sVar);
    }

    public static /* synthetic */ void b(s sVar) {
    }

    public static final boolean c(@l Object obj, @l un.d<?> dVar) {
        l0.p(obj, "<this>");
        l0.p(dVar, y0.a.f8215h);
        return in.b.e(dVar).isInstance(obj);
    }

    public static final <T> b d() {
        l0.P();
        Type typeF = b0.f(null);
        l0.P();
        return e(typeF, l1.d(Object.class), null);
    }

    @l
    public static final b e(@l Type type, @l un.d<?> dVar, @l s sVar) {
        l0.p(type, "reifiedType");
        l0.p(dVar, "kClass");
        l0.p(sVar, "kType");
        return new c(dVar, type, sVar);
    }
}
