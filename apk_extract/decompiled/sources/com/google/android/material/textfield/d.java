package com.google.android.material.textfield;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f2266b;

    public /* synthetic */ d(EndIconDelegate endIconDelegate, int i8) {
        this.f2265a = i8;
        this.f2266b = endIconDelegate;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f2265a;
        EndIconDelegate endIconDelegate = this.f2266b;
        switch (i8) {
            case 0:
                ((ClearTextEndIconDelegate) endIconDelegate).lambda$tearDown$2();
                break;
            default:
                ((DropdownMenuEndIconDelegate) endIconDelegate).lambda$afterEditTextChanged$3();
                break;
        }
    }
}
