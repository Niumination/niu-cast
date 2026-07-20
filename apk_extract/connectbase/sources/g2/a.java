package g2;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaExtractor;
import java.io.IOException;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final C0152a f6376c = new C0152a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final String f6377d = "AnimPlayer.FileContainer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final AssetFileDescriptor f6378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final AssetManager.AssetInputStream f6379b;

    /* JADX INFO: renamed from: g2.a$a, reason: collision with other inner class name */
    public static final class C0152a {
        public C0152a() {
        }

        public C0152a(w wVar) {
        }
    }

    public a(@l AssetManager assetManager, @l String str) throws IOException {
        l0.p(assetManager, "assetManager");
        l0.p(str, "assetsPath");
        AssetFileDescriptor assetFileDescriptorOpenFd = assetManager.openFd(str);
        l0.o(assetFileDescriptorOpenFd, "assetManager.openFd(assetsPath)");
        this.f6378a = assetFileDescriptorOpenFd;
        this.f6379b = (AssetManager.AssetInputStream) assetManager.open(str, 2);
        l2.a.f9640a.e("AnimPlayer.FileContainer", "AssetsFileContainer init");
    }

    @Override // g2.c
    public void a() {
        l2.a.f9640a.e("AnimPlayer.FileContainer", "AssetsFileContainer startRandomRead");
    }

    @Override // g2.c
    public void b() throws IOException {
        this.f6379b.close();
    }

    @Override // g2.c
    public void c(@l MediaExtractor mediaExtractor) throws IOException {
        l0.p(mediaExtractor, "extractor");
        if (this.f6378a.getDeclaredLength() < 0) {
            mediaExtractor.setDataSource(this.f6378a.getFileDescriptor());
        } else {
            mediaExtractor.setDataSource(this.f6378a.getFileDescriptor(), this.f6378a.getStartOffset(), this.f6378a.getDeclaredLength());
        }
    }

    @Override // g2.c
    public void close() throws IOException {
        this.f6378a.close();
        this.f6379b.close();
    }

    @Override // g2.c
    public int read(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "b");
        return this.f6379b.read(bArr, i10, i11);
    }

    @Override // g2.c
    public void skip(long j10) throws IOException {
        this.f6379b.skip(j10);
    }
}
