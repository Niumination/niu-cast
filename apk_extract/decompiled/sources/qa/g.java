package qa;

import com.google.protobuf.ExtensionRegistryLite;
import ze.m2;
import ze.q1;
import ze.r1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile r1 f8973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile m2 f8974b;

    public static r1 a() {
        r1 r1VarH = f8973a;
        if (r1VarH == null) {
            synchronized (g.class) {
                try {
                    r1VarH = f8973a;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.UNARY;
                        bVarB.e = r1.a("lifecycle._LifecycleService", "sendPackageName");
                        bVarB.f4714a = true;
                        f fVar = f.f8970b;
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(fVar);
                        bVarB.f4716c = new gf.b(c.f8967a);
                        r1VarH = bVarB.h();
                        f8973a = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }
}
