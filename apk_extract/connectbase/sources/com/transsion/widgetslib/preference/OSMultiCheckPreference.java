package com.transsion.widgetslib.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.util.AttributeSet;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import com.transsion.widgetslib.R;
import ej.h;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class OSMultiCheckPreference extends OSDialogPreference {
    public String[] H;
    public boolean[] I;
    public boolean[] J;
    public String K;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence[] f2356z;

    public class a implements DialogInterface.OnMultiChoiceClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i10, boolean z10) {
            OSMultiCheckPreference.this.I[i10] = z10;
        }
    }

    public OSMultiCheckPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OsListPreference, i10, i11);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(R.styleable.OsListPreference_entries);
        this.f2356z = textArray;
        if (textArray != null) {
            S(textArray);
        }
        V(typedArrayObtainStyledAttributes.getTextArray(R.styleable.OsListPreference_entryValues));
        typedArrayObtainStyledAttributes.recycle();
    }

    public int M(String str) {
        String[] strArr;
        if (str == null || (strArr = this.H) == null) {
            return -1;
        }
        for (int length = strArr.length - 1; length >= 0; length--) {
            if (this.H[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] N() {
        return this.f2356z;
    }

    public String[] O() {
        return this.H;
    }

    public boolean P(int i10) {
        return this.I[i10];
    }

    public boolean[] Q() {
        return this.I;
    }

    public void R(@ArrayRes int i10) {
        S(getContext().getResources().getTextArray(i10));
    }

    public void S(CharSequence[] charSequenceArr) {
        this.f2356z = charSequenceArr;
        this.I = new boolean[charSequenceArr.length];
        this.J = new boolean[charSequenceArr.length];
    }

    public void T(@ArrayRes int i10) {
        V(getContext().getResources().getTextArray(i10));
    }

    public void U(String[] strArr) {
        this.H = strArr;
        Arrays.fill(this.I, false);
        Arrays.fill(this.J, false);
    }

    public final void V(CharSequence[] charSequenceArr) {
        X(null);
        if (charSequenceArr != null) {
            this.H = new String[charSequenceArr.length];
            for (int i10 = 0; i10 < charSequenceArr.length; i10++) {
                this.H[i10] = charSequenceArr[i10].toString();
            }
        }
    }

    public void W(int i10, boolean z10) {
        this.I[i10] = z10;
    }

    public void X(boolean[] zArr) {
        boolean[] zArr2 = this.I;
        if (zArr2 != null) {
            Arrays.fill(zArr2, false);
            Arrays.fill(this.J, false);
            if (zArr != null) {
                boolean[] zArr3 = this.I;
                System.arraycopy(zArr, 0, zArr3, 0, zArr.length < zArr3.length ? zArr.length : zArr3.length);
            }
        }
    }

    @Override // android.preference.Preference
    public CharSequence getSummary() {
        String str = this.K;
        return str == null ? super.getSummary() : str;
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
        X(savedState.f2357a);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f2357a = Q();
        return savedState;
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z10, Object obj) {
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public void s(boolean z10) {
        if (z10 && callChangeListener(Q())) {
            return;
        }
        boolean[] zArr = this.J;
        boolean[] zArr2 = this.I;
        System.arraycopy(zArr, 0, zArr2, 0, zArr2.length);
    }

    @Override // android.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.K != null) {
            this.K = null;
        } else {
            if (charSequence == null || charSequence.equals(this.K)) {
                return;
            }
            this.K = charSequence.toString();
        }
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public void t(h.b bVar) {
        if (this.f2356z == null || this.H == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        boolean[] zArr = this.I;
        this.J = Arrays.copyOf(zArr, zArr.length);
        bVar.v(this.f2356z, this.I, new a());
    }

    public static class SavedState extends Preference.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean[] f2357a;

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
            this.f2357a = parcel.createBooleanArray();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBooleanArray(this.f2357a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public OSMultiCheckPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public OSMultiCheckPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.OsDialogPreferenceStyle, 0);
    }

    public OSMultiCheckPreference(Context context) {
        this(context, null);
    }
}
