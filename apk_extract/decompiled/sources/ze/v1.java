package ze;

import androidx.core.os.EnvironmentCompat;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f11453d = Logger.getLogger(v1.class.getName());
    public static v1 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11454a = EnvironmentCompat.MEDIA_UNKNOWN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f11455b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i4.t0 f11456c = i4.t0.of();

    public final synchronized void a() {
        try {
            HashMap map = new HashMap();
            String str = EnvironmentCompat.MEDIA_UNKNOWN;
            int iC = Integer.MIN_VALUE;
            for (u1 u1Var : this.f11455b) {
                u1Var.getClass();
                u1 u1Var2 = (u1) map.get("dns");
                if (u1Var2 == null || u1Var2.c() < u1Var.c()) {
                    map.put("dns", u1Var);
                }
                if (iC < u1Var.c()) {
                    iC = u1Var.c();
                    str = "dns";
                }
            }
            this.f11456c = i4.t0.copyOf((Map) map);
            this.f11454a = str;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
