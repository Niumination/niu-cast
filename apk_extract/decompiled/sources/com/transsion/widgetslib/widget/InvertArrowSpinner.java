package com.transsion.widgetslib.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$style;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import zd.e;
import zd.j;
import zd.n;

/* JADX INFO: loaded from: classes2.dex */
public class InvertArrowSpinner extends Spinner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public id.a f3389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f3390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ListView f3392d;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3393a;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeByte(this.f3393a ? (byte) 1 : (byte) 0);
        }
    }

    public InvertArrowSpinner(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public ListView getPopupList() {
        return this.f3392d;
    }

    public n getPopupWindow() {
        return this.f3390b;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        getSelectedItemPosition();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f3393a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new kd.a(this, 3));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3393a = this.f3391c;
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0049 A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:7:0x0017, B:9:0x003c, B:11:0x0045, B:13:0x004b, B:12:0x0049), top: B:19:0x0017 }] */
    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        id.a aVar = this.f3389a;
        if (aVar != null && aVar.getCount() > 0) {
            setBackground(getResources().getDrawable(R$drawable.os_spinner_background_material_blue_close));
            try {
                getContext();
                this.f3389a.setDropDownSpinner(true);
                this.f3392d.setOnItemClickListener(new j(this, 0));
                this.f3390b.setOnDismissListener(new e(this, 1));
                n nVar = this.f3390b;
                View view = nVar.e;
                if (view != null) {
                    Intrinsics.checkNotNull(view);
                    if (view.getLayoutDirection() == 1) {
                        nVar.f11299d = false;
                    } else {
                        nVar.f11299d = true;
                    }
                } else {
                    nVar.f11299d = true;
                }
                nVar.f11303j = true;
                this.f3390b.f(this.f3389a.getCount(), this);
                this.f3391c = true;
                return true;
            } catch (Exception e) {
                Log.e("os_spinner", "performClick OSPopupWindow error: " + e);
            }
        }
        return super.performClick();
    }

    public void setNeedRemoveAllGlobalLayoutListeners(boolean z2) {
    }

    public InvertArrowSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(getResources().getDrawable(R$drawable.os_spinner_background_material_blue_open));
        setPopupBackgroundDrawable(getResources().getDrawable(R$drawable.os_liquid_popup_background));
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
        int count = spinnerAdapter.getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i8 = 0; i8 < count; i8++) {
            Object item = spinnerAdapter.getItem(i8);
            if (item instanceof CharSequence) {
                arrayList.add((CharSequence) item);
            } else if (item instanceof TextView) {
                arrayList.add(((TextView) item).getText());
            } else if (item != null) {
                arrayList.add(String.valueOf(item));
            } else {
                arrayList.add("");
            }
        }
        id.a aVar = new id.a(getContext(), arrayList);
        this.f3389a = aVar;
        if (aVar.getCount() == 0) {
            return;
        }
        Context context = getContext();
        if (this.f3392d == null) {
            ListView listView = new ListView(context);
            this.f3392d = listView;
            listView.setDivider(null);
            this.f3392d.setSelector(new ColorDrawable(0));
            this.f3392d.setChoiceMode(0);
            this.f3392d.setAdapter((ListAdapter) this.f3389a);
        }
        if (this.f3390b == null) {
            n nVar = new n(context, 0, R$style.OsLiquidPopupWindowStyle);
            this.f3390b = nVar;
            nVar.setContentView(this.f3392d);
            this.f3390b.setWidth(pd.j.D(context, this.f3389a));
            this.f3390b.setOutsideTouchable(true);
            this.f3390b.setFocusable(true);
        }
    }

    @Override // android.widget.AbsSpinner, android.widget.AdapterView
    public id.a getAdapter() {
        return this.f3389a;
    }
}
