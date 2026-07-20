package e4;

import com.transsion.backup.model.AlbumFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends x2.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final AlbumFile f4047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public InputStream f4048c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@l AlbumFile albumFile) {
        super(Long.valueOf(albumFile.getId()));
        l0.p(albumFile, "albumFile");
        this.f4047b = albumFile;
    }

    @Override // x2.a
    @l
    public InputStream I() {
        InputStream inputStream = this.f4048c;
        if (inputStream != null) {
            s2.b.c(inputStream);
        }
        FileInputStream fileInputStream = new FileInputStream(new File(this.f4047b.getPath()));
        this.f4048c = fileInputStream;
        return fileInputStream;
    }

    @Override // x2.a
    public long N1() {
        return this.f4047b.getSize();
    }

    @Override // x2.c
    @l
    public String c() {
        return this.f4047b.getName();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f4048c;
        if (inputStream != null) {
            inputStream.close();
        }
    }
}
