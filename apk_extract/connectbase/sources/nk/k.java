package nk;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import jq.e0;
import kn.l0;
import kn.n0;
import lm.f0;
import lm.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends s.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final File f11528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final String f11529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final ik.i f11530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final String f11531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final lm.d0 f11532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final lm.d0 f11533g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final lm.d0 f11534i;

    public static final class a extends n0 implements jn.a<Boolean> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Boolean invoke() {
            JarEntry jarEntryO = k.this.o();
            return Boolean.valueOf(jarEntryO == null ? false : !jarEntryO.isDirectory());
        }
    }

    public static final class b extends n0 implements jn.a<JarFile> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final JarFile invoke() {
            return new JarFile(k.this.f11528b);
        }
    }

    public static final class c extends n0 implements jn.a<JarEntry> {
        public c() {
            super(0);
        }

        @Override // jn.a
        public final JarEntry invoke() {
            return k.this.n().getJarEntry(k.this.f11529c);
        }
    }

    public k(@os.l File file, @os.l String str, @os.l ik.i iVar) {
        l0.p(file, "jarFile");
        l0.p(str, "resourcePath");
        l0.p(iVar, "contentType");
        this.f11528b = file;
        this.f11529c = str;
        this.f11530d = iVar;
        String strH2 = e0.h2(Paths.get(str, new String[0]).normalize().toString(), File.separatorChar, el.b0.f4502a, false, 4, null);
        this.f11531e = strH2;
        h0 h0Var = h0.NONE;
        this.f11532f = f0.c(h0Var, new c());
        this.f11533g = f0.c(h0Var, new b());
        this.f11534i = f0.c(h0Var, new a());
        if (e0.s2(strH2, "..", false, 2, null)) {
            throw new IllegalArgumentException(l0.C("Bad resource relative path ", str).toString());
        }
        JarEntry jarEntryO = o();
        if (jarEntryO == null) {
            return;
        }
        List<a0> listC = c0.c(this);
        FileTime lastModifiedTime = jarEntryO.getLastModifiedTime();
        l0.o(lastModifiedTime, "it.lastModifiedTime");
        c0.d(this, nm.h0.F4(listC, l.a(lastModifiedTime)));
    }

    @Override // nk.s
    @os.m
    public Long b() {
        JarEntry jarEntryO = o();
        if (jarEntryO == null) {
            return null;
        }
        return Long.valueOf(jarEntryO.getSize());
    }

    @Override // nk.s
    @os.l
    public ik.i c() {
        return this.f11530d;
    }

    @Override // nk.s.d
    @os.l
    public pl.k j() throws IOException {
        InputStream inputStream = n().getInputStream(o());
        pl.k kVarD = inputStream != null ? yl.i.d(inputStream, null, gl.b.a(), 1, null) : null;
        if (kVarD != null) {
            return kVarD;
        }
        throw new IOException(j.c.a(new StringBuilder("Resource "), this.f11531e, " not found"));
    }

    public final JarFile n() {
        return (JarFile) this.f11533g.getValue();
    }

    public final JarEntry o() {
        return (JarEntry) this.f11532f.getValue();
    }

    @os.l
    public final File p() {
        return this.f11528b;
    }

    @os.l
    public final String r() {
        return this.f11529c;
    }

    public final boolean s() {
        return ((Boolean) this.f11534i.getValue()).booleanValue();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public k(@os.l Path path, @os.l String str, @os.l ik.i iVar) {
        l0.p(path, "zipFilePath");
        l0.p(str, "resourcePath");
        l0.p(iVar, "contentType");
        File file = path.toFile();
        l0.o(file, "zipFilePath.toFile()");
        this(file, str, iVar);
    }
}
