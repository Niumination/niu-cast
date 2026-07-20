package di;

import bi.q;
import ei.n;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    boolean include() default true;

    String name() default "";

    Class<? extends q> objectFactory() default q.class;

    Class<? extends n> transformer() default n.class;
}
