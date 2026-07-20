package l3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public abstract class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f7292a;

    static {
        char[] cArr = new char[80];
        f7292a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(StringBuilder sb2, int i8, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb2, i8, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb2, i8, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        b(i8, sb2);
        if (!str.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Character.toLowerCase(str.charAt(0)));
            for (int i9 = 1; i9 < str.length(); i9++) {
                char cCharAt = str.charAt(i9);
                if (Character.isUpperCase(cCharAt)) {
                    sb3.append("_");
                }
                sb3.append(Character.toLowerCase(cCharAt));
            }
            str = sb3.toString();
        }
        sb2.append(str);
        if (obj instanceof String) {
            sb2.append(": \"");
            sb2.append(k2.b(new a0(((String) obj).getBytes(z0.f7328a))));
            sb2.append(Typography.quote);
            return;
        }
        if (obj instanceof b0) {
            sb2.append(": \"");
            sb2.append(k2.b((b0) obj));
            sb2.append(Typography.quote);
            return;
        }
        if (obj instanceof q0) {
            sb2.append(" {");
            c((q0) obj, sb2, i8 + 2);
            sb2.append("\n");
            b(i8, sb2);
            sb2.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj);
            return;
        }
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i10 = i8 + 2;
        a(sb2, i10, "key", entry.getKey());
        a(sb2, i10, "value", entry.getValue());
        sb2.append("\n");
        b(i8, sb2);
        sb2.append("}");
    }

    public static void b(int i8, StringBuilder sb2) {
        while (i8 > 0) {
            int i9 = 80;
            if (i8 <= 80) {
                i9 = i8;
            }
            sb2.append(f7292a, 0, i9);
            i8 -= i9;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0200  */
    public static void c(q0 q0Var, StringBuilder sb2, int i8) {
        int i9;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = q0Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i10 = 0;
        while (true) {
            i9 = 3;
            if (i10 >= length) {
                break;
            }
            Method method3 = declaredMethods[i10];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i10++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i9);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                a(sb2, i8, strSubstring.substring(0, strSubstring.length() - 4), q0.f(method2, q0Var, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                a(sb2, i8, strSubstring.substring(0, strSubstring.length() - 3), q0.f(method, q0Var, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objF = q0.f(method4, q0Var, new Object[0]);
                    if (method5 == null) {
                        if (objF instanceof Boolean) {
                            if (((Boolean) objF).booleanValue()) {
                                a(sb2, i8, strSubstring, objF);
                            }
                        } else if (objF instanceof Integer) {
                            if (((Integer) objF).intValue() != 0) {
                                a(sb2, i8, strSubstring, objF);
                            }
                        } else if (objF instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objF).floatValue()) != 0) {
                                a(sb2, i8, strSubstring, objF);
                            }
                        } else if (!(objF instanceof Double)) {
                            if (objF instanceof String) {
                                zEquals = objF.equals("");
                            } else if (objF instanceof b0) {
                                zEquals = objF.equals(b0.zzb);
                            } else if (objF instanceof q1) {
                                if (objF != ((q0) ((q0) ((q1) objF)).n(6, null))) {
                                    a(sb2, i8, strSubstring, objF);
                                }
                            } else if (!(objF instanceof Enum) || ((Enum) objF).ordinal() != 0) {
                                a(sb2, i8, strSubstring, objF);
                            }
                            if (!zEquals) {
                                a(sb2, i8, strSubstring, objF);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objF).doubleValue()) != 0) {
                            a(sb2, i8, strSubstring, objF);
                        }
                    } else if (((Boolean) q0.f(method5, q0Var, new Object[0])).booleanValue()) {
                        a(sb2, i8, strSubstring, objF);
                    }
                }
            }
            i9 = 3;
        }
        if (q0Var instanceof n0) {
            Iterator itD = ((n0) q0Var).zza.d();
            while (true) {
                m2 m2Var = (m2) itD;
                if (!m2Var.hasNext()) {
                    break;
                }
                Map.Entry entry2 = (Map.Entry) m2Var.next();
                a(sb2, i8, h0.a.h(((o0) entry2.getKey()).f7276a, "[", "]"), entry2.getValue());
            }
        }
        o2 o2Var = q0Var.zzc;
        if (o2Var != null) {
            for (int i11 = 0; i11 < o2Var.f7279a; i11++) {
                a(sb2, i8, String.valueOf(o2Var.f7280b[i11] >>> 3), o2Var.f7281c[i11]);
            }
        }
    }
}
