package u2;

import android.os.Parcel;
import com.google.android.gms.common.internal.zax;

/* JADX INFO: loaded from: classes.dex */
public final class i extends h3.a {
    public final f3.a l(f3.b bVar, zax zaxVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f5236d);
        h3.c.d(parcelObtain, bVar);
        h3.c.c(parcelObtain, zaxVar);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                this.f5235c.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain.recycle();
                f3.a aVarK = f3.b.k(parcelObtain2.readStrongBinder());
                parcelObtain2.recycle();
                return aVarK;
            } catch (RuntimeException e) {
                parcelObtain2.recycle();
                throw e;
            }
        } catch (Throwable th2) {
            parcelObtain.recycle();
            throw th2;
        }
    }
}
