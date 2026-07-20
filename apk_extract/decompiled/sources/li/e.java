package li;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7444b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0[] f7445a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public e(o0[] o0VarArr) {
        this.f7445a = o0VarArr;
        this.notCompletedCount$volatile = o0VarArr.length;
    }
}
