package lm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE})
@mm.f(allowedTargets = {mm.b.ANNOTATION_CLASS})
@mm.e(mm.a.BINARY)
@f1(version = "1.3")
@Retention(RetentionPolicy.CLASS)
public @interface b1 {

    public enum a {
        WARNING,
        ERROR;


        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ym.a f10180b = ym.c.c(a());

        @os.l
        public static ym.a<a> getEntries() {
            return f10180b;
        }
    }

    a level() default a.ERROR;

    String message() default "";
}
