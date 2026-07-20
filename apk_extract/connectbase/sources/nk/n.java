package nk;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.FileTime;
import java.util.List;
import kn.l0;
import nm.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends s.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final File f11537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ik.i f11538c;

    public n(@os.l File file, @os.l ik.i iVar) throws IOException {
        l0.p(file, "file");
        l0.p(iVar, "contentType");
        this.f11537b = file;
        this.f11538c = iVar;
        List<a0> listC = c0.c(this);
        FileTime lastModifiedTime = Files.getLastModifiedTime(file.toPath(), new LinkOption[0]);
        l0.o(lastModifiedTime, "getLastModifiedTime(file.toPath())");
        c0.d(this, h0.F4(listC, l.a(lastModifiedTime)));
    }

    @Override // nk.s
    @os.l
    public Long b() {
        return Long.valueOf(this.f11537b.length());
    }

    @Override // nk.s
    @os.l
    public ik.i c() {
        return this.f11538c;
    }

    @Override // nk.s.d
    @os.l
    public pl.k j() {
        return gl.g.b(this.f11537b, 0L, 0L, null, 7, null);
    }

    @Override // nk.s.d
    @os.l
    public pl.k k(@os.l tn.o oVar) {
        l0.p(oVar, "range");
        return gl.g.b(this.f11537b, oVar.f15921a, oVar.f15922b, null, 4, null);
    }

    @os.l
    public final File l() {
        return this.f11537b;
    }

    public /* synthetic */ n(File file, ik.i iVar, int i10, kn.w wVar) {
        this(file, (i10 & 2) != 0 ? ik.u.a(ik.i.f7981f, file) : iVar);
    }
}
