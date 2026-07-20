package r1;

import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public final class r implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f9292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q1.a f9294d;
    public final q1.a e;
    public final boolean f;

    public r(String str, boolean z2, Path.FillType fillType, q1.a aVar, q1.a aVar2, boolean z3) {
        this.f9293c = str;
        this.f9291a = z2;
        this.f9292b = fillType;
        this.f9294d = aVar;
        this.e = aVar2;
        this.f = z3;
    }

    @Override // r1.b
    public final l1.d a(j1.x xVar, j1.j jVar, s1.c cVar) {
        return new l1.h(xVar, cVar, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f9291a + '}';
    }
}
