package com.transsion.widgetslib.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.transsion.widgetslib.R;
import ej.h;

/* JADX INFO: loaded from: classes2.dex */
public class OSListPreference extends OSDialogPreference {
    public CharSequence[] H;
    public String I;
    public String J;
    public int K;
    public boolean L;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence[] f2353z;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            OSListPreference.this.K = i10;
            OSListPreference.this.onClick(dialogInterface, -1);
            OSListPreference.this.u();
        }
    }

    @RequiresApi(api = 21)
    public OSListPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OsListPreference, i10, i11);
        this.f2353z = typedArrayObtainStyledAttributes.getTextArray(R.styleable.OsListPreference_entries);
        this.H = typedArrayObtainStyledAttributes.getTextArray(R.styleable.OsListPreference_entryValues);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int M(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.H) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.H[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] N() {
        return this.f2353z;
    }

    public CharSequence O() {
        CharSequence[] charSequenceArr;
        int iM = M(this.I);
        if (iM < 0 || (charSequenceArr = this.f2353z) == null) {
            return null;
        }
        return charSequenceArr[iM];
    }

    public CharSequence[] P() {
        return this.H;
    }

    public final int Q() {
        return M(this.I);
    }

    public void R(@ArrayRes int i10) {
        S(getContext().getResources().getTextArray(i10));
    }

    public void S(CharSequence[] charSequenceArr) {
        this.f2353z = charSequenceArr;
    }

    public void T(@ArrayRes int i10) {
        U(getContext().getResources().getTextArray(i10));
    }

    public void U(CharSequence[] charSequenceArr) {
        this.H = charSequenceArr;
    }

    public void V(int i10) {
        CharSequence[] charSequenceArr = this.H;
        if (charSequenceArr != null) {
            setValue(charSequenceArr[i10].toString());
        }
    }

    @Override // android.preference.Preference
    public CharSequence getSummary() {
        CharSequence charSequenceO = O();
        String str = this.J;
        if (str == null) {
            return super.getSummary();
        }
        if (charSequenceO == null) {
            charSequenceO = "";
        }
        return String.format(str, charSequenceO);
    }

    public String getValue() {
        return this.I;
    }

    @Override // android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    @RequiresApi(api = 21)
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setValue(savedState.f2354a);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f2354a = getValue();
        return savedState;
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z10, Object obj) {
        setValue(z10 ? getPersistedString(this.I) : (String) obj);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public void s(boolean z10) {
        int i10;
        CharSequence[] charSequenceArr;
        if (!z10 || (i10 = this.K) < 0 || (charSequenceArr = this.H) == null) {
            return;
        }
        String string = charSequenceArr[i10].toString();
        if (callChangeListener(string)) {
            setValue(string);
        }
    }

    @Override // android.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.J != null) {
            this.J = null;
        } else {
            if (charSequence == null || charSequence.equals(this.J)) {
                return;
            }
            this.J = charSequence.toString();
        }
    }

    public void setValue(String str) {
        boolean zEquals = TextUtils.equals(this.I, str);
        if (zEquals && this.L) {
            return;
        }
        this.I = str;
        this.L = true;
        persistString(str);
        if (zEquals) {
            return;
        }
        notifyChanged();
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public void t(h.b bVar) {
        if (this.f2353z == null || this.H == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        int iM = M(this.I);
        this.K = iM;
        bVar.O(this.f2353z, iM, new a());
        bVar.H(null, null);
    }

    public static class SavedState extends Preference.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2354a;

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
            this.f2354a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f2354a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @RequiresApi(api = 21)
    public OSListPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    @RequiresApi(api = 21)
    public OSListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.OsDialogPreferenceStyle, 0);
    }

    @RequiresApi(api = 21)
    public OSListPreference(Context context) {
        this(context, null);
    }
}
