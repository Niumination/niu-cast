package l3;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import kotlin.jvm.internal.CharCompanionObject;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class t1 implements f2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f7298n = new int[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Unsafe f7299o = x2.j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f7300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f7301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7303d;
    public final q1 e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f7304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f7306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i1 f7307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p2 f7308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g0 f7309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f7310m;

    public t1(int[] iArr, Object[] objArr, int i8, int i9, q1 q1Var, int i10, int[] iArr2, int i11, int i12, i1 i1Var, p2 p2Var, g0 g0Var) {
        this.f7300a = iArr;
        this.f7301b = objArr;
        this.f7302c = i8;
        this.f7303d = i9;
        this.f7310m = i10;
        boolean z2 = false;
        if (g0Var != null && (q1Var instanceof n0)) {
            z2 = true;
        }
        this.f = z2;
        this.f7304g = iArr2;
        this.f7305h = i11;
        this.f7306i = i12;
        this.f7307j = i1Var;
        this.f7308k = p2Var;
        this.f7309l = g0Var;
        this.e = q1Var;
    }

    public static o2 B(Object obj) {
        q0 q0Var = (q0) obj;
        o2 o2Var = q0Var.zzc;
        if (o2Var != o2.f) {
            return o2Var;
        }
        o2 o2VarB = o2.b();
        q0Var.zzc = o2VarB;
        return o2VarB;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x025b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0261  */
    /* JADX WARN: Code duplicated, block: B:129:0x0277  */
    /* JADX WARN: Code duplicated, block: B:130:0x027a  */
    public static t1 C(a2 a2Var, i1 i1Var, p2 p2Var, g0 g0Var) {
        int i8;
        int iCharAt;
        int iCharAt2;
        int i9;
        int i10;
        int i11;
        int[] iArr;
        int i12;
        int i13;
        int i14;
        char cCharAt;
        int i15;
        char cCharAt2;
        int i16;
        char cCharAt3;
        int i17;
        char cCharAt4;
        int i18;
        char cCharAt5;
        int i19;
        char cCharAt6;
        int i20;
        char cCharAt7;
        int i21;
        char cCharAt8;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        char c9;
        int i28;
        int i29;
        Field fieldO;
        int i30;
        char cCharAt9;
        int i31;
        int i32;
        int i33;
        int i34;
        Object obj;
        Field fieldO2;
        int i35;
        Object obj2;
        Field fieldO3;
        int i36;
        char cCharAt10;
        int i37;
        char cCharAt11;
        int i38;
        char cCharAt12;
        int i39;
        char cCharAt13;
        if (!(a2Var instanceof a2)) {
            h0.a.A(a2Var);
            throw null;
        }
        String strC = a2Var.c();
        int length = strC.length();
        char c10 = 55296;
        if (strC.charAt(0) >= 55296) {
            int i40 = 1;
            while (true) {
                i8 = i40 + 1;
                if (strC.charAt(i40) < 55296) {
                    break;
                }
                i40 = i8;
            }
        } else {
            i8 = 1;
        }
        int i41 = i8 + 1;
        int iCharAt3 = strC.charAt(i8);
        if (iCharAt3 >= 55296) {
            int i42 = iCharAt3 & 8191;
            int i43 = 13;
            while (true) {
                i39 = i41 + 1;
                cCharAt13 = strC.charAt(i41);
                if (cCharAt13 < 55296) {
                    break;
                }
                i42 |= (cCharAt13 & 8191) << i43;
                i43 += 13;
                i41 = i39;
            }
            iCharAt3 = i42 | (cCharAt13 << i43);
            i41 = i39;
        }
        if (iCharAt3 == 0) {
            i11 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i9 = 0;
            i12 = 0;
            i10 = 0;
            iArr = f7298n;
            i13 = 0;
        } else {
            int i44 = i41 + 1;
            int iCharAt4 = strC.charAt(i41);
            if (iCharAt4 >= 55296) {
                int i45 = iCharAt4 & 8191;
                int i46 = 13;
                while (true) {
                    i21 = i44 + 1;
                    cCharAt8 = strC.charAt(i44);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt8 & 8191) << i46;
                    i46 += 13;
                    i44 = i21;
                }
                iCharAt4 = i45 | (cCharAt8 << i46);
                i44 = i21;
            }
            int i47 = i44 + 1;
            int iCharAt5 = strC.charAt(i44);
            if (iCharAt5 >= 55296) {
                int i48 = iCharAt5 & 8191;
                int i49 = 13;
                while (true) {
                    i20 = i47 + 1;
                    cCharAt7 = strC.charAt(i47);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt7 & 8191) << i49;
                    i49 += 13;
                    i47 = i20;
                }
                iCharAt5 = i48 | (cCharAt7 << i49);
                i47 = i20;
            }
            int i50 = i47 + 1;
            int iCharAt6 = strC.charAt(i47);
            if (iCharAt6 >= 55296) {
                int i51 = iCharAt6 & 8191;
                int i52 = 13;
                while (true) {
                    i19 = i50 + 1;
                    cCharAt6 = strC.charAt(i50);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt6 & 8191) << i52;
                    i52 += 13;
                    i50 = i19;
                }
                iCharAt6 = i51 | (cCharAt6 << i52);
                i50 = i19;
            }
            int i53 = i50 + 1;
            int iCharAt7 = strC.charAt(i50);
            if (iCharAt7 >= 55296) {
                int i54 = iCharAt7 & 8191;
                int i55 = 13;
                while (true) {
                    i18 = i53 + 1;
                    cCharAt5 = strC.charAt(i53);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt5 & 8191) << i55;
                    i55 += 13;
                    i53 = i18;
                }
                iCharAt7 = i54 | (cCharAt5 << i55);
                i53 = i18;
            }
            int i56 = i53 + 1;
            iCharAt = strC.charAt(i53);
            if (iCharAt >= 55296) {
                int i57 = iCharAt & 8191;
                int i58 = 13;
                while (true) {
                    i17 = i56 + 1;
                    cCharAt4 = strC.charAt(i56);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt4 & 8191) << i58;
                    i58 += 13;
                    i56 = i17;
                }
                iCharAt = i57 | (cCharAt4 << i58);
                i56 = i17;
            }
            int i59 = i56 + 1;
            iCharAt2 = strC.charAt(i56);
            if (iCharAt2 >= 55296) {
                int i60 = iCharAt2 & 8191;
                int i61 = 13;
                while (true) {
                    i16 = i59 + 1;
                    cCharAt3 = strC.charAt(i59);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt3 & 8191) << i61;
                    i61 += 13;
                    i59 = i16;
                }
                iCharAt2 = i60 | (cCharAt3 << i61);
                i59 = i16;
            }
            int i62 = i59 + 1;
            int iCharAt8 = strC.charAt(i59);
            if (iCharAt8 >= 55296) {
                int i63 = iCharAt8 & 8191;
                int i64 = 13;
                while (true) {
                    i15 = i62 + 1;
                    cCharAt2 = strC.charAt(i62);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i63 |= (cCharAt2 & 8191) << i64;
                    i64 += 13;
                    i62 = i15;
                }
                iCharAt8 = i63 | (cCharAt2 << i64);
                i62 = i15;
            }
            int i65 = i62 + 1;
            int iCharAt9 = strC.charAt(i62);
            if (iCharAt9 >= 55296) {
                int i66 = iCharAt9 & 8191;
                int i67 = 13;
                while (true) {
                    i14 = i65 + 1;
                    cCharAt = strC.charAt(i65);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i66 |= (cCharAt & 8191) << i67;
                    i67 += 13;
                    i65 = i14;
                }
                iCharAt9 = i66 | (cCharAt << i67);
                i65 = i14;
            }
            int i68 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i9 = iCharAt6;
            i10 = iCharAt9;
            i11 = i68;
            iArr = iArr2;
            i12 = iCharAt7;
            i13 = iCharAt4;
            i41 = i65;
        }
        Unsafe unsafe = f7299o;
        Object[] objArrD = a2Var.d();
        Class<?> cls = a2Var.a().getClass();
        int i69 = i10 + iCharAt2;
        int i70 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i70];
        int i71 = i10;
        int i72 = i69;
        int i73 = 0;
        int i74 = 0;
        while (i41 < length) {
            int i75 = i41 + 1;
            int iCharAt10 = strC.charAt(i41);
            if (iCharAt10 >= c10) {
                int i76 = iCharAt10 & 8191;
                int i77 = i75;
                int i78 = 13;
                while (true) {
                    i38 = i77 + 1;
                    cCharAt12 = strC.charAt(i77);
                    if (cCharAt12 < c10) {
                        break;
                    }
                    i76 |= (cCharAt12 & 8191) << i78;
                    i78 += 13;
                    i77 = i38;
                }
                iCharAt10 = i76 | (cCharAt12 << i78);
                i22 = i38;
            } else {
                i22 = i75;
            }
            int i79 = i22 + 1;
            int iCharAt11 = strC.charAt(i22);
            if (iCharAt11 >= c10) {
                int i80 = iCharAt11 & 8191;
                int i81 = i79;
                int i82 = 13;
                while (true) {
                    i37 = i81 + 1;
                    cCharAt11 = strC.charAt(i81);
                    if (cCharAt11 < c10) {
                        break;
                    }
                    i80 |= (cCharAt11 & 8191) << i82;
                    i82 += 13;
                    i81 = i37;
                }
                iCharAt11 = i80 | (cCharAt11 << i82);
                i23 = i37;
            } else {
                i23 = i79;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i73] = i74;
                i73++;
            }
            int i83 = iCharAt11 & 255;
            if (i83 >= 51) {
                int i84 = i23 + 1;
                int iCharAt12 = strC.charAt(i23);
                char c11 = 55296;
                if (iCharAt12 >= 55296) {
                    int i85 = 13;
                    int i86 = iCharAt12 & 8191;
                    int i87 = i84;
                    while (true) {
                        i36 = i87 + 1;
                        cCharAt10 = strC.charAt(i87);
                        if (cCharAt10 < c11) {
                            break;
                        }
                        i86 |= (cCharAt10 & 8191) << i85;
                        i85 += 13;
                        i87 = i36;
                        c11 = 55296;
                    }
                    iCharAt12 = i86 | (cCharAt10 << i85);
                    i32 = i36;
                } else {
                    i32 = i84;
                }
                int i88 = i32;
                int i89 = i83 - 51;
                i24 = length;
                if (i89 == 9 || i89 == 17) {
                    int i90 = i74 / 3;
                    i33 = i11 + 1;
                    objArr[i90 + i90 + 1] = objArrD[i11];
                } else {
                    if (i89 == 12 && (a2Var.b() == 1 || (iCharAt11 & 2048) != 0)) {
                        int i91 = i74 / 3;
                        i33 = i11 + 1;
                        objArr[i91 + i91 + 1] = objArrD[i11];
                    }
                    i34 = iCharAt12 + iCharAt12;
                    obj = objArrD[i34];
                    if (obj instanceof Field) {
                        fieldO2 = (Field) obj;
                    } else {
                        fieldO2 = o(cls, (String) obj);
                        objArrD[i34] = fieldO2;
                    }
                    int i92 = i9;
                    i26 = i12;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldO2);
                    i35 = i34 + 1;
                    obj2 = objArrD[i35];
                    if (obj2 instanceof Field) {
                        fieldO3 = (Field) obj2;
                    } else {
                        fieldO3 = o(cls, (String) obj2);
                        objArrD[i35] = fieldO3;
                    }
                    strC = strC;
                    i25 = i92;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO3);
                    i27 = i11;
                    i28 = i88;
                    i29 = 0;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    c9 = 55296;
                }
                i11 = i33;
                i34 = iCharAt12 + iCharAt12;
                obj = objArrD[i34];
                if (obj instanceof Field) {
                    fieldO2 = (Field) obj;
                } else {
                    fieldO2 = o(cls, (String) obj);
                    objArrD[i34] = fieldO2;
                }
                int i93 = i9;
                i26 = i12;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldO2);
                i35 = i34 + 1;
                obj2 = objArrD[i35];
                if (obj2 instanceof Field) {
                    fieldO3 = (Field) obj2;
                } else {
                    fieldO3 = o(cls, (String) obj2);
                    objArrD[i35] = fieldO3;
                }
                strC = strC;
                i25 = i93;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO3);
                i27 = i11;
                i28 = i88;
                i29 = 0;
                iObjectFieldOffset = iObjectFieldOffset4;
                c9 = 55296;
            } else {
                i24 = length;
                i25 = i9;
                i26 = i12;
                i27 = i11 + 1;
                Field fieldO4 = o(cls, (String) objArrD[i11]);
                if (i83 == 9 || i83 == 17) {
                    i25 = i25;
                    int i94 = i74 / 3;
                    objArr[i94 + i94 + 1] = fieldO4.getType();
                } else {
                    if (i83 == 27 || i83 == 49) {
                        i25 = i25;
                        int i95 = i74 / 3;
                        i31 = i11 + 2;
                        objArr[i95 + i95 + 1] = objArrD[i27];
                    } else if (i83 == 12 || i83 == 30 || i83 == 44) {
                        i25 = i25;
                        if (a2Var.b() == 1 || (iCharAt11 & 2048) != 0) {
                            int i96 = i74 / 3;
                            i31 = i11 + 2;
                            objArr[i96 + i96 + 1] = objArrD[i27];
                        }
                    } else if (i83 == 50) {
                        int i97 = i71 + 1;
                        iArr[i71] = i74;
                        int i98 = i74 / 3;
                        int i99 = i11 + 2;
                        int i100 = i98 + i98;
                        objArr[i100] = objArrD[i27];
                        if ((iCharAt11 & 2048) != 0) {
                            i27 = i11 + 3;
                            objArr[i100 + 1] = objArrD[i99];
                            i71 = i97;
                        } else {
                            i71 = i97;
                            i27 = i99;
                        }
                    }
                    i27 = i31;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) == 0 || i83 > 17) {
                    c9 = 55296;
                    i28 = i23;
                    i29 = 0;
                } else {
                    i28 = i23 + 1;
                    int iCharAt13 = strC.charAt(i23);
                    if (iCharAt13 >= 55296) {
                        int i101 = iCharAt13 & 8191;
                        int i102 = 13;
                        while (true) {
                            i30 = i28 + 1;
                            cCharAt9 = strC.charAt(i28);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i101 |= (cCharAt9 & 8191) << i102;
                            i102 += 13;
                            i28 = i30;
                        }
                        iCharAt13 = i101 | (cCharAt9 << i102);
                        i28 = i30;
                    }
                    int i103 = (iCharAt13 / 32) + i13 + i13;
                    Object obj3 = objArrD[i103];
                    if (obj3 instanceof Field) {
                        fieldO = (Field) obj3;
                    } else {
                        fieldO = o(cls, (String) obj3);
                        objArrD[i103] = fieldO;
                    }
                    i29 = iCharAt13 % 32;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO);
                    c9 = 55296;
                }
                if (i83 >= 18 && i83 <= 49) {
                    iArr[i72] = iObjectFieldOffset;
                    i72++;
                }
            }
            int i104 = i74 + 1;
            iArr3[i74] = iCharAt10;
            int i105 = i74 + 2;
            iArr3[i104] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i83 << 20) | iObjectFieldOffset;
            i74 += 3;
            iArr3[i105] = (i29 << 20) | iObjectFieldOffset2;
            c10 = c9;
            i41 = i28;
            strC = strC;
            i9 = i25;
            i11 = i27;
            length = i24;
            i12 = i26;
        }
        return new t1(iArr3, objArr, i9, i12, a2Var.a(), a2Var.b(), iArr, i10, i69, i1Var, p2Var, g0Var);
    }

    public static int E(long j8, Object obj) {
        return ((Integer) x2.i(j8, obj)).intValue();
    }

    public static int J(int i8) {
        return (i8 >>> 20) & 255;
    }

    public static long L(long j8, Object obj) {
        return ((Long) x2.i(j8, obj)).longValue();
    }

    public static Field o(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sbP = h0.a.p("Field ", str, " for ", name, " not found. Known fields are ");
            sbP.append(string);
            throw new RuntimeException(sbP.toString());
        }
    }

    public static void p(Object obj) {
        if (!x(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    public static boolean x(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof q0) {
            return ((q0) obj).k();
        }
        return true;
    }

    public static final void z(int i8, Object obj, l1 l1Var) throws d0 {
        if (!(obj instanceof String)) {
            l1Var.g(i8, (b0) obj);
        } else {
            ((c0) l1Var.f7264a).h(i8, (String) obj);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15801. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int A(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, l3.t r40) {
        /*
            Method dump skipped, instruction units count: 1580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.t1.A(java.lang.Object, byte[], int, int, int, l3.t):int");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0093  */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0126  */
    public final int D(q0 q0Var) {
        int i8;
        int i9;
        int iR;
        int i10;
        int i11;
        int iZzd;
        int iQ;
        int iJ;
        int i12;
        int i13;
        int iQ2;
        int iR2;
        int iD;
        int i14;
        int iQ3;
        int i15;
        Unsafe unsafe = f7299o;
        int i16 = 1048575;
        int i17 = 1048575;
        int i18 = 0;
        int iC = 0;
        int i19 = 0;
        while (true) {
            int[] iArr = this.f7300a;
            if (i18 < iArr.length) {
                int iK = K(i18);
                int i20 = iArr[i18];
                int iJ2 = J(iK);
                if (iJ2 <= 17) {
                    int i21 = iArr[i18 + 2];
                    int i22 = i21 & i16;
                    int i23 = i21 >>> 20;
                    if (i22 != i17) {
                        i19 = unsafe.getInt(q0Var, i22);
                        i17 = i22;
                    }
                    i8 = 1 << i23;
                } else {
                    i8 = 0;
                }
                long j8 = iK & i16;
                int iO = 4;
                int iQ4 = 8;
                switch (iJ2) {
                    case 0:
                        if ((i19 & i8) != 0) {
                            i15 = i20 << 3;
                            iC = h0.a.b(i15, iQ4, iC);
                        }
                        break;
                    case 1:
                        if ((i19 & i8) != 0) {
                            i10 = i20 << 3;
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 2:
                        if ((i19 & i8) != 0) {
                            i9 = i20 << 3;
                            iR = c0.r(unsafe.getLong(q0Var, j8));
                            iC = h0.a.b(i9, iR, iC);
                        }
                        break;
                    case 3:
                        if ((i19 & i8) != 0) {
                            i9 = i20 << 3;
                            iR = c0.r(unsafe.getLong(q0Var, j8));
                            iC = h0.a.b(i9, iR, iC);
                        }
                        break;
                    case 4:
                        if ((i19 & i8) != 0) {
                            i10 = i20 << 3;
                            iO = c0.o(unsafe.getInt(q0Var, j8));
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 5:
                        if ((i19 & i8) != 0) {
                            i15 = i20 << 3;
                            iC = h0.a.b(i15, iQ4, iC);
                        }
                        break;
                    case 6:
                        if ((i19 & i8) != 0) {
                            i10 = i20 << 3;
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 7:
                        if ((i19 & i8) != 0) {
                            iC = h0.a.b(i20 << 3, 1, iC);
                        }
                        break;
                    case 8:
                        if ((i19 & i8) != 0) {
                            Object object = unsafe.getObject(q0Var, j8);
                            if (object instanceof b0) {
                                i11 = i20 << 3;
                                Logger logger = c0.e;
                                iZzd = ((b0) object).zzd();
                                iQ = c0.q(iZzd);
                                iC = h0.a.b(i11, iQ + iZzd, iC);
                            } else {
                                i10 = i20 << 3;
                                iO = c0.p((String) object);
                                iC = h0.a.b(i10, iO, iC);
                            }
                        }
                        break;
                    case 9:
                        if ((i19 & i8) != 0) {
                            iJ = g2.J(i20, unsafe.getObject(q0Var, j8), k(i18));
                            iC += iJ;
                        }
                        break;
                    case 10:
                        if ((i19 & i8) != 0) {
                            b0 b0Var = (b0) unsafe.getObject(q0Var, j8);
                            i11 = i20 << 3;
                            Logger logger2 = c0.e;
                            iZzd = b0Var.zzd();
                            iQ = c0.q(iZzd);
                            iC = h0.a.b(i11, iQ + iZzd, iC);
                        }
                        break;
                    case 11:
                        if ((i19 & i8) != 0) {
                            i10 = i20 << 3;
                            iO = c0.q(unsafe.getInt(q0Var, j8));
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 12:
                        if ((i19 & i8) != 0) {
                            i10 = i20 << 3;
                            iO = c0.o(unsafe.getInt(q0Var, j8));
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 13:
                        if ((i19 & i8) != 0) {
                            i10 = i20 << 3;
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 14:
                        if ((i19 & i8) != 0) {
                            i15 = i20 << 3;
                            iC = h0.a.b(i15, iQ4, iC);
                        }
                        break;
                    case 15:
                        if ((i19 & i8) != 0) {
                            int i24 = unsafe.getInt(q0Var, j8);
                            i12 = i24 + i24;
                            i13 = i24 >> 31;
                            iQ4 = c0.q(i20 << 3);
                            i15 = i13 ^ i12;
                            iC = h0.a.b(i15, iQ4, iC);
                        }
                        break;
                    case 16:
                        if ((i19 & i8) != 0) {
                            long j10 = unsafe.getLong(q0Var, j8);
                            iQ2 = c0.q(i20 << 3);
                            iR2 = c0.r((j10 >> 63) ^ (j10 + j10));
                            iJ = iR2 + iQ2;
                            iC += iJ;
                        }
                        break;
                    case 17:
                        if ((i19 & i8) != 0) {
                            iJ = c0.n(i20, (q1) unsafe.getObject(q0Var, j8), k(i18));
                            iC += iJ;
                        }
                        break;
                    case 18:
                        iJ = g2.C(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 19:
                        iJ = g2.A(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 20:
                        iJ = g2.H(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 21:
                        iJ = g2.S(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 22:
                        iJ = g2.F(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 23:
                        iJ = g2.C(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 24:
                        iJ = g2.A(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 25:
                        iJ = g2.w(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 26:
                        iJ = g2.P(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 27:
                        iJ = g2.K(i20, (List) unsafe.getObject(q0Var, j8), k(i18));
                        iC += iJ;
                        break;
                    case 28:
                        iJ = g2.x(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 29:
                        iJ = g2.Q(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                        iJ = g2.y(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 31:
                        iJ = g2.A(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 32:
                        iJ = g2.C(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 33:
                        iJ = g2.L(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 34:
                        iJ = g2.N(i20, (List) unsafe.getObject(q0Var, j8));
                        iC += iJ;
                        break;
                    case 35:
                        iD = g2.D((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 36:
                        iD = g2.B((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 37:
                        iD = g2.I((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 38:
                        iD = g2.T((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 39:
                        iD = g2.G((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 40:
                        iD = g2.D((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 41:
                        iD = g2.B((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 42:
                        List list = (List) unsafe.getObject(q0Var, j8);
                        Class cls = g2.f7238a;
                        iD = list.size();
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 43:
                        iD = g2.R((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 44:
                        iD = g2.z((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 45:
                        iD = g2.B((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 46:
                        iD = g2.D((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case 47:
                        iD = g2.M((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        iD = g2.O((List) unsafe.getObject(q0Var, j8));
                        if (iD > 0) {
                            i14 = i20 << 3;
                            iQ3 = c0.q(iD);
                            iC = h0.a.c(i14, iQ3, iD, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        iJ = g2.E(i20, (List) unsafe.getObject(q0Var, j8), k(i18));
                        iC += iJ;
                        break;
                    case 50:
                        n1.a(unsafe.getObject(q0Var, j8), l(i18));
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (y(i20, i18, q0Var)) {
                            i15 = i20 << 3;
                            iC = h0.a.b(i15, iQ4, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (y(i20, i18, q0Var)) {
                            i10 = i20 << 3;
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (y(i20, i18, q0Var)) {
                            i9 = i20 << 3;
                            iR = c0.r(L(j8, q0Var));
                            iC = h0.a.b(i9, iR, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (y(i20, i18, q0Var)) {
                            i9 = i20 << 3;
                            iR = c0.r(L(j8, q0Var));
                            iC = h0.a.b(i9, iR, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (y(i20, i18, q0Var)) {
                            i10 = i20 << 3;
                            iO = c0.o(E(j8, q0Var));
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 56:
                        if (y(i20, i18, q0Var)) {
                            i15 = i20 << 3;
                            iC = h0.a.b(i15, iQ4, iC);
                        }
                        break;
                    case 57:
                        if (y(i20, i18, q0Var)) {
                            i10 = i20 << 3;
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 58:
                        if (y(i20, i18, q0Var)) {
                            iC = h0.a.b(i20 << 3, 1, iC);
                        }
                        break;
                    case 59:
                        if (y(i20, i18, q0Var)) {
                            Object object2 = unsafe.getObject(q0Var, j8);
                            if (object2 instanceof b0) {
                                i11 = i20 << 3;
                                Logger logger3 = c0.e;
                                iZzd = ((b0) object2).zzd();
                                iQ = c0.q(iZzd);
                                iC = h0.a.b(i11, iQ + iZzd, iC);
                            } else {
                                i10 = i20 << 3;
                                iO = c0.p((String) object2);
                                iC = h0.a.b(i10, iO, iC);
                            }
                        }
                        break;
                    case 60:
                        if (y(i20, i18, q0Var)) {
                            iJ = g2.J(i20, unsafe.getObject(q0Var, j8), k(i18));
                            iC += iJ;
                        }
                        break;
                    case 61:
                        if (y(i20, i18, q0Var)) {
                            b0 b0Var2 = (b0) unsafe.getObject(q0Var, j8);
                            i11 = i20 << 3;
                            Logger logger4 = c0.e;
                            iZzd = b0Var2.zzd();
                            iQ = c0.q(iZzd);
                            iC = h0.a.b(i11, iQ + iZzd, iC);
                        }
                        break;
                    case 62:
                        if (y(i20, i18, q0Var)) {
                            i10 = i20 << 3;
                            iO = c0.q(E(j8, q0Var));
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        if (y(i20, i18, q0Var)) {
                            i10 = i20 << 3;
                            iO = c0.o(E(j8, q0Var));
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case 64:
                        if (y(i20, i18, q0Var)) {
                            i10 = i20 << 3;
                            iC = h0.a.b(i10, iO, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (y(i20, i18, q0Var)) {
                            i15 = i20 << 3;
                            iC = h0.a.b(i15, iQ4, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (y(i20, i18, q0Var)) {
                            int iE = E(j8, q0Var);
                            i12 = iE + iE;
                            i13 = iE >> 31;
                            iQ4 = c0.q(i20 << 3);
                            i15 = i13 ^ i12;
                            iC = h0.a.b(i15, iQ4, iC);
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                        if (y(i20, i18, q0Var)) {
                            long jL = L(j8, q0Var);
                            iQ2 = c0.q(i20 << 3);
                            iR2 = c0.r((jL >> 63) ^ (jL + jL));
                            iJ = iR2 + iQ2;
                            iC += iJ;
                        }
                        break;
                    case 68:
                        if (y(i20, i18, q0Var)) {
                            iJ = c0.n(i20, (q1) unsafe.getObject(q0Var, j8), k(i18));
                            iC += iJ;
                        }
                        break;
                }
                i18 += 3;
                i16 = 1048575;
            } else {
                this.f7308k.getClass();
                int iA = p2.a(p2.b(q0Var)) + iC;
                if (!this.f) {
                    return iA;
                }
                this.f7309l.getClass();
                i0 i0VarB = g0.b(q0Var);
                int i25 = 0;
                int iA2 = 0;
                while (true) {
                    int iA3 = i0VarB.f7250a.a();
                    h2 h2Var = i0VarB.f7250a;
                    if (i25 >= iA3) {
                        for (Map.Entry entry : h2Var.b()) {
                            iA2 = i0.a((o0) entry.getKey(), entry.getValue()) + iA2;
                        }
                        return iA + iA2;
                    }
                    Map.Entry entryD = h2Var.d(i25);
                    iA2 = i0.a((o0) entryD.getKey(), entryD.getValue()) + iA2;
                    i25++;
                }
            }
        }
    }

    public final void F(int i8, long j8, Object obj) {
        Unsafe unsafe = f7299o;
        Object objL = l(i8);
        Object object = unsafe.getObject(obj, j8);
        if (!((m1) object).zze()) {
            m1 m1VarZzb = m1.zza().zzb();
            n1.b(m1VarZzb, object);
            unsafe.putObject(obj, j8, m1VarZzb);
        }
        o.d.y(objL);
        throw null;
    }

    public final int G(Object obj, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j8, int i15, t tVar) throws b1 {
        Unsafe unsafe = f7299o;
        long j10 = this.f7300a[i15 + 2] & 1048575;
        switch (i14) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                if (i12 != 1) {
                    return i8;
                }
                unsafe.putObject(obj, j8, Double.valueOf(Double.longBitsToDouble(k2.u(i8, bArr))));
                int i16 = i8 + 8;
                unsafe.putInt(obj, j10, i11);
                return i16;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                if (i12 != 5) {
                    return i8;
                }
                unsafe.putObject(obj, j8, Float.valueOf(Float.intBitsToFloat(k2.d(i8, bArr))));
                int i17 = i8 + 4;
                unsafe.putInt(obj, j10, i11);
                return i17;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                if (i12 != 0) {
                    return i8;
                }
                int iQ = k2.q(bArr, i8, tVar);
                unsafe.putObject(obj, j8, Long.valueOf(tVar.f7295b));
                unsafe.putInt(obj, j10, i11);
                return iQ;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 62:
                if (i12 != 0) {
                    return i8;
                }
                int iN = k2.n(bArr, i8, tVar);
                unsafe.putObject(obj, j8, Integer.valueOf(tVar.f7294a));
                unsafe.putInt(obj, j10, i11);
                return iN;
            case 56:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                if (i12 != 1) {
                    return i8;
                }
                unsafe.putObject(obj, j8, Long.valueOf(k2.u(i8, bArr)));
                int i18 = i8 + 8;
                unsafe.putInt(obj, j10, i11);
                return i18;
            case 57:
            case 64:
                if (i12 != 5) {
                    return i8;
                }
                unsafe.putObject(obj, j8, Integer.valueOf(k2.d(i8, bArr)));
                int i19 = i8 + 4;
                unsafe.putInt(obj, j10, i11);
                return i19;
            case 58:
                if (i12 != 0) {
                    return i8;
                }
                int iQ2 = k2.q(bArr, i8, tVar);
                unsafe.putObject(obj, j8, Boolean.valueOf(tVar.f7295b != 0));
                unsafe.putInt(obj, j10, i11);
                return iQ2;
            case 59:
                if (i12 != 2) {
                    return i8;
                }
                int iN2 = k2.n(bArr, i8, tVar);
                int i20 = tVar.f7294a;
                if (i20 == 0) {
                    unsafe.putObject(obj, j8, "");
                } else {
                    if ((i13 & 536870912) != 0 && !z2.d(bArr, iN2, iN2 + i20)) {
                        throw b1.zzc();
                    }
                    unsafe.putObject(obj, j8, new String(bArr, iN2, i20, z0.f7328a));
                    iN2 += i20;
                }
                unsafe.putInt(obj, j10, i11);
                return iN2;
            case 60:
                if (i12 != 2) {
                    return i8;
                }
                Object objN = n(i11, i15, obj);
                int iS = k2.s(objN, k(i15), bArr, i8, i9, tVar);
                u(i11, obj, i15, objN);
                return iS;
            case 61:
                if (i12 != 2) {
                    return i8;
                }
                int iA = k2.a(bArr, i8, tVar);
                unsafe.putObject(obj, j8, tVar.f7296c);
                unsafe.putInt(obj, j10, i11);
                return iA;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                if (i12 != 0) {
                    return i8;
                }
                int iN3 = k2.n(bArr, i8, tVar);
                int i21 = tVar.f7294a;
                u0 u0VarJ = j(i15);
                if (u0VarJ != null && !u0VarJ.a(i21)) {
                    B(obj).c(i10, Long.valueOf(i21));
                    return iN3;
                }
                unsafe.putObject(obj, j8, Integer.valueOf(i21));
                unsafe.putInt(obj, j10, i11);
                return iN3;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (i12 != 0) {
                    return i8;
                }
                int iN4 = k2.n(bArr, i8, tVar);
                unsafe.putObject(obj, j8, Integer.valueOf(k2.c(tVar.f7294a)));
                unsafe.putInt(obj, j10, i11);
                return iN4;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (i12 != 0) {
                    return i8;
                }
                int iQ3 = k2.q(bArr, i8, tVar);
                unsafe.putObject(obj, j8, Long.valueOf(k2.f(tVar.f7295b)));
                unsafe.putInt(obj, j10, i11);
                return iQ3;
            case 68:
                if (i12 != 3) {
                    return i8;
                }
                Object objN2 = n(i11, i15, obj);
                int iR = k2.r(objN2, k(i15), bArr, i8, i9, (i10 & (-8)) | 4, tVar);
                u(i11, obj, i15, objN2);
                return iR;
            default:
                return i8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int H(Object obj, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, long j8, int i14, long j10, t tVar) throws b1 {
        int iN;
        int iP;
        Unsafe unsafe = f7299o;
        r rVar = (r) ((y0) unsafe.getObject(obj, j10));
        boolean zF = rVar.f();
        r rVar2 = rVar;
        if (!zF) {
            int size = rVar.size();
            y0 y0VarB = rVar.b(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j10, y0VarB);
            rVar2 = y0VarB;
        }
        Object objA = null;
        switch (i14) {
            case 18:
            case 35:
                if (i12 == 2) {
                    h0.a.z(rVar2);
                    int iN2 = k2.n(bArr, i8, tVar);
                    int i15 = tVar.f7294a + iN2;
                    if (iN2 < i15) {
                        Double.longBitsToDouble(k2.u(iN2, bArr));
                        throw null;
                    }
                    if (iN2 == i15) {
                        return iN2;
                    }
                    throw b1.zzg();
                }
                if (i12 == 1) {
                    h0.a.z(rVar2);
                    Double.longBitsToDouble(k2.u(i8, bArr));
                    throw null;
                }
                break;
            case 19:
            case 36:
                if (i12 == 2) {
                    k0 k0Var = (k0) rVar2;
                    int iN3 = k2.n(bArr, i8, tVar);
                    int i16 = tVar.f7294a + iN3;
                    while (iN3 < i16) {
                        k0Var.g(Float.intBitsToFloat(k2.d(iN3, bArr)));
                        iN3 += 4;
                    }
                    if (iN3 == i16) {
                        return iN3;
                    }
                    throw b1.zzg();
                }
                if (i12 == 5) {
                    k0 k0Var2 = (k0) rVar2;
                    k0Var2.g(Float.intBitsToFloat(k2.d(i8, bArr)));
                    int i17 = i8 + 4;
                    while (i17 < i9) {
                        int iN4 = k2.n(bArr, i17, tVar);
                        if (i10 != tVar.f7294a) {
                            return i17;
                        }
                        k0Var2.g(Float.intBitsToFloat(k2.d(iN4, bArr)));
                        i17 = iN4 + 4;
                    }
                    return i17;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i12 == 2) {
                    h0.a.z(rVar2);
                    int iN5 = k2.n(bArr, i8, tVar);
                    int i18 = tVar.f7294a + iN5;
                    if (iN5 < i18) {
                        k2.q(bArr, iN5, tVar);
                        throw null;
                    }
                    if (iN5 == i18) {
                        return iN5;
                    }
                    throw b1.zzg();
                }
                if (i12 == 0) {
                    h0.a.z(rVar2);
                    k2.q(bArr, i8, tVar);
                    throw null;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i12 == 2) {
                    return k2.j(bArr, i8, rVar2, tVar);
                }
                if (i12 == 0) {
                    return k2.p(i10, bArr, i8, i9, rVar2, tVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i12 == 2) {
                    h0.a.z(rVar2);
                    int iN6 = k2.n(bArr, i8, tVar);
                    int i19 = tVar.f7294a + iN6;
                    if (iN6 < i19) {
                        k2.u(iN6, bArr);
                        throw null;
                    }
                    if (iN6 == i19) {
                        return iN6;
                    }
                    throw b1.zzg();
                }
                if (i12 == 1) {
                    h0.a.z(rVar2);
                    k2.u(i8, bArr);
                    throw null;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i12 == 2) {
                    r0 r0Var = (r0) rVar2;
                    int iN7 = k2.n(bArr, i8, tVar);
                    int i20 = tVar.f7294a + iN7;
                    while (iN7 < i20) {
                        r0Var.g(k2.d(iN7, bArr));
                        iN7 += 4;
                    }
                    if (iN7 == i20) {
                        return iN7;
                    }
                    throw b1.zzg();
                }
                if (i12 == 5) {
                    r0 r0Var2 = (r0) rVar2;
                    r0Var2.g(k2.d(i8, bArr));
                    int i21 = i8 + 4;
                    while (i21 < i9) {
                        int iN8 = k2.n(bArr, i21, tVar);
                        if (i10 != tVar.f7294a) {
                            return i21;
                        }
                        r0Var2.g(k2.d(iN8, bArr));
                        i21 = iN8 + 4;
                    }
                    return i21;
                }
                break;
            case 25:
            case 42:
                if (i12 == 2) {
                    h0.a.z(rVar2);
                    int iN9 = k2.n(bArr, i8, tVar);
                    int i22 = tVar.f7294a + iN9;
                    if (iN9 < i22) {
                        k2.q(bArr, iN9, tVar);
                        throw null;
                    }
                    if (iN9 == i22) {
                        return iN9;
                    }
                    throw b1.zzg();
                }
                if (i12 == 0) {
                    h0.a.z(rVar2);
                    k2.q(bArr, i8, tVar);
                    throw null;
                }
                break;
            case 26:
                if (i12 == 2) {
                    if ((j8 & 536870912) == 0) {
                        int iN10 = k2.n(bArr, i8, tVar);
                        int i23 = tVar.f7294a;
                        if (i23 < 0) {
                            throw b1.zzd();
                        }
                        if (i23 == 0) {
                            rVar2.add("");
                        } else {
                            rVar2.add(new String(bArr, iN10, i23, z0.f7328a));
                            iN10 += i23;
                        }
                        while (iN10 < i9) {
                            int iN11 = k2.n(bArr, iN10, tVar);
                            if (i10 != tVar.f7294a) {
                                return iN10;
                            }
                            iN10 = k2.n(bArr, iN11, tVar);
                            int i24 = tVar.f7294a;
                            if (i24 < 0) {
                                throw b1.zzd();
                            }
                            if (i24 == 0) {
                                rVar2.add("");
                            } else {
                                rVar2.add(new String(bArr, iN10, i24, z0.f7328a));
                                iN10 += i24;
                            }
                        }
                        return iN10;
                    }
                    int iN12 = k2.n(bArr, i8, tVar);
                    int i25 = tVar.f7294a;
                    if (i25 < 0) {
                        throw b1.zzd();
                    }
                    if (i25 == 0) {
                        rVar2.add("");
                        iN = iN12;
                    } else {
                        iN = iN12 + i25;
                        if (!z2.d(bArr, iN12, iN)) {
                            throw b1.zzc();
                        }
                        rVar2.add(new String(bArr, iN12, i25, z0.f7328a));
                    }
                    while (iN < i9) {
                        int iN13 = k2.n(bArr, iN, tVar);
                        if (i10 != tVar.f7294a) {
                            return iN;
                        }
                        iN = k2.n(bArr, iN13, tVar);
                        int i26 = tVar.f7294a;
                        if (i26 < 0) {
                            throw b1.zzd();
                        }
                        if (i26 == 0) {
                            rVar2.add("");
                        } else {
                            int i27 = iN + i26;
                            if (!z2.d(bArr, iN, i27)) {
                                throw b1.zzc();
                            }
                            rVar2.add(new String(bArr, iN, i26, z0.f7328a));
                            iN = i27;
                        }
                    }
                    return iN;
                }
                break;
            case 27:
                if (i12 == 2) {
                    return k2.h(k(i13), i10, bArr, i8, i9, rVar2, tVar);
                }
                break;
            case 28:
                if (i12 == 2) {
                    int iN14 = k2.n(bArr, i8, tVar);
                    int i28 = tVar.f7294a;
                    if (i28 < 0) {
                        throw b1.zzd();
                    }
                    if (i28 > bArr.length - iN14) {
                        throw b1.zzg();
                    }
                    if (i28 == 0) {
                        rVar2.add(b0.zzb);
                    } else {
                        rVar2.add(b0.zzr(bArr, iN14, i28));
                        iN14 += i28;
                    }
                    while (iN14 < i9) {
                        int iN15 = k2.n(bArr, iN14, tVar);
                        if (i10 != tVar.f7294a) {
                            return iN14;
                        }
                        iN14 = k2.n(bArr, iN15, tVar);
                        int i29 = tVar.f7294a;
                        if (i29 < 0) {
                            throw b1.zzd();
                        }
                        if (i29 > bArr.length - iN14) {
                            throw b1.zzg();
                        }
                        if (i29 == 0) {
                            rVar2.add(b0.zzb);
                        } else {
                            rVar2.add(b0.zzr(bArr, iN14, i29));
                            iN14 += i29;
                        }
                    }
                    return iN14;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
            case 44:
                if (i12 == 2) {
                    iP = k2.j(bArr, i8, rVar2, tVar);
                } else if (i12 == 0) {
                    iP = k2.p(i10, bArr, i8, i9, rVar2, tVar);
                }
                u0 u0VarJ = j(i13);
                Class cls = g2.f7238a;
                if (u0VarJ != null) {
                    int size2 = rVar2.size();
                    int i30 = 0;
                    for (int i31 = 0; i31 < size2; i31++) {
                        Integer num = (Integer) rVar2.get(i31);
                        int iIntValue = num.intValue();
                        if (u0VarJ.a(iIntValue)) {
                            if (i31 != i30) {
                                rVar2.set(i30, num);
                            }
                            i30++;
                        } else {
                            objA = g2.a(obj, i11, iIntValue, objA, this.f7308k);
                        }
                    }
                    if (i30 != size2) {
                        rVar2.subList(i30, size2).clear();
                        return iP;
                    }
                }
                return iP;
            case 33:
            case 47:
                if (i12 == 2) {
                    r0 r0Var3 = (r0) rVar2;
                    int iN16 = k2.n(bArr, i8, tVar);
                    int i32 = tVar.f7294a + iN16;
                    while (iN16 < i32) {
                        iN16 = k2.n(bArr, iN16, tVar);
                        r0Var3.g(k2.c(tVar.f7294a));
                    }
                    if (iN16 == i32) {
                        return iN16;
                    }
                    throw b1.zzg();
                }
                if (i12 == 0) {
                    r0 r0Var4 = (r0) rVar2;
                    int iN17 = k2.n(bArr, i8, tVar);
                    r0Var4.g(k2.c(tVar.f7294a));
                    while (iN17 < i9) {
                        int iN18 = k2.n(bArr, iN17, tVar);
                        if (i10 != tVar.f7294a) {
                            return iN17;
                        }
                        iN17 = k2.n(bArr, iN18, tVar);
                        r0Var4.g(k2.c(tVar.f7294a));
                    }
                    return iN17;
                }
                break;
            case 34:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                if (i12 == 2) {
                    h0.a.z(rVar2);
                    int iN19 = k2.n(bArr, i8, tVar);
                    int i33 = tVar.f7294a + iN19;
                    if (iN19 < i33) {
                        k2.q(bArr, iN19, tVar);
                        throw null;
                    }
                    if (iN19 == i33) {
                        return iN19;
                    }
                    throw b1.zzg();
                }
                if (i12 == 0) {
                    h0.a.z(rVar2);
                    k2.q(bArr, i8, tVar);
                    throw null;
                }
                break;
            default:
                if (i12 == 3) {
                    f2 f2VarK = k(i13);
                    int i34 = (i10 & (-8)) | 4;
                    int iE = k2.e(f2VarK, bArr, i8, i9, i34, tVar);
                    rVar2.add(tVar.f7296c);
                    while (iE < i9) {
                        int iN20 = k2.n(bArr, iE, tVar);
                        if (i10 != tVar.f7294a) {
                            return iE;
                        }
                        iE = k2.e(f2VarK, bArr, iN20, i9, i34, tVar);
                        rVar2.add(tVar.f7296c);
                    }
                    return iE;
                }
                break;
        }
        return i8;
    }

    public final int I(int i8, int i9) {
        int[] iArr = this.f7300a;
        int length = (iArr.length / 3) - 1;
        while (i9 <= length) {
            int i10 = (length + i9) >>> 1;
            int i11 = i10 * 3;
            int i12 = iArr[i11];
            if (i8 == i12) {
                return i11;
            }
            if (i8 < i12) {
                length = i10 - 1;
            } else {
                i9 = i10 + 1;
            }
        }
        return -1;
    }

    public final int K(int i8) {
        return this.f7300a[i8 + 1];
    }

    @Override // l3.f2
    public final Object a() {
        return (q0) ((q0) this.e).n(4, null);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0067  */
    /* JADX WARN: Code duplicated, block: B:27:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a A[SYNTHETIC] */
    @Override // l3.f2
    public final void b(Object obj) {
        if (x(obj)) {
            if (obj instanceof q0) {
                q0 q0Var = (q0) obj;
                q0Var.i();
                q0Var.zzb = 0;
                q0Var.g();
            }
            int[] iArr = this.f7300a;
            int length = iArr.length;
            for (int i8 = 0; i8 < length; i8 += 3) {
                int iK = K(i8);
                int i9 = 1048575 & iK;
                int iJ = J(iK);
                long j8 = i9;
                if (iJ != 9) {
                    if (iJ != 60 && iJ != 68) {
                        switch (iJ) {
                            case 17:
                                if (w(i8, obj)) {
                                    k(i8).b(f7299o.getObject(obj, j8));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.f7307j.a(j8, obj);
                                break;
                            case 50:
                                Unsafe unsafe = f7299o;
                                Object object = unsafe.getObject(obj, j8);
                                if (object != null) {
                                    ((m1) object).zzc();
                                    unsafe.putObject(obj, j8, object);
                                }
                                break;
                        }
                    } else if (y(iArr[i8], i8, obj)) {
                        k(i8).b(f7299o.getObject(obj, j8));
                    }
                } else if (w(i8, obj)) {
                    k(i8).b(f7299o.getObject(obj, j8));
                }
            }
            this.f7308k.getClass();
            p2.c(obj);
            if (this.f) {
                this.f7309l.getClass();
                g0.c(obj);
            }
        }
    }

    @Override // l3.f2
    public final boolean c(q0 q0Var, Object obj) {
        boolean zV;
        int[] iArr = this.f7300a;
        int length = iArr.length;
        for (int i8 = 0; i8 < length; i8 += 3) {
            int iK = K(i8);
            long j8 = iK & 1048575;
            switch (J(iK)) {
                case 0:
                    if (v(q0Var, obj, i8)) {
                        w2 w2Var = x2.f7322c;
                        if (Double.doubleToLongBits(w2Var.a(j8, q0Var)) == Double.doubleToLongBits(w2Var.a(j8, obj))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 1:
                    if (v(q0Var, obj, i8)) {
                        w2 w2Var2 = x2.f7322c;
                        if (Float.floatToIntBits(w2Var2.b(j8, q0Var)) == Float.floatToIntBits(w2Var2.b(j8, obj))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 2:
                    if (!v(q0Var, obj, i8) || x2.g(j8, q0Var) != x2.g(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!v(q0Var, obj, i8) || x2.g(j8, q0Var) != x2.g(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!v(q0Var, obj, i8) || x2.f(j8, q0Var) != x2.f(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!v(q0Var, obj, i8) || x2.g(j8, q0Var) != x2.g(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!v(q0Var, obj, i8) || x2.f(j8, q0Var) != x2.f(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (v(q0Var, obj, i8)) {
                        w2 w2Var3 = x2.f7322c;
                        if (w2Var3.g(j8, q0Var) == w2Var3.g(j8, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 8:
                    if (!v(q0Var, obj, i8) || !g2.v(x2.i(j8, q0Var), x2.i(j8, obj))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!v(q0Var, obj, i8) || !g2.v(x2.i(j8, q0Var), x2.i(j8, obj))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!v(q0Var, obj, i8) || !g2.v(x2.i(j8, q0Var), x2.i(j8, obj))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!v(q0Var, obj, i8) || x2.f(j8, q0Var) != x2.f(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!v(q0Var, obj, i8) || x2.f(j8, q0Var) != x2.f(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!v(q0Var, obj, i8) || x2.f(j8, q0Var) != x2.f(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!v(q0Var, obj, i8) || x2.g(j8, q0Var) != x2.g(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!v(q0Var, obj, i8) || x2.f(j8, q0Var) != x2.f(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!v(q0Var, obj, i8) || x2.g(j8, q0Var) != x2.g(j8, obj)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!v(q0Var, obj, i8) || !g2.v(x2.i(j8, q0Var), x2.i(j8, obj))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    zV = g2.v(x2.i(j8, q0Var), x2.i(j8, obj));
                    break;
                case 50:
                    zV = g2.v(x2.i(j8, q0Var), x2.i(j8, obj));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                case 68:
                    long j10 = iArr[i8 + 2] & 1048575;
                    if (x2.f(j10, q0Var) != x2.f(j10, obj) || !g2.v(x2.i(j8, q0Var), x2.i(j8, obj))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zV) {
                return false;
            }
        }
        this.f7308k.getClass();
        if (!q0Var.zzc.equals(((q0) obj).zzc)) {
            return false;
        }
        if (!this.f) {
            return true;
        }
        this.f7309l.getClass();
        return ((n0) q0Var).zza.equals(((n0) obj).zza);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x00b6. Please report as an issue. */
    @Override // l3.f2
    public final void d(Object obj, byte[] bArr, int i8, int i9, t tVar) throws b1 {
        int i10;
        int I;
        int i11;
        int i12;
        int i13;
        int i14;
        Unsafe unsafe;
        int i15;
        boolean z2;
        int i16;
        t tVar2;
        char c9;
        boolean z3;
        char c10;
        t tVar3;
        t tVar4;
        int i17;
        Unsafe unsafe2;
        int i18;
        int i19;
        char c11;
        t1 t1Var = this;
        Object obj2 = obj;
        bArr = bArr;
        i9 = i9;
        tVar = tVar;
        a3 a3Var = a3.zza;
        int i20 = -1;
        if (t1Var.f7310m - 1 == 0) {
            A(obj, bArr, i8, i9, 0, tVar);
            return;
        }
        p(obj);
        Unsafe unsafe3 = f7299o;
        int i21 = 0;
        int iM = i8;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        int i25 = 1048575;
        while (iM < i9) {
            int i26 = iM + 1;
            byte b9 = bArr[iM];
            if (b9 < 0) {
                int iO = k2.o(b9, bArr, i26, tVar);
                i10 = tVar.f7294a;
                i26 = iO;
            } else {
                i10 = b9;
            }
            int i27 = i10 >>> 3;
            int i28 = t1Var.f7303d;
            int i29 = t1Var.f7302c;
            if (i27 > i24) {
                int i30 = i22 / 3;
                if (i27 < i29 || i27 > i28) {
                    I = i20;
                } else {
                    I = t1Var.I(i27, i30);
                }
            } else if (i27 < i29 || i27 > i28) {
                I = i20;
            } else {
                I = t1Var.I(i27, i21);
            }
            int i31 = I;
            if (i31 == i20) {
                i11 = i27;
                i12 = i23;
                i13 = i25;
                i14 = i21;
                unsafe = unsafe3;
                i15 = i20;
                z2 = true;
            } else {
                int i32 = i10 & 7;
                int[] iArr = t1Var.f7300a;
                int i33 = iArr[i31 + 1];
                int iJ = J(i33);
                Unsafe unsafe4 = unsafe3;
                long j8 = i33 & 1048575;
                if (iJ <= 17) {
                    int i34 = iArr[i31 + 2];
                    int i35 = 1 << (i34 >>> 20);
                    int i36 = 1048575;
                    int i37 = i34 & 1048575;
                    if (i37 != i25) {
                        if (i25 != 1048575) {
                            long j10 = i25;
                            unsafe2 = unsafe4;
                            unsafe2.putInt(obj2, j10, i23);
                            i36 = 1048575;
                        } else {
                            unsafe2 = unsafe4;
                        }
                        if (i37 != i36) {
                            i23 = unsafe2.getInt(obj2, i37);
                        }
                        i25 = i37;
                        i16 = i23;
                        unsafe3 = unsafe2;
                    } else {
                        unsafe3 = unsafe4;
                        i16 = i23;
                        i25 = i25;
                    }
                    switch (iJ) {
                        case 0:
                            i11 = i27;
                            i22 = i31;
                            z3 = true;
                            if (i32 != 1) {
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                x2.l(obj2, j8, Double.longBitsToDouble(k2.u(i26, bArr)));
                                iM = i26 + 8;
                                i23 = i16 | i35;
                                tVar = tVar;
                                i21 = 0;
                                i20 = -1;
                                i24 = i11;
                            }
                            break;
                        case 1:
                            tVar2 = tVar;
                            i11 = i27;
                            i22 = i31;
                            if (i32 != 5) {
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                x2.m(obj2, j8, Float.intBitsToFloat(k2.d(i26, bArr)));
                                i23 = i16 | i35;
                                iM = i26 + 4;
                                tVar = tVar2;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        case 2:
                        case 3:
                            tVar2 = tVar;
                            i11 = i27;
                            i22 = i31;
                            c9 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 0) {
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                int iQ = k2.q(bArr, i26, tVar2);
                                unsafe3.putLong(obj, j8, tVar2.f7295b);
                                i23 = i16 | i35;
                                i22 = i22;
                                iM = iQ;
                                tVar = tVar2;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        case 4:
                        case 11:
                            tVar2 = tVar;
                            i11 = i27;
                            i22 = i31;
                            c9 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 0) {
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                iM = k2.n(bArr, i26, tVar2);
                                unsafe3.putInt(obj2, j8, tVar2.f7294a);
                                i23 = i16 | i35;
                                tVar = tVar2;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        case 5:
                        case 14:
                            tVar2 = tVar;
                            i11 = i27;
                            if (i32 != 1) {
                                z3 = true;
                                i22 = i31;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                unsafe3.putLong(obj, j8, k2.u(i26, bArr));
                                iM = i26 + 8;
                                i23 = i16 | i35;
                                i22 = i31;
                                tVar = tVar2;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        case 6:
                        case 13:
                            tVar4 = tVar;
                            i11 = i27;
                            i17 = i31;
                            c9 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 5) {
                                i22 = i17;
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                unsafe3.putInt(obj2, j8, k2.d(i26, bArr));
                                iM = i26 + 4;
                                int i38 = i16 | i35;
                                i22 = i17;
                                tVar = tVar4;
                                i21 = 0;
                                i20 = -1;
                                i23 = i38;
                                i24 = i11;
                            }
                            break;
                        case 7:
                            tVar4 = tVar;
                            i11 = i27;
                            i17 = i31;
                            c9 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 0) {
                                i22 = i17;
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                iM = k2.q(bArr, i26, tVar4);
                                x2.k(obj2, j8, tVar4.f7295b != 0);
                                int i39 = i16 | i35;
                                i22 = i17;
                                tVar = tVar4;
                                i21 = 0;
                                i20 = -1;
                                i23 = i39;
                                i24 = i11;
                            }
                            break;
                        case 8:
                            tVar4 = tVar;
                            i11 = i27;
                            i17 = i31;
                            c9 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 2) {
                                i22 = i17;
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                iM = (536870912 & i33) == 0 ? k2.k(bArr, i26, tVar4) : k2.l(bArr, i26, tVar4);
                                unsafe3.putObject(obj2, j8, tVar4.f7296c);
                                int i310 = i16 | i35;
                                i22 = i17;
                                tVar = tVar4;
                                i21 = 0;
                                i20 = -1;
                                i23 = i310;
                                i24 = i11;
                            }
                            break;
                        case 9:
                            tVar2 = tVar;
                            i11 = i27;
                            c10 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 2) {
                                i22 = i31;
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                Object objM = t1Var.m(i31, obj2);
                                iM = k2.s(objM, t1Var.k(i31), bArr, i26, i9, tVar);
                                t1Var.t(i31, obj2, objM);
                                i23 = i16 | i35;
                                i22 = i31;
                                tVar = tVar2;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        case 10:
                            tVar3 = tVar;
                            i11 = i27;
                            c10 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 2) {
                                i22 = i31;
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                int iA = k2.a(bArr, i26, tVar3);
                                unsafe3.putObject(obj2, j8, tVar3.f7296c);
                                i23 = i16 | i35;
                                iM = iA;
                                tVar = tVar3;
                                i22 = i31;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        case 12:
                            tVar3 = tVar;
                            i11 = i27;
                            c10 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 0) {
                                i22 = i31;
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                iM = k2.n(bArr, i26, tVar3);
                                unsafe3.putInt(obj2, j8, tVar3.f7294a);
                                i23 = i16 | i35;
                                tVar = tVar3;
                                i22 = i31;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        case 15:
                            tVar3 = tVar;
                            i11 = i27;
                            c10 = CharCompanionObject.MAX_VALUE;
                            if (i32 != 0) {
                                i22 = i31;
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                iM = k2.n(bArr, i26, tVar3);
                                unsafe3.putInt(obj2, j8, k2.c(tVar3.f7294a));
                                i23 = i16 | i35;
                                tVar = tVar3;
                                i22 = i31;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        case 16:
                            if (i32 != 0) {
                                i11 = i27;
                                i22 = i31;
                                z3 = true;
                                z2 = z3;
                                i21 = i22;
                                unsafe = unsafe3;
                                i12 = i16;
                                i13 = i25;
                                i15 = -1;
                                i14 = 0;
                            } else {
                                tVar3 = tVar;
                                int iQ2 = k2.q(bArr, i26, tVar3);
                                i11 = i27;
                                unsafe3.putLong(obj, j8, k2.f(tVar3.f7295b));
                                i23 = i16 | i35;
                                iM = iQ2;
                                tVar = tVar3;
                                i22 = i31;
                                i24 = i11;
                                i21 = 0;
                                i20 = -1;
                                i9 = i9;
                            }
                            break;
                        default:
                            i11 = i27;
                            i22 = i31;
                            z3 = true;
                            z2 = z3;
                            i21 = i22;
                            unsafe = unsafe3;
                            i12 = i16;
                            i13 = i25;
                            i15 = -1;
                            i14 = 0;
                            break;
                    }
                } else {
                    i11 = i27;
                    if (iJ != 27) {
                        z2 = true;
                        int i40 = i23;
                        i14 = 0;
                        if (iJ <= 49) {
                            i12 = i40;
                            i13 = i25;
                            i15 = -1;
                            int i41 = i26;
                            unsafe = unsafe4;
                            iM = H(obj, bArr, i26, i9, i10, i11, i32, i31, i33, iJ, j8, tVar);
                            if (iM != i41) {
                                obj2 = obj;
                                i22 = i31;
                            } else {
                                i26 = iM;
                                i21 = i31;
                                obj2 = obj;
                                iM = k2.m(i10, bArr, i26, i9, B(obj), tVar);
                                i22 = i21;
                                obj2 = obj2;
                            }
                            i20 = i15;
                            i21 = i14;
                        } else {
                            i12 = i40;
                            i13 = i25;
                            i18 = i26;
                            unsafe = unsafe4;
                            i19 = i31;
                            i15 = -1;
                            if (iJ == 50) {
                                c11 = 2;
                                if (i32 == 2) {
                                    F(i19, j8, obj);
                                    throw null;
                                }
                            } else {
                                obj2 = obj;
                                iM = G(obj, bArr, i18, i9, i10, i11, i32, i33, iJ, j8, i19, tVar);
                                if (iM != i18) {
                                    bArr = bArr;
                                    i9 = i9;
                                    tVar = tVar;
                                    obj2 = obj2;
                                    i20 = -1;
                                    i21 = 0;
                                    i22 = i19;
                                } else {
                                    i26 = iM;
                                    i21 = i19;
                                    iM = k2.m(i10, bArr, i26, i9, B(obj), tVar);
                                    i22 = i21;
                                    obj2 = obj2;
                                    i20 = i15;
                                    i21 = i14;
                                }
                            }
                        }
                        i24 = i11;
                        i23 = i12;
                        i25 = i13;
                        unsafe3 = unsafe;
                        t1Var = this;
                    } else if (i32 == 2) {
                        r rVar = (r) ((y0) unsafe4.getObject(obj2, j8));
                        boolean zF = rVar.f();
                        r rVar2 = rVar;
                        if (!zF) {
                            int size = rVar.size();
                            y0 y0VarB = rVar.b(size == 0 ? 10 : size + size);
                            unsafe4.putObject(obj2, j8, y0VarB);
                            rVar2 = y0VarB;
                        }
                        iM = k2.h(t1Var.k(i31), i10, bArr, i26, i9, rVar2, tVar);
                        i25 = i25;
                        unsafe3 = unsafe4;
                        i22 = i31;
                        i23 = i23;
                        i21 = 0;
                        i24 = i11;
                        i20 = -1;
                        i9 = i9;
                        tVar = tVar;
                    } else {
                        i14 = 0;
                        z2 = true;
                        i12 = i23;
                        i13 = i25;
                        c11 = 2;
                        i18 = i26;
                        unsafe = unsafe4;
                        i19 = i31;
                        i15 = -1;
                    }
                    i26 = i18;
                    i21 = i19;
                    obj2 = obj;
                    iM = k2.m(i10, bArr, i26, i9, B(obj), tVar);
                    i22 = i21;
                    obj2 = obj2;
                    i20 = i15;
                    i21 = i14;
                    i24 = i11;
                    i23 = i12;
                    i25 = i13;
                    unsafe3 = unsafe;
                    t1Var = this;
                }
            }
            iM = k2.m(i10, bArr, i26, i9, B(obj), tVar);
            i22 = i21;
            obj2 = obj2;
            i20 = i15;
            i21 = i14;
            i24 = i11;
            i23 = i12;
            i25 = i13;
            unsafe3 = unsafe;
            t1Var = this;
        }
        int i42 = i23;
        int i43 = i25;
        Unsafe unsafe5 = unsafe3;
        Object obj3 = obj2;
        if (i43 != 1048575) {
            unsafe5.putInt(obj3, i43, i42);
        }
        if (iM != i9) {
            throw b1.zze();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x032b  */
    /* JADX WARN: Code duplicated, block: B:101:0x033c  */
    /* JADX WARN: Code duplicated, block: B:102:0x034d  */
    /* JADX WARN: Code duplicated, block: B:103:0x035d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0371  */
    /* JADX WARN: Code duplicated, block: B:105:0x0381  */
    /* JADX WARN: Code duplicated, block: B:106:0x0392  */
    /* JADX WARN: Code duplicated, block: B:107:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:108:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:109:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:110:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:111:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:112:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:113:0x0409  */
    /* JADX WARN: Code duplicated, block: B:115:0x040f  */
    /* JADX WARN: Code duplicated, block: B:116:0x041f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0425  */
    /* JADX WARN: Code duplicated, block: B:119:0x0431  */
    /* JADX WARN: Code duplicated, block: B:121:0x0437  */
    /* JADX WARN: Code duplicated, block: B:122:0x0443  */
    /* JADX WARN: Code duplicated, block: B:124:0x0449  */
    /* JADX WARN: Code duplicated, block: B:125:0x0455  */
    /* JADX WARN: Code duplicated, block: B:127:0x045b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0467  */
    /* JADX WARN: Code duplicated, block: B:130:0x046d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0479  */
    /* JADX WARN: Code duplicated, block: B:133:0x047f  */
    /* JADX WARN: Code duplicated, block: B:134:0x048b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0491  */
    /* JADX WARN: Code duplicated, block: B:137:0x049f  */
    /* JADX WARN: Code duplicated, block: B:139:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:140:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:142:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:143:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:145:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:146:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:148:0x04df  */
    /* JADX WARN: Code duplicated, block: B:149:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:151:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:152:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:154:0x0501  */
    /* JADX WARN: Code duplicated, block: B:155:0x050c  */
    /* JADX WARN: Code duplicated, block: B:157:0x0512  */
    /* JADX WARN: Code duplicated, block: B:158:0x051d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0523  */
    /* JADX WARN: Code duplicated, block: B:161:0x052e  */
    /* JADX WARN: Code duplicated, block: B:163:0x0534  */
    /* JADX WARN: Code duplicated, block: B:164:0x053f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0545  */
    /* JADX WARN: Code duplicated, block: B:179:0x0598  */
    /* JADX WARN: Code duplicated, block: B:22:0x006d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0073  */
    /* JADX WARN: Code duplicated, block: B:25:0x0083  */
    /* JADX WARN: Code duplicated, block: B:27:0x0089  */
    /* JADX WARN: Code duplicated, block: B:28:0x0095  */
    /* JADX WARN: Code duplicated, block: B:30:0x009b  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:360:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:362:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:364:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:366:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:368:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:370:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:372:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:374:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:376:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:378:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:380:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:382:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:384:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:386:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:390:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:392:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:394:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:396:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:430:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:432:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:434:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:436:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:438:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:440:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:442:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:444:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:446:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:448:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:450:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:452:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:454:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:456:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:458:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:460:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:462:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:464:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:465:0x054f A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:466:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0103  */
    /* JADX WARN: Code duplicated, block: B:48:0x0109  */
    /* JADX WARN: Code duplicated, block: B:49:0x0119  */
    /* JADX WARN: Code duplicated, block: B:51:0x011f  */
    /* JADX WARN: Code duplicated, block: B:52:0x012b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0131  */
    /* JADX WARN: Code duplicated, block: B:55:0x0143  */
    /* JADX WARN: Code duplicated, block: B:57:0x0149  */
    /* JADX WARN: Code duplicated, block: B:58:0x0155  */
    /* JADX WARN: Code duplicated, block: B:60:0x015b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0167  */
    /* JADX WARN: Code duplicated, block: B:63:0x016d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0179  */
    /* JADX WARN: Code duplicated, block: B:66:0x017f  */
    /* JADX WARN: Code duplicated, block: B:67:0x018b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0191  */
    /* JADX WARN: Code duplicated, block: B:70:0x019d  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:73:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:75:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:76:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:81:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:82:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:83:0x020a  */
    /* JADX WARN: Code duplicated, block: B:84:0x021b  */
    /* JADX WARN: Code duplicated, block: B:85:0x022c  */
    /* JADX WARN: Code duplicated, block: B:86:0x023d  */
    /* JADX WARN: Code duplicated, block: B:87:0x024e  */
    /* JADX WARN: Code duplicated, block: B:88:0x025f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0270  */
    /* JADX WARN: Code duplicated, block: B:8:0x0038  */
    /* JADX WARN: Code duplicated, block: B:90:0x0281  */
    /* JADX WARN: Code duplicated, block: B:91:0x0292  */
    /* JADX WARN: Code duplicated, block: B:92:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:93:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:94:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:95:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:96:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:97:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:98:0x0309  */
    /* JADX WARN: Code duplicated, block: B:99:0x031a  */
    @Override // l3.f2
    public final void e(Object obj, l1 l1Var) throws d0 {
        Iterator itD;
        Map.Entry entry;
        int i8;
        boolean z2;
        boolean z3;
        boolean z5;
        boolean z10;
        Iterator itD2;
        Map.Entry entry2;
        a3 a3Var = a3.zza;
        int i9 = this.f7310m - 1;
        int[] iArr = this.f7300a;
        p2 p2Var = this.f7308k;
        boolean z11 = this.f;
        g0 g0Var = this.f7309l;
        if (i9 == 0) {
            if (z11) {
                g0Var.getClass();
                i0 i0VarB = g0.b(obj);
                if (i0VarB.f7250a.isEmpty()) {
                    itD = null;
                    entry = null;
                } else {
                    itD = i0VarB.d();
                    entry = (Map.Entry) ((m2) itD).next();
                }
            } else {
                itD = null;
                entry = null;
            }
            Unsafe unsafe = f7299o;
            int i10 = 1048575;
            int i11 = 0;
            int i12 = 0;
            for (int length = iArr.length; i11 < length; length = length) {
                int iK = K(i11);
                int i13 = iArr[i11];
                int iJ = J(iK);
                entry = entry;
                if (iJ <= 17) {
                    int i14 = iArr[i11 + 2];
                    int i15 = i14 & 1048575;
                    if (i15 != i10) {
                        i12 = unsafe.getInt(obj, i15);
                        i10 = i15;
                    }
                    i8 = 1 << (i14 >>> 20);
                } else {
                    i8 = 0;
                }
                while (true) {
                    if (entry != null) {
                        g0Var.getClass();
                        i10 = i10;
                        if (g0.a(entry) <= i13) {
                            g0.d(l1Var, entry);
                            m2 m2Var = (m2) itD;
                            entry = m2Var.hasNext() ? (Map.Entry) m2Var.next() : null;
                        }
                    } else {
                        i10 = i10;
                    }
                }
                long j8 = iK & 1048575;
                switch (iJ) {
                    case 0:
                        if ((i8 & i12) != 0) {
                            l1Var.h(i13, x2.d(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 1:
                        if ((i8 & i12) != 0) {
                            l1Var.l(i13, x2.e(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 2:
                        if ((i8 & i12) != 0) {
                            l1Var.o(i13, unsafe.getLong(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 3:
                        if ((i8 & i12) != 0) {
                            l1Var.d(i13, unsafe.getLong(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 4:
                        if ((i8 & i12) != 0) {
                            l1Var.n(i13, unsafe.getInt(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 5:
                        if ((i8 & i12) != 0) {
                            l1Var.k(i13, unsafe.getLong(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 6:
                        if ((i8 & i12) != 0) {
                            l1Var.j(i13, unsafe.getInt(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 7:
                        if ((i8 & i12) != 0) {
                            l1Var.e(i13, x2.t(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 8:
                        if ((i8 & i12) != 0) {
                            z(i13, unsafe.getObject(obj, j8), l1Var);
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 9:
                        if ((i8 & i12) != 0) {
                            l1Var.p(i13, unsafe.getObject(obj, j8), k(i11));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 10:
                        if ((i8 & i12) != 0) {
                            l1Var.g(i13, (b0) unsafe.getObject(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 11:
                        if ((i8 & i12) != 0) {
                            l1Var.c(i13, unsafe.getInt(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 12:
                        if ((i8 & i12) != 0) {
                            l1Var.i(i13, unsafe.getInt(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 13:
                        if ((i8 & i12) != 0) {
                            l1Var.r(i13, unsafe.getInt(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 14:
                        if ((i8 & i12) != 0) {
                            l1Var.s(i13, unsafe.getLong(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 15:
                        if ((i8 & i12) != 0) {
                            l1Var.a(i13, unsafe.getInt(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 16:
                        if ((i8 & i12) != 0) {
                            l1Var.b(i13, unsafe.getLong(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 17:
                        if ((i8 & i12) != 0) {
                            l1Var.m(i13, unsafe.getObject(obj, j8), k(i11));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 18:
                        z2 = true;
                        g2.f(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 19:
                        z2 = true;
                        g2.j(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 20:
                        z2 = true;
                        g2.m(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 21:
                        z2 = true;
                        g2.u(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 22:
                        z2 = true;
                        g2.l(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 23:
                        z2 = true;
                        g2.i(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 24:
                        z2 = true;
                        g2.h(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 25:
                        z2 = true;
                        int i16 = iArr[i11];
                        List list = (List) unsafe.getObject(obj, j8);
                        z3 = false;
                        g2.d(i16, list, l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 26:
                        z5 = true;
                        g2.s(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 27:
                        z5 = true;
                        g2.n(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, k(i11));
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 28:
                        z5 = true;
                        g2.e(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 29:
                        z10 = false;
                        z2 = true;
                        g2.t(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                        z10 = false;
                        z2 = true;
                        g2.g(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 31:
                        z10 = false;
                        z2 = true;
                        g2.o(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 32:
                        z10 = false;
                        z2 = true;
                        g2.p(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 33:
                        z10 = false;
                        z2 = true;
                        g2.q(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 34:
                        z2 = true;
                        int i17 = iArr[i11];
                        List list2 = (List) unsafe.getObject(obj, j8);
                        z3 = false;
                        g2.r(i17, list2, l1Var, false);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 35:
                        z5 = true;
                        g2.f(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 36:
                        z5 = true;
                        g2.j(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 37:
                        z5 = true;
                        g2.m(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 38:
                        z5 = true;
                        g2.u(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 39:
                        z5 = true;
                        g2.l(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 40:
                        z5 = true;
                        g2.i(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 41:
                        z5 = true;
                        g2.h(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 42:
                        z5 = true;
                        g2.d(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 43:
                        z5 = true;
                        g2.t(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 44:
                        z5 = true;
                        g2.g(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 45:
                        z5 = true;
                        g2.o(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 46:
                        z5 = true;
                        g2.p(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 47:
                        z5 = true;
                        g2.q(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        z5 = true;
                        g2.r(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, true);
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        g2.k(iArr[i11], (List) unsafe.getObject(obj, j8), l1Var, k(i11));
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 50:
                        if (unsafe.getObject(obj, j8) != null) {
                            l(i11).getClass();
                            throw new ClassCastException();
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (y(i13, i11, obj)) {
                            l1Var.h(i13, ((Double) x2.i(j8, obj)).doubleValue());
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (y(i13, i11, obj)) {
                            l1Var.l(i13, ((Float) x2.i(j8, obj)).floatValue());
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (y(i13, i11, obj)) {
                            l1Var.o(i13, L(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (y(i13, i11, obj)) {
                            l1Var.d(i13, L(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (y(i13, i11, obj)) {
                            l1Var.n(i13, E(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 56:
                        if (y(i13, i11, obj)) {
                            l1Var.k(i13, L(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 57:
                        if (y(i13, i11, obj)) {
                            l1Var.j(i13, E(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 58:
                        if (y(i13, i11, obj)) {
                            l1Var.e(i13, ((Boolean) x2.i(j8, obj)).booleanValue());
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 59:
                        if (y(i13, i11, obj)) {
                            z(i13, unsafe.getObject(obj, j8), l1Var);
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 60:
                        if (y(i13, i11, obj)) {
                            l1Var.p(i13, unsafe.getObject(obj, j8), k(i11));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 61:
                        if (y(i13, i11, obj)) {
                            l1Var.g(i13, (b0) unsafe.getObject(obj, j8));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 62:
                        if (y(i13, i11, obj)) {
                            l1Var.c(i13, E(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        if (y(i13, i11, obj)) {
                            l1Var.i(i13, E(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 64:
                        if (y(i13, i11, obj)) {
                            l1Var.r(i13, E(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (y(i13, i11, obj)) {
                            l1Var.s(i13, L(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (y(i13, i11, obj)) {
                            l1Var.a(i13, E(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                        if (y(i13, i11, obj)) {
                            l1Var.b(i13, L(j8, obj));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    case 68:
                        if (y(i13, i11, obj)) {
                            l1Var.m(i13, unsafe.getObject(obj, j8), k(i11));
                        }
                        i11 += 3;
                        i10 = i10;
                        break;
                    default:
                        i11 += 3;
                        i10 = i10;
                        break;
                }
            }
            while (entry != null) {
                g0Var.getClass();
                g0.d(l1Var, entry);
                m2 m2Var2 = (m2) itD;
                entry = m2Var2.hasNext() ? (Map.Entry) m2Var2.next() : null;
            }
            p2Var.getClass();
            p2.d(p2.b(obj), l1Var);
            return;
        }
        if (z11) {
            g0Var.getClass();
            i0 i0VarB2 = g0.b(obj);
            if (i0VarB2.f7250a.isEmpty()) {
                itD2 = null;
                entry2 = null;
            } else {
                itD2 = i0VarB2.d();
                entry2 = (Map.Entry) ((m2) itD2).next();
            }
        } else {
            itD2 = null;
            entry2 = null;
        }
        int length2 = iArr.length;
        for (int i18 = 0; i18 < length2; i18 += 3) {
            int iK2 = K(i18);
            int i19 = iArr[i18];
            while (entry2 != null) {
                g0Var.getClass();
                if (g0.a(entry2) <= i19) {
                    g0.d(l1Var, entry2);
                    m2 m2Var3 = (m2) itD2;
                    entry2 = m2Var3.hasNext() ? (Map.Entry) m2Var3.next() : null;
                } else {
                    switch (J(iK2)) {
                        case 0:
                            if (w(i18, obj)) {
                                l1Var.h(i19, x2.d(iK2 & 1048575, obj));
                            }
                            break;
                        case 1:
                            if (w(i18, obj)) {
                                l1Var.l(i19, x2.e(iK2 & 1048575, obj));
                            }
                            break;
                        case 2:
                            if (w(i18, obj)) {
                                l1Var.o(i19, x2.g(iK2 & 1048575, obj));
                            }
                            break;
                        case 3:
                            if (w(i18, obj)) {
                                l1Var.d(i19, x2.g(iK2 & 1048575, obj));
                            }
                            break;
                        case 4:
                            if (w(i18, obj)) {
                                l1Var.n(i19, x2.f(iK2 & 1048575, obj));
                            }
                            break;
                        case 5:
                            if (w(i18, obj)) {
                                l1Var.k(i19, x2.g(iK2 & 1048575, obj));
                            }
                            break;
                        case 6:
                            if (w(i18, obj)) {
                                l1Var.j(i19, x2.f(iK2 & 1048575, obj));
                            }
                            break;
                        case 7:
                            if (w(i18, obj)) {
                                l1Var.e(i19, x2.t(iK2 & 1048575, obj));
                            }
                            break;
                        case 8:
                            if (w(i18, obj)) {
                                z(i19, x2.i(iK2 & 1048575, obj), l1Var);
                            }
                            break;
                        case 9:
                            if (w(i18, obj)) {
                                l1Var.p(i19, x2.i(iK2 & 1048575, obj), k(i18));
                            }
                            break;
                        case 10:
                            if (w(i18, obj)) {
                                l1Var.g(i19, (b0) x2.i(iK2 & 1048575, obj));
                            }
                            break;
                        case 11:
                            if (w(i18, obj)) {
                                l1Var.c(i19, x2.f(iK2 & 1048575, obj));
                            }
                            break;
                        case 12:
                            if (w(i18, obj)) {
                                l1Var.i(i19, x2.f(iK2 & 1048575, obj));
                            }
                            break;
                        case 13:
                            if (w(i18, obj)) {
                                l1Var.r(i19, x2.f(iK2 & 1048575, obj));
                            }
                            break;
                        case 14:
                            if (w(i18, obj)) {
                                l1Var.s(i19, x2.g(iK2 & 1048575, obj));
                            }
                            break;
                        case 15:
                            if (w(i18, obj)) {
                                l1Var.a(i19, x2.f(iK2 & 1048575, obj));
                            }
                            break;
                        case 16:
                            if (w(i18, obj)) {
                                l1Var.b(i19, x2.g(iK2 & 1048575, obj));
                            }
                            break;
                        case 17:
                            if (w(i18, obj)) {
                                l1Var.m(i19, x2.i(iK2 & 1048575, obj), k(i18));
                            }
                            break;
                        case 18:
                            g2.f(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 19:
                            g2.j(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 20:
                            g2.m(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 21:
                            g2.u(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 22:
                            g2.l(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 23:
                            g2.i(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 24:
                            g2.h(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 25:
                            g2.d(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 26:
                            g2.s(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var);
                            break;
                        case 27:
                            g2.n(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, k(i18));
                            break;
                        case 28:
                            g2.e(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var);
                            break;
                        case 29:
                            g2.t(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                            g2.g(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 31:
                            g2.o(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 32:
                            g2.p(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 33:
                            g2.q(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 34:
                            g2.r(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                            break;
                        case 35:
                            g2.f(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 36:
                            g2.j(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 37:
                            g2.m(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 38:
                            g2.u(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 39:
                            g2.l(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 40:
                            g2.i(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 41:
                            g2.h(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 42:
                            g2.d(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 43:
                            g2.t(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 44:
                            g2.g(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 45:
                            g2.o(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 46:
                            g2.p(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case 47:
                            g2.q(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            g2.r(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                            g2.k(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, k(i18));
                            break;
                        case 50:
                            if (x2.i(iK2 & 1048575, obj) == null) {
                                l(i18).getClass();
                                throw new ClassCastException();
                            }
                            break;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                            if (y(i19, i18, obj)) {
                                l1Var.h(i19, ((Double) x2.i(iK2 & 1048575, obj)).doubleValue());
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                            if (y(i19, i18, obj)) {
                                l1Var.l(i19, ((Float) x2.i(iK2 & 1048575, obj)).floatValue());
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                            if (y(i19, i18, obj)) {
                                l1Var.o(i19, L(iK2 & 1048575, obj));
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                            if (y(i19, i18, obj)) {
                                l1Var.d(i19, L(iK2 & 1048575, obj));
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                            if (y(i19, i18, obj)) {
                                l1Var.n(i19, E(iK2 & 1048575, obj));
                            }
                            break;
                        case 56:
                            if (y(i19, i18, obj)) {
                                l1Var.k(i19, L(iK2 & 1048575, obj));
                            }
                            break;
                        case 57:
                            if (y(i19, i18, obj)) {
                                l1Var.j(i19, E(iK2 & 1048575, obj));
                            }
                            break;
                        case 58:
                            if (y(i19, i18, obj)) {
                                l1Var.e(i19, ((Boolean) x2.i(iK2 & 1048575, obj)).booleanValue());
                            }
                            break;
                        case 59:
                            if (y(i19, i18, obj)) {
                                z(i19, x2.i(iK2 & 1048575, obj), l1Var);
                            }
                            break;
                        case 60:
                            if (y(i19, i18, obj)) {
                                l1Var.p(i19, x2.i(iK2 & 1048575, obj), k(i18));
                            }
                            break;
                        case 61:
                            if (y(i19, i18, obj)) {
                                l1Var.g(i19, (b0) x2.i(iK2 & 1048575, obj));
                            }
                            break;
                        case 62:
                            if (y(i19, i18, obj)) {
                                l1Var.c(i19, E(iK2 & 1048575, obj));
                            }
                            break;
                        case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                            if (y(i19, i18, obj)) {
                                l1Var.i(i19, E(iK2 & 1048575, obj));
                            }
                            break;
                        case 64:
                            if (y(i19, i18, obj)) {
                                l1Var.r(i19, E(iK2 & 1048575, obj));
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                            if (y(i19, i18, obj)) {
                                l1Var.s(i19, L(iK2 & 1048575, obj));
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                            if (y(i19, i18, obj)) {
                                l1Var.a(i19, E(iK2 & 1048575, obj));
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                            if (y(i19, i18, obj)) {
                                l1Var.b(i19, L(iK2 & 1048575, obj));
                            }
                            break;
                        case 68:
                            if (y(i19, i18, obj)) {
                                l1Var.m(i19, x2.i(iK2 & 1048575, obj), k(i18));
                            }
                            break;
                    }
                }
            }
            switch (J(iK2)) {
                case 0:
                    if (w(i18, obj)) {
                        l1Var.h(i19, x2.d(iK2 & 1048575, obj));
                    }
                    break;
                case 1:
                    if (w(i18, obj)) {
                        l1Var.l(i19, x2.e(iK2 & 1048575, obj));
                    }
                    break;
                case 2:
                    if (w(i18, obj)) {
                        l1Var.o(i19, x2.g(iK2 & 1048575, obj));
                    }
                    break;
                case 3:
                    if (w(i18, obj)) {
                        l1Var.d(i19, x2.g(iK2 & 1048575, obj));
                    }
                    break;
                case 4:
                    if (w(i18, obj)) {
                        l1Var.n(i19, x2.f(iK2 & 1048575, obj));
                    }
                    break;
                case 5:
                    if (w(i18, obj)) {
                        l1Var.k(i19, x2.g(iK2 & 1048575, obj));
                    }
                    break;
                case 6:
                    if (w(i18, obj)) {
                        l1Var.j(i19, x2.f(iK2 & 1048575, obj));
                    }
                    break;
                case 7:
                    if (w(i18, obj)) {
                        l1Var.e(i19, x2.t(iK2 & 1048575, obj));
                    }
                    break;
                case 8:
                    if (w(i18, obj)) {
                        z(i19, x2.i(iK2 & 1048575, obj), l1Var);
                    }
                    break;
                case 9:
                    if (w(i18, obj)) {
                        l1Var.p(i19, x2.i(iK2 & 1048575, obj), k(i18));
                    }
                    break;
                case 10:
                    if (w(i18, obj)) {
                        l1Var.g(i19, (b0) x2.i(iK2 & 1048575, obj));
                    }
                    break;
                case 11:
                    if (w(i18, obj)) {
                        l1Var.c(i19, x2.f(iK2 & 1048575, obj));
                    }
                    break;
                case 12:
                    if (w(i18, obj)) {
                        l1Var.i(i19, x2.f(iK2 & 1048575, obj));
                    }
                    break;
                case 13:
                    if (w(i18, obj)) {
                        l1Var.r(i19, x2.f(iK2 & 1048575, obj));
                    }
                    break;
                case 14:
                    if (w(i18, obj)) {
                        l1Var.s(i19, x2.g(iK2 & 1048575, obj));
                    }
                    break;
                case 15:
                    if (w(i18, obj)) {
                        l1Var.a(i19, x2.f(iK2 & 1048575, obj));
                    }
                    break;
                case 16:
                    if (w(i18, obj)) {
                        l1Var.b(i19, x2.g(iK2 & 1048575, obj));
                    }
                    break;
                case 17:
                    if (w(i18, obj)) {
                        l1Var.m(i19, x2.i(iK2 & 1048575, obj), k(i18));
                    }
                    break;
                case 18:
                    g2.f(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 19:
                    g2.j(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 20:
                    g2.m(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 21:
                    g2.u(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 22:
                    g2.l(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 23:
                    g2.i(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 24:
                    g2.h(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 25:
                    g2.d(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 26:
                    g2.s(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var);
                    break;
                case 27:
                    g2.n(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, k(i18));
                    break;
                case 28:
                    g2.e(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var);
                    break;
                case 29:
                    g2.t(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    g2.g(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 31:
                    g2.o(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 32:
                    g2.p(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 33:
                    g2.q(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 34:
                    g2.r(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, false);
                    break;
                case 35:
                    g2.f(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 36:
                    g2.j(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 37:
                    g2.m(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 38:
                    g2.u(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 39:
                    g2.l(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 40:
                    g2.i(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 41:
                    g2.h(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 42:
                    g2.d(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 43:
                    g2.t(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 44:
                    g2.g(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 45:
                    g2.o(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 46:
                    g2.p(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case 47:
                    g2.q(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    g2.r(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    g2.k(iArr[i18], (List) x2.i(iK2 & 1048575, obj), l1Var, k(i18));
                    break;
                case 50:
                    if (x2.i(iK2 & 1048575, obj) == null) {
                        l(i18).getClass();
                        throw new ClassCastException();
                    }
                    break;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (y(i19, i18, obj)) {
                        l1Var.h(i19, ((Double) x2.i(iK2 & 1048575, obj)).doubleValue());
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (y(i19, i18, obj)) {
                        l1Var.l(i19, ((Float) x2.i(iK2 & 1048575, obj)).floatValue());
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (y(i19, i18, obj)) {
                        l1Var.o(i19, L(iK2 & 1048575, obj));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (y(i19, i18, obj)) {
                        l1Var.d(i19, L(iK2 & 1048575, obj));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (y(i19, i18, obj)) {
                        l1Var.n(i19, E(iK2 & 1048575, obj));
                    }
                    break;
                case 56:
                    if (y(i19, i18, obj)) {
                        l1Var.k(i19, L(iK2 & 1048575, obj));
                    }
                    break;
                case 57:
                    if (y(i19, i18, obj)) {
                        l1Var.j(i19, E(iK2 & 1048575, obj));
                    }
                    break;
                case 58:
                    if (y(i19, i18, obj)) {
                        l1Var.e(i19, ((Boolean) x2.i(iK2 & 1048575, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (y(i19, i18, obj)) {
                        z(i19, x2.i(iK2 & 1048575, obj), l1Var);
                    }
                    break;
                case 60:
                    if (y(i19, i18, obj)) {
                        l1Var.p(i19, x2.i(iK2 & 1048575, obj), k(i18));
                    }
                    break;
                case 61:
                    if (y(i19, i18, obj)) {
                        l1Var.g(i19, (b0) x2.i(iK2 & 1048575, obj));
                    }
                    break;
                case 62:
                    if (y(i19, i18, obj)) {
                        l1Var.c(i19, E(iK2 & 1048575, obj));
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (y(i19, i18, obj)) {
                        l1Var.i(i19, E(iK2 & 1048575, obj));
                    }
                    break;
                case 64:
                    if (y(i19, i18, obj)) {
                        l1Var.r(i19, E(iK2 & 1048575, obj));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (y(i19, i18, obj)) {
                        l1Var.s(i19, L(iK2 & 1048575, obj));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (y(i19, i18, obj)) {
                        l1Var.a(i19, E(iK2 & 1048575, obj));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (y(i19, i18, obj)) {
                        l1Var.b(i19, L(iK2 & 1048575, obj));
                    }
                    break;
                case 68:
                    if (y(i19, i18, obj)) {
                        l1Var.m(i19, x2.i(iK2 & 1048575, obj), k(i18));
                    }
                    break;
            }
        }
        while (entry2 != null) {
            g0Var.getClass();
            g0.d(l1Var, entry2);
            m2 m2Var4 = (m2) itD2;
            entry2 = m2Var4.hasNext() ? (Map.Entry) m2Var4.next() : null;
        }
        p2Var.getClass();
        p2.d(p2.b(obj), l1Var);
    }

    @Override // l3.f2
    public final void f(Object obj, Object obj2) {
        p(obj);
        obj2.getClass();
        int i8 = 0;
        while (true) {
            int[] iArr = this.f7300a;
            if (i8 >= iArr.length) {
                g2.c(this.f7308k, obj, obj2);
                if (this.f) {
                    g2.b(this.f7309l, obj, obj2);
                    return;
                }
                return;
            }
            int iK = K(i8);
            int i9 = iArr[i8];
            long j8 = iK & 1048575;
            switch (J(iK)) {
                case 0:
                    if (w(i8, obj2)) {
                        x2.l(obj, j8, x2.f7322c.a(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 1:
                    if (w(i8, obj2)) {
                        x2.m(obj, j8, x2.f7322c.b(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 2:
                    if (w(i8, obj2)) {
                        x2.o(obj, j8, x2.g(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 3:
                    if (w(i8, obj2)) {
                        x2.o(obj, j8, x2.g(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 4:
                    if (w(i8, obj2)) {
                        x2.n(x2.f(j8, obj2), j8, obj);
                        s(i8, obj);
                    }
                    break;
                case 5:
                    if (w(i8, obj2)) {
                        x2.o(obj, j8, x2.g(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 6:
                    if (w(i8, obj2)) {
                        x2.n(x2.f(j8, obj2), j8, obj);
                        s(i8, obj);
                    }
                    break;
                case 7:
                    if (w(i8, obj2)) {
                        x2.k(obj, j8, x2.f7322c.g(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 8:
                    if (w(i8, obj2)) {
                        x2.p(j8, obj, x2.i(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 9:
                    q(i8, obj, obj2);
                    break;
                case 10:
                    if (w(i8, obj2)) {
                        x2.p(j8, obj, x2.i(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 11:
                    if (w(i8, obj2)) {
                        x2.n(x2.f(j8, obj2), j8, obj);
                        s(i8, obj);
                    }
                    break;
                case 12:
                    if (w(i8, obj2)) {
                        x2.n(x2.f(j8, obj2), j8, obj);
                        s(i8, obj);
                    }
                    break;
                case 13:
                    if (w(i8, obj2)) {
                        x2.n(x2.f(j8, obj2), j8, obj);
                        s(i8, obj);
                    }
                    break;
                case 14:
                    if (w(i8, obj2)) {
                        x2.o(obj, j8, x2.g(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 15:
                    if (w(i8, obj2)) {
                        x2.n(x2.f(j8, obj2), j8, obj);
                        s(i8, obj);
                    }
                    break;
                case 16:
                    if (w(i8, obj2)) {
                        x2.o(obj, j8, x2.g(j8, obj2));
                        s(i8, obj);
                    }
                    break;
                case 17:
                    q(i8, obj, obj2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    this.f7307j.b(j8, obj, obj2);
                    break;
                case 50:
                    Class cls = g2.f7238a;
                    x2.p(j8, obj, n1.b(x2.i(j8, obj), x2.i(j8, obj2)));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (y(i9, i8, obj2)) {
                        x2.p(j8, obj, x2.i(j8, obj2));
                        x2.n(i9, iArr[i8 + 2] & 1048575, obj);
                    }
                    break;
                case 60:
                    r(i8, obj, obj2);
                    break;
                case 61:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (y(i9, i8, obj2)) {
                        x2.p(j8, obj, x2.i(j8, obj2));
                        x2.n(i9, iArr[i8 + 2] & 1048575, obj);
                    }
                    break;
                case 68:
                    r(i8, obj, obj2);
                    break;
            }
            i8 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00db A[PHI: r3
      0x00db: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:84:0x01e8, B:42:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // l3.f2
    public final int g(q0 q0Var) {
        int i8;
        long jDoubleToLongBits;
        int i9;
        int iFloatToIntBits;
        int i10;
        int[] iArr = this.f7300a;
        int length = iArr.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int iK = K(i12);
            int i13 = iArr[i12];
            long j8 = 1048575 & iK;
            int i14 = 1237;
            int iHashCode = 37;
            switch (J(iK)) {
                case 0:
                    i8 = i11 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(x2.f7322c.a(j8, q0Var));
                    Charset charset = z0.f7328a;
                    i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i9 = i11 * 53;
                    iFloatToIntBits = Float.floatToIntBits(x2.f7322c.b(j8, q0Var));
                    i11 = iFloatToIntBits + i9;
                    break;
                case 2:
                    i8 = i11 * 53;
                    jDoubleToLongBits = x2.g(j8, q0Var);
                    Charset charset2 = z0.f7328a;
                    i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i8 = i11 * 53;
                    jDoubleToLongBits = x2.g(j8, q0Var);
                    Charset charset3 = z0.f7328a;
                    i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.f(j8, q0Var);
                    i11 = iFloatToIntBits + i9;
                    break;
                case 5:
                    i8 = i11 * 53;
                    jDoubleToLongBits = x2.g(j8, q0Var);
                    Charset charset4 = z0.f7328a;
                    i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.f(j8, q0Var);
                    i11 = iFloatToIntBits + i9;
                    break;
                case 7:
                    i10 = i11 * 53;
                    boolean zG = x2.f7322c.g(j8, q0Var);
                    Charset charset5 = z0.f7328a;
                    if (zG) {
                        i14 = 1231;
                    }
                    i11 = i14 + i10;
                    break;
                case 8:
                    i9 = i11 * 53;
                    iFloatToIntBits = ((String) x2.i(j8, q0Var)).hashCode();
                    i11 = iFloatToIntBits + i9;
                    break;
                case 9:
                    Object objI = x2.i(j8, q0Var);
                    if (objI != null) {
                        iHashCode = objI.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 10:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.i(j8, q0Var).hashCode();
                    i11 = iFloatToIntBits + i9;
                    break;
                case 11:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.f(j8, q0Var);
                    i11 = iFloatToIntBits + i9;
                    break;
                case 12:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.f(j8, q0Var);
                    i11 = iFloatToIntBits + i9;
                    break;
                case 13:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.f(j8, q0Var);
                    i11 = iFloatToIntBits + i9;
                    break;
                case 14:
                    i8 = i11 * 53;
                    jDoubleToLongBits = x2.g(j8, q0Var);
                    Charset charset6 = z0.f7328a;
                    i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.f(j8, q0Var);
                    i11 = iFloatToIntBits + i9;
                    break;
                case 16:
                    i8 = i11 * 53;
                    jDoubleToLongBits = x2.g(j8, q0Var);
                    Charset charset7 = z0.f7328a;
                    i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    Object objI2 = x2.i(j8, q0Var);
                    if (objI2 != null) {
                        iHashCode = objI2.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.i(j8, q0Var).hashCode();
                    i11 = iFloatToIntBits + i9;
                    break;
                case 50:
                    i9 = i11 * 53;
                    iFloatToIntBits = x2.i(j8, q0Var).hashCode();
                    i11 = iFloatToIntBits + i9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (y(i13, i12, q0Var)) {
                        i8 = i11 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) x2.i(j8, q0Var)).doubleValue());
                        Charset charset8 = z0.f7328a;
                        i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) x2.i(j8, q0Var)).floatValue());
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (y(i13, i12, q0Var)) {
                        i8 = i11 * 53;
                        jDoubleToLongBits = L(j8, q0Var);
                        Charset charset9 = z0.f7328a;
                        i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (y(i13, i12, q0Var)) {
                        i8 = i11 * 53;
                        jDoubleToLongBits = L(j8, q0Var);
                        Charset charset10 = z0.f7328a;
                        i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = E(j8, q0Var);
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case 56:
                    if (y(i13, i12, q0Var)) {
                        i8 = i11 * 53;
                        jDoubleToLongBits = L(j8, q0Var);
                        Charset charset11 = z0.f7328a;
                        i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 57:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = E(j8, q0Var);
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case 58:
                    if (y(i13, i12, q0Var)) {
                        i10 = i11 * 53;
                        boolean zBooleanValue = ((Boolean) x2.i(j8, q0Var)).booleanValue();
                        Charset charset12 = z0.f7328a;
                        if (zBooleanValue) {
                            i14 = 1231;
                        }
                        i11 = i14 + i10;
                    }
                    break;
                case 59:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = ((String) x2.i(j8, q0Var)).hashCode();
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case 60:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = x2.i(j8, q0Var).hashCode();
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case 61:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = x2.i(j8, q0Var).hashCode();
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case 62:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = E(j8, q0Var);
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = E(j8, q0Var);
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case 64:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = E(j8, q0Var);
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (y(i13, i12, q0Var)) {
                        i8 = i11 * 53;
                        jDoubleToLongBits = L(j8, q0Var);
                        Charset charset13 = z0.f7328a;
                        i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = E(j8, q0Var);
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (y(i13, i12, q0Var)) {
                        i8 = i11 * 53;
                        jDoubleToLongBits = L(j8, q0Var);
                        Charset charset14 = z0.f7328a;
                        i11 = i8 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (y(i13, i12, q0Var)) {
                        i9 = i11 * 53;
                        iFloatToIntBits = x2.i(j8, q0Var).hashCode();
                        i11 = iFloatToIntBits + i9;
                    }
                    break;
            }
        }
        this.f7308k.getClass();
        int iHashCode2 = q0Var.zzc.hashCode() + (i11 * 53);
        if (!this.f) {
            return iHashCode2;
        }
        this.f7309l.getClass();
        return ((n0) q0Var).zza.f7250a.hashCode() + (iHashCode2 * 53);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0092  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x012e  */
    @Override // l3.f2
    public final int h(q0 q0Var) {
        int i8;
        int iR;
        int i9;
        int iO;
        int i10;
        int iZzd;
        int iQ;
        int iJ;
        int i11;
        int i12;
        int iQ2;
        int iQ3;
        int iR2;
        int iD;
        int i13;
        int iQ4;
        a3 a3Var = a3.zza;
        if (this.f7310m - 1 == 0) {
            return D(q0Var);
        }
        Unsafe unsafe = f7299o;
        int i14 = 0;
        int iC = 0;
        while (true) {
            int[] iArr = this.f7300a;
            if (i14 >= iArr.length) {
                this.f7308k.getClass();
                return p2.a(p2.b(q0Var)) + iC;
            }
            int iK = K(i14);
            int iJ2 = J(iK);
            int i15 = iArr[i14];
            int i16 = iK & 1048575;
            if (iJ2 >= j0.zzJ.zza() && iJ2 <= j0.zzW.zza()) {
                int i17 = iArr[i14 + 2];
            }
            long j8 = i16;
            switch (iJ2) {
                case 0:
                    if (w(i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 8, iC);
                    }
                    break;
                case 1:
                    if (w(i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 4, iC);
                    }
                    break;
                case 2:
                    if (w(i14, q0Var)) {
                        i8 = i15 << 3;
                        iR = c0.r(x2.g(j8, q0Var));
                        iC = h0.a.b(i8, iR, iC);
                    }
                    break;
                case 3:
                    if (w(i14, q0Var)) {
                        i8 = i15 << 3;
                        iR = c0.r(x2.g(j8, q0Var));
                        iC = h0.a.b(i8, iR, iC);
                    }
                    break;
                case 4:
                    if (w(i14, q0Var)) {
                        i9 = i15 << 3;
                        iO = c0.o(x2.f(j8, q0Var));
                        iC = h0.a.b(i9, iO, iC);
                    }
                    break;
                case 5:
                    if (w(i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 8, iC);
                    }
                    break;
                case 6:
                    if (w(i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 4, iC);
                    }
                    break;
                case 7:
                    if (w(i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 1, iC);
                    }
                    break;
                case 8:
                    if (w(i14, q0Var)) {
                        Object objI = x2.i(j8, q0Var);
                        if (!(objI instanceof b0)) {
                            i9 = i15 << 3;
                            iO = c0.p((String) objI);
                            iC = h0.a.b(i9, iO, iC);
                        } else {
                            i10 = i15 << 3;
                            Logger logger = c0.e;
                            iZzd = ((b0) objI).zzd();
                            iQ = c0.q(iZzd);
                            iC = h0.a.b(i10, iQ + iZzd, iC);
                        }
                    }
                    break;
                case 9:
                    if (w(i14, q0Var)) {
                        iJ = g2.J(i15, x2.i(j8, q0Var), k(i14));
                        iC = iJ + iC;
                    }
                    break;
                case 10:
                    if (w(i14, q0Var)) {
                        b0 b0Var = (b0) x2.i(j8, q0Var);
                        i10 = i15 << 3;
                        Logger logger2 = c0.e;
                        iZzd = b0Var.zzd();
                        iQ = c0.q(iZzd);
                        iC = h0.a.b(i10, iQ + iZzd, iC);
                    }
                    break;
                case 11:
                    if (w(i14, q0Var)) {
                        i9 = i15 << 3;
                        iO = c0.q(x2.f(j8, q0Var));
                        iC = h0.a.b(i9, iO, iC);
                    }
                    break;
                case 12:
                    if (w(i14, q0Var)) {
                        i9 = i15 << 3;
                        iO = c0.o(x2.f(j8, q0Var));
                        iC = h0.a.b(i9, iO, iC);
                    }
                    break;
                case 13:
                    if (w(i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 4, iC);
                    }
                    break;
                case 14:
                    if (w(i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 8, iC);
                    }
                    break;
                case 15:
                    if (w(i14, q0Var)) {
                        int iF = x2.f(j8, q0Var);
                        i11 = iF + iF;
                        i12 = iF >> 31;
                        iQ2 = c0.q(i15 << 3);
                        iC = h0.a.b(i12 ^ i11, iQ2, iC);
                    }
                    break;
                case 16:
                    if (w(i14, q0Var)) {
                        long jG = x2.g(j8, q0Var);
                        iQ3 = c0.q(i15 << 3);
                        iR2 = c0.r((jG >> 63) ^ (jG + jG));
                        iJ = iR2 + iQ3;
                        iC = iJ + iC;
                    }
                    break;
                case 17:
                    if (w(i14, q0Var)) {
                        iJ = c0.n(i15, (q1) x2.i(j8, q0Var), k(i14));
                        iC = iJ + iC;
                    }
                    break;
                case 18:
                    iJ = g2.C(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 19:
                    iJ = g2.A(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 20:
                    iJ = g2.H(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 21:
                    iJ = g2.S(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 22:
                    iJ = g2.F(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 23:
                    iJ = g2.C(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 24:
                    iJ = g2.A(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 25:
                    iJ = g2.w(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 26:
                    iJ = g2.P(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 27:
                    iJ = g2.K(i15, (List) x2.i(j8, q0Var), k(i14));
                    iC = iJ + iC;
                    break;
                case 28:
                    iJ = g2.x(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 29:
                    iJ = g2.Q(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    iJ = g2.y(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 31:
                    iJ = g2.A(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 32:
                    iJ = g2.C(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 33:
                    iJ = g2.L(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 34:
                    iJ = g2.N(i15, (List) x2.i(j8, q0Var));
                    iC = iJ + iC;
                    break;
                case 35:
                    iD = g2.D((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 36:
                    iD = g2.B((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 37:
                    iD = g2.I((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 38:
                    iD = g2.T((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 39:
                    iD = g2.G((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 40:
                    iD = g2.D((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 41:
                    iD = g2.B((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(q0Var, j8);
                    Class cls = g2.f7238a;
                    iD = list.size();
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 43:
                    iD = g2.R((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 44:
                    iD = g2.z((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 45:
                    iD = g2.B((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 46:
                    iD = g2.D((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case 47:
                    iD = g2.M((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    iD = g2.O((List) unsafe.getObject(q0Var, j8));
                    if (iD > 0) {
                        i13 = i15 << 3;
                        iQ4 = c0.q(iD);
                        iC = h0.a.c(i13, iQ4, iD, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iJ = g2.E(i15, (List) x2.i(j8, q0Var), k(i14));
                    iC = iJ + iC;
                    break;
                case 50:
                    n1.a(x2.i(j8, q0Var), l(i14));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (y(i15, i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 8, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (y(i15, i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 4, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (y(i15, i14, q0Var)) {
                        i8 = i15 << 3;
                        iR = c0.r(L(j8, q0Var));
                        iC = h0.a.b(i8, iR, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (y(i15, i14, q0Var)) {
                        i8 = i15 << 3;
                        iR = c0.r(L(j8, q0Var));
                        iC = h0.a.b(i8, iR, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (y(i15, i14, q0Var)) {
                        i9 = i15 << 3;
                        iO = c0.o(E(j8, q0Var));
                        iC = h0.a.b(i9, iO, iC);
                    }
                    break;
                case 56:
                    if (y(i15, i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 8, iC);
                    }
                    break;
                case 57:
                    if (y(i15, i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 4, iC);
                    }
                    break;
                case 58:
                    if (y(i15, i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 1, iC);
                    }
                    break;
                case 59:
                    if (y(i15, i14, q0Var)) {
                        Object objI2 = x2.i(j8, q0Var);
                        if (!(objI2 instanceof b0)) {
                            i9 = i15 << 3;
                            iO = c0.p((String) objI2);
                            iC = h0.a.b(i9, iO, iC);
                        } else {
                            i10 = i15 << 3;
                            Logger logger3 = c0.e;
                            iZzd = ((b0) objI2).zzd();
                            iQ = c0.q(iZzd);
                            iC = h0.a.b(i10, iQ + iZzd, iC);
                        }
                    }
                    break;
                case 60:
                    if (y(i15, i14, q0Var)) {
                        iJ = g2.J(i15, x2.i(j8, q0Var), k(i14));
                        iC = iJ + iC;
                    }
                    break;
                case 61:
                    if (y(i15, i14, q0Var)) {
                        b0 b0Var2 = (b0) x2.i(j8, q0Var);
                        i10 = i15 << 3;
                        Logger logger4 = c0.e;
                        iZzd = b0Var2.zzd();
                        iQ = c0.q(iZzd);
                        iC = h0.a.b(i10, iQ + iZzd, iC);
                    }
                    break;
                case 62:
                    if (y(i15, i14, q0Var)) {
                        i9 = i15 << 3;
                        iO = c0.q(E(j8, q0Var));
                        iC = h0.a.b(i9, iO, iC);
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (y(i15, i14, q0Var)) {
                        i9 = i15 << 3;
                        iO = c0.o(E(j8, q0Var));
                        iC = h0.a.b(i9, iO, iC);
                    }
                    break;
                case 64:
                    if (y(i15, i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 4, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (y(i15, i14, q0Var)) {
                        iC = h0.a.b(i15 << 3, 8, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (y(i15, i14, q0Var)) {
                        int iE = E(j8, q0Var);
                        i11 = iE + iE;
                        i12 = iE >> 31;
                        iQ2 = c0.q(i15 << 3);
                        iC = h0.a.b(i12 ^ i11, iQ2, iC);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (y(i15, i14, q0Var)) {
                        long jL = L(j8, q0Var);
                        iQ3 = c0.q(i15 << 3);
                        iR2 = c0.r((jL >> 63) ^ (jL + jL));
                        iJ = iR2 + iQ3;
                        iC = iJ + iC;
                    }
                    break;
                case 68:
                    if (y(i15, i14, q0Var)) {
                        iJ = c0.n(i15, (q1) x2.i(j8, q0Var), k(i14));
                        iC = iJ + iC;
                    }
                    break;
            }
            i14 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00bd A[LOOP:1: B:49:0x00ac->B:54:0x00bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0 A[SYNTHETIC] */
    @Override // l3.f2
    public final boolean i(Object obj) {
        List list;
        f2 f2VarK;
        int i8;
        int i9 = 0;
        int i10 = 0;
        int i11 = 1048575;
        while (true) {
            boolean zW = true;
            if (i9 >= this.f7305h) {
                if (this.f) {
                    this.f7309l.getClass();
                    if (!g0.b(obj).g()) {
                        return false;
                    }
                }
                return true;
            }
            int i12 = this.f7304g[i9];
            int[] iArr = this.f7300a;
            int i13 = iArr[i12];
            int iK = K(i12);
            int i14 = iArr[i12 + 2];
            int i15 = i14 & 1048575;
            int i16 = 1 << (i14 >>> 20);
            if (i15 != i11) {
                if (i15 != 1048575) {
                    i10 = f7299o.getInt(obj, i15);
                }
                i11 = i15;
            }
            if ((268435456 & iK) != 0) {
                if (!(i11 == 1048575 ? w(i12, obj) : (i10 & i16) != 0)) {
                    return false;
                }
            }
            int iJ = J(iK);
            if (iJ == 9 || iJ == 17) {
                if (i11 == 1048575) {
                    zW = w(i12, obj);
                } else if ((i16 & i10) == 0) {
                    zW = false;
                }
                if (zW && !k(i12).i(x2.i(iK & 1048575, obj))) {
                    return false;
                }
            } else if (iJ == 27) {
                list = (List) x2.i(iK & 1048575, obj);
                if (list.isEmpty()) {
                    continue;
                } else {
                    f2VarK = k(i12);
                    for (i8 = 0; i8 < list.size(); i8++) {
                        if (!f2VarK.i(list.get(i8))) {
                            return false;
                        }
                    }
                }
            } else if (iJ == 60 || iJ == 68) {
                if (y(i13, i12, obj) && !k(i12).i(x2.i(iK & 1048575, obj))) {
                    return false;
                }
            } else if (iJ == 49) {
                list = (List) x2.i(iK & 1048575, obj);
                if (list.isEmpty()) {
                    f2VarK = k(i12);
                    while (i8 < list.size()) {
                        if (!f2VarK.i(list.get(i8))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iJ == 50 && !((m1) x2.i(iK & 1048575, obj)).isEmpty()) {
                o.d.y(l(i12));
                throw null;
            }
            i9++;
        }
    }

    public final u0 j(int i8) {
        int i9 = i8 / 3;
        return (u0) this.f7301b[i9 + i9 + 1];
    }

    public final f2 k(int i8) {
        int i9 = i8 / 3;
        int i10 = i9 + i9;
        Object[] objArr = this.f7301b;
        f2 f2Var = (f2) objArr[i10];
        if (f2Var != null) {
            return f2Var;
        }
        f2 f2VarB = y1.f7325c.b((Class) objArr[i10 + 1]);
        objArr[i10] = f2VarB;
        return f2VarB;
    }

    public final Object l(int i8) {
        int i9 = i8 / 3;
        return this.f7301b[i9 + i9];
    }

    public final Object m(int i8, Object obj) {
        f2 f2VarK = k(i8);
        int iK = K(i8) & 1048575;
        if (!w(i8, obj)) {
            return f2VarK.a();
        }
        Object object = f7299o.getObject(obj, iK);
        if (x(object)) {
            return object;
        }
        Object objA = f2VarK.a();
        if (object != null) {
            f2VarK.f(objA, object);
        }
        return objA;
    }

    public final Object n(int i8, int i9, Object obj) {
        f2 f2VarK = k(i9);
        if (!y(i8, i9, obj)) {
            return f2VarK.a();
        }
        Object object = f7299o.getObject(obj, K(i9) & 1048575);
        if (x(object)) {
            return object;
        }
        Object objA = f2VarK.a();
        if (object != null) {
            f2VarK.f(objA, object);
        }
        return objA;
    }

    public final void q(int i8, Object obj, Object obj2) {
        if (w(i8, obj2)) {
            int iK = K(i8) & 1048575;
            Unsafe unsafe = f7299o;
            long j8 = iK;
            Object object = unsafe.getObject(obj2, j8);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f7300a[i8] + " is present but null: " + obj2.toString());
            }
            f2 f2VarK = k(i8);
            if (!w(i8, obj)) {
                if (x(object)) {
                    Object objA = f2VarK.a();
                    f2VarK.f(objA, object);
                    unsafe.putObject(obj, j8, objA);
                } else {
                    unsafe.putObject(obj, j8, object);
                }
                s(i8, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j8);
            if (!x(object2)) {
                Object objA2 = f2VarK.a();
                f2VarK.f(objA2, object2);
                unsafe.putObject(obj, j8, objA2);
                object2 = objA2;
            }
            f2VarK.f(object2, object);
        }
    }

    public final void r(int i8, Object obj, Object obj2) {
        int[] iArr = this.f7300a;
        int i9 = iArr[i8];
        if (y(i9, i8, obj2)) {
            int iK = K(i8) & 1048575;
            Unsafe unsafe = f7299o;
            long j8 = iK;
            Object object = unsafe.getObject(obj2, j8);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i8] + " is present but null: " + obj2.toString());
            }
            f2 f2VarK = k(i8);
            if (!y(i9, i8, obj)) {
                if (x(object)) {
                    Object objA = f2VarK.a();
                    f2VarK.f(objA, object);
                    unsafe.putObject(obj, j8, objA);
                } else {
                    unsafe.putObject(obj, j8, object);
                }
                x2.n(i9, iArr[i8 + 2] & 1048575, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j8);
            if (!x(object2)) {
                Object objA2 = f2VarK.a();
                f2VarK.f(objA2, object2);
                unsafe.putObject(obj, j8, objA2);
                object2 = objA2;
            }
            f2VarK.f(object2, object);
        }
    }

    public final void s(int i8, Object obj) {
        int i9 = this.f7300a[i8 + 2];
        long j8 = 1048575 & i9;
        if (j8 == 1048575) {
            return;
        }
        x2.n((1 << (i9 >>> 20)) | x2.f(j8, obj), j8, obj);
    }

    public final void t(int i8, Object obj, Object obj2) {
        f7299o.putObject(obj, K(i8) & 1048575, obj2);
        s(i8, obj);
    }

    public final void u(int i8, Object obj, int i9, Object obj2) {
        f7299o.putObject(obj, K(i9) & 1048575, obj2);
        x2.n(i8, this.f7300a[i9 + 2] & 1048575, obj);
    }

    public final boolean v(q0 q0Var, Object obj, int i8) {
        return w(i8, q0Var) == w(i8, obj);
    }

    public final boolean w(int i8, Object obj) {
        int i9 = this.f7300a[i8 + 2];
        long j8 = i9 & 1048575;
        if (j8 != 1048575) {
            return ((1 << (i9 >>> 20)) & x2.f(j8, obj)) != 0;
        }
        int iK = K(i8);
        long j10 = iK & 1048575;
        switch (J(iK)) {
            case 0:
                return Double.doubleToRawLongBits(x2.f7322c.a(j10, obj)) != 0;
            case 1:
                return Float.floatToRawIntBits(x2.f7322c.b(j10, obj)) != 0;
            case 2:
                return x2.g(j10, obj) != 0;
            case 3:
                return x2.g(j10, obj) != 0;
            case 4:
                return x2.f(j10, obj) != 0;
            case 5:
                return x2.g(j10, obj) != 0;
            case 6:
                return x2.f(j10, obj) != 0;
            case 7:
                return x2.f7322c.g(j10, obj);
            case 8:
                Object objI = x2.i(j10, obj);
                if (objI instanceof String) {
                    return !((String) objI).isEmpty();
                }
                if (objI instanceof b0) {
                    return !b0.zzb.equals(objI);
                }
                throw new IllegalArgumentException();
            case 9:
                return x2.i(j10, obj) != null;
            case 10:
                return !b0.zzb.equals(x2.i(j10, obj));
            case 11:
                return x2.f(j10, obj) != 0;
            case 12:
                return x2.f(j10, obj) != 0;
            case 13:
                return x2.f(j10, obj) != 0;
            case 14:
                return x2.g(j10, obj) != 0;
            case 15:
                return x2.f(j10, obj) != 0;
            case 16:
                return x2.g(j10, obj) != 0;
            case 17:
                return x2.i(j10, obj) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean y(int i8, int i9, Object obj) {
        return x2.f((long) (this.f7300a[i9 + 2] & 1048575), obj) == i8;
    }
}
