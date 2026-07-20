package q1;

import f1.x7;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public abstract class u<InputT, OutputT> extends v<OutputT> {
    public static final Logger H = Logger.getLogger(u.class.getName());

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @gm.a
    public f1.e3<? extends s1<? extends InputT>> f13721x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f13722y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f13723z;

    public enum a {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public u(f1.e3<? extends s1<? extends InputT>> futures, boolean allMustSucceed, boolean collectsValues) {
        super(futures.size());
        this.f13721x = futures;
        this.f13722y = allMustSucceed;
        this.f13723z = collectsValues;
    }

    public static boolean O(Set<Throwable> seen, Throwable param) {
        while (param != null) {
            if (!seen.add(param)) {
                return false;
            }
            param = param.getCause();
        }
        return true;
    }

    public static void X(Throwable throwable) {
        H.log(Level.SEVERE, throwable instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", throwable);
    }

    @Override // q1.v
    public final void I(Set<Throwable> seen) {
        seen.getClass();
        if (isCancelled()) {
            return;
        }
        Throwable thA = a();
        Objects.requireNonNull(thA);
        O(seen, thA);
    }

    public abstract void P(int index, @c2 InputT returnValue);

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(int index, Future<? extends InputT> future) {
        try {
            P(index, h1.j(future));
        } catch (Error | RuntimeException e10) {
            T(e10);
        } catch (ExecutionException e11) {
            T(e11.getCause());
        }
    }

    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public final void W(@gm.a f1.e3<? extends Future<? extends InputT>> futuresIfNeedToCollectAtCompletion) {
        int iB = v.f13725v.b(this);
        c1.h0.h0(iB >= 0, "Less than 0 remaining futures");
        if (iB == 0) {
            Y(futuresIfNeedToCollectAtCompletion);
        }
    }

    public abstract void S();

    public final void T(Throwable throwable) {
        throwable.getClass();
        if (this.f13722y && !C(throwable) && O(L(), throwable)) {
            X(throwable);
        } else if (throwable instanceof Error) {
            X(throwable);
        }
    }

    public final void U() {
        Objects.requireNonNull(this.f13721x);
        if (this.f13721x.isEmpty()) {
            S();
            return;
        }
        if (!this.f13722y) {
            final f1.e3<? extends s1<? extends InputT>> e3Var = this.f13723z ? this.f13721x : null;
            Runnable runnable = new Runnable() { // from class: q1.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13718a.W(e3Var);
                }
            };
            x7<? extends s1<? extends InputT>> it = this.f13721x.iterator();
            while (it.hasNext()) {
                it.next().addListener(runnable, n0.INSTANCE);
            }
            return;
        }
        x7<? extends s1<? extends InputT>> it2 = this.f13721x.iterator();
        final int i10 = 0;
        while (it2.hasNext()) {
            final s1<? extends InputT> next = it2.next();
            next.addListener(new Runnable() { // from class: q1.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13705a.V(next, i10);
                }
            }, n0.INSTANCE);
            i10++;
        }
    }

    public final /* synthetic */ void V(s1 s1Var, int i10) {
        try {
            if (s1Var.isCancelled()) {
                this.f13721x = null;
                cancel(false);
            } else {
                Q(i10, s1Var);
            }
        } finally {
            W(null);
        }
    }

    public final void Y(@gm.a f1.e3<? extends Future<? extends InputT>> futuresIfNeedToCollectAtCompletion) {
        if (futuresIfNeedToCollectAtCompletion != null) {
            x7<? extends Future<? extends InputT>> it = futuresIfNeedToCollectAtCompletion.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                Future<? extends InputT> next = it.next();
                if (!next.isCancelled()) {
                    Q(i10, next);
                }
                i10++;
            }
        }
        this.f13727n = null;
        S();
        Z(a.ALL_INPUT_FUTURES_PROCESSED);
    }

    @t1.r
    @t1.g
    public void Z(a reason) {
        reason.getClass();
        this.f13721x = null;
    }

    @Override // q1.f
    public final void m() {
        f1.e3<? extends s1<? extends InputT>> e3Var = this.f13721x;
        Z(a.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (e3Var != null)) {
            boolean zE = E();
            x7<? extends s1<? extends InputT>> it = e3Var.iterator();
            while (it.hasNext()) {
                it.next().cancel(zE);
            }
        }
    }

    @Override // q1.f
    @gm.a
    public final String y() {
        f1.e3<? extends s1<? extends InputT>> e3Var = this.f13721x;
        if (e3Var == null) {
            return super.y();
        }
        return "futures=" + e3Var;
    }
}
