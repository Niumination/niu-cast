package c3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements x2.b {
    @Override // x2.b
    @os.m
    public OutputStream a(@os.l String str) {
        File parentFile;
        l0.p(str, "fileName");
        try {
            File file = new File(q2.a.f13797a.a(), str);
            File parentFile2 = file.getParentFile();
            if (parentFile2 != null && !parentFile2.exists() && (parentFile = file.getParentFile()) != null) {
                parentFile.mkdirs();
            }
            return new FileOutputStream(file);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
