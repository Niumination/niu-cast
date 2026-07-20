package androidx.startup;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupException extends RuntimeException {
    public StartupException(@NonNull String str) {
        super(str);
    }

    public StartupException(@NonNull Throwable th2) {
        super(th2);
    }

    public StartupException(@NonNull String str, @NonNull Throwable th2) {
        super(str, th2);
    }
}
