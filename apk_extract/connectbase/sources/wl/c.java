package wl;

import kn.w;
import pl.s;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f19691b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final c f19692c = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final Throwable f19693a;

    public static final class a {
        public a() {
        }

        @os.l
        public final c a() {
            return c.f19692c;
        }

        public a(w wVar) {
        }
    }

    public c(@os.m Throwable th2) {
        this.f19693a = th2;
    }

    @os.m
    public final Throwable b() {
        return this.f19693a;
    }

    @os.l
    public final Throwable c() {
        Throwable th2 = this.f19693a;
        return th2 == null ? new s("The channel was closed") : th2;
    }

    @os.l
    public String toString() {
        return "Closed[" + c() + ']';
    }
}
