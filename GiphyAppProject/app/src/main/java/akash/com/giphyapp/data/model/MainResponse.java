package akash.com.giphyapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainResponse {
    @SerializedName("data")
    @Expose
    private List<DataInner> data = null;

    public List<DataInner> getData() {
        return data;
    }

    public void setData(List<DataInner> data) {
        this.data = data;
    }

    public static class DataInner {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("bitly_gif_url")
        @Expose
        private String bitlyGifUrl;
        @SerializedName("bitly_url")
        @Expose
        private String bitlyUrl;
        @SerializedName("embed_url")
        @Expose
        private String embedUrl;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("rating")
        @Expose
        private String rating;
        @SerializedName("content_url")
        @Expose
        private String contentUrl;
        @SerializedName("source_post_url")
        @Expose
        private String sourcePostUrl;
        @SerializedName("is_sticker")
        @Expose
        private Integer isSticker;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("images")
        @Expose
        private Images images;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBitlyGifUrl() {
            return bitlyGifUrl;
        }

        public void setBitlyGifUrl(String bitlyGifUrl) {
            this.bitlyGifUrl = bitlyGifUrl;
        }

        public String getBitlyUrl() {
            return bitlyUrl;
        }

        public void setBitlyUrl(String bitlyUrl) {
            this.bitlyUrl = bitlyUrl;
        }

        public String getEmbedUrl() {
            return embedUrl;
        }

        public void setEmbedUrl(String embedUrl) {
            this.embedUrl = embedUrl;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getContentUrl() {
            return contentUrl;
        }

        public void setContentUrl(String contentUrl) {
            this.contentUrl = contentUrl;
        }

        public String getSourcePostUrl() {
            return sourcePostUrl;
        }

        public void setSourcePostUrl(String sourcePostUrl) {
            this.sourcePostUrl = sourcePostUrl;
        }

        public Integer getIsSticker() {
            return isSticker;
        }

        public void setIsSticker(Integer isSticker) {
            this.isSticker = isSticker;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Images getImages() {
            return images;
        }

        public void setImages(Images images) {
            this.images = images;
        }

        public static class Images {

            @SerializedName("original_mp4")
            @Expose
            private OriginalMp4 originalMp4;
            @SerializedName("preview_gif")
            @Expose
            private PreviewGif previewGif;
            @SerializedName("480w_still")
            @Expose
            private _480wStill _480wStill;

            public OriginalMp4 getOriginalMp4() {
                return originalMp4;
            }

            public void setOriginalMp4(OriginalMp4 originalMp4) {
                this.originalMp4 = originalMp4;
            }

            public PreviewGif getPreviewGif() {
                return previewGif;
            }

            public void setPreviewGif(PreviewGif previewGif) {
                this.previewGif = previewGif;
            }

            public _480wStill get480wStill() {
                return _480wStill;
            }

            public void set480wStill(_480wStill _480wStill) {
                this._480wStill = _480wStill;
            }

            public static class _480wStill {

                @SerializedName("url")
                @Expose
                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

            }

            public static class PreviewGif {

                @SerializedName("url")
                @Expose
                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

            }

            public class OriginalMp4 {

                @SerializedName("mp4")
                @Expose
                private String mp4;

                public String getMp4() {
                    return mp4;
                }

                public void setMp4(String mp4) {
                    this.mp4 = mp4;
                }

            }

        }

    }

}
