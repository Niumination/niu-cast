package a6;

import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.storage.StorageManager;
import android.util.Pair;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f119a = "StorageUtils";

    public static long a(StorageStatsManager storageStatsManager) {
        try {
            return storageStatsManager.getFreeBytes(StorageManager.UUID_DEFAULT);
        } catch (IOException e10) {
            k4.m.d(f119a, e10);
            return 0L;
        }
    }

    public static Pair<Long, Long> b(Context context) {
        long totalBytes;
        StorageStatsManager storageStatsManager = (StorageStatsManager) context.getSystemService(StorageStatsManager.class);
        long freeBytes = 0;
        try {
            UUID uuid = StorageManager.UUID_DEFAULT;
            totalBytes = storageStatsManager.getTotalBytes(uuid);
            try {
                freeBytes = totalBytes - storageStatsManager.getFreeBytes(uuid);
            } catch (IOException e10) {
                e = e10;
                k4.m.d(f119a, e);
            }
        } catch (IOException e11) {
            e = e11;
            totalBytes = 0;
        }
        return new Pair<>(Long.valueOf(freeBytes), Long.valueOf(totalBytes));
    }
}
