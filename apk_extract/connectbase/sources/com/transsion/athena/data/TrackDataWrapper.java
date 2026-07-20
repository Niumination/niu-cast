package com.transsion.athena.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TrackDataWrapper implements Parcelable {
    public static final Parcelable.Creator<TrackDataWrapper> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TrackData f1825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1826c;

    public class a implements Parcelable.Creator<TrackDataWrapper> {
        @Override // android.os.Parcelable.Creator
        public TrackDataWrapper createFromParcel(Parcel parcel) {
            return new TrackDataWrapper(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrackDataWrapper[] newArray(int i10) {
            return new TrackDataWrapper[i10];
        }
    }

    public TrackDataWrapper(String str, TrackData trackData, long j10) {
        this.f1824a = str;
        this.f1825b = trackData;
        this.f1826c = j10;
    }

    public String a() {
        String str = this.f1824a;
        return str == null ? "" : str;
    }

    public long b() {
        return this.f1826c;
    }

    public TrackData c() {
        return this.f1825b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1824a);
        parcel.writeParcelable(this.f1825b, i10);
        parcel.writeLong(this.f1826c);
    }

    public TrackDataWrapper(Parcel parcel) {
        this.f1824a = parcel.readString();
        this.f1825b = (TrackData) parcel.readParcelable(TrackData.class.getClassLoader());
        this.f1826c = parcel.readLong();
    }
}
