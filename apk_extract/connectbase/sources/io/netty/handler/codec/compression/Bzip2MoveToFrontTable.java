package io.netty.handler.codec.compression;

import c1.c;
import fl.h;
import io.netty.handler.codec.http.HttpConstants;
import kk.k;
import o1.t;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2MoveToFrontTable {
    private final byte[] mtf = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, c.f1119m, c.f1120n, 13, c.f1122p, c.f1123q, c.f1124r, 17, c.f1127u, 19, c.f1130x, c.f1131y, c.f1132z, c.A, c.B, c.C, c.D, c.E, c.F, c.G, c.H, c.I, 32, 33, HttpConstants.DOUBLE_QUOTE, 35, 36, 37, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, k.f9234c, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, 62, h.f6042b, t.f12049a, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, -128, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -117, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -106, -105, -104, -103, -102, -101, -100, -99, -98, -97, -96, -95, -94, -93, -92, -91, -90, -89, -88, -87, -86, -85, -84, -83, -82, -81, -80, -79, -78, -77, -76, -75, -74, -73, -72, -71, -70, -69, -68, -67, -66, -65, -64, -63, -62, -61, -60, -59, -58, -57, -56, -55, -54, -53, -52, -51, -50, -49, -48, -47, -46, -45, -44, -43, -42, -41, -40, -39, -38, -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1};

    public byte indexToFront(int i10) {
        byte[] bArr = this.mtf;
        byte b10 = bArr[i10];
        System.arraycopy(bArr, 0, bArr, 1, i10);
        this.mtf[0] = b10;
        return b10;
    }

    public int valueToFront(byte b10) {
        byte[] bArr = this.mtf;
        int i10 = 0;
        byte b11 = bArr[0];
        if (b10 != b11) {
            bArr[0] = b10;
            while (b10 != b11) {
                i10++;
                byte[] bArr2 = this.mtf;
                byte b12 = bArr2[i10];
                bArr2[i10] = b11;
                b11 = b12;
            }
        }
        return i10;
    }
}
