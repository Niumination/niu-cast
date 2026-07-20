package mk;

import lm.l2;
import mk.w;

/* JADX INFO: loaded from: classes2.dex */
@f
public interface x<ConfigType, ExtensionType extends w<ConfigType>> {
    boolean a();

    boolean b();

    boolean c();

    @os.l
    ExtensionType d(@os.l jn.l<? super ConfigType, l2> lVar);

    @os.l
    fl.b<ExtensionType> getKey();
}
