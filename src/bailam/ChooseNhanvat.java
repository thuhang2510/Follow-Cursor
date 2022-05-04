package bailam;

public class ChooseNhanvat {
    NhanVat nv;
    
    public int slSprite() {
        return 3;
    }
    
    public NhanVat luaChon(int lc) {
        if(lc == 1)
            nv = new Sprite1();
        else if(lc == 2)
            nv = new Sprite2();
        else if(lc == 3)
            nv = new Sprite3();

        return nv;
    }
    
}
