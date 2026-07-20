package q2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class d extends Exception {

    @NonNull
    @Deprecated
    protected final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(@NonNull Status status) {
        int i8 = status.f1819b;
        String str = status.f1820c;
        super(i8 + ": " + (str == null ? "" : str));
        this.mStatus = status;
    }

    @NonNull
    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.f1819b;
    }

    @Nullable
    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.f1820c;
    }
}
