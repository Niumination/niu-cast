package com.welink.protocol.utils;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import we.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/welink/protocol/utils/LanNetworkInfo;", "Landroid/os/Parcelable;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nLanNetworkInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanNetworkInfo.kt\ncom/welink/protocol/utils/LanNetworkInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,139:1\n1863#2,2:140\n*S KotlinDebug\n*F\n+ 1 LanNetworkInfo.kt\ncom/welink/protocol/utils/LanNetworkInfo\n*L\n72#1:140,2\n*E\n"})
public final /* data */ class LanNetworkInfo implements Parcelable {

    @JvmField
    public static final Parcelable.Creator<LanNetworkInfo> CREATOR = new b(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4240d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f4243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f4244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f4245l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f4246m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f4247n;

    public /* synthetic */ LanNetworkInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i8) {
        this(str, str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? null : str4, (i8 & 16) != 0 ? null : str5, (i8 & 32) != 0 ? null : str6, (i8 & 64) != 0 ? null : str7, (i8 & 128) != 0 ? null : str8, (i8 & 256) != 0 ? null : str9, (i8 & 512) != 0 ? null : str10, (i8 & 1024) != 0 ? null : str11, (List) null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(LanNetworkInfo.class, obj.getClass()) || !(obj instanceof LanNetworkInfo)) {
            return false;
        }
        LanNetworkInfo lanNetworkInfo = (LanNetworkInfo) obj;
        if (!Intrinsics.areEqual(this.f4237a, lanNetworkInfo.f4237a) || !Intrinsics.areEqual(this.f4238b, lanNetworkInfo.f4238b) || !Intrinsics.areEqual(this.f4239c, lanNetworkInfo.f4239c) || !Intrinsics.areEqual(this.f4240d, lanNetworkInfo.f4240d) || !Intrinsics.areEqual(this.e, lanNetworkInfo.e) || !Intrinsics.areEqual(this.f4241h, lanNetworkInfo.f4241h) || !Intrinsics.areEqual(this.f4242i, lanNetworkInfo.f4242i) || !Intrinsics.areEqual(this.f4243j, lanNetworkInfo.f4243j) || !Intrinsics.areEqual(this.f4244k, lanNetworkInfo.f4244k) || !Intrinsics.areEqual(this.f4245l, lanNetworkInfo.f4245l) || !Intrinsics.areEqual(this.f4246m, lanNetworkInfo.f4246m)) {
            return false;
        }
        List list = this.f4247n;
        if (list != null && lanNetworkInfo.f4247n != null) {
            Set set = list != null ? CollectionsKt.toSet(list) : null;
            List list2 = lanNetworkInfo.f4247n;
            if (!Intrinsics.areEqual(set, list2 != null ? CollectionsKt.toSet(list2) : null)) {
                return false;
            }
        } else if (!Intrinsics.areEqual(list, lanNetworkInfo.f4247n)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.f4237a, this.f4238b, this.f4239c, this.f4240d, this.e, this.f4241h, this.f4242i, this.f4243j, this.f4244k, this.f4245l, this.f4246m, this.f4247n);
    }

    public final String toString() {
        return StringsKt.trimIndent("LanNetworkInfo(\n            remoteIp=" + this.f4237a + ",\n            localIp=" + this.f4238b + ",\n            mac=" + this.f4239c + ",\n            mask=" + this.f4240d + ",\n            gateway=" + this.e + ",\n            remoteIpv6=" + this.f4241h + ",\n            localIpv6=" + this.f4242i + ",\n            macIpv6=" + this.f4243j + ",\n            maskIpv6=" + this.f4244k + ",\n            gatewayIpv6=" + this.f4245l + ",\n            hostname=" + this.f4246m + ",\n            serviceList=" + this.f4247n + "\n        ");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i8) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f4237a);
        dest.writeString(this.f4238b);
        dest.writeString(this.f4239c);
        dest.writeString(this.f4240d);
        dest.writeString(this.e);
        dest.writeString(this.f4241h);
        dest.writeString(this.f4242i);
        dest.writeString(this.f4243j);
        dest.writeString(this.f4244k);
        dest.writeString(this.f4245l);
        dest.writeString(this.f4246m);
        List list = this.f4247n;
        dest.writeInt(list != null ? list.size() : 0);
        List<Pair> list2 = this.f4247n;
        if (list2 != null) {
            for (Pair pair : list2) {
                dest.writeString((String) pair.getFirst());
                dest.writeInt(((Number) pair.getSecond()).intValue());
            }
        }
    }

    public LanNetworkInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list) {
        this.f4237a = str;
        this.f4238b = str2;
        this.f4239c = str3;
        this.f4240d = str4;
        this.e = str5;
        this.f4241h = str6;
        this.f4242i = str7;
        this.f4243j = str8;
        this.f4244k = str9;
        this.f4245l = str10;
        this.f4246m = str11;
        this.f4247n = list;
    }
}
