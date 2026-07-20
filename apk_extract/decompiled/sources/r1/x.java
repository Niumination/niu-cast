package r1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class x implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q1.b f9305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q1.a f9307d;
    public final q1.a e;
    public final q1.b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f9308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f9309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f9310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f9311j;

    public x(String str, q1.b bVar, ArrayList arrayList, q1.a aVar, q1.a aVar2, q1.b bVar2, v vVar, w wVar, float f, boolean z2) {
        this.f9304a = str;
        this.f9305b = bVar;
        this.f9306c = arrayList;
        this.f9307d = aVar;
        this.e = aVar2;
        this.f = bVar2;
        this.f9308g = vVar;
        this.f9309h = wVar;
        this.f9310i = f;
        this.f9311j = z2;
    }

    @Override // r1.b
    public final l1.d a(j1.x xVar, j1.j jVar, s1.c cVar) {
        return new l1.v(xVar, cVar, this);
    }
}
