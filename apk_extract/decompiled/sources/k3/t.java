package k3;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {
    static {
        t.class.getClassLoader();
    }

    public static void a(Parcel parcel, f3.a aVar) {
        parcel.writeStrongBinder(aVar.asBinder());
    }
}
