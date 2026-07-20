package p001if;

import af.h4;
import af.v2;
import i4.h0;
import i4.h5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;
import y6.g;
import ze.b;
import ze.b1;
import ze.c0;
import ze.f0;
import ze.q;
import ze.q2;
import ze.x0;
import ze.y0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends b1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Logger f5810i = Logger.getLogger(h.class.getName());
    public final f0 e;
    public boolean f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f5813h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f5811d = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h4 f5812g = new h4();

    public h(f0 f0Var) {
        this.e = f0Var;
        f5810i.log(Level.FINE, "Created");
    }

    @Override // ze.b1
    public final q2 a(y0 y0Var) {
        try {
            this.f = true;
            g gVarG = g(y0Var);
            q2 q2Var = (q2) gVarG.f11095a;
            if (!q2Var.e()) {
                this.f = false;
                return q2Var;
            }
            h();
            for (f fVar : (ArrayList) gVarG.f11096b) {
                fVar.f5804b.f();
                fVar.f5806d = q.SHUTDOWN;
                f5810i.log(Level.FINE, "Child balancer {0} deleted", fVar.f5803a);
            }
            this.f = false;
            return q2Var;
        } catch (Throwable th2) {
            this.f = false;
            throw th2;
        }
    }

    @Override // ze.b1
    public final void c(q2 q2Var) {
        if (this.f5813h != q.READY) {
            this.e.m(q.TRANSIENT_FAILURE, new v2(x0.a(q2Var), 1));
        }
    }

    @Override // ze.b1
    public final void f() {
        Level level = Level.INFO;
        Logger logger = f5810i;
        logger.log(level, "Shutdown");
        LinkedHashMap linkedHashMap = this.f5811d;
        for (f fVar : linkedHashMap.values()) {
            fVar.f5804b.f();
            fVar.f5806d = q.SHUTDOWN;
            logger.log(Level.FINE, "Child balancer {0} deleted", fVar.f5803a);
        }
        linkedHashMap.clear();
    }

    public final g g(y0 y0Var) {
        LinkedHashMap linkedHashMap;
        g gVar;
        c0 c0Var;
        Level level = Level.FINE;
        Logger logger = f5810i;
        logger.log(level, "Received resolution result: {0}", y0Var);
        HashMap map = new HashMap();
        List list = y0Var.f11477a;
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            linkedHashMap = this.f5811d;
            if (!zHasNext) {
                break;
            }
            g gVar2 = new g((c0) it.next());
            f fVar = (f) linkedHashMap.get(gVar2);
            if (fVar != null) {
                map.put(gVar2, fVar);
            } else {
                map.put(gVar2, new f(this, gVar2, this.f5812g));
            }
        }
        if (map.isEmpty()) {
            q2 q2VarH = q2.f11411n.h("NameResolver returned no usable address. " + y0Var);
            c(q2VarH);
            return new g(q2VarH, null);
        }
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            h4 h4Var = ((f) entry.getValue()).f5805c;
            ((f) entry.getValue()).getClass();
            if (linkedHashMap.containsKey(key)) {
                f fVar2 = (f) linkedHashMap.get(key);
                if (fVar2.f) {
                    fVar2.f = false;
                }
            } else {
                linkedHashMap.put(key, (f) entry.getValue());
            }
            f fVar3 = (f) linkedHashMap.get(key);
            if (key instanceof c0) {
                gVar = new g((c0) key);
            } else {
                v8.c("key is wrong type", key instanceof g);
                gVar = (g) key;
            }
            Iterator it2 = list.iterator();
            do {
                if (!it2.hasNext()) {
                    c0Var = null;
                    break;
                }
                c0Var = (c0) it2.next();
            } while (!gVar.equals(new g(c0Var)));
            v8.i(c0Var, key + " no longer present in load balancer children");
            b bVar = b.f11321b;
            y0 y0Var2 = new y0(Collections.singletonList(c0Var), y0Var.f11478b, null);
            ((f) linkedHashMap.get(key)).getClass();
            if (!fVar3.f) {
                fVar3.f5804b.d(y0Var2);
            }
        }
        ArrayList arrayList = new ArrayList();
        h5 it3 = h0.copyOf((Collection) linkedHashMap.keySet()).iterator();
        while (it3.hasNext()) {
            Object next = it3.next();
            if (!map.containsKey(next)) {
                f fVar4 = (f) linkedHashMap.get(next);
                if (!fVar4.f) {
                    LinkedHashMap linkedHashMap2 = fVar4.f5807g.f5811d;
                    g gVar3 = fVar4.f5803a;
                    linkedHashMap2.remove(gVar3);
                    fVar4.f = true;
                    logger.log(Level.FINE, "Child balancer {0} deactivated", gVar3);
                }
                arrayList.add(fVar4);
            }
        }
        return new g(q2.e, arrayList);
    }

    public abstract void h();
}
