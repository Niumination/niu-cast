package com.welink.protocol.utils;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import we.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"com/welink/protocol/utils/ArrayUtil$ServicePort", "Landroid/os/Parcelable;", "CREATOR", "we/a", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class ArrayUtil$ServicePort implements Parcelable {
    public static final a CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4212b;

    public ArrayUtil$ServicePort(String service, int i8) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.f4211a = service;
        this.f4212b = i8;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getF4212b() {
        return this.f4212b;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getF4211a() {
        return this.f4211a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArrayUtil$ServicePort)) {
            return false;
        }
        ArrayUtil$ServicePort arrayUtil$ServicePort = (ArrayUtil$ServicePort) obj;
        return Intrinsics.areEqual(this.f4211a, arrayUtil$ServicePort.f4211a) && this.f4212b == arrayUtil$ServicePort.f4212b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4212b) + (this.f4211a.hashCode() * 31);
    }

    public final String toString() {
        return "ServicePort(service=" + this.f4211a + ", port=" + this.f4212b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f4211a);
        parcel.writeInt(this.f4212b);
    }
}
