package m5;

import android.app.usage.StorageStatsManager;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.documentfile.provider.DocumentFile;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.sdk.FileInfo;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10457a = "FileUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f10458b = 20971520;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f10459c = 1048576;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double f10460d = 0.05d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10461e = "image";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10462f = "video";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10463g = "audio";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10464h = "document";

    public static String a(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String b() {
        String string = SourceApplication.b().getSharedPreferences("fileConfig", 0).getString("savePath", c("receiveFile"));
        File file = new File(string);
        if (!file.exists()) {
            k4.m.b(f10457a, "isMkdirs=" + file.mkdirs());
        }
        return string;
    }

    public static String c(String str) {
        String str2;
        String strA = n.a.a("/", str, "/");
        if (Environment.getExternalStorageState().equals("mounted")) {
            str2 = Environment.getExternalStorageDirectory() + strA;
        } else {
            str2 = SourceApplication.b().getExternalCacheDir() + strA;
        }
        File file = new File(str2);
        if (!file.exists()) {
            k4.m.b(f10457a, "isMkdirs=" + file.mkdirs());
        }
        return str2;
    }

    public static long d(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return -1L;
    }

    public static double e(long j10) {
        double d10 = j10;
        double d11 = 0.05d * d10;
        if (d11 > 2.097152E7d) {
            d11 = 2.097152E7d;
        }
        if (d11 < 1048576.0d) {
            d11 = 1048576.0d;
        }
        k4.m.b(f10457a, "Sink buffer size:" + d11);
        return d11 + d10;
    }

    @Nullable
    public static String f(Context context, Uri uri) {
        if (!DocumentsContract.isDocumentUri(context, uri)) {
            if (t2.a.f15437d.equalsIgnoreCase(uri.getScheme())) {
                k4.m.b(f10457a, "file belong to MediaStore");
                return a(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                k4.m.b(f10457a, "file belong to File");
                return uri.getPath();
            }
        }
        if (i(uri)) {
            k4.m.b(f10457a, "file belong to ExternalStorageProvider");
            String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
            }
        }
        if (h(uri)) {
            k4.m.b(f10457a, "file belong to DownloadsProvider");
            return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri))), null, null);
        }
        if (!j(uri)) {
            return null;
        }
        k4.m.b(f10457a, "file belong to MediaProvider");
        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
        return a(context, g(strArrSplit2[0]), "_id=?", new String[]{strArrSplit2[1]});
    }

    public static Uri g(String str) {
        k4.m.b(f10457a, "type is " + str);
        str.getClass();
        switch (str) {
            case "audio":
                return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            case "image":
                return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            case "video":
                return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            case "document":
                return MediaStore.Files.getContentUri("external");
            default:
                return null;
        }
    }

    public static boolean h(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean i(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean j(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean k(long j10, String str) {
        long length = new File(str).length();
        StringBuilder sbA = j.b.a("Sink file size:", length, "; free size:");
        sbA.append(j10);
        k4.m.b(f10457a, sbA.toString());
        return ((double) j10) > e(length);
    }

    public static boolean l(StorageStatsManager storageStatsManager, long j10) {
        long jA = a6.o.a(storageStatsManager);
        StringBuilder sbA = j.b.a("Source file size:", j10, "; free size:");
        sbA.append(jA);
        k4.m.b(f10457a, sbA.toString());
        return ((double) jA) > e(j10);
    }

    public static String m(String str) {
        return new File(str).getName();
    }

    @Nullable
    public static FileInfo n(Context context, Uri uri, String str) {
        if (uri == null) {
            k4.m.c(f10457a, "choice file uri is null");
            return null;
        }
        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(context, uri);
        if (documentFileFromSingleUri == null) {
            k4.m.c(f10457a, "convert document file fail");
            return null;
        }
        String strF = f(context, uri);
        String name = documentFileFromSingleUri.getName();
        if (strF != null) {
            k4.m.b(f10457a, "file real path:".concat(strF));
            return new FileInfo(UUID.randomUUID().toString(), strF, str, documentFileFromSingleUri.getName(), "format", 0, documentFileFromSingleUri.length());
        }
        k4.m.c(f10457a, name + " load fail");
        return null;
    }
}
