package wj;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f19105f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3 f19106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1 f19107b = m1.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1 f19108c = m1.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l1 f19109d = m1.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f19110e;

    public class a implements b {
        @Override // wj.o.b
        public o a() {
            return new o(n3.f19104a);
        }
    }

    public interface b {
        o a();
    }

    public o(n3 n3Var) {
        this.f19106a = n3Var;
    }

    public static b a() {
        return f19105f;
    }

    public void b(boolean z10) {
        if (z10) {
            this.f19108c.add(1L);
        } else {
            this.f19109d.add(1L);
        }
    }

    public void c() {
        this.f19107b.add(1L);
        this.f19110e = this.f19106a.a();
    }

    public void d(vj.v0.b.a aVar) {
        aVar.f17301d = this.f19107b.value();
        aVar.f17302e = this.f19108c.value();
        aVar.f17303f = this.f19109d.value();
        aVar.f17304g = this.f19110e;
    }

    public void e(vj.v0.j.a aVar) {
        aVar.f17339a = this.f19107b.value();
        aVar.f17340b = this.f19108c.value();
        aVar.f17341c = this.f19109d.value();
        aVar.f17342d = this.f19110e;
    }
}
