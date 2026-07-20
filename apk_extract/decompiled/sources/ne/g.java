package ne;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.ble.EarBudsInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new EarBudsInfo(parcel.readBoolean(), parcel.readBoolean(), parcel.readBoolean(), parcel.readBoolean(), parcel.readBoolean(), parcel.readBoolean(), parcel.readBoolean(), parcel.readBoolean(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readBoolean(), parcel.readString(), parcel.readString(), parcel.readBoolean());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new EarBudsInfo[i8];
    }
}
