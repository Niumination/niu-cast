package com.transsion.connectx.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import l.a;
import rs.f;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Parcelable.Creator<DeviceInfo>() { // from class: com.transsion.connectx.sdk.DeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int i10) {
            return new DeviceInfo[i10];
        }
    };
    private String info;

    public DeviceInfo(String str) {
        this.info = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    @NonNull
    public String toString() {
        return a.a(new StringBuilder("DeviceInfo{info = "), this.info, f.f14860b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.info);
    }

    public DeviceInfo(Parcel parcel) {
        this.info = parcel.readString();
    }
}
