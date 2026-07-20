package com.welink.protocol.ble;

import a1.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ne.g;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/ble/EarBudsInfo;", "Landroid/os/Parcelable;", "CREATOR", "ne/g", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class EarBudsInfo implements Parcelable {
    public static final g CREATOR = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3847d;
    public final boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f3849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f3850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f3851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f3853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f3854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f3855o;
    public final String p;
    public final String q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f3856r;

    public EarBudsInfo(boolean z2, boolean z3, boolean z5, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i8, int i9, int i10, int i11, boolean z15, String str, String str2, boolean z16) {
        this.f3844a = z2;
        this.f3845b = z3;
        this.f3846c = z5;
        this.f3847d = z10;
        this.e = z11;
        this.f3848h = z12;
        this.f3849i = z13;
        this.f3850j = z14;
        this.f3851k = i8;
        this.f3852l = i9;
        this.f3853m = i10;
        this.f3854n = i11;
        this.f3855o = z15;
        this.p = str;
        this.q = str2;
        this.f3856r = z16;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EarBudsInfo)) {
            return false;
        }
        EarBudsInfo earBudsInfo = (EarBudsInfo) obj;
        return this.f3844a == earBudsInfo.f3844a && this.f3845b == earBudsInfo.f3845b && this.f3846c == earBudsInfo.f3846c && this.f3847d == earBudsInfo.f3847d && this.e == earBudsInfo.e && this.f3848h == earBudsInfo.f3848h && this.f3849i == earBudsInfo.f3849i && this.f3850j == earBudsInfo.f3850j && this.f3851k == earBudsInfo.f3851k && this.f3852l == earBudsInfo.f3852l && this.f3853m == earBudsInfo.f3853m && this.f3854n == earBudsInfo.f3854n && this.f3855o == earBudsInfo.f3855o && Intrinsics.areEqual(this.p, earBudsInfo.p) && Intrinsics.areEqual(this.q, earBudsInfo.q) && this.f3856r == earBudsInfo.f3856r;
    }

    public final int hashCode() {
        int iG = a.g(this.f3855o, a.c(this.f3854n, a.c(this.f3853m, a.c(this.f3852l, a.c(this.f3851k, a.g(this.f3850j, a.g(this.f3849i, a.g(this.f3848h, a.g(this.e, a.g(this.f3847d, a.g(this.f3846c, a.g(this.f3845b, Boolean.hashCode(this.f3844a) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        String str = this.p;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.q;
        return Boolean.hashCode(this.f3856r) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "EarBudsInfo(isBroadcasting=" + this.f3844a + ", isInPairingMode=" + this.f3845b + ", isConnectedWithDevice=" + this.f3846c + ", isBoxOpened=" + this.f3847d + ", isLeftEarbudInBox=" + this.e + ", isLeftEarbudInEar=" + this.f3848h + ", isRightEarbudInBox=" + this.f3849i + ", isRightEarbudInEar=" + this.f3850j + ", leftBattery=" + this.f3851k + ", rightBattery=" + this.f3852l + ", boxBattery=" + this.f3853m + ", color=" + this.f3854n + ", isSupportBLEAudio=" + this.f3855o + ", otherEarbudBTMac=" + this.p + ", firmwareVersion=" + this.q + ", isNotAllowFirstPopup=" + this.f3856r + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeBoolean(this.f3844a);
        parcel.writeBoolean(this.f3845b);
        parcel.writeBoolean(this.f3846c);
        parcel.writeBoolean(this.f3847d);
        parcel.writeBoolean(this.e);
        parcel.writeBoolean(this.f3848h);
        parcel.writeBoolean(this.f3849i);
        parcel.writeBoolean(this.f3850j);
        parcel.writeInt(this.f3851k);
        parcel.writeInt(this.f3852l);
        parcel.writeInt(this.f3853m);
        parcel.writeInt(this.f3854n);
        parcel.writeBoolean(this.f3855o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeBoolean(this.f3856r);
    }
}
