package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.nfbd.NearLaptopManager$TransferConnectInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z3 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        NearLaptopManager$TransferConnectInfo nearLaptopManager$TransferConnectInfo = new NearLaptopManager$TransferConnectInfo();
        nearLaptopManager$TransferConnectInfo.f3912a = parcel.readInt() == 1;
        nearLaptopManager$TransferConnectInfo.f3913b = parcel.readInt();
        nearLaptopManager$TransferConnectInfo.f3914c = parcel.createByteArray();
        nearLaptopManager$TransferConnectInfo.f3915d = parcel.createByteArray();
        return nearLaptopManager$TransferConnectInfo;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new NearLaptopManager$TransferConnectInfo[i8];
    }
}
