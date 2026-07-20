package c6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1364b;

        public b(String str, boolean z10) {
            this.f1363a = str;
            this.f1364b = z10;
        }

        public String a() {
            return this.f1363a;
        }

        public boolean b() {
            return this.f1364b;
        }
    }

    public static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f1366b;

        public c() {
            this.f1365a = false;
            this.f1366b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f1365a) {
                throw new IllegalStateException();
            }
            this.f1365a = true;
            return this.f1366b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (this.f1366b.size() == 0) {
                    this.f1366b.put(iBinder);
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                this.f1366b.clear();
            } catch (Exception unused) {
            }
        }
    }

    public static final class d implements IInterface {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IBinder f1367c;

        public d(IBinder iBinder) {
            this.f1367c = iBinder;
        }

        public String O() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f1367c.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean P(boolean z10) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z10 ? 1 : 0);
                this.f1367c.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f1367c;
        }
    }

    public static b a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        c cVar = new c();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (!context.bindService(intent, cVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                d dVar = new d(cVar.a());
                b bVar = new b(dVar.O(), dVar.P(true));
                context.unbindService(cVar);
                return bVar;
            } catch (Exception e10) {
                throw e10;
            }
        } catch (Throwable th2) {
            context.unbindService(cVar);
            throw th2;
        }
    }
}
