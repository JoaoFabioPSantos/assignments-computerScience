public class LightBulb{
    
    private String _color;
    private String _brand;
    private String _type;
    
    private int _watts;
    private int _guaranteeTime;

    private double _price;
    
    private boolean _status;
    
    //Poderia ser criado só os Sets, por serem atributos "Read Only"
    
    public void setColor(String _color){
        this._color = _color;
    }
    
    public void turnOn(){
        _status = true;
        System.out.println("#Lâmpada Ligada 🔆#");
    }
    
    public void turnOff(){
        _status = false;
        System.out.println("#Lâmpada Desligada 🔅#");
    }
    
}