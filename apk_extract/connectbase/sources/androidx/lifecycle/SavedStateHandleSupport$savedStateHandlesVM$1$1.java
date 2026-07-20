package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import jn.l;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends n0 implements l<CreationExtras, SavedStateHandlesVM> {
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 INSTANCE = new SavedStateHandleSupport$savedStateHandlesVM$1$1();

    public SavedStateHandleSupport$savedStateHandlesVM$1$1() {
        super(1);
    }

    @Override // jn.l
    @os.l
    public final SavedStateHandlesVM invoke(@os.l CreationExtras creationExtras) {
        l0.p(creationExtras, "$this$initializer");
        return new SavedStateHandlesVM();
    }
}
