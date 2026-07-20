package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kn.l0;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(@l Shader shader, @l jn.l<? super Matrix, l2> lVar) {
        l0.p(shader, "<this>");
        l0.p(lVar, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        lVar.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
