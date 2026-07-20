package fn;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<Exception> f6126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public Path f6127d;

    public e() {
        this(0, 1, null);
    }

    public final void a(@os.l Exception exc) {
        l0.p(exc, "exception");
        this.f6125b++;
        if (this.f6126c.size() < this.f6124a) {
            if (this.f6127d != null) {
                Throwable thInitCause = new FileSystemException(String.valueOf(this.f6127d)).initCause(exc);
                l0.n(thInitCause, "null cannot be cast to non-null type java.nio.file.FileSystemException");
                exc = (FileSystemException) thInitCause;
            }
            this.f6126c.add(exc);
        }
    }

    public final void b(@os.l Path path) {
        l0.p(path, "name");
        Path path2 = this.f6127d;
        this.f6127d = path2 != null ? path2.resolve(path) : null;
    }

    public final void c(@os.l Path path) {
        l0.p(path, "name");
        Path path2 = this.f6127d;
        if (!l0.g(path, path2 != null ? path2.getFileName() : null)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Path path3 = this.f6127d;
        this.f6127d = path3 != null ? path3.getParent() : null;
    }

    @os.l
    public final List<Exception> d() {
        return this.f6126c;
    }

    @os.m
    public final Path e() {
        return this.f6127d;
    }

    public final int f() {
        return this.f6125b;
    }

    public final void g(@os.m Path path) {
        this.f6127d = path;
    }

    public e(int i10) {
        this.f6124a = i10;
        this.f6126c = new ArrayList();
    }

    public /* synthetic */ e(int i10, int i11, w wVar) {
        this((i11 & 1) != 0 ? 64 : i10);
    }
}
