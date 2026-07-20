package qb;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    public static abstract class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile T f13899a;

        public final void a() {
            this.f13899a = null;
        }

        public abstract T b();

        public final T c() {
            if (this.f13899a == null) {
                synchronized (this) {
                    try {
                        if (this.f13899a == null) {
                            this.f13899a = b();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return this.f13899a;
        }
    }
}
