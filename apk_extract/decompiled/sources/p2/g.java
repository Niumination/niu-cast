package p2;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import u2.y;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends h3.b implements y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f8658d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8659c;

    public g(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 1);
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.f8659c = Arrays.hashCode(bArr);
    }

    public static byte[] k(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // u2.y
    public final int c() {
        return this.f8659c;
    }

    @Override // u2.y
    public final f3.a d() {
        return new f3.b(l());
    }

    public final boolean equals(Object obj) {
        f3.a aVarD;
        if (obj != null && (obj instanceof y)) {
            try {
                y yVar = (y) obj;
                if (yVar.c() == this.f8659c && (aVarD = yVar.d()) != null) {
                    return Arrays.equals(l(), (byte[]) f3.b.l(aVarD));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8659c;
    }

    @Override // h3.b
    public final boolean j(int i8, Parcel parcel, Parcel parcel2) {
        if (i8 == 1) {
            f3.a aVarD = d();
            parcel2.writeNoException();
            i3.a.c(parcel2, aVarD);
        } else {
            if (i8 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.f8659c);
        }
        return true;
    }

    public abstract byte[] l();
}
