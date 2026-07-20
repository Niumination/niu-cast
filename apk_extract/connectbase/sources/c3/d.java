package c3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends x2.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final File f1274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public InputStream f1275c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@os.l File file) {
        super(null, 1, null);
        l0.p(file, "file");
        this.f1274b = file;
    }

    @Override // x2.a
    @os.l
    public InputStream I() {
        InputStream inputStream = this.f1275c;
        if (inputStream != null) {
            s2.b.c(inputStream);
        }
        FileInputStream fileInputStream = new FileInputStream(this.f1274b);
        this.f1275c = fileInputStream;
        return fileInputStream;
    }

    @Override // x2.a
    public long N1() {
        return this.f1274b.length();
    }

    @Override // x2.c
    @os.l
    public String c() {
        String name = this.f1274b.getName();
        l0.o(name, "getName(...)");
        return name;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f1275c;
        if (inputStream != null) {
            inputStream.close();
        }
    }
}
