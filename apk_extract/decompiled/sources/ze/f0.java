package ze;

import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.ArrayList] */
    public static List e(Class cls, List list, ClassLoader classLoader, p2 p2Var) {
        ?? Load;
        boolean zC;
        try {
            Class.forName("android.app.Application", false, classLoader);
            Load = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Class cls2 = (Class) it.next();
                Object objNewInstance = null;
                try {
                    objNewInstance = cls2.asSubclass(cls).getConstructor(null).newInstance(null);
                } catch (ClassCastException unused) {
                } catch (Throwable th2) {
                    throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th2), th2);
                }
                if (objNewInstance != null) {
                    Load.add(objNewInstance);
                }
            }
        } catch (Exception unused2) {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(cls, classLoader);
            Load = !serviceLoaderLoad.iterator().hasNext() ? ServiceLoader.load(cls) : serviceLoaderLoad;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : Load) {
            switch (p2Var.f11402a) {
                case 3:
                    zC = ((c1) obj).c();
                    break;
                case 4:
                    zC = ((h1) obj).b();
                    break;
                case 5:
                default:
                    zC = ((i2) obj).a();
                    break;
                case 6:
                    zC = ((u1) obj).b();
                    break;
            }
            if (zC) {
                arrayList.add(obj);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new n2(p2Var)));
        return Collections.unmodifiableList(arrayList);
    }

    public abstract i a(qf.c cVar);

    public abstract i b();

    public abstract ScheduledExecutorService c();

    public abstract v2 d();

    public abstract void f(q2 q2Var, p1 p1Var);

    public abstract void g(q2 q2Var);

    public void h(p1 p1Var) {
    }

    public abstract void i(MessageLite messageLite);

    public void j() {
    }

    public abstract void k(t1 t1Var);

    public abstract void l();

    public abstract void m(q qVar, z0 z0Var);
}
