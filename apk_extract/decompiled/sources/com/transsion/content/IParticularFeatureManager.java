package com.transsion.content;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IParticularFeatureManager extends IInterface {
    public static final String DESCRIPTOR = "com.transsion.content.IParticularFeatureManager";

    public static class Default implements IParticularFeatureManager {
        public Default() {
            throw new RuntimeException("Stub!");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            throw new RuntimeException("Stub!");
        }

        @Override // com.transsion.content.IParticularFeatureManager
        public IBinder getFeature(String str, String str2) throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        @Override // com.transsion.content.IParticularFeatureManager
        public boolean hasFeature(String str, String str2) throws RemoteException {
            throw new RuntimeException("Stub!");
        }
    }

    public static abstract class Stub extends Binder implements IParticularFeatureManager {
        public Stub() {
            throw new RuntimeException("Stub!");
        }

        public static IParticularFeatureManager asInterface(IBinder iBinder) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            throw new RuntimeException("Stub!");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            throw new RuntimeException("Stub!");
        }
    }

    IBinder getFeature(String str, String str2) throws RemoteException;

    boolean hasFeature(String str, String str2) throws RemoteException;
}
