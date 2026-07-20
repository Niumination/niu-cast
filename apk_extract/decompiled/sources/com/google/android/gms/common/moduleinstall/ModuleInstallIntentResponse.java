package com.google.android.gms.common.moduleinstall;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import uc.a;

/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallIntentResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new a(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f1914a;

    public ModuleInstallIntentResponse(PendingIntent pendingIntent) {
        this.f1914a = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.d(parcel, 1, this.f1914a, i8);
        qd.j(parcel, i9);
    }
}
