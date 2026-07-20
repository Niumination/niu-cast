package ze;

import af.h4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d1 f11342d;
    public static final List e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f11343a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f11344b = new LinkedHashMap();

    static {
        Logger logger = Logger.getLogger(d1.class.getName());
        f11341c = logger;
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(h4.class);
        } catch (ClassNotFoundException e4) {
            logger.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e4);
        }
        try {
            arrayList.add(p001if.x.class);
        } catch (ClassNotFoundException e10) {
            logger.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e10);
        }
        e = Collections.unmodifiableList(arrayList);
    }

    public static synchronized d1 a() {
        try {
            if (f11342d == null) {
                List<c1> listE = f0.e(c1.class, e, c1.class.getClassLoader(), new p2(3));
                f11342d = new d1();
                for (c1 c1Var : listE) {
                    f11341c.fine("Service loader found " + c1Var);
                    d1 d1Var = f11342d;
                    synchronized (d1Var) {
                        v8.c("isAvailable() returned false", c1Var.c());
                        d1Var.f11343a.add(c1Var);
                    }
                }
                f11342d.c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f11342d;
    }

    public final synchronized c1 b(String str) {
        LinkedHashMap linkedHashMap;
        linkedHashMap = this.f11344b;
        v8.i(str, "policy");
        return (c1) linkedHashMap.get(str);
    }

    public final synchronized void c() {
        try {
            this.f11344b.clear();
            for (c1 c1Var : this.f11343a) {
                String strA = c1Var.a();
                c1 c1Var2 = (c1) this.f11344b.get(strA);
                if (c1Var2 == null || c1Var2.b() < c1Var.b()) {
                    this.f11344b.put(strA, c1Var);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
