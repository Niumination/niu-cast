package com.transsion.iotservice.multiscreen.pc.socket.tccp.util;

import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public class CrcUtils {
    public static byte calcCrc8(byte[] bArr) {
        byte b9 = 0;
        for (byte b10 : bArr) {
            b9 = (byte) (b9 ^ b10);
            for (int i8 = 0; i8 < 8; i8++) {
                b9 = (byte) ((b9 & ByteCompanionObject.MIN_VALUE) != 0 ? ((byte) (b9 << 1)) ^ 263 : b9 << 1);
            }
        }
        return b9;
    }
}
