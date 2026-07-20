package androidx.lifecycle;

import jn.l;
import kn.n0;
import lm.l2;

/* JADX INFO: Add missing generic type declarations: [Y] */
/* JADX INFO: loaded from: classes.dex */
public final class Transformations$switchMap$1$onChanged$1<Y> extends n0 implements l<Y, l2> {
    final /* synthetic */ MediatorLiveData<Y> $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transformations$switchMap$1$onChanged$1(MediatorLiveData<Y> mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jn.l
    public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
        invoke2(obj);
        return l2.f10208a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Y y10) {
        this.$result.setValue(y10);
    }
}
