package ir.ac.kntu.services;

public enum RestaurantType {
    LUXURY(10),NORMAL(5),ECONOMIC(2);

    private double brandRate;

    /**
     *
     * @param brandRate a percentage that is added to the price of an order
     */
    RestaurantType(double brandRate){
        this.brandRate = brandRate;
    }

}
