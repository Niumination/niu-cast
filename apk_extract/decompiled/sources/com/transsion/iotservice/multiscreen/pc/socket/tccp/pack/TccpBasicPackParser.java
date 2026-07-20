package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TCCPPacket;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.util.CrcUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import k3.gc;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/TccpBasicPackParser;", "", "<init>", "()V", "mHandShakeSuccessTime", "", "handleTccpData", "Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TCCPPacket;", "dis", "Ljava/io/InputStream;", "handlerTccpRequestData", "dataInputStream", "Ljava/io/DataInputStream;", "handlerTccpResponseData", "buildCompleteRequestPack", "", "operationFlag", "payloadJson", "", "buildCompleteResponsePack", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TccpBasicPackParser {
    private static final String TCCP_TAG = "tccp_tag";
    private long mHandShakeSuccessTime;

    private final TCCPPacket handlerTccpRequestData(DataInputStream dataInputStream) throws IOException {
        dataInputStream.readByte();
        int i8 = dataInputStream.readInt();
        byte[] bArr = new byte[2];
        dataInputStream.readFully(bArr);
        int i9 = dataInputStream.readInt();
        long j8 = dataInputStream.readLong();
        byte[] bArr2 = new byte[i8 - 15];
        dataInputStream.readFully(bArr2);
        byte b9 = dataInputStream.readByte();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.write(bArr);
        dataOutputStream.writeInt(i9);
        dataOutputStream.writeLong(j8);
        dataOutputStream.write(bArr2);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        dataOutputStream.flush();
        dataOutputStream.close();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        String log = d.f(b9, CrcUtils.calcCrc8(byteArray), "handlerTccpRequestData 读取到的crc：", " , 计算得到的crc: ");
        Intrinsics.checkNotNullParameter(TCCP_TAG, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TCCP_TAG), log);
        }
        return new TCCPPacket(false, bArr, null, new String(bArr2, Charsets.UTF_8));
    }

    private final TCCPPacket handlerTccpResponseData(DataInputStream dataInputStream) throws IOException {
        dataInputStream.readByte();
        int i8 = dataInputStream.readInt();
        short s2 = dataInputStream.readShort();
        int i9 = dataInputStream.readInt();
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        long j8 = dataInputStream.readLong();
        byte[] bArr2 = new byte[i8 - 19];
        dataInputStream.readFully(bArr2);
        byte b9 = dataInputStream.readByte();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(s2);
        dataOutputStream.writeInt(i9);
        dataOutputStream.write(bArr);
        dataOutputStream.writeLong(j8);
        dataOutputStream.write(bArr2);
        dataOutputStream.flush();
        dataOutputStream.close();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        String log = d.f(b9, b9, "handlerTccpResponseData 读取到的crc：", " , 计算得到的crc: ");
        Intrinsics.checkNotNullParameter(TCCP_TAG, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TCCP_TAG), log);
        }
        return new TCCPPacket(true, ArraysKt.copyOfRange(bArr, 0, 2), Integer.valueOf(s2), new String(bArr2, Charsets.UTF_8));
    }

    public final byte[] buildCompleteRequestPack(byte[] operationFlag, String payloadJson) throws IOException {
        Intrinsics.checkNotNullParameter(operationFlag, "operationFlag");
        Intrinsics.checkNotNullParameter(payloadJson, "payloadJson");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        TccpConfig tccpConfig = TccpConfig.INSTANCE;
        dataOutputStream.write(tccpConfig.getTCCP_REQUEST_HEADER());
        dataOutputStream.write(tccpConfig.getTCCP_VERSION());
        byte[] bytes = payloadJson.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        dataOutputStream.writeInt(bytes.length + 15);
        dataOutputStream.write(operationFlag);
        dataOutputStream.writeInt((int) (System.currentTimeMillis() - this.mHandShakeSuccessTime));
        dataOutputStream.writeLong(System.currentTimeMillis() - this.mHandShakeSuccessTime);
        dataOutputStream.write(bytes);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNull(byteArray);
        byte bCalcCrc8 = CrcUtils.calcCrc8(ArraysKt.copyOfRange(byteArray, 9, byteArray.length));
        dataOutputStream.writeByte(bCalcCrc8);
        String strM = d.m("构建完整的tccp请求包 写入的CRC: ", TCCP_TAG, "tag", "log", bCalcCrc8);
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TCCP_TAG), strM);
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        dataOutputStream.close();
        Intrinsics.checkNotNull(byteArray2);
        return byteArray2;
    }

    public final byte[] buildCompleteResponsePack(byte[] operationFlag, String payloadJson) throws IOException {
        Intrinsics.checkNotNullParameter(operationFlag, "operationFlag");
        Intrinsics.checkNotNullParameter(payloadJson, "payloadJson");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        TccpConfig tccpConfig = TccpConfig.INSTANCE;
        dataOutputStream.write(tccpConfig.getTCCP_RESPONSE_HEADER());
        dataOutputStream.write(tccpConfig.getTCCP_VERSION());
        byte[] bytes = payloadJson.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        dataOutputStream.writeInt(bytes.length + 19);
        dataOutputStream.writeShort(200);
        dataOutputStream.writeInt((int) (System.currentTimeMillis() - this.mHandShakeSuccessTime));
        dataOutputStream.write(ArraysKt.plus(operationFlag, new byte[]{37, 37}));
        dataOutputStream.writeLong(System.currentTimeMillis() - this.mHandShakeSuccessTime);
        dataOutputStream.write(bytes);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNull(byteArray);
        byte bCalcCrc8 = CrcUtils.calcCrc8(ArraysKt.copyOfRange(byteArray, 9, byteArray.length));
        dataOutputStream.writeByte(bCalcCrc8);
        String strM = d.m("构建完整的Tccp响应包 写入的CRC: ", TCCP_TAG, "tag", "log", bCalcCrc8);
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat(TCCP_TAG), strM);
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        dataOutputStream.close();
        Intrinsics.checkNotNull(byteArray2);
        return byteArray2;
    }

    public final TCCPPacket handleTccpData(InputStream dis) {
        Intrinsics.checkNotNullParameter(dis, "dis");
        gc.a(TCCP_TAG, "handleTccpData ");
        DataInputStream dataInputStream = new DataInputStream(dis);
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        String string = Arrays.toString(bArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        gc.a(TCCP_TAG, "first4ByteArray:" + string);
        String string2 = Arrays.toString(bArr);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        TccpConfig tccpConfig = TccpConfig.INSTANCE;
        String string3 = Arrays.toString(tccpConfig.getTCCP_REQUEST_HEADER());
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        if (Intrinsics.areEqual(string2, string3)) {
            return handlerTccpRequestData(dataInputStream);
        }
        String string4 = Arrays.toString(tccpConfig.getTCCP_RESPONSE_HEADER());
        Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
        if (Intrinsics.areEqual(string2, string4)) {
            return handlerTccpResponseData(dataInputStream);
        }
        gc.b(TCCP_TAG, "PackType.UNKNOWN");
        return null;
    }
}
