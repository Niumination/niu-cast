package g2;

import android.media.MediaExtractor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@b.b(23)
public final class d implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final a f6384c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final String f6385d = "StreamContainer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final byte[] f6386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public ByteArrayInputStream f6387b;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public d(@l byte[] bArr) {
        l0.p(bArr, "bytes");
        this.f6386a = bArr;
        this.f6387b = new ByteArrayInputStream(bArr);
    }

    @Override // g2.c
    public void a() {
        l2.a.f9640a.e(f6385d, "StreamContainer startRandomRead");
    }

    @Override // g2.c
    public void b() {
        l2.a.f9640a.e(f6385d, "StreamContainer closeRandomRead");
    }

    @Override // g2.c
    public void c(@l MediaExtractor mediaExtractor) throws IOException {
        l0.p(mediaExtractor, "extractor");
        mediaExtractor.setDataSource(new e(this.f6386a));
    }

    @Override // g2.c
    public void close() throws IOException {
        this.f6387b.close();
    }

    @Override // g2.c
    public int read(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "b");
        return this.f6387b.read(bArr, i10, i11);
    }

    @Override // g2.c
    public void skip(long j10) {
        this.f6387b.skip(j10);
    }
}
