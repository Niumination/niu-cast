package r1;

/* JADX INFO: loaded from: classes.dex */
public final class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9283a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q1.b f9285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9286d;
    public final q1.e e;
    public final Object f;

    public o(String str, q1.b bVar, q1.b bVar2, q1.d dVar, boolean z2) {
        this.f9284b = str;
        this.f9285c = bVar;
        this.e = bVar2;
        this.f = dVar;
        this.f9286d = z2;
    }

    @Override // r1.b
    public final l1.d a(j1.x xVar, j1.j jVar, s1.c cVar) {
        switch (this.f9283a) {
            case 0:
                return new l1.r(xVar, cVar, this);
            case 1:
                return new l1.s(xVar, cVar, this);
            default:
                return new l1.w(cVar, this);
        }
    }

    public String toString() {
        switch (this.f9283a) {
            case 0:
                return "RectangleShape{position=" + this.e + ", size=" + ((q1.a) this.f) + '}';
            case 1:
            default:
                return super.toString();
            case 2:
                return "Trim Path: {start: " + this.f9285c + ", end: " + ((q1.b) this.e) + ", offset: " + ((q1.b) this.f) + "}";
        }
    }

    public o(String str, q1.e eVar, q1.a aVar, q1.b bVar, boolean z2) {
        this.f9284b = str;
        this.e = eVar;
        this.f = aVar;
        this.f9285c = bVar;
        this.f9286d = z2;
    }

    public o(String str, y yVar, q1.b bVar, q1.b bVar2, q1.b bVar3, boolean z2) {
        this.f9284b = yVar;
        this.f9285c = bVar;
        this.e = bVar2;
        this.f = bVar3;
        this.f9286d = z2;
    }
}
