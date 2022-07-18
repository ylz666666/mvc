package domain;

public class Computer {
    private Integer size;
    private Float price;

    public Computer() {
    }

    public Computer(Integer size, Float price) {
        this.size = size;
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }


    public void setSize(Integer size) {
        this.size = size;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "size=" + size +
                ", price=" + price +
                '}';
    }
}
