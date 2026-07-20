package com.transsion.iotcardsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.transsion.iotcardsdk.bean.IotCardTemplatePublisherWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface IControlsSubscriber extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.iotcardsdk.IControlsSubscriber";

    public static class Default implements IControlsSubscriber {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.transsion.iotcardsdk.IControlsSubscriber
        public void onComplete(IBinder iBinder) throws RemoteException {
        }

        @Override // com.transsion.iotcardsdk.IControlsSubscriber
        public void onError(IBinder iBinder, String str) throws RemoteException {
        }

        @Override // com.transsion.iotcardsdk.IControlsSubscriber
        public void onNext(IBinder iBinder, IotCardTemplatePublisherWrapper iotCardTemplatePublisherWrapper) throws RemoteException {
        }

        @Override // com.transsion.iotcardsdk.IControlsSubscriber
        public void onSubscribe(IBinder iBinder, IControlsSubscription iControlsSubscription) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IControlsSubscriber {
        static final int TRANSACTION_onComplete = 4;
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onNext = 2;
        static final int TRANSACTION_onSubscribe = 1;

        public static class Proxy implements IControlsSubscriber {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IControlsSubscriber.DESCRIPTOR;
            }

            @Override // com.transsion.iotcardsdk.IControlsSubscriber
            public void onComplete(IBinder iBinder) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsSubscriber.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.iotcardsdk.IControlsSubscriber
            public void onError(IBinder iBinder, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsSubscriber.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.iotcardsdk.IControlsSubscriber
            public void onNext(IBinder iBinder, IotCardTemplatePublisherWrapper iotCardTemplatePublisherWrapper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsSubscriber.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iBinder);
                    _Parcel.writeTypedObject(parcelObtain, iotCardTemplatePublisherWrapper, 0);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.transsion.iotcardsdk.IControlsSubscriber
            public void onSubscribe(IBinder iBinder, IControlsSubscription iControlsSubscription) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IControlsSubscriber.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeStrongInterface(iControlsSubscription);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IControlsSubscriber.DESCRIPTOR);
        }

        public static IControlsSubscriber asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IControlsSubscriber.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IControlsSubscriber)) ? new Proxy(iBinder) : (IControlsSubscriber) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(IControlsSubscriber.DESCRIPTOR);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(IControlsSubscriber.DESCRIPTOR);
                return true;
            }
            if (i8 == 1) {
                onSubscribe(parcel.readStrongBinder(), IControlsSubscription.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i8 == 2) {
                onNext(parcel.readStrongBinder(), (IotCardTemplatePublisherWrapper) _Parcel.readTypedObject(parcel, IotCardTemplatePublisherWrapper.INSTANCE));
            } else if (i8 == 3) {
                onError(parcel.readStrongBinder(), parcel.readString());
            } else {
                if (i8 != 4) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                onComplete(parcel.readStrongBinder());
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

    void onComplete(IBinder iBinder) throws RemoteException;

    void onError(IBinder iBinder, String str) throws RemoteException;

    void onNext(IBinder iBinder, IotCardTemplatePublisherWrapper iotCardTemplatePublisherWrapper) throws RemoteException;

    void onSubscribe(IBinder iBinder, IControlsSubscription iControlsSubscription) throws RemoteException;
}
