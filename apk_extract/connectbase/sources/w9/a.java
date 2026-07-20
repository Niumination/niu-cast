package w9;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f18212e = "a";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f18213f = "Executor cannot be empty";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f18214g = "callback cannot be empty.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f7.a f18215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xc.b f18216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f18217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public final f7.b.InterfaceC0139b f18218d = new C0469a();

    /* JADX INFO: renamed from: w9.a$a, reason: collision with other inner class name */
    public class C0469a implements f7.b.InterfaceC0139b {
        public C0469a() {
        }

        @Override // f7.b.InterfaceC0139b
        public void a(int i10) {
            if (a.this.f18217c != null) {
                a.this.f18217c.a(i10);
            }
        }

        @Override // f7.b.InterfaceC0139b
        public void b(int i10) {
            if (a.this.f18217c != null) {
                a.this.f18217c.b(i10);
            }
        }

        @Override // f7.b.InterfaceC0139b
        public void c(int[] iArr) {
            if (a.this.f18217c != null) {
                a.this.f18217c.c(iArr);
            }
        }
    }

    @Deprecated
    public interface b {
        void a(int i10);

        void b(int i10);

        void c(int[] iArr);
    }

    public int b() {
        return d(fc.b.a.f5994n).c();
    }

    public qf.a c() {
        f7.a aVar = this.f18215a;
        if (aVar != null) {
            return aVar;
        }
        f7.a aVar2 = new f7.a();
        this.f18215a = aVar2;
        return aVar2;
    }

    public qf.a d(String str) {
        if (fc.b.b(str)) {
            xc.b bVar = this.f18216b;
            if (bVar != null) {
                return bVar;
            }
            xc.b bVar2 = new xc.b();
            this.f18216b = bVar2;
            return bVar2;
        }
        f7.a aVar = this.f18215a;
        if (aVar != null) {
            return aVar;
        }
        f7.a aVar2 = new f7.a();
        this.f18215a = aVar2;
        return aVar2;
    }

    @Deprecated
    public void e(Executor executor, b bVar) {
        if (executor == null) {
            throw new IllegalArgumentException(f18213f);
        }
        if (bVar == null) {
            throw new IllegalArgumentException(f18214g);
        }
        this.f18217c = bVar;
        c().b(executor, this.f18218d);
    }

    @Deprecated
    public void f(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException(f18214g);
        }
        c().a(this.f18218d);
    }
}
