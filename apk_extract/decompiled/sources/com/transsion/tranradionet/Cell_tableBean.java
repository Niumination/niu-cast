package com.transsion.tranradionet;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class Cell_tableBean implements Parcelable {
    public static final Parcelable.Creator<Cell_tableBean> CREATOR = new Parcelable.Creator<Cell_tableBean>() { // from class: com.transsion.tranradionet.Cell_tableBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Cell_tableBean createFromParcel(Parcel parcel) {
            return new Cell_tableBean(parcel, 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Cell_tableBean[] newArray(int i8) {
            return new Cell_tableBean[i8];
        }
    };
    public long mCellidentity;
    public int[] mFeature;
    public String mLogTime;
    public String mRegistered;
    public long mTime;
    public String mType;

    public /* synthetic */ Cell_tableBean(Parcel parcel, int i8) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.mRegistered);
        parcel.writeLong(this.mTime);
        parcel.writeString(this.mType);
        parcel.writeLong(this.mCellidentity);
        parcel.writeIntArray(this.mFeature);
        parcel.writeString(this.mLogTime);
    }

    public Cell_tableBean() {
        this.mFeature = new int[8];
    }

    private Cell_tableBean(Parcel parcel) {
        this.mFeature = new int[8];
        this.mRegistered = parcel.readString();
        this.mTime = parcel.readLong();
        this.mType = parcel.readString();
        this.mCellidentity = parcel.readLong();
        parcel.readIntArray(this.mFeature);
        this.mLogTime = parcel.readString();
    }
}
