package g2;

import android.media.MediaExtractor;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    void a();

    void b();

    void c(@l MediaExtractor mediaExtractor);

    void close();

    int read(@l byte[] bArr, int i10, int i11);

    void skip(long j10);
}
