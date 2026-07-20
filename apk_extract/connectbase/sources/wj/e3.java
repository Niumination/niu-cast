package wj;

import androidx.core.app.NotificationCompat;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class e3 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, ?> f18606b;

        public a(String str, Map<String, ?> map) {
            this.f18605a = (String) c1.h0.F(str, "policyName");
            this.f18606b = (Map) c1.h0.F(map, "rawConfigValue");
        }

        public String a() {
            return this.f18605a;
        }

        public Map<String, ?> b() {
            return this.f18606b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18605a.equals(aVar.f18605a) && this.f18606b.equals(aVar.f18606b);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f18605a, this.f18606b});
        }

        public String toString() {
            return c1.z.c(this).j("policyName", this.f18605a).j("rawConfigValue", this.f18606b).toString();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.p1 f18607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final Object f18608b;

        public b(vj.p1 p1Var, @gm.j Object obj) {
            this.f18607a = (vj.p1) c1.h0.F(p1Var, "provider");
            this.f18608b = obj;
        }

        @gm.j
        public Object a() {
            return this.f18608b;
        }

        public vj.p1 b() {
            return this.f18607a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return c1.b0.a(this.f18607a, bVar.f18607a) && c1.b0.a(this.f18608b, bVar.f18608b);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f18607a, this.f18608b});
        }

        public String toString() {
            return c1.z.c(this).j("provider", this.f18607a).j("config", this.f18608b).toString();
        }
    }

    public static a A(Map<String, ?> map) {
        if (map.size() == 1) {
            String key = map.entrySet().iterator().next().getKey();
            return new a(key, h1.l(map, key));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }

    public static List<a> B(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, ?>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(A(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @gm.j
    public static Double a(Map<String, ?> map) {
        return h1.h(map, "backoffMultiplier");
    }

    @gm.j
    public static Map<String, ?> b(@gm.j Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        return h1.l(map, "healthCheckConfig");
    }

    @gm.j
    public static String c(@gm.j Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        return h1.m(map, "serviceName");
    }

    @gm.j
    public static Long d(Map<String, ?> map) {
        return h1.n(map, "hedgingDelay");
    }

    @gm.j
    public static Map<String, ?> e(Map<String, ?> map) {
        return h1.l(map, "hedgingPolicy");
    }

    @gm.j
    public static Long f(Map<String, ?> map) {
        return h1.n(map, "initialBackoff");
    }

    public static Set<vj.y2.b> g(Map<String, ?> map, String str) {
        List<?> listE = h1.e(map, str);
        if (listE == null) {
            return null;
        }
        return v(listE);
    }

    @b1.e
    public static List<Map<String, ?>> h(Map<String, ?> map) {
        String strM;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(h1.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (strM = h1.m(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(strM.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @gm.j
    public static Integer i(Map<String, ?> map) {
        return h1.j(map, "maxAttempts");
    }

    @gm.j
    public static Integer j(Map<String, ?> map) {
        return h1.j(map, "maxAttempts");
    }

    @gm.j
    public static Long k(Map<String, ?> map) {
        return h1.n(map, "maxBackoff");
    }

    @gm.j
    public static Integer l(Map<String, ?> map) {
        return h1.j(map, "maxRequestMessageBytes");
    }

    @gm.j
    public static Integer m(Map<String, ?> map) {
        return h1.j(map, "maxResponseMessageBytes");
    }

    @gm.j
    public static List<Map<String, ?>> n(Map<String, ?> map) {
        return h1.f(map, "methodConfig");
    }

    @gm.j
    public static String o(Map<String, ?> map) {
        return h1.m(map, "method");
    }

    @gm.j
    public static List<Map<String, ?>> p(Map<String, ?> map) {
        return h1.f(map, "name");
    }

    public static Set<vj.y2.b> q(Map<String, ?> map) {
        Set<vj.y2.b> setG = g(map, "nonFatalStatusCodes");
        if (setG == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(vj.y2.b.class));
        }
        c1.w0.q(!setG.contains(vj.y2.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setG;
    }

    @gm.j
    public static Long r(Map<String, ?> map) {
        return h1.n(map, "perAttemptRecvTimeout");
    }

    @gm.j
    public static Map<String, ?> s(Map<String, ?> map) {
        return h1.l(map, "retryPolicy");
    }

    public static Set<vj.y2.b> t(Map<String, ?> map) {
        Set<vj.y2.b> setG = g(map, "retryableStatusCodes");
        c1.w0.q(setG != null, "%s is required in retry policy", "retryableStatusCodes");
        c1.w0.q(true ^ setG.contains(vj.y2.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return setG;
    }

    @gm.j
    public static String u(Map<String, ?> map) {
        return h1.m(map, NotificationCompat.CATEGORY_SERVICE);
    }

    public static Set<vj.y2.b> v(List<?> list) {
        vj.y2.b bVarValueOf;
        EnumSet enumSetNoneOf = EnumSet.noneOf(vj.y2.b.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d10 = (Double) obj;
                int iIntValue = d10.intValue();
                c1.w0.q(((double) iIntValue) == d10.doubleValue(), "Status code %s is not integral", obj);
                bVarValueOf = vj.y2.k(iIntValue).f17568a;
                c1.w0.q(bVarValueOf.value() == d10.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new c1.x0("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    bVarValueOf = vj.y2.b.valueOf((String) obj);
                } catch (IllegalArgumentException e10) {
                    throw new c1.x0("Status code " + obj + " is not valid", e10);
                }
            }
            enumSetNoneOf.add(bVarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    @gm.j
    public static m2.e0 w(@gm.j Map<String, ?> map) {
        Map<String, ?> mapL;
        if (map == null || (mapL = h1.l(map, "retryThrottling")) == null) {
            return null;
        }
        float fFloatValue = h1.h(mapL, "maxTokens").floatValue();
        float fFloatValue2 = h1.h(mapL, "tokenRatio").floatValue();
        c1.h0.h0(fFloatValue > 0.0f, "maxToken should be greater than zero");
        c1.h0.h0(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new m2.e0(fFloatValue, fFloatValue2);
    }

    @gm.j
    public static Long x(Map<String, ?> map) {
        return h1.n(map, RtspHeaders.Values.TIMEOUT);
    }

    @gm.j
    public static Boolean y(Map<String, ?> map) {
        return h1.d(map, "waitForReady");
    }

    public static vj.x1.c z(List<a> list, vj.q1 q1Var) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            String str = aVar.f18605a;
            vj.p1 p1VarE = q1Var.e(str);
            if (p1VarE != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(e3.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                vj.x1.c cVarE = p1VarE.e(aVar.f18606b);
                return cVarE.f17531a != null ? cVarE : new vj.x1.c(new b(p1VarE, cVarE.f17532b));
            }
            arrayList.add(str);
        }
        return vj.x1.c.b(vj.y2.f17550g.u("None of " + arrayList + " specified by Service Config are available."));
    }
}
