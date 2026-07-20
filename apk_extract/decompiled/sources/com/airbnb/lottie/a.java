package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        LottieAnimationView.SavedState savedState = new LottieAnimationView.SavedState(parcel);
        savedState.f1752a = parcel.readString();
        savedState.f1754c = parcel.readFloat();
        savedState.f1755d = parcel.readInt() == 1;
        savedState.e = parcel.readString();
        savedState.f1756h = parcel.readInt();
        savedState.f1757i = parcel.readInt();
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new LottieAnimationView.SavedState[i8];
    }
}
