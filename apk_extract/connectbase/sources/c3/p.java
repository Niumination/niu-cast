package c3;

import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends l implements x2.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final x2.f f1325d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@os.l x2.f fVar) {
        super(fVar);
        l0.p(fVar, "listener");
        this.f1325d = fVar;
    }

    @Override // x2.f
    public void c(long j10, @os.l List<r2.j> list, @os.m String str) {
        l0.p(list, "files");
        this.f1325d.c(j10, list, str);
    }
}
