package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new TranConnectionController$MessageInfo(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), (DeviceInfo) ((Parcelable) parcel.readParcelable(DeviceInfo.class.getClassLoader(), DeviceInfo.class)), (TranConnectionController$EventInfo) ((Parcelable) parcel.readParcelable(TranConnectionController$EventInfo.class.getClassLoader(), TranConnectionController$EventInfo.class)), (NearDeviceDataParcel) ((Parcelable) parcel.readParcelable(NearDeviceDataParcel.class.getClassLoader(), NearDeviceDataParcel.class)));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new TranConnectionController$MessageInfo[i8];
    }
}
