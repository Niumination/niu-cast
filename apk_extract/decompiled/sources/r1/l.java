package r1;

import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class l implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f9272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9273b;

    public l(String str, k kVar, boolean z2) {
        this.f9272a = kVar;
        this.f9273b = z2;
    }

    @Override // r1.b
    public final l1.d a(j1.x xVar, j1.j jVar, s1.c cVar) {
        if (((HashSet) xVar.f6022o.f10264a).contains(j1.y.MergePathsApi19)) {
            return new l1.n(this);
        }
        w1.b.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public final String toString() {
        return "MergePaths{mode=" + this.f9272a + '}';
    }
}
