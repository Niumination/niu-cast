package com.transsion.widgetslib.view;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ViewPagerTabs.SavedState savedState = new ViewPagerTabs.SavedState(parcel);
        savedState.f3214a = parcel.readInt();
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new ViewPagerTabs.SavedState[i8];
    }
}
