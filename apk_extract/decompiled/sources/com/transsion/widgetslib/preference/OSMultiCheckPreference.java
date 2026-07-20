package com.transsion.widgetslib.preference;

import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import java.util.Arrays;
import ld.k;
import ld.n;

/* JADX INFO: loaded from: classes2.dex */
public class OSMultiCheckPreference extends OSDialogPreference {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence[] f3096l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String[] f3097m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean[] f3098n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean[] f3099o;
    public String p;

    public static class SavedState extends Preference.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean[] f3100a;

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeBooleanArray(this.f3100a);
        }
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public final void c(boolean z2) {
        if (z2 && callChangeListener(getValues())) {
            return;
        }
        boolean[] zArr = this.f3099o;
        boolean[] zArr2 = this.f3098n;
        System.arraycopy(zArr, 0, zArr2, 0, zArr2.length);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public final void d(k kVar) {
        if (this.f3096l == null || this.f3097m == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        boolean[] zArr = this.f3098n;
        this.f3099o = Arrays.copyOf(zArr, zArr.length);
        CharSequence[] charSequenceArr = this.f3096l;
        boolean[] zArr2 = this.f3098n;
        od.b bVar = new od.b(this, 0);
        n nVar = kVar.f7400b;
        nVar.f7414o = charSequenceArr;
        nVar.f7416s = zArr2;
        nVar.f7417t = bVar;
        nVar.q = true;
    }

    public CharSequence[] getEntries() {
        return this.f3096l;
    }

    public String[] getEntryValues() {
        return this.f3097m;
    }

    @Override // android.preference.Preference
    public CharSequence getSummary() {
        String str = this.p;
        return str == null ? super.getSummary() : str;
    }

    public boolean[] getValues() {
        return this.f3098n;
    }

    @Override // android.preference.Preference
    public final Object onGetDefaultValue(TypedArray typedArray, int i8) {
        return typedArray.getString(i8);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setValues(savedState.f3100a);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f3100a = getValues();
        return savedState;
    }

    @Override // android.preference.Preference
    public final void onSetInitialValue(boolean z2, Object obj) {
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.f3096l = charSequenceArr;
        this.f3098n = new boolean[charSequenceArr.length];
        this.f3099o = new boolean[charSequenceArr.length];
    }

    public void setEntryValues(String[] strArr) {
        this.f3097m = strArr;
        Arrays.fill(this.f3098n, false);
        Arrays.fill(this.f3099o, false);
    }

    @Override // android.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.p != null) {
            this.p = null;
        } else {
            if (charSequence == null || charSequence.equals(this.p)) {
                return;
            }
            this.p = charSequence.toString();
        }
    }

    public void setValues(boolean[] zArr) {
        boolean[] zArr2 = this.f3098n;
        if (zArr2 != null) {
            Arrays.fill(zArr2, false);
            Arrays.fill(this.f3099o, false);
            if (zArr != null) {
                boolean[] zArr3 = this.f3098n;
                System.arraycopy(zArr, 0, zArr3, 0, zArr.length < zArr3.length ? zArr.length : zArr3.length);
            }
        }
    }

    public void setEntries(@ArrayRes int i8) {
        setEntries(getContext().getResources().getTextArray(i8));
    }

    public void setEntryValues(@ArrayRes int i8) {
        CharSequence[] textArray = getContext().getResources().getTextArray(i8);
        setValues(null);
        if (textArray != null) {
            this.f3097m = new String[textArray.length];
            for (int i9 = 0; i9 < textArray.length; i9++) {
                this.f3097m[i9] = textArray[i9].toString();
            }
        }
    }
}
