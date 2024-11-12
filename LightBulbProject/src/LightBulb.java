public class LightBulb{
    
    private String _color;
    private String _brand;
    private String _type;
    private String _model;
    
    private int _watts;
    private int _guaranteeTime;

    private double _price;
    
    private String _statusBulb;
    private boolean _status;
    
    public void setColor(String _color){
        this._color = _color;
    }
    public String getColor(){
        return _color;
    }
    
    public void setBrand(String _brand){
        this._brand = _brand;
    }
    public String getBrand(){
        return _brand;
    }
    
    public void setType(String _type){
        this._type = _type;
    }
    public String getType(){
        return _type;
    }
    
    public void setModel(String _model){
        this._model = _model;
    }
    public String getModel(){
        return _model;
    }
    
    public void setWatss(int _watts){
        this._watts = _watts;
    }
    public int getWatss(){
        return _watts;
    }
    
    public void setGuaranteeTime(int _guaranteeTime){
        this._guaranteeTime = _guaranteeTime;
    }
    public int getGuaranteeTime(){
        return _guaranteeTime;
    }
    
    public void setPrice(double _price){
        this._price = _price;
    }
    public double getPrice(){
        return _price;
    }
    
    public void setStatus(String _statusBulb){
        this._statusBulb = _statusBulb;
        
        if(_statusBulb == "Ligada"){
            _status = true;
        }else if(_statusBulb == "Desligada"){
            _status = false;
        }
    }
    public String getStatus(){
        return _statusBulb;
    }
    
    
    public void turnOn(){
        System.out.println("#Lâmpada Ligada 🔆#");
        setStatus("Ligada");
    }
    public void turnOff(){
        System.out.println("#Lâmpada Desligada 🔅#");
        setStatus("Desligada");
    }
    
    
    public void switchMode(){
        if(!_status){
            System.out.println("#Lâmpada Ligada 🔆#");
            setStatus("Ligada");
        }else if(_status){
            System.out.println("#Lâmpada Desligada 🔅#");
            setStatus("Desligada");
        }
        
    }
    
}
