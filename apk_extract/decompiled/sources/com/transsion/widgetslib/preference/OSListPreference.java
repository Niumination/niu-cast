package com.transsion.widgetslib.preference;

import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import ld.k;
import ld.n;

/* JADX INFO: loaded from: classes2.dex */
public class OSListPreference extends OSDialogPreference {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence[] f3091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence[] f3092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f3093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f3094o;
    public int p;

    public static class SavedState extends Preference.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3095a;

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeString(this.f3095a);
        }
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public final void c(boolean z2) {
        int i8;
        CharSequence[] charSequenceArr;
        if (!z2 || (i8 = this.p) < 0 || (charSequenceArr = this.f3092m) == null) {
            return;
        }
        String string = charSequenceArr[i8].toString();
        if (callChangeListener(string)) {
            setValue(string);
        }
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public final void d(k kVar) {
        if (this.f3091l == null || this.f3092m == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        int iF = f();
        this.p = iF;
        CharSequence[] charSequenceArr = this.f3091l;
        od.a aVar = new od.a(this);
        n nVar = kVar.f7400b;
        nVar.f7414o = charSequenceArr;
        nVar.u = iF;
        nVar.p = aVar;
        nVar.f7415r = true;
        kVar.c(null, null);
    }

    public final int f() {
        CharSequence[] charSequenceArr;
        String str = this.f3093n;
        if (str != null && (charSequenceArr = this.f3092m) != null) {
            for (int length = charSequenceArr.length - 1; length >= 0; length--) {
                if (this.f3092m[length].equals(str)) {
                    return length;
                }
            }
        }
        return -1;
    }

    public CharSequence[] getEntries() {
        return this.f3091l;
    }

    public CharSequence getEntry() {
        CharSequence[] charSequenceArr;
        int iF = f();
        if (iF < 0 || (charSequenceArr = this.f3091l) == null) {
            return null;
        }
        return charSequenceArr[iF];
    }

    public CharSequence[] getEntryValues() {
        return this.f3092m;
    }

    @Override // android.preference.Preference
    public CharSequence getSummary() {
        CharSequence entry = getEntry();
        String str = this.f3094o;
        if (str == null) {
            return super.getSummary();
        }
        if (entry == null) {
            entry = "";
        }
        return String.format(str, entry);
    }

    public String getValue() {
        return this.f3093n;
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
        setValue(savedState.f3095a);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f3095a = getValue();
        return savedState;
    }

    @Override // android.preference.Preference
    public final void onSetInitialValue(boolean z2, Object obj) {
        setValue(z2 ? getPersistedString(this.f3093n) : (String) obj);
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.f3091l = charSequenceArr;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.f3092m = charSequenceArr;
    }

    @Override // android.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.f3094o != null) {
            this.f3094o = null;
        } else {
            if (charSequence == null || charSequence.equals(this.f3094o)) {
                return;
            }
            this.f3094o = charSequence.toString();
        }
    }

    public void setValue(String str) {
        boolean zEquals = TextUtils.equals(this.f3093n, str);
        if (zEquals) {
            return;
        }
        this.f3093n = str;
        persistString(str);
        if (zEquals) {
            return;
        }
        notifyChanged();
    }

    public void setValueIndex(int i8) {
        CharSequence[] charSequenceArr = this.f3092m;
        if (charSequenceArr != null) {
            setValue(charSequenceArr[i8].toString());
        }
    }

    public void setEntries(@ArrayRes int i8) {
        setEntries(getContext().getResources().getTextArray(i8));
    }

    public void setEntryValues(@ArrayRes int i8) {
        setEntryValues(getContext().getResources().getTextArray(i8));
    }
}
