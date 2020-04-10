package sortingassignment.models;

import java.util.Random;

public class Tshirt {

    private String name;
    private double price;
    private Size size;
    private Color color;
    private Fabric fabric;
    private static String [] names;
    
    
    static{//static block
        names = new String []{"Aloha", "Baseball", "Camp",
            "Epaulette", "Lumberjack", "Granddad", "Golf",
            "Henley", "Polo", "Tuxedo", "Tunic", "Sweatshirt"};
    }

    public Tshirt(String name, double price, Size size, Color color, Fabric fabric) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.fabric = fabric;
    }

    public Tshirt() {
        this.name = randomName();
        this.size = randomSize();
        this.color = randomColor();
        this.fabric = randomFabric();
        this.price = generatePrice(size.ordinal(), color.ordinal(), fabric.ordinal());
    }

    
    
    public double generatePrice(int size, int color, int fabric){
        String temp = "" + size + color + fabric;
        double timi = Double.parseDouble(temp);
        return timi;
    }
    
    
    public String randomName() {
        Random random = new Random();
        random.nextInt(5);
       
        int randomNumber = random.nextInt(names.length);
        return names[randomNumber];
    }
    
    public Size randomSize() {
        Random random = new Random();
        random.nextInt(5);
        Size[] sizes = Size.values();
        int randomNumber = random.nextInt(sizes.length);
        return sizes[randomNumber];
    }

    public Color randomColor() {
        Random random = new Random();
        random.nextInt(5);
        Color[] colors = Color.values();
        int randomNumber = random.nextInt(colors.length);
        return colors[randomNumber];
    }

    public Fabric randomFabric() {
        Random random = new Random();
        random.nextInt(5);
        Fabric[] fabrics = Fabric.values();
        int randomNumber = random.nextInt(fabrics.length);
        return fabrics[randomNumber];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "Tshirt{" + "name=" + name + ", price=" + price + ", size=" + size + ", color=" + color + ", fabric=" + fabric + '}';
    }

}
