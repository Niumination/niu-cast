package q1;

import com.google.j2objc.annotations.ReflectionSupport;
import f1.k6;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class v<OutputT> extends f.j<OutputT> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b f13725v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Logger f13726w = Logger.getLogger(v.class.getName());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @gm.a
    public volatile Set<Throwable> f13727n = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile int f13728p;

    public static abstract class b {
        public b() {
        }

        public abstract void a(v<?> state, @gm.a Set<Throwable> expect, Set<Throwable> update);

        public abstract int b(v<?> state);

        public b(a aVar) {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<v<?>, Set<Throwable>> f13729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<v<?>> f13730b;

        public c(AtomicReferenceFieldUpdater seenExceptionsUpdater, AtomicIntegerFieldUpdater remainingCountUpdater) {
            this.f13729a = seenExceptionsUpdater;
            this.f13730b = remainingCountUpdater;
        }

        @Override // q1.v.b
        public void a(v<?> state, @gm.a Set<Throwable> expect, Set<Throwable> update) {
            j.d.a(this.f13729a, state, expect, update);
        }

        @Override // q1.v.b
        public int b(v<?> state) {
            return this.f13730b.decrementAndGet(state);
        }
    }

    public static final class d extends b {
        public d() {
        }

        @Override // q1.v.b
        public void a(v<?> state, @gm.a Set<Throwable> expect, Set<Throwable> update) {
            synchronized (state) {
                if (state.f13727n == expect) {
                    state.f13727n = update;
                }
            }
        }

        @Override // q1.v.b
        public int b(v<?> state) {
            int iH;
            synchronized (state) {
                iH = v.H(state);
            }
            return iH;
        }

        public d(a aVar) {
        }
    }

    static {
        b dVar;
        try {
            dVar = new c(AtomicReferenceFieldUpdater.newUpdater(v.class, Set.class, p6.n.f13005a), AtomicIntegerFieldUpdater.newUpdater(v.class, "p"));
            e = null;
        } catch (Error | RuntimeException e10) {
            e = e10;
            dVar = new d();
        }
        f13725v = dVar;
        if (e != null) {
            f13726w.log(Level.SEVERE, "SafeAtomicHelper is broken!", e);
        }
    }

    public v(int remainingFutures) {
        this.f13728p = remainingFutures;
    }

    public static /* synthetic */ int H(v vVar) {
        int i10 = vVar.f13728p - 1;
        vVar.f13728p = i10;
        return i10;
    }

    public abstract void I(Set<Throwable> seen);

    public final void J() {
        this.f13727n = null;
    }

    public final int K() {
        return f13725v.b(this);
    }

    public final Set<Throwable> L() {
        Set<Throwable> set = this.f13727n;
        if (set != null) {
            return set;
        }
        Set<Throwable> setP = k6.p();
        I(setP);
        f13725v.a(this, null, setP);
        Set<Throwable> set2 = this.f13727n;
        Objects.requireNonNull(set2);
        return set2;
    }
}
