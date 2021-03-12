package pl.allegro.restapi.main.pojo;

public class Options {

    private Boolean advertisement;
    private Boolean advertisementPriceOptional;
    private Boolean variantsByColorPatternAllowed;
    private Boolean offersWithProductPublicationEnabled;
    private Boolean productCreationEnabled;
    private Boolean customParametersEnabled;

    public Boolean getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Boolean advertisement) {
        this.advertisement = advertisement;
    }

    public Boolean getAdvertisementPriceOptional() {
        return advertisementPriceOptional;
    }

    public void setAdvertisementPriceOptional(Boolean advertisementPriceOptional) {
        this.advertisementPriceOptional = advertisementPriceOptional;
    }

    public Boolean getVariantsByColorPatternAllowed() {
        return variantsByColorPatternAllowed;
    }

    public void setVariantsByColorPatternAllowed(Boolean variantsByColorPatternAllowed) {
        this.variantsByColorPatternAllowed = variantsByColorPatternAllowed;
    }

    public Boolean getOffersWithProductPublicationEnabled() {
        return offersWithProductPublicationEnabled;
    }

    public void setOffersWithProductPublicationEnabled(Boolean offersWithProductPublicationEnabled) {
        this.offersWithProductPublicationEnabled = offersWithProductPublicationEnabled;
    }

    public Boolean getProductCreationEnabled() {
        return productCreationEnabled;
    }

    public void setProductCreationEnabled(Boolean productCreationEnabled) {
        this.productCreationEnabled = productCreationEnabled;
    }

    public Boolean getCustomParametersEnabled() {
        return customParametersEnabled;
    }

    public void setCustomParametersEnabled(Boolean customParametersEnabled) {
        this.customParametersEnabled = customParametersEnabled;
    }

}