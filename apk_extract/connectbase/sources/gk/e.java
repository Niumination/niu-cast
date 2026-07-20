package gk;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.s f6586a;

    public static class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final Throwable f6587b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@os.l un.s sVar, @os.l Throwable th2) {
            super(sVar);
            kn.l0.p(sVar, ik.y0.a.f8215h);
            kn.l0.p(th2, "cause");
            this.f6587b = th2;
        }

        @os.l
        public final Throwable b() {
            return this.f6587b;
        }
    }

    public static final class b<T> extends e<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final T f6588b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@os.l un.s sVar, @os.l T t10) {
            super(sVar);
            kn.l0.p(sVar, ik.y0.a.f8215h);
            kn.l0.p(t10, "value");
            this.f6588b = t10;
        }

        @os.l
        public final T b() {
            return this.f6588b;
        }
    }

    public /* synthetic */ e(un.s sVar, kn.w wVar) {
        this(sVar);
    }

    @os.l
    public final un.s a() {
        return this.f6586a;
    }

    public e(un.s sVar) {
        this.f6586a = sVar;
    }
}
