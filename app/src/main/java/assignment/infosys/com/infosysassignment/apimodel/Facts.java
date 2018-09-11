package assignment.infosys.com.infosysassignment.apimodel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

public class Facts {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private List<Data> data = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }


    public static class Data {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("imageHref")
        @Expose
        private String imageHref;

        public Data(String title, String description, String imageHref) {
            this.title = title;
            this.description = description;
            this.imageHref = imageHref;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageHref() {
            return imageHref;
        }

        public void setImageHref(String imageHref) {
            this.imageHref = imageHref;
        }

    }
}
