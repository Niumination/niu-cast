package ck;

import java.util.List;
import java.util.Map;
import vj.o1;
import vj.p1;
import vj.q1;
import vj.t0;
import vj.x1;
import vj.y2;
import wj.e3;
import wj.h1;
import wj.n3;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class n extends p1 {
    @Override // vj.o1.d
    public o1 a(o1.f fVar) {
        return new l(fVar, n3.f19104a);
    }

    @Override // vj.p1
    public String b() {
        return "outlier_detection_experimental";
    }

    @Override // vj.p1
    public int c() {
        return 5;
    }

    @Override // vj.p1
    public boolean d() {
        return true;
    }

    @Override // vj.p1
    public x1.c e(Map<String, ?> map) {
        try {
            return f(map);
        } catch (RuntimeException e10) {
            return x1.c.b(y2.f17563t.t(e10).u("Failed parsing configuration for " + b()));
        }
    }

    public final x1.c f(Map<String, ?> map) {
        Long lN = h1.n(map, "interval");
        Long lN2 = h1.n(map, "baseEjectionTime");
        Long lN3 = h1.n(map, "maxEjectionTime");
        Integer numJ = h1.j(map, "maxEjectionPercentage");
        l.g.a aVar = new l.g.a();
        if (lN != null) {
            aVar.e(lN);
        }
        if (lN2 != null) {
            aVar.b(lN2);
        }
        if (lN3 != null) {
            aVar.g(lN3);
        }
        if (numJ != null) {
            aVar.f(numJ);
        }
        Map<String, ?> mapL = h1.l(map, "successRateEjection");
        if (mapL != null) {
            l.g.c.a aVar2 = new l.g.c.a();
            Integer numJ2 = h1.j(mapL, "stdevFactor");
            Integer numJ3 = h1.j(mapL, "enforcementPercentage");
            Integer numJ4 = h1.j(mapL, "minimumHosts");
            Integer numJ5 = h1.j(mapL, "requestVolume");
            if (numJ2 != null) {
                aVar2.e(numJ2);
            }
            if (numJ3 != null) {
                aVar2.b(numJ3);
            }
            if (numJ4 != null) {
                aVar2.c(numJ4);
            }
            if (numJ5 != null) {
                aVar2.d(numJ5);
            }
            aVar.f1574e = aVar2.a();
        }
        Map<String, ?> mapL2 = h1.l(map, "failurePercentageEjection");
        if (mapL2 != null) {
            l.g.b.a aVar3 = new l.g.b.a();
            Integer numJ6 = h1.j(mapL2, "threshold");
            Integer numJ7 = h1.j(mapL2, "enforcementPercentage");
            Integer numJ8 = h1.j(mapL2, "minimumHosts");
            Integer numJ9 = h1.j(mapL2, "requestVolume");
            if (numJ6 != null) {
                aVar3.e(numJ6);
            }
            if (numJ7 != null) {
                aVar3.b(numJ7);
            }
            if (numJ8 != null) {
                aVar3.c(numJ8);
            }
            if (numJ9 != null) {
                aVar3.d(numJ9);
            }
            aVar.f1575f = aVar3.a();
        }
        List<e3.a> listB = e3.B(h1.f(map, "childPolicy"));
        if (listB == null || listB.isEmpty()) {
            return x1.c.b(y2.f17562s.u("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        x1.c cVarZ = e3.z(listB, q1.c());
        if (cVarZ.f17531a != null) {
            return cVarZ;
        }
        aVar.c((e3.b) cVarZ.f17532b);
        return new x1.c(aVar.a());
    }
}
