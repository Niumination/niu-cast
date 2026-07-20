package fl;

import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(message = "This was moved to another package.", replaceWith = @lm.a1(expression = "ConversionService", imports = {"io.ktor.util.converters.ConversionService"}))
public interface v {
    @os.l
    List<String> a(@os.m Object obj);

    @os.m
    Object b(@os.l List<String> list, @os.l Type type);
}
