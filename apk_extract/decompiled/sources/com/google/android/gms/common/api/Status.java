package com.google.android.gms.common.api;

import a3.a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import k3.qd;
import u2.l;
import u6.c;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new a(25);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PendingIntent f1821d;
    public final ConnectionResult e;

    public Status(int i8, int i9, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f1818a = i8;
        this.f1819b = i9;
        this.f1820c = str;
        this.f1821d = pendingIntent;
        this.e = connectionResult;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f1818a == status.f1818a && this.f1819b == status.f1819b && l.h(this.f1820c, status.f1820c) && l.h(this.f1821d, status.f1821d) && l.h(this.e, status.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1818a), Integer.valueOf(this.f1819b), this.f1820c, this.f1821d, this.e});
    }

    public final String toString() {
        c cVar = new c(this);
        String strO = this.f1820c;
        if (strO == null) {
            int i8 = this.f1819b;
            switch (i8) {
                case -1:
                    strO = "SUCCESS_CACHE";
                    break;
                case 0:
                    strO = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strO = a1.a.o(i8, "unknown status code: ");
                    break;
                case 2:
                    strO = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strO = "SERVICE_DISABLED";
                    break;
                case 4:
                    strO = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strO = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strO = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strO = "NETWORK_ERROR";
                    break;
                case 8:
                    strO = "INTERNAL_ERROR";
                    break;
                case 10:
                    strO = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strO = "ERROR";
                    break;
                case 14:
                    strO = "INTERRUPTED";
                    break;
                case 15:
                    strO = "TIMEOUT";
                    break;
                case 16:
                    strO = "CANCELED";
                    break;
                case 17:
                    strO = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strO = "DEAD_CLIENT";
                    break;
                case 19:
                    strO = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strO = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strO = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strO = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        cVar.q(strO, "statusCode");
        cVar.q(this.f1821d, "resolution");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1819b);
        qd.e(parcel, 2, this.f1820c);
        qd.d(parcel, 3, this.f1821d, i8);
        qd.d(parcel, 4, this.e, i8);
        qd.k(parcel, 1000, 4);
        parcel.writeInt(this.f1818a);
        qd.j(parcel, i9);
    }

    public Status(int i8, String str) {
        this(1, i8, str, null, null);
    }
}
