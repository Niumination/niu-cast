package com.google.android.gms.common;

import a3.a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.transsion.message.bank.MessageBank;
import java.util.Arrays;
import k3.qd;
import u2.l;
import u6.c;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f1799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1800d;
    public static final ConnectionResult e = new ConnectionResult(0);

    @NonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new a(15);

    public ConnectionResult(int i8, int i9, PendingIntent pendingIntent, String str) {
        this.f1797a = i8;
        this.f1798b = i9;
        this.f1799c = pendingIntent;
        this.f1800d = str;
    }

    public static String g(int i8) {
        if (i8 == 99) {
            return "UNFINISHED";
        }
        if (i8 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i8) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i8) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return h0.a.h(i8, "UNKNOWN_ERROR_CODE(", ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f1798b == connectionResult.f1798b && l.h(this.f1799c, connectionResult.f1799c) && l.h(this.f1800d, connectionResult.f1800d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1798b), this.f1799c, this.f1800d});
    }

    public final String toString() {
        c cVar = new c(this);
        cVar.q(g(this.f1798b), "statusCode");
        cVar.q(this.f1799c, "resolution");
        cVar.q(this.f1800d, MessageBank.KEY_MESSAGE);
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1797a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1798b);
        qd.d(parcel, 3, this.f1799c, i8);
        qd.e(parcel, 4, this.f1800d);
        qd.j(parcel, i9);
    }

    public ConnectionResult(int i8) {
        this(1, i8, null, null);
    }

    public ConnectionResult(int i8, PendingIntent pendingIntent) {
        this(1, i8, pendingIntent, null);
    }
}
