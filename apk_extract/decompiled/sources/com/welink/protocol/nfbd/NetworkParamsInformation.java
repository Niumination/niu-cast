package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import se.i4;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/NetworkParamsInformation;", "Landroid/os/Parcelable;", "CREATOR", "se/i4", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class NetworkParamsInformation implements Parcelable {
    public static final i4 CREATOR = new i4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3955d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f3957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f3958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f3959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f3962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f3963o;
    public final String p;
    public final Integer q;

    public NetworkParamsInformation(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Integer num) {
        this.f3952a = str;
        this.f3953b = str2;
        this.f3954c = str3;
        this.f3955d = str4;
        this.e = str5;
        this.f3956h = str6;
        this.f3957i = str7;
        this.f3958j = str8;
        this.f3959k = str9;
        this.f3960l = str10;
        this.f3961m = str11;
        this.f3962n = str12;
        this.f3963o = str13;
        this.p = str14;
        this.q = num;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkParamsInformation) || (str = this.f3958j) == null) {
            return false;
        }
        return Intrinsics.areEqual(str, ((NetworkParamsInformation) obj).f3958j);
    }

    public final int hashCode() {
        String str = this.f3958j;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "NetworkParamsInformation(remoteIpv4Address=" + this.f3952a + ", remoteIpv6Address=" + this.f3953b + ", ipAddress=" + this.f3954c + ", netmask=" + this.f3955d + ", gateway=" + this.e + ", dns=" + this.f3956h + ", dns2=" + this.f3957i + ", macAddress=" + this.f3958j + ", ipv6Prefix=" + this.f3959k + ", ipv6Address=" + this.f3960l + ", ipv6Gateway=" + this.f3961m + ", ipv6Dns=" + this.f3962n + ", ipv6Dns2=" + this.f3963o + ", ipv6MacAddress=" + this.p + ", ipv6PrefixLength=" + this.q + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i8) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f3952a);
        dest.writeString(this.f3953b);
        dest.writeString(this.f3954c);
        dest.writeString(this.f3955d);
        dest.writeString(this.e);
        dest.writeString(this.f3956h);
        dest.writeString(this.f3957i);
        dest.writeString(this.f3958j);
        dest.writeString(this.f3959k);
        dest.writeString(this.f3960l);
        dest.writeString(this.f3961m);
        dest.writeString(this.f3962n);
        dest.writeString(this.f3963o);
        dest.writeString(this.p);
        Integer num = this.q;
        dest.writeInt(num != null ? num.intValue() : -1);
    }
}
