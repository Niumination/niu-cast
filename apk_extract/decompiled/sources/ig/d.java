package ig;

import gg.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wi.h;
import wi.j;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f5867b;

    public /* synthetic */ d(int i8, long j8) {
        this.f5866a = i8;
        this.f5867b = j8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f5866a) {
            case 0:
                j cipherLoop = (j) obj;
                Intrinsics.checkNotNullParameter(cipherLoop, "$this$cipherLoop");
                wi.a aVar = (wi.a) cipherLoop;
                h hVarL = aVar.l(8);
                int i8 = hVarL.f10778c;
                long j8 = this.f5867b;
                byte[] bArr = hVarL.f10776a;
                bArr[i8] = (byte) ((j8 >>> 56) & 255);
                bArr[i8 + 1] = (byte) ((j8 >>> 48) & 255);
                bArr[i8 + 2] = (byte) ((j8 >>> 40) & 255);
                bArr[i8 + 3] = (byte) ((j8 >>> 32) & 255);
                bArr[i8 + 4] = (byte) ((j8 >>> 24) & 255);
                bArr[i8 + 5] = (byte) ((j8 >>> 16) & 255);
                bArr[i8 + 6] = (byte) ((j8 >>> 8) & 255);
                bArr[i8 + 7] = (byte) (j8 & 255);
                hVarL.f10778c = i8 + 8;
                aVar.f10764c += 8;
                break;
            default:
                ((x) obj).f5206d = this.f5867b;
                break;
        }
        return Unit.INSTANCE;
    }
}
