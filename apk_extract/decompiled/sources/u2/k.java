package u2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;

/* JADX INFO: loaded from: classes.dex */
public final class k implements IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f10346b;

    public k(IBinder iBinder) {
        this.f10346b = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10346b;
    }

    public final void e(n nVar, GetServiceRequest getServiceRequest) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(nVar);
            parcelObtain.writeInt(1);
            s8.b.a(getServiceRequest, parcelObtain, 0);
            this.f10346b.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
