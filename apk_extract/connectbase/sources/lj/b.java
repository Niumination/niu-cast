package lj;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10020e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10021f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f10023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f10024c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10025d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10028c;
    }

    public b(int i10, g gVar) {
        this.f10022a = i10;
        this.f10023b = gVar;
    }

    public abstract void a(e eVar, int i10, int i11);

    public abstract void b(e eVar, int i10, int i11, int i12, int i13, int i14);

    public abstract void c(e eVar, int i10, int i11);

    public abstract void d(e eVar, int i10, int i11, int i12, int i13, int i14);

    public abstract a e(int i10, int i11);

    public abstract int f(int i10, float f10, MotionEvent motionEvent, boolean z10);

    public int g() {
        return this.f10022a;
    }

    public int h() {
        return this.f10023b.i().size();
    }

    public g i() {
        return this.f10023b;
    }

    public int j() {
        return this.f10023b.k();
    }

    public int k() {
        return this.f10025d;
    }

    public abstract boolean l(int i10, float f10);

    public boolean m(int i10) {
        return i10 == 0 && g() * (-i().k()) != 0;
    }

    public abstract boolean n(int i10);

    public abstract boolean o(int i10);

    public void p(int i10) {
        this.f10025d = i10;
    }
}
