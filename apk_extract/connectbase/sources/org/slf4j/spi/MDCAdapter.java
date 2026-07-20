package org.slf4j.spi;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface MDCAdapter {
    void a(String str, String str2);

    Map<String, String> b();

    void c(Map<String, String> map);

    void clear();

    String get(String str);

    void remove(String str);
}
