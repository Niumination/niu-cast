package nk;

import java.io.File;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public enum g {
    BROTLI("br", null, 2, null),
    GZIP("gz", "gzip");


    @os.l
    private final String encoding;

    @os.l
    private final String extension;

    g(String str, String str2) {
        this.extension = str;
        this.encoding = str2;
    }

    @os.l
    public final File file(@os.l File file) {
        l0.p(file, "plain");
        return new File(((Object) file.getAbsolutePath()) + n1.e.f11183c + this.extension);
    }

    @os.l
    public final String getEncoding() {
        return this.encoding;
    }

    @os.l
    public final String getExtension() {
        return this.extension;
    }

    /* synthetic */ g(String str, String str2, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? str : str2);
    }
}
