package af;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p1 extends b {
    public static final ze.n1 u = ze.t0.a(":status", new k2(14));
    public ze.q2 q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ze.p1 f497r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Charset f498s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f499t;

    public static Charset t(ze.p1 p1Var) {
        String str = (String) p1Var.c(l1.f417j);
        if (str != null) {
            String[] strArrSplit = str.split("charset=", 2);
            try {
                return Charset.forName(strArrSplit[strArrSplit.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return h4.f.f5248b;
    }

    public static ze.q2 u(ze.p1 p1Var) {
        Integer num = (Integer) p1Var.c(u);
        if (num == null) {
            return ze.q2.f11410m.h("Missing HTTP status code");
        }
        String str = (String) p1Var.c(l1.f417j);
        if (l1.i(str)) {
            return null;
        }
        return l1.h(num.intValue()).a("invalid content-type: " + str);
    }
}
