package com.transsion.iotservice.multiscreen.pc.socket;

import a0.e;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.TccpBasicPackParser;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TCCPPacket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import k3.gc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import na.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020!H\u0002J\u0006\u0010)\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/TranTCCPChannel;", "Lcom/transsion/iotservice/multiscreen/pc/socket/ITranChannel;", "<init>", "()V", "packParser", "Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/TccpBasicPackParser;", "msgListener", "Lcom/transsion/iotservice/multiscreen/pc/socket/EventListener;", "getMsgListener", "()Lcom/transsion/iotservice/multiscreen/pc/socket/EventListener;", "setMsgListener", "(Lcom/transsion/iotservice/multiscreen/pc/socket/EventListener;)V", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread", "()Landroid/os/HandlerThread;", "input", "Ljava/io/InputStream;", "getInput", "()Ljava/io/InputStream;", "setInput", "(Ljava/io/InputStream;)V", "output", "Ljava/io/OutputStream;", "getOutput", "()Ljava/io/OutputStream;", "setOutput", "(Ljava/io/OutputStream;)V", "handler", "Landroid/os/Handler;", "sendRequest", "", "operation", "", "payload", "", "sendResponse", "setEventListener", "listener", "sendData", "data", "handleTccp", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class TranTCCPChannel implements ITranChannel {
    private static final String TAG = "TranTCCPChannel";
    private final Handler handler;
    private final HandlerThread handlerThread;
    private InputStream input;
    private EventListener msgListener;
    private OutputStream output;
    private final TccpBasicPackParser packParser = new TccpBasicPackParser();

    public TranTCCPChannel() {
        HandlerThread handlerThread = new HandlerThread("handshake socket");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper());
    }

    private final void sendData(byte[] data) {
        OutputStream outputStream = this.output;
        if (outputStream != null) {
            this.handler.post(new e(24, data, outputStream));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendData$lambda$1$lambda$0(byte[] bArr, OutputStream outputStream) {
        try {
            String string = Arrays.toString(bArr);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String log = "write:" + string;
            Intrinsics.checkNotNullParameter(TAG, "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat(TAG), log);
            }
            outputStream.write(bArr);
            outputStream.flush();
        } catch (IOException e) {
            Intrinsics.checkNotNullParameter(TAG, "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat(TAG), e.getMessage(), e);
        }
    }

    public final HandlerThread getHandlerThread() {
        return this.handlerThread;
    }

    public final InputStream getInput() {
        return this.input;
    }

    public final EventListener getMsgListener() {
        return this.msgListener;
    }

    public final OutputStream getOutput() {
        return this.output;
    }

    public final void handleTccp() throws Exception {
        InputStream inputStream = this.input;
        if (inputStream != null) {
            try {
                TCCPPacket tCCPPacketHandleTccpData = this.packParser.handleTccpData(inputStream);
                if (tCCPPacketHandleTccpData == null) {
                    tCCPPacketHandleTccpData = null;
                } else if (tCCPPacketHandleTccpData.isResp()) {
                    String log = "handleTccp:receive tccp resp:" + tCCPPacketHandleTccpData;
                    Intrinsics.checkNotNullParameter(TAG, "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat(TAG), log);
                    }
                    EventListener eventListener = this.msgListener;
                    if (eventListener != null) {
                        eventListener.onReceiveResponse(tCCPPacketHandleTccpData);
                    }
                } else {
                    String log2 = "handleTccp:receive tccp req:" + tCCPPacketHandleTccpData;
                    Intrinsics.checkNotNullParameter(TAG, "tag");
                    Intrinsics.checkNotNullParameter(log2, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat(TAG), log2);
                    }
                    EventListener eventListener2 = this.msgListener;
                    if (eventListener2 != null) {
                        eventListener2.onReceiveRequest(tCCPPacketHandleTccpData);
                    }
                }
                if (tCCPPacketHandleTccpData != null) {
                    return;
                }
            } catch (Exception e) {
                String log3 = "handleTccpData Exception :" + e;
                Intrinsics.checkNotNullParameter(TAG, "tag");
                Intrinsics.checkNotNullParameter(log3, "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat(TAG), log3);
                }
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter("handleTccp:input is null", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat(TAG), "handleTccp:input is null");
        }
        Unit unit = Unit.INSTANCE;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.ITranChannel
    public void sendRequest(byte[] operation, Object payload) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(payload, "payload");
        String strB = b.b(payload);
        String string = Arrays.toString(operation);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String log = "sendRequest:operation:" + string + ",payload:" + strB;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TAG), log);
        }
        sendData(this.packParser.buildCompleteRequestPack(operation, strB));
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.ITranChannel
    public void sendResponse(byte[] operation, Object payload) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(payload, "payload");
        String strB = b.b(payload);
        String string = Arrays.toString(operation);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String log = "sendResponse:operation:" + string + ",payload:" + strB;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TAG), log);
        }
        sendData(this.packParser.buildCompleteResponsePack(operation, strB));
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.ITranChannel
    public void setEventListener(EventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.msgListener = listener;
    }

    public final void setInput(InputStream inputStream) {
        this.input = inputStream;
    }

    public final void setMsgListener(EventListener eventListener) {
        this.msgListener = eventListener;
    }

    public final void setOutput(OutputStream outputStream) {
        this.output = outputStream;
    }
}
