package h3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Binder implements IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5237b;

    public b(String str, int i8) {
        this.f5237b = i8;
        switch (i8) {
            case 1:
                attachInterface(this, str);
                break;
            default:
                attachInterface(this, str);
                break;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        int i8 = this.f5237b;
        return this;
    }

    public abstract boolean i(int i8, Parcel parcel, Parcel parcel2);

    public boolean j(int i8, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
        switch (this.f5237b) {
            case 0:
                if (i8 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i8, parcel, parcel2, i9)) {
                    return true;
                }
                return i(i8, parcel, parcel2);
            case 1:
                if (i8 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i8, parcel, parcel2, i9)) {
                    return true;
                }
                return j(i8, parcel, parcel2);
            default:
                return super.onTransact(i8, parcel, parcel2, i9);
        }
    }
}
