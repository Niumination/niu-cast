package com.transsion.iotservice.multiscreen.pc.socket;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/IHandshakeChannelServer;", "Lcom/transsion/iotservice/multiscreen/pc/socket/ITranChannel;", "startServer", "", "port", "", "releaseServer", "quietlyExit", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface IHandshakeChannelServer extends ITranChannel {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        public static /* synthetic */ void releaseServer$default(IHandshakeChannelServer iHandshakeChannelServer, boolean z2, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: releaseServer");
            }
            if ((i8 & 1) != 0) {
                z2 = false;
            }
            iHandshakeChannelServer.releaseServer(z2);
        }
    }

    void releaseServer(boolean quietlyExit);

    void startServer(int port);
}
