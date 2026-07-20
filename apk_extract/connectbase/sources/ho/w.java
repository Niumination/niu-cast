package ho;

import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<x> f7452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Set<x> f7453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<x> f7454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Set<x> f7455d;

    public w(@os.l List<x> list, @os.l Set<x> set, @os.l List<x> list2, @os.l Set<x> set2) {
        kn.l0.p(list, "allDependencies");
        kn.l0.p(set, "modulesWhoseInternalsAreVisible");
        kn.l0.p(list2, "directExpectedByDependencies");
        kn.l0.p(set2, "allExpectedByDependencies");
        this.f7452a = list;
        this.f7453b = set;
        this.f7454c = list2;
        this.f7455d = set2;
    }

    @Override // ho.v
    @os.l
    public List<x> a() {
        return this.f7452a;
    }

    @Override // ho.v
    @os.l
    public List<x> b() {
        return this.f7454c;
    }

    @Override // ho.v
    @os.l
    public Set<x> c() {
        return this.f7453b;
    }
}
