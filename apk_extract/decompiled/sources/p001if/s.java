package p001if;

import af.c6;
import af.d6;
import af.j2;
import java.util.List;
import java.util.Map;
import k3.v8;
import ze.b1;
import ze.c1;
import ze.d1;
import ze.f0;
import ze.q2;
import ze.s1;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends c1 {
    public static s1 f(Map map) {
        l lVar;
        l lVar2;
        List list;
        Integer num;
        Integer num2;
        Long lI = j2.i("interval", map);
        Long lI2 = j2.i("baseEjectionTime", map);
        Long lI3 = j2.i("maxEjectionTime", map);
        Integer numF = j2.f("maxEjectionPercentage", map);
        Long l4 = lI != null ? lI : 10000000000L;
        Long l8 = lI2 != null ? lI2 : 30000000000L;
        Long l10 = lI3 != null ? lI3 : 300000000000L;
        Integer num3 = numF != null ? numF : 10;
        Map mapG = j2.g("successRateEjection", map);
        if (mapG != null) {
            Integer num4 = 100;
            Integer numF2 = j2.f("stdevFactor", mapG);
            Integer numF3 = j2.f("enforcementPercentage", mapG);
            Integer numF4 = j2.f("minimumHosts", mapG);
            Integer numF5 = j2.f("requestVolume", mapG);
            Integer num5 = numF2 != null ? numF2 : 1900;
            if (numF3 != null) {
                v8.e(numF3.intValue() >= 0 && numF3.intValue() <= 100);
                num = numF3;
            } else {
                num = num4;
            }
            if (numF4 != null) {
                v8.e(numF4.intValue() >= 0);
                num2 = numF4;
            } else {
                num2 = 5;
            }
            if (numF5 != null) {
                v8.e(numF5.intValue() >= 0);
                num4 = numF5;
            }
            lVar = new l(num5, num, num2, num4);
        } else {
            lVar = null;
        }
        Map mapG2 = j2.g("failurePercentageEjection", map);
        if (mapG2 != null) {
            Integer num6 = 85;
            Integer num7 = 100;
            Integer num8 = 5;
            Integer num9 = 50;
            Integer numF6 = j2.f("threshold", mapG2);
            Integer numF7 = j2.f("enforcementPercentage", mapG2);
            Integer numF8 = j2.f("minimumHosts", mapG2);
            Integer numF9 = j2.f("requestVolume", mapG2);
            if (numF6 != null) {
                v8.e(numF6.intValue() >= 0 && numF6.intValue() <= 100);
                num6 = numF6;
            }
            if (numF7 != null) {
                v8.e(numF7.intValue() >= 0 && numF7.intValue() <= 100);
                num7 = numF7;
            }
            if (numF8 != null) {
                v8.e(numF8.intValue() >= 0);
                num8 = numF8;
            }
            if (numF9 != null) {
                v8.e(numF9.intValue() >= 0);
                num9 = numF9;
            }
            lVar2 = new l(num6, num7, num8, num9);
        } else {
            lVar2 = null;
        }
        List listC = j2.c("childPolicy", map);
        if (listC == null) {
            list = null;
        } else {
            j2.a(listC);
            list = listC;
        }
        List listW = d6.w(list);
        if (listW == null || listW.isEmpty()) {
            return new s1(q2.f11410m.h("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        s1 s1VarU = d6.u(listW, d1.a());
        if (s1VarU.f11433a != null) {
            return s1VarU;
        }
        c6 c6Var = (c6) s1VarU.f11434b;
        v8.m(c6Var != null);
        v8.m(c6Var != null);
        return new s1(new m(l4, l8, l10, num3, lVar, lVar2, c6Var));
    }

    @Override // ze.c1
    public String a() {
        return "outlier_detection_experimental";
    }

    @Override // ze.c1
    public int b() {
        return 5;
    }

    @Override // ze.c1
    public boolean c() {
        return true;
    }

    @Override // ze.c1
    public final b1 d(f0 f0Var) {
        return new r(f0Var);
    }

    @Override // ze.c1
    public s1 e(Map map) {
        try {
            return f(map);
        } catch (RuntimeException e) {
            return new s1(q2.f11411n.g(e).h("Failed parsing configuration for " + a()));
        }
    }
}
