package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
public interface ForegroundUpdater {
    @NonNull
    l setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo);
}
