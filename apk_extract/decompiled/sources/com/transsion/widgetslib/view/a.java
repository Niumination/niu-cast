package com.transsion.widgetslib.view;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        OverBoundNestedScrollView.SavedState savedState = new OverBoundNestedScrollView.SavedState(parcel);
        savedState.f3186a = parcel.readInt();
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new OverBoundNestedScrollView.SavedState[i8];
    }
}
