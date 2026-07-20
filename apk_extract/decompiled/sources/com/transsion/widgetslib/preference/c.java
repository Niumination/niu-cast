package com.transsion.widgetslib.preference;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        OSListPreference.SavedState savedState = new OSListPreference.SavedState(parcel);
        savedState.f3095a = parcel.readString();
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new OSListPreference.SavedState[i8];
    }
}
