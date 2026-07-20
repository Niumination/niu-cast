package qg;

import java.io.File;
import java.io.FileNotFoundException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9125a;

    static {
        j3.z zVar = yi.a.f11225b;
        Intrinsics.checkNotNullParameter(".", "path");
        File file = new File(".");
        yi.b path = new yi.b(file);
        zVar.getClass();
        Intrinsics.checkNotNullParameter(path, "path");
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        File file2 = file.getCanonicalFile();
        Intrinsics.checkNotNullExpressionValue(file2, "getCanonicalFile(...)");
        Intrinsics.checkNotNullParameter(file2, "file");
        String string = file2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        f9125a = string;
    }
}
