package f2;

/* JADX INFO: loaded from: classes.dex */
public final class a implements yh.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f4979c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f4980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f4981b;

    public static yh.a a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f4981b = f4979c;
        aVar.f4980a = bVar;
        return aVar;
    }

    @Override // yh.a
    public final Object get() {
        Object obj = this.f4981b;
        Object obj2 = f4979c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f4981b;
                    if (obj == obj2) {
                        obj = this.f4980a.get();
                        Object obj3 = this.f4981b;
                        if (obj3 != obj2 && obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f4981b = obj;
                        this.f4980a = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return obj;
    }
}
