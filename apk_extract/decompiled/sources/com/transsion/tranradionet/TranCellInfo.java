package com.transsion.tranradionet;

import android.annotation.NonNull;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranCellInfo implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<TranCellInfo> CREATOR = new Parcelable.Creator<TranCellInfo>() { // from class: com.transsion.tranradionet.TranCellInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranCellInfo createFromParcel(Parcel parcel) {
            parcel.readInt();
            return new TranCellInfo(parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranCellInfo[] newArray(int i8) {
            return new TranCellInfo[i8];
        }
    };
    public int mCid;
    public String mMccStr;
    public String mMncStr;
    public String mPlmnStr;
    public int mType;

    public TranCellInfo(int i8, int i9, String str) {
        this.mCid = i8;
        this.mType = i9;
        this.mPlmnStr = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setCellIdentity(int i8) {
        this.mCid = i8;
    }

    public void setRatType(int i8) {
        this.mType = i8;
    }

    public String toString() {
        return "cid: " + this.mCid + " ,ratType: " + this.mType + " ,plmn: " + this.mPlmnStr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.mCid);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mPlmnStr);
    }

    public void setRatType(String str) {
        this.mPlmnStr = str;
    }
}
