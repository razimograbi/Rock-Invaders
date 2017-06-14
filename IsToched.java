public class IsToched {
    float x,y;
    int width , height;
    public IsToched(float x ,float y , int width , int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public void move(float x , float y ){
        this.x = x;
        this.y = y;
    }
    public boolean CollidesWith (IsToched toched){
        return x < toched.x + toched.width && y < toched.y + toched.height && x + width > toched.x && y + height > toched.y;
    }
}
