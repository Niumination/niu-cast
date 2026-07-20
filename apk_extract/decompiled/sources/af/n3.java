package af;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import k3.t8;
import k3.u8;
import k3.v8;
import k3.x8;

/* JADX INFO: loaded from: classes3.dex */
public final class n3 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ze.e f465g = new ze.e("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f469d;
    public final g5 e;
    public final o1 f;

    public n3(Map map, int i8, int i9, boolean z2) {
        g5 g5Var;
        o1 o1Var;
        this.f466a = j2.i("timeout", map);
        this.f467b = j2.b("waitForReady", map);
        Integer numF = j2.f("maxResponseMessageBytes", map);
        this.f468c = numF;
        if (numF != null) {
            v8.d("maxInboundMessageSize %s exceeds bounds", numF.intValue() >= 0, numF);
        }
        Integer numF2 = j2.f("maxRequestMessageBytes", map);
        this.f469d = numF2;
        if (numF2 != null) {
            v8.d("maxOutboundMessageSize %s exceeds bounds", numF2.intValue() >= 0, numF2);
        }
        Map mapG = z2 ? j2.g("retryPolicy", map) : null;
        if (mapG == null) {
            g5Var = null;
        } else {
            Integer numF3 = j2.f("maxAttempts", mapG);
            v8.i(numF3, "maxAttempts cannot be empty");
            int iIntValue = numF3.intValue();
            v8.b(iIntValue, "maxAttempts must be greater than 1: %s", iIntValue >= 2);
            int iMin = Math.min(iIntValue, i8);
            Long lI = j2.i("initialBackoff", mapG);
            v8.i(lI, "initialBackoff cannot be empty");
            long jLongValue = lI.longValue();
            v8.f(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            Long lI2 = j2.i("maxBackoff", mapG);
            v8.i(lI2, "maxBackoff cannot be empty");
            long jLongValue2 = lI2.longValue();
            v8.f(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double dE = j2.e("backoffMultiplier", mapG);
            v8.i(dE, "backoffMultiplier cannot be empty");
            double dDoubleValue = dE.doubleValue();
            v8.d("backoffMultiplier must be greater than 0: %s", dDoubleValue > 0.0d, dE);
            Long lI3 = j2.i("perAttemptRecvTimeout", mapG);
            v8.d("perAttemptRecvTimeout cannot be negative: %s", lI3 == null || lI3.longValue() >= 0, lI3);
            Set setP = d6.p("retryableStatusCodes", mapG);
            x8.a("%s is required in retry policy", setP != null, "retryableStatusCodes");
            x8.a("%s must not contain OK", !setP.contains(ze.o2.OK), "retryableStatusCodes");
            v8.c("retryableStatusCodes cannot be empty without perAttemptRecvTimeout", (lI3 == null && setP.isEmpty()) ? false : true);
            g5Var = new g5(iMin, jLongValue, jLongValue2, dDoubleValue, lI3, setP);
        }
        this.e = g5Var;
        Map mapG2 = z2 ? j2.g("hedgingPolicy", map) : null;
        if (mapG2 == null) {
            o1Var = null;
        } else {
            Integer numF4 = j2.f("maxAttempts", mapG2);
            v8.i(numF4, "maxAttempts cannot be empty");
            int iIntValue2 = numF4.intValue();
            v8.b(iIntValue2, "maxAttempts must be greater than 1: %s", iIntValue2 >= 2);
            int iMin2 = Math.min(iIntValue2, i9);
            Long lI4 = j2.i("hedgingDelay", mapG2);
            v8.i(lI4, "hedgingDelay cannot be empty");
            long jLongValue3 = lI4.longValue();
            v8.f(jLongValue3 >= 0, "hedgingDelay must not be negative: %s", jLongValue3);
            Set setP2 = d6.p("nonFatalStatusCodes", mapG2);
            if (setP2 == null) {
                setP2 = Collections.unmodifiableSet(EnumSet.noneOf(ze.o2.class));
            } else {
                x8.a("%s must not contain OK", !setP2.contains(ze.o2.OK), "nonFatalStatusCodes");
            }
            o1Var = new o1(iMin2, jLongValue3, setP2);
        }
        this.f = o1Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        return u8.a(this.f466a, n3Var.f466a) && u8.a(this.f467b, n3Var.f467b) && u8.a(this.f468c, n3Var.f468c) && u8.a(this.f469d, n3Var.f469d) && u8.a(this.e, n3Var.e) && u8.a(this.f, n3Var.f);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f466a, this.f467b, this.f468c, this.f469d, this.e, this.f});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f466a, "timeoutNanos");
        aVarA.d(this.f467b, "waitForReady");
        aVarA.d(this.f468c, "maxInboundMessageSize");
        aVarA.d(this.f469d, "maxOutboundMessageSize");
        aVarA.d(this.e, "retryPolicy");
        aVarA.d(this.f, "hedgingPolicy");
        return aVarA.toString();
    }
}
