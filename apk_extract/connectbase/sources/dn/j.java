package dn;

import java.io.File;
import java.io.IOException;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public class j extends IOException {

    @os.l
    private final File file;

    @os.m
    private final File other;

    @os.m
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@os.l File file, @os.m File file2, @os.m String str) {
        super(f.b(file, file2, str));
        l0.p(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }

    @os.l
    public final File getFile() {
        return this.file;
    }

    @os.m
    public final File getOther() {
        return this.other;
    }

    @os.m
    public final String getReason() {
        return this.reason;
    }

    public /* synthetic */ j(File file, File file2, String str, int i10, kn.w wVar) {
        this(file, (i10 & 2) != 0 ? null : file2, (i10 & 4) != 0 ? null : str);
    }
}
