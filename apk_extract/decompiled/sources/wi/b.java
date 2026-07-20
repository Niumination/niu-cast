package wi;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final void a(a aVar, ByteBuffer source) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        while (iRemaining > 0) {
            h hVarL = aVar.l(1);
            int i8 = hVarL.f10778c;
            byte[] data = hVarL.f10776a;
            int iMin = Math.min(iRemaining, data.length - i8);
            source.get(data, i8, iMin);
            iRemaining -= iMin;
            if (iMin == 1) {
                Intrinsics.checkNotNullParameter(data, "data");
                hVarL.f10778c += iMin;
                aVar.f10764c += (long) iMin;
            } else {
                if (iMin < 0 || iMin > hVarL.a()) {
                    StringBuilder sbU = a1.a.u(iMin, "Invalid number of bytes written: ", ". Should be in 0..");
                    sbU.append(hVarL.a());
                    throw new IllegalStateException(sbU.toString().toString());
                }
                if (iMin != 0) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    hVarL.f10778c += iMin;
                    aVar.f10764c += (long) iMin;
                } else if (q.d(hVarL)) {
                    aVar.g();
                }
            }
        }
    }
}
