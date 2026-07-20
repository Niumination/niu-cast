package ik;

import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(@os.l String str, @os.l String str2) {
        super("Failed to parse date string: \"" + str + "\". Reason: \"" + str2 + '\"');
        kn.l0.p(str, "data");
        kn.l0.p(str2, HomeKeyReceiver.f2161e);
    }
}
