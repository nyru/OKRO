package eswar.com.okro.Model;

public class BasketitemsModel {
    String itemname, weight, price, itemsno;
    int itempic, plus, minus;

    public BasketitemsModel(int itempic,String itemname, String price, String  weight,int minus, String itemsno, int plus ) {
        this.itempic = itempic;
        this.itemname = itemname;
        this.price = price;
        this.weight = weight;
        this.minus = minus;
        this.itemsno = itemsno;
        this.plus = plus;

    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemsno() {
        return itemsno;
    }

    public void setItemsno(String itemsno) {
        this.itemsno = itemsno;
    }

    public int getItempic() {
        return itempic;
    }

    public void setItempic(int itempic) {
        this.itempic = itempic;
    }

    public int getPlus() {
        return plus;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }

    public int getMinus() {
        return minus;
    }

    public void setMinus(int minus) {
        this.minus = minus;
    }
}

