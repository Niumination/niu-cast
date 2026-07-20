package gg;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import jh.j0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(j0 j0Var, ReadableByteChannel readableByteChannel, ContinuationImpl continuationImpl) throws Throwable {
        g gVar;
        Ref.IntRef intRef;
        if (continuationImpl instanceof g) {
            gVar = (g) continuationImpl;
            int i8 = gVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                gVar.label = i8 - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuationImpl);
            }
        } else {
            gVar = new g(continuationImpl);
        }
        Object obj = gVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = gVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.IntRef intRef2 = new Ref.IntRef();
            gVar.L$0 = intRef2;
            gVar.label = 1;
            jh.k kVar = (jh.k) j0Var;
            wi.a aVarK = kVar.k();
            aVarK.getClass();
            wi.h hVarL = aVarK.l(1);
            int i10 = hVarL.f10778c;
            byte[] data = hVarL.f10776a;
            ByteBuffer buffer = ByteBuffer.wrap(data, i10, data.length - i10);
            Intrinsics.checkNotNull(buffer);
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            intRef2.element = readableByteChannel.read(buffer);
            Unit unit = Unit.INSTANCE;
            int iPosition = buffer.position() - i10;
            if (iPosition == 1) {
                Intrinsics.checkNotNullParameter(data, "data");
                hVarL.f10778c += iPosition;
                aVarK.f10764c += (long) iPosition;
            } else {
                if (iPosition < 0 || iPosition > hVarL.a()) {
                    StringBuilder sbU = a1.a.u(iPosition, "Invalid number of bytes written: ", ". Should be in 0..");
                    sbU.append(hVarL.a());
                    throw new IllegalStateException(sbU.toString().toString());
                }
                if (iPosition != 0) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    hVarL.f10778c += iPosition;
                    aVarK.f10764c += (long) iPosition;
                } else if (wi.q.d(hVarL)) {
                    aVarK.g();
                }
            }
            Object objH = kVar.h(gVar);
            if (objH != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objH = Unit.INSTANCE;
            }
            if (objH == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (Ref.IntRef) gVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(intRef.element);
    }
}
