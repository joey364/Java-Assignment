public class StockItem {

    String stockNumber;
    String name;
    Double price;
    int totalStock = 0;

    public StockItem(String stockNumber, String name, Double price) {
        this.stockNumber = stockNumber;
        this.name = name;
        this.price = price;
    }

    public String getStockNumber() {
        return this.stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getTotalStock() {
        return this.totalStock;
    }

    public void addToTotalStock(int newStocks) {
        this.totalStock += newStocks;
    }

    public Double getStockValue() {
        return this.totalStock * this.price;
    }

}
