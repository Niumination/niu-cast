package com.transsion.pcconnect.invoke.bridge;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yc.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/pcconnect/invoke/bridge/Device;", "Landroid/os/Parcelable;", "CREATOR", "yc/a", "invoke_bridge_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class Device implements Parcelable {
    public static final a CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2950d;

    public Device(String id2, String name, String type, String ip) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(ip, "ip");
        this.f2947a = id2;
        this.f2948b = name;
        this.f2949c = type;
        this.f2950d = ip;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return Intrinsics.areEqual(this.f2947a, device.f2947a) && Intrinsics.areEqual(this.f2948b, device.f2948b) && Intrinsics.areEqual(this.f2949c, device.f2949c) && Intrinsics.areEqual(this.f2950d, device.f2950d);
    }

    public final int hashCode() {
        return this.f2950d.hashCode() + a1.a.e(a1.a.e(this.f2947a.hashCode() * 31, 31, this.f2948b), 31, this.f2949c);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Device(id=");
        sb2.append(this.f2947a);
        sb2.append(", name=");
        sb2.append(this.f2948b);
        sb2.append(", type=");
        sb2.append(this.f2949c);
        sb2.append(", ip=");
        return h0.a.n(sb2, this.f2950d, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f2947a);
        parcel.writeString(this.f2948b);
        parcel.writeString(this.f2949c);
        parcel.writeString(this.f2950d);
    }
}
