package fn;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
@f
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public jn.p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f6128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public jn.p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f6129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public jn.p<? super Path, ? super IOException, ? extends FileVisitResult> f6130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public jn.p<? super Path, ? super IOException, ? extends FileVisitResult> f6131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6132e;

    @Override // fn.g
    public void a(@os.l jn.p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar) {
        l0.p(pVar, "function");
        f();
        g(this.f6128a, "onPreVisitDirectory");
        this.f6128a = pVar;
    }

    @Override // fn.g
    public void b(@os.l jn.p<? super Path, ? super IOException, ? extends FileVisitResult> pVar) {
        l0.p(pVar, "function");
        f();
        g(this.f6131d, "onPostVisitDirectory");
        this.f6131d = pVar;
    }

    @Override // fn.g
    public void c(@os.l jn.p<? super Path, ? super IOException, ? extends FileVisitResult> pVar) {
        l0.p(pVar, "function");
        f();
        g(this.f6130c, "onVisitFileFailed");
        this.f6130c = pVar;
    }

    @Override // fn.g
    public void d(@os.l jn.p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar) {
        l0.p(pVar, "function");
        f();
        g(this.f6129b, "onVisitFile");
        this.f6129b = pVar;
    }

    @os.l
    public final FileVisitor<Path> e() {
        f();
        this.f6132e = true;
        return new i(this.f6128a, this.f6129b, this.f6130c, this.f6131d);
    }

    public final void f() {
        if (this.f6132e) {
            throw new IllegalStateException("This builder was already built");
        }
    }

    public final void g(Object obj, String str) {
        if (obj != null) {
            throw new IllegalStateException(j.a.a(str, " was already defined"));
        }
    }
}
