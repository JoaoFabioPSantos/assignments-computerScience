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
    
    public void setBrand(String _brand){
        this._brand = _brand;
    }
    
     public void setType(String _type){
        this._type = _type;
    }
    
    public void setModel(String _model){
        this._model = _model;
    }
    
    public void setWatss(int _watts){
        this._watts = _watts;
    }
    
    public void setGuaranteeTime(int _guaranteeTime){
        this._guaranteeTime = _guaranteeTime;
    }
    
    public void setPrice(double _price){
        this._price = _price;
    }
    
    public void setStatus(String _statusBulb){
        if(_statusBulb == "Ligada"){
            _status = true;
        }else if(_statusBulb == "Desligada"){
            _status = false;
        }
    }
    
    
    public void turnOn(){
        _status = true;
        System.out.println("#Lâmpada Ligada 🔆#");
    }
    
    public void turnOff(){
        _status = false;
        System.out.println("#Lâmpada Desligada 🔅#");
    }
    
    public void switchMode(){
        if(!_status){
            setStatus("Ligada");
            System.out.println("#Lâmpada Ligada 🔆#");
        }else{
            setStatus("Desligada");
            System.out.println("#Lâmpada Desligada 🔅#");
        }
        
    }
    
}
