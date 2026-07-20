package io.netty.util;

import fl.h;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import n.a;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class DomainNameMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    public static final class ImmutableDomainNameMapping<V> extends DomainNameMapping<V> {
        private static final int REPR_CONST_PART_LENGTH = 46;
        private static final String REPR_HEADER = "ImmutableDomainNameMapping(default: ";
        private static final String REPR_MAP_CLOSING = "})";
        private static final String REPR_MAP_OPENING = ", map: {";
        private final String[] domainNamePatterns;
        private final Map<String, V> map;
        private final V[] values;

        private StringBuilder appendMapping(StringBuilder sb2, int i10) {
            return appendMapping(sb2, this.domainNamePatterns[i10], this.values[i10].toString());
        }

        private static int estimateBufferSize(int i10, int i11, int i12) {
            return REPR_CONST_PART_LENGTH + i10 + ((int) (((double) (i12 * i11)) * 1.1d));
        }

        @Override // io.netty.util.DomainNameMapping
        @Deprecated
        public DomainNameMapping<V> add(String str, V v10) {
            throw new UnsupportedOperationException("Immutable DomainNameMapping does not support modification after initial creation");
        }

        @Override // io.netty.util.DomainNameMapping
        public Map<String, V> asMap() {
            return this.map;
        }

        @Override // io.netty.util.DomainNameMapping
        public String toString() {
            String string = this.defaultValue.toString();
            String[] strArr = this.domainNamePatterns;
            int length = strArr.length;
            if (length == 0) {
                return a.a(REPR_HEADER, string, ", map: {})");
            }
            String str = strArr[0];
            String string2 = this.values[0].toString();
            StringBuilder sb2 = new StringBuilder(estimateBufferSize(string.length(), length, string2.length() + str.length() + 3));
            sb2.append(REPR_HEADER);
            sb2.append(string);
            sb2.append(REPR_MAP_OPENING);
            appendMapping(sb2, str, string2);
            for (int i10 = 1; i10 < length; i10++) {
                sb2.append(", ");
                appendMapping(sb2, i10);
            }
            sb2.append(REPR_MAP_CLOSING);
            return sb2.toString();
        }

        private ImmutableDomainNameMapping(V v10, Map<String, V> map) {
            super((Map) null, v10);
            Set<Map.Entry<String, V>> setEntrySet = map.entrySet();
            int size = setEntrySet.size();
            this.domainNamePatterns = new String[size];
            this.values = (V[]) new Object[size];
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            int i10 = 0;
            for (Map.Entry<String, V> entry : setEntrySet) {
                String strNormalizeHostname = DomainNameMapping.normalizeHostname(entry.getKey());
                V value = entry.getValue();
                this.domainNamePatterns[i10] = strNormalizeHostname;
                this.values[i10] = value;
                linkedHashMap.put(strNormalizeHostname, value);
                i10++;
            }
            this.map = Collections.unmodifiableMap(linkedHashMap);
        }

        private static StringBuilder appendMapping(StringBuilder sb2, String str, String str2) {
            sb2.append(str);
            sb2.append(h.f6043c);
            sb2.append(str2);
            return sb2;
        }

        @Override // io.netty.util.DomainNameMapping, io.netty.util.Mapping
        public V map(String str) {
            if (str != null) {
                String strNormalizeHostname = DomainNameMapping.normalizeHostname(str);
                int length = this.domainNamePatterns.length;
                for (int i10 = 0; i10 < length; i10++) {
                    if (DomainNameMapping.matches(this.domainNamePatterns[i10], strNormalizeHostname)) {
                        return this.values[i10];
                    }
                }
            }
            return this.defaultValue;
        }
    }

    public DomainNameMappingBuilder(V v10) {
        this(4, v10);
    }

    public DomainNameMappingBuilder<V> add(String str, V v10) {
        this.map.put((String) ObjectUtil.checkNotNull(str, "hostname"), (V) ObjectUtil.checkNotNull(v10, "output"));
        return this;
    }

    public DomainNameMapping<V> build() {
        return new ImmutableDomainNameMapping(this.defaultValue, this.map);
    }

    public DomainNameMappingBuilder(int i10, V v10) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(v10, "defaultValue");
        this.map = new LinkedHashMap(i10);
    }
}
