package io.netty.util;

import fl.h;
import io.netty.util.internal.ObjectUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import k.a;
import rs.f;

/* JADX INFO: loaded from: classes3.dex */
public class DomainWildcardMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    public static final class ImmutableDomainWildcardMapping<V> implements Mapping<String, V> {
        private static final String REPR_HEADER = "ImmutableDomainWildcardMapping(default: ";
        private static final String REPR_MAP_CLOSING = ")";
        private static final String REPR_MAP_OPENING = ", map: ";
        private final V defaultValue;
        private final Map<String, V> map;

        public ImmutableDomainWildcardMapping(V v10, Map<String, V> map) {
            this.defaultValue = v10;
            this.map = new LinkedHashMap(map);
        }

        public static String normalize(String str) {
            return DomainNameMapping.normalizeHostname(str);
        }

        public String toString() {
            StringBuilder sbA = a.a(REPR_HEADER);
            sbA.append(this.defaultValue);
            sbA.append(", map: {");
            for (Map.Entry<String, V> entry : this.map.entrySet()) {
                String key = entry.getKey();
                if (key.charAt(0) == '.') {
                    key = "*".concat(key);
                }
                sbA.append(key);
                sbA.append(h.f6043c);
                sbA.append(entry.getValue());
                sbA.append(", ");
            }
            sbA.setLength(sbA.length() - 2);
            sbA.append(f.f14860b);
            sbA.append(REPR_MAP_CLOSING);
            return sbA.toString();
        }

        @Override // io.netty.util.Mapping
        public V map(String str) {
            V v10;
            if (str != null) {
                String strNormalize = normalize(str);
                V v11 = this.map.get(strNormalize);
                if (v11 != null) {
                    return v11;
                }
                int iIndexOf = strNormalize.indexOf(46);
                if (iIndexOf != -1 && (v10 = this.map.get(strNormalize.substring(iIndexOf))) != null) {
                    return v10;
                }
            }
            return this.defaultValue;
        }
    }

    public DomainWildcardMappingBuilder(V v10) {
        this(4, v10);
    }

    private String normalizeHostName(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        if (str.isEmpty() || str.charAt(0) == '.') {
            throw new IllegalArgumentException(n.a.a("Hostname '", str, "' not valid"));
        }
        String strNormalize = ImmutableDomainWildcardMapping.normalize((String) ObjectUtil.checkNotNull(str, "hostname"));
        if (strNormalize.charAt(0) != '*') {
            return strNormalize;
        }
        if (strNormalize.length() < 3 || strNormalize.charAt(1) != '.') {
            throw new IllegalArgumentException(n.a.a("Wildcard Hostname '", strNormalize, "'not valid"));
        }
        return strNormalize.substring(1);
    }

    public DomainWildcardMappingBuilder<V> add(String str, V v10) {
        this.map.put(normalizeHostName(str), (V) ObjectUtil.checkNotNull(v10, "output"));
        return this;
    }

    public Mapping<String, V> build() {
        return new ImmutableDomainWildcardMapping(this.defaultValue, this.map);
    }

    public DomainWildcardMappingBuilder(int i10, V v10) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(v10, "defaultValue");
        this.map = new LinkedHashMap(i10);
    }
}
