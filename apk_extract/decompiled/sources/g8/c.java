package g8;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IBinder f5120c;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.f5119b) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.f5120c;
    }

    public String e() {
        switch (this.f5119b) {
            case 1:
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f5120c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            default:
                Parcel parcelObtain3 = Parcel.obtain();
                Parcel parcelObtain4 = Parcel.obtain();
                try {
                    parcelObtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f5120c.transact(1, parcelObtain3, parcelObtain4, 0);
                    parcelObtain4.readException();
                    return parcelObtain4.readString();
                } finally {
                    parcelObtain4.recycle();
                    parcelObtain3.recycle();
                }
        }
    }

    public boolean g() {
        switch (this.f5119b) {
            case 1:
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(1);
                    this.f5120c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            default:
                Parcel parcelObtain3 = Parcel.obtain();
                Parcel parcelObtain4 = Parcel.obtain();
                try {
                    parcelObtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain3.writeInt(1);
                    this.f5120c.transact(2, parcelObtain3, parcelObtain4, 0);
                    parcelObtain4.readException();
                    return parcelObtain4.readInt() != 0;
                } finally {
                    parcelObtain4.recycle();
                    parcelObtain3.recycle();
                }
        }
    }

    public String i() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f5120c.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public boolean j() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcelObtain.writeInt(1);
            this.f5120c.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
