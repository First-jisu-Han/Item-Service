package hello.itemservice.domain.item;


import lombok.Data;

@Data
public class Item {
    // Integer로 넣은 이유 : null로 받으려고, int 로 넣으면 값이 0으로 들어갈 수 있기때문에
    private Long id;              // 상품 고유 ID
    private String itemName;      // 상품 이름
    private Integer price;        // 상품 가격
    private Integer quantity;     // 상품 수량

    public Item(){
    }

    public Item(String itemName,Integer price,Integer quantity){
        this.itemName=itemName;
        this.price=price;
        this.quantity=quantity;
    }



}
