package s1;

import af.r5;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m1.p;
import m1.r;
import r1.s;
import r1.z;

/* JADX INFO: loaded from: classes.dex */
public final class n extends c {
    public final StringBuilder D;
    public final RectF E;
    public final Matrix F;
    public final k1.a G;
    public final k1.a H;
    public final HashMap I;
    public final LongSparseArray J;
    public final ArrayList K;
    public final m1.f L;
    public final x M;
    public final j1.j N;
    public final z O;
    public final m1.f P;
    public r Q;
    public final m1.f R;
    public r S;
    public final m1.i T;
    public r U;
    public final m1.i V;
    public r W;
    public final m1.f X;
    public r Y;
    public r Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final m1.f f9495a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final m1.f f9496b0;
    public final m1.f c0;

    public n(x xVar, i iVar) {
        dj.m mVar;
        dj.m mVar2;
        q1.a aVar;
        dj.m mVar3;
        q1.a aVar2;
        dj.m mVar4;
        q1.a aVar3;
        r5 r5Var;
        q1.a aVar4;
        r5 r5Var2;
        q1.b bVar;
        r5 r5Var3;
        q1.b bVar2;
        r5 r5Var4;
        q1.a aVar5;
        r5 r5Var5;
        q1.a aVar6;
        super(xVar, iVar);
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        k1.a aVar7 = new k1.a(1, 1);
        aVar7.setStyle(Paint.Style.FILL);
        this.G = aVar7;
        k1.a aVar8 = new k1.a(1, 2);
        aVar8.setStyle(Paint.Style.STROKE);
        this.H = aVar8;
        this.I = new HashMap();
        this.J = new LongSparseArray();
        this.K = new ArrayList();
        this.O = z.INDEX;
        this.M = xVar;
        this.N = iVar.f9473b;
        m1.f fVar = new m1.f((List) iVar.q.f574b, 2);
        this.L = fVar;
        fVar.a(this);
        f(fVar);
        tc.d dVar = iVar.f9485r;
        if (dVar != null && (r5Var5 = (r5) dVar.f10209a) != null && (aVar6 = (q1.a) r5Var5.f557b) != null) {
            m1.e eVarG = aVar6.g();
            this.P = (m1.f) eVarG;
            eVarG.a(this);
            f(eVarG);
        }
        if (dVar != null && (r5Var4 = (r5) dVar.f10209a) != null && (aVar5 = (q1.a) r5Var4.f558c) != null) {
            m1.e eVarG2 = aVar5.g();
            this.R = (m1.f) eVarG2;
            eVarG2.a(this);
            f(eVarG2);
        }
        if (dVar != null && (r5Var3 = (r5) dVar.f10209a) != null && (bVar2 = (q1.b) r5Var3.f559d) != null) {
            m1.i iVarG = bVar2.g();
            this.T = iVarG;
            iVarG.a(this);
            f(iVarG);
        }
        if (dVar != null && (r5Var2 = (r5) dVar.f10209a) != null && (bVar = (q1.b) r5Var2.e) != null) {
            m1.i iVarG2 = bVar.g();
            this.V = iVarG2;
            iVarG2.a(this);
            f(iVarG2);
        }
        if (dVar != null && (r5Var = (r5) dVar.f10209a) != null && (aVar4 = (q1.a) r5Var.f560h) != null) {
            m1.e eVarG3 = aVar4.g();
            this.X = (m1.f) eVarG3;
            eVarG3.a(this);
            f(eVarG3);
        }
        if (dVar != null && (mVar4 = (dj.m) dVar.f10210b) != null && (aVar3 = (q1.a) mVar4.f4609a) != null) {
            m1.e eVarG4 = aVar3.g();
            this.f9495a0 = (m1.f) eVarG4;
            eVarG4.a(this);
            f(eVarG4);
        }
        if (dVar != null && (mVar3 = (dj.m) dVar.f10210b) != null && (aVar2 = (q1.a) mVar3.f4610b) != null) {
            m1.e eVarG5 = aVar2.g();
            this.f9496b0 = (m1.f) eVarG5;
            eVarG5.a(this);
            f(eVarG5);
        }
        if (dVar != null && (mVar2 = (dj.m) dVar.f10210b) != null && (aVar = (q1.a) mVar2.f4611c) != null) {
            m1.e eVarG6 = aVar.g();
            this.c0 = (m1.f) eVarG6;
            eVarG6.a(this);
            f(eVarG6);
        }
        if (dVar == null || (mVar = (dj.m) dVar.f10210b) == null) {
            return;
        }
        this.O = (z) mVar.f4612d;
    }

