package l3;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class y1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y1 f7325c = new y1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7327b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f7326a = new l1(0);

    public static y1 a() {
        return f7325c;
    }

    public final f2 b(Class cls) {
        t1 t1VarC;
        u1 u1Var;
        Class cls2;
        Charset charset = z0.f7328a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f7327b;
        f2 f2Var = (f2) concurrentHashMap.get(cls);
        if (f2Var == null) {
            l1 l1Var = this.f7326a;
            l1Var.getClass();
            Class cls3 = g2.f7238a;
            if (!q0.class.isAssignableFrom(cls) && (cls2 = g2.f7238a) != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
            a2 a2VarA = ((k1) l1Var.f7264a).a(cls);
            if ((a2VarA.f7203d & 2) == 2) {
                boolean zIsAssignableFrom = q0.class.isAssignableFrom(cls);
                q1 q1Var = a2VarA.f7200a;
                if (zIsAssignableFrom) {
                    u1Var = new u1(g2.f7240c, h0.f7241a, q1Var);
                } else {
                    p2 p2Var = g2.f7239b;
                    g0 g0Var = h0.f7242b;
                    if (g0Var == null) {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                    u1Var = new u1(p2Var, g0Var, q1Var);
                }
                f2Var = u1Var;
            } else {
                if (q0.class.isAssignableFrom(cls)) {
                    if (a2VarA.b() - 1 != 1) {
                        int i8 = w1.f7318a;
                        h1 h1Var = i1.f7253b;
                        p2 p2Var2 = g2.f7240c;
                        g0 g0Var2 = h0.f7241a;
                        int i9 = o1.f7278a;
                        t1VarC = t1.C(a2VarA, h1Var, p2Var2, g0Var2);
                    } else {
                        int i10 = w1.f7318a;
                        h1 h1Var2 = i1.f7253b;
                        p2 p2Var3 = g2.f7240c;
                        int i11 = o1.f7278a;
                        t1VarC = t1.C(a2VarA, h1Var2, p2Var3, null);
                    }
                } else if (a2VarA.b() - 1 != 1) {
                    int i12 = w1.f7318a;
                    f1 f1Var = i1.f7252a;
                    p2 p2Var4 = g2.f7239b;
                    g0 g0Var3 = h0.f7242b;
                    if (g0Var3 == null) {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                    int i13 = o1.f7278a;
                    t1VarC = t1.C(a2VarA, f1Var, p2Var4, g0Var3);
                } else {
                    int i14 = w1.f7318a;
                    f1 f1Var2 = i1.f7252a;
                    p2 p2Var5 = g2.f7239b;
                    int i15 = o1.f7278a;
                    t1VarC = t1.C(a2VarA, f1Var2, p2Var5, null);
                }
                f2Var = t1VarC;
            }
            f2 f2Var2 = (f2) concurrentHashMap.putIfAbsent(cls, f2Var);
            if (f2Var2 != null) {
                return f2Var2;
            }
        }
        return f2Var;
    }
}
