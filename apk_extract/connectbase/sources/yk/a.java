package yk;

import java.util.concurrent.TimeUnit;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: yk.a$a, reason: collision with other inner class name */
    public static class C0542a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21357c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21358d;

        public C0542a() {
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            this.f21355a = iAvailableProcessors;
            this.f21356b = (iAvailableProcessors / 2) + 1;
            this.f21357c = (iAvailableProcessors / 2) + 1;
            this.f21358d = iAvailableProcessors;
        }

        public final int a() {
            return this.f21358d;
        }

        public final int b() {
            return this.f21356b;
        }

        public final int c() {
            return this.f21355a;
        }

        public final int d() {
            return this.f21357c;
        }

        public final void e(int i10) {
            this.f21358d = i10;
        }

        public final void f(int i10) {
            this.f21356b = i10;
        }

        public final void g(int i10) {
            this.f21357c = i10;
        }
    }

    public static final class b {
        @os.l
        public static dk.a a(@os.l a aVar) {
            l0.p(aVar, "this");
            return aVar.c().a();
        }

        public static /* synthetic */ a b(a aVar, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return aVar.b(z10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void c(a aVar, long j10, long j11, TimeUnit timeUnit) {
            l0.p(aVar, "this");
            l0.p(timeUnit, "timeUnit");
            g.a(aVar, j10, j11, timeUnit);
        }
    }

    @os.l
    dk.a a();

    @os.l
    a b(boolean z10);

    @os.l
    yk.b c();

    void d(long j10, long j11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void e(long j10, long j11, TimeUnit timeUnit);
}
