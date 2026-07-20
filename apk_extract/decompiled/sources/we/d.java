package we;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        byte b9 = parcel.readByte();
        byte b10 = parcel.readByte();
        String string = parcel.readString();
        String string2 = parcel.readString();
        Boolean boolValueOf = Boolean.valueOf(parcel.readBoolean());
        EarBudsInfo earBudsInfo = (EarBudsInfo) ((Parcelable) parcel.readParcelable(EarBudsInfo.class.getClassLoader(), EarBudsInfo.class));
        int i8 = parcel.readInt();
        int i9 = parcel.readInt();
        int i10 = parcel.readInt();
        int i11 = parcel.readInt();
        String string3 = parcel.readString();
        byte[] bArrCreateByteArray = parcel.createByteArray();
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        return new DeviceInfo(b9, b10, string, string2, boolValueOf, earBudsInfo, i8, i9, i10, i11, string3, bArrCreateByteArray, arrayListCreateStringArrayList != null ? CollectionsKt.toList(arrayListCreateStringArrayList) : null, parcel.readString(), parcel.readString(), parcel.readByte(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new DeviceInfo[i8];
    }
}
