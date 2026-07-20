package com.transsion.iotservice.multiscreen.pc.socket;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TCCPPacket;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/EventListener;", "", "onConnected", "", "onDisconnected", "onReceiveRequest", "request", "Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TCCPPacket;", "onReceiveResponse", "response", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface EventListener {
    void onConnected();

    void onDisconnected();

    void onReceiveRequest(TCCPPacket request);

    void onReceiveResponse(TCCPPacket response);
}
