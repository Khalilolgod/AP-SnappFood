package ir.ac.kntu;

public enum RestaurantType {
    LUXURY(10),NORMAL(5),ECONOMIC(2);

    double brandRate;

    /**
     *
     * @param brandRate a percentage that is added to the price of an order
     */
    RestaurantType(double brandRate){
        this.brandRate = brandRate;
    }

}
