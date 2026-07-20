package vo;

import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f17611e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final d f17612f = new d(null, null, false, false, 8, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final g f17613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final e f17614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17616d;

    public static final class a {
        public a() {
        }

        @os.l
        public final d a() {
            return d.f17612f;
        }

        public a(w wVar) {
        }
    }

    public d(@os.m g gVar, @os.m e eVar, boolean z10, boolean z11) {
        this.f17613a = gVar;
        this.f17614b = eVar;
        this.f17615c = z10;
        this.f17616d = z11;
    }

    public final boolean b() {
        return this.f17615c;
    }

    @os.m
    public final e c() {
        return this.f17614b;
    }

    @os.m
    public final g d() {
        return this.f17613a;
    }

    public final boolean e() {
        return this.f17616d;
    }

    public /* synthetic */ d(g gVar, e eVar, boolean z10, boolean z11, int i10, w wVar) {
        this(gVar, eVar, z10, (i10 & 8) != 0 ? false : z11);
    }
}
