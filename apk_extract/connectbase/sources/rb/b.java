package rb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.InputEvent;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // rb.b
        public void m(InputEvent inputEvent) throws RemoteException {
        }
    }

    /* JADX INFO: renamed from: rb.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0349b extends Binder implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f14369c = "com.transsion.hubsdk.api.view.ITranTouchEventHandler";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14370d = 1;

        /* JADX INFO: renamed from: rb.b$b$a */
        public static class a implements b {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static b f14371d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IBinder f14372c;

            public a(IBinder iBinder) {
                this.f14372c = iBinder;
            }

            public String O() {
                return AbstractBinderC0349b.f14369c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14372c;
            }

            @Override // rb.b
            public void m(InputEvent inputEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0349b.f14369c);
                    if (inputEvent != null) {
                        parcelObtain.writeInt(1);
                        inputEvent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f14372c.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0349b.P() == null) {
                        parcelObtain2.readException();
                    } else {
                        f14371d.m(inputEvent);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0349b() {
            attachInterface(this, f14369c);
        }

        public static b O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f14369c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b P() {
            return a.f14371d;
        }

        public static boolean Q(b bVar) {
            if (a.f14371d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.f14371d = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f14369c);
                return true;
            }
            parcel.enforceInterface(f14369c);
            m(parcel.readInt() != 0 ? (InputEvent) InputEvent.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void m(InputEvent inputEvent) throws RemoteException;
}
