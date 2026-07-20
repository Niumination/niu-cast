package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c3.b;
import java.util.ArrayList;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class WakeLockEvent extends StatsEvent {

    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1964d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f1967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f1969l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f1970m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f1971n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f1972o;
    public final long p;
    public final boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f1973r = -1;

    public WakeLockEvent(int i8, long j8, int i9, String str, int i10, ArrayList arrayList, String str2, long j10, int i11, String str3, String str4, float f, long j11, String str5, boolean z2) {
        this.f1961a = i8;
        this.f1962b = j8;
        this.f1963c = i9;
        this.f1964d = str;
        this.e = str3;
        this.f1965h = str5;
        this.f1966i = i10;
        this.f1967j = arrayList;
        this.f1968k = str2;
        this.f1969l = j10;
        this.f1970m = i11;
        this.f1971n = str4;
        this.f1972o = f;
        this.p = j11;
        this.q = z2;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int g() {
        return this.f1963c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long h() {
        return this.f1973r;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long i() {
        return this.f1962b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String k() {
        ArrayList arrayList = this.f1967j;
        String strJoin = arrayList == null ? "" : TextUtils.join(",", arrayList);
        String str = this.e;
        if (str == null) {
            str = "";
        }
        String str2 = this.f1971n;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f1965h;
        return "\t" + this.f1964d + "\t" + this.f1966i + "\t" + strJoin + "\t" + this.f1970m + "\t" + str + "\t" + str2 + "\t" + this.f1972o + "\t" + (str3 != null ? str3 : "") + "\t" + this.q;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1961a);
        qd.k(parcel, 2, 8);
        parcel.writeLong(this.f1962b);
        qd.e(parcel, 4, this.f1964d);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.f1966i);
        ArrayList arrayList = this.f1967j;
        if (arrayList != null) {
            int i10 = qd.i(parcel, 6);
            parcel.writeStringList(arrayList);
            qd.j(parcel, i10);
        }
        qd.k(parcel, 8, 8);
        parcel.writeLong(this.f1969l);
        qd.e(parcel, 10, this.e);
        qd.k(parcel, 11, 4);
        parcel.writeInt(this.f1963c);
        qd.e(parcel, 12, this.f1968k);
        qd.e(parcel, 13, this.f1971n);
        qd.k(parcel, 14, 4);
        parcel.writeInt(this.f1970m);
        qd.k(parcel, 15, 4);
        parcel.writeFloat(this.f1972o);
        qd.k(parcel, 16, 8);
        parcel.writeLong(this.p);
        qd.e(parcel, 17, this.f1965h);
        qd.k(parcel, 18, 4);
        parcel.writeInt(this.q ? 1 : 0);
        qd.j(parcel, i9);
    }
}
