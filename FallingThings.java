public class FallingThings {
    public static final float width = 16;
    public static final float height = 16;
    public static final int Width = 32;
    public static final int Hieght = 32;
    public static  int SpeedFallingThings = 250;
    public boolean remove  = false;
    float x , y;
    IsToched toched;
    private static Texture texture;

    public FallingThings(float x){
        this.x = x;
        SpeedFallingThings = 250;
        this.toched = new IsToched(x , y , Width , Hieght);
        this.y = MyGame2.HEIGHT;
        if (texture == null){
            texture = new Texture("asteroid22.png");
        }

    }
    public void update(float deltatime){
        y-=SpeedFallingThings*deltatime;
        if (y< -height){
            remove = true;
        }
        toched.move(x, y);
    }
    public void render (SpriteBatch batch){
        batch.draw(texture , x , y , width , height);
    }

    public IsToched getToched (){
        return toched;
    }
}
