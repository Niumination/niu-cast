package k3;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class i1 {
    public static void a(StringBuilder sb2, HashMap map) {
        sb2.append("{");
        boolean z2 = true;
        for (String str : map.keySet()) {
            if (!z2) {
                sb2.append(",");
            }
            String str2 = (String) map.get(str);
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\":");
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append("\"");
                sb2.append(str2);
                sb2.append("\"");
            }
            z2 = false;
        }
        sb2.append("}");
    }
}
