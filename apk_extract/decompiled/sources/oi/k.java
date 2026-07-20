package oi;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f8557a;

    public k(List list) {
        this.f8557a = list;
    }

    @Override // oi.h
    public final Object a(i iVar, Continuation continuation) {
        Object objEmit = iVar.emit(this.f8557a, continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }
}
