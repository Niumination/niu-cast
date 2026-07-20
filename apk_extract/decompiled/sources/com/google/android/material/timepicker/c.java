package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2273b;

    public /* synthetic */ c(Object obj, int i8) {
        this.f2272a = i8;
        this.f2273b = obj;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i8, boolean z2) {
        int i9 = this.f2272a;
        Object obj = this.f2273b;
        switch (i9) {
            case 0:
                ((TimePickerTextInputPresenter) obj).lambda$setupPeriodToggle$0(materialButtonToggleGroup, i8, z2);
                break;
            default:
                ((TimePickerView) obj).lambda$new$0(materialButtonToggleGroup, i8, z2);
                break;
        }
    }
}
