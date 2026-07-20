package wf;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import k3.bb;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import m3.a6;
import wi.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(b bVar, Charset charset, ContinuationImpl continuationImpl) throws Throwable {
        d dVar;
        KType kTypeTypeOf;
        CharsetDecoder charsetDecoder;
        if (continuationImpl instanceof d) {
            dVar = (d) continuationImpl;
            int i8 = dVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                dVar.label = i8 - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuationImpl);
            }
        } else {
            dVar = new d(continuationImpl);
        }
        Object objA = dVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = dVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objA);
            Charset charsetA = a6.a(bVar);
            if (charsetA != null) {
                charset = charsetA;
            }
            CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
            kf.c cVarB = bVar.b();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(k.class);
            try {
                kTypeTypeOf = Reflection.typeOf(k.class);
            } catch (Throwable unused) {
                kTypeTypeOf = null;
            }
            ih.a aVar = new ih.a(orCreateKotlinClass, kTypeTypeOf);
            dVar.L$0 = charsetDecoderNewDecoder;
            dVar.label = 1;
            objA = cVarB.a(aVar, dVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            charsetDecoder = charsetDecoderNewDecoder;
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            charsetDecoder = (CharsetDecoder) dVar.L$0;
            ResultKt.throwOnFailure(objA);
        }
        if (objA == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.io.Source");
        }
        Intrinsics.checkNotNull(charsetDecoder);
        return bb.a(charsetDecoder, (k) objA, Integer.MAX_VALUE);
    }
}
