package com.google.android.gms.common.server.response;

import a3.a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import k3.i1;
import k3.pd;
import k3.qd;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @NonNull
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new a(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parcel f1947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zan f1949d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1951i;

    public SafeParcelResponse(int i8, Parcel parcel, zan zanVar) {
        this.f1946a = i8;
        l.e(parcel);
        this.f1947b = parcel;
        this.f1948c = 2;
        this.f1949d = zanVar;
        this.e = zanVar == null ? null : zanVar.f1960c;
        this.f1950h = 2;
    }

    public static void k(StringBuilder sb2, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse$Field) entry.getValue()).f1941i, entry);
        }
        sb2.append('{');
        int iS = pd.s(parcel);
        boolean z2 = false;
        while (parcel.dataPosition() < iS) {
            int i8 = parcel.readInt();
            Map.Entry entry2 = (Map.Entry) sparseArray.get((char) i8);
            if (entry2 != null) {
                if (z2) {
                    sb2.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) entry2.getValue();
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                StringToIntConverter stringToIntConverter = fastJsonResponse$Field.f1945m;
                BigInteger bigInteger = null;
                BigInteger bigInteger2 = null;
                Parcel[] parcelArr = null;
                boolean[] zArrCreateBooleanArray = null;
                BigDecimal[] bigDecimalArr = null;
                double[] dArrCreateDoubleArray = null;
                float[] fArrCreateFloatArray = null;
                long[] jArrCreateLongArray = null;
                BigInteger[] bigIntegerArr = null;
                Parcel parcelObtain = null;
                int i9 = fastJsonResponse$Field.f1939d;
                if (stringToIntConverter != null) {
                    switch (i9) {
                        case 0:
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, Integer.valueOf(pd.n(parcel, i8))));
                            break;
                        case 1:
                            int iQ = pd.q(parcel, i8);
                            int iDataPosition = parcel.dataPosition();
                            if (iQ != 0) {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iQ);
                                bigInteger2 = new BigInteger(bArrCreateByteArray);
                            }
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, bigInteger2));
                            break;
                        case 2:
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, Long.valueOf(pd.o(parcel, i8))));
                            break;
                        case 3:
                            pd.t(parcel, i8, 4);
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, Float.valueOf(parcel.readFloat())));
                            break;
                        case 4:
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, Double.valueOf(pd.l(parcel, i8))));
                            break;
                        case 5:
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, pd.a(parcel, i8)));
                            break;
                        case 6:
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, Boolean.valueOf(pd.k(parcel, i8))));
                            break;
                        case 7:
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, pd.f(parcel, i8)));
                            break;
                        case 8:
                        case 9:
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, pd.c(parcel, i8)));
                            break;
                        case 10:
                            Bundle bundleB = pd.b(parcel, i8);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleB.keySet()) {
                                String string = bundleB.getString(str2);
                                l.e(string);
                                map2.put(str2, string);
                            }
                            m(sb2, fastJsonResponse$Field, FastSafeParcelableJsonResponse.h(fastJsonResponse$Field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(a1.a.o(i9, "Unknown field out type = "));
                    }
                } else {
                    boolean z3 = fastJsonResponse$Field.e;
                    String str3 = fastJsonResponse$Field.f1943k;
                    if (z3) {
                        sb2.append("[");
                        switch (i9) {
                            case 0:
                                int[] iArrD = pd.d(parcel, i8);
                                int length = iArrD.length;
                                for (int i10 = 0; i10 < length; i10++) {
                                    if (i10 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(Integer.toString(iArrD[i10]));
                                }
                                break;
                            case 1:
                                int iQ2 = pd.q(parcel, i8);
                                int iDataPosition2 = parcel.dataPosition();
                                if (iQ2 != 0) {
                                    int i11 = parcel.readInt();
                                    bigIntegerArr = new BigInteger[i11];
                                    for (int i12 = 0; i12 < i11; i12++) {
                                        bigIntegerArr[i12] = new BigInteger(parcel.createByteArray());
                                    }
                                    parcel.setDataPosition(iDataPosition2 + iQ2);
                                }
                                int length2 = bigIntegerArr.length;
                                for (int i13 = 0; i13 < length2; i13++) {
                                    if (i13 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(bigIntegerArr[i13]);
                                }
                                break;
                            case 2:
                                int iQ3 = pd.q(parcel, i8);
                                int iDataPosition3 = parcel.dataPosition();
                                if (iQ3 != 0) {
                                    jArrCreateLongArray = parcel.createLongArray();
                                    parcel.setDataPosition(iDataPosition3 + iQ3);
                                }
                                int length3 = jArrCreateLongArray.length;
                                for (int i14 = 0; i14 < length3; i14++) {
                                    if (i14 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(Long.toString(jArrCreateLongArray[i14]));
                                }
                                break;
                            case 3:
                                int iQ4 = pd.q(parcel, i8);
                                int iDataPosition4 = parcel.dataPosition();
                                if (iQ4 != 0) {
                                    fArrCreateFloatArray = parcel.createFloatArray();
                                    parcel.setDataPosition(iDataPosition4 + iQ4);
                                }
                                int length4 = fArrCreateFloatArray.length;
                                for (int i15 = 0; i15 < length4; i15++) {
                                    if (i15 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(Float.toString(fArrCreateFloatArray[i15]));
                                }
                                break;
                            case 4:
                                int iQ5 = pd.q(parcel, i8);
                                int iDataPosition5 = parcel.dataPosition();
                                if (iQ5 != 0) {
                                    dArrCreateDoubleArray = parcel.createDoubleArray();
                                    parcel.setDataPosition(iDataPosition5 + iQ5);
                                }
                                int length5 = dArrCreateDoubleArray.length;
                                for (int i16 = 0; i16 < length5; i16++) {
                                    if (i16 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(Double.toString(dArrCreateDoubleArray[i16]));
                                }
                                break;
                            case 5:
                                int iQ6 = pd.q(parcel, i8);
                                int iDataPosition6 = parcel.dataPosition();
                                if (iQ6 != 0) {
                                    int i17 = parcel.readInt();
                                    bigDecimalArr = new BigDecimal[i17];
                                    for (int i18 = 0; i18 < i17; i18++) {
                                        bigDecimalArr[i18] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
                                    }
                                    parcel.setDataPosition(iDataPosition6 + iQ6);
                                }
                                int length6 = bigDecimalArr.length;
                                for (int i19 = 0; i19 < length6; i19++) {
                                    if (i19 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(bigDecimalArr[i19]);
                                }
                                break;
                            case 6:
                                int iQ7 = pd.q(parcel, i8);
                                int iDataPosition7 = parcel.dataPosition();
                                if (iQ7 != 0) {
                                    zArrCreateBooleanArray = parcel.createBooleanArray();
                                    parcel.setDataPosition(iDataPosition7 + iQ7);
                                }
                                int length7 = zArrCreateBooleanArray.length;
                                for (int i20 = 0; i20 < length7; i20++) {
                                    if (i20 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(Boolean.toString(zArrCreateBooleanArray[i20]));
                                }
                                break;
                            case 7:
                                String[] strArrG = pd.g(parcel, i8);
                                int length8 = strArrG.length;
                                for (int i21 = 0; i21 < length8; i21++) {
                                    if (i21 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append("\"");
                                    sb2.append(strArrG[i21]);
                                    sb2.append("\"");
                                }
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                int iQ8 = pd.q(parcel, i8);
                                int iDataPosition8 = parcel.dataPosition();
                                if (iQ8 != 0) {
                                    int i22 = parcel.readInt();
                                    Parcel[] parcelArr2 = new Parcel[i22];
                                    for (int i23 = 0; i23 < i22; i23++) {
                                        int i24 = parcel.readInt();
                                        if (i24 != 0) {
                                            int iDataPosition9 = parcel.dataPosition();
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            parcelObtain2.appendFrom(parcel, iDataPosition9, i24);
                                            parcelArr2[i23] = parcelObtain2;
                                            parcel.setDataPosition(iDataPosition9 + i24);
                                        } else {
                                            parcelArr2[i23] = null;
                                        }
                                    }
                                    parcel.setDataPosition(iDataPosition8 + iQ8);
                                    parcelArr = parcelArr2;
                                }
                                int length9 = parcelArr.length;
                                for (int i25 = 0; i25 < length9; i25++) {
                                    if (i25 > 0) {
                                        sb2.append(",");
                                    }
                                    parcelArr[i25].setDataPosition(0);
                                    l.e(str3);
                                    l.e(fastJsonResponse$Field.f1944l);
                                    Map map3 = (Map) fastJsonResponse$Field.f1944l.f1959b.get(str3);
                                    l.e(map3);
                                    k(sb2, map3, parcelArr[i25]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        sb2.append("]");
                    } else {
                        switch (i9) {
                            case 0:
                                sb2.append(pd.n(parcel, i8));
                                break;
                            case 1:
                                int iQ9 = pd.q(parcel, i8);
                                int iDataPosition10 = parcel.dataPosition();
                                if (iQ9 != 0) {
                                    byte[] bArrCreateByteArray2 = parcel.createByteArray();
                                    parcel.setDataPosition(iDataPosition10 + iQ9);
                                    bigInteger = new BigInteger(bArrCreateByteArray2);
                                }
                                sb2.append(bigInteger);
                                break;
                            case 2:
                                sb2.append(pd.o(parcel, i8));
                                break;
                            case 3:
                                pd.t(parcel, i8, 4);
                                sb2.append(parcel.readFloat());
                                break;
                            case 4:
                                sb2.append(pd.l(parcel, i8));
                                break;
                            case 5:
                                sb2.append(pd.a(parcel, i8));
                                break;
                            case 6:
                                sb2.append(pd.k(parcel, i8));
                                break;
                            case 7:
                                String strF = pd.f(parcel, i8);
                                sb2.append("\"");
                                sb2.append(d3.a.a(strF));
                                sb2.append("\"");
                                break;
                            case 8:
                                byte[] bArrC = pd.c(parcel, i8);
                                sb2.append("\"");
                                sb2.append(bArrC != null ? Base64.encodeToString(bArrC, 0) : null);
                                sb2.append("\"");
                                break;
                            case 9:
                                byte[] bArrC2 = pd.c(parcel, i8);
                                sb2.append("\"");
                                sb2.append(bArrC2 != null ? Base64.encodeToString(bArrC2, 10) : null);
                                sb2.append("\"");
                                break;
                            case 10:
                                Bundle bundleB2 = pd.b(parcel, i8);
                                Set<String> setKeySet = bundleB2.keySet();
                                sb2.append("{");
                                boolean z5 = true;
                                for (String str4 : setKeySet) {
                                    if (!z5) {
                                        sb2.append(",");
                                    }
                                    sb2.append("\"");
                                    sb2.append(str4);
                                    sb2.append("\":\"");
                                    sb2.append(d3.a.a(bundleB2.getString(str4)));
                                    sb2.append("\"");
                                    z5 = false;
                                }
                                sb2.append("}");
                                break;
                            case 11:
                                int iQ10 = pd.q(parcel, i8);
                                int iDataPosition11 = parcel.dataPosition();
                                if (iQ10 != 0) {
                                    parcelObtain = Parcel.obtain();
                                    parcelObtain.appendFrom(parcel, iDataPosition11, iQ10);
                                    parcel.setDataPosition(iDataPosition11 + iQ10);
                                }
                                parcelObtain.setDataPosition(0);
                                l.e(str3);
                                l.e(fastJsonResponse$Field.f1944l);
                                Map map4 = (Map) fastJsonResponse$Field.f1944l.f1959b.get(str3);
                                l.e(map4);
                                k(sb2, map4, parcelObtain);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                }
                z2 = true;
            }
        }
        if (parcel.dataPosition() != iS) {
            throw new v2.a(a1.a.o(iS, "Overread allowed size end="), parcel);
        }
        sb2.append('}');
    }

    public static final void l(StringBuilder sb2, int i8, Object obj) {
        switch (i8) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                l.e(obj);
                sb2.append(d3.a.a(obj.toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                byte[] bArr = (byte[]) obj;
                sb2.append(bArr != null ? Base64.encodeToString(bArr, 0) : null);
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                byte[] bArr2 = (byte[]) obj;
                sb2.append(bArr2 != null ? Base64.encodeToString(bArr2, 10) : null);
                sb2.append("\"");
                return;
            case 10:
                l.e(obj);
                i1.a(sb2, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(a1.a.o(i8, "Unknown type = "));
        }
    }

    public static final void m(StringBuilder sb2, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        boolean z2 = fastJsonResponse$Field.f1938c;
        int i8 = fastJsonResponse$Field.f1937b;
        if (!z2) {
            l(sb2, i8, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb2.append("[");
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            if (i9 != 0) {
                sb2.append(",");
            }
            l(sb2, i8, arrayList.get(i9));
        }
        sb2.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final Map b() {
        zan zanVar = this.f1949d;
        if (zanVar == null) {
            return null;
        }
        String str = this.e;
        l.e(str);
        return (Map) zanVar.f1959b.get(str);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final Object e() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final boolean g() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Parcel j() {
        int i8 = this.f1950h;
        Parcel parcel = this.f1947b;
        if (i8 == 0) {
            int i9 = qd.i(parcel, 20293);
            this.f1951i = i9;
            qd.j(parcel, i9);
            this.f1950h = 2;
        } else if (i8 == 1) {
            qd.j(parcel, this.f1951i);
            this.f1950h = 2;
        }
        return parcel;
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final String toString() {
        zan zanVar = this.f1949d;
        l.f(zanVar, "Cannot convert to JSON on client side.");
        Parcel parcelJ = j();
        parcelJ.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        String str = this.e;
        l.e(str);
        Map map = (Map) zanVar.f1959b.get(str);
        l.e(map);
        k(sb2, map, parcelJ);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1946a);
        Parcel parcelJ = j();
        if (parcelJ != null) {
            int i10 = qd.i(parcel, 2);
            parcel.appendFrom(parcelJ, 0, parcelJ.dataSize());
            qd.j(parcel, i10);
        }
        qd.d(parcel, 3, this.f1948c != 0 ? this.f1949d : null, i8);
        qd.j(parcel, i9);
    }
}
