package af;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class w5 extends ze.b2 implements ze.q0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Logger f662t = Logger.getLogger(w5.class.getName());
    public static final k2 u = new k2(19);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.r0 f663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a8.a f664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Executor f665d;
    public final u1 e;
    public final x5 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ze.f2[] f667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final cf.x f671l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f672m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashSet f673n = new HashSet();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ze.y f674o;
    public final ze.b0 p;
    public final ze.o0 q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final r f675r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ze.p2 f676s;

    public w5(y5 y5Var, cf.x xVar, ze.y yVar) {
        List listUnmodifiableList;
        a8.a aVar = y5Var.f731g;
        v8.i(aVar, "executorPool");
        this.f664c = aVar;
        se.e eVar = y5Var.f727a;
        eVar.getClass();
        HashMap map = new HashMap();
        LinkedHashMap linkedHashMap = (LinkedHashMap) eVar.f9720b;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            for (ze.g2 g2Var : ((ze.l2) it.next()).f11374b.values()) {
                map.put(g2Var.f11353a.f11423b, g2Var);
            }
        }
        this.e = new u1(Collections.unmodifiableList(new ArrayList(linkedHashMap.values())), Collections.unmodifiableMap(map));
        x5 x5Var = y5Var.f;
        v8.i(x5Var, "fallbackRegistry");
        this.f = x5Var;
        this.f671l = xVar;
        synchronized (this.f672m) {
            listUnmodifiableList = Collections.unmodifiableList(Collections.singletonList(xVar.f1654h));
        }
        ze.r0 r0Var = new ze.r0("Server", String.valueOf(listUnmodifiableList), ze.r0.f11418d.incrementAndGet());
        this.f663b = r0Var;
        v8.i(yVar, "rootContext");
        this.f674o = new ze.y(yVar.f11475b, yVar.f11476c + 1);
        this.p = y5Var.f732h;
        this.f666g = Collections.unmodifiableList(new ArrayList(y5Var.f728b));
        ArrayList arrayList = y5Var.f729c;
        this.f667h = (ze.f2[]) arrayList.toArray(new ze.f2[arrayList.size()]);
        this.f668i = y5Var.f734j;
        ze.o0 o0Var = y5Var.p;
        this.q = o0Var;
        y5Var.q.getClass();
        this.f675r = new r();
        ze.p2 p2Var = y5Var.f735k;
        v8.i(p2Var, "ticker");
        this.f676s = p2Var;
        ze.o0.a(o0Var.f11390a, this);
    }

    @Override // ze.b2
    public final w5 b() {
        synchronized (this.f672m) {
            v8.n(!this.f669j, "Already started");
            this.f671l.a(new tj.w(this, 3));
            Executor executor = (Executor) g6.a((f6) this.f664c.f44b);
            v8.i(executor, "executor");
            this.f665d = executor;
            this.f669j = true;
        }
        return this;
    }

    @Override // ze.q0
    public final ze.r0 d() {
        return this.f663b;
    }

    public final int e() {
        synchronized (this.f672m) {
            try {
                v8.n(this.f669j, "Not started");
                for (SocketAddress socketAddress : Collections.singletonList(this.f671l.f1654h)) {
                    if (socketAddress instanceof InetSocketAddress) {
                        return ((InetSocketAddress) socketAddress).getPort();
                    }
                }
                return -1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.e("logId", this.f663b.f11421c);
        aVarA.d(this.f671l, "transportServer");
        return aVarA.toString();
    }
}
