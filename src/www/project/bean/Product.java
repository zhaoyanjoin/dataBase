package www.project.bean;

public class Product {
    private int pro_id;
    private String pro_name;
    private String pro_num;
    private double market_price;
    private double shop_price;
    private String pro_color;
    private int pro_total_count;
    private String pro_max_img;
    private String pro_min_img;
    private int pro_state;

    public Product() {
    }

    public Product(int pro_id, String pro_name, String pro_num, double market_price, double shop_price, String pro_color, int pro_total_count, String pro_max_img, String pro_min_img, int pro_state) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_num = pro_num;
        this.market_price = market_price;
        this.shop_price = shop_price;
        this.pro_color = pro_color;
        this.pro_total_count = pro_total_count;
        this.pro_max_img = pro_max_img;
        this.pro_min_img = pro_min_img;
        this.pro_state = pro_state;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", pro_num='" + pro_num + '\'' +
                ", market_price=" + market_price +
                ", shop_price=" + shop_price +
                ", pro_color='" + pro_color + '\'' +
                ", pro_total_count=" + pro_total_count +
                ", pro_max_img='" + pro_max_img + '\'' +
                ", pro_min_img='" + pro_min_img + '\'' +
                ", pro_state=" + pro_state +
                '}';
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public void setPro_num(String pro_num) {
        this.pro_num = pro_num;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public void setPro_color(String pro_color) {
        this.pro_color = pro_color;
    }

    public void setPro_total_count(int pro_total_count) {
        this.pro_total_count = pro_total_count;
    }

    public void setPro_max_img(String pro_max_img) {
        this.pro_max_img = pro_max_img;
    }

    public void setPro_min_img(String pro_min_img) {
        this.pro_min_img = pro_min_img;
    }

    public void setPro_state(int pro_state) {
        this.pro_state = pro_state;
    }

    public int getPro_id() {
        return pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public String getPro_num() {
        return pro_num;
    }

    public double getMarket_price() {
        return market_price;
    }

    public double getShop_price() {
        return shop_price;
    }

    public String getPro_color() {
        return pro_color;
    }

    public int getPro_total_count() {
        return pro_total_count;
    }

    public String getPro_max_img() {
        return pro_max_img;
    }

    public String getPro_min_img() {
        return pro_min_img;
    }

    public int getPro_state() {
        return pro_state;
    }
}
