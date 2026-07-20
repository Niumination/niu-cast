package com.transsion.widgetslib.preference;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        OSDialogPreference.SavedState savedState = new OSDialogPreference.SavedState(parcel);
        savedState.f3087a = parcel.readInt() == 1;
        savedState.f3088b = parcel.readBundle();
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new OSDialogPreference.SavedState[i8];
    }
}
