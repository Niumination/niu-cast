package e1;

import c1.q0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@i
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0<p> f4033a;

    public class a implements q0<p> {
        @Override // c1.q0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p get() {
            return new r();
        }
    }

    public class b implements q0<p> {
        @Override // c1.q0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p get() {
            return new c(null);
        }
    }

    public static final class c extends AtomicLong implements p {
        public c() {
        }

        @Override // e1.p
        public void add(long x10) {
            getAndAdd(x10);
        }

        @Override // e1.p
        public void increment() {
            getAndIncrement();
        }

        @Override // e1.p
        public long sum() {
            return get();
        }

        public c(a aVar) {
        }
    }

    static {
        q0<p> bVar;
        try {
            new r();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f4033a = bVar;
    }

    public static p a() {
        return f4033a.get();
    }
}
