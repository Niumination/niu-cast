package v2;

import android.os.Parcel;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class a extends RuntimeException {
    public a(@NonNull String str, @NonNull Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }
}
