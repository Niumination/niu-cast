package com.transsion.kolun.kolunscanner.parcelablebean;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import uc.a;

/* JADX INFO: loaded from: classes2.dex */
public class TwsBleScanResult implements Parcelable {
    public static final Parcelable.Creator<TwsBleScanResult> CREATOR = new a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2935d;
    public String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TwsBleScanBroadcastAndPairState f2936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TwsBleScanBoxAndEarbudsStatus f2937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TwsBleScanBatteryInfo f2938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TwsBleScanColorInfo f2939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TwsBleScanBLEAudioSupport f2940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TwsBleScanOtherEarbudBTMac f2941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TwsBleScanFirmwareVersion f2942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ContentValues f2943o;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TwsBleScanResult twsBleScanResult = (TwsBleScanResult) obj;
        return this.f2932a == twsBleScanResult.f2932a && this.f2934c == twsBleScanResult.f2934c && this.f2935d == twsBleScanResult.f2935d && Objects.equals(this.f2933b, twsBleScanResult.f2933b) && Objects.equals(this.e, twsBleScanResult.e) && Objects.equals(this.f2936h, twsBleScanResult.f2936h) && Objects.equals(this.f2937i, twsBleScanResult.f2937i) && Objects.equals(this.f2938j, twsBleScanResult.f2938j) && Objects.equals(this.f2939k, twsBleScanResult.f2939k) && Objects.equals(this.f2940l, twsBleScanResult.f2940l) && Objects.equals(this.f2941m, twsBleScanResult.f2941m) && Objects.equals(this.f2942n, twsBleScanResult.f2942n) && Objects.equals(this.f2943o, twsBleScanResult.f2943o);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2932a), this.f2933b, Integer.valueOf(this.f2934c), Integer.valueOf(this.f2935d), this.e, this.f2936h, this.f2937i, this.f2938j, this.f2939k, this.f2940l, this.f2941m, this.f2942n, this.f2943o);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f2932a);
        parcel.writeString(this.f2933b);
        parcel.writeInt(this.f2934c);
        parcel.writeInt(this.f2935d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f2936h, i8);
        parcel.writeParcelable(this.f2937i, i8);
        parcel.writeParcelable(this.f2938j, i8);
        parcel.writeParcelable(this.f2939k, i8);
        parcel.writeParcelable(this.f2940l, i8);
        parcel.writeParcelable(this.f2941m, i8);
        parcel.writeParcelable(this.f2942n, i8);
        parcel.writeParcelable(this.f2943o, i8);
    }
}
