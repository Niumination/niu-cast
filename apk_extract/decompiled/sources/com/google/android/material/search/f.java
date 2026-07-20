package com.google.android.material.search;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchViewAnimationHelper f2252b;

    public /* synthetic */ f(SearchViewAnimationHelper searchViewAnimationHelper, int i8) {
        this.f2251a = i8;
        this.f2252b = searchViewAnimationHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f2251a;
        SearchViewAnimationHelper searchViewAnimationHelper = this.f2252b;
        switch (i8) {
            case 0:
                searchViewAnimationHelper.lambda$startShowAnimationExpand$0();
                break;
            default:
                searchViewAnimationHelper.lambda$startShowAnimationTranslate$1();
                break;
        }
    }
}
