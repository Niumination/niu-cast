package com.transsion.widgetslib.preference;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        OSEditTextPreference.SavedState savedState = new OSEditTextPreference.SavedState(parcel);
        savedState.f3090a = parcel.readString();
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new OSEditTextPreference.SavedState[i8];
    }
}
