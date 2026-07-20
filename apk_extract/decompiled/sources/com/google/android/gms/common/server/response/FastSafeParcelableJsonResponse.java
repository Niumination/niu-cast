package com.google.android.gms.common.server.response;

import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import d3.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k3.i1;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class FastSafeParcelableJsonResponse implements SafeParcelable {
    public static final Object h(FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        StringToIntConverter stringToIntConverter = fastJsonResponse$Field.f1945m;
        if (stringToIntConverter == null) {
            return obj;
        }
        String str = (String) stringToIntConverter.f1930c.get(((Integer) obj).intValue());
        return (str == null && stringToIntConverter.f1929b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public static final void i(StringBuilder sb2, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        int i8 = fastJsonResponse$Field.f1937b;
        if (i8 == 11) {
            Class cls = fastJsonResponse$Field.f1942j;
            l.e(cls);
            sb2.append(((FastSafeParcelableJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i8 != 7) {
                sb2.append(obj);
                return;
            }
            sb2.append("\"");
            sb2.append(a.a((String) obj));
            sb2.append("\"");
        }
    }

    public abstract Map b();

    public final Object d(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f1942j == null) {
            return e();
        }
        Object objE = e();
        String str = fastJsonResponse$Field.f1940h;
        if (objE != null) {
            throw new IllegalStateException("Concrete field shouldn't be value object: " + str);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public Object e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastSafeParcelableJsonResponse fastSafeParcelableJsonResponse = (FastSafeParcelableJsonResponse) obj;
        for (FastJsonResponse$Field fastJsonResponse$Field : b().values()) {
            if (f(fastJsonResponse$Field)) {
                if (!fastSafeParcelableJsonResponse.f(fastJsonResponse$Field) || !l.h(d(fastJsonResponse$Field), fastSafeParcelableJsonResponse.d(fastJsonResponse$Field))) {
                    return false;
                }
            } else if (fastSafeParcelableJsonResponse.f(fastJsonResponse$Field)) {
                return false;
            }
        }
        return true;
    }

    public final boolean f(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f1939d != 11) {
            return g();
        }
        if (fastJsonResponse$Field.e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public boolean g() {
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (FastJsonResponse$Field fastJsonResponse$Field : b().values()) {
            if (f(fastJsonResponse$Field)) {
                Object objD = d(fastJsonResponse$Field);
                l.e(objD);
                iHashCode = (iHashCode * 31) + objD.hashCode();
            }
        }
        return iHashCode;
    }

    public String toString() {
        Map mapB = b();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str : mapB.keySet()) {
            FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) mapB.get(str);
            if (f(fastJsonResponse$Field)) {
                Object objH = h(fastJsonResponse$Field, d(fastJsonResponse$Field));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(",");
                }
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (objH != null) {
                    switch (fastJsonResponse$Field.f1939d) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(Base64.encodeToString((byte[]) objH, 0));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(Base64.encodeToString((byte[]) objH, 10));
                            sb2.append("\"");
                            break;
                        case 10:
                            i1.a(sb2, (HashMap) objH);
                            break;
                        default:
                            if (fastJsonResponse$Field.f1938c) {
                                ArrayList arrayList = (ArrayList) objH;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i8 = 0; i8 < size; i8++) {
                                    if (i8 > 0) {
                                        sb2.append(",");
                                    }
                                    Object obj = arrayList.get(i8);
                                    if (obj != null) {
                                        i(sb2, fastJsonResponse$Field, obj);
                                    }
                                }
                                sb2.append("]");
                            } else {
                                i(sb2, fastJsonResponse$Field, objH);
                            }
                            break;
                    }
                } else {
                    sb2.append("null");
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }
}
