package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import se.z3;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"com/welink/protocol/nfbd/NearLaptopManager$TransferConnectInfo", "Landroid/os/Parcelable;", "CREATOR", "se/z3", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class NearLaptopManager$TransferConnectInfo implements Parcelable {
    public static final z3 CREATOR = new z3();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3912a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3913b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f3914c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f3915d = null;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(NearLaptopManager$TransferConnectInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearLaptopManager.TransferConnectInfo");
        NearLaptopManager$TransferConnectInfo nearLaptopManager$TransferConnectInfo = (NearLaptopManager$TransferConnectInfo) obj;
        if (this.f3912a != nearLaptopManager$TransferConnectInfo.f3912a || this.f3913b != nearLaptopManager$TransferConnectInfo.f3913b) {
            return false;
        }
        byte[] bArr = this.f3914c;
        if (bArr != null) {
            byte[] bArr2 = nearLaptopManager$TransferConnectInfo.f3914c;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (nearLaptopManager$TransferConnectInfo.f3914c != null) {
            return false;
        }
        byte[] bArr3 = this.f3915d;
        if (bArr3 != null) {
            byte[] bArr4 = nearLaptopManager$TransferConnectInfo.f3915d;
            if (bArr4 == null || !Arrays.equals(bArr3, bArr4)) {
                return false;
            }
        } else if (nearLaptopManager$TransferConnectInfo.f3915d != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.f3912a) * 31) + this.f3913b) * 31;
        byte[] bArr = this.f3914c;
        int iHashCode2 = (iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.f3915d;
        return iHashCode2 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0);
    }

    public final String toString() {
        return "TransferConnectInfo(is5gSupport=" + this.f3912a + ", channel=" + this.f3913b + ", pcMac=" + Arrays.toString(this.f3914c) + ", phoneMac=" + Arrays.toString(this.f3915d) + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.f3912a ? 1 : 0);
        parcel.writeInt(this.f3913b);
        parcel.writeByteArray(this.f3914c);
        parcel.writeByteArray(this.f3915d);
    }
}
