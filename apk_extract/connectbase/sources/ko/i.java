package ko;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:16:? A[RETURN, SYNTHETIC] */
    @os.m
    public static final e a(@os.l Annotation[] annotationArr, @os.l dp.c cVar) {
        Annotation annotation;
        l0.p(annotationArr, "<this>");
        l0.p(cVar, "fqName");
        int length = annotationArr.length;
        int i10 = 0;
        while (i10 < length) {
            annotation = annotationArr[i10];
            i10++;
            if (l0.g(d.a(in.b.e(in.b.a(annotation))).b(), cVar)) {
                if (annotation == null) {
                    return null;
                }
                return new e(annotation);
            }
        }
        annotation = null;
        if (annotation == null) {
            return null;
        }
        return new e(annotation);
    }

    @os.l
    public static final List<e> b(@os.l Annotation[] annotationArr) {
        l0.p(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        int length = annotationArr.length;
        int i10 = 0;
        while (i10 < length) {
            Annotation annotation = annotationArr[i10];
            i10++;
            arrayList.add(new e(annotation));
        }
        return arrayList;
    }
}
