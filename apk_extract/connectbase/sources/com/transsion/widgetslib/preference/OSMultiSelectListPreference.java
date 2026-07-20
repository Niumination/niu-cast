package com.transsion.widgetslib.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.util.AttributeSet;
import androidx.annotation.ArrayRes;
import com.transsion.widgetslib.R;
import ej.h;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class OSMultiSelectListPreference extends OSDialogPreference {
    public CharSequence[] H;
    public Set<String> I;
    public Set<String> J;
    public boolean K;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence[] f2359z;

    public class a implements DialogInterface.OnMultiChoiceClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i10, boolean z10) {
            if (z10) {
                OSMultiSelectListPreference oSMultiSelectListPreference = OSMultiSelectListPreference.this;
                OSMultiSelectListPreference.L(oSMultiSelectListPreference, oSMultiSelectListPreference.J.add(OSMultiSelectListPreference.this.H[i10].toString()) ? 1 : 0);
            } else {
                OSMultiSelectListPreference oSMultiSelectListPreference2 = OSMultiSelectListPreference.this;
                OSMultiSelectListPreference.L(oSMultiSelectListPreference2, oSMultiSelectListPreference2.J.remove(OSMultiSelectListPreference.this.H[i10].toString()) ? 1 : 0);
            }
        }
    }

    public OSMultiSelectListPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.I = new HashSet();
        this.J = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OsListPreference, i10, i11);
        this.f2359z = typedArrayObtainStyledAttributes.getTextArray(R.styleable.OsListPreference_entries);
        this.H = typedArrayObtainStyledAttributes.getTextArray(R.styleable.OsListPreference_entryValues);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    public static /* synthetic */ boolean L(OSMultiSelectListPreference oSMultiSelectListPreference, int i10) {
        ?? r10 = (i10 | (oSMultiSelectListPreference.K ? 1 : 0)) == true ? (byte) 1 : (byte) 0;
        oSMultiSelectListPreference.K = r10;
        return r10;
    }

    public int O(String str) {
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

    public CharSequence[] P() {
        return this.f2359z;
    }

    public CharSequence[] Q() {
        return this.H;
    }

    public final boolean[] R() {
        CharSequence[] charSequenceArr = this.H;
        int length = charSequenceArr.length;
        Set<String> set = this.I;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            zArr[i10] = set.contains(charSequenceArr[i10].toString());
        }
        return zArr;
    }

    public Set<String> S() {
        return this.I;
    }

    public void T(@ArrayRes int i10) {
        U(getContext().getResources().getTextArray(i10));
    }

    public void U(CharSequence[] charSequenceArr) {
        this.f2359z = charSequenceArr;
    }

    public void V(@ArrayRes int i10) {
        W(getContext().getResources().getTextArray(i10));
    }

    public void W(CharSequence[] charSequenceArr) {
        this.H = charSequenceArr;
    }

    public void X(Set<String> set) {
        this.I.clear();
        this.I.addAll(set);
        persistStringSet(set);
    }

    @Override // android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        CharSequence[] textArray = typedArray.getTextArray(i10);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference, android.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f2360a = S();
        return savedState;
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z10, Object obj) {
        X(z10 ? getPersistedStringSet(this.I) : (Set) obj);
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public void s(boolean z10) {
        if (z10 && this.K) {
            Set<String> set = this.J;
            if (callChangeListener(set)) {
                X(set);
            }
        }
        this.K = false;
    }

    @Override // com.transsion.widgetslib.preference.OSDialogPreference
    public void t(h.b bVar) {
        if (this.f2359z == null || this.H == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        bVar.v(this.f2359z, R(), new a());
        this.J.clear();
        this.J.addAll(this.I);
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set<String> f2360a;

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
            this.f2360a = new HashSet();
            for (String str : parcel.createStringArray()) {
                this.f2360a.add(str);
            }
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeStringArray((String[]) this.f2360a.toArray(new String[0]));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public OSMultiSelectListPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public OSMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.OsDialogPreferenceStyle, 0);
    }

    public OSMultiSelectListPreference(Context context) {
        this(context, null);
    }
}
