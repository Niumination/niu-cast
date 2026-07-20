package com.welink.protocol.nfbd;

import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new WirelessDevice.P2p(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), (WifiP2pDevice) ((Parcelable) parcel.readParcelable(WifiP2pDevice.class.getClassLoader(), WifiP2pDevice.class)), parcel.readLong());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new WirelessDevice.P2p[i8];
    }
}
