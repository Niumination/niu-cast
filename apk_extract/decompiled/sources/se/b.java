package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.nfbd.CascadedDevices;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new CascadedDevices(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new CascadedDevices[i8];
    }
}
