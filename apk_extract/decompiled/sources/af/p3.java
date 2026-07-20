package af;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k3.t8;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3 f500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f5 f503d;
    public final Object e;
    public final Map f;

    public p3(n3 n3Var, HashMap map, HashMap map2, f5 f5Var, Object obj, Map map3) {
        this.f500a = n3Var;
        this.f501b = h0.a.s(map);
        this.f502c = h0.a.s(map2);
        this.f503d = f5Var;
        this.e = obj;
        this.f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static p3 a(Map map, boolean z2, int i8, int i9, Object obj) {
        f5 f5Var;
        Map mapG;
        f5 f5Var2;
        if (z2) {
            if (map == null || (mapG = j2.g("retryThrottling", map)) == null) {
                f5Var2 = null;
            } else {
                float fFloatValue = j2.e("maxTokens", mapG).floatValue();
                float fFloatValue2 = j2.e("tokenRatio", mapG).floatValue();
                v8.n(fFloatValue > 0.0f, "maxToken should be greater than zero");
                v8.n(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
                f5Var2 = new f5(fFloatValue, fFloatValue2);
            }
            f5Var = f5Var2;
        } else {
            f5Var = null;
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Map mapG2 = map == null ? null : j2.g("healthCheckConfig", map);
        List<Map> listC = j2.c("methodConfig", map);
        if (listC == null) {
            listC = null;
        } else {
            j2.a(listC);
        }
        if (listC == null) {
            return new p3(null, map2, map3, f5Var, obj, mapG2);
        }
        n3 n3Var = null;
        for (Map map4 : listC) {
            n3 n3Var2 = new n3(map4, i8, i9, z2);
            List<Map> listC2 = j2.c("name", map4);
            if (listC2 == null) {
                listC2 = null;
            } else {
                j2.a(listC2);
            }
            if (listC2 != null && !listC2.isEmpty()) {
                for (Map map5 : listC2) {
                    String strH = j2.h("service", map5);
                    String strH2 = j2.h("method", map5);
                    if (h4.q.a(strH)) {
                        v8.d("missing service name for method %s", h4.q.a(strH2), strH2);
                        v8.d("Duplicate default method config in service config %s", n3Var == null, map);
                        n3Var = n3Var2;
                    } else if (h4.q.a(strH2)) {
                        v8.d("Duplicate service %s", !map3.containsKey(strH), strH);
                        map3.put(strH, n3Var2);
                    } else {
                        String strA = ze.r1.a(strH, strH2);
                        v8.d("Duplicate method name %s", !map2.containsKey(strA), strA);
                        map2.put(strA, n3Var2);
                    }
                }
            }
        }
        return new p3(n3Var, map2, map3, f5Var, obj, mapG2);
    }

    public final o3 b() {
        if (this.f502c.isEmpty() && this.f501b.isEmpty() && this.f500a == null) {
            return null;
        }
        return new o3(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p3.class != obj.getClass()) {
            return false;
        }
        p3 p3Var = (p3) obj;
        return u8.a(this.f500a, p3Var.f500a) && u8.a(this.f501b, p3Var.f501b) && u8.a(this.f502c, p3Var.f502c) && u8.a(this.f503d, p3Var.f503d) && u8.a(this.e, p3Var.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f500a, this.f501b, this.f502c, this.f503d, this.e});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f500a, "defaultMethodConfig");
        aVarA.d(this.f501b, "serviceMethodMap");
        aVarA.d(this.f502c, "serviceMap");
        aVarA.d(this.f503d, "retryThrottling");
        aVarA.d(this.e, "loadBalancingConfig");
        return aVarA.toString();
    }
}
