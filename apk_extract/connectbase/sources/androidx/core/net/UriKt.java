package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kn.l0;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nUri.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uri.kt\nandroidx/core/net/UriKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
public final class UriKt {
    @l
    public static final File toFile(@l Uri uri) {
        l0.p(uri, "<this>");
        if (!l0.g(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }

    @l
    public static final Uri toUri(@l String str) {
        l0.p(str, "<this>");
        Uri uri = Uri.parse(str);
        l0.o(uri, "parse(this)");
        return uri;
    }

    @l
    public static final Uri toUri(@l File file) {
        l0.p(file, "<this>");
        Uri uriFromFile = Uri.fromFile(file);
        l0.o(uriFromFile, "fromFile(this)");
        return uriFromFile;
    }
}
