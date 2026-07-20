package vj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2 f17267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, q2<?, ?>> f17268b;

    public static b a(String str) {
        return new b(str);
    }

    public static b b(w2 w2Var) {
        return new b(w2Var);
    }

    @t0
    public q2<?, ?> c(String str) {
        return this.f17268b.get(str);
    }

    public Collection<q2<?, ?>> d() {
        return this.f17268b.values();
    }

    public w2 e() {
        return this.f17267a;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w2 f17270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, q2<?, ?>> f17271c;

        public <ReqT, RespT> b a(w1<ReqT, RespT> w1Var, m2<ReqT, RespT> m2Var) {
            return b(new q2<>((w1) c1.h0.F(w1Var, "method must not be null"), (m2) c1.h0.F(m2Var, "handler must not be null")));
        }

        public <ReqT, RespT> b b(q2<ReqT, RespT> q2Var) {
            w1<ReqT, RespT> w1Var = q2Var.f17252a;
            c1.h0.y(this.f17269a.equals(w1Var.f17482c), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", this.f17269a, w1Var.f17481b);
            String str = w1Var.f17481b;
            c1.h0.x0(!this.f17271c.containsKey(str), "Method by same name already registered: %s", str);
            this.f17271c.put(str, q2Var);
            return this;
        }

        public t2 c() {
            w2 w2Var = this.f17270b;
            if (w2Var == null) {
                ArrayList arrayList = new ArrayList(this.f17271c.size());
                Iterator<q2<?, ?>> it = this.f17271c.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f17252a);
                }
                w2Var = new w2(this.f17269a, arrayList);
            }
            HashMap map = new HashMap(this.f17271c);
            for (w1<?, ?> w1Var : w2Var.f17500b) {
                q2 q2Var = (q2) map.remove(w1Var.f17481b);
                if (q2Var == null) {
                    throw new IllegalStateException("No method bound for descriptor entry " + w1Var.f17481b);
                }
                if (q2Var.f17252a != w1Var) {
                    throw new IllegalStateException(j.c.a(new StringBuilder("Bound method for "), w1Var.f17481b, " not same instance as method in service descriptor"));
                }
            }
            if (map.size() <= 0) {
                return new t2(w2Var, this.f17271c);
            }
            throw new IllegalStateException("No entry in descriptor matching bound method " + ((q2) map.values().iterator().next()).f17252a.f17481b);
        }

        public b(String str) {
            this.f17271c = new HashMap();
            this.f17269a = (String) c1.h0.F(str, "serviceName");
            this.f17270b = null;
        }

        public b(w2 w2Var) {
            this.f17271c = new HashMap();
            this.f17270b = (w2) c1.h0.F(w2Var, "serviceDescriptor");
            this.f17269a = w2Var.f17499a;
        }
    }

    public t2(w2 w2Var, Map<String, q2<?, ?>> map) {
        this.f17267a = (w2) c1.h0.F(w2Var, "serviceDescriptor");
        this.f17268b = Collections.unmodifiableMap(new HashMap(map));
    }
}
