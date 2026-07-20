package tl;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15832a = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final bm.h<o0> f15833b = new d0(0, 0, null, 7, null);

    @os.l
    public static final bm.h<o0> a() {
        return f15833b;
    }

    public static /* synthetic */ void b() {
    }

    @f0
    public static final <R> R c(int i10, @os.l jn.l<? super e, ? extends R> lVar) {
        kn.l0.p(lVar, "block");
        return lVar.invoke(new e(ql.e.f14042a.c(i10)));
    }

    @f0
    public static final <R> R d(@os.l bm.h<e> hVar, @os.l jn.l<? super e, ? extends R> lVar) {
        kn.l0.p(hVar, "pool");
        kn.l0.p(lVar, "block");
        e eVarW0 = hVar.W0();
        try {
            return lVar.invoke(eVarW0);
        } finally {
            hVar.recycle(eVarW0);
        }
    }

    public static final <R> R e(@os.l bm.h<ul.b> hVar, @os.l jn.l<? super ul.b, ? extends R> lVar) {
        kn.l0.p(hVar, "pool");
        kn.l0.p(lVar, "block");
        ul.b bVarW0 = hVar.W0();
        try {
            return lVar.invoke(bVarW0);
        } finally {
            bVarW0.j2(hVar);
        }
    }
}
