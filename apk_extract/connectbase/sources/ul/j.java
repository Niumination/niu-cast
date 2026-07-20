package ul;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kn.l0;
import kn.r;
import lm.g2;
import lm.y;
import lm.z0;
import os.l;
import os.m;
import p5.m0;
import tl.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16323a = 1114111;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16324b = 56320;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16325c = 55296;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16326d = 65536;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16327e = 55232;

    @xm.f(c = "io.ktor.utils.io.core.internal.UTF8Kt", f = "UTF8.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {35}, m = "decodeUTF8LineLoopSuspend", n = {"out", "nextChunk", "decoded", ik.f.b.f7973h, "cr", FloatingWindow.f2049c0, "limit"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
    public static final class a extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.g(null, 0, null, this);
        }
    }

    @d
    public static final int a(int i10) {
        int i11 = 0;
        int i12 = 128;
        int i13 = 1;
        while (i13 < 7) {
            i13++;
            if ((i10 & i12) == 0) {
                break;
            }
            i10 &= ~i12;
            i12 >>= 1;
            i11++;
        }
        return i11;
    }

    public static final int b(int i10) {
        if (1 <= i10 && i10 < 128) {
            return 1;
        }
        if (128 <= i10 && i10 < 2048) {
            return 2;
        }
        if (2048 <= i10 && i10 < 65536) {
            return 3;
        }
        if (65536 <= i10 && i10 < 1114112) {
            return 4;
        }
        p(i10);
        throw new y();
    }

    public static final int c(char c10, char c11) {
        return ((c10 - 55232) << 10) | (c11 - r.f9348f);
    }

    public static final boolean d(@l tl.e eVar, @l jn.l<? super Character, Boolean> lVar) {
        l0.p(eVar, "<this>");
        l0.p(lVar, "consumer");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        int i12 = i10;
        while (i12 < i11) {
            int i13 = i12 + 1;
            byte b10 = byteBuffer.get(i12);
            int i14 = b10 & 255;
            if ((b10 & 128) == 128 || !lVar.invoke(Character.valueOf((char) i14)).booleanValue()) {
                eVar.h(i12 - i10);
                return false;
            }
            i12 = i13;
        }
        eVar.h(i11 - i10);
        return true;
    }

    @d
    public static final int e(@l tl.e eVar, @l jn.l<? super Character, Boolean> lVar) throws f {
        l0.p(eVar, "<this>");
        l0.p(lVar, "consumer");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        int i12 = i10;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 < i11) {
            int i16 = i12 + 1;
            byte b10 = byteBuffer.get(i12);
            int i17 = b10 & 255;
            if ((b10 & 128) != 0) {
                int i18 = 1;
                if (i13 == 0) {
                    i15 = i13;
                    int i19 = 128;
                    i14 = i17;
                    while (i18 < 7) {
                        i18++;
                        if ((i14 & i19) == 0) {
                            break;
                        }
                        i14 &= ~i19;
                        i19 >>= 1;
                        i15++;
                    }
                    i13 = i15 - 1;
                    if (i15 > i11 - i12) {
                        eVar.h(i12 - i10);
                        return i15;
                    }
                } else {
                    i14 = (i14 << 6) | (b10 & 127);
                    i13--;
                    if (i13 != 0) {
                        continue;
                    } else {
                        if (l(i14)) {
                            if (!lVar.invoke(Character.valueOf((char) i14)).booleanValue()) {
                                eVar.h(((i12 - i10) - i15) + 1);
                                return -1;
                            }
                        } else {
                            if (!m(i14)) {
                                p(i14);
                                throw new y();
                            }
                            if (!lVar.invoke(Character.valueOf((char) k(i14))).booleanValue() || !lVar.invoke(Character.valueOf((char) n(i14))).booleanValue()) {
                                eVar.h(((i12 - i10) - i15) + 1);
                                return -1;
                            }
                        }
                        i14 = 0;
                    }
                }
            } else {
                if (i13 != 0) {
                    o(i13);
                    throw new y();
                }
                if (!lVar.invoke(Character.valueOf((char) i17)).booleanValue()) {
                    eVar.h(i12 - i10);
                    return -1;
                }
            }
            i12 = i16;
        }
        eVar.h(i11 - i10);
        return 0;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final int f(o0 o0Var, jn.l<? super Character, Boolean> lVar) throws f {
        l0.p(o0Var, "<this>");
        l0.p(lVar, "consumer");
        ByteBuffer byteBuffer = o0Var.f15820a;
        tl.m mVar = o0Var.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        int i12 = i10;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 < i11) {
            int i16 = i12 + 1;
            byte b10 = byteBuffer.get(i12);
            int i17 = b10 & 255;
            if ((b10 & 128) != 0) {
                int i18 = 1;
                if (i13 == 0) {
                    i15 = i13;
                    int i19 = 128;
                    i14 = i17;
                    while (i18 < 7) {
                        i18++;
                        if ((i14 & i19) == 0) {
                            break;
                        }
                        i14 &= ~i19;
                        i19 >>= 1;
                        i15++;
                    }
                    i13 = i15 - 1;
                    if (i15 > i11 - i12) {
                        o0Var.h(i12 - i10);
                        return i15;
                    }
                } else {
                    i14 = (i14 << 6) | (b10 & 127);
                    i13--;
                    if (i13 != 0) {
                        continue;
                    } else if (l(i14)) {
                        if (!lVar.invoke(Character.valueOf((char) i14)).booleanValue()) {
                            o0Var.h(((i12 - i10) - i15) + 1);
                            return -1;
                        }
                        i14 = 0;
                    } else {
                        if (!m(i14)) {
                            p(i14);
                            throw new y();
                        }
                        if (!lVar.invoke(Character.valueOf((char) k(i14))).booleanValue() || !lVar.invoke(Character.valueOf((char) n(i14))).booleanValue()) {
                            o0Var.h(((i12 - i10) - i15) + 1);
                            return -1;
                        }
                        i14 = 0;
                    }
                }
                i12 = i16;
            } else {
                if (i13 != 0) {
                    o(i13);
                    throw new y();
                }
                if (!lVar.invoke(Character.valueOf((char) i17)).booleanValue()) {
                    o0Var.h(i12 - i10);
                    return -1;
                }
                i12 = i16;
            }
        }
        o0Var.h(i11 - i10);
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:261:0x0192 A[EDGE_INSN: B:261:0x0192->B:79:0x0192 BREAK  A[LOOP:2: B:74:0x017a->B:78:0x0185], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x017d A[Catch: all -> 0x0117, TryCatch #4 {all -> 0x0117, blocks: (B:37:0x00ec, B:40:0x0108, B:47:0x0114, B:59:0x0132, B:159:0x0303, B:161:0x0309, B:162:0x030c, B:169:0x0319, B:165:0x0312, B:50:0x011a, B:55:0x0127, B:56:0x012c, B:58:0x0130, B:62:0x013d, B:64:0x0141, B:67:0x0150, B:68:0x0167, B:69:0x0168, B:70:0x0170, B:71:0x0171, B:73:0x0175, B:76:0x017d, B:78:0x0185, B:79:0x0192, B:81:0x01a4, B:83:0x01b1, B:85:0x01c5, B:87:0x01cd, B:93:0x01d7, B:101:0x01f2, B:94:0x01da, B:150:0x02a7, B:97:0x01e7, B:98:0x01ec, B:100:0x01f0, B:102:0x01fc, B:104:0x0200, B:106:0x020b, B:107:0x0222, B:108:0x0223, B:110:0x022d, B:116:0x023b, B:146:0x028f, B:117:0x023e, B:130:0x0264, B:136:0x0274, B:137:0x0277, B:142:0x0284, B:143:0x0289, B:145:0x028d, B:147:0x0299, B:149:0x029d, B:151:0x02aa, B:152:0x02c1, B:122:0x024b, B:123:0x0250, B:125:0x0254, B:127:0x0258, B:129:0x025c, B:153:0x02c2, B:154:0x02d9, B:155:0x02da, B:156:0x02e4, B:158:0x02f4), top: B:229:0x00ec }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0185 A[Catch: all -> 0x0117, LOOP:2: B:74:0x017a->B:78:0x0185, LOOP_END, TryCatch #4 {all -> 0x0117, blocks: (B:37:0x00ec, B:40:0x0108, B:47:0x0114, B:59:0x0132, B:159:0x0303, B:161:0x0309, B:162:0x030c, B:169:0x0319, B:165:0x0312, B:50:0x011a, B:55:0x0127, B:56:0x012c, B:58:0x0130, B:62:0x013d, B:64:0x0141, B:67:0x0150, B:68:0x0167, B:69:0x0168, B:70:0x0170, B:71:0x0171, B:73:0x0175, B:76:0x017d, B:78:0x0185, B:79:0x0192, B:81:0x01a4, B:83:0x01b1, B:85:0x01c5, B:87:0x01cd, B:93:0x01d7, B:101:0x01f2, B:94:0x01da, B:150:0x02a7, B:97:0x01e7, B:98:0x01ec, B:100:0x01f0, B:102:0x01fc, B:104:0x0200, B:106:0x020b, B:107:0x0222, B:108:0x0223, B:110:0x022d, B:116:0x023b, B:146:0x028f, B:117:0x023e, B:130:0x0264, B:136:0x0274, B:137:0x0277, B:142:0x0284, B:143:0x0289, B:145:0x028d, B:147:0x0299, B:149:0x029d, B:151:0x02aa, B:152:0x02c1, B:122:0x024b, B:123:0x0250, B:125:0x0254, B:127:0x0258, B:129:0x025c, B:153:0x02c2, B:154:0x02d9, B:155:0x02da, B:156:0x02e4, B:158:0x02f4), top: B:229:0x00ec }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009c -> B:23:0x00a1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @ul.d
    public static final java.lang.Object g(@os.l java.lang.Appendable r25, int r26, @os.l jn.p<? super java.lang.Integer, ? super um.d<? super tl.a>, ? extends java.lang.Object> r27, @os.l um.d<? super java.lang.Boolean> r28) {
        /*
            Method dump skipped, instruction units count: 947
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ul.j.g(java.lang.Appendable, int, jn.p, um.d):java.lang.Object");
    }

    public static final int h(@l ByteBuffer byteBuffer, @l CharSequence charSequence, int i10, int i11, int i12, int i13) {
        l0.p(byteBuffer, "$this$encodeUTF8");
        l0.p(charSequence, "text");
        int iMin = Math.min(i11, i10 + 65535);
        int i14 = i13 > 65535 ? 65535 : i13;
        int i15 = i10;
        int i16 = i12;
        while (i16 < i14 && i15 < iMin) {
            int i17 = i15 + 1;
            char cCharAt = charSequence.charAt(i15);
            int i18 = cCharAt & r.f9345c;
            if ((cCharAt & 65408) != 0) {
                return i(byteBuffer, charSequence, i15, iMin, i10, i16, i14, i12);
            }
            byteBuffer.put(i16, (byte) i18);
            i15 = i17;
            i16++;
        }
        return e.e(g2.m((short) (i15 - i10)), (short) (i16 - i12));
    }

    public static final int i(ByteBuffer byteBuffer, CharSequence charSequence, int i10, int i11, int i12, int i13, int i14, int i15) {
        int iC;
        int i16;
        int i17 = i14 - 3;
        int i18 = i10;
        int i19 = i13;
        while (i17 - i19 > 0 && i18 < i11) {
            int i20 = i18 + 1;
            char cCharAt = charSequence.charAt(i18);
            if (!Character.isHighSurrogate(cCharAt)) {
                i18 = i20;
                iC = cCharAt;
            } else if (i20 == i11 || !Character.isLowSurrogate(charSequence.charAt(i20))) {
                i18 = i20;
                iC = 63;
            } else {
                i18 += 2;
                iC = c(cCharAt, charSequence.charAt(i20));
            }
            if (iC >= 0 && iC < 128) {
                byteBuffer.put(i19, (byte) iC);
                i16 = 1;
            } else if (128 <= iC && iC < 2048) {
                byteBuffer.put(i19, (byte) (((iC >> 6) & 31) | 192));
                byteBuffer.put(i19 + 1, (byte) (128 | (iC & 63)));
                i16 = 2;
            } else if (2048 <= iC && iC < 65536) {
                byteBuffer.put(i19, (byte) (((iC >> 12) & 15) | 224));
                byteBuffer.put(i19 + 1, (byte) ((63 & (iC >> 6)) | 128));
                byteBuffer.put(i19 + 2, (byte) (128 | (iC & 63)));
                i16 = 3;
            } else {
                if (65536 > iC || iC >= 1114112) {
                    p(iC);
                    throw new y();
                }
                byteBuffer.put(i19, (byte) (((iC >> 18) & 7) | m0.f12864d));
                byteBuffer.put(i19 + 1, (byte) (((iC >> 12) & 63) | 128));
                byteBuffer.put(i19 + 2, (byte) ((63 & (iC >> 6)) | 128));
                byteBuffer.put(i19 + 3, (byte) (128 | (iC & 63)));
                i16 = 4;
            }
            i19 += i16;
        }
        return i19 == i17 ? j(byteBuffer, charSequence, i18, i11, i12, i19, i14, i15) : e.e(g2.m((short) (i18 - i12)), (short) (i19 - i15));
    }

    public static final int j(ByteBuffer byteBuffer, CharSequence charSequence, int i10, int i11, int i12, int i13, int i14, int i15) {
        int iC;
        int i16;
        int i17;
        int i18 = i10;
        int i19 = i13;
        while (true) {
            int i20 = i14 - i19;
            if (i20 <= 0 || i18 >= i11) {
                break;
            }
            int i21 = i18 + 1;
            char cCharAt = charSequence.charAt(i18);
            if (!Character.isHighSurrogate(cCharAt)) {
                i18 = i21;
                iC = cCharAt;
            } else if (i21 == i11 || !Character.isLowSurrogate(charSequence.charAt(i21))) {
                i18 = i21;
                iC = 63;
            } else {
                i18 += 2;
                iC = c(cCharAt, charSequence.charAt(i21));
            }
            if (1 <= iC && iC < 128) {
                i16 = 1;
            } else if (128 <= iC && iC < 2048) {
                i16 = 2;
            } else if (2048 <= iC && iC < 65536) {
                i16 = 3;
            } else {
                if (65536 > iC || iC >= 1114112) {
                    p(iC);
                    throw new y();
                }
                i16 = 4;
            }
            if (i16 > i20) {
                i18--;
                break;
            }
            if (iC >= 0 && iC < 128) {
                byteBuffer.put(i19, (byte) iC);
                i17 = 1;
            } else if (128 <= iC && iC < 2048) {
                byteBuffer.put(i19, (byte) (((iC >> 6) & 31) | 192));
                byteBuffer.put(i19 + 1, (byte) ((iC & 63) | 128));
                i17 = 2;
            } else if (2048 <= iC && iC < 65536) {
                byteBuffer.put(i19, (byte) (((iC >> 12) & 15) | 224));
                byteBuffer.put(i19 + 1, (byte) (((iC >> 6) & 63) | 128));
                byteBuffer.put(i19 + 2, (byte) ((iC & 63) | 128));
                i17 = 3;
            } else {
                if (65536 > iC || iC >= 1114112) {
                    p(iC);
                    throw new y();
                }
                byteBuffer.put(i19, (byte) (((iC >> 18) & 7) | m0.f12864d));
                byteBuffer.put(i19 + 1, (byte) (((iC >> 12) & 63) | 128));
                byteBuffer.put(i19 + 2, (byte) (((iC >> 6) & 63) | 128));
                byteBuffer.put(i19 + 3, (byte) ((iC & 63) | 128));
                i17 = 4;
            }
            i19 += i17;
        }
        return e.e(g2.m((short) (i18 - i12)), (short) (i19 - i15));
    }

    @z0
    public static final int k(int i10) {
        return (i10 >>> 10) + 55232;
    }

    @z0
    public static final boolean l(int i10) {
        return (i10 >>> 16) == 0;
    }

    @z0
    public static final boolean m(int i10) {
        return i10 <= 1114111;
    }

    @z0
    public static final int n(int i10) {
        return (i10 & 1023) + 56320;
    }

    @z0
    @l
    public static final Void o(int i10) throws f {
        throw new f(k.b.a("Expected ", i10, " more character bytes"));
    }

    @z0
    @l
    public static final Void p(int i10) {
        throw new IllegalArgumentException(k.b.a("Malformed code-point ", i10, " found"));
    }

    public static final Void q(int i10) throws EOFException {
        throw new EOFException(k.b.a("Premature end of stream: expected ", i10, " bytes to decode UTF-8 char"));
    }

    public static final int r(@l ByteBuffer byteBuffer, int i10, int i11) {
        l0.p(byteBuffer, "$this$putUtf8Char");
        if (i11 >= 0 && i11 < 128) {
            byteBuffer.put(i10, (byte) i11);
            return 1;
        }
        if (128 <= i11 && i11 < 2048) {
            byteBuffer.put(i10, (byte) (((i11 >> 6) & 31) | 192));
            byteBuffer.put(i10 + 1, (byte) ((i11 & 63) | 128));
            return 2;
        }
        if (2048 <= i11 && i11 < 65536) {
            byteBuffer.put(i10, (byte) (((i11 >> 12) & 15) | 224));
            byteBuffer.put(i10 + 1, (byte) (((i11 >> 6) & 63) | 128));
            byteBuffer.put(i10 + 2, (byte) ((i11 & 63) | 128));
            return 3;
        }
        if (65536 > i11 || i11 >= 1114112) {
            p(i11);
            throw new y();
        }
        byteBuffer.put(i10, (byte) (((i11 >> 18) & 7) | m0.f12864d));
        byteBuffer.put(i10 + 1, (byte) (((i11 >> 12) & 63) | 128));
        byteBuffer.put(i10 + 2, (byte) (((i11 >> 6) & 63) | 128));
        byteBuffer.put(i10 + 3, (byte) ((i11 & 63) | 128));
        return 4;
    }
}
