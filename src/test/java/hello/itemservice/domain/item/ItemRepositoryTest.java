package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ItemRepositoryTest {

    ItemRepository itemRepository=new ItemRepository();


    // Test 힐때마다 저장소를 비워줌
    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Item item=new Item("itemA",10000,10);
        // when
        Item savedItem=itemRepository.save(item);
        // then
        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem).isEqualTo(savedItem);
    }
    @Test
    void findAll(){
        // given
        Item item1=new Item("itemA",10000,10);
        Item item2=new Item("itemB",20000,20);

        itemRepository.save(item1);
        itemRepository.save(item2);
        // when
        List<Item> result=itemRepository.findAll();
        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(item1,item2);
    }
    @Test
    void updateItem(){
        // ~일때
        Item item1=new Item("item1",10000,100);
        Item savedItem=itemRepository.save(item1);
        Long itemId=savedItem.getId();
        // ~하면
        itemRepository.update(itemId,new Item("item2",20000,200));
        // 결과
        Item findItem = itemRepository.findById(itemId);
        Assertions.assertThat(findItem.getItemName()).isEqualTo("item2");
    }



}
