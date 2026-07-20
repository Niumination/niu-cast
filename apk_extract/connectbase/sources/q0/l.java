package q0;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l extends a<u0.l, Path> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u0.l f13376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f13377j;

    public l(List<a1.a<u0.l>> list) {
        super(list);
        this.f13376i = new u0.l();
        this.f13377j = new Path();
    }

    @Override // q0.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Path i(a1.a<u0.l> aVar, float f10) {
        this.f13376i.c(aVar.f6b, aVar.f7c, f10);
        z0.g.i(this.f13376i, this.f13377j);
        return this.f13377j;
    }
}
