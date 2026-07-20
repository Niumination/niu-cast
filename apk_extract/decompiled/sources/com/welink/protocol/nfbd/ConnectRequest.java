package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/ConnectRequest;", "Landroid/os/Parcelable;", "CREATOR", "se/c", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class ConnectRequest implements Parcelable {
    public static final se.c CREATOR = new se.c();
    public final List A;
    public final UInt B;
    public final UInt C;
    public final int D;
    public final String E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3865d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f3866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f3867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f3868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f3869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f3871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f3872n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f3873o;
    public final int p;
    public final int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f3874r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f3875s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f3876t;
    public final int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f3877v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f3878w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3879x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3880y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final byte[] f3881z;

    public /* synthetic */ ConnectRequest(String str, int i8, int i9, String str2, int i10, ArrayList arrayList, long j8, String str3, String str4, String str5, int i11, int i12, int i13, int i14, int i15, String str6, String str7, int i16, int i17, String str8, int i18, int i19, int i20, byte[] bArr, List list, UInt uInt, UInt uInt2, int i21) {
        this(str, i8, i9, str2, i10, arrayList, j8, str3, str4, str5, i11, i12, i13, i14, i15, str6, str7, i16, i17, str8, i18, i19, i20, bArr, list, (i21 & 33554432) != 0 ? null : uInt, (i21 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? null : uInt2, 0, null);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getF3871m() {
        return this.f3871m;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getF3870l() {
        return this.f3870l;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getF3869k() {
        return this.f3869k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(ConnectRequest.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.ConnectRequest");
        ConnectRequest connectRequest = (ConnectRequest) obj;
        return Intrinsics.areEqual(this.f3862a, connectRequest.f3862a) && this.f3863b == connectRequest.f3863b && this.f3864c == connectRequest.f3864c && Intrinsics.areEqual(this.f3865d, connectRequest.f3865d) && this.e == connectRequest.e && Intrinsics.areEqual(this.f3866h, connectRequest.f3866h) && this.f3867i == connectRequest.f3867i && Intrinsics.areEqual(this.f3868j, connectRequest.f3868j) && Intrinsics.areEqual(this.f3869k, connectRequest.f3869k) && Intrinsics.areEqual(this.f3870l, connectRequest.f3870l) && this.f3871m == connectRequest.f3871m && this.f3872n == connectRequest.f3872n && this.f3873o == connectRequest.f3873o && this.p == connectRequest.p && Intrinsics.areEqual(this.f3874r, connectRequest.f3874r) && Intrinsics.areEqual(this.f3875s, connectRequest.f3875s) && this.f3876t == connectRequest.f3876t && this.u == connectRequest.u && Intrinsics.areEqual(this.f3877v, connectRequest.f3877v) && this.f3878w == connectRequest.f3878w && this.f3879x == connectRequest.f3879x && this.f3880y == connectRequest.f3880y && Intrinsics.areEqual(this.B, connectRequest.B) && Intrinsics.areEqual(this.C, connectRequest.C) && this.D == connectRequest.D && Intrinsics.areEqual(this.E, connectRequest.E);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getF3868j() {
        return this.f3868j;
    }

    public final int hashCode() {
        String str = this.f3862a;
        int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.f3863b) * 31) + this.f3864c) * 31;
        String str2 = this.f3865d;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.e) * 31;
        ArrayList arrayList = this.f3866h;
        int iF = a1.a.f(this.f3867i, (iHashCode2 + (arrayList != null ? arrayList.hashCode() : 0)) * 31, 31);
        String str3 = this.f3868j;
        int iHashCode3 = (iF + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3869k;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f3870l;
        int iHashCode5 = (((((((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f3871m) * 31) + this.f3872n) * 31) + this.f3873o) * 31) + this.p) * 31;
        String str6 = this.f3874r;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f3875s;
        int iHashCode7 = (((((iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.f3876t) * 31) + this.u) * 31;
        String str8 = this.f3877v;
        int iHashCode8 = (((((((iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.f3878w) * 31) + this.f3879x) * 31) + this.f3880y) * 31;
        UInt uInt = this.B;
        int iM266hashCodeimpl = (iHashCode8 + (uInt != null ? UInt.m266hashCodeimpl(uInt.getData()) : 0)) * 31;
        UInt uInt2 = this.C;
        int iM266hashCodeimpl2 = (((iM266hashCodeimpl + (uInt2 != null ? UInt.m266hashCodeimpl(uInt2.getData()) : 0)) * 31) + this.D) * 31;
        String str9 = this.E;
        return iM266hashCodeimpl2 + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        String string;
        byte[] bArr = this.f3881z;
        if (bArr != null) {
            string = Arrays.toString(bArr);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else {
            string = null;
        }
        List list = this.A;
        return "ConnectRequest(version=" + this.f3862a + ", encrypt=" + this.f3863b + ", reqType=" + this.f3864c + ", deviceId=" + this.f3865d + ", fileCount=" + this.e + ", fileName=" + this.f3866h + ", totalFileSize=" + this.f3867i + ", ssid=" + this.f3868j + ", pwd=" + this.f3869k + ", mac=" + this.f3870l + ", chan=" + this.f3871m + ", freq=" + this.f3872n + ", port=" + this.f3873o + ", messagePort=" + this.p + ", deviceName=" + this.f3874r + ", deviceMac=" + this.f3875s + ", productSubType=" + this.f3876t + ", productBrandName=" + this.u + ", productNameCode=" + this.f3877v + ", serviceType=" + this.f3878w + ", subCapability=" + this.f3879x + ", protocol=" + this.f3880y + ", serviceData=" + string + ", bandInfo=" + (list != null ? CollectionsKt___CollectionsKt.joinToString$default(list, " ", null, null, 0, null, null, 62, null) : null) + "), targetPublicService=" + this.B + ", targetPrivateService=" + this.C + "), iPhoneRequestResult=" + this.D;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f3862a);
        parcel.writeInt(this.f3863b);
        parcel.writeInt(this.f3864c);
        parcel.writeString(this.f3865d);
        parcel.writeInt(this.e);
        parcel.writeStringList(this.f3866h);
        parcel.writeLong(this.f3867i);
        parcel.writeString(this.f3868j);
        parcel.writeString(this.f3869k);
        parcel.writeString(this.f3870l);
        parcel.writeInt(this.f3871m);
        parcel.writeInt(this.f3872n);
        parcel.writeInt(this.f3873o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeString(this.f3874r);
        parcel.writeString(this.f3875s);
        parcel.writeInt(this.f3876t);
        parcel.writeInt(this.u);
        parcel.writeString(this.f3877v);
        parcel.writeInt(this.f3878w);
        parcel.writeInt(this.f3879x);
        parcel.writeInt(this.f3880y);
        parcel.writeByteArray(this.f3881z);
        parcel.writeStringList(this.A);
        UInt uInt = this.C;
        parcel.writeInt(uInt != null ? uInt.getData() : 0);
        UInt uInt2 = this.B;
        parcel.writeInt(uInt2 != null ? uInt2.getData() : 0);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
    }

    public ConnectRequest(String str, int i8, int i9, String str2, int i10, ArrayList arrayList, long j8, String str3, String str4, String str5, int i11, int i12, int i13, int i14, int i15, String str6, String str7, int i16, int i17, String str8, int i18, int i19, int i20, byte[] bArr, List list, UInt uInt, UInt uInt2, int i21, String str9) {
        this.f3862a = str;
        this.f3863b = i8;
        this.f3864c = i9;
        this.f3865d = str2;
        this.e = i10;
        this.f3866h = arrayList;
        this.f3867i = j8;
        this.f3868j = str3;
        this.f3869k = str4;
        this.f3870l = str5;
        this.f3871m = i11;
        this.f3872n = i12;
        this.f3873o = i13;
        this.p = i14;
        this.q = i15;
        this.f3874r = str6;
        this.f3875s = str7;
        this.f3876t = i16;
        this.u = i17;
        this.f3877v = str8;
        this.f3878w = i18;
        this.f3879x = i19;
        this.f3880y = i20;
        this.f3881z = bArr;
        this.A = list;
        this.B = uInt;
        this.C = uInt2;
        this.D = i21;
        this.E = str9;
    }
}
