public class Product<T, U> {
    private T item;
    private U price;

    Product(T item, U price){
        this.item = item;
        this.price = price;
    }
    public T getItem(){
        return item;
    }
    public U getPrice(){
        return price;
    }
}
