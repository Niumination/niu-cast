package com.transsion.iotcardsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.transsion.iotcardsdk.bean.ControlActionWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface IControlsProvider extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.iotcardsdk.IControlsProvider";

    public static class Default implements IControlsProvider {
        @Override // com.transsion.iotcardsdk.IControlsProvider
        public void action(String str, ControlActionWrapper controlActionWrapper, IControlsActionCallback iControlsActionCallback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.iotcardsdk.IControlsProvider
        public void load(IControlsSubscriber iControlsSubscriber) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IControlsProvider {
        static final int TRANSACTION_action = 2;
        static final int TRANSACTION_load = 1;

        public static class Proxy implements IControlsProvider {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.transsion.iotcardsdk.IControlsProvider
            public void action(String str, ControlActionWrapper controlActionWrapper, IControlsActionCallback iControlsActionCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsProvider.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, controlActionWrapper, 0);
                    parcelObtain.writeStrongInterface(iControlsActionCallback);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IControlsProvider.DESCRIPTOR;
            }

            @Override // com.transsion.iotcardsdk.IControlsProvider
            public void load(IControlsSubscriber iControlsSubscriber) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsProvider.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iControlsSubscriber);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IControlsProvider.DESCRIPTOR);
        }

        public static IControlsProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IControlsProvider.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IControlsProvider)) ? new Proxy(iBinder) : (IControlsProvider) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(IControlsProvider.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(IControlsProvider.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                load(IControlsSubscriber.Stub.asInterface(parcel.readStrongBinder()));
            } else {
                if (i8 != 2) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                action(parcel.readString(), (ControlActionWrapper) _Parcel.readTypedObject(parcel, ControlActionWrapper.INSTANCE), IControlsActionCallback.Stub.asInterface(parcel.readStrongBinder()));
            }
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t3, int i8) {
            if (t3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t3.writeToParcel(parcel, i8);
            }
        }
    }

    void action(String str, ControlActionWrapper controlActionWrapper, IControlsActionCallback iControlsActionCallback) throws RemoteException;

    void load(IControlsSubscriber iControlsSubscriber) throws RemoteException;
}
