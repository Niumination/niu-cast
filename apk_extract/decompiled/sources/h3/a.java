package h3;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBinder f5235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5236d;

    public /* synthetic */ a(IBinder iBinder, String str, int i8) {
        this.f5234b = i8;
        this.f5235c = iBinder;
        this.f5236d = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.f5234b) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.f5235c;
    }

    public void e(Parcel parcel, int i8) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f5235c.transact(i8, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public Parcel g(Parcel parcel, int i8) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f5235c.transact(i8, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } catch (Throwable th2) {
            parcel.recycle();
            throw th2;
        }
    }

    public Parcel i() {
        switch (this.f5234b) {
            case 1:
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken(this.f5236d);
                return parcelObtain;
            default:
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken(this.f5236d);
                return parcelObtain2;
        }
    }

    public Parcel j(Parcel parcel, int i8) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f5235c.transact(i8, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } catch (Throwable th2) {
            parcel.recycle();
            throw th2;
        }
    }

    public void k(Parcel parcel, int i8) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f5235c.transact(i8, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
