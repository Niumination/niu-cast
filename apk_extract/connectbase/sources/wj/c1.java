package wj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends vj.o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<vj.t2> f18407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, vj.q2<?, ?>> f18408b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, vj.t2> f18409a = new LinkedHashMap();

        public b a(vj.t2 t2Var) {
            this.f18409a.put(t2Var.f17267a.f17499a, t2Var);
            return this;
        }

        public c1 b() {
            HashMap map = new HashMap();
            Iterator<vj.t2> it = this.f18409a.values().iterator();
            while (it.hasNext()) {
                for (vj.q2<?, ?> q2Var : it.next().f17268b.values()) {
                    map.put(q2Var.f17252a.f17481b, q2Var);
                }
            }
            return new c1(Collections.unmodifiableList(new ArrayList(this.f18409a.values())), Collections.unmodifiableMap(map));
        }
    }

    public c1(List<vj.t2> list, Map<String, vj.q2<?, ?>> map) {
        this.f18407a = list;
        this.f18408b = map;
    }

    @Override // vj.o0
    public List<vj.t2> a() {
        return this.f18407a;
    }

    @Override // vj.o0
    @gm.j
    public vj.q2<?, ?> c(String str, @gm.j String str2) {
        return this.f18408b.get(str);
    }
}
