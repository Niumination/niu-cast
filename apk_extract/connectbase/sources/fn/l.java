package fn;

import java.nio.file.Path;
import java.util.Iterator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Path f6144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final Object f6145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final l f6146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public Iterator<l> f6147d;

    public l(@os.l Path path, @os.m Object obj, @os.m l lVar) {
        l0.p(path, "path");
        this.f6144a = path;
        this.f6145b = obj;
        this.f6146c = lVar;
    }

    @os.m
    public final Iterator<l> a() {
        return this.f6147d;
    }

    @os.m
    public final Object b() {
        return this.f6145b;
    }

    @os.m
    public final l c() {
        return this.f6146c;
    }

    @os.l
    public final Path d() {
        return this.f6144a;
    }

    public final void e(@os.m Iterator<l> it) {
        this.f6147d = it;
    }
}
