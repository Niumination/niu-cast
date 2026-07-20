package j1;

import c1.q0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@l
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0<b0> f8363a;

    public class a implements q0<b0> {
        @Override // c1.q0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b0 get() {
            return new d0();
        }
    }

    public class b implements q0<b0> {
        @Override // c1.q0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b0 get() {
            return new c(null);
        }
    }

    public static final class c extends AtomicLong implements b0 {
        public c() {
        }

        @Override // j1.b0
        public void add(long x10) {
            getAndAdd(x10);
        }

        @Override // j1.b0
        public void increment() {
            getAndIncrement();
        }

        @Override // j1.b0
        public long sum() {
            return get();
        }

        public c(a aVar) {
        }
    }

    static {
        q0<b0> bVar;
        try {
            new d0();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f8363a = bVar;
    }

    public static b0 a() {
        return f8363a.get();
    }
}
