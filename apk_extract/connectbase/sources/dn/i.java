package dn;

import java.io.File;
import java.util.List;
import kn.l0;
import nm.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final File f3758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<File> f3759b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@os.l File file, @os.l List<? extends File> list) {
        l0.p(file, "root");
        l0.p(list, "segments");
        this.f3758a = file;
        this.f3759b = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ i d(i iVar, File file, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            file = iVar.f3758a;
        }
        if ((i10 & 2) != 0) {
            list = iVar.f3759b;
        }
        return iVar.c(file, list);
    }

    @os.l
    public final File a() {
        return this.f3758a;
    }

    @os.l
    public final List<File> b() {
        return this.f3759b;
    }

    @os.l
    public final i c(@os.l File file, @os.l List<? extends File> list) {
        l0.p(file, "root");
        l0.p(list, "segments");
        return new i(file, list);
    }

    @os.l
    public final File e() {
        return this.f3758a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return l0.g(this.f3758a, iVar.f3758a) && l0.g(this.f3759b, iVar.f3759b);
    }

    @os.l
    public final String f() {
        String path = this.f3758a.getPath();
        l0.o(path, "getPath(...)");
        return path;
    }

    @os.l
    public final List<File> g() {
        return this.f3759b;
    }

    public final int h() {
        return this.f3759b.size();
    }

    public int hashCode() {
        return this.f3759b.hashCode() + (this.f3758a.hashCode() * 31);
    }

    public final boolean i() {
        String path = this.f3758a.getPath();
        l0.o(path, "getPath(...)");
        return path.length() > 0;
    }

    @os.l
    public final File j(int i10, int i11) {
        if (i10 < 0 || i10 > i11 || i11 > this.f3759b.size()) {
            throw new IllegalArgumentException();
        }
        List<File> listSubList = this.f3759b.subList(i10, i11);
        String str = File.separator;
        l0.o(str, "separator");
        return new File(h0.m3(listSubList, str, null, null, 0, null, null, 62, null));
    }

    @os.l
    public String toString() {
        return "FilePathComponents(root=" + this.f3758a + ", segments=" + this.f3759b + ')';
    }
}
