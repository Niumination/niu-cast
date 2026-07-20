package e8;

/* JADX INFO: loaded from: classes2.dex */
public class u implements pg.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f4144a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v.a f4145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v.b f4146c;

    public static void h(va.u.b bVar, va.r rVar) {
        va.r rVar2 = new va.r();
        rVar2.f16834a = rVar.c();
        bVar.a(rVar2);
    }

    @Override // pg.o
    public void a(String str) {
        v vVar = this.f4144a;
        if (vVar != null) {
            vVar.c(str);
        }
    }

    @Override // pg.o
    public void b(final va.u.b bVar) {
        if (this.f4144a != null) {
            v.b bVar2 = new v.b() { // from class: e8.s
                @Override // e8.v.b
                public final void a(va.r rVar) {
                    u.h(bVar, rVar);
                }
            };
            this.f4146c = bVar2;
            this.f4144a.b(bVar2);
        }
    }

    @Override // pg.o
    public void c(final va.u.a aVar) {
        if (this.f4144a != null) {
            v.a aVar2 = new v.a() { // from class: e8.t
                @Override // e8.v.a
                public final void a() {
                    aVar.a();
                }
            };
            this.f4145b = aVar2;
            this.f4144a.a(aVar2);
        }
    }

    @Override // pg.o
    public void d() {
        v vVar = this.f4144a;
        if (vVar != null) {
            vVar.d();
        }
    }
}
