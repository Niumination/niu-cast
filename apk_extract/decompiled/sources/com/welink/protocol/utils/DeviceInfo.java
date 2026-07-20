package com.welink.protocol.utils;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.welink.protocol.ble.EarBudsInfo;
import h0.a;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import we.d;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/utils/DeviceInfo;", "Landroid/os/Parcelable;", "CREATOR", "we/d", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nDeviceInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceInfo.kt\ncom/welink/protocol/utils/DeviceInfo\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,153:1\n9#2,4:154\n*S KotlinDebug\n*F\n+ 1 DeviceInfo.kt\ncom/welink/protocol/utils/DeviceInfo\n*L\n29#1:154,4\n*E\n"})
public final /* data */ class DeviceInfo implements Parcelable {
    public static final d CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f4220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f4221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4223d;
    public final Boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final EarBudsInfo f4224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f4228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f4229m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final byte[] f4230n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f4231o;
    public final String p;
    public final String q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final byte f4232r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f4233s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f4234t;
    public final int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f4235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f4236w;

    public /* synthetic */ DeviceInfo(byte b9, byte b10, String str, String str2, Boolean bool, EarBudsInfo earBudsInfo, int i8, int i9, int i10, int i11, String str3, byte[] bArr, List list, String str4, String str5, byte b11, int i12, int i13, int i14, String str6, int i15) {
        this(b9, b10, str, str2, bool, earBudsInfo, (i15 & 64) != 0 ? 0 : i8, (i15 & 128) != 0 ? 0 : i9, (i15 & 256) != 0 ? 0 : i10, (i15 & 512) != 0 ? 0 : i11, (i15 & 1024) != 0 ? null : str3, (i15 & 2048) != 0 ? null : bArr, (i15 & 4096) != 0 ? null : list, (i15 & 8192) != 0 ? null : str4, (i15 & 16384) != 0 ? null : str5, (32768 & i15) != 0 ? (byte) 0 : b11, (65536 & i15) != 0 ? 0 : i12, (131072 & i15) != 0 ? 0 : i13, (262144 & i15) != 0 ? 0 : i14, (i15 & 524288) != 0 ? null : str6, (String) null);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getF4223d() {
        return this.f4223d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        List list;
        byte[] bArr;
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(DeviceInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.utils.DeviceInfo");
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (this.f4220a != deviceInfo.f4220a || this.f4221b != deviceInfo.f4221b || !Intrinsics.areEqual(this.f4222c, deviceInfo.f4222c) || !Intrinsics.areEqual(this.f4223d, deviceInfo.f4223d) || !Intrinsics.areEqual(this.e, deviceInfo.e) || !Intrinsics.areEqual(this.f4224h, deviceInfo.f4224h) || this.f4225i != deviceInfo.f4225i || this.f4226j != deviceInfo.f4226j || this.f4227k != deviceInfo.f4227k || this.f4228l != deviceInfo.f4228l || !Intrinsics.areEqual(this.f4229m, deviceInfo.f4229m)) {
            return false;
        }
        byte[] bArr2 = this.f4230n;
        if (bArr2 != null && ((bArr = deviceInfo.f4230n) == null || !Arrays.equals(bArr2, bArr))) {
            return false;
        }
        List list2 = this.f4231o;
        if (list2 != null && ((list = deviceInfo.f4231o) == null || !Intrinsics.areEqual(list2, list))) {
            return false;
        }
        String str3 = this.q;
        if (str3 != null && ((str2 = deviceInfo.q) == null || !Intrinsics.areEqual(str3, str2))) {
            return false;
        }
        String str4 = this.p;
        return (str4 == null || ((str = deviceInfo.p) != null && Intrinsics.areEqual(str4, str))) && this.f4232r == deviceInfo.f4232r && this.f4233s == deviceInfo.f4233s && this.f4234t == deviceInfo.f4234t && Intrinsics.areEqual(this.f4235v, deviceInfo.f4235v) && Intrinsics.areEqual(this.f4236w, deviceInfo.f4236w);
    }

    public final int hashCode() {
        int iM177constructorimpl = (((UByte.m177constructorimpl(this.f4220a) & UByte.MAX_VALUE) * 31) + this.f4221b) * 31;
        String str = this.f4222c;
        int iHashCode = (iM177constructorimpl + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f4223d;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.e;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        EarBudsInfo earBudsInfo = this.f4224h;
        int iHashCode4 = (((((((((iHashCode3 + (earBudsInfo != null ? earBudsInfo.hashCode() : 0)) * 31) + this.f4225i) * 31) + this.f4226j) * 31) + this.f4227k) * 31) + this.f4228l) * 31;
        String str3 = this.f4229m;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        byte[] bArr = this.f4230n;
        int iHashCode6 = (iHashCode5 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        List list = this.f4231o;
        int iHashCode7 = (iHashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.p;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.q;
        int iHashCode9 = (((((((((iHashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f4232r) * 31) + this.f4233s) * 31) + this.f4234t) * 31) + this.u) * 31;
        String str6 = this.f4235v;
        int iHashCode10 = (iHashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f4236w;
        return iHashCode10 + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        String string = Arrays.toString(this.f4230n);
        StringBuilder sb2 = new StringBuilder("DeviceInfo(productSubType=");
        sb2.append((int) this.f4220a);
        sb2.append(", productBrandName=");
        sb2.append((int) this.f4221b);
        sb2.append(", productNameCode=");
        sb2.append(this.f4222c);
        sb2.append(", deviceMac=");
        sb2.append(this.f4223d);
        sb2.append(", isEarBuds=");
        sb2.append(this.e);
        sb2.append(", earBudsInfo=");
        sb2.append(this.f4224h);
        sb2.append(", wirelessType=");
        sb2.append(this.f4225i);
        sb2.append(", serviceType=");
        sb2.append(this.f4226j);
        sb2.append(", subCapability=");
        sb2.append(this.f4227k);
        sb2.append(", protocol=");
        sb2.append(this.f4228l);
        sb2.append(", version=");
        o.d.A(sb2, this.f4229m, ", serviceData=", string, ", bandInfo=");
        sb2.append(this.f4231o);
        sb2.append(", deviceName=");
        sb2.append(this.p);
        sb2.append(", pubMac=");
        sb2.append(this.q);
        sb2.append(", iphoneAction=");
        sb2.append((int) this.f4232r);
        sb2.append(", iphoneActionCount=");
        sb2.append(this.f4233s);
        sb2.append(", iphoneRequestResult=");
        sb2.append(this.f4234t);
        sb2.append(", fileCount=");
        sb2.append(this.u);
        sb2.append(", fileTypes=");
        sb2.append(this.f4235v);
        sb2.append(", shortPID=");
        return a.n(sb2, this.f4236w, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.f4220a);
        parcel.writeByte(this.f4221b);
        parcel.writeString(this.f4222c);
        parcel.writeString(this.f4223d);
        Boolean bool = this.e;
        parcel.writeBoolean(bool != null ? bool.booleanValue() : false);
        parcel.writeParcelable(this.f4224h, i8);
        parcel.writeInt(this.f4225i);
        parcel.writeInt(this.f4226j);
        parcel.writeInt(this.f4227k);
        parcel.writeInt(this.f4228l);
        parcel.writeString(this.f4229m);
        parcel.writeByteArray(this.f4230n);
        parcel.writeStringList(this.f4231o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeByte(this.f4232r);
        parcel.writeInt(this.f4233s);
        parcel.writeInt(this.f4234t);
        parcel.writeInt(this.u);
        parcel.writeString(this.f4235v);
        parcel.writeString(this.f4236w);
    }

    public DeviceInfo(byte b9, byte b10, String str, String str2, Boolean bool, EarBudsInfo earBudsInfo, int i8, int i9, int i10, int i11, String str3, byte[] bArr, List list, String str4, String str5, byte b11, int i12, int i13, int i14, String str6, String str7) {
        this.f4220a = b9;
        this.f4221b = b10;
        this.f4222c = str;
        this.f4223d = str2;
        this.e = bool;
        this.f4224h = earBudsInfo;
        this.f4225i = i8;
        this.f4226j = i9;
        this.f4227k = i10;
        this.f4228l = i11;
        this.f4229m = str3;
        this.f4230n = bArr;
        this.f4231o = list;
        this.p = str4;
        this.q = str5;
        this.f4232r = b11;
        this.f4233s = i12;
        this.f4234t = i13;
        this.u = i14;
        this.f4235v = str6;
        this.f4236w = str7;
    }
}
