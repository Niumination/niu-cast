package ei;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class p extends ConcurrentHashMap<Class, n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f4321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f4322b;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4323a;

        public a() {
        }

        public void a(boolean z10) {
            this.f4323a = z10;
        }

        public boolean b() {
            return this.f4323a;
        }
    }

    public p() {
    }

    public n a(Object obj) {
        p pVar;
        a aVar = new a();
        Class<?> cls = obj == null ? Void.TYPE : obj.getClass();
        n nVarC = c(cls, cls, aVar);
        if (nVarC == null && (pVar = this.f4321a) != null && (nVarC = pVar.a(obj)) != null) {
            a(obj == null ? Void.TYPE : obj.getClass(), nVarC);
        }
        if (!aVar.f4323a) {
            a(cls, nVarC);
        }
        return nVarC;
    }

    public final n c(Class cls, Class cls2, a aVar) {
        if (cls == null) {
            return null;
        }
        if (containsKey(cls)) {
            if (cls != cls2) {
                aVar.a(false);
            }
            return get(cls);
        }
        if (cls.isArray()) {
            aVar.a(false);
            return get(Arrays.class);
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            n nVarC = c(cls3, cls2, aVar);
            if (nVarC != null) {
                return nVarC;
            }
        }
        return c(cls.getSuperclass(), cls2, aVar);
    }

    public p(p pVar) {
        this.f4321a = pVar;
    }

    public n a(Class cls, n nVar) {
        if (!this.f4322b) {
            put(cls, nVar);
        }
        return nVar;
    }
}
