package androidx.lifecycle;

import jn.l;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
public final class Transformations$switchMap$2$onChanged$1 extends n0 implements l<Object, l2> {
    final /* synthetic */ MediatorLiveData<Object> $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transformations$switchMap$2$onChanged$1(MediatorLiveData<Object> mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
        invoke2(obj);
        return l2.f10208a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        this.$result.setValue(obj);
    }
}
