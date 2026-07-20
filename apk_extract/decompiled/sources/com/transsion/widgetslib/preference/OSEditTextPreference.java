package com.transsion.widgetslib.preference;

import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class OSEditTextPreference extends OSDialogPreference {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3089l;

    public static class SavedState extends Preference.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3090a;

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeString(this.f3090a);
        }
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public final void b(View view) {
        super.b(view);
        getText();
        throw null;
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public final void c(boolean z2) {
        if (z2) {
            throw null;
        }
    }

    public EditText getEditText() {
        return null;
    }

    public String getText() {
        return this.f3089l;
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
        setText(savedState.f3090a);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f3090a = getText();
        return savedState;
    }

    @Override // android.preference.Preference
    public final void onSetInitialValue(boolean z2, Object obj) {
        setText(z2 ? getPersistedString(this.f3089l) : (String) obj);
    }

    public void setText(String str) {
        boolean zEquals = TextUtils.equals(this.f3089l, str);
        if (zEquals) {
            return;
        }
        this.f3089l = str;
        persistString(str);
        if (zEquals) {
            return;
        }
        notifyDependencyChange(shouldDisableDependents());
        notifyChanged();
    }

    @Override // android.preference.Preference
    public final boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.f3089l) || super.shouldDisableDependents();
    }
}
