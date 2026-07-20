package androidx.camera.video.internal.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class OutputUtil {
    private static final String TAG = "OutputUtil";

    private OutputUtil() {
    }

    public static boolean createParentFolder(@NonNull File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        return parentFile.exists() ? parentFile.isDirectory() : parentFile.mkdirs();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    @Nullable
    public static String getAbsolutePathFromUri(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) {
        Cursor cursorQuery;
        ?? r7 = 0;
        try {
            try {
                cursorQuery = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                try {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(str);
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    cursorQuery.close();
                    return string;
                } catch (RuntimeException e) {
                    e = e;
                    Logger.e(TAG, "Failed in getting absolute path for Uri " + uri.toString() + " with Exception " + e.toString());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                r7 = contentResolver;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (RuntimeException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r7 != 0) {
                r7.close();
            }
            throw th;
        }
    }
}
