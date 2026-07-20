package ck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import vj.e0;
import vj.o0;
import vj.q2;
import vj.t2;
import vj.w1;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public final class k extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, t2> f1535a = new ConcurrentHashMap();

    @Override // vj.o0
    @e0("https://github.com/grpc/grpc-java/issues/2222")
    public List<t2> a() {
        return Collections.unmodifiableList(new ArrayList(this.f1535a.values()));
    }

    @Override // vj.o0
    @gm.j
    public q2<?, ?> c(String str, @gm.j String str2) {
        t2 t2Var;
        String strC = w1.c(str);
        if (strC == null || (t2Var = this.f1535a.get(strC)) == null) {
            return null;
        }
        return t2Var.c(str);
    }

    @gm.j
    public t2 d(vj.c cVar) {
        return e(cVar.bindService());
    }

    @gm.j
    public t2 e(t2 t2Var) {
        return this.f1535a.put(t2Var.f17267a.f17499a, t2Var);
    }

    public boolean f(t2 t2Var) {
        return this.f1535a.remove(t2Var.f17267a.f17499a, t2Var);
    }
}
