package qa;

import qd.j;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13882c = "d";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13883d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13884e = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f13885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z7.d f13886b;

    public boolean a() {
        return b(fc.b.a.f5989i).c();
    }

    public kg.c b(String str) {
        if (fc.b.b(str)) {
            j jVar = this.f13885a;
            if (jVar != null) {
                return jVar;
            }
            j jVar2 = new j();
            this.f13885a = jVar2;
            return jVar2;
        }
        z7.d dVar = this.f13886b;
        if (dVar != null) {
            return dVar;
        }
        z7.d dVar2 = new z7.d();
        this.f13886b = dVar2;
        return dVar2;
    }

    public int c(int i10) {
        return b(fc.b.a.C).a(i10);
    }

    @yb.a(level = 2)
    public void d(boolean z10) {
        b(fc.b.a.f5983c).b(z10);
    }

    public void e(int i10, int i11) {
        b(fc.b.a.C).d(i10, i11);
    }
}
