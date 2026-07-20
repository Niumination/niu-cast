package com.transsion.widgetslib.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R;
import ej.h;
import ej.i;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OSDialogPreference extends Preference implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, PreferenceManager.OnActivityDestroyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h.b f2334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f2335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f2336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f2337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f2338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f2339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2340g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2341i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2342n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Dialog f2343p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2344v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2345w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2346x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Runnable f2347y;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OSDialogPreference.this.f2343p != null) {
                OSDialogPreference.this.f2343p.dismiss();
            }
        }
    }

    @RequiresApi(api = 21)
    public OSDialogPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f2341i = true;
        this.f2342n = true;
        this.f2347y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OsDialogPreference, i10, i11);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.OsDialogPreference_dialogTitle);
        this.f2335b = string;
        if (string == null) {
            this.f2335b = getTitle();
        }
        this.f2336c = typedArrayObtainStyledAttributes.getString(R.styleable.OsDialogPreference_dialogMessage);
        this.f2337d = typedArrayObtainStyledAttributes.getDrawable(R.styleable.OsDialogPreference_dialogIcon);
        this.f2338e = typedArrayObtainStyledAttributes.getString(R.styleable.OsDialogPreference_positiveButtonText);
        this.f2339f = typedArrayObtainStyledAttributes.getString(R.styleable.OsDialogPreference_negativeButtonText);
        this.f2340g = typedArrayObtainStyledAttributes.getResourceId(R.styleable.OsDialogPreference_dialogLayout, this.f2340g);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new int[]{android.R.attr.listPreferredItemPaddingStart, android.R.attr.listPreferredItemPaddingEnd});
        this.f2345w = typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, context.getResources().getDimensionPixelSize(R.dimen.os_no_curve_content_padding));
        this.f2346x = typedArrayObtainStyledAttributes2.getDimensionPixelSize(1, context.getResources().getDimensionPixelSize(R.dimen.os_no_curve_content_padding));
        typedArrayObtainStyledAttributes2.recycle();
    }

    public void A(Drawable drawable) {
        this.f2337d = drawable;
    }

    public void B(int i10) {
        this.f2340g = i10;
    }

    public void C(int i10) {
        D(getContext().getString(i10));
    }

    public void D(CharSequence charSequence) {
        this.f2336c = charSequence;
    }

    public void E(int i10) {
        F(getContext().getString(i10));
    }

    public void F(CharSequence charSequence) {
        this.f2335b = charSequence;
    }

    public void G(@StringRes int i10) {
        H(getContext().getString(i10));
    }

    public void H(CharSequence charSequence) {
        this.f2339f = charSequence;
    }

    public void I(@StringRes int i10) {
        J(getContext().getString(i10));
    }

    public void J(CharSequence charSequence) {
        this.f2338e = charSequence;
    }

    @RequiresApi(api = 3)
    public void K(Bundle bundle) {
        Context context = getContext();
        this.f2344v = -2;
        h.b bVar = new h.b(context, 0);
        CharSequence charSequence = this.f2335b;
        i iVar = bVar.f4441b;
        iVar.f4449b = charSequence;
        iVar.f4451d = this.f2337d;
        this.f2334a = bVar.H(this.f2338e, this).x(this.f2339f, this);
        View viewR = r();
        if (viewR != null) {
            q(viewR);
            this.f2334a.U(viewR);
        } else {
            this.f2334a.s(this.f2336c);
        }
        t(this.f2334a);
        o(getPreferenceManager(), "registerOnActivityDestroyListener");
        h hVarA = this.f2334a.g(this.f2341i).h(this.f2342n).a();
        this.f2343p = hVarA;
        if (bundle != null) {
            hVarA.onRestoreInstanceState(bundle);
        }
        if (p()) {
            w(hVarA);
        }
        hVarA.setOnDismissListener(this);
        hVarA.show();
    }

    @Nullable
    public final View b() {
        Dialog dialog = this.f2343p;
        if (dialog == null || dialog.getWindow() == null) {
            return null;
        }
        return this.f2343p.getWindow().getDecorView();
    }

    public Dialog d() {
        return this.f2343p;
    }

    public Drawable f() {
        return this.f2337d;
    }

    public int h() {
        return this.f2340g;
    }

    public CharSequence k() {
        return this.f2336c;
    }

    public CharSequence l() {
        return this.f2335b;
    }

    public CharSequence m() {
        return this.f2339f;
    }

    public CharSequence n() {
        return this.f2338e;
    }

    public final void o(PreferenceManager preferenceManager, String str) {
        try {
            Method declaredMethod = preferenceManager.getClass().getDeclaredMethod(str, PreferenceManager.OnActivityDestroyListener.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, this);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.preference.PreferenceManager.OnActivityDestroyListener
    public void onActivityDestroy() {
        Dialog dialog = this.f2343p;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f2343p.dismiss();
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
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
                    linearLayout.setPadding(this.f2345w, linearLayout.getPaddingTop(), this.f2346x, linearLayout.getPaddingBottom());
                }
            }
        }
    }

    @Override // android.preference.Preference
    @RequiresApi(api = 21)
    public void onClick() {
        Dialog dialog = this.f2343p;
        if (dialog == null || !dialog.isShowing()) {
            K(null);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        o(getPreferenceManager(), "unregisterOnActivityDestroyListener");
        this.f2343p = null;
        s(this.f2344v == -1);
    }

    @Override // android.preference.Preference
    @RequiresApi(api = 21)
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f2348a) {
            K(savedState.f2349b);
        }
    }

    @Override // android.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Dialog dialog = this.f2343p;
        if (dialog == null || !dialog.isShowing()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.f2348a = true;
        savedState.f2349b = this.f2343p.onSaveInstanceState();
        return savedState;
    }

    public boolean p() {
        return false;
    }

    @CallSuper
    public void q(View view) {
        int i10;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequenceK = k();
            if (TextUtils.isEmpty(charSequenceK)) {
                i10 = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequenceK);
                }
                i10 = 0;
            }
            if (viewFindViewById.getVisibility() != i10) {
                viewFindViewById.setVisibility(i10);
            }
        }
    }

    public View r() {
        if (this.f2340g == 0) {
            return null;
        }
        return LayoutInflater.from(this.f2334a.b()).inflate(this.f2340g, (ViewGroup) null);
    }

    public void s(boolean z10) {
    }

    public void t(h.b bVar) {
    }

    public void u() {
        v();
        View viewB = b();
        if (viewB != null) {
            viewB.post(this.f2347y);
        }
    }

    public final void v() {
        View viewB = b();
        if (viewB != null) {
            viewB.removeCallbacks(this.f2347y);
        }
    }

    @RequiresApi(api = 3)
    public final void w(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    public OSDialogPreference x(boolean z10) {
        this.f2341i = z10;
        return this;
    }

    public OSDialogPreference y(boolean z10) {
        this.f2342n = z10;
        return this;
    }

    public void z(@DrawableRes int i10) {
        this.f2337d = ContextCompat.getDrawable(getContext(), i10);
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f2349b;

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
            this.f2348a = parcel.readInt() == 1;
            this.f2349b = parcel.readBundle();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2348a ? 1 : 0);
            parcel.writeBundle(this.f2349b);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f2344v = i10;
    }

    @RequiresApi(api = 21)
    public OSDialogPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    @RequiresApi(api = 21)
    public OSDialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.OsDialogPreferenceStyle, 0);
    }

    @RequiresApi(api = 21)
    public OSDialogPreference(Context context) {
        this(context, null);
    }
}
