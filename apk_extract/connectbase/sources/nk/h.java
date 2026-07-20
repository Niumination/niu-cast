package nk;

import ik.r0;
import java.io.File;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    @os.m
    public static final s a(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj) {
        s nVar;
        l0.p(fVar, "<this>");
        l0.p(obj, "value");
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj instanceof String) {
            return new y((String) obj, vk.b.a(fVar.getContext(), null), null);
        }
        if (obj instanceof byte[]) {
            nVar = new b((byte[]) obj, null, null, 6, null);
        } else {
            if (!(obj instanceof r0)) {
                if (obj instanceof z) {
                    z zVar = (z) obj;
                    if (l0.g(zVar.f11563b.getScheme(), "file")) {
                        nVar = new n(new File(zVar.f11563b), null, 2, null);
                    }
                }
                return null;
            }
            nVar = new j((r0) obj);
        }
        return nVar;
    }
}
