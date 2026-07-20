package q0;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<u0.l, Path>> f13365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a<Integer, Integer>> f13366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<u0.g> f13367c;

    public g(List<u0.g> list) {
        this.f13367c = list;
        this.f13365a = new ArrayList(list.size());
        this.f13366b = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f13365a.add(list.get(i10).b().l());
            this.f13366b.add(list.get(i10).c().l());
        }
    }

    public List<a<u0.l, Path>> a() {
        return this.f13365a;
    }

    public List<u0.g> b() {
        return this.f13367c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f13366b;
    }
}
