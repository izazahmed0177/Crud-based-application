package com.example.codeware2.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;



public class Users {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("support")
    @Expose
    private Support support;

    /**
     * No args constructor for use in serialization
     *
     */
    public Users() {
    }

    /**
     *
     * @param total
     * @param perPage
     * @param data
     * @param totalPages
     * @param page
     * @param support
     */
    public Users(Integer page, Integer perPage, Integer total, Integer totalPages, List<Datum> data, Support support) {
        super();
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
        this.support = support;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Users withPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Users withPerPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Users withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Users withTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Users withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public Users withSupport(Support support) {
        this.support = support;
        return this;
    }


    public class Support {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("text")
        @Expose
        private String text;

        /**
         * No args constructor for use in serialization
         *
         */
        public Support() {
        }

        /**
         *
         * @param text
         * @param url
         */
        public Support(String url, String text) {
            super();
            this.url = url;
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Support withUrl(String url) {
            this.url = url;
            return this;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Support withText(String text) {
            this.text = text;
            return this;
        }

    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("avatar")
        @Expose
        private String avatar;

        /**
         * No args constructor for use in serialization
         *
         */
        public Datum() {
        }

        /**
         *
         * @param firstName
         * @param lastName
         * @param id
         * @param avatar
         * @param email
         */
        public Datum(Integer id, String email, String firstName, String lastName, String avatar) {
            super();
            this.id = id;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.avatar = avatar;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Datum withId(Integer id) {
            this.id = id;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Datum withEmail(String email) {
            this.email = email;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Datum withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Datum withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Datum withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

    }

}