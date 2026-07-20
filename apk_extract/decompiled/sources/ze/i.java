package ze;

import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11361a = new a("io.grpc.Grpc.TRANSPORT_ATTR_REMOTE_ADDR");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11362b = new a("io.grpc.Grpc.TRANSPORT_ATTR_LOCAL_ADDR");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11363c = new a("io.grpc.Grpc.TRANSPORT_ATTR_SSL_SESSION");

    public static f0 h(j0 j0Var) {
        k2 k2Var;
        List list;
        List<i2> list2;
        Logger logger = k2.f11369c;
        synchronized (k2.class) {
            try {
                if (k2.f11370d == null) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        arrayList.add(cf.z.class);
                    } catch (ClassNotFoundException e) {
                        k2.f11369c.log(Level.FINE, "Unable to find OkHttpServerProvider", (Throwable) e);
                    }
                    List<i2> listE = f0.e(i2.class, Collections.unmodifiableList(arrayList), i2.class.getClassLoader(), new p2(7));
                    k2.f11370d = new k2();
                    for (i2 i2Var : listE) {
                        k2.f11369c.fine("Service loader found " + i2Var);
                        k2 k2Var2 = k2.f11370d;
                        synchronized (k2Var2) {
                            v8.c("isAvailable() returned false", i2Var.a());
                            k2Var2.f11371a.add(i2Var);
                        }
                    }
                    k2 k2Var3 = k2.f11370d;
                    synchronized (k2Var3) {
                        ArrayList arrayList2 = new ArrayList(k2Var3.f11371a);
                        Collections.sort(arrayList2, Collections.reverseOrder(new i1(1)));
                        k2Var3.f11372b = Collections.unmodifiableList(arrayList2);
                    }
                }
                k2Var = k2.f11370d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (k2Var) {
            list = k2Var.f11372b;
        }
        if (list.isEmpty()) {
            throw new j2("No functional server found. Try adding a dependency on the grpc-netty, grpc-netty-shaded, or grpc-okhttp artifact");
        }
        StringBuilder sb2 = new StringBuilder();
        synchronized (k2Var) {
            list2 = k2Var.f11372b;
        }
        for (i2 i2Var2 : list2) {
            h2 h2VarB = i2Var2.b(0, j0Var);
            cf.y yVar = h2VarB.f11359a;
            if (yVar != null) {
                return yVar;
            }
            sb2.append("; ");
            sb2.append(i2Var2.getClass().getName());
            sb2.append(": ");
            sb2.append(h2VarB.f11360b);
        }
        throw new j2(sb2.substring(2));
    }

    public static q2 s(y yVar) {
        v8.i(yVar, "context must not be null");
        if (!yVar.m()) {
            return null;
        }
        Throwable thG = yVar.g();
        if (thG == null) {
            return q2.f.h("io.grpc.Context was cancelled without error");
        }
        if (thG instanceof TimeoutException) {
            return q2.f11405h.h(thG.getMessage()).g(thG);
        }
        q2 q2VarD = q2.d(thG);
        return (o2.UNKNOWN.equals(q2VarD.f11413a) && q2VarD.f11415c == thG) ? q2.f.h("Context cancelled").g(thG) : q2VarD.g(thG);
    }

    public abstract List a();

    public abstract b b();

    public abstract i c();

    public abstract Object d();

    public abstract String e();

    public abstract void f(h hVar, String str);

    public abstract void g(h hVar, String str, Object... objArr);

    public abstract void i();

    public void j() {
    }

    public abstract void k();

    public abstract void l(MessageLite messageLite);

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q(f0 f0Var);

    public abstract void r(a1 a1Var);

    public abstract void t(List list);
}
