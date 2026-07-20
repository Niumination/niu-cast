package com.transsion.widgetslib.preference;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        OSMultiCheckPreference.SavedState savedState = new OSMultiCheckPreference.SavedState(parcel);
        savedState.f3100a = parcel.createBooleanArray();
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new OSMultiCheckPreference.SavedState[i8];
    }
}
