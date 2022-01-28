package hello.itemservice.domain.item;


import org.springframework.stereotype.Repository;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository   // @Component 를 포함하고 있다.
public class ItemRepository {
    // 멀티 쓰레드에선 ConcurrentHashMap사용, Long도 값이 꼬이기때문에 AtomicLong등을 사용해야함
    private static final Map<Long,Item> store = new HashMap<>();  // static -> 클래스 생성될때 같이 메모리에 올라감
    private static long sequence = 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }
    public Item findById(Long id){
        return store.get(id);
    }
    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }
    public void update(Long itemId,Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    public void clearStore(){
        store.clear();
    }

}
