package dn;

import java.io.File;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends j {
    public /* synthetic */ t(File file, File file2, String str, int i10, kn.w wVar) {
        this(file, (i10 & 2) != 0 ? null : file2, (i10 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@os.l File file, @os.m File file2, @os.m String str) {
        super(file, file2, str);
        l0.p(file, "file");
    }
}
