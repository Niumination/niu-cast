package com.transsion.widgetslib.widget.shadow;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ExpandActionButton.SaveState saveState = new ExpandActionButton.SaveState(parcel);
        saveState.f3634a = parcel.readByte() == 0;
        return saveState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new ExpandActionButton.SaveState[i8];
    }
}
