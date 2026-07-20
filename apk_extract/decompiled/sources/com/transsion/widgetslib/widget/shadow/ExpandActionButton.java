package com.transsion.widgetslib.widget.shadow;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.widgetslib.R$layout;
import fe.b;

/* JADX INFO: loaded from: classes2.dex */
public class ExpandActionButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3633d;

    public static class SaveState extends View.BaseSavedState {
        public static final Parcelable.Creator<SaveState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3634a;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeByte((byte) (!this.f3634a ? 1 : 0));
        }
    }

    public ExpandActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3633d = true;
        LayoutInflater.from(context).inflate(R$layout.os_expand_action_btn_layout, this);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics());
        setPadding(iApplyDimension, iApplyDimension, iApplyDimension, iApplyDimension);
        this.f3630a = (int) TypedValue.applyDimension(1, 88.0f, getResources().getDisplayMetrics());
        this.f3631b = (int) TypedValue.applyDimension(1, 265.0f, getResources().getDisplayMetrics());
        int i8 = context.getResources().getConfiguration().orientation;
        if (i8 == 2) {
            this.f3632c = 1;
        } else if (i8 == 1) {
            this.f3632c = 0;
        }
    }

    private void setItemsVisibility(int i8) {
    }

    public final void a() {
        int i8 = this.f3632c;
        int i9 = this.f3630a;
        int i10 = this.f3631b;
        if (i8 == 0) {
            getLayoutParams().height = i10;
            getLayoutParams().width = i9;
            requestLayout();
        } else if (i8 == 1) {
            getLayoutParams().width = i10;
            getLayoutParams().height = i9;
            requestLayout();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        int i8 = configuration.orientation;
        if (i8 == 2) {
            setExpandOrientation(1);
        } else if (i8 == 1) {
            setExpandOrientation(0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        if (this.f3633d) {
            return;
        }
        setItemsVisibility(8);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SaveState saveState = (SaveState) parcelable;
        super.onRestoreInstanceState(saveState);
        boolean z2 = saveState.f3634a;
        this.f3633d = z2;
        setExpandable(z2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SaveState saveState = new SaveState(super.onSaveInstanceState());
        saveState.f3634a = this.f3633d;
        return saveState;
    }

    public void setExpandOrientation(int i8) {
        this.f3632c = i8;
        a();
    }

    public void setExpandable(boolean z2) {
        this.f3633d = z2;
        if (z2) {
            a();
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i8 = this.f3630a;
        layoutParams.width = i8;
        getLayoutParams().height = i8;
        requestLayout();
    }

    public void setOnItemButtonClickListener(fe.a aVar) {
    }

    public void setOnMainButtonClickListener(b bVar) {
    }
}
