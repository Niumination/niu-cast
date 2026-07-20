package tc;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f10206b;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10206b;
    }

    public final void e(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.transsion.kolun.kolunscanner.IKolunScanner");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(1);
            if (!this.f10206b.transact(13, parcelObtain, parcelObtain2, 0)) {
                int i8 = b.f10207b;
            }
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final String g(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.transsion.kolun.kolunscanner.IKolunScanner");
            parcelObtain.writeString(str);
            parcelObtain.writeString("ap0");
            if (!this.f10206b.transact(19, parcelObtain, parcelObtain2, 0)) {
                int i8 = b.f10207b;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final int i(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.transsion.kolun.kolunscanner.IKolunScanner");
            parcelObtain.writeString(str);
            if (!this.f10206b.transact(20, parcelObtain, parcelObtain2, 0)) {
                int i8 = b.f10207b;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final String j(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.transsion.kolun.kolunscanner.IKolunScanner");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            if (!this.f10206b.transact(12, parcelObtain, parcelObtain2, 0)) {
                int i8 = b.f10207b;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final boolean k(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.transsion.kolun.kolunscanner.IKolunScanner");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(1);
            if (!this.f10206b.transact(21, parcelObtain, parcelObtain2, 0)) {
                int i8 = b.f10207b;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
