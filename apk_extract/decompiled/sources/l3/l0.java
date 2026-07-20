package l3;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l0 f7261b = new l0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7262a;

    public /* synthetic */ l0(int i8) {
        this.f7262a = i8;
    }

    @Override // l3.p1
    public final a2 a(Class cls) {
        switch (this.f7262a) {
            case 0:
                if (!q0.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (a2) q0.e(cls.asSubclass(q0.class)).n(3, null);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // l3.p1
    public final boolean b(Class cls) {
        switch (this.f7262a) {
            case 0:
                return q0.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
