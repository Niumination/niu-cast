package nb;

import dc.e;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11438c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ne.b f11439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y8.b f11440b;

    public File a(String str) {
        return j(fc.b.a.C).i(str);
    }

    public File b(String str, String str2) {
        return j(fc.b.a.C).d(str, str2);
    }

    public File c(String str) {
        return j(fc.b.a.C).a(str);
    }

    public File d(String str, String str2) {
        return j(fc.b.a.C).g(str, str2);
    }

    public List<File> e(String str) {
        return j(fc.b.a.C).f(str);
    }

    public List<File> f(String str, String str2) {
        return j(fc.b.a.C).j(str, str2);
    }

    public File g(String str) {
        return j(fc.b.a.C).e(str);
    }

    public File h(String str) {
        return j(fc.b.a.C).h(str);
    }

    public File i(String str, boolean z10) {
        return j(fc.b.a.C).c(str, z10);
    }

    public hh.b j(String str) {
        if (fc.b.b(str)) {
            ne.b bVar = this.f11439a;
            if (bVar != null) {
                return bVar;
            }
            ne.b bVar2 = new ne.b();
            this.f11439a = bVar2;
            return bVar2;
        }
        e.f(f11438c, "TranConfigsManager");
        y8.b bVar3 = this.f11440b;
        if (bVar3 != null) {
            return bVar3;
        }
        y8.b bVar4 = new y8.b();
        this.f11440b = bVar4;
        return bVar4;
    }

    public void k(String str) {
        j(fc.b.a.C).b(str);
    }
}
