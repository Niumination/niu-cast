package com.transsion.widgetslib.preference;

import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import androidx.annotation.ArrayRes;
import java.util.HashSet;
import java.util.Set;
import ld.k;
import ld.n;

/* JADX INFO: loaded from: classes2.dex */
public class OSMultiSelectListPreference extends OSDialogPreference {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence[] f3101l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence[] f3102m;

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set f3103a;

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeStringArray((String[]) this.f3103a.toArray(new String[0]));
        }
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public final void c(boolean z2) {
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public final void d(k kVar) {
        CharSequence[] charSequenceArr;
        CharSequence[] charSequenceArr2 = this.f3101l;
        if (charSequenceArr2 == null || (charSequenceArr = this.f3102m) == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        int length = charSequenceArr.length;
        boolean[] zArr = new boolean[length];
        if (length > 0) {
            charSequenceArr[0].toString();
            throw null;
        }
        od.b bVar = new od.b(this, 1);
        n nVar = kVar.f7400b;
        nVar.f7414o = charSequenceArr2;
        nVar.f7416s = zArr;
        nVar.f7417t = bVar;
        nVar.q = true;
        throw null;
    }

    public CharSequence[] getEntries() {
        return this.f3101l;
    }

    public CharSequence[] getEntryValues() {
        return this.f3102m;
    }

    public Set<String> getValues() {
        return null;
    }

    @Override // android.preference.Preference
    public final Object onGetDefaultValue(TypedArray typedArray, int i8) {
        CharSequence[] textArray = typedArray.getTextArray(i8);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f3103a = getValues();
        return savedState;
    }

    @Override // android.preference.Preference
    public final void onSetInitialValue(boolean z2, Object obj) {
        setValues(z2 ? getPersistedStringSet(null) : (Set) obj);
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.f3101l = charSequenceArr;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.f3102m = charSequenceArr;
    }

    public void setValues(Set<String> set) {
        throw null;
    }

    public void setEntries(@ArrayRes int i8) {
        setEntries(getContext().getResources().getTextArray(i8));
    }

    public void setEntryValues(@ArrayRes int i8) {
        setEntryValues(getContext().getResources().getTextArray(i8));
    }
}
