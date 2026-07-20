package androidx.core.content;

import android.content.ContentValues;
import kn.l0;
import lm.t0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class ContentValuesKt {
    @l
    public static final ContentValues contentValuesOf(@l t0<String, ? extends Object>... t0VarArr) {
        l0.p(t0VarArr, "pairs");
        ContentValues contentValues = new ContentValues(t0VarArr.length);
        for (t0<String, ? extends Object> t0Var : t0VarArr) {
            String strComponent1 = t0Var.component1();
            Object objComponent2 = t0Var.component2();
            if (objComponent2 == null) {
                contentValues.putNull(strComponent1);
            } else if (objComponent2 instanceof String) {
                contentValues.put(strComponent1, (String) objComponent2);
            } else if (objComponent2 instanceof Integer) {
                contentValues.put(strComponent1, (Integer) objComponent2);
            } else if (objComponent2 instanceof Long) {
                contentValues.put(strComponent1, (Long) objComponent2);
            } else if (objComponent2 instanceof Boolean) {
                contentValues.put(strComponent1, (Boolean) objComponent2);
            } else if (objComponent2 instanceof Float) {
                contentValues.put(strComponent1, (Float) objComponent2);
            } else if (objComponent2 instanceof Double) {
                contentValues.put(strComponent1, (Double) objComponent2);
            } else if (objComponent2 instanceof byte[]) {
                contentValues.put(strComponent1, (byte[]) objComponent2);
            } else if (objComponent2 instanceof Byte) {
                contentValues.put(strComponent1, (Byte) objComponent2);
            } else {
                if (!(objComponent2 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objComponent2.getClass().getCanonicalName() + " for key \"" + strComponent1 + '\"');
                }
                contentValues.put(strComponent1, (Short) objComponent2);
            }
        }
        return contentValues;
    }
}
