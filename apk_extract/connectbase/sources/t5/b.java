package t5;

import k4.m;
import p4.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T extends p4.b<?>> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f15478h = "sender-base";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f15479i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f15480j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f15481k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f15482l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f15483m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f15484n = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f15485a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v4.d f15487c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0402b f15490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p4.c f15491g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15486b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15488d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15489e = false;

    public class a implements p4.c {
        public a() {
        }

        @Override // p4.c
        public void a(byte[] bArr) {
            b.this.d(bArr);
        }

        @Override // p4.c
        public void b(int i10) {
        }
    }

    /* JADX INFO: renamed from: t5.b$b, reason: collision with other inner class name */
    public static class C0402b {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    public b(T t10, v4.d dVar) {
        a aVar = new a();
        this.f15491g = aVar;
        this.f15485a = t10;
        this.f15487c = dVar;
        t10.f(aVar);
    }

    public int a() {
        return this.f15486b;
    }

    public void b() {
        this.f15488d = 4;
    }

    public void c() {
        if (this.f15488d == 4) {
            this.f15488d = 3;
        }
    }

    public abstract void d(byte[] bArr);

    public void e(C0402b c0402b) {
        this.f15490f = c0402b;
    }

    public void f() {
        if (!this.f15489e) {
            m.e(f15478h, "link not ready");
            this.f15488d = 2;
            return;
        }
        int i10 = this.f15488d;
        if (i10 == 3) {
            m.e(f15478h, "start: sender already work");
            return;
        }
        if (i10 == 5) {
            m.e(f15478h, "start: sender stopped");
        } else if (i10 == 4 || i10 == 1) {
            m.e(f15478h, "start success");
            this.f15485a.start();
            this.f15488d = 3;
        }
    }

    public void g() {
        this.f15485a.stop();
        this.f15488d = 5;
    }
}
