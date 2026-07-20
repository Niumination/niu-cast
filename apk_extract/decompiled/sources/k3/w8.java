package k3;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class w8 {
    public static String a(String str, Object... objArr) {
        int iIndexOf;
        String string;
        String strValueOf = String.valueOf(str);
        int i8 = 0;
        for (int i9 = 0; i9 < objArr.length; i9++) {
            Object obj = objArr[i9];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e);
                    StringBuilder sbY = a1.a.y("<", str2, " threw ");
                    sbY.append(e.getClass().getName());
                    sbY.append(">");
                    string = sbY.toString();
                }
            }
            objArr[i9] = string;
        }
        StringBuilder sb2 = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i10 = 0;
        while (i8 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i10)) != -1) {
            sb2.append((CharSequence) strValueOf, i10, iIndexOf);
            sb2.append(objArr[i8]);
            i10 = iIndexOf + 2;
            i8++;
        }
        sb2.append((CharSequence) strValueOf, i10, strValueOf.length());
        if (i8 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i8]);
            for (int i11 = i8 + 1; i11 < objArr.length; i11++) {
                sb2.append(", ");
                sb2.append(objArr[i11]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }
}
