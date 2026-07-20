package com.transsion.widgetslib.view.indicator;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        OSWatchPageIndicator.SaveState saveState = new OSWatchPageIndicator.SaveState(parcel);
        saveState.f3271a = 0;
        saveState.f3271a = parcel.readInt();
        return saveState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new OSWatchPageIndicator.SaveState[i8];
    }
}
