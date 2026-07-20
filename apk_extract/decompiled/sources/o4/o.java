package o4;

/* JADX INFO: loaded from: classes.dex */
public final class o implements u4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8392c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f8393a = f8392c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile u4.a f8394b;

    public o(u4.a aVar) {
        this.f8394b = aVar;
    }

    @Override // u4.a
    public final Object get() {
        Object obj = this.f8393a;
        Object obj2 = f8392c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f8393a;
                    if (obj == obj2) {
                        obj = this.f8394b.get();
                        this.f8393a = obj;
                        this.f8394b = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return obj;
    }
}
