package as;

import hs.a0;
import hs.p;
import hs.x;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@p
@x(qualifier = b.class)
@Documented
@Repeatable(InterfaceC0025a.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface a {

    /* JADX INFO: renamed from: as.a$a, reason: collision with other inner class name */
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @p
    @x(qualifier = b.class)
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface InterfaceC0025a {
        a[] value();
    }

    @a0("value")
    String[] fields();

    String[] value() default {"this"};
}
