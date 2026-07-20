package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kn.l0;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(@l Canvas canvas, @l Rect rect, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(rect, "clipRect");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withMatrix(@l Canvas canvas, @l Matrix matrix, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(matrix, "matrix");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static void withMatrix$default(Canvas canvas, Matrix matrix, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matrix = new Matrix();
        }
        l0.p(canvas, "<this>");
        l0.p(matrix, "matrix");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withRotation(@l Canvas canvas, float f10, float f11, float f12, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static void withRotation$default(Canvas canvas, float f10, float f11, float f12, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withSave(@l Canvas canvas, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withScale(@l Canvas canvas, float f10, float f11, float f12, float f13, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static void withScale$default(Canvas canvas, float f10, float f11, float f12, float f13, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withSkew(@l Canvas canvas, float f10, float f11, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.skew(f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static void withSkew$default(Canvas canvas, float f10, float f11, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.skew(f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withTranslation(@l Canvas canvas, float f10, float f11, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.translate(f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static void withTranslation$default(Canvas canvas, float f10, float f11, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.translate(f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(@l Canvas canvas, @l RectF rectF, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(rectF, "clipRect");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(@l Canvas canvas, int i10, int i11, int i12, int i13, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.clipRect(i10, i11, i12, i13);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(@l Canvas canvas, float f10, float f11, float f12, float f13, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.clipRect(f10, f11, f12, f13);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(@l Canvas canvas, @l Path path, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(canvas, "<this>");
        l0.p(path, "clipPath");
        l0.p(lVar, "block");
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }
}
