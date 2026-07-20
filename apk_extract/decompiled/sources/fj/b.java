package fj;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.transsion.message.bank.MessageBank;
import dj.c;
import dj.d0;
import dj.e0;
import dj.i0;
import dj.j0;
import dj.l0;
import dj.m0;
import dj.r;
import dj.s;
import dj.v;
import dj.w;
import hj.i;
import ij.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements w {
    /* JADX WARN: Code duplicated, block: B:100:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:133:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:135:0x02c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:139:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:141:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:144:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:164:0x033e  */
    /* JADX WARN: Code duplicated, block: B:177:0x039c  */
    /* JADX WARN: Code duplicated, block: B:179:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:183:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x008c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x0094 A[EDGE_INSN: B:199:0x0094->B:26:0x0094 BREAK  A[LOOP:2: B:20:0x0072->B:24:0x0085], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x006d  */
    /* JADX WARN: Code duplicated, block: B:206:0x0337 A[EDGE_INSN: B:206:0x0337->B:162:0x0337 BREAK  A[LOOP:5: B:142:0x02e9->B:161:0x0332], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0074  */
    /* JADX WARN: Code duplicated, block: B:24:0x0085 A[LOOP:2: B:20:0x0072->B:24:0x0085, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:30:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x014b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0159  */
    /* JADX WARN: Code duplicated, block: B:67:0x015d  */
    /* JADX WARN: Code duplicated, block: B:69:0x0165  */
    /* JADX WARN: Code duplicated, block: B:70:0x0169  */
    /* JADX WARN: Code duplicated, block: B:72:0x0171  */
    /* JADX WARN: Code duplicated, block: B:74:0x017b  */
    /* JADX WARN: Code duplicated, block: B:76:0x0184  */
    /* JADX WARN: Code duplicated, block: B:77:0x018b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0193  */
    /* JADX WARN: Code duplicated, block: B:80:0x0197  */
    /* JADX WARN: Code duplicated, block: B:82:0x019f  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:86:0x01af  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:92:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:94:0x01db  */
    /* JADX WARN: Code duplicated, block: B:95:0x01de  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:98:0x01e9  */
    @Override // dj.w
    public final j0 intercept(v chain) {
        i1.b bVar;
        i1.b bVar2;
        i call;
        e0 e0Var;
        j0 cachedResponse;
        j0 j0VarB;
        m0 m0Var;
        r rVar;
        s sVar;
        int size;
        int i8;
        s sVar2;
        int size2;
        int i9;
        String strF;
        String strF2;
        String strH;
        i1.b bVar3;
        s sVar3;
        int i10;
        int i11;
        int length;
        int length2;
        i1.b bVar4;
        s sVar4;
        String strSubstring;
        String string;
        int i12;
        boolean z2;
        int i13;
        String string2;
        byte b9;
        int i14;
        Intrinsics.checkNotNullParameter(chain, "chain");
        f fVar = (f) chain;
        System.currentTimeMillis();
        e0 request = fVar.f;
        Intrinsics.checkNotNullParameter(request, "request");
        i1.b bVar5 = new i1.b(request, null);
        if (request != null) {
            c cVar = request.f4527a;
            if (cVar == null) {
                int i15 = c.f4515n;
                s headers = request.f4530d;
                Intrinsics.checkNotNullParameter(headers, "headers");
                int size3 = headers.size();
                String str = null;
                int i16 = 0;
                boolean z3 = true;
                boolean z5 = false;
                boolean z10 = false;
                int iX = -1;
                int iX2 = -1;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                int iX3 = -1;
                int iX4 = -1;
                boolean z14 = false;
                boolean z15 = false;
                boolean z16 = false;
                while (i16 < size3) {
                    String strF3 = headers.f(i16);
                    String indexOfNonWhitespace = headers.h(i16);
                    if (StringsKt__StringsJVMKt.equals(strF3, "Cache-Control", true)) {
                        if (str == null) {
                            str = indexOfNonWhitespace;
                        }
                        i11 = 0;
                        while (i11 < indexOfNonWhitespace.length()) {
                            length = indexOfNonWhitespace.length();
                            length2 = i11;
                            while (true) {
                                if (length2 < length) {
                                    bVar4 = bVar5;
                                    sVar4 = headers;
                                    length2 = indexOfNonWhitespace.length();
                                    break;
                                }
                                bVar4 = bVar5;
                                sVar4 = headers;
                                if (StringsKt__StringsKt.contains$default("=,;", indexOfNonWhitespace.charAt(length2), false, 2, (Object) null)) {
                                    break;
                                }
                                length2++;
                                headers = sVar4;
                                bVar5 = bVar4;
                            }
                            strSubstring = indexOfNonWhitespace.substring(i11, length2);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            if (strSubstring != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            string = StringsKt__StringsKt.trim((CharSequence) strSubstring).toString();
                            if (length2 != indexOfNonWhitespace.length()) {
                                i12 = size3;
                                if (indexOfNonWhitespace.charAt(length2) == ',' && indexOfNonWhitespace.charAt(length2) != ';') {
                                    int length3 = length2 + 1;
                                    byte[] bArr = ej.b.f4964a;
                                    Intrinsics.checkNotNullParameter(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
                                    int length4 = indexOfNonWhitespace.length();
                                    while (true) {
                                        if (length3 >= length4) {
                                            i14 = 1;
                                            length3 = indexOfNonWhitespace.length();
                                            break;
                                        }
                                        char cCharAt = indexOfNonWhitespace.charAt(length3);
                                        int i17 = length4;
                                        if (cCharAt != ' ' && cCharAt != '\t') {
                                            i14 = 1;
                                            break;
                                        }
                                        length3++;
                                        length4 = i17;
                                    }
                                    if (length3 < indexOfNonWhitespace.length()) {
                                        z2 = z3;
                                        if (indexOfNonWhitespace.charAt(length3) == '\"') {
                                            int i18 = length3 + i14;
                                            int iIndexOf$default = StringsKt__StringsKt.indexOf$default(indexOfNonWhitespace, Typography.quote, i18, false, 4, (Object) null);
                                            String strSubstring2 = indexOfNonWhitespace.substring(i18, iIndexOf$default);
                                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                            string2 = strSubstring2;
                                            i13 = iIndexOf$default + i14;
                                        }
                                    } else {
                                        z2 = z3;
                                    }
                                    int length5 = indexOfNonWhitespace.length();
                                    int length6 = length3;
                                    while (true) {
                                        if (length6 >= length5) {
                                            length6 = indexOfNonWhitespace.length();
                                            break;
                                        }
                                        int i19 = length5;
                                        if (StringsKt__StringsKt.contains$default(",;", indexOfNonWhitespace.charAt(length6), false, 2, (Object) null)) {
                                            break;
                                        }
                                        length6++;
                                        length5 = i19;
                                    }
                                    String strSubstring3 = indexOfNonWhitespace.substring(length3, length6);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring3 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string2 = StringsKt__StringsKt.trim((CharSequence) strSubstring3).toString();
                                    i13 = length6;
                                }
                                if (StringsKt__StringsJVMKt.equals("no-cache", string, true)) {
                                    z5 = true;
                                } else if (StringsKt__StringsJVMKt.equals("no-store", string, true)) {
                                    z10 = true;
                                } else if (StringsKt__StringsJVMKt.equals("max-age", string, true)) {
                                    b9 = -1;
                                    iX = ej.b.x(-1, string2);
                                } else {
                                    b9 = -1;
                                    if (StringsKt__StringsJVMKt.equals("s-maxage", string, true)) {
                                        iX2 = ej.b.x(-1, string2);
                                    } else if (StringsKt__StringsJVMKt.equals("private", string, true)) {
                                        z11 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("public", string, true)) {
                                        z12 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("must-revalidate", string, true)) {
                                        z13 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("max-stale", string, true)) {
                                        iX3 = ej.b.x(Integer.MAX_VALUE, string2);
                                    } else if (StringsKt__StringsJVMKt.equals("min-fresh", string, true)) {
                                        iX4 = ej.b.x(-1, string2);
                                    } else if (StringsKt__StringsJVMKt.equals("only-if-cached", string, true)) {
                                        z14 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("no-transform", string, true)) {
                                        z15 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("immutable", string, true)) {
                                        z16 = true;
                                    }
                                }
                                i11 = i13;
                                headers = sVar4;
                                bVar5 = bVar4;
                                size3 = i12;
                                z3 = z2;
                            } else {
                                i12 = size3;
                            }
                            z2 = z3;
                            i13 = length2 + 1;
                            string2 = null;
                            if (StringsKt__StringsJVMKt.equals("no-cache", string, true)) {
                                z5 = true;
                            } else if (StringsKt__StringsJVMKt.equals("no-store", string, true)) {
                                z10 = true;
                            } else if (StringsKt__StringsJVMKt.equals("max-age", string, true)) {
                                b9 = -1;
                                iX = ej.b.x(-1, string2);
                            } else {
                                b9 = -1;
                                if (StringsKt__StringsJVMKt.equals("s-maxage", string, true)) {
                                    iX2 = ej.b.x(-1, string2);
                                } else if (StringsKt__StringsJVMKt.equals("private", string, true)) {
                                    z11 = true;
                                } else if (StringsKt__StringsJVMKt.equals("public", string, true)) {
                                    z12 = true;
                                } else if (StringsKt__StringsJVMKt.equals("must-revalidate", string, true)) {
                                    z13 = true;
                                } else if (StringsKt__StringsJVMKt.equals("max-stale", string, true)) {
                                    iX3 = ej.b.x(Integer.MAX_VALUE, string2);
                                } else if (StringsKt__StringsJVMKt.equals("min-fresh", string, true)) {
                                    iX4 = ej.b.x(-1, string2);
                                } else if (StringsKt__StringsJVMKt.equals("only-if-cached", string, true)) {
                                    z14 = true;
                                } else if (StringsKt__StringsJVMKt.equals("no-transform", string, true)) {
                                    z15 = true;
                                } else if (StringsKt__StringsJVMKt.equals("immutable", string, true)) {
                                    z16 = true;
                                }
                            }
                            i11 = i13;
                            headers = sVar4;
                            bVar5 = bVar4;
                            size3 = i12;
                            z3 = z2;
                        }
                        bVar3 = bVar5;
                        sVar3 = headers;
                        i10 = size3;
                        i16++;
                        headers = sVar3;
                        bVar5 = bVar3;
                        size3 = i10;
                    } else {
                        if (!StringsKt__StringsJVMKt.equals(strF3, "Pragma", true)) {
                            bVar3 = bVar5;
                            sVar3 = headers;
                            i10 = size3;
                        }
                        i16++;
                        headers = sVar3;
                        bVar5 = bVar3;
                        size3 = i10;
                    }
                    z3 = false;
                    i11 = 0;
                    while (i11 < indexOfNonWhitespace.length()) {
                        length = indexOfNonWhitespace.length();
                        length2 = i11;
                        while (true) {
                            if (length2 < length) {
                                bVar4 = bVar5;
                                sVar4 = headers;
                                length2 = indexOfNonWhitespace.length();
                                break;
                            }
                            bVar4 = bVar5;
                            sVar4 = headers;
                            if (StringsKt__StringsKt.contains$default("=,;", indexOfNonWhitespace.charAt(length2), false, 2, (Object) null)) {
                                break;
                                break;
                            }
                            length2++;
                            headers = sVar4;
                            bVar5 = bVar4;
                        }
                        strSubstring = indexOfNonWhitespace.substring(i11, length2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        string = StringsKt__StringsKt.trim((CharSequence) strSubstring).toString();
                        if (length2 != indexOfNonWhitespace.length()) {
                            i12 = size3;
                            if (indexOfNonWhitespace.charAt(length2) == ',') {
                            }
                            if (StringsKt__StringsJVMKt.equals("no-cache", string, true)) {
                                z5 = true;
                            } else if (StringsKt__StringsJVMKt.equals("no-store", string, true)) {
                                z10 = true;
                            } else if (StringsKt__StringsJVMKt.equals("max-age", string, true)) {
                                b9 = -1;
                                iX = ej.b.x(-1, string2);
                            } else {
                                b9 = -1;
                                if (StringsKt__StringsJVMKt.equals("s-maxage", string, true)) {
                                    iX2 = ej.b.x(-1, string2);
                                } else if (StringsKt__StringsJVMKt.equals("private", string, true)) {
                                    z11 = true;
                                } else if (StringsKt__StringsJVMKt.equals("public", string, true)) {
                                    z12 = true;
                                } else if (StringsKt__StringsJVMKt.equals("must-revalidate", string, true)) {
                                    z13 = true;
                                } else if (StringsKt__StringsJVMKt.equals("max-stale", string, true)) {
                                    iX3 = ej.b.x(Integer.MAX_VALUE, string2);
                                } else if (StringsKt__StringsJVMKt.equals("min-fresh", string, true)) {
                                    iX4 = ej.b.x(-1, string2);
                                } else if (StringsKt__StringsJVMKt.equals("only-if-cached", string, true)) {
                                    z14 = true;
                                } else if (StringsKt__StringsJVMKt.equals("no-transform", string, true)) {
                                    z15 = true;
                                } else if (StringsKt__StringsJVMKt.equals("immutable", string, true)) {
                                    z16 = true;
                                }
                            }
                            i11 = i13;
                            headers = sVar4;
                            bVar5 = bVar4;
                            size3 = i12;
                            z3 = z2;
                        } else {
                            i12 = size3;
                        }
                        z2 = z3;
                        i13 = length2 + 1;
                        string2 = null;
                        if (StringsKt__StringsJVMKt.equals("no-cache", string, true)) {
                            z5 = true;
                        } else if (StringsKt__StringsJVMKt.equals("no-store", string, true)) {
                            z10 = true;
                        } else if (StringsKt__StringsJVMKt.equals("max-age", string, true)) {
                            b9 = -1;
                            iX = ej.b.x(-1, string2);
                        } else {
                            b9 = -1;
                            if (StringsKt__StringsJVMKt.equals("s-maxage", string, true)) {
                                iX2 = ej.b.x(-1, string2);
                            } else if (StringsKt__StringsJVMKt.equals("private", string, true)) {
                                z11 = true;
                            } else if (StringsKt__StringsJVMKt.equals("public", string, true)) {
                                z12 = true;
                            } else if (StringsKt__StringsJVMKt.equals("must-revalidate", string, true)) {
                                z13 = true;
                            } else if (StringsKt__StringsJVMKt.equals("max-stale", string, true)) {
                                iX3 = ej.b.x(Integer.MAX_VALUE, string2);
                            } else if (StringsKt__StringsJVMKt.equals("min-fresh", string, true)) {
                                iX4 = ej.b.x(-1, string2);
                            } else if (StringsKt__StringsJVMKt.equals("only-if-cached", string, true)) {
                                z14 = true;
                            } else if (StringsKt__StringsJVMKt.equals("no-transform", string, true)) {
                                z15 = true;
                            } else if (StringsKt__StringsJVMKt.equals("immutable", string, true)) {
                                z16 = true;
                            }
                        }
                        i11 = i13;
                        headers = sVar4;
                        bVar5 = bVar4;
                        size3 = i12;
                        z3 = z2;
                    }
                    bVar3 = bVar5;
                    sVar3 = headers;
                    i10 = size3;
                    i16++;
                    headers = sVar3;
                    bVar5 = bVar3;
                    size3 = i10;
                }
                bVar = bVar5;
                cVar = new c(z5, z10, iX, iX2, z11, z12, z13, iX3, iX4, z14, z15, z16, !z3 ? null : str);
                request.f4527a = cVar;
            } else {
                bVar = bVar5;
            }
            if (cVar.f4523j) {
                bVar2 = new i1.b(null, null);
            }
            call = fVar.f5878b;
            e0Var = (e0) bVar2.f5527a;
            cachedResponse = (j0) bVar2.f5528b;
            if (e0Var != null && cachedResponse == null) {
                r rVar2 = new r(0);
                Intrinsics.checkNotNullParameter(request, "request");
                d0 protocol = d0.HTTP_1_1;
                Intrinsics.checkNotNullParameter(protocol, "protocol");
                Intrinsics.checkNotNullParameter("Unsatisfiable Request (only-if-cached)", MessageBank.KEY_MESSAGE);
                l0 l0Var = ej.b.f4966c;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (request == null) {
                    throw new IllegalStateException("request == null");
                }
                if (protocol == null) {
                    throw new IllegalStateException("protocol == null");
                }
                j0 response = new j0(request, protocol, "Unsatisfiable Request (only-if-cached)", TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null, rVar2.c(), l0Var, null, null, null, -1L, jCurrentTimeMillis, null);
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                return response;
            }
            if (e0Var == null) {
                Intrinsics.checkNotNull(cachedResponse);
                i0 i0VarG = cachedResponse.g();
                j0 j0VarA = a.a(cachedResponse);
                i0.b(j0VarA, "cacheResponse");
                i0VarG.f4567i = j0VarA;
                j0 response2 = i0VarG.a();
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response2, "response");
                return response2;
            }
            if (cachedResponse != null) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
            }
            j0VarB = fVar.b(e0Var);
            if (cachedResponse != null) {
                if (j0VarB.f4579d == 304) {
                    i0 i0VarG2 = cachedResponse.g();
                    rVar = new r(0);
                    sVar = cachedResponse.f4580h;
                    size = sVar.size();
                    i8 = 0;
                    while (true) {
                        sVar2 = j0VarB.f4580h;
                        if (i8 < size) {
                            break;
                        }
                        strF2 = sVar.f(i8);
                        strH = sVar.h(i8);
                        s sVar5 = sVar;
                        if ((StringsKt__StringsJVMKt.equals("Warning", strF2, true) || !StringsKt__StringsJVMKt.startsWith$default(strH, "1", false, 2, null)) && (StringsKt__StringsJVMKt.equals("Content-Length", strF2, true) || StringsKt__StringsJVMKt.equals("Content-Encoding", strF2, true) || StringsKt__StringsJVMKt.equals("Content-Type", strF2, true) || !a.b(strF2) || sVar2.e(strF2) == null)) {
                            rVar.b(strF2, strH);
                        }
                        i8++;
                        sVar = sVar5;
                    }
                    size2 = sVar2.size();
                    for (i9 = 0; i9 < size2; i9++) {
                        strF = sVar2.f(i9);
                        if (StringsKt__StringsJVMKt.equals("Content-Length", strF, true) && !StringsKt__StringsJVMKt.equals("Content-Encoding", strF, true) && !StringsKt__StringsJVMKt.equals("Content-Type", strF, true) && a.b(strF)) {
                            rVar.b(strF, sVar2.h(i9));
                        }
                    }
                    s headers2 = rVar.c();
                    Intrinsics.checkNotNullParameter(headers2, "headers");
                    i0VarG2.f = headers2.g();
                    i0VarG2.f4569k = j0VarB.f4585m;
                    i0VarG2.f4570l = j0VarB.f4586n;
                    j0 j0VarA2 = a.a(cachedResponse);
                    i0.b(j0VarA2, "cacheResponse");
                    i0VarG2.f4567i = j0VarA2;
                    j0 j0VarA3 = a.a(j0VarB);
                    i0.b(j0VarA3, "networkResponse");
                    i0VarG2.f4566h = j0VarA3;
                    i0VarG2.a();
                    m0 m0Var2 = j0VarB.f4581i;
                    Intrinsics.checkNotNull(m0Var2);
                    m0Var2.close();
                    Intrinsics.checkNotNull(null);
                    throw null;
                }
                m0Var = cachedResponse.f4581i;
                if (m0Var != null) {
                    ej.b.d(m0Var);
                }
            }
            Intrinsics.checkNotNull(j0VarB);
            i0 i0VarG3 = j0VarB.g();
            j0 j0VarA4 = a.a(cachedResponse);
            i0.b(j0VarA4, "cacheResponse");
            i0VarG3.f4567i = j0VarA4;
            j0 j0VarA5 = a.a(j0VarB);
            i0.b(j0VarA5, "networkResponse");
            i0VarG3.f4566h = j0VarA5;
            return i0VarG3.a();
        }
        bVar = bVar5;
        bVar2 = bVar;
        call = fVar.f5878b;
        e0Var = (e0) bVar2.f5527a;
        cachedResponse = (j0) bVar2.f5528b;
        if (e0Var != null) {
        }
        if (e0Var == null) {
            Intrinsics.checkNotNull(cachedResponse);
            i0 i0VarG4 = cachedResponse.g();
            j0 j0VarA6 = a.a(cachedResponse);
            i0.b(j0VarA6, "cacheResponse");
            i0VarG4.f4567i = j0VarA6;
            j0 response3 = i0VarG4.a();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response3, "response");
            return response3;
        }
        if (cachedResponse != null) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
        }
        j0VarB = fVar.b(e0Var);
        if (cachedResponse != null) {
            if (j0VarB.f4579d == 304) {
                i0 i0VarG5 = cachedResponse.g();
                rVar = new r(0);
                sVar = cachedResponse.f4580h;
                size = sVar.size();
                i8 = 0;
                while (true) {
                    sVar2 = j0VarB.f4580h;
                    if (i8 < size) {
                        break;
                        break;
                    }
                    strF2 = sVar.f(i8);
                    strH = sVar.h(i8);
                    s sVar6 = sVar;
                    if (StringsKt__StringsJVMKt.equals("Warning", strF2, true)) {
                        rVar.b(strF2, strH);
                    } else {
                        rVar.b(strF2, strH);
                    }
                    i8++;
                    sVar = sVar6;
                }
                size2 = sVar2.size();
                while (i9 < size2) {
                    strF = sVar2.f(i9);
                    if (StringsKt__StringsJVMKt.equals("Content-Length", strF, true)) {
                    }
                }
                s headers3 = rVar.c();
                Intrinsics.checkNotNullParameter(headers3, "headers");
                i0VarG5.f = headers3.g();
                i0VarG5.f4569k = j0VarB.f4585m;
                i0VarG5.f4570l = j0VarB.f4586n;
                j0 j0VarA7 = a.a(cachedResponse);
                i0.b(j0VarA7, "cacheResponse");
                i0VarG5.f4567i = j0VarA7;
                j0 j0VarA8 = a.a(j0VarB);
                i0.b(j0VarA8, "networkResponse");
                i0VarG5.f4566h = j0VarA8;
                i0VarG5.a();
                m0 m0Var3 = j0VarB.f4581i;
                Intrinsics.checkNotNull(m0Var3);
                m0Var3.close();
                Intrinsics.checkNotNull(null);
                throw null;
            }
            m0Var = cachedResponse.f4581i;
            if (m0Var != null) {
                ej.b.d(m0Var);
            }
        }
        Intrinsics.checkNotNull(j0VarB);
        i0 i0VarG6 = j0VarB.g();
        j0 j0VarA9 = a.a(cachedResponse);
        i0.b(j0VarA9, "cacheResponse");
        i0VarG6.f4567i = j0VarA9;
        j0 j0VarA10 = a.a(j0VarB);
        i0.b(j0VarA10, "networkResponse");
        i0VarG6.f4566h = j0VarA10;
        return i0VarG6.a();
    }
}
