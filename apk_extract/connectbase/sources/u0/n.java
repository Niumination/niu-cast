package u0;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f16143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16144c;

    public n(String str, List<b> list, boolean z10) {
        this.f16142a = str;
        this.f16143b = list;
        this.f16144c = z10;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.d(jVar, aVar, this);
    }

    public List<b> b() {
        return this.f16143b;
    }

    public String c() {
        return this.f16142a;
    }

    public boolean d() {
        return this.f16144c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f16142a + "' Shapes: " + Arrays.toString(this.f16143b.toArray()) + rs.f.f14860b;
    }
}
