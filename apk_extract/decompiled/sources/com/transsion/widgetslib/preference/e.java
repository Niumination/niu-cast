package com.transsion.widgetslib.preference;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        OSMultiSelectListPreference.SavedState savedState = new OSMultiSelectListPreference.SavedState(parcel);
        savedState.f3103a = new HashSet();
        for (String str : parcel.createStringArray()) {
            savedState.f3103a.add(str);
        }
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new OSMultiSelectListPreference.SavedState[i8];
    }
}