    public static void s(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public static void t(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // s1.c, l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        j1.j jVar = this.N;
        rectF.set(0.0f, 0.0f, jVar.f5972k.width(), jVar.f5972k.height());
    }

    @Override // s1.c, p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        super.e(colorFilter, cVar);
        PointF pointF = b0.f5922a;
        if (colorFilter == 1) {
            r rVar = this.Q;
            if (rVar != null) {
                n(rVar);
            }
            r rVar2 = new r(cVar, null);
            this.Q = rVar2;
            rVar2.a(this);
            f(this.Q);
            return;
        }
        if (colorFilter == 2) {
            r rVar3 = this.S;
            if (rVar3 != null) {
                n(rVar3);
            }
            r rVar4 = new r(cVar, null);
            this.S = rVar4;
            rVar4.a(this);
            f(this.S);
            return;
        }
        if (colorFilter == b0.f5933n) {
            r rVar5 = this.U;
            if (rVar5 != null) {
                n(rVar5);
            }
            r rVar6 = new r(cVar, null);
            this.U = rVar6;
            rVar6.a(this);
            f(this.U);
            return;
        }
        if (colorFilter == b0.f5934o) {
            r rVar7 = this.W;
            if (rVar7 != null) {
                n(rVar7);
            }
            r rVar8 = new r(cVar, null);
            this.W = rVar8;
            rVar8.a(this);
            f(this.W);
            return;
        }
        if (colorFilter == b0.A) {
            r rVar9 = this.Y;
            if (rVar9 != null) {
                n(rVar9);
            }
            r rVar10 = new r(cVar, null);
            this.Y = rVar10;
            rVar10.a(this);
            f(this.Y);
            return;
        }
        if (colorFilter != b0.H) {
            if (colorFilter == b0.J) {
                m1.f fVar = this.L;
                fVar.getClass();
                fVar.k(new p(new x1.b(), cVar, new p1.c()));
                return;
            }
            return;
        }
        r rVar11 = this.Z;
        if (rVar11 != null) {
            n(rVar11);
        }
        r rVar12 = new r(cVar, null);
        this.Z = rVar12;
        rVar12.a(this);
        f(this.Z);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x035e  */
    /* JADX WARN: Code duplicated, block: B:120:0x03db  */
    /* JADX WARN: Code duplicated, block: B:122:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:123:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:127:0x0400  */
    /* JADX WARN: Code duplicated, block: B:129:0x0413  */
    /* JADX WARN: Code duplicated, block: B:132:0x041c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0434  */
    /* JADX WARN: Code duplicated, block: B:151:0x0485  */
    /* JADX WARN: Code duplicated, block: B:152:0x048e  */
    /* JADX WARN: Code duplicated, block: B:154:0x0499 A[LOOP:9: B:153:0x0497->B:154:0x0499, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:158:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:159:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:167:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x04e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0478 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:24:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:29:0x0115  */
    /* JADX WARN: Code duplicated, block: B:31:0x012a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0133  */
    /* JADX WARN: Code duplicated, block: B:36:0x0147  */
    /* JADX WARN: Code duplicated, block: B:37:0x0155  */
    /* JADX WARN: Code duplicated, block: B:39:0x0164  */
    /* JADX WARN: Code duplicated, block: B:40:0x0175  */
    /* JADX WARN: Code duplicated, block: B:42:0x0189 A[LOOP:4: B:41:0x0187->B:42:0x0189, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:49:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:50:0x01ee  */
    @Override // s1.c
    public final void i(Canvas canvas, Matrix matrix, int i8) {
        p1.d dVar;
        String str;
        String str2;
        String str3;
        Typeface typefaceCreateFromAsset;
        Typeface typeface;
        int i9;
        Typeface typeface2;
        float fFloatValue;
        float fC;
        List listAsList;
        int size;
        int i10;
        int length;
        PointF pointF;
        float f;
        List listX;
        int i11;
        m mVar;
        int i12;
        String str4;
        int length2;
        int iCodePointAt;
        int iCharCount;
        int i13;
        p1.d dVar2;
        long j8;
        LongSparseArray longSparseArray;
        StringBuilder sb2;
        int iCharCount2;
        String string;
        int iCodePointAt2;
        float fFloatValue2;
        float f4;
        int i14;
        PointF pointF2;
        float f10;
        float f11;
        k1.a aVar;
        String str5;
        String str6;
        List listX2;
        int i15;
        m mVar2;
        int i16;
        String str7;
        int i17;
        p1.e eVar;
        HashMap map;
        ArrayList arrayList;
        int size2;
        ArrayList arrayList2;
        int i18;
        int i19;
        List list;
        int i20;
        Path path;
        p1.c cVar = (p1.c) this.L.f();
        j1.j jVar = this.N;
        p1.d dVar3 = (p1.d) jVar.f.get(cVar.f8619b);
        if (dVar3 == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        r(cVar, i8, 0);
        x xVar = this.M;
        Map map2 = xVar.f6020m;
        m1.i iVar = this.V;
        String str8 = "\u0003";
        k1.a aVar2 = this.G;
        int i21 = -1;
        k1.a aVar3 = this.H;
        String str9 = dVar3.f8631c;
        String str10 = dVar3.f8629a;
        if (map2 != null || xVar.f6011a.f5969h.size() <= 0) {
            r rVar = this.Z;
            if (rVar == null || (typeface = (Typeface) rVar.f()) == null) {
                Map map3 = xVar.f6020m;
                if (map3 != null) {
                    str2 = str10;
                    if (map3.containsKey(str2)) {
                        typeface = (Typeface) map3.get(str2);
                        str8 = "\u0003";
                        dVar = dVar3;
                        str3 = "\n";
                    } else {
                        dVar = dVar3;
                        String str11 = dVar.f8630b;
                        if (map3.containsKey(str11)) {
                            typeface2 = (Typeface) map3.get(str11);
                        } else {
                            str = str9;
                            String strL = o.d.l(str2, "-", str);
                            if (map3.containsKey(strL)) {
                                typeface2 = (Typeface) map3.get(strL);
                            }
                        }
                        typeface = typeface2;
                        str3 = "\n";
                        str8 = "\u0003";
                    }
                    if (typeface == null) {
                        typeface = dVar.f8632d;
                    }
                } else {
                    dVar = dVar3;
                    str = str9;
                    str2 = str10;
                }
                r5 r5VarI = xVar.i();
                if (r5VarI != null) {
                    p1.j jVar2 = (p1.j) r5VarI.f557b;
                    jVar2.f8645a = str2;
                    jVar2.f8646b = str;
                    HashMap map4 = (HashMap) r5VarI.f558c;
                    Typeface typeface3 = (Typeface) map4.get(jVar2);
                    if (typeface3 != null) {
                        str8 = "\u0003";
                        typefaceCreateFromAsset = typeface3;
                        str3 = "\n";
                    } else {
                        HashMap map5 = (HashMap) r5VarI.f559d;
                        Typeface typeface4 = (Typeface) map5.get(str2);
                        if (typeface4 != null) {
                            typefaceCreateFromAsset = typeface4;
                            str3 = "\n";
                        } else {
                            str3 = "\n";
                            Typeface typeface5 = dVar.f8632d;
                            if (typeface5 != null) {
                                typefaceCreateFromAsset = typeface5;
                            } else {
                                typefaceCreateFromAsset = Typeface.createFromAsset((AssetManager) r5VarI.e, "fonts/" + str2 + ((String) r5VarI.f560h));
                                map5.put(str2, typefaceCreateFromAsset);
                            }
                        }
                        boolean zContains = str.contains("Italic");
                        boolean zContains2 = str.contains("Bold");
                        if (zContains && zContains2) {
                            i9 = 3;
                        } else if (zContains) {
                            i9 = 2;
                        } else {
                            i9 = zContains2 ? 1 : 0;
                        }
                        if (typefaceCreateFromAsset.getStyle() != i9) {
                            typefaceCreateFromAsset = Typeface.create(typefaceCreateFromAsset, i9);
                        }
                        map4.put(jVar2, typefaceCreateFromAsset);
                    }
                } else {
                    str3 = "\n";
                    str8 = "\u0003";
                    typefaceCreateFromAsset = null;
                }
                typeface = typefaceCreateFromAsset;
                if (typeface == null) {
                    typeface = dVar.f8632d;
                }
            } else {
                str8 = "\u0003";
                dVar = dVar3;
                str3 = "\n";
            }
            if (typeface != null) {
                String str12 = cVar.f8618a;
                aVar2.setTypeface(typeface);
                r rVar2 = this.Y;
                float fFloatValue3 = rVar2 != null ? ((Float) rVar2.f()).floatValue() : cVar.f8620c;
                aVar2.setTextSize(w1.g.c() * fFloatValue3);
                aVar3.setTypeface(aVar2.getTypeface());
                aVar3.setTextSize(aVar2.getTextSize());
                float f12 = cVar.e / 10.0f;
                r rVar3 = this.W;
                if (rVar3 != null) {
                    fFloatValue = ((Float) rVar3.f()).floatValue();
                } else {
                    if (iVar != null) {
                        fFloatValue = ((Float) iVar.f()).floatValue();
                    }
                    fC = ((w1.g.c() * f12) * fFloatValue3) / 100.0f;
                    listAsList = Arrays.asList(str12.replaceAll("\r\n", "\r").replaceAll(str8, "\r").replaceAll(str3, "\r").split("\r"));
                    size = listAsList.size();
                    i10 = 0;
                    length = 0;
                    while (i10 < size) {
                        String str13 = (String) listAsList.get(i10);
                        pointF = cVar.f8628m;
                        if (pointF == null) {
                            f = 0.0f;
                        } else {
                            f = pointF.x;
                        }
                        List list2 = listAsList;
                        listX = x(str13, f, dVar, 0.0f, fC, false);
                        i11 = 0;
                        while (i11 < listX.size()) {
                            mVar = (m) listX.get(i11);
                            i12 = i21 + 1;
                            canvas.save();
                            if (w(canvas, cVar, i12, mVar.f9494b)) {
                                str4 = mVar.f9493a;
                                length2 = 0;
                                while (length2 < str4.length()) {
                                    iCodePointAt = str4.codePointAt(length2);
                                    int i22 = i12;
                                    List list3 = listX;
                                    iCharCount = Character.charCount(iCodePointAt) + length2;
                                    while (true) {
                                        if (iCharCount < str4.length()) {
                                            i13 = size;
                                            dVar2 = dVar;
                                            break;
                                        }
                                        iCodePointAt2 = str4.codePointAt(iCharCount);
                                        i13 = size;
                                        dVar2 = dVar;
                                        if (Character.getType(iCodePointAt2) == 16 && Character.getType(iCodePointAt2) != 27 && Character.getType(iCodePointAt2) != 6 && Character.getType(iCodePointAt2) != 28 && Character.getType(iCodePointAt2) != 8 && Character.getType(iCodePointAt2) != 19) {
                                            break;
                                        }
                                        iCharCount += Character.charCount(iCodePointAt2);
                                        iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
                                        size = i13;
                                        dVar = dVar2;
                                    }
                                    j8 = iCodePointAt;
                                    longSparseArray = this.J;
                                    if (longSparseArray.containsKey(j8)) {
                                        string = (String) longSparseArray.get(j8);
                                    } else {
                                        sb2 = this.D;
                                        sb2.setLength(0);
                                        iCharCount2 = length2;
                                        while (iCharCount2 < iCharCount) {
                                            int i23 = iCharCount;
                                            int iCodePointAt3 = str4.codePointAt(iCharCount2);
                                            sb2.appendCodePoint(iCodePointAt3);
                                            iCharCount2 += Character.charCount(iCodePointAt3);
                                            iCharCount = i23;
                                        }
                                        string = sb2.toString();
                                        longSparseArray.put(j8, string);
                                    }
                                    r(cVar, i8, length + length2);
                                    if (cVar.f8626k) {
                                        s(string, aVar2, canvas);
                                        s(string, aVar3, canvas);
                                    } else {
                                        s(string, aVar3, canvas);
                                        s(string, aVar2, canvas);
                                    }
                                    canvas.translate(aVar2.measureText(string) + fC, 0.0f);
                                    length2 += string.length();
                                    listX = list3;
                                    i12 = i22;
                                    size = i13;
                                    i10 = i10;
                                    dVar = dVar2;
                                }
                            }
                            i21 = i12;
                            length = mVar.f9493a.length() + length;
                            canvas.restore();
                            i11++;
                            listX = listX;
                            size = size;
                            i10 = i10;
                            dVar = dVar;
                        }
                        i10++;
                        listAsList = list2;
                        size = size;
                    }
                }
                f12 += fFloatValue;
                fC = ((w1.g.c() * f12) * fFloatValue3) / 100.0f;
                listAsList = Arrays.asList(str12.replaceAll("\r\n", "\r").replaceAll(str8, "\r").replaceAll(str3, "\r").split("\r"));
                size = listAsList.size();
                i10 = 0;
                length = 0;
                while (i10 < size) {
                    String str14 = (String) listAsList.get(i10);
                    pointF = cVar.f8628m;
                    if (pointF == null) {
                        f = 0.0f;
                    } else {
                        f = pointF.x;
                    }
                    List list4 = listAsList;
                    listX = x(str14, f, dVar, 0.0f, fC, false);
                    i11 = 0;
                    while (i11 < listX.size()) {
                        mVar = (m) listX.get(i11);
                        i12 = i21 + 1;
                        canvas.save();
                        if (w(canvas, cVar, i12, mVar.f9494b)) {
                            str4 = mVar.f9493a;
                            length2 = 0;
                            while (length2 < str4.length()) {
                                iCodePointAt = str4.codePointAt(length2);
                                int i24 = i12;
                                List list5 = listX;
                                iCharCount = Character.charCount(iCodePointAt) + length2;
                                while (true) {
                                    if (iCharCount < str4.length()) {
                                        i13 = size;
                                        dVar2 = dVar;
                                        break;
                                    }
                                    iCodePointAt2 = str4.codePointAt(iCharCount);
                                    i13 = size;
                                    dVar2 = dVar;
                                    if (Character.getType(iCodePointAt2) == 16) {
                                    }
                                    iCharCount += Character.charCount(iCodePointAt2);
                                    iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
                                    size = i13;
                                    dVar = dVar2;
                                }
                                j8 = iCodePointAt;
                                longSparseArray = this.J;
                                if (longSparseArray.containsKey(j8)) {
                                    string = (String) longSparseArray.get(j8);
                                } else {
                                    sb2 = this.D;
                                    sb2.setLength(0);
                                    iCharCount2 = length2;
                                    while (iCharCount2 < iCharCount) {
                                        int i25 = iCharCount;
                                        int iCodePointAt4 = str4.codePointAt(iCharCount2);
                                        sb2.appendCodePoint(iCodePointAt4);
                                        iCharCount2 += Character.charCount(iCodePointAt4);
                                        iCharCount = i25;
                                    }
                                    string = sb2.toString();
                                    longSparseArray.put(j8, string);
                                }
                                r(cVar, i8, length + length2);
                                if (cVar.f8626k) {
                                    s(string, aVar2, canvas);
                                    s(string, aVar3, canvas);
                                } else {
                                    s(string, aVar3, canvas);
                                    s(string, aVar2, canvas);
                                }
                                canvas.translate(aVar2.measureText(string) + fC, 0.0f);
                                length2 += string.length();
                                listX = list5;
                                i12 = i24;
                                size = i13;
                                i10 = i10;
                                dVar = dVar2;
                            }
                        }
                        i21 = i12;
                        length = mVar.f9493a.length() + length;
                        canvas.restore();
                        i11++;
                        listX = listX;
                        size = size;
                        i10 = i10;
                        dVar = dVar;
                    }
                    i10++;
                    listAsList = list4;
                    size = size;
                }
            }
        } else {
            r rVar4 = this.Y;
            float fFloatValue4 = (rVar4 != null ? ((Float) rVar4.f()).floatValue() : cVar.f8620c) / 100.0f;
            float[] fArr = (float[]) w1.g.f10650d.get();
            float f13 = 0.0f;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            float f14 = w1.g.e;
            fArr[2] = f14;
            fArr[3] = f14;
            matrix.mapPoints(fArr);
            x xVar2 = xVar;
            Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
            List listAsList2 = Arrays.asList(cVar.f8618a.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
            int size3 = listAsList2.size();
            float f15 = cVar.e / 10.0f;
            r rVar5 = this.W;
            if (rVar5 != null) {
                fFloatValue2 = ((Float) rVar5.f()).floatValue();
            } else {
                if (iVar != null) {
                    fFloatValue2 = ((Float) iVar.f()).floatValue();
                }
                f4 = f15;
                i14 = 0;
                while (i14 < size3) {
                    String str15 = (String) listAsList2.get(i14);
                    pointF2 = cVar.f8628m;
                    if (pointF2 == null) {
                        f10 = f13;
                    } else {
                        f10 = pointF2.x;
                    }
                    f11 = fFloatValue4;
                    p1.d dVar4 = dVar3;
                    List list6 = listAsList2;
                    int i26 = size3;
                    int i27 = i14;
                    aVar = aVar3;
                    str5 = str10;
                    p1.d dVar5 = dVar3;
                    str6 = str9;
                    listX2 = x(str15, f10, dVar4, f11, f4, true);
                    i15 = 0;
                    while (i15 < listX2.size()) {
                        mVar2 = (m) listX2.get(i15);
                        i16 = i21 + 1;
                        canvas.save();
                        if (w(canvas, cVar, i16, mVar2.f9494b)) {
                            str7 = mVar2.f9493a;
                            i17 = 0;
                            while (i17 < str7.length()) {
                                List list7 = listX2;
                                eVar = (p1.e) jVar.f5969h.get(p1.e.a(str5, str7.charAt(i17), str6));
                                if (eVar == null) {
                                    i19 = i15;
                                    i16 = i16;
                                    str6 = str6;
                                    str5 = str5;
                                    xVar2 = xVar2;
                                } else {
                                    r(cVar, i8, i17);
                                    map = this.I;
                                    if (map.containsKey(eVar)) {
                                        list = (List) map.get(eVar);
                                        i19 = i15;
                                    } else {
                                        arrayList = eVar.f8633a;
                                        size2 = arrayList.size();
                                        arrayList2 = new ArrayList(size2);
                                        i18 = 0;
                                        while (i18 < size2) {
                                            arrayList2.add(new l1.e(xVar2, this, (s) arrayList.get(i18), jVar));
                                            i18++;
                                            size2 = size2;
                                            arrayList = arrayList;
                                            i15 = i15;
                                        }
                                        i19 = i15;
                                        map.put(eVar, arrayList2);
                                        list = arrayList2;
                                    }
                                    i20 = 0;
                                    while (i20 < list.size()) {
                                        path = ((l1.e) list.get(i20)).getPath();
                                        path.computeBounds(this.E, false);
                                        Matrix matrix2 = this.F;
                                        matrix2.reset();
                                        List list8 = list;
                                        matrix2.preTranslate(0.0f, (-cVar.f8622g) * w1.g.c());
                                        matrix2.preScale(f11, f11);
                                        path.transform(matrix2);
                                        if (cVar.f8626k) {
                                            t(path, aVar2, canvas);
                                            t(path, aVar, canvas);
                                        } else {
                                            t(path, aVar, canvas);
                                            t(path, aVar2, canvas);
                                        }
                                        i20++;
                                        list = list8;
                                    }
                                    canvas.translate((w1.g.c() * ((float) eVar.f8635c) * f11) + f4, 0.0f);
                                }
                                i17++;
                                xVar2 = xVar2;
                                listX2 = list7;
                                str7 = str7;
                                i16 = i16;
                                str6 = str6;
                                str5 = str5;
                                i15 = i19;
                            }
                        }
                        canvas.restore();
                        xVar2 = xVar2;
                        i21 = i16;
                        str6 = str6;
                        str5 = str5;
                        i15++;
                        listX2 = listX2;
                    }
                    String str16 = str6;
                    String str17 = str5;
                    i14 = i27 + 1;
                    dVar3 = dVar5;
                    str9 = str16;
                    str10 = str17;
                    f13 = 0.0f;
                    fFloatValue4 = f11;
                    aVar3 = aVar;
                    size3 = i26;
                    listAsList2 = list6;
                }
            }
            f15 += fFloatValue2;
            f4 = f15;
            i14 = 0;
            while (i14 < size3) {
                String str18 = (String) listAsList2.get(i14);
                pointF2 = cVar.f8628m;
                if (pointF2 == null) {
                    f10 = f13;
                } else {
                    f10 = pointF2.x;
                }
                f11 = fFloatValue4;
                p1.d dVar6 = dVar3;
                List list9 = listAsList2;
                int i28 = size3;
                int i29 = i14;
                aVar = aVar3;
                str5 = str10;
                p1.d dVar7 = dVar3;
                str6 = str9;
                listX2 = x(str18, f10, dVar6, f11, f4, true);
                i15 = 0;
                while (i15 < listX2.size()) {
                    mVar2 = (m) listX2.get(i15);
                    i16 = i21 + 1;
                    canvas.save();
                    if (w(canvas, cVar, i16, mVar2.f9494b)) {
                        str7 = mVar2.f9493a;
                        i17 = 0;
                        while (i17 < str7.length()) {
                            List list10 = listX2;
                            eVar = (p1.e) jVar.f5969h.get(p1.e.a(str5, str7.charAt(i17), str6));
                            if (eVar == null) {
                                i19 = i15;
                                i16 = i16;
                                str6 = str6;
                                str5 = str5;
                                xVar2 = xVar2;
                            } else {
                                r(cVar, i8, i17);
                                map = this.I;
                                if (map.containsKey(eVar)) {
                                    list = (List) map.get(eVar);
                                    i19 = i15;
                                } else {
                                    arrayList = eVar.f8633a;
                                    size2 = arrayList.size();
                                    arrayList2 = new ArrayList(size2);
                                    i18 = 0;
                                    while (i18 < size2) {
                                        arrayList2.add(new l1.e(xVar2, this, (s) arrayList.get(i18), jVar));
                                        i18++;
                                        size2 = size2;
                                        arrayList = arrayList;
                                        i15 = i15;
                                    }
                                    i19 = i15;
                                    map.put(eVar, arrayList2);
                                    list = arrayList2;
                                }
                                i20 = 0;
                                while (i20 < list.size()) {
                                    path = ((l1.e) list.get(i20)).getPath();
                                    path.computeBounds(this.E, false);
                                    Matrix matrix3 = this.F;
                                    matrix3.reset();
                                    List list11 = list;
                                    matrix3.preTranslate(0.0f, (-cVar.f8622g) * w1.g.c());
                                    matrix3.preScale(f11, f11);
                                    path.transform(matrix3);
                                    if (cVar.f8626k) {
                                        t(path, aVar2, canvas);
                                        t(path, aVar, canvas);
                                    } else {
                                        t(path, aVar, canvas);
                                        t(path, aVar2, canvas);
                                    }
                                    i20++;
                                    list = list11;
                                }
                                canvas.translate((w1.g.c() * ((float) eVar.f8635c) * f11) + f4, 0.0f);
                            }
                            i17++;
                            xVar2 = xVar2;
                            listX2 = list10;
                            str7 = str7;
                            i16 = i16;
                            str6 = str6;
                            str5 = str5;
                            i15 = i19;
                        }
                    }
                    canvas.restore();
                    xVar2 = xVar2;
                    i21 = i16;
                    str6 = str6;
                    str5 = str5;
                    i15++;
                    listX2 = listX2;
                }
                String str19 = str6;
                String str110 = str5;
                i14 = i29 + 1;
                dVar3 = dVar7;
                str9 = str19;
                str10 = str110;
                f13 = 0.0f;
                fFloatValue4 = f11;
                aVar3 = aVar;
                size3 = i28;
                listAsList2 = list9;
            }
        }
        canvas.restore();
    }

    public final void r(p1.c cVar, int i8, int i9) {
        r rVar = this.Q;
        k1.a aVar = this.G;
        if (rVar != null) {
            aVar.setColor(((Integer) rVar.f()).intValue());
        } else {
            m1.f fVar = this.P;
            if (fVar == null || !v(i9)) {
                aVar.setColor(cVar.f8623h);
            } else {
                aVar.setColor(((Integer) fVar.f()).intValue());
            }
        }
        r rVar2 = this.S;
        k1.a aVar2 = this.H;
        if (rVar2 != null) {
            aVar2.setColor(((Integer) rVar2.f()).intValue());
        } else {
            m1.f fVar2 = this.R;
            if (fVar2 == null || !v(i9)) {
                aVar2.setColor(cVar.f8624i);
            } else {
                aVar2.setColor(((Integer) fVar2.f()).intValue());
            }
        }
        m1.e eVar = this.f9467w.f7620j;
        int iIntValue = 100;
        int iIntValue2 = eVar == null ? 100 : ((Integer) eVar.f()).intValue();
        m1.f fVar3 = this.X;
        if (fVar3 != null && v(i9)) {
            iIntValue = ((Integer) fVar3.f()).intValue();
        }
        int iRound = Math.round((((iIntValue / 100.0f) * ((iIntValue2 * 255.0f) / 100.0f)) * i8) / 255.0f);
        aVar.setAlpha(iRound);
        aVar2.setAlpha(iRound);
        r rVar3 = this.U;
        if (rVar3 != null) {
            aVar2.setStrokeWidth(((Float) rVar3.f()).floatValue());
            return;
        }
        m1.i iVar = this.T;
        if (iVar == null || !v(i9)) {
            aVar2.setStrokeWidth(w1.g.c() * cVar.f8625j);
        } else {
            aVar2.setStrokeWidth(((Float) iVar.f()).floatValue());
        }
    }

    public final m u(int i8) {
        ArrayList arrayList = this.K;
        for (int size = arrayList.size(); size < i8; size++) {
            m mVar = new m();
            mVar.f9493a = "";
            mVar.f9494b = 0.0f;
            arrayList.add(mVar);
        }
        return (m) arrayList.get(i8 - 1);
    }

    public final boolean v(int i8) {
        m1.f fVar;
        int length = ((p1.c) this.L.f()).f8618a.length();
        m1.f fVar2 = this.f9495a0;
        if (fVar2 == null || (fVar = this.f9496b0) == null) {
            return true;
        }
        int iMin = Math.min(((Integer) fVar2.f()).intValue(), ((Integer) fVar.f()).intValue());
        int iMax = Math.max(((Integer) fVar2.f()).intValue(), ((Integer) fVar.f()).intValue());
        m1.f fVar3 = this.c0;
        if (fVar3 != null) {
            int iIntValue = ((Integer) fVar3.f()).intValue();
            iMin += iIntValue;
            iMax += iIntValue;
        }
        if (this.O == z.INDEX) {
            return i8 >= iMin && i8 < iMax;
        }
        float f = (i8 / length) * 100.0f;
        return f >= ((float) iMin) && f < ((float) iMax);
    }

    public final boolean w(Canvas canvas, p1.c cVar, int i8, float f) {
        PointF pointF = cVar.f8627l;
        PointF pointF2 = cVar.f8628m;
        float fC = w1.g.c();
        float f4 = (i8 * cVar.f * fC) + (pointF == null ? 0.0f : (cVar.f * fC) + pointF.y);
        if (this.M.f6027w && pointF2 != null && pointF != null && f4 >= pointF.y + pointF2.y + cVar.f8620c) {
            return false;
        }
        float f10 = pointF == null ? 0.0f : pointF.x;
        float f11 = pointF2 != null ? pointF2.x : 0.0f;
        int i9 = l.f9492a[cVar.f8621d.ordinal()];
        if (i9 == 1) {
            canvas.translate(f10, f4);
        } else if (i9 == 2) {
            canvas.translate((f10 + f11) - f, f4);
        } else if (i9 == 3) {
            canvas.translate(((f11 / 2.0f) + f10) - (f / 2.0f), f4);
        }
        return true;
    }

    public final List x(String str, float f, p1.d dVar, float f4, float f10, boolean z2) {
        float fMeasureText;
        int i8 = 0;
        int i9 = 0;
        boolean z3 = false;
        int i10 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (z2) {
                p1.e eVar = (p1.e) this.N.f5969h.get(p1.e.a(dVar.f8629a, cCharAt, dVar.f8631c));
                if (eVar != null) {
                    fMeasureText = (w1.g.c() * ((float) eVar.f8635c) * f4) + f10;
                }
            } else {
                fMeasureText = this.G.measureText(str.substring(i11, i11 + 1)) + f10;
            }
            if (cCharAt == ' ') {
                z3 = true;
                f13 = fMeasureText;
            } else if (z3) {
                z3 = false;
                i10 = i11;
                f12 = fMeasureText;
            } else {
                f12 += fMeasureText;
            }
            f11 += fMeasureText;
            if (f > 0.0f && f11 >= f && cCharAt != ' ') {
                i8++;
                m mVarU = u(i8);
                if (i10 == i9) {
                    String strSubstring = str.substring(i9, i11);
                    String strTrim = strSubstring.trim();
                    float length = (f11 - fMeasureText) - ((strTrim.length() - strSubstring.length()) * f13);
                    mVarU.f9493a = strTrim;
                    mVarU.f9494b = length;
                    i9 = i11;
                    i10 = i9;
                    f11 = fMeasureText;
                    f12 = f11;
                } else {
                    String strSubstring2 = str.substring(i9, i10 - 1);
                    String strTrim2 = strSubstring2.trim();
                    float length2 = ((f11 - f12) - ((strSubstring2.length() - strTrim2.length()) * f13)) - f13;
                    mVarU.f9493a = strTrim2;
                    mVarU.f9494b = length2;
                    f11 = f12;
                    i9 = i10;
                }
            }
        }
        if (f11 > 0.0f) {
            i8++;
            m mVarU2 = u(i8);
            mVarU2.f9493a = str.substring(i9);
            mVarU2.f9494b = f11;
        }
        return this.K.subList(0, i8);
    }
}
