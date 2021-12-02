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

    
    /** 
     * @return String
     */
    public String getStockNumber() {
        return this.stockNumber;
    }

    
    /** 
     * @param stockNumber
     */
    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return Double
     */
    public Double getPrice() {
        return this.price;
    }

    
    /** 
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    
    /** 
     * @return int
     */
    public int getTotalStock() {
        return this.totalStock;
    }

    
    /** 
     * @param newStocks
     */
    public void increaseTotalStock(int newStocks) {
        this.totalStock += newStocks;
    }

    
    /** 
     * @return Double
     */
    public Double calculateTotalPrice() {
        return this.totalStock * this.price;
    }

}
