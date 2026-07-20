package vo;

import java.util.List;
import kn.l0;
import kn.w;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final q f17626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<q> f17627b;

    public j() {
        this(null, null, 3, null);
    }

    @os.l
    public final List<q> a() {
        return this.f17627b;
    }

    @os.m
    public final q b() {
        return this.f17626a;
    }

    public j(@os.m q qVar, @os.l List<q> list) {
        l0.p(list, "parametersInfo");
        this.f17626a = qVar;
        this.f17627b = list;
    }

    public j(q qVar, List list, int i10, w wVar) {
        this((i10 & 1) != 0 ? null : qVar, (i10 & 2) != 0 ? k0.INSTANCE : list);
    }
}
