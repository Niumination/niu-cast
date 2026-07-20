package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aD\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aN\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u001e"}, d2 = {"withClip", "", "Landroid/graphics/Canvas;", "clipPath", "Landroid/graphics/Path;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            matrix = new Matrix();
        }
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f4, float f10, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.rotate(f, f4, f10);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f4, float f10, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            f = 0.0f;
        }
        if ((i8 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i8 & 4) != 0) {
            f10 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.rotate(f, f4, f10);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withSave(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withScale(Canvas canvas, float f, float f4, float f10, float f11, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.scale(f, f4, f10, f11);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f4, float f10, float f11, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            f = 1.0f;
        }
        if ((i8 & 2) != 0) {
            f4 = 1.0f;
        }
        if ((i8 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i8 & 8) != 0) {
            f11 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.scale(f, f4, f10, f11);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f4, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.skew(f, f4);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f4, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            f = 0.0f;
        }
        if ((i8 & 2) != 0) {
            f4 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.skew(f, f4);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f4, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.translate(f, f4);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f4, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            f = 0.0f;
        }
        if ((i8 & 2) != 0) {
            f4 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.translate(f, f4);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(Canvas canvas, int i8, int i9, int i10, int i11, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.clipRect(i8, i9, i10, i11);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(Canvas canvas, float f, float f4, float f10, float f11, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.clipRect(f, f4, f10, f11);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(Canvas canvas, Path path, Function1<? super Canvas, Unit> function1) {
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            function1.invoke(canvas);
        } finally {
            a.t(1, canvas, iSave, 1);
        }
    }
}
