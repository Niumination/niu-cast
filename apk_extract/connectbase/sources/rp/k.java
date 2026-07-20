package rp;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface k {

    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f14747a = new a();

        @Override // rp.k
        public boolean a() {
            return b.b(this);
        }

        @Override // rp.k
        public boolean b() {
            return b.e(this);
        }

        @Override // rp.k
        public boolean c() {
            return b.f(this);
        }

        @Override // rp.k
        public boolean d() {
            return b.a(this);
        }

        @Override // rp.k
        public boolean e() {
            return b.d(this);
        }

        @Override // rp.k
        public boolean f() {
            return b.c(this);
        }
    }

    public static final class b {
        public static boolean a(@os.l k kVar) {
            l0.p(kVar, "this");
            return false;
        }

        public static boolean b(@os.l k kVar) {
            l0.p(kVar, "this");
            return false;
        }

        public static boolean c(@os.l k kVar) {
            l0.p(kVar, "this");
            return false;
        }

        public static boolean d(@os.l k kVar) {
            l0.p(kVar, "this");
            return false;
        }

        public static boolean e(@os.l k kVar) {
            l0.p(kVar, "this");
            return false;
        }

        public static boolean f(@os.l k kVar) {
            l0.p(kVar, "this");
            return true;
        }
    }

    boolean a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    boolean f();
}
