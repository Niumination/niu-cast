package t1;

import android.content.Context;
import com.transsion.core.utils.EncoderUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.b f10161a;

    public d(a4.b bVar) {
        this.f10161a = bVar;
    }

    public static String a(String str, c cVar, boolean z2) {
        String strTempExtension = z2 ? cVar.tempExtension() : cVar.extension;
        String strReplaceAll = str.replaceAll("\\W+", "");
        int length = 242 - strTempExtension.length();
        if (strReplaceAll.length() > length) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5).digest(strReplaceAll.getBytes());
                StringBuilder sb2 = new StringBuilder();
                for (byte b9 : bArrDigest) {
                    sb2.append(String.format("%02x", Byte.valueOf(b9)));
                }
                strReplaceAll = sb2.toString();
            } catch (NoSuchAlgorithmException unused) {
                strReplaceAll = strReplaceAll.substring(0, length);
            }
        }
        return h0.a.j("lottie_cache_", strReplaceAll, strTempExtension);
    }

    public final File b(String str) {
        File file = new File(c(), a(str, c.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(c(), a(str, c.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        File file3 = new File(c(), a(str, c.GZIP, false));
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    public final File c() {
        a4.b bVar = this.f10161a;
        bVar.getClass();
        File file = new File(((Context) bVar.f33b).getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File d(String str, InputStream inputStream, c cVar) throws IOException {
        File file = new File(c(), a(str, cVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i8 = inputStream.read(bArr);
                    if (i8 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i8);
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
