package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import se.m1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NearDeviceExtension;", "Landroid/os/Parcelable;", "CREATOR", "se/m1", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nNearDeviceExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NearDeviceExtension.kt\ncom/welink/protocol/nfbd/NearDeviceExtension\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,215:1\n9#2,4:216\n*S KotlinDebug\n*F\n+ 1 NearDeviceExtension.kt\ncom/welink/protocol/nfbd/NearDeviceExtension\n*L\n158#1:216,4\n*E\n"})
public final class NearDeviceExtension implements Parcelable {
    public static final m1 CREATOR = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3908d;
    public final boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LanNetworkInfo f3909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Set f3910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WearableDeviceInfo f3911j;

    public NearDeviceExtension(List list, String str, String str2, int i8, boolean z2, LanNetworkInfo lanNetworkInfo, Set set, WearableDeviceInfo wearableDeviceInfo) {
        this.f3905a = list;
        this.f3906b = str;
        this.f3907c = str2;
        this.f3908d = i8;
        this.e = z2;
        this.f3909h = lanNetworkInfo;
        this.f3910i = set;
        this.f3911j = wearableDeviceInfo;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(NearDeviceExtension.class, obj.getClass()) || !(obj instanceof NearDeviceExtension)) {
            return false;
        }
        NearDeviceExtension nearDeviceExtension = (NearDeviceExtension) obj;
        return Intrinsics.areEqual(this.f3905a, nearDeviceExtension.f3905a) && Intrinsics.areEqual(this.f3906b, nearDeviceExtension.f3906b) && Intrinsics.areEqual(this.f3907c, nearDeviceExtension.f3907c) && this.f3908d == nearDeviceExtension.f3908d && this.e == nearDeviceExtension.e && Intrinsics.areEqual(this.f3910i, nearDeviceExtension.f3910i) && Intrinsics.areEqual(this.f3909h, nearDeviceExtension.f3909h);
    }

    public final int hashCode() {
        return Objects.hash(this.f3905a, this.f3906b, Integer.valueOf(this.f3908d), Boolean.valueOf(this.e), this.f3909h, this.f3910i);
    }

    public final String toString() {
        return StringsKt.trimIndent("\n        NearDeviceExtension:\n        - Capability: " + this.f3905a + ",\n        - Public Bluetooth MAC: '" + this.f3906b + "',\n        - Connectable Address: '" + this.f3907c + "',\n        - BLE Version: " + this.f3908d + ",\n        - Connectable: " + this.e + ",\n        - Cascaded Devices: " + this.f3910i + ",\n        - LAN Network Info: " + this.f3909h + "\n    ");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i8) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        List list = this.f3905a;
        dest.writeIntArray(list != null ? CollectionsKt.toIntArray(list) : null);
        dest.writeString(this.f3906b);
        dest.writeString(this.f3907c);
        dest.writeInt(this.f3908d);
        dest.writeInt(this.e ? 1 : 0);
        dest.writeParcelable(this.f3909h, i8);
        Set set = this.f3910i;
        dest.writeTypedList(set != null ? CollectionsKt.toList(set) : null);
    }
}
