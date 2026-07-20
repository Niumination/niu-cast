package t1;

import android.content.Context;
import j1.c0;
import j1.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f10163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f10164b;

    public f(d dVar, b bVar) {
        this.f10163a = dVar;
        this.f10164b = bVar;
    }

    public final c0 a(Context context, String str, InputStream inputStream, String str2, String str3) {
        c0 c0VarF;
        c cVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        boolean zContains = str2.contains("application/zip");
        d dVar = this.f10163a;
        if (zContains || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            w1.b.a();
            c cVar2 = c.ZIP;
            c0VarF = str3 != null ? o.f(context, new ZipInputStream(new FileInputStream(dVar.d(str, inputStream, cVar2))), str) : o.f(context, new ZipInputStream(inputStream), null);
            cVar = cVar2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            w1.b.a();
            cVar = c.GZIP;
            c0VarF = str3 != null ? o.c(new GZIPInputStream(new FileInputStream(dVar.d(str, inputStream, cVar))), str) : o.c(new GZIPInputStream(inputStream), null);
        } else {
            w1.b.a();
            cVar = c.JSON;
            c0VarF = str3 != null ? o.c(new FileInputStream(dVar.d(str, inputStream, cVar).getAbsolutePath()), str) : o.c(inputStream, null);
        }
        if (str3 != null && c0VarF.f5943a != null) {
            File file = new File(dVar.c(), d.a(str, cVar, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            file2.toString();
            w1.b.a();
            if (!zRenameTo) {
                w1.b.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
            }
        }
        return c0VarF;
    }
}
