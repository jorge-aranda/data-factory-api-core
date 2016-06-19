
package es.jaranda.datafactory.api.builder.impl;

import es.jaranda.datafactory.api.builder.CollectionFactory;
import es.jaranda.datafactory.api.builder.MapFactory;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Implementation of MapFactory
 * @author Jorge
 * @param <K> Type to use as key in your final Map
 * @param <V> Type to use as value in your final Map
 * 
 * @see es.jaranda.datafactory.api.builder.MapFactory
 */
public class MapFactoryImpl<K,V> implements MapFactory<K,V> {

    private final CollectionFactory<Entry<K,V>> collectionFactory;
    
    public MapFactoryImpl() {
        this(new CollectionFactoryImpl<Entry<K, V>>());
    }
    
    public MapFactoryImpl(CollectionFactory<Entry<K,V>> collectionFactory) {
        this.collectionFactory = collectionFactory;
    }
    
    
    @Override
    public MapFactory<K,V> entry(K key, V value) {
        final Entry<K,V> entry = 
                new SimpleImmutableEntry<K, V>(key, value);
        final CollectionFactory newCollectionFactory = 
                this.collectionFactory.item(entry);
        
        return new MapFactoryImpl(newCollectionFactory);
    }

    @Override
    public Map<K,V> toMap() {
        final Map<K,V> newMap = new HashMap<K, V>();
        
        for (Entry<K, V> entry : this.collectionFactory.toList()) {
            newMap.putIfAbsent(entry.getKey(), entry.getValue());
        }
        
        return newMap;
    }
}
