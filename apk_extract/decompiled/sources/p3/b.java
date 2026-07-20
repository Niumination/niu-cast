package p3;

import android.os.Parcel;
import com.google.android.gms.signin.internal.zak;
import i2.e;
import r2.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends h3.b {
    @Override // h3.b
    public final boolean i(int i8, Parcel parcel, Parcel parcel2) {
        switch (i8) {
            case 3:
                h3.c.b(parcel);
                break;
            case 4:
                h3.c.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                h3.c.b(parcel);
                break;
            case 7:
                h3.c.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) h3.c.a(parcel, zak.CREATOR);
                h3.c.b(parcel);
                t tVar = (t) this;
                tVar.f9367d.post(new e(tVar, 14, zakVar, false));
                break;
            case 9:
                h3.c.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
