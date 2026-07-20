package se;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new TranConnectionController$P2pDeviceInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), (WifiP2pDevice) ((Parcelable) parcel.readParcelable(WifiP2pDevice.class.getClassLoader(), WifiP2pDevice.class)), (WifiP2pGroup) ((Parcelable) parcel.readParcelable(WifiP2pGroup.class.getClassLoader(), WifiP2pGroup.class)));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new TranConnectionController$P2pDeviceInfo[i8];
    }
}
