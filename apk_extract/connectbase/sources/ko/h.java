package ko;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public interface h extends uo.d {

    public static final class a {
        @os.m
        public static e a(@os.l h hVar, @os.l dp.c cVar) {
            Annotation[] declaredAnnotations;
            l0.p(hVar, "this");
            l0.p(cVar, "fqName");
            AnnotatedElement element = hVar.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
                return null;
            }
            return i.a(declaredAnnotations, cVar);
        }

        @os.l
        public static List<e> b(@os.l h hVar) {
            l0.p(hVar, "this");
            AnnotatedElement element = hVar.getElement();
            Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
            return declaredAnnotations == null ? k0.INSTANCE : i.b(declaredAnnotations);
        }

        public static boolean c(@os.l h hVar) {
            l0.p(hVar, "this");
            return false;
        }
    }

    @os.m
    AnnotatedElement getElement();
}
