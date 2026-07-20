package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/CascadedDevices;", "Landroid/os/Parcelable;", "CREATOR", "se/b", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CascadedDevices implements Parcelable {
    public static final se.b CREATOR = new se.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3861a;

    public CascadedDevices(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List devices = parcel.createTypedArrayList(NearDevice.CREATOR);
        devices = devices == null ? CollectionsKt.emptyList() : devices;
        Intrinsics.checkNotNullParameter(devices, "devices");
        this.f3861a = devices;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedList(this.f3861a);
    }
}
