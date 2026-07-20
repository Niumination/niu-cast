package an;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kn.n1;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@f1(version = "1.2")
@Retention(RetentionPolicy.SOURCE)
@mm.d
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.FUNCTION, mm.b.PROPERTY, mm.b.CONSTRUCTOR, mm.b.TYPEALIAS})
@mm.e(mm.a.SOURCE)
@Repeatable(a.class)
public @interface p {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @mm.f(allowedTargets = {mm.b.CLASS, mm.b.FUNCTION, mm.b.PROPERTY, mm.b.CONSTRUCTOR, mm.b.TYPEALIAS})
    @mm.e(mm.a.SOURCE)
    @n1
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
        p[] value();
    }

    int errorCode() default -1;

    lm.m level() default lm.m.ERROR;

    String message() default "";

    String version();

    q versionKind() default q.LANGUAGE_VERSION;
}
