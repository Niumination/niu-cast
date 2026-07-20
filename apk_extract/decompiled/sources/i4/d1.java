package i4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import k3.d9;

/* JADX INFO: loaded from: classes.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f5575a = o.create();

    public Collection a() {
        return new ArrayList();
    }

    public d1 b(Object obj, Object obj2) {
        d9.a(obj, obj2);
        o oVar = this.f5575a;
        Collection collectionA = (Collection) oVar.get(obj);
        if (collectionA == null) {
            collectionA = a();
            oVar.put(obj, collectionA);
        }
        collectionA.add(obj2);
        return this;
    }

    public void c(Map.Entry entry) {
        b(entry.getKey(), entry.getValue());
    }
}
