package oh;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 {
    public static s a(boolean z2, y frameType, byte[] data, boolean z3, boolean z5, boolean z10) {
        s mVar;
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        Intrinsics.checkNotNullParameter(data, "data");
        int i8 = o.$EnumSwitchMapping$0[frameType.ordinal()];
        if (i8 != 1) {
            z zVar = z.f8533a;
            if (i8 != 2) {
                if (i8 == 3) {
                    return new n(data);
                }
                if (i8 == 4) {
                    return new p(data);
                }
                if (i8 == 5) {
                    return new q(data, zVar);
                }
                throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNullParameter(data, "data");
            mVar = new r(z2, y.TEXT, data, z3, z5, z10);
        } else {
            mVar = new m(z2, data, z3, z5, z10);
        }
        return mVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(s0 s0Var, c cVar, ContinuationImpl continuationImpl) {
        t0 t0Var;
        if (continuationImpl instanceof t0) {
            t0Var = (t0) continuationImpl;
            int i8 = t0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                t0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                t0Var = new t0(continuationImpl);
            }
        } else {
            t0Var = new t0(continuationImpl);
        }
        Object obj = t0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = t0Var.label;
        try {
            if (i9 != 0) {
                if (i9 == 1) {
                    s0Var = (s0) t0Var.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            n nVar = new n(cVar);
            t0Var.L$0 = s0Var;
            t0Var.label = 1;
            if (s0Var.E(nVar, t0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            t0Var.L$0 = null;
            t0Var.label = 2;
            if (s0Var.l(t0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } catch (Throwable unused) {
        }
        return Unit.INSTANCE;
    }

    public static final void d(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List listSplit$default = StringsKt__StringsKt.split$default(value, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt__StringsKt.split$default((String) it.next(), new String[]{";"}, false, 0, 6, (Object) null);
            String string = StringsKt__StringsKt.trim((CharSequence) ((String) CollectionsKt.first(listSplit$default2))).toString();
            List listDrop = CollectionsKt.drop(listSplit$default2, 1);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.i(listDrop));
            Iterator it2 = listDrop.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StringsKt__StringsKt.trim((CharSequence) ((String) it2.next())).toString());
            }
            arrayList.add(new n6.a(string, arrayList2));
        }
    }

    public static final c e(n nVar) throws EOFException {
        Intrinsics.checkNotNullParameter(nVar, "<this>");
        byte[] bArr = nVar.f8520c;
        if (bArr.length < 2) {
            return null;
        }
        wi.a aVar = new wi.a();
        lh.a.k(aVar, bArr, 0, bArr.length);
        return new c(lh.a.h(aVar, null, 3), aVar.a());
    }

    public static final void f(ByteBuffer byteBuffer, ByteBuffer other) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        ByteBuffer byteBufferSlice2 = other.slice();
        int iRemaining = byteBufferSlice2.remaining();
        int iRemaining2 = byteBufferSlice.remaining();
        for (int i8 = 0; i8 < iRemaining2; i8++) {
            byteBufferSlice.put(i8, (byte) (byteBufferSlice.get(i8) ^ byteBufferSlice2.get(i8 % iRemaining)));
        }
    }
}
