package r1;

import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f9250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f9251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q1.a f9252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q1.a f9253d;
    public final q1.a e;
    public final q1.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9255h;

    public d(String str, f fVar, Path.FillType fillType, q1.a aVar, q1.a aVar2, q1.a aVar3, q1.a aVar4, boolean z2) {
        this.f9250a = fVar;
        this.f9251b = fillType;
        this.f9252c = aVar;
        this.f9253d = aVar2;
        this.e = aVar3;
        this.f = aVar4;
        this.f9254g = str;
        this.f9255h = z2;
    }

    @Override // r1.b
    public final l1.d a(j1.x xVar, j1.j jVar, s1.c cVar) {
        return new l1.i(xVar, jVar, cVar, this);
    }
}
