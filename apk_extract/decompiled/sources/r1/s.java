package r1;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f9296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9297c;

    public s(String str, boolean z2, List list) {
        this.f9295a = str;
        this.f9296b = list;
        this.f9297c = z2;
    }

    @Override // r1.b
    public final l1.d a(j1.x xVar, j1.j jVar, s1.c cVar) {
        return new l1.e(xVar, cVar, this, jVar);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.f9295a + "' Shapes: " + Arrays.toString(this.f9296b.toArray()) + '}';
    }
}
