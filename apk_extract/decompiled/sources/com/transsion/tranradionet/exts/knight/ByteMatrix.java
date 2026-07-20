package com.transsion.tranradionet.exts.knight;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class ByteMatrix implements Parcelable {
    public static final Parcelable.Creator<ByteMatrix> CREATOR = new Parcelable.Creator<ByteMatrix>() { // from class: com.transsion.tranradionet.exts.knight.ByteMatrix.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ByteMatrix createFromParcel(Parcel parcel) {
            return new ByteMatrix(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ByteMatrix[] newArray(int i8) {
            return new ByteMatrix[i8];
        }
    };
    private final byte[][] data;

    public ByteMatrix(byte[][] bArr) {
        this.data = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[][] getData() {
        return this.data;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        byte[][] bArr = this.data;
        if (bArr == null || bArr.length == 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : this.data) {
            parcel.writeByteArray(bArr2);
        }
    }

    public ByteMatrix(Parcel parcel) {
        int i8 = parcel.readInt();
        if (i8 == 0) {
            this.data = null;
            return;
        }
        this.data = new byte[i8][];
        for (int i9 = 0; i9 < i8; i9++) {
            this.data[i9] = parcel.createByteArray();
        }
    }
}
