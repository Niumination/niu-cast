package va;

import vd.k0;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16837c = "u";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16838d = "Parameters cannot be null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k0 f16839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.u f16840b;

    public interface a {
        void a();
    }

    public interface b {
        void a(r rVar);
    }

    public static /* synthetic */ void f(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    public void c(final a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException(f16838d);
        }
        e(fc.b.a.f5989i).c(new a() { // from class: va.t
            @Override // va.u.a
            public final void a() {
                u.f(aVar);
            }
        });
    }

    public void d(final b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException(f16838d);
        }
        e(fc.b.a.f5998r).b(new b() { // from class: va.s
            @Override // va.u.b
            public final void a(r rVar) {
                bVar.a(rVar);
            }
        });
    }

    public pg.o e(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16837c, k0.f16951b);
            k0 k0Var = this.f16839a;
            if (k0Var != null) {
                return k0Var;
            }
            k0 k0Var2 = new k0();
            this.f16839a = k0Var2;
            return k0Var2;
        }
        dc.e.f(f16837c, "TranAospUEventObserver");
        e8.u uVar = this.f16840b;
        if (uVar != null) {
            return uVar;
        }
        e8.u uVar2 = new e8.u();
        this.f16840b = uVar2;
        return uVar2;
    }

    public void h(String str) {
        if (str == null) {
            throw new IllegalArgumentException(f16838d);
        }
        e(fc.b.a.f5989i).a(str);
    }

    public void i() {
        e(fc.b.a.f5989i).d();
    }
}
