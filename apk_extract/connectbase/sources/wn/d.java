package wn;

import eo.h;
import in.i;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.l1;
import lm.f1;
import nm.h0;
import os.l;
import un.g;
import un.s;
import un.t;
import xn.v;
import xn.y;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "KTypesJvm")
public final class d {
    @l
    public static final un.d<?> a(@l g gVar) {
        Object obj;
        l0.p(gVar, "<this>");
        if (gVar instanceof un.d) {
            return (un.d) gVar;
        }
        if (!(gVar instanceof t)) {
            throw new y(l0.C("Cannot calculate JVM erasure for type: ", gVar));
        }
        List<s> upperBounds = ((t) gVar).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            h hVarD = ((v) ((s) next)).f20427a.G0().d();
            eo.e eVar = hVarD instanceof eo.e ? (eo.e) hVarD : null;
            if (eVar != null && eVar.getKind() != eo.f.INTERFACE && eVar.getKind() != eo.f.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        s sVar = (s) obj;
        if (sVar == null) {
            sVar = (s) h0.G2(upperBounds);
        }
        return sVar == null ? l1.d(Object.class) : b(sVar);
    }

    @l
    public static final un.d<?> b(@l s sVar) {
        l0.p(sVar, "<this>");
        g gVarI = sVar.i();
        if (gVarI != null) {
            return a(gVarI);
        }
        throw new y(l0.C("Cannot calculate JVM erasure for type: ", sVar));
    }

    @f1(version = "1.1")
    public static /* synthetic */ void c(s sVar) {
    }
}
