package ir.ac.kntu.model.services;

public enum ServiceType {
    LUXURY(10),NORMAL(5),ECONOMIC(2);

    private double brandRate;

    /**
     *
     * @param brandRate a percentage that is added to the price of an order
     */
    ServiceType(double brandRate){
        this.brandRate = brandRate;
    }

}
