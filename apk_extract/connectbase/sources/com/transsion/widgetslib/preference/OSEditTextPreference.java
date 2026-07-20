package com.transsion.widgetslib.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.transsion.widgetslib.R;
import hj.h;

/* JADX INFO: loaded from: classes2.dex */
public class OSEditTextPreference extends OSDialogPreference {
    public String H;
    public boolean I;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public EditText f2351z;

    public OSEditTextPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f2351z = new EditText(context, attributeSet);
        this.f2351z.setId(h.s("com.android.internal.R$id", "edit"));
        this.f2351z.setBackgroundResource(R.drawable.os_dialog_edittext_bg);
        this.f2351z.setEnabled(true);
    }

    public EditText L() {
        return this.f2351z;
    }

    public String M() {
        return this.H;
    }

    public void N(View view, EditText editText) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.edittext_container);
        if (viewGroup != null) {
            viewGroup.addView(editText, -1, -2);
        }
    }

    public void O(String str) {
        boolean zEquals = TextUtils.equals(this.H, str);
        if (zEquals && this.I) {
            return;
        }
        this.H = str;
        this.I = true;
        persistString(str);
        if (zEquals) {
            return;
        }
        notifyDependencyChange(shouldDisableDependents());
        notifyChanged();
    }

    @Override // android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        O(savedState.f2352a);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f2352a = M();
        return savedState;
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z10, Object obj) {
        O(z10 ? getPersistedString(this.H) : (String) obj);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public boolean p() {
        return true;
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public void q(View view) {
        super.q(view);
        EditText editText = this.f2351z;
        editText.setText(M());
        ViewParent parent = editText.getParent();
        if (parent != view) {
            if (parent != null) {
                ((ViewGroup) parent).removeView(editText);
            }
            N(view, editText);
        }
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public void s(boolean z10) {
        if (z10) {
            String string = this.f2351z.getText().toString();
            if (callChangeListener(string)) {
                O(string);
            }
        }
    }

    @Override // android.preference.Preference
    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.H) || super.shouldDisableDependents();
    }

    public static class SavedState extends Preference.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2352a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2352a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f2352a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public OSEditTextPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public OSEditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.OsEditTextPreferenceStyle, 0);
    }

    public OSEditTextPreference(Context context) {
        this(context, null);
    }
}
