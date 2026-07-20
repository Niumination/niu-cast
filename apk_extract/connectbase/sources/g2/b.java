package g2;

import android.media.MediaExtractor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final a f6380c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final String f6381d = "AnimPlayer.FileContainer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final File f6382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public RandomAccessFile f6383b;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public b(@l File file) throws FileNotFoundException {
        l0.p(file, "file");
        this.f6382a = file;
        l2.a.f9640a.e("AnimPlayer.FileContainer", "FileContainer init");
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            throw new FileNotFoundException(l0.C("Unable to read ", file));
        }
    }

    @Override // g2.c
    public void a() {
        this.f6383b = new RandomAccessFile(this.f6382a, "r");
    }

    @Override // g2.c
    public void b() throws IOException {
        RandomAccessFile randomAccessFile = this.f6383b;
        if (randomAccessFile == null) {
            return;
        }
        randomAccessFile.close();
    }

    @Override // g2.c
    public void c(@l MediaExtractor mediaExtractor) throws IOException {
        l0.p(mediaExtractor, "extractor");
        mediaExtractor.setDataSource(this.f6382a.toString());
    }

    @Override // g2.c
    public void close() {
        l2.a.f9640a.e("AnimPlayer.FileContainer", "FileContainer close");
    }

    @Override // g2.c
    public int read(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "b");
        RandomAccessFile randomAccessFile = this.f6383b;
        if (randomAccessFile == null) {
            return -1;
        }
        return randomAccessFile.read(bArr, i10, i11);
    }

    @Override // g2.c
    public void skip(long j10) throws IOException {
        RandomAccessFile randomAccessFile = this.f6383b;
        if (randomAccessFile == null) {
            return;
        }
        randomAccessFile.skipBytes((int) j10);
    }
}
