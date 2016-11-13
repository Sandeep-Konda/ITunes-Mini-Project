
package sandeep.itunesminiproject.DTO;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Result implements Parcelable{

    @SerializedName("wrapperType")
    @Expose
    private String wrapperType;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("artistId")
    @Expose
    private Integer artistId;
    @SerializedName("trackId")
    @Expose
    private Integer trackId;
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("trackName")
    @Expose
    private String trackName;
    @SerializedName("trackCensoredName")
    @Expose
    private String trackCensoredName;
    @SerializedName("artistViewUrl")
    @Expose
    private String artistViewUrl;
    @SerializedName("trackViewUrl")
    @Expose
    private String trackViewUrl;
    @SerializedName("previewUrl")
    @Expose
    private String previewUrl;
    @SerializedName("artworkUrl30")
    @Expose
    private String artworkUrl30;
    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("artworkUrl100")
    @Expose
    private String artworkUrl100;
    @SerializedName("collectionPrice")
    @Expose
    private Float collectionPrice;
    @SerializedName("trackPrice")
    @Expose
    private Float trackPrice;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("collectionExplicitness")
    @Expose
    private String collectionExplicitness;
    @SerializedName("trackExplicitness")
    @Expose
    private String trackExplicitness;
    @SerializedName("trackTimeMillis")
    @Expose
    private Integer trackTimeMillis;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("primaryGenreName")
    @Expose
    private String primaryGenreName;
    @SerializedName("contentAdvisoryRating")
    @Expose
    private String contentAdvisoryRating;

    /**
     * 
     * @return
     *     The wrapperType
     */
    public String getWrapperType() {
        return wrapperType;
    }

    /**
     * 
     * @param wrapperType
     *     The wrapperType
     */
    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    /**
     * 
     * @return
     *     The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * 
     * @param kind
     *     The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 
     * @return
     *     The artistId
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * 
     * @param artistId
     *     The artistId
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    /**
     * 
     * @return
     *     The trackId
     */
    public Integer getTrackId() {
        return trackId;
    }

    /**
     * 
     * @param trackId
     *     The trackId
     */
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    /**
     * 
     * @return
     *     The artistName
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * 
     * @param artistName
     *     The artistName
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * 
     * @return
     *     The trackName
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * 
     * @param trackName
     *     The trackName
     */
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    /**
     * 
     * @return
     *     The trackCensoredName
     */
    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    /**
     * 
     * @param trackCensoredName
     *     The trackCensoredName
     */
    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    /**
     * 
     * @return
     *     The artistViewUrl
     */
    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    /**
     * 
     * @param artistViewUrl
     *     The artistViewUrl
     */
    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    /**
     * 
     * @return
     *     The trackViewUrl
     */
    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    /**
     * 
     * @param trackViewUrl
     *     The trackViewUrl
     */
    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    /**
     * 
     * @return
     *     The previewUrl
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * 
     * @param previewUrl
     *     The previewUrl
     */
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    /**
     * 
     * @return
     *     The artworkUrl30
     */
    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    /**
     * 
     * @param artworkUrl30
     *     The artworkUrl30
     */
    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    /**
     * 
     * @return
     *     The artworkUrl60
     */
    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    /**
     * 
     * @param artworkUrl60
     *     The artworkUrl60
     */
    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    /**
     * 
     * @return
     *     The artworkUrl100
     */
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    /**
     * 
     * @param artworkUrl100
     *     The artworkUrl100
     */
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    /**
     * 
     * @return
     *     The collectionPrice
     */
    public Float getCollectionPrice() {
        return collectionPrice;
    }

    /**
     * 
     * @param collectionPrice
     *     The collectionPrice
     */
    public void setCollectionPrice(Float collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    /**
     * 
     * @return
     *     The trackPrice
     */
    public Float getTrackPrice() {
        return trackPrice;
    }

    /**
     * 
     * @param trackPrice
     *     The trackPrice
     */
    public void setTrackPrice(Float trackPrice) {
        this.trackPrice = trackPrice;
    }

    /**
     * 
     * @return
     *     The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * 
     * @param releaseDate
     *     The releaseDate
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 
     * @return
     *     The collectionExplicitness
     */
    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    /**
     * 
     * @param collectionExplicitness
     *     The collectionExplicitness
     */
    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    /**
     * 
     * @return
     *     The trackExplicitness
     */
    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    /**
     * 
     * @param trackExplicitness
     *     The trackExplicitness
     */
    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    /**
     * 
     * @return
     *     The trackTimeMillis
     */
    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    /**
     * 
     * @param trackTimeMillis
     *     The trackTimeMillis
     */
    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The primaryGenreName
     */
    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    /**
     * 
     * @param primaryGenreName
     *     The primaryGenreName
     */
    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    /**
     * 
     * @return
     *     The contentAdvisoryRating
     */
    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    /**
     * 
     * @param contentAdvisoryRating
     *     The contentAdvisoryRating
     */
    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
