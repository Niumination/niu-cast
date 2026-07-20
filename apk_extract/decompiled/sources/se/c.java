package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.nfbd.ConnectRequest;
import java.util.ArrayList;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        int i8 = parcel.readInt();
        int i9 = parcel.readInt();
        String string2 = parcel.readString();
        int i10 = parcel.readInt();
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        long j8 = parcel.readLong();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        int i11 = parcel.readInt();
        int i12 = parcel.readInt();
        int i13 = parcel.readInt();
        int i14 = parcel.readInt();
        int i15 = parcel.readInt();
        String string6 = parcel.readString();
        String string7 = parcel.readString();
        int i16 = parcel.readInt();
        int i17 = parcel.readInt();
        String string8 = parcel.readString();
        int i18 = parcel.readInt();
        int i19 = parcel.readInt();
        int i20 = parcel.readInt();
        byte[] bArrCreateByteArray = parcel.createByteArray();
        ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
        return new ConnectRequest(string, i8, i9, string2, i10, arrayListCreateStringArrayList, j8, string3, string4, string5, i11, i12, i13, i14, i15, string6, string7, i16, i17, string8, i18, i19, i20, bArrCreateByteArray, arrayListCreateStringArrayList2 != null ? CollectionsKt.toList(arrayListCreateStringArrayList2) : null, UInt.m248boximpl(UInt.m254constructorimpl(parcel.readInt())), UInt.m248boximpl(UInt.m254constructorimpl(parcel.readInt())), parcel.readInt(), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new ConnectRequest[i8];
    }
}
