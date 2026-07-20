package com.transsion.widgetslib.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        InvertArrowSpinner.SavedState savedState = new InvertArrowSpinner.SavedState(parcel);
        savedState.f3393a = parcel.readByte() != 0;
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new InvertArrowSpinner.SavedState[i8];
    }
}
