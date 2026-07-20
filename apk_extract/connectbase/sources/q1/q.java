package q1;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class q implements i2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v1.a<i2.a> f13657h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v1.a<i2.a> f13658i = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v1.a<i2.a> f13659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v1.a<i2.a> f13660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v1.a<i2.a> f13661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v1.a<i2.a> f13662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final v1.a<i2.a> f13663n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v1.a<i2.a> f13664o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y1 f13665a = new y1(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.a f13666b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.a f13667c = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y1.a f13668d = new g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y1.a f13669e = new j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v1<i2.a> f13670f = new v1<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile k f13671g = new k(i2.b.NEW);

    public class a implements v1.a<i2.a> {
        @Override // q1.v1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(i2.a listener) {
            listener.c();
        }

        public String toString() {
            return "starting()";
        }
    }

    public class b implements v1.a<i2.a> {
        @Override // q1.v1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(i2.a listener) {
            listener.b();
        }

        public String toString() {
            return "running()";
        }
    }

    public class c implements v1.a<i2.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i2.b f13672a;

        public c(final i2.b val$from) {
            this.f13672a = val$from;
        }

        @Override // q1.v1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(i2.a listener) {
            listener.e(this.f13672a);
        }

        public String toString() {
            return "terminated({from = " + this.f13672a + "})";
        }
    }

    public class d implements v1.a<i2.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i2.b f13673a;

        public d(final i2.b val$from) {
            this.f13673a = val$from;
        }

        @Override // q1.v1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(i2.a listener) {
            listener.d(this.f13673a);
        }

        public String toString() {
            return "stopping({from = " + this.f13673a + "})";
        }
    }

    public class e implements v1.a<i2.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i2.b f13674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f13675b;

        public e(final q this$0, final i2.b val$from, final Throwable val$cause) {
            this.f13674a = val$from;
            this.f13675b = val$cause;
        }

        @Override // q1.v1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(i2.a listener) {
            listener.a(this.f13674a, this.f13675b);
        }

        public String toString() {
            return "failed({from = " + this.f13674a + ", cause = " + this.f13675b + "})";
        }
    }

    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13676a;

        static {
            int[] iArr = new int[i2.b.values().length];
            f13676a = iArr;
            try {
                iArr[i2.b.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13676a[i2.b.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13676a[i2.b.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13676a[i2.b.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13676a[i2.b.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13676a[i2.b.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final class g extends y1.a {
        public g() {
            super(q.this.f13665a);
        }

        @Override // q1.y1.a
        public boolean a() {
            return q.this.f13671g.a().compareTo(i2.b.RUNNING) >= 0;
        }
    }

    public final class h extends y1.a {
        public h() {
            super(q.this.f13665a);
        }

        @Override // q1.y1.a
        public boolean a() {
            return q.this.f13671g.a() == i2.b.NEW;
        }
    }

    public final class i extends y1.a {
        public i() {
            super(q.this.f13665a);
        }

        @Override // q1.y1.a
        public boolean a() {
            return q.this.f13671g.a().compareTo(i2.b.RUNNING) <= 0;
        }
    }

    public final class j extends y1.a {
        public j() {
            super(q.this.f13665a);
        }

        @Override // q1.y1.a
        public boolean a() {
            return q.this.f13671g.a().compareTo(i2.b.TERMINATED) >= 0;
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i2.b f13681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public final Throwable f13683c;

        public k(i2.b internalState) {
            this(internalState, false, null);
        }

        public i2.b a() {
            return (this.f13682b && this.f13681a == i2.b.STARTING) ? i2.b.STOPPING : this.f13681a;
        }

        public Throwable b() {
            i2.b bVar = this.f13681a;
            c1.h0.x0(bVar == i2.b.FAILED, "failureCause() is only valid if the service has failed, service is %s", bVar);
            Throwable th2 = this.f13683c;
            Objects.requireNonNull(th2);
            return th2;
        }

        public k(i2.b internalState, boolean shutdownWhenStartupFinishes, @gm.a Throwable failure) {
            c1.h0.u(!shutdownWhenStartupFinishes || internalState == i2.b.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", internalState);
            c1.h0.y((failure != null) == (internalState == i2.b.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", internalState, failure);
            this.f13681a = internalState;
            this.f13682b = shutdownWhenStartupFinishes;
            this.f13683c = failure;
        }
    }

    static {
        i2.b bVar = i2.b.STARTING;
        f13659j = new d(bVar);
        i2.b bVar2 = i2.b.RUNNING;
        f13660k = new d(bVar2);
        f13661l = new c(i2.b.NEW);
        f13662m = new c(bVar);
        f13663n = new c(bVar2);
        f13664o = new c(i2.b.STOPPING);
    }

    public static v1.a<i2.a> w(final i2.b from) {
        return new d(from);
    }

    public static v1.a<i2.a> x(final i2.b from) {
        return new c(from);
    }

    @Override // q1.i2
    public final void a(long timeout, TimeUnit unit) throws TimeoutException {
        if (this.f13665a.r(this.f13668d, timeout, unit)) {
            try {
                j(i2.b.RUNNING);
            } finally {
                this.f13665a.D();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
        }
    }

    @Override // q1.i2
    public final void b(long timeout, TimeUnit unit) throws TimeoutException {
        if (this.f13665a.r(this.f13669e, timeout, unit)) {
            try {
                j(i2.b.TERMINATED);
            } finally {
                this.f13665a.D();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + this.f13671g.a());
        }
    }

    @Override // q1.i2
    public final void c() {
        this.f13665a.q(this.f13669e);
        try {
            j(i2.b.TERMINATED);
        } finally {
            this.f13665a.D();
        }
    }

    @Override // q1.i2
    @t1.a
    public final i2 d() {
        if (!this.f13665a.i(this.f13666b)) {
            throw new IllegalStateException("Service " + this + " has already been started");
        }
        try {
            this.f13671g = new k(i2.b.STARTING);
            q();
            m();
        } catch (Throwable th2) {
            try {
                e2.b(th2);
                t(th2);
            } finally {
                this.f13665a.D();
                k();
            }
        }
        return this;
    }

    @Override // q1.i2
    public final void e(i2.a listener, Executor executor) {
        this.f13670f.b(listener, executor);
    }

    @Override // q1.i2
    public final void f() {
        this.f13665a.q(this.f13668d);
        try {
            j(i2.b.RUNNING);
        } finally {
            this.f13665a.D();
        }
    }

    @Override // q1.i2
    public final Throwable g() {
        return this.f13671g.b();
    }

    @Override // q1.i2
    @t1.a
    public final i2 h() {
        if (this.f13665a.i(this.f13667c)) {
            try {
                i2.b bVarA = this.f13671g.a();
                switch (f.f13676a[bVarA.ordinal()]) {
                    case 1:
                        this.f13671g = new k(i2.b.TERMINATED);
                        s(i2.b.NEW);
                        break;
                    case 2:
                        i2.b bVar = i2.b.STARTING;
                        this.f13671g = new k(bVar, true, null);
                        r(bVar);
                        l();
                        break;
                    case 3:
                        this.f13671g = new k(i2.b.STOPPING);
                        r(i2.b.RUNNING);
                        n();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        throw new AssertionError("isStoppable is incorrectly implemented, saw: " + bVarA);
                }
            } catch (Throwable th2) {
                try {
                    e2.b(th2);
                    t(th2);
                } finally {
                    this.f13665a.D();
                    k();
                }
            }
        }
        return this;
    }

    @Override // q1.i2
    public final boolean isRunning() {
        return this.f13671g.a() == i2.b.RUNNING;
    }

    @u1.a("monitor")
    public final void j(i2.b expected) {
        i2.b bVarA = this.f13671g.a();
        if (bVarA != expected) {
            if (bVarA == i2.b.FAILED) {
                throw new IllegalStateException("Expected the service " + this + " to be " + expected + ", but the service has FAILED", this.f13671g.b());
            }
            throw new IllegalStateException("Expected the service " + this + " to be " + expected + ", but was " + bVarA);
        }
    }

    public final void k() {
        if (this.f13665a.f13768b.isHeldByCurrentThread()) {
            return;
        }
        this.f13670f.c();
    }

    @t1.g
    public void l() {
    }

    @t1.g
    public abstract void m();

    @t1.g
    public abstract void n();

    public final void o(final i2.b from, final Throwable cause) {
        v1<i2.a> v1Var = this.f13670f;
        e eVar = new e(this, from, cause);
        v1Var.f(eVar, eVar);
    }

    public final void p() {
        v1<i2.a> v1Var = this.f13670f;
        v1.a<i2.a> aVar = f13658i;
        v1Var.f(aVar, aVar);
    }

    public final void q() {
        v1<i2.a> v1Var = this.f13670f;
        v1.a<i2.a> aVar = f13657h;
        v1Var.f(aVar, aVar);
    }

    public final void r(final i2.b from) {
        if (from == i2.b.STARTING) {
            v1<i2.a> v1Var = this.f13670f;
            v1.a<i2.a> aVar = f13659j;
            v1Var.f(aVar, aVar);
        } else {
            if (from != i2.b.RUNNING) {
                throw new AssertionError();
            }
            v1<i2.a> v1Var2 = this.f13670f;
            v1.a<i2.a> aVar2 = f13660k;
            v1Var2.f(aVar2, aVar2);
        }
    }

    public final void s(final i2.b from) {
        switch (f.f13676a[from.ordinal()]) {
            case 1:
                v1<i2.a> v1Var = this.f13670f;
                v1.a<i2.a> aVar = f13661l;
                v1Var.f(aVar, aVar);
                return;
            case 2:
                v1<i2.a> v1Var2 = this.f13670f;
                v1.a<i2.a> aVar2 = f13662m;
                v1Var2.f(aVar2, aVar2);
                return;
            case 3:
                v1<i2.a> v1Var3 = this.f13670f;
                v1.a<i2.a> aVar3 = f13663n;
                v1Var3.f(aVar3, aVar3);
                return;
            case 4:
                v1<i2.a> v1Var4 = this.f13670f;
                v1.a<i2.a> aVar4 = f13664o;
                v1Var4.f(aVar4, aVar4);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    @Override // q1.i2
    public final i2.b state() {
        return this.f13671g.a();
    }

    public final void t(Throwable cause) {
        cause.getClass();
        this.f13665a.g();
        try {
            i2.b bVarA = this.f13671g.a();
            int i10 = f.f13676a[bVarA.ordinal()];
            if (i10 != 1) {
                if (i10 == 2 || i10 == 3 || i10 == 4) {
                    this.f13671g = new k(i2.b.FAILED, false, cause);
                    o(bVarA, cause);
                } else if (i10 != 5) {
                }
                this.f13665a.D();
                k();
                return;
            }
            throw new IllegalStateException("Failed while in state:" + bVarA, cause);
        } catch (Throwable th2) {
            this.f13665a.D();
            k();
            throw th2;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + this.f13671g.a() + "]";
    }

    public final void u() {
        this.f13665a.g();
        try {
            if (this.f13671g.f13681a != i2.b.STARTING) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.f13671g.f13681a);
                t(illegalStateException);
                throw illegalStateException;
            }
            if (this.f13671g.f13682b) {
                this.f13671g = new k(i2.b.STOPPING);
                n();
            } else {
                this.f13671g = new k(i2.b.RUNNING);
                p();
            }
            this.f13665a.D();
            k();
        } catch (Throwable th2) {
            this.f13665a.D();
            k();
            throw th2;
        }
    }

    public final void v() {
        this.f13665a.g();
        try {
            i2.b bVarA = this.f13671g.a();
            switch (f.f13676a[bVarA.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    throw new IllegalStateException("Cannot notifyStopped() when the service is " + bVarA);
                case 2:
                case 3:
                case 4:
                    this.f13671g = new k(i2.b.TERMINATED);
                    s(bVarA);
                    break;
            }
            this.f13665a.D();
            k();
        } catch (Throwable th2) {
            this.f13665a.D();
            k();
            throw th2;
        }
    }
}
