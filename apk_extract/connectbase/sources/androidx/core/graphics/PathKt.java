package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import b.a;
import java.util.Collection;
import kn.l0;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n1#1,85:1\n44#1,3:86\n*S KotlinDebug\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n63#1:86,3\n*E\n"})
@a({"ClassVerificationFailure"})
public final class PathKt {
    @RequiresApi(19)
    @l
    public static final Path and(@l Path path, @l Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "p");
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    @l
    public static final Iterable<PathSegment> flatten(@l Path path, float f10) {
        l0.p(path, "<this>");
        Collection<PathSegment> collectionFlatten = PathUtils.flatten(path, f10);
        l0.o(collectionFlatten, "flatten(this, error)");
        return collectionFlatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.5f;
        }
        return flatten(path, f10);
    }

    @RequiresApi(19)
    @l
    public static final Path minus(@l Path path, @l Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    @l
    public static final Path or(@l Path path, @l Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    @l
    public static final Path plus(@l Path path, @l Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    @l
    public static final Path xor(@l Path path, @l Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
