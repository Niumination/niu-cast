package wj;

import androidx.core.app.NotificationCompat;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.j
    public final b f19175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b> f19176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, b> f19177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @gm.j
    public final m2.e0 f19178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.j
    public final Object f19179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.j
    public final Map<String, ?> f19180f;

    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final vj.e.c<b> f19181g = vj.e.c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f19182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f19183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f19184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f19185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final n2 f19186e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final x0 f19187f;

        public b(Map<String, ?> map, boolean z10, int i10, int i11) {
            this.f19182a = h1.n(map, RtspHeaders.Values.TIMEOUT);
            this.f19183b = h1.d(map, "waitForReady");
            Integer numJ = h1.j(map, "maxResponseMessageBytes");
            this.f19184c = numJ;
            if (numJ != null) {
                c1.h0.u(numJ.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numJ);
            }
            Integer numJ2 = h1.j(map, "maxRequestMessageBytes");
            this.f19185d = numJ2;
            if (numJ2 != null) {
                c1.h0.u(numJ2.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numJ2);
            }
            Map<String, ?> mapL = z10 ? h1.l(map, "retryPolicy") : null;
            this.f19186e = mapL == null ? null : b(mapL, i10);
            Map<String, ?> mapL2 = z10 ? h1.l(map, "hedgingPolicy") : null;
            this.f19187f = mapL2 != null ? a(mapL2, i11) : null;
        }

        public static x0 a(Map<String, ?> map, int i10) {
            int iIntValue = ((Integer) c1.h0.F(h1.j(map, "maxAttempts"), "maxAttempts cannot be empty")).intValue();
            c1.h0.k(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i10);
            long jLongValue = ((Long) c1.h0.F(h1.n(map, "hedgingDelay"), "hedgingDelay cannot be empty")).longValue();
            c1.h0.p(jLongValue >= 0, "hedgingDelay must not be negative: %s", jLongValue);
            return new x0(iMin, jLongValue, e3.q(map));
        }

        public static n2 b(Map<String, ?> map, int i10) {
            int iIntValue = ((Integer) c1.h0.F(h1.j(map, "maxAttempts"), "maxAttempts cannot be empty")).intValue();
            c1.h0.k(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i10);
            long jLongValue = ((Long) c1.h0.F(h1.n(map, "initialBackoff"), "initialBackoff cannot be empty")).longValue();
            c1.h0.p(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            long jLongValue2 = ((Long) c1.h0.F(h1.n(map, "maxBackoff"), "maxBackoff cannot be empty")).longValue();
            c1.h0.p(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double d10 = (Double) c1.h0.F(h1.h(map, "backoffMultiplier"), "backoffMultiplier cannot be empty");
            double dDoubleValue = d10.doubleValue();
            c1.h0.u(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", d10);
            Long lN = h1.n(map, "perAttemptRecvTimeout");
            c1.h0.u(lN == null || lN.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lN);
            Set<vj.y2.b> setT = e3.t(map);
            c1.h0.e((lN == null && setT.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new n2(iMin, jLongValue, jLongValue2, dDoubleValue, lN, setT);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return c1.b0.a(this.f19182a, bVar.f19182a) && c1.b0.a(this.f19183b, bVar.f19183b) && c1.b0.a(this.f19184c, bVar.f19184c) && c1.b0.a(this.f19185d, bVar.f19185d) && c1.b0.a(this.f19186e, bVar.f19186e) && c1.b0.a(this.f19187f, bVar.f19187f);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f19182a, this.f19183b, this.f19184c, this.f19185d, this.f19186e, this.f19187f});
        }

        public String toString() {
            return c1.z.c(this).j("timeoutNanos", this.f19182a).j("waitForReady", this.f19183b).j("maxInboundMessageSize", this.f19184c).j("maxOutboundMessageSize", this.f19185d).j("retryPolicy", this.f19186e).j("hedgingPolicy", this.f19187f).toString();
        }
    }

    public static final class c extends vj.x0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q1 f19188b;

        public c(q1 q1Var) {
            this.f19188b = q1Var;
        }

        @Override // vj.x0
        public vj.x0.b a(vj.o1.h hVar) {
            return new vj.x0.b.a().b(this.f19188b).a();
        }
    }

    public q1(@gm.j b bVar, Map<String, b> map, Map<String, b> map2, @gm.j m2.e0 e0Var, @gm.j Object obj, @gm.j Map<String, ?> map3) {
        this.f19175a = bVar;
        this.f19176b = Collections.unmodifiableMap(new HashMap(map));
        this.f19177c = Collections.unmodifiableMap(new HashMap(map2));
        this.f19178d = e0Var;
        this.f19179e = obj;
        this.f19180f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static q1 a() {
        return new q1(null, new HashMap(), new HashMap(), null, null, null);
    }

    public static q1 b(Map<String, ?> map, boolean z10, int i10, int i11, @gm.j Object obj) {
        m2.e0 e0VarW = z10 ? e3.w(map) : null;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Map<String, ?> mapB = e3.b(map);
        List<Map<String, ?>> listF = h1.f(map, "methodConfig");
        if (listF == null) {
            return new q1(null, map2, map3, e0VarW, obj, mapB);
        }
        b bVar = null;
        for (Map<String, ?> map4 : listF) {
            b bVar2 = new b(map4, z10, i10, i11);
            List<Map<String, ?>> listF2 = h1.f(map4, "name");
            if (listF2 != null && !listF2.isEmpty()) {
                for (Map<String, ?> map5 : listF2) {
                    String strM = h1.m(map5, NotificationCompat.CATEGORY_SERVICE);
                    String strM2 = h1.m(map5, "method");
                    if (c1.g0.j(strM)) {
                        c1.h0.u(c1.g0.j(strM2), "missing service name for method %s", strM2);
                        c1.h0.u(bVar == null, "Duplicate default method config in service config %s", map);
                        bVar = bVar2;
                    } else if (c1.g0.j(strM2)) {
                        c1.h0.u(!map3.containsKey(strM), "Duplicate service %s", strM);
                        map3.put(strM, bVar2);
                    } else {
                        String strD = vj.w1.d(strM, strM2);
                        c1.h0.u(!map2.containsKey(strD), "Duplicate method name %s", strD);
                        map2.put(strD, bVar2);
                    }
                }
            }
        }
        return new q1(bVar, map2, map3, e0VarW, obj, mapB);
    }

    @gm.j
    public vj.x0 c() {
        if (this.f19177c.isEmpty() && this.f19176b.isEmpty() && this.f19175a == null) {
            return null;
        }
        return new c(this);
    }

    @gm.j
    public Map<String, ?> d() {
        return this.f19180f;
    }

    @gm.j
    @b1.e
    public Object e() {
        return this.f19179e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q1.class != obj.getClass()) {
            return false;
        }
        q1 q1Var = (q1) obj;
        return c1.b0.a(this.f19175a, q1Var.f19175a) && c1.b0.a(this.f19176b, q1Var.f19176b) && c1.b0.a(this.f19177c, q1Var.f19177c) && c1.b0.a(this.f19178d, q1Var.f19178d) && c1.b0.a(this.f19179e, q1Var.f19179e);
    }

    @gm.j
    public b f(vj.w1<?, ?> w1Var) {
        b bVar = this.f19176b.get(w1Var.f17481b);
        if (bVar == null) {
            bVar = this.f19177c.get(w1Var.f17482c);
        }
        return bVar == null ? this.f19175a : bVar;
    }

    @gm.j
    public m2.e0 g() {
        return this.f19178d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f19175a, this.f19176b, this.f19177c, this.f19178d, this.f19179e});
    }

    public String toString() {
        return c1.z.c(this).j("defaultMethodConfig", this.f19175a).j("serviceMethodMap", this.f19176b).j("serviceMap", this.f19177c).j("retryThrottling", this.f19178d).j("loadBalancingConfig", this.f19179e).toString();
    }
}
