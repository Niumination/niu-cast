package gg;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f5207a;

    public y() {
        this.f5207a = new HashMap();
    }

    public abstract Object a(Object obj);

    public Object b(Object obj) {
        synchronized (this.f5207a) {
            try {
                if (this.f5207a.containsKey(obj)) {
                    return this.f5207a.get(obj);
                }
                Object objA = a(obj);
                this.f5207a.put(obj, objA);
                return objA;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public y(HashMap map) {
        this.f5207a = map;
    }
}
