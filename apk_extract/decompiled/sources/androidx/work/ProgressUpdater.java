package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
public interface ProgressUpdater {
    @NonNull
    l updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data);
}
