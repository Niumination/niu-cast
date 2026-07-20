package hg;

import android.net.nsd.NsdServiceInfo;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5352b;

    public /* synthetic */ e(String str, int i8) {
        this.f5351a = i8;
        this.f5352b = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws NoSuchAlgorithmException {
        switch (this.f5351a) {
            case 0:
                wi.k handshakes = (wi.k) obj;
                Intrinsics.checkNotNullParameter(handshakes, "handshakes");
                MessageDigest messageDigest = MessageDigest.getInstance(this.f5352b);
                Intrinsics.checkNotNull(messageDigest);
                ByteBuffer buffer = (ByteBuffer) lg.a.f7423a.R();
                while (!handshakes.T()) {
                    try {
                        Intrinsics.checkNotNullParameter(handshakes, "<this>");
                        Intrinsics.checkNotNullParameter(buffer, "buffer");
                        int iRemaining = buffer.remaining();
                        wi.n.a(handshakes, buffer);
                        if (iRemaining - buffer.remaining() == -1) {
                            byte[] bArrDigest = messageDigest.digest();
                            lg.a.f7423a.h0(buffer);
                            return bArrDigest;
                        }
                        buffer.flip();
                        messageDigest.update(buffer);
                        buffer.clear();
                    } catch (Throwable th2) {
                        lg.a.f7423a.h0(buffer);
                        throw th2;
                    }
                }
                byte[] bArrDigest2 = messageDigest.digest();
                lg.a.f7423a.h0(buffer);
                return bArrDigest2;
            case 1:
                qg.b1 install = (qg.b1) obj;
                Intrinsics.checkNotNullParameter(install, "$this$install");
                install.getClass();
                String str = this.f5352b;
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                install.f9067a = str;
                return Unit.INSTANCE;
            default:
                return Boolean.valueOf(Intrinsics.areEqual(((NsdServiceInfo) obj).getServiceName(), this.f5352b));
        }
    }
}
