package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceExtension;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int[] iArrCreateIntArray = parcel.createIntArray();
        List<Integer> list = iArrCreateIntArray != null ? ArraysKt.toList(iArrCreateIntArray) : null;
        String string = parcel.readString();
        String string2 = parcel.readString();
        int i8 = parcel.readInt();
        boolean z2 = parcel.readInt() >= 1;
        LanNetworkInfo lanNetworkInfo = (LanNetworkInfo) ((Parcelable) parcel.readParcelable(LanNetworkInfo.class.getClassLoader(), LanNetworkInfo.class));
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(NearDevice.CREATOR);
        return new NearDeviceExtension(list, string, string2, i8, z2, lanNetworkInfo, arrayListCreateTypedArrayList != null ? CollectionsKt___CollectionsKt.toMutableSet(arrayListCreateTypedArrayList) : null, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new NearDeviceExtension[i8];
    }
}
