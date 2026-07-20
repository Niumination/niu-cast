package com.transsion.widgetslib.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$id;
import java.lang.reflect.Method;
import ld.k;
import ld.m;
import ld.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OSDialogPreference extends Preference implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, PreferenceManager.OnActivityDestroyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f3079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f3080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f3081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f3082d;
    public CharSequence e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f3083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f3085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3086k;

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f3088b;

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f3087a ? 1 : 0);
            parcel.writeBundle(this.f3088b);
        }
    }

    public final void a(PreferenceManager preferenceManager, String str) {
        try {
            Method declaredMethod = preferenceManager.getClass().getDeclaredMethod(str, PreferenceManager.OnActivityDestroyListener.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(View view) {
        int i8;
        View viewFindViewById = view.findViewById(R$id.message);
        if (viewFindViewById != null) {
            CharSequence dialogMessage = getDialogMessage();
            if (TextUtils.isEmpty(dialogMessage)) {
                i8 = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(dialogMessage);
                }
                i8 = 0;
            }
            if (viewFindViewById.getVisibility() != i8) {
                viewFindViewById.setVisibility(i8);
            }
        }
    }

    public void c(boolean z2) {
    }

    public void d(k kVar) {
    }

    public final void e(Bundle bundle) {
        Context context = getContext();
        this.f3086k = -2;
        k kVar = new k(context, 0);
        CharSequence charSequence = this.f3080b;
        n nVar = kVar.f7400b;
        nVar.f7403b = charSequence;
        nVar.f7404c = this.f3082d;
        kVar.c(this.e, this);
        kVar.b(this.f3083h, this);
        this.f3079a = kVar;
        View viewInflate = this.f3084i != 0 ? LayoutInflater.from(kVar.getContext()).inflate(this.f3084i, (ViewGroup) null) : null;
        if (viewInflate != null) {
            b(viewInflate);
            this.f3079a.f7400b.f7413n = viewInflate;
        } else {
            this.f3079a.f7400b.f7405d = this.f3081c;
        }
        d(this.f3079a);
        a(getPreferenceManager(), "registerOnActivityDestroyListener");
        k kVar2 = this.f3079a;
        n nVar2 = kVar2.f7400b;
        nVar2.f7409j = false;
        nVar2.f7410k = false;
        m mVarA = kVar2.a();
        this.f3085j = mVarA;
        if (bundle != null) {
            mVarA.onRestoreInstanceState(bundle);
        }
        if (this instanceof OSEditTextPreference) {
            mVarA.getWindow().setSoftInputMode(5);
        }
        mVarA.setOnDismissListener(this);
        mVarA.show();
    }

    public Dialog getDialog() {
        return this.f3085j;
    }

    public Drawable getDialogIcon() {
        return this.f3082d;
    }

    public int getDialogLayoutResource() {
        return this.f3084i;
    }

    public CharSequence getDialogMessage() {
        return this.f3081c;
    }

    public CharSequence getDialogTitle() {
        return this.f3080b;
    }

    public CharSequence getNegativeButtonText() {
        return this.f3083h;
    }

    public CharSequence getPositiveButtonText() {
        return this.e;
    }

    @Override // android.preference.PreferenceManager.OnActivityDestroyListener
    public final void onActivityDestroy() {
        m mVar = this.f3085j;
        if (mVar == null || !mVar.isShowing()) {
            return;
        }
        this.f3085j.dismiss();
    }

    @Override // android.preference.Preference
    public final void onBindView(View view) {
        super.onBindView(view);
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            if (linearLayout.getChildCount() >= 2) {
                View childAt = linearLayout.getChildAt(1);
                if (childAt instanceof RelativeLayout) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams.setMarginStart(0);
                    layoutParams.setMarginEnd(0);
                    childAt.setLayoutParams(layoutParams);
                    linearLayout.setPadding(0, linearLayout.getPaddingTop(), 0, linearLayout.getPaddingBottom());
                }
            }
        }
    }

    @Override // android.preference.Preference
    public final void onClick() {
        m mVar = this.f3085j;
        if (mVar == null || !mVar.isShowing()) {
            e(null);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        a(getPreferenceManager(), "unregisterOnActivityDestroyListener");
        this.f3085j = null;
        c(this.f3086k == -1);
    }

    @Override // android.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f3087a) {
            e(savedState.f3088b);
        }
    }

    @Override // android.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        m mVar = this.f3085j;
        if (mVar == null || !mVar.isShowing()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f3087a = true;
        savedState.f3088b = this.f3085j.onSaveInstanceState();
        return savedState;
    }

    public void setDialogIcon(Drawable drawable) {
        this.f3082d = drawable;
    }

    public void setDialogLayoutResource(int i8) {
        this.f3084i = i8;
    }

    public void setDialogMessage(CharSequence charSequence) {
        this.f3081c = charSequence;
    }

    public void setDialogTitle(CharSequence charSequence) {
        this.f3080b = charSequence;
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        this.f3083h = charSequence;
    }

    public void setPositiveButtonText(CharSequence charSequence) {
        this.e = charSequence;
    }

    public void setDialogIcon(@DrawableRes int i8) {
        this.f3082d = ContextCompat.getDrawable(getContext(), i8);
    }

    public void setDialogMessage(int i8) {
        setDialogMessage(getContext().getString(i8));
    }

    public void setDialogTitle(int i8) {
        setDialogTitle(getContext().getString(i8));
    }

    public void setNegativeButtonText(@StringRes int i8) {
        setNegativeButtonText(getContext().getString(i8));
    }

    public void setPositiveButtonText(@StringRes int i8) {
        setPositiveButtonText(getContext().getString(i8));
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i8) {
        this.f3086k = i8;
    }
}
