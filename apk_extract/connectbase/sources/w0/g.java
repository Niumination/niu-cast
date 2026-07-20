package w0;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final e f17901a;

    public g(@NonNull e eVar) {
        this.f17901a = eVar;
    }

    public static String c(String str, c cVar, boolean z10) {
        StringBuilder sb2 = new StringBuilder("lottie_cache_");
        sb2.append(str.replaceAll("\\W+", ""));
        sb2.append(z10 ? cVar.tempExtension() : cVar.extension);
        return sb2.toString();
    }

    public void a() {
        File fileE = e();
        if (fileE.exists()) {
            File[] fileArrListFiles = fileE.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileE.listFiles()) {
                    file.delete();
                }
            }
            fileE.delete();
        }
    }

    @Nullable
    @WorkerThread
    public Pair<c, InputStream> b(String str) {
        try {
            File fileD = d(str);
            if (fileD == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileD);
            c cVar = fileD.getAbsolutePath().endsWith(".zip") ? c.ZIP : c.JSON;
            StringBuilder sbA = e.a.a("Cache hit for ", str, " at ");
            sbA.append(fileD.getAbsolutePath());
            z0.d.a(sbA.toString());
            return new Pair<>(cVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public final File d(String str) throws FileNotFoundException {
        File file = new File(e(), c(str, c.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), c(str, c.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public final File e() {
        File fileA = this.f17901a.a();
        if (fileA.isFile()) {
            fileA.delete();
        }
        if (!fileA.exists()) {
            fileA.mkdirs();
        }
        return fileA;
    }

    public void f(String str, c cVar) {
        File file = new File(e(), c(str, cVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        z0.d.a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        z0.d.e("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    public File g(String str, InputStream inputStream, c cVar) throws IOException {
        File file = new File(e(), c(str, cVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = inputStream.read(bArr);
                    if (i10 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i10);
                }
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            inputStream.close();
            throw th3;
        }
    }
}
