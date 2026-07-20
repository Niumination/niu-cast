package vq;

/* JADX INFO: loaded from: classes3.dex */
@is.a
public final class d extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final d f17830a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f17831b = new a();

    public static final class a extends ClassValue<jn.l<? super Throwable, ? extends Throwable>> {
        @Override // java.lang.ClassValue
        @os.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public jn.l<Throwable, Throwable> computeValue(@os.m Class<?> cls) {
            kn.l0.n(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
            return p.b(cls);
        }
    }

    @Override // vq.k
    @os.l
    public jn.l<Throwable, Throwable> a(@os.l Class<? extends Throwable> cls) {
        return (jn.l) f17831b.get(cls);
    }
}
