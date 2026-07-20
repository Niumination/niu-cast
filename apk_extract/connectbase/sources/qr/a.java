package qr;

import hs.p;
import hs.r;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD})
@p
@Repeatable(InterfaceC0344a.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface a {

    /* JADX INFO: renamed from: qr.a$a, reason: collision with other inner class name */
    @Target({ElementType.METHOD})
    @p
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface InterfaceC0344a {
        a[] value();
    }

    @r
    String value() default "this";
}
