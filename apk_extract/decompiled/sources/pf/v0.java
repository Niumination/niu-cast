package pf;

import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf.d f8874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kf.c f8876c;

    public v0(jf.d client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f8874a = client;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // pf.m1
    public final Object a(vf.c cVar, ContinuationImpl continuationImpl) {
        u0 u0Var;
        if (continuationImpl instanceof u0) {
            u0Var = (u0) continuationImpl;
            int i8 = u0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                u0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                u0Var = new u0(this, continuationImpl);
            }
        } else {
            u0Var = new u0(this, continuationImpl);
        }
        Object objB = u0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = u0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objB);
            kf.c cVar2 = this.f8876c;
            if (cVar2 != null) {
                li.h0.b(cVar2, null);
            }
            int i10 = this.f8875b;
            if (i10 >= 20) {
                throw new l1("Max send count 20 exceeded. Consider increasing the property maxSendCount if more is required.");
            }
            this.f8875b = i10 + 1;
            vf.h hVar = this.f8874a.f6260i;
            Object obj = cVar.f10560d;
            u0Var.L$0 = this;
            u0Var.label = 1;
            objB = hVar.b(cVar, obj, u0Var);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (v0) u0Var.L$0;
            ResultKt.throwOnFailure(objB);
        }
        kf.c cVar3 = objB instanceof kf.c ? (kf.c) objB : null;
        if (cVar3 != null) {
            this.f8876c = cVar3;
            return cVar3;
        }
        throw new IllegalStateException(("Failed to execute send pipeline. Expected [HttpClientCall], but received " + objB).toString());
    }
}
