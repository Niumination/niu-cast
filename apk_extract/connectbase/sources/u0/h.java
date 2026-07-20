package u0;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f16109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16110c;

    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a forId(int i10) {
            if (i10 == 1) {
                return MERGE;
            }
            if (i10 == 2) {
                return ADD;
            }
            if (i10 == 3) {
                return SUBTRACT;
            }
            if (i10 != 4) {
                return i10 != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
        }
    }

    public h(String str, a aVar, boolean z10) {
        this.f16108a = str;
        this.f16109b = aVar;
        this.f16110c = z10;
    }

    @Override // u0.b
    @Nullable
    public p0.c a(n0.j jVar, v0.a aVar) {
        if (jVar.r()) {
            return new p0.l(this);
        }
        z0.d.e("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a b() {
        return this.f16109b;
    }

    public String c() {
        return this.f16108a;
    }

    public boolean d() {
        return this.f16110c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f16109b + rs.f.f14860b;
    }
}
